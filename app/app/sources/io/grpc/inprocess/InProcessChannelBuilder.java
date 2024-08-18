package io.grpc.inprocess;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.google.common.base.Preconditions;
import io.grpc.ChannelCredentials;
import io.grpc.ChannelLogger;
import io.grpc.ManagedChannelBuilder;
import io.grpc.internal.AbstractManagedChannelImplBuilder;
import io.grpc.internal.ClientTransportFactory;
import io.grpc.internal.ConnectionClientTransport;
import io.grpc.internal.GrpcUtil;
import io.grpc.internal.ManagedChannelImplBuilder;
import io.grpc.internal.SharedResourceHolder;
import java.net.SocketAddress;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;

public final class InProcessChannelBuilder extends AbstractManagedChannelImplBuilder<InProcessChannelBuilder> {
    private final ManagedChannelImplBuilder managedChannelImplBuilder;
    private int maxInboundMetadataSize = Integer.MAX_VALUE;
    private ScheduledExecutorService scheduledExecutorService;
    private boolean transportIncludeStatusCause = false;

    public static InProcessChannelBuilder forName(String name) {
        return forAddress(new InProcessSocketAddress((String) Preconditions.checkNotNull(name, "name")));
    }

    public static InProcessChannelBuilder forTarget(String target) {
        return new InProcessChannelBuilder((SocketAddress) null, (String) Preconditions.checkNotNull(target, TypedValues.AttributesType.S_TARGET));
    }

    public static InProcessChannelBuilder forAddress(SocketAddress address) {
        return new InProcessChannelBuilder((SocketAddress) Preconditions.checkNotNull(address, "address"), (String) null);
    }

    public static InProcessChannelBuilder forAddress(String name, int port) {
        throw new UnsupportedOperationException("call forName() instead");
    }

    private InProcessChannelBuilder(@Nullable SocketAddress directAddress, @Nullable String target) {
        if (directAddress != null) {
            this.managedChannelImplBuilder = new ManagedChannelImplBuilder(directAddress, "localhost", new ManagedChannelImplBuilder.ClientTransportFactoryBuilder() {
                public ClientTransportFactory buildClientTransportFactory() {
                    return InProcessChannelBuilder.this.buildTransportFactory();
                }
            }, (ManagedChannelImplBuilder.ChannelBuilderDefaultPortProvider) null);
        } else {
            this.managedChannelImplBuilder = new ManagedChannelImplBuilder(target, new ManagedChannelImplBuilder.ClientTransportFactoryBuilder() {
                public ClientTransportFactory buildClientTransportFactory() {
                    return InProcessChannelBuilder.this.buildTransportFactory();
                }
            }, (ManagedChannelImplBuilder.ChannelBuilderDefaultPortProvider) null);
        }
        this.managedChannelImplBuilder.setStatsRecordStartedRpcs(false);
        this.managedChannelImplBuilder.setStatsRecordFinishedRpcs(false);
        this.managedChannelImplBuilder.setStatsRecordRetryMetrics(false);
        this.managedChannelImplBuilder.disableRetry();
    }

    /* access modifiers changed from: protected */
    public ManagedChannelBuilder<?> delegate() {
        return this.managedChannelImplBuilder;
    }

    public InProcessChannelBuilder maxInboundMessageSize(int max) {
        return (InProcessChannelBuilder) super.maxInboundMessageSize(max);
    }

    public InProcessChannelBuilder useTransportSecurity() {
        return this;
    }

    public InProcessChannelBuilder usePlaintext() {
        return this;
    }

    public InProcessChannelBuilder keepAliveTime(long keepAliveTime, TimeUnit timeUnit) {
        return this;
    }

    public InProcessChannelBuilder keepAliveTimeout(long keepAliveTimeout, TimeUnit timeUnit) {
        return this;
    }

    public InProcessChannelBuilder keepAliveWithoutCalls(boolean enable) {
        return this;
    }

    public InProcessChannelBuilder scheduledExecutorService(ScheduledExecutorService scheduledExecutorService2) {
        this.scheduledExecutorService = (ScheduledExecutorService) Preconditions.checkNotNull(scheduledExecutorService2, "scheduledExecutorService");
        return this;
    }

    public InProcessChannelBuilder maxInboundMetadataSize(int bytes) {
        Preconditions.checkArgument(bytes > 0, "maxInboundMetadataSize must be > 0");
        this.maxInboundMetadataSize = bytes;
        return this;
    }

    public InProcessChannelBuilder propagateCauseWithStatus(boolean enable) {
        this.transportIncludeStatusCause = enable;
        return this;
    }

    /* access modifiers changed from: package-private */
    public ClientTransportFactory buildTransportFactory() {
        return new InProcessClientTransportFactory(this.scheduledExecutorService, this.maxInboundMetadataSize, this.transportIncludeStatusCause);
    }

    /* access modifiers changed from: package-private */
    public void setStatsEnabled(boolean value) {
        this.managedChannelImplBuilder.setStatsEnabled(value);
    }

    static final class InProcessClientTransportFactory implements ClientTransportFactory {
        private boolean closed;
        private final boolean includeCauseWithStatus;
        private final int maxInboundMetadataSize;
        private final ScheduledExecutorService timerService;
        private final boolean useSharedTimer;

        private InProcessClientTransportFactory(@Nullable ScheduledExecutorService scheduledExecutorService, int maxInboundMetadataSize2, boolean includeCauseWithStatus2) {
            this.useSharedTimer = scheduledExecutorService == null;
            this.timerService = this.useSharedTimer ? (ScheduledExecutorService) SharedResourceHolder.get(GrpcUtil.TIMER_SERVICE) : scheduledExecutorService;
            this.maxInboundMetadataSize = maxInboundMetadataSize2;
            this.includeCauseWithStatus = includeCauseWithStatus2;
        }

        public ConnectionClientTransport newClientTransport(SocketAddress addr, ClientTransportFactory.ClientTransportOptions options, ChannelLogger channelLogger) {
            if (!this.closed) {
                return new InProcessTransport(addr, this.maxInboundMetadataSize, options.getAuthority(), options.getUserAgent(), options.getEagAttributes(), this.includeCauseWithStatus);
            }
            throw new IllegalStateException("The transport factory is closed.");
        }

        public ScheduledExecutorService getScheduledExecutorService() {
            return this.timerService;
        }

        public ClientTransportFactory.SwapChannelCredentialsResult swapChannelCredentials(ChannelCredentials channelCreds) {
            return null;
        }

        public void close() {
            if (!this.closed) {
                this.closed = true;
                if (this.useSharedTimer) {
                    SharedResourceHolder.release(GrpcUtil.TIMER_SERVICE, this.timerService);
                }
            }
        }
    }
}
