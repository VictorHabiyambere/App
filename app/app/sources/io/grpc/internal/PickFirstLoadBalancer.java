package io.grpc.internal;

import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import io.grpc.ConnectivityState;
import io.grpc.ConnectivityStateInfo;
import io.grpc.EquivalentAddressGroup;
import io.grpc.LoadBalancer;
import io.grpc.Status;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.annotation.Nullable;

final class PickFirstLoadBalancer extends LoadBalancer {
    private ConnectivityState currentState = ConnectivityState.IDLE;
    /* access modifiers changed from: private */
    public final LoadBalancer.Helper helper;
    private LoadBalancer.Subchannel subchannel;

    PickFirstLoadBalancer(LoadBalancer.Helper helper2) {
        this.helper = (LoadBalancer.Helper) Preconditions.checkNotNull(helper2, "helper");
    }

    public boolean acceptResolvedAddresses(LoadBalancer.ResolvedAddresses resolvedAddresses) {
        List<EquivalentAddressGroup> servers = resolvedAddresses.getAddresses();
        if (servers.isEmpty()) {
            handleNameResolutionError(Status.UNAVAILABLE.withDescription("NameResolver returned no usable address. addrs=" + resolvedAddresses.getAddresses() + ", attrs=" + resolvedAddresses.getAttributes()));
            return false;
        }
        if (resolvedAddresses.getLoadBalancingPolicyConfig() instanceof PickFirstLoadBalancerConfig) {
            PickFirstLoadBalancerConfig config = (PickFirstLoadBalancerConfig) resolvedAddresses.getLoadBalancingPolicyConfig();
            if (config.shuffleAddressList != null && config.shuffleAddressList.booleanValue()) {
                servers = new ArrayList<>(servers);
                Collections.shuffle(servers, config.randomSeed != null ? new Random(config.randomSeed.longValue()) : new Random());
            }
        }
        if (this.subchannel == null) {
            final LoadBalancer.Subchannel subchannel2 = this.helper.createSubchannel(LoadBalancer.CreateSubchannelArgs.newBuilder().setAddresses(servers).build());
            subchannel2.start(new LoadBalancer.SubchannelStateListener() {
                public void onSubchannelState(ConnectivityStateInfo stateInfo) {
                    PickFirstLoadBalancer.this.processSubchannelState(subchannel2, stateInfo);
                }
            });
            this.subchannel = subchannel2;
            updateBalancingState(ConnectivityState.CONNECTING, new Picker(LoadBalancer.PickResult.withSubchannel(subchannel2)));
            subchannel2.requestConnection();
            return true;
        }
        this.subchannel.updateAddresses(servers);
        return true;
    }

    public void handleNameResolutionError(Status error) {
        if (this.subchannel != null) {
            this.subchannel.shutdown();
            this.subchannel = null;
        }
        updateBalancingState(ConnectivityState.TRANSIENT_FAILURE, new Picker(LoadBalancer.PickResult.withError(error)));
    }

    /* access modifiers changed from: private */
    public void processSubchannelState(LoadBalancer.Subchannel subchannel2, ConnectivityStateInfo stateInfo) {
        LoadBalancer.SubchannelPicker picker;
        ConnectivityState newState = stateInfo.getState();
        if (newState != ConnectivityState.SHUTDOWN) {
            if (newState == ConnectivityState.TRANSIENT_FAILURE || newState == ConnectivityState.IDLE) {
                this.helper.refreshNameResolution();
            }
            if (this.currentState == ConnectivityState.TRANSIENT_FAILURE) {
                if (newState != ConnectivityState.CONNECTING) {
                    if (newState == ConnectivityState.IDLE) {
                        requestConnection();
                        return;
                    }
                } else {
                    return;
                }
            }
            switch (newState) {
                case IDLE:
                    picker = new RequestConnectionPicker(subchannel2);
                    break;
                case CONNECTING:
                    picker = new Picker(LoadBalancer.PickResult.withNoResult());
                    break;
                case READY:
                    picker = new Picker(LoadBalancer.PickResult.withSubchannel(subchannel2));
                    break;
                case TRANSIENT_FAILURE:
                    picker = new Picker(LoadBalancer.PickResult.withError(stateInfo.getStatus()));
                    break;
                default:
                    throw new IllegalArgumentException("Unsupported state:" + newState);
            }
            updateBalancingState(newState, picker);
        }
    }

    private void updateBalancingState(ConnectivityState state, LoadBalancer.SubchannelPicker picker) {
        this.currentState = state;
        this.helper.updateBalancingState(state, picker);
    }

    public void shutdown() {
        if (this.subchannel != null) {
            this.subchannel.shutdown();
        }
    }

    public void requestConnection() {
        if (this.subchannel != null) {
            this.subchannel.requestConnection();
        }
    }

    private static final class Picker extends LoadBalancer.SubchannelPicker {
        private final LoadBalancer.PickResult result;

        Picker(LoadBalancer.PickResult result2) {
            this.result = (LoadBalancer.PickResult) Preconditions.checkNotNull(result2, "result");
        }

        public LoadBalancer.PickResult pickSubchannel(LoadBalancer.PickSubchannelArgs args) {
            return this.result;
        }

        public String toString() {
            return MoreObjects.toStringHelper((Class<?>) Picker.class).add("result", (Object) this.result).toString();
        }
    }

    private final class RequestConnectionPicker extends LoadBalancer.SubchannelPicker {
        private final AtomicBoolean connectionRequested = new AtomicBoolean(false);
        /* access modifiers changed from: private */
        public final LoadBalancer.Subchannel subchannel;

        RequestConnectionPicker(LoadBalancer.Subchannel subchannel2) {
            this.subchannel = (LoadBalancer.Subchannel) Preconditions.checkNotNull(subchannel2, "subchannel");
        }

        public LoadBalancer.PickResult pickSubchannel(LoadBalancer.PickSubchannelArgs args) {
            if (this.connectionRequested.compareAndSet(false, true)) {
                PickFirstLoadBalancer.this.helper.getSynchronizationContext().execute(new Runnable() {
                    public void run() {
                        RequestConnectionPicker.this.subchannel.requestConnection();
                    }
                });
            }
            return LoadBalancer.PickResult.withNoResult();
        }
    }

    public static final class PickFirstLoadBalancerConfig {
        @Nullable
        final Long randomSeed;
        @Nullable
        public final Boolean shuffleAddressList;

        public PickFirstLoadBalancerConfig(@Nullable Boolean shuffleAddressList2) {
            this(shuffleAddressList2, (Long) null);
        }

        PickFirstLoadBalancerConfig(@Nullable Boolean shuffleAddressList2, @Nullable Long randomSeed2) {
            this.shuffleAddressList = shuffleAddressList2;
            this.randomSeed = randomSeed2;
        }
    }
}
