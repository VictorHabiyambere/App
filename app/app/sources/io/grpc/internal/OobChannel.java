package io.grpc.internal;

import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.SettableFuture;
import io.grpc.Attributes;
import io.grpc.CallOptions;
import io.grpc.ClientCall;
import io.grpc.ClientStreamTracer;
import io.grpc.ConnectivityState;
import io.grpc.ConnectivityStateInfo;
import io.grpc.Context;
import io.grpc.EquivalentAddressGroup;
import io.grpc.InternalChannelz;
import io.grpc.InternalConfigSelector;
import io.grpc.InternalInstrumented;
import io.grpc.InternalLogId;
import io.grpc.LoadBalancer;
import io.grpc.ManagedChannel;
import io.grpc.Metadata;
import io.grpc.MethodDescriptor;
import io.grpc.Status;
import io.grpc.SynchronizationContext;
import io.grpc.internal.ClientCallImpl;
import io.grpc.internal.ManagedClientTransport;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

final class OobChannel extends ManagedChannel implements InternalInstrumented<InternalChannelz.ChannelStats> {
    private static final Logger log = Logger.getLogger(OobChannel.class.getName());
    private final String authority;
    private final CallTracer channelCallsTracer;
    private final ChannelTracer channelTracer;
    private final InternalChannelz channelz;
    private final ScheduledExecutorService deadlineCancellationExecutor;
    /* access modifiers changed from: private */
    public final DelayedClientTransport delayedTransport;
    private final Executor executor;
    private final ObjectPool<? extends Executor> executorPool;
    private final InternalLogId logId;
    private volatile boolean shutdown;
    private InternalSubchannel subchannel;
    /* access modifiers changed from: private */
    public AbstractSubchannel subchannelImpl;
    private LoadBalancer.SubchannelPicker subchannelPicker;
    private final CountDownLatch terminatedLatch = new CountDownLatch(1);
    private final TimeProvider timeProvider;
    private final ClientCallImpl.ClientStreamProvider transportProvider = new ClientCallImpl.ClientStreamProvider() {
        public ClientStream newStream(MethodDescriptor<?, ?> method, CallOptions callOptions, Metadata headers, Context context) {
            ClientStreamTracer[] tracers = GrpcUtil.getClientStreamTracers(callOptions, headers, 0, false);
            Context origContext = context.attach();
            try {
                return OobChannel.this.delayedTransport.newStream(method, headers, callOptions, tracers);
            } finally {
                context.detach(origContext);
            }
        }
    };

    OobChannel(String authority2, ObjectPool<? extends Executor> executorPool2, ScheduledExecutorService deadlineCancellationExecutor2, SynchronizationContext syncContext, CallTracer callsTracer, ChannelTracer channelTracer2, InternalChannelz channelz2, TimeProvider timeProvider2) {
        this.authority = (String) Preconditions.checkNotNull(authority2, "authority");
        this.logId = InternalLogId.allocate(getClass(), authority2);
        this.executorPool = (ObjectPool) Preconditions.checkNotNull(executorPool2, "executorPool");
        this.executor = (Executor) Preconditions.checkNotNull((Executor) executorPool2.getObject(), "executor");
        this.deadlineCancellationExecutor = (ScheduledExecutorService) Preconditions.checkNotNull(deadlineCancellationExecutor2, "deadlineCancellationExecutor");
        this.delayedTransport = new DelayedClientTransport(this.executor, syncContext);
        this.channelz = (InternalChannelz) Preconditions.checkNotNull(channelz2);
        this.delayedTransport.start(new ManagedClientTransport.Listener() {
            public void transportShutdown(Status s) {
            }

            public void transportTerminated() {
                OobChannel.this.subchannelImpl.shutdown();
            }

            public void transportReady() {
            }

            public void transportInUse(boolean inUse) {
            }
        });
        this.channelCallsTracer = callsTracer;
        this.channelTracer = (ChannelTracer) Preconditions.checkNotNull(channelTracer2, "channelTracer");
        this.timeProvider = (TimeProvider) Preconditions.checkNotNull(timeProvider2, "timeProvider");
    }

    /* access modifiers changed from: package-private */
    public void setSubchannel(final InternalSubchannel subchannel2) {
        log.log(Level.FINE, "[{0}] Created with [{1}]", new Object[]{this, subchannel2});
        this.subchannel = subchannel2;
        this.subchannelImpl = new AbstractSubchannel() {
            public void shutdown() {
                subchannel2.shutdown(Status.UNAVAILABLE.withDescription("OobChannel is shutdown"));
            }

            /* access modifiers changed from: package-private */
            public InternalInstrumented<InternalChannelz.ChannelStats> getInstrumentedInternalSubchannel() {
                return subchannel2;
            }

            public void requestConnection() {
                subchannel2.obtainActiveTransport();
            }

            public List<EquivalentAddressGroup> getAllAddresses() {
                return subchannel2.getAddressGroups();
            }

            public Attributes getAttributes() {
                return Attributes.EMPTY;
            }

            public Object getInternalSubchannel() {
                return subchannel2;
            }
        };
        this.subchannelPicker = new LoadBalancer.SubchannelPicker() {
            final LoadBalancer.PickResult result = LoadBalancer.PickResult.withSubchannel(OobChannel.this.subchannelImpl);

            public LoadBalancer.PickResult pickSubchannel(LoadBalancer.PickSubchannelArgs args) {
                return this.result;
            }

            public String toString() {
                return MoreObjects.toStringHelper((Class<?>) AnonymousClass1OobSubchannelPicker.class).add("result", (Object) this.result).toString();
            }
        };
        this.delayedTransport.reprocess(this.subchannelPicker);
    }

