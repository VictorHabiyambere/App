package io.grpc;

import io.grpc.ServerStreamTracer;
import java.util.List;

public final class InternalGlobalInterceptors {
    public static void setInterceptorsTracers(List<ClientInterceptor> clientInterceptorList, List<ServerInterceptor> serverInterceptorList, List<ServerStreamTracer.Factory> serverStreamTracerFactoryList) {
        GlobalInterceptors.setInterceptorsTracers(clientInterceptorList, serverInterceptorList, serverStreamTracerFactoryList);
    }

    public static List<ClientInterceptor> getClientInterceptors() {
        return GlobalInterceptors.getClientInterceptors();
    }

    public static List<ServerInterceptor> getServerInterceptors() {
        return GlobalInterceptors.getServerInterceptors();
    }

    public static List<ServerStreamTracer.Factory> getServerStreamTracerFactories() {
        return GlobalInterceptors.getServerStreamTracerFactories();
    }

    private InternalGlobalInterceptors() {
    }
}
