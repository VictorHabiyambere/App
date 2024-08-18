package io.grpc.util;

import com.google.common.base.Preconditions;
import com.google.common.collect.ForwardingMap;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import io.grpc.Attributes;
import io.grpc.ChannelLogger;
import io.grpc.ClientStreamTracer;
import io.grpc.ConnectivityState;
import io.grpc.ConnectivityStateInfo;
import io.grpc.EquivalentAddressGroup;
import io.grpc.LoadBalancer;
import io.grpc.Metadata;
import io.grpc.Status;
import io.grpc.SynchronizationContext;
import io.grpc.internal.ServiceConfigUtil;
import io.grpc.internal.TimeProvider;
import java.net.SocketAddress;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import javax.annotation.Nullable;

public final class OutlierDetectionLoadBalancer extends LoadBalancer {
    /* access modifiers changed from: private */
    public static final Attributes.Key<AddressTracker> ADDRESS_TRACKER_ATTR_KEY = Attributes.Key.create("addressTrackerKey");
    private final LoadBalancer.Helper childHelper;
    private SynchronizationContext.ScheduledHandle detectionTimerHandle;
    /* access modifiers changed from: private */
    public Long detectionTimerStartNanos;
    private final ChannelLogger logger;
    private final GracefulSwitchLoadBalancer switchLb = new GracefulSwitchLoadBalancer(this.childHelper);
    private final SynchronizationContext syncContext;
    /* access modifiers changed from: private */
    public TimeProvider timeProvider;
    private final ScheduledExecutorService timeService;
    final AddressTrackerMap trackerMap = new AddressTrackerMap();

    public OutlierDetectionLoadBalancer(LoadBalancer.Helper helper, TimeProvider timeProvider2) {
        this.logger = helper.getChannelLogger();
        this.childHelper = new ChildHelper((LoadBalancer.Helper) Preconditions.checkNotNull(helper, "helper"));
        this.syncContext = (SynchronizationContext) Preconditions.checkNotNull(helper.getSynchronizationContext(), "syncContext");
        this.timeService = (ScheduledExecutorService) Preconditions.checkNotNull(helper.getScheduledExecutorService(), "timeService");
        this.timeProvider = timeProvider2;
        this.logger.log(ChannelLogger.ChannelLogLevel.DEBUG, "OutlierDetection lb created.");
    }

    public boolean acceptResolvedAddresses(LoadBalancer.ResolvedAddresses resolvedAddresses) {
        Long initialDelayNanos;
        this.logger.log(ChannelLogger.ChannelLogLevel.DEBUG, "Received resolution result: {0}", resolvedAddresses);
        OutlierDetectionLoadBalancerConfig config = (OutlierDetectionLoadBalancerConfig) resolvedAddresses.getLoadBalancingPolicyConfig();
        ArrayList<SocketAddress> addresses = new ArrayList<>();
        for (EquivalentAddressGroup addressGroup : resolvedAddresses.getAddresses()) {
            addresses.addAll(addressGroup.getAddresses());
        }
        this.trackerMap.keySet().retainAll(addresses);
        this.trackerMap.updateTrackerConfigs(config);
        this.trackerMap.putNewTrackers(config, addresses);
        this.switchLb.switchTo(config.childPolicy.getProvider());
        if (config.outlierDetectionEnabled()) {
            if (this.detectionTimerStartNanos == null) {
                initialDelayNanos = config.intervalNanos;
            } else {
                initialDelayNanos = Long.valueOf(Math.max(0, config.intervalNanos.longValue() - (this.timeProvider.currentTimeNanos() - this.detectionTimerStartNanos.longValue())));
            }
            if (this.detectionTimerHandle != null) {
                this.detectionTimerHandle.cancel();
                this.trackerMap.resetCallCounters();
            }
            this.detectionTimerHandle = this.syncContext.scheduleWithFixedDelay(new DetectionTimer(config, this.logger), initialDelayNanos.longValue(), config.intervalNanos.longValue(), TimeUnit.NANOSECONDS, this.timeService);
        } else if (this.detectionTimerHandle != null) {
            this.detectionTimerHandle.cancel();
            this.detectionTimerStartNanos = null;
            this.trackerMap.cancelTracking();
        }
        this.switchLb.handleResolvedAddresses(resolvedAddresses.toBuilder().setLoadBalancingPolicyConfig(config.childPolicy.getConfig()).build());
        return true;
    }

    public void handleNameResolutionError(Status error) {
        this.switchLb.handleNameResolutionError(error);
    }

    public void shutdown() {
        this.switchLb.shutdown();
    }

    class DetectionTimer implements Runnable {
        OutlierDetectionLoadBalancerConfig config;
        ChannelLogger logger;