    /* access modifiers changed from: package-private */
    public void updateAddresses(List<EquivalentAddressGroup> eag) {
        this.subchannel.updateAddresses(eag);
    }

    public <RequestT, ResponseT> ClientCall<RequestT, ResponseT> newCall(MethodDescriptor<RequestT, ResponseT> methodDescriptor, CallOptions callOptions) {
        return new ClientCallImpl(methodDescriptor, callOptions.getExecutor() == null ? this.executor : callOptions.getExecutor(), callOptions, this.transportProvider, this.deadlineCancellationExecutor, this.channelCallsTracer, (InternalConfigSelector) null);
    }

    public String authority() {
        return this.authority;
    }

    public boolean isTerminated() {
        return this.terminatedLatch.getCount() == 0;
    }

    public boolean awaitTermination(long time, TimeUnit unit) throws InterruptedException {
        return this.terminatedLatch.await(time, unit);
    }

    public ConnectivityState getState(boolean requestConnectionIgnored) {
        if (this.subchannel == null) {
            return ConnectivityState.IDLE;
        }
        return this.subchannel.getState();
    }

    public ManagedChannel shutdown() {
        this.shutdown = true;
        this.delayedTransport.shutdown(Status.UNAVAILABLE.withDescription("OobChannel.shutdown() called"));
        return this;
    }

    public boolean isShutdown() {
        return this.shutdown;
    }

    public ManagedChannel shutdownNow() {
        this.shutdown = true;
        this.delayedTransport.shutdownNow(Status.UNAVAILABLE.withDescription("OobChannel.shutdownNow() called"));
        return this;
    }

    /* access modifiers changed from: package-private */
    public void handleSubchannelStateChange(final ConnectivityStateInfo newState) {
        this.channelTracer.reportEvent(new InternalChannelz.ChannelTrace.Event.Builder().setDescription("Entering " + newState.getState() + " state").setSeverity(InternalChannelz.ChannelTrace.Event.Severity.CT_INFO).setTimestampNanos(this.timeProvider.currentTimeNanos()).build());
        switch (newState.getState()) {
            case READY:
            case IDLE:
                this.delayedTransport.reprocess(this.subchannelPicker);
                return;
            case TRANSIENT_FAILURE:
                this.delayedTransport.reprocess(new LoadBalancer.SubchannelPicker() {
                    final LoadBalancer.PickResult errorResult = LoadBalancer.PickResult.withError(newState.getStatus());

                    public LoadBalancer.PickResult pickSubchannel(LoadBalancer.PickSubchannelArgs args) {
                        return this.errorResult;
                    }

                    public String toString() {
                        return MoreObjects.toStringHelper((Class<?>) AnonymousClass1OobErrorPicker.class).add("errorResult", (Object) this.errorResult).toString();
                    }
                });
                return;
            default:
                return;
        }
    }

    /* access modifiers changed from: package-private */
    public void handleSubchannelTerminated() {
        this.channelz.removeSubchannel(this);
        this.executorPool.returnObject(this.executor);
        this.terminatedLatch.countDown();
    }

    /* access modifiers changed from: package-private */
    public LoadBalancer.Subchannel getSubchannel() {
        return this.subchannelImpl;
    }

    /* access modifiers changed from: package-private */
    public InternalSubchannel getInternalSubchannel() {
        return this.subchannel;
    }

    public ListenableFuture<InternalChannelz.ChannelStats> getStats() {
        SettableFuture<InternalChannelz.ChannelStats> ret = SettableFuture.create();
        InternalChannelz.ChannelStats.Builder builder = new InternalChannelz.ChannelStats.Builder();
        this.channelCallsTracer.updateBuilder(builder);
        this.channelTracer.updateBuilder(builder);
        builder.setTarget(this.authority).setState(this.subchannel.getState()).setSubchannels(Collections.singletonList(this.subchannel));
        ret.set(builder.build());
        return ret;
    }

    public InternalLogId getLogId() {
        return this.logId;
    }

    public String toString() {
        return MoreObjects.toStringHelper((Object) this).add("logId", this.logId.getId()).add("authority", (Object) this.authority).toString();
    }

    public void resetConnectBackoff() {
        this.subchannel.resetConnectBackoff();
    }
}
