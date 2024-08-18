package io.grpc.okhttp;

import io.grpc.ServerStreamTracer;
import io.grpc.internal.InternalServer;
import io.grpc.internal.TransportTracer;
import java.util.List;

public final class InternalOkHttpServerBuilder {
    public static InternalServer buildTransportServers(OkHttpServerBuilder builder, List<? extends ServerStreamTracer.Factory> streamTracerFactories) {
        return builder.buildTransportServers(streamTracerFactories);
    }

    public static void setTransportTracerFactory(OkHttpServerBuilder builder, TransportTracer.Factory transportTracerFactory) {
        builder.setTransportTracerFactory(transportTracerFactory);
    }

    public static void setStatsEnabled(OkHttpServerBuilder builder, boolean value) {
        builder.setStatsEnabled(value);
    }

    private InternalOkHttpServerBuilder() {
    }
}