        DetectionTimer(OutlierDetectionLoadBalancerConfig config2, ChannelLogger logger2) {
            this.config = config2;
            this.logger = logger2;
        }

        public void run() {
            Long unused = OutlierDetectionLoadBalancer.this.detectionTimerStartNanos = Long.valueOf(OutlierDetectionLoadBalancer.this.timeProvider.currentTimeNanos());
            OutlierDetectionLoadBalancer.this.trackerMap.swapCounters();
            for (OutlierEjectionAlgorithm algo : OutlierEjectionAlgorithm.forConfig(this.config, this.logger)) {
                algo.ejectOutliers(OutlierDetectionLoadBalancer.this.trackerMap, OutlierDetectionLoadBalancer.this.detectionTimerStartNanos.longValue());
            }
            OutlierDetectionLoadBalancer.this.trackerMap.maybeUnejectOutliers(OutlierDetectionLoadBalancer.this.detectionTimerStartNanos);
        }
    }

    class ChildHelper extends ForwardingLoadBalancerHelper {
        private LoadBalancer.Helper delegate;

        ChildHelper(LoadBalancer.Helper delegate2) {
            this.delegate = delegate2;
        }

        /* access modifiers changed from: protected */
        public LoadBalancer.Helper delegate() {
            return this.delegate;
        }

        public LoadBalancer.Subchannel createSubchannel(LoadBalancer.CreateSubchannelArgs args) {
            OutlierDetectionSubchannel subchannel = new OutlierDetectionSubchannel(this.delegate.createSubchannel(args));
            List<EquivalentAddressGroup> addressGroups = args.getAddresses();
            if (OutlierDetectionLoadBalancer.hasSingleAddress(addressGroups) && OutlierDetectionLoadBalancer.this.trackerMap.containsKey(addressGroups.get(0).getAddresses().get(0))) {
                AddressTracker tracker = (AddressTracker) OutlierDetectionLoadBalancer.this.trackerMap.get(addressGroups.get(0).getAddresses().get(0));
                tracker.addSubchannel(subchannel);
                if (tracker.ejectionTimeNanos != null) {
                    subchannel.eject();
                }
            }
            return subchannel;
        }

        public void updateBalancingState(ConnectivityState newState, LoadBalancer.SubchannelPicker newPicker) {
            this.delegate.updateBalancingState(newState, new OutlierDetectionPicker(newPicker));
        }
    }

    class OutlierDetectionSubchannel extends ForwardingSubchannel {
        private AddressTracker addressTracker;
        private final LoadBalancer.Subchannel delegate;
        /* access modifiers changed from: private */
        public boolean ejected;
        /* access modifiers changed from: private */
        public ConnectivityStateInfo lastSubchannelState;
        private final ChannelLogger logger;
        private LoadBalancer.SubchannelStateListener subchannelStateListener;

        OutlierDetectionSubchannel(LoadBalancer.Subchannel delegate2) {
            this.delegate = delegate2;
            this.logger = delegate2.getChannelLogger();
        }

        public void start(LoadBalancer.SubchannelStateListener listener) {
            this.subchannelStateListener = listener;
            super.start(new OutlierDetectionSubchannelStateListener(listener));
        }

        public Attributes getAttributes() {
            if (this.addressTracker != null) {
                return this.delegate.getAttributes().toBuilder().set(OutlierDetectionLoadBalancer.ADDRESS_TRACKER_ATTR_KEY, this.addressTracker).build();
            }
            return this.delegate.getAttributes();
        }

        public void updateAddresses(List<EquivalentAddressGroup> addressGroups) {
            if (OutlierDetectionLoadBalancer.hasSingleAddress(getAllAddresses()) && OutlierDetectionLoadBalancer.hasSingleAddress(addressGroups)) {
                if (OutlierDetectionLoadBalancer.this.trackerMap.containsValue(this.addressTracker)) {
                    this.addressTracker.removeSubchannel(this);
                }
                SocketAddress address = addressGroups.get(0).getAddresses().get(0);
                if (OutlierDetectionLoadBalancer.this.trackerMap.containsKey(address)) {
                    ((AddressTracker) OutlierDetectionLoadBalancer.this.trackerMap.get(address)).addSubchannel(this);
                }
            } else if (!OutlierDetectionLoadBalancer.hasSingleAddress(getAllAddresses()) || OutlierDetectionLoadBalancer.hasSingleAddress(addressGroups)) {
                if (!OutlierDetectionLoadBalancer.hasSingleAddress(getAllAddresses()) && OutlierDetectionLoadBalancer.hasSingleAddress(addressGroups)) {
                    SocketAddress address2 = addressGroups.get(0).getAddresses().get(0);
                    if (OutlierDetectionLoadBalancer.this.trackerMap.containsKey(address2)) {
                        ((AddressTracker) OutlierDetectionLoadBalancer.this.trackerMap.get(address2)).addSubchannel(this);
                    }
                }
            } else if (OutlierDetectionLoadBalancer.this.trackerMap.containsKey(getAddresses().getAddresses().get(0))) {
                AddressTracker tracker = (AddressTracker) OutlierDetectionLoadBalancer.this.trackerMap.get(getAddresses().getAddresses().get(0));
                tracker.removeSubchannel(this);
                tracker.resetCallCounters();
            }
            this.delegate.updateAddresses(addressGroups);
        }

