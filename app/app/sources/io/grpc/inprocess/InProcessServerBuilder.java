package io.grpc.inprocess;

import com.google.common.base.Preconditions;
import io.grpc.Deadline;
import io.grpc.ServerBuilder;
import io.grpc.ServerStreamTracer;
import io.grpc.internal.AbstractServerImplBuilder;
import io.grpc.internal.FixedObjectPool;
import io.grpc.internal.GrpcUtil;
import io.grpc.internal.InternalServer;
import io.grpc.internal.ObjectPool;
import io.grpc.internal.ServerImplBuilder;
import io.grpc.internal.SharedResourcePool;
import java.io.File;
import java.net.SocketAddress;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public final class InProcessServerBuilder extends AbstractServerImplBuilder<InProcessServerBuilder> {
    final SocketAddress listenAddress;
    int maxInboundMetadataSize = Integer.MAX_VALUE;
    ObjectPool<ScheduledExecutorService> schedulerPool = SharedResourcePool.forResource(GrpcUtil.TIMER_SERVICE);
    private final ServerImplBuilder serverImplBuilder;

    public static InProcessServerBuilder forName(String name) {
        return forAddress(new InProcessSocketAddress((String) Preconditions.checkNotNull(name, "name")));
    }

    public static InProcessServerBuilder forAddress(SocketAddress listenAddress2) {
        return new InProcessServerBuilder(listenAddress2);
    }

    public static InProcessServerBuilder forPort(int port) {
        throw new UnsupportedOperationException("call forName() instead");
    }

    public static String generateName() {
        return UUID.randomUUID().toString();
    }

    private InProcessServerBuilder(SocketAddress listenAddress2) {
        this.listenAddress = (SocketAddress) Preconditions.checkNotNull(listenAddress2, "listenAddress");
        this.serverImplBuilder = new ServerImplBuilder(new ServerImplBuilder.ClientTransportServersBuilder() {
            public InternalServer buildClientTransportServers(List<? extends ServerStreamTracer.Factory> streamTracerFactories) {
                return InProcessServerBuilder.this.buildTransportServers(streamTracerFactories);
            }
        });
        this.serverImplBuilder.setStatsRecordStartedRpcs(false);
        this.serverImplBuilder.setStatsRecordFinishedRpcs(false);
        handshakeTimeout(Long.MAX_VALUE, TimeUnit.SECONDS);
    }

    /* access modifiers changed from: protected */
    public ServerBuilder<?> delegate() {
        return this.serverImplBuilder;
    }

    public InProcessServerBuilder scheduledExecutorService(ScheduledExecutorService scheduledExecutorService) {
        this.schedulerPool = new FixedObjectPool((ScheduledExecutorService) Preconditions.checkNotNull(scheduledExecutorService, "scheduledExecutorService"));
        return this;
    }

    public InProcessServerBuilder deadlineTicker(Deadline.Ticker ticker) {
        this.serverImplBuilder.setDeadlineTicker(ticker);
        return this;
    }

    public InProcessServerBuilder maxInboundMetadataSize(int bytes) {
        Preconditions.checkArgument(bytes > 0, "maxInboundMetadataSize must be > 0");
        this.maxInboundMetadataSize = bytes;
        return this;
    }

    /* access modifiers changed from: package-private */
    public InProcessServer buildTransportServers(List<? extends ServerStreamTracer.Factory> streamTracerFactories) {
        return new InProcessServer(this, streamTracerFactories);
    }

    public InProcessServerBuilder useTransportSecurity(File certChain, File privateKey) {
        throw new UnsupportedOperationException("TLS not supported in InProcessServer");
    }

    /* access modifiers changed from: package-private */
    public void setStatsEnabled(boolean value) {
        this.serverImplBuilder.setStatsEnabled(value);
    }
}