        /* access modifiers changed from: package-private */
        public void setAddressTracker(AddressTracker addressTracker2) {
            this.addressTracker = addressTracker2;
        }

        /* access modifiers changed from: package-private */
        public void clearAddressTracker() {
            this.addressTracker = null;
        }

        /* access modifiers changed from: package-private */
        public void eject() {
            this.ejected = true;
            this.subchannelStateListener.onSubchannelState(ConnectivityStateInfo.forTransientFailure(Status.UNAVAILABLE));
            this.logger.log(ChannelLogger.ChannelLogLevel.INFO, "Subchannel ejected: {0}", this);
        }

        /* access modifiers changed from: package-private */
        public void uneject() {
            this.ejected = false;
            if (this.lastSubchannelState != null) {
                this.subchannelStateListener.onSubchannelState(this.lastSubchannelState);
                this.logger.log(ChannelLogger.ChannelLogLevel.INFO, "Subchannel unejected: {0}", this);
            }
        }

        /* access modifiers changed from: package-private */
        public boolean isEjected() {
            return this.ejected;
        }

        /* access modifiers changed from: protected */
        public LoadBalancer.Subchannel delegate() {
            return this.delegate;
        }

        class OutlierDetectionSubchannelStateListener implements LoadBalancer.SubchannelStateListener {
            private final LoadBalancer.SubchannelStateListener delegate;

            OutlierDetectionSubchannelStateListener(LoadBalancer.SubchannelStateListener delegate2) {
                this.delegate = delegate2;
            }

            public void onSubchannelState(ConnectivityStateInfo newState) {
                ConnectivityStateInfo unused = OutlierDetectionSubchannel.this.lastSubchannelState = newState;
                if (!OutlierDetectionSubchannel.this.ejected) {
                    this.delegate.onSubchannelState(newState);
                }
            }
        }

        public String toString() {
            return "OutlierDetectionSubchannel{addresses=" + this.delegate.getAllAddresses() + '}';
        }
    }

    class OutlierDetectionPicker extends LoadBalancer.SubchannelPicker {
        private final LoadBalancer.SubchannelPicker delegate;

        OutlierDetectionPicker(LoadBalancer.SubchannelPicker delegate2) {
            this.delegate = delegate2;
        }

        public LoadBalancer.PickResult pickSubchannel(LoadBalancer.PickSubchannelArgs args) {
            LoadBalancer.PickResult pickResult = this.delegate.pickSubchannel(args);
            LoadBalancer.Subchannel subchannel = pickResult.getSubchannel();
            if (subchannel != null) {
                return LoadBalancer.PickResult.withSubchannel(subchannel, new ResultCountingClientStreamTracerFactory((AddressTracker) subchannel.getAttributes().get(OutlierDetectionLoadBalancer.ADDRESS_TRACKER_ATTR_KEY), pickResult.getStreamTracerFactory()));
            }
            return pickResult;
        }

        class ResultCountingClientStreamTracerFactory extends ClientStreamTracer.Factory {
            @Nullable
            private final ClientStreamTracer.Factory delegateFactory;
            /* access modifiers changed from: private */
            public final AddressTracker tracker;

            ResultCountingClientStreamTracerFactory(AddressTracker tracker2, @Nullable ClientStreamTracer.Factory delegateFactory2) {
                this.tracker = tracker2;
                this.delegateFactory = delegateFactory2;
            }

            public ClientStreamTracer newClientStreamTracer(ClientStreamTracer.StreamInfo info, Metadata headers) {
                if (this.delegateFactory == null) {
                    return new ClientStreamTracer() {
                        public void streamClosed(Status status) {
                            ResultCountingClientStreamTracerFactory.this.tracker.incrementCallCount(status.isOk());
                        }
                    };
                }
                final ClientStreamTracer delegateTracer = this.delegateFactory.newClientStreamTracer(info, headers);
                return new ForwardingClientStreamTracer() {
                    /* access modifiers changed from: protected */
                    public ClientStreamTracer delegate() {
                        return delegateTracer;
                    }

                    public void streamClosed(Status status) {
                        ResultCountingClientStreamTracerFactory.this.tracker.incrementCallCount(status.isOk());
                        delegate().streamClosed(status);
                    }
                };
            }
        }
    }

    static class AddressTracker {
        private volatile CallCounter activeCallCounter = new CallCounter();
        private OutlierDetectionLoadBalancerConfig config;
        private int ejectionTimeMultiplier;
        /* access modifiers changed from: private */
        public Long ejectionTimeNanos;
        private CallCounter inactiveCallCounter = new CallCounter();
        private final Set<OutlierDetectionSubchannel> subchannels = new HashSet();

        AddressTracker(OutlierDetectionLoadBalancerConfig config2) {
            this.config = config2;
        }

        /* access modifiers changed from: package-private */
        public void setConfig(OutlierDetectionLoadBalancerConfig config2) {
            this.config = config2;
        }

        /* access modifiers changed from: package-private */
        public boolean addSubchannel(OutlierDetectionSubchannel subchannel) {
            if (subchannelsEjected() && !subchannel.isEjected()) {
                subchannel.eject();
            } else if (!subchannelsEjected() && subchannel.isEjected()) {
                subchannel.uneject();
            }
            subchannel.setAddressTracker(this);
            return this.subchannels.add(subchannel);
        }

        /* access modifiers changed from: package-private */
        public boolean removeSubchannel(OutlierDetectionSubchannel subchannel) {
            subchannel.clearAddressTracker();
            return this.subchannels.remove(subchannel);
        }

        /* access modifiers changed from: package-private */
        public boolean containsSubchannel(OutlierDetectionSubchannel subchannel) {
            return this.subchannels.contains(subchannel);
        }

        /* access modifiers changed from: package-private */
        public Set<OutlierDetectionSubchannel> getSubchannels() {
            return ImmutableSet.copyOf(this.subchannels);
        }

        /* access modifiers changed from: package-private */
        public void incrementCallCount(boolean success) {
            if (this.config.successRateEjection != null || this.config.failurePercentageEjection != null) {
                if (success) {
                    this.activeCallCounter.successCount.getAndIncrement();
                } else {
                    this.activeCallCounter.failureCount.getAndIncrement();
                }
            }
        }

        /* access modifiers changed from: package-private */
        public long activeVolume() {
            return this.activeCallCounter.successCount.get() + this.activeCallCounter.failureCount.get();
        }

        /* access modifiers changed from: package-private */
        public long inactiveVolume() {
            return this.inactiveCallCounter.successCount.get() + this.inactiveCallCounter.failureCount.get();
        }

        /* access modifiers changed from: package-private */
        public double successRate() {
            return ((double) this.inactiveCallCounter.successCount.get()) / ((double) inactiveVolume());
        }

        /* access modifiers changed from: package-private */
        public double failureRate() {
            return ((double) this.inactiveCallCounter.failureCount.get()) / ((double) inactiveVolume());
        }

        /* access modifiers changed from: package-private */
        public void resetCallCounters() {
            this.activeCallCounter.reset();
            this.inactiveCallCounter.reset();
        }

        /* access modifiers changed from: package-private */
        public void decrementEjectionTimeMultiplier() {
            this.ejectionTimeMultiplier = this.ejectionTimeMultiplier == 0 ? 0 : this.ejectionTimeMultiplier - 1;
        }

        /* access modifiers changed from: package-private */
        public void resetEjectionTimeMultiplier() {
            this.ejectionTimeMultiplier = 0;
        }

        /* access modifiers changed from: package-private */
        public void swapCounters() {
            this.inactiveCallCounter.reset();
            CallCounter tempCounter = this.activeCallCounter;
            this.activeCallCounter = this.inactiveCallCounter;
            this.inactiveCallCounter = tempCounter;
        }

        /* access modifiers changed from: package-private */
        public void ejectSubchannels(long ejectionTimeNanos2) {
            this.ejectionTimeNanos = Long.valueOf(ejectionTimeNanos2);
            this.ejectionTimeMultiplier++;
            for (OutlierDetectionSubchannel subchannel : this.subchannels) {
                subchannel.eject();
            }
        }

        /* access modifiers changed from: package-private */
        public void unejectSubchannels() {
            Preconditions.checkState(this.ejectionTimeNanos != null, "not currently ejected");
            this.ejectionTimeNanos = null;
            for (OutlierDetectionSubchannel subchannel : this.subchannels) {
                subchannel.uneject();
            }
        }

        /* access modifiers changed from: package-private */
        public boolean subchannelsEjected() {
            return this.ejectionTimeNanos != null;
        }

        public boolean maxEjectionTimeElapsed(long currentTimeNanos) {
            return currentTimeNanos > this.ejectionTimeNanos.longValue() + Math.min(this.config.baseEjectionTimeNanos.longValue() * ((long) this.ejectionTimeMultiplier), Math.max(this.config.baseEjectionTimeNanos.longValue(), this.config.maxEjectionTimeNanos.longValue()));
        }

        private static class CallCounter {
            AtomicLong failureCount;
            AtomicLong successCount;

            private CallCounter() {
                this.successCount = new AtomicLong();
                this.failureCount = new AtomicLong();
            }

            /* access modifiers changed from: package-private */
            public void reset() {
                this.successCount.set(0);
                this.failureCount.set(0);
            }
        }

        public String toString() {
            return "AddressTracker{subchannels=" + this.subchannels + '}';
        }
    }

    static class AddressTrackerMap extends ForwardingMap<SocketAddress, AddressTracker> {
        private final Map<SocketAddress, AddressTracker> trackerMap = new HashMap();

        AddressTrackerMap() {
        }

        /* access modifiers changed from: protected */
        public Map<SocketAddress, AddressTracker> delegate() {
            return this.trackerMap;
        }

        /* access modifiers changed from: package-private */
        public void updateTrackerConfigs(OutlierDetectionLoadBalancerConfig config) {
            for (AddressTracker tracker : this.trackerMap.values()) {
                tracker.setConfig(config);
            }
        }

        /* access modifiers changed from: package-private */
        public void putNewTrackers(OutlierDetectionLoadBalancerConfig config, Collection<SocketAddress> addresses) {
            for (SocketAddress address : addresses) {
                if (!this.trackerMap.containsKey(address)) {
                    this.trackerMap.put(address, new AddressTracker(config));
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void resetCallCounters() {
            for (AddressTracker tracker : this.trackerMap.values()) {
                tracker.resetCallCounters();
            }
        }

        /* access modifiers changed from: package-private */
        public void cancelTracking() {
            for (AddressTracker tracker : this.trackerMap.values()) {
                if (tracker.subchannelsEjected()) {
                    tracker.unejectSubchannels();
                }
                tracker.resetEjectionTimeMultiplier();
            }
        }

        /* access modifiers changed from: package-private */
        public void swapCounters() {
            for (AddressTracker tracker : this.trackerMap.values()) {
                tracker.swapCounters();
            }
        }

        /* access modifiers changed from: package-private */
        public void maybeUnejectOutliers(Long detectionTimerStartNanos) {
            for (AddressTracker tracker : this.trackerMap.values()) {
                if (!tracker.subchannelsEjected()) {
                    tracker.decrementEjectionTimeMultiplier();
                }
                if (tracker.subchannelsEjected() && tracker.maxEjectionTimeElapsed(detectionTimerStartNanos.longValue())) {
                    tracker.unejectSubchannels();
                }
            }
        }

        /* access modifiers changed from: package-private */
        public double ejectionPercentage() {
            if (this.trackerMap.isEmpty()) {
                return 0.0d;
            }
            int totalAddresses = 0;
            int ejectedAddresses = 0;
            for (AddressTracker tracker : this.trackerMap.values()) {
                totalAddresses++;
                if (tracker.subchannelsEjected()) {
                    ejectedAddresses++;
                }
            }
            return (((double) ejectedAddresses) / ((double) totalAddresses)) * 100.0d;
        }
    }

    interface OutlierEjectionAlgorithm {
        void ejectOutliers(AddressTrackerMap addressTrackerMap, long j);

        @Nullable
        static List<OutlierEjectionAlgorithm> forConfig(OutlierDetectionLoadBalancerConfig config, ChannelLogger logger) {
            ImmutableList.Builder<OutlierEjectionAlgorithm> algoListBuilder = ImmutableList.builder();
            if (config.successRateEjection != null) {
                algoListBuilder.add((Object) new SuccessRateOutlierEjectionAlgorithm(config, logger));
            }
            if (config.failurePercentageEjection != null) {
                algoListBuilder.add((Object) new FailurePercentageOutlierEjectionAlgorithm(config, logger));
            }
            return algoListBuilder.build();
        }
    }

    static class SuccessRateOutlierEjectionAlgorithm implements OutlierEjectionAlgorithm {
        private final OutlierDetectionLoadBalancerConfig config;
        private final ChannelLogger logger;

        SuccessRateOutlierEjectionAlgorithm(OutlierDetectionLoadBalancerConfig config2, ChannelLogger logger2) {
            Preconditions.checkArgument(config2.successRateEjection != null, "success rate ejection config is null");
            this.config = config2;
            this.logger = logger2;
        }

        public void ejectOutliers(AddressTrackerMap trackerMap, long ejectionTimeNanos) {
            List<AddressTracker> trackersWithVolume;
            List<AddressTracker> trackersWithVolume2 = OutlierDetectionLoadBalancer.trackersWithVolume(trackerMap, this.config.successRateEjection.requestVolume.intValue());
            if (trackersWithVolume2.size() < this.config.successRateEjection.minimumHosts.intValue()) {
                List<AddressTracker> list = trackersWithVolume2;
                long j = ejectionTimeNanos;
            } else if (trackersWithVolume2.size() == 0) {
                List<AddressTracker> list2 = trackersWithVolume2;
                long j2 = ejectionTimeNanos;
            } else {
                List<Double> successRates = new ArrayList<>();
                for (AddressTracker tracker : trackersWithVolume2) {
                    successRates.add(Double.valueOf(tracker.successRate()));
                }
                double mean = mean(successRates);
                double stdev = standardDeviation(successRates, mean);
                double requiredSuccessRate = mean - (((double) (((float) this.config.successRateEjection.stdevFactor.intValue()) / 1000.0f)) * stdev);
                for (AddressTracker tracker2 : trackersWithVolume2) {
                    if (trackerMap.ejectionPercentage() < ((double) this.config.maxEjectionPercent.intValue())) {
                        if (tracker2.successRate() < requiredSuccessRate) {
                            trackersWithVolume = trackersWithVolume2;
                            this.logger.log(ChannelLogger.ChannelLogLevel.DEBUG, "SuccessRate algorithm detected outlier: {0}. Parameters: successRate={1}, mean={2}, stdev={3}, requiredSuccessRate={4}", tracker2, Double.valueOf(tracker2.successRate()), Double.valueOf(mean), Double.valueOf(stdev), Double.valueOf(requiredSuccessRate));
                            if (new Random().nextInt(100) < this.config.successRateEjection.enforcementPercentage.intValue()) {
                                tracker2.ejectSubchannels(ejectionTimeNanos);
                            } else {
                                long j3 = ejectionTimeNanos;
                            }
                        } else {
                            trackersWithVolume = trackersWithVolume2;
                            long j4 = ejectionTimeNanos;
                        }
                        AddressTrackerMap addressTrackerMap = trackerMap;
                        trackersWithVolume2 = trackersWithVolume;
                    } else {
                        return;
                    }
                }
            }
        }

        static double mean(Collection<Double> values) {
            double totalValue = 0.0d;
            for (Double doubleValue : values) {
                totalValue += doubleValue.doubleValue();
            }
            return totalValue / ((double) values.size());
        }

        static double standardDeviation(Collection<Double> values, double mean) {
            double squaredDifferenceSum = 0.0d;
            for (Double doubleValue : values) {
                double difference = doubleValue.doubleValue() - mean;
                squaredDifferenceSum += difference * difference;
            }
            return Math.sqrt(squaredDifferenceSum / ((double) values.size()));
        }
    }

    static class FailurePercentageOutlierEjectionAlgorithm implements OutlierEjectionAlgorithm {
        private final OutlierDetectionLoadBalancerConfig config;
        private final ChannelLogger logger;

        FailurePercentageOutlierEjectionAlgorithm(OutlierDetectionLoadBalancerConfig config2, ChannelLogger logger2) {
            this.config = config2;
            this.logger = logger2;
        }

        public void ejectOutliers(AddressTrackerMap trackerMap, long ejectionTimeNanos) {
            List<AddressTracker> trackersWithVolume = OutlierDetectionLoadBalancer.trackersWithVolume(trackerMap, this.config.failurePercentageEjection.requestVolume.intValue());
            if (trackersWithVolume.size() >= this.config.failurePercentageEjection.minimumHosts.intValue() && trackersWithVolume.size() != 0) {
                for (AddressTracker tracker : trackersWithVolume) {
                    if (trackerMap.ejectionPercentage() < ((double) this.config.maxEjectionPercent.intValue())) {
                        if (tracker.inactiveVolume() >= ((long) this.config.failurePercentageEjection.requestVolume.intValue())) {
                            if (tracker.failureRate() > ((double) this.config.failurePercentageEjection.threshold.intValue()) / 100.0d) {
                                this.logger.log(ChannelLogger.ChannelLogLevel.DEBUG, "FailurePercentage algorithm detected outlier: {0}, failureRate={1}", tracker, Double.valueOf(tracker.failureRate()));
                                if (new Random().nextInt(100) < this.config.failurePercentageEjection.enforcementPercentage.intValue()) {
                                    tracker.ejectSubchannels(ejectionTimeNanos);
                                }
                            }
                        }
                    } else {
                        return;
                    }
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public static List<AddressTracker> trackersWithVolume(AddressTrackerMap trackerMap2, int volume) {
        List<AddressTracker> trackersWithVolume = new ArrayList<>();
        for (AddressTracker tracker : trackerMap2.values()) {
            if (tracker.inactiveVolume() >= ((long) volume)) {
                trackersWithVolume.add(tracker);
            }
        }
        return trackersWithVolume;
    }

    /* access modifiers changed from: private */
    public static boolean hasSingleAddress(List<EquivalentAddressGroup> addressGroups) {
        int addressCount = 0;
        for (EquivalentAddressGroup addressGroup : addressGroups) {
            addressCount += addressGroup.getAddresses().size();
            if (addressCount > 1) {
                return false;
            }
        }
        return true;
    }

    public static final class OutlierDetectionLoadBalancerConfig {
        public final Long baseEjectionTimeNanos;
        public final ServiceConfigUtil.PolicySelection childPolicy;
        public final FailurePercentageEjection failurePercentageEjection;
        public final Long intervalNanos;
        public final Integer maxEjectionPercent;
        public final Long maxEjectionTimeNanos;
        public final SuccessRateEjection successRateEjection;

        private OutlierDetectionLoadBalancerConfig(Long intervalNanos2, Long baseEjectionTimeNanos2, Long maxEjectionTimeNanos2, Integer maxEjectionPercent2, SuccessRateEjection successRateEjection2, FailurePercentageEjection failurePercentageEjection2, ServiceConfigUtil.PolicySelection childPolicy2) {
            this.intervalNanos = intervalNanos2;
            this.baseEjectionTimeNanos = baseEjectionTimeNanos2;
            this.maxEjectionTimeNanos = maxEjectionTimeNanos2;
            this.maxEjectionPercent = maxEjectionPercent2;
            this.successRateEjection = successRateEjection2;
            this.failurePercentageEjection = failurePercentageEjection2;
            this.childPolicy = childPolicy2;
        }

        public static class Builder {
            Long baseEjectionTimeNanos = 30000000000L;
            ServiceConfigUtil.PolicySelection childPolicy;
            FailurePercentageEjection failurePercentageEjection;
            Long intervalNanos = 10000000000L;
            Integer maxEjectionPercent = 10;
            Long maxEjectionTimeNanos = 300000000000L;
            SuccessRateEjection successRateEjection;

            public Builder setIntervalNanos(Long intervalNanos2) {
                Preconditions.checkArgument(intervalNanos2 != null);
                this.intervalNanos = intervalNanos2;
                return this;
            }

            public Builder setBaseEjectionTimeNanos(Long baseEjectionTimeNanos2) {
                Preconditions.checkArgument(baseEjectionTimeNanos2 != null);
                this.baseEjectionTimeNanos = baseEjectionTimeNanos2;
                return this;
            }

            public Builder setMaxEjectionTimeNanos(Long maxEjectionTimeNanos2) {
                Preconditions.checkArgument(maxEjectionTimeNanos2 != null);
                this.maxEjectionTimeNanos = maxEjectionTimeNanos2;
                return this;
            }

            public Builder setMaxEjectionPercent(Integer maxEjectionPercent2) {
                Preconditions.checkArgument(maxEjectionPercent2 != null);
                this.maxEjectionPercent = maxEjectionPercent2;
                return this;
            }

            public Builder setSuccessRateEjection(SuccessRateEjection successRateEjection2) {
                this.successRateEjection = successRateEjection2;
                return this;
            }

            public Builder setFailurePercentageEjection(FailurePercentageEjection failurePercentageEjection2) {
                this.failurePercentageEjection = failurePercentageEjection2;
                return this;
            }

            public Builder setChildPolicy(ServiceConfigUtil.PolicySelection childPolicy2) {
                Preconditions.checkState(childPolicy2 != null);
                this.childPolicy = childPolicy2;
                return this;
            }

            public OutlierDetectionLoadBalancerConfig build() {
                Preconditions.checkState(this.childPolicy != null);
                return new OutlierDetectionLoadBalancerConfig(this.intervalNanos, this.baseEjectionTimeNanos, this.maxEjectionTimeNanos, this.maxEjectionPercent, this.successRateEjection, this.failurePercentageEjection, this.childPolicy);
            }
        }

        public static class SuccessRateEjection {
            public final Integer enforcementPercentage;
            public final Integer minimumHosts;
            public final Integer requestVolume;
            public final Integer stdevFactor;

            SuccessRateEjection(Integer stdevFactor2, Integer enforcementPercentage2, Integer minimumHosts2, Integer requestVolume2) {
                this.stdevFactor = stdevFactor2;
                this.enforcementPercentage = enforcementPercentage2;
                this.minimumHosts = minimumHosts2;
                this.requestVolume = requestVolume2;
            }

            public static final class Builder {
                Integer enforcementPercentage = 100;
                Integer minimumHosts = 5;
                Integer requestVolume = 100;
                Integer stdevFactor = 1900;

                public Builder setStdevFactor(Integer stdevFactor2) {
                    Preconditions.checkArgument(stdevFactor2 != null);
                    this.stdevFactor = stdevFactor2;
                    return this;
                }

                public Builder setEnforcementPercentage(Integer enforcementPercentage2) {
                    boolean z = true;
                    Preconditions.checkArgument(enforcementPercentage2 != null);
                    if (enforcementPercentage2.intValue() < 0 || enforcementPercentage2.intValue() > 100) {
                        z = false;
                    }
                    Preconditions.checkArgument(z);
                    this.enforcementPercentage = enforcementPercentage2;
                    return this;
                }

                public Builder setMinimumHosts(Integer minimumHosts2) {
                    boolean z = true;
                    Preconditions.checkArgument(minimumHosts2 != null);
                    if (minimumHosts2.intValue() < 0) {
                        z = false;
                    }
                    Preconditions.checkArgument(z);
                    this.minimumHosts = minimumHosts2;
                    return this;
                }

                public Builder setRequestVolume(Integer requestVolume2) {
                    boolean z = true;
                    Preconditions.checkArgument(requestVolume2 != null);
                    if (requestVolume2.intValue() < 0) {
                        z = false;
                    }
                    Preconditions.checkArgument(z);
                    this.requestVolume = requestVolume2;
                    return this;
                }

                public SuccessRateEjection build() {
                    return new SuccessRateEjection(this.stdevFactor, this.enforcementPercentage, this.minimumHosts, this.requestVolume);
                }
            }
        }

        public static class FailurePercentageEjection {
            public final Integer enforcementPercentage;
            public final Integer minimumHosts;
            public final Integer requestVolume;
            public final Integer threshold;

            FailurePercentageEjection(Integer threshold2, Integer enforcementPercentage2, Integer minimumHosts2, Integer requestVolume2) {
                this.threshold = threshold2;
                this.enforcementPercentage = enforcementPercentage2;
                this.minimumHosts = minimumHosts2;
                this.requestVolume = requestVolume2;
            }

            public static class Builder {
                Integer enforcementPercentage = 100;
                Integer minimumHosts = 5;
                Integer requestVolume = 50;
                Integer threshold = 85;

                public Builder setThreshold(Integer threshold2) {
                    boolean z = true;
                    Preconditions.checkArgument(threshold2 != null);
                    if (threshold2.intValue() < 0 || threshold2.intValue() > 100) {
                        z = false;
                    }
                    Preconditions.checkArgument(z);
                    this.threshold = threshold2;
                    return this;
                }

                public Builder setEnforcementPercentage(Integer enforcementPercentage2) {
                    boolean z = true;
                    Preconditions.checkArgument(enforcementPercentage2 != null);
                    if (enforcementPercentage2.intValue() < 0 || enforcementPercentage2.intValue() > 100) {
                        z = false;
                    }
                    Preconditions.checkArgument(z);
                    this.enforcementPercentage = enforcementPercentage2;
                    return this;
                }

                public Builder setMinimumHosts(Integer minimumHosts2) {
                    boolean z = true;
                    Preconditions.checkArgument(minimumHosts2 != null);
                    if (minimumHosts2.intValue() < 0) {
                        z = false;
                    }
                    Preconditions.checkArgument(z);
                    this.minimumHosts = minimumHosts2;
                    return this;
                }

                public Builder setRequestVolume(Integer requestVolume2) {
                    boolean z = true;
                    Preconditions.checkArgument(requestVolume2 != null);
                    if (requestVolume2.intValue() < 0) {
                        z = false;
                    }
                    Preconditions.checkArgument(z);
                    this.requestVolume = requestVolume2;
                    return this;
                }

                public FailurePercentageEjection build() {
                    return new FailurePercentageEjection(this.threshold, this.enforcementPercentage, this.minimumHosts, this.requestVolume);
                }
            }
        }

        /* access modifiers changed from: package-private */
        public boolean outlierDetectionEnabled() {
            return (this.successRateEjection == null && this.failurePercentageEjection == null) ? false : true;
        }
    }
}
