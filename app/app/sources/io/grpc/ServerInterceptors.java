package io.grpc;

import com.google.common.base.Preconditions;
import io.grpc.MethodDescriptor;
import io.grpc.ServerCall;
import io.grpc.ServerServiceDefinition;
import io.grpc.ServiceDescriptor;
import java.io.BufferedInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public final class ServerInterceptors {
    private ServerInterceptors() {
    }

    public static ServerServiceDefinition interceptForward(ServerServiceDefinition serviceDef, ServerInterceptor... interceptors) {
        return interceptForward(serviceDef, (List<? extends ServerInterceptor>) Arrays.asList(interceptors));
    }

    public static ServerServiceDefinition interceptForward(BindableService bindableService, ServerInterceptor... interceptors) {
        return interceptForward(bindableService.bindService(), (List<? extends ServerInterceptor>) Arrays.asList(interceptors));
    }

    public static ServerServiceDefinition interceptForward(ServerServiceDefinition serviceDef, List<? extends ServerInterceptor> interceptors) {
        List<? extends ServerInterceptor> copy = new ArrayList<>(interceptors);
        Collections.reverse(copy);
        return intercept(serviceDef, copy);
    }

    public static ServerServiceDefinition interceptForward(BindableService bindableService, List<? extends ServerInterceptor> interceptors) {
        return interceptForward(bindableService.bindService(), interceptors);
    }

    public static ServerServiceDefinition intercept(ServerServiceDefinition serviceDef, ServerInterceptor... interceptors) {
        return intercept(serviceDef, (List<? extends ServerInterceptor>) Arrays.asList(interceptors));
    }

    public static ServerServiceDefinition intercept(BindableService bindableService, ServerInterceptor... interceptors) {
        Preconditions.checkNotNull(bindableService, "bindableService");
        return intercept(bindableService.bindService(), (List<? extends ServerInterceptor>) Arrays.asList(interceptors));
    }

    public static ServerServiceDefinition intercept(ServerServiceDefinition serviceDef, List<? extends ServerInterceptor> interceptors) {
        Preconditions.checkNotNull(serviceDef, "serviceDef");
        if (interceptors.isEmpty()) {
            return serviceDef;
        }
        ServerServiceDefinition.Builder serviceDefBuilder = ServerServiceDefinition.builder(serviceDef.getServiceDescriptor());
        for (ServerMethodDefinition<?, ?> method : serviceDef.getMethods()) {
            wrapAndAddMethod(serviceDefBuilder, method, interceptors);
        }
        return serviceDefBuilder.build();
    }

    public static ServerServiceDefinition intercept(BindableService bindableService, List<? extends ServerInterceptor> interceptors) {
        Preconditions.checkNotNull(bindableService, "bindableService");
        return intercept(bindableService.bindService(), interceptors);
    }

    public static ServerServiceDefinition useInputStreamMessages(ServerServiceDefinition serviceDef) {
        return useMarshalledMessages(serviceDef, new MethodDescriptor.Marshaller<InputStream>() {
            public InputStream stream(InputStream value) {
                return value;
            }

            public InputStream parse(InputStream stream) {
                if (stream.markSupported()) {
                    return stream;
                }
                if (stream instanceof KnownLength) {
                    return new KnownLengthBufferedInputStream(stream);
                }
                return new BufferedInputStream(stream);
            }
        });
    }

    private static final class KnownLengthBufferedInputStream extends BufferedInputStream implements KnownLength {
        KnownLengthBufferedInputStream(InputStream in) {
            super(in);
        }
    }

    public static <T> ServerServiceDefinition useMarshalledMessages(ServerServiceDefinition serviceDef, MethodDescriptor.Marshaller<T> marshaller) {
        return useMarshalledMessages(serviceDef, marshaller, marshaller);
    }

    public static <ReqT, RespT> ServerServiceDefinition useMarshalledMessages(ServerServiceDefinition serviceDef, MethodDescriptor.Marshaller<ReqT> requestMarshaller, MethodDescriptor.Marshaller<RespT> responseMarshaller) {
        List<ServerMethodDefinition<?, ?>> wrappedMethods = new ArrayList<>();
        List<MethodDescriptor<?, ?>> wrappedDescriptors = new ArrayList<>();
        for (ServerMethodDefinition<?, ?> definition : serviceDef.getMethods()) {
            MethodDescriptor<NewReqT, NewRespT> build = definition.getMethodDescriptor().toBuilder(requestMarshaller, responseMarshaller).build();
            wrappedDescriptors.add(build);
            wrappedMethods.add(wrapMethod(definition, build));
        }
        ServiceDescriptor.Builder serviceDescriptorBuilder = ServiceDescriptor.newBuilder(serviceDef.getServiceDescriptor().getName()).setSchemaDescriptor(serviceDef.getServiceDescriptor().getSchemaDescriptor());
        for (MethodDescriptor<?, ?> wrappedDescriptor : wrappedDescriptors) {
            serviceDescriptorBuilder.addMethod(wrappedDescriptor);
        }
        ServerServiceDefinition.Builder serviceBuilder = ServerServiceDefinition.builder(serviceDescriptorBuilder.build());
        for (ServerMethodDefinition<?, ?> definition2 : wrappedMethods) {
            serviceBuilder.addMethod(definition2);
        }
        return serviceBuilder.build();
    }

    /* JADX WARNING: type inference failed for: r4v0, types: [io.grpc.ServerMethodDefinition<ReqT, RespT>, io.grpc.ServerMethodDefinition] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static <ReqT, RespT> void wrapAndAddMethod(io.grpc.ServerServiceDefinition.Builder r3, io.grpc.ServerMethodDefinition<ReqT, RespT> r4, java.util.List<? extends io.grpc.ServerInterceptor> r5) {
        /*
            io.grpc.ServerCallHandler r0 = r4.getServerCallHandler()
            java.util.Iterator r1 = r5.iterator()
        L_0x0008:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x0019
            java.lang.Object r2 = r1.next()
            io.grpc.ServerInterceptor r2 = (io.grpc.ServerInterceptor) r2
            io.grpc.ServerInterceptors$InterceptCallHandler r0 = io.grpc.ServerInterceptors.InterceptCallHandler.create(r2, r0)
            goto L_0x0008
        L_0x0019:
            io.grpc.ServerMethodDefinition r1 = r4.withServerCallHandler(r0)
            r3.addMethod(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.grpc.ServerInterceptors.wrapAndAddMethod(io.grpc.ServerServiceDefinition$Builder, io.grpc.ServerMethodDefinition, java.util.List):void");
    }

    static final class InterceptCallHandler<ReqT, RespT> implements ServerCallHandler<ReqT, RespT> {
        private final ServerCallHandler<ReqT, RespT> callHandler;
        private final ServerInterceptor interceptor;

        public static <ReqT, RespT> InterceptCallHandler<ReqT, RespT> create(ServerInterceptor interceptor2, ServerCallHandler<ReqT, RespT> callHandler2) {
            return new InterceptCallHandler<>(interceptor2, callHandler2);
        }

        private InterceptCallHandler(ServerInterceptor interceptor2, ServerCallHandler<ReqT, RespT> callHandler2) {
            this.interceptor = (ServerInterceptor) Preconditions.checkNotNull(interceptor2, "interceptor");
            this.callHandler = callHandler2;
        }

        public ServerCall.Listener<ReqT> startCall(ServerCall<ReqT, RespT> call, Metadata headers) {
            return this.interceptor.interceptCall(call, headers, this.callHandler);
        }
    }

    static <OReqT, ORespT, WReqT, WRespT> ServerMethodDefinition<WReqT, WRespT> wrapMethod(ServerMethodDefinition<OReqT, ORespT> definition, MethodDescriptor<WReqT, WRespT> wrappedMethod) {
        return ServerMethodDefinition.create(wrappedMethod, wrapHandler(definition.getServerCallHandler(), definition.getMethodDescriptor(), wrappedMethod));
    }

    private static <OReqT, ORespT, WReqT, WRespT> ServerCallHandler<WReqT, WRespT> wrapHandler(final ServerCallHandler<OReqT, ORespT> originalHandler, final MethodDescriptor<OReqT, ORespT> originalMethod, final MethodDescriptor<WReqT, WRespT> wrappedMethod) {
        return new ServerCallHandler<WReqT, WRespT>() {
            public ServerCall.Listener<WReqT> startCall(final ServerCall<WReqT, WRespT> call, Metadata headers) {
                final ServerCall.Listener<OReqT> originalListener = originalHandler.startCall(new PartialForwardingServerCall<OReqT, ORespT>() {
                    /* access modifiers changed from: protected */
                    public ServerCall<WReqT, WRespT> delegate() {
                        return call;
                    }

                    public void sendMessage(ORespT message) {
                        delegate().sendMessage(wrappedMethod.parseResponse(MethodDescriptor.this.streamResponse(message)));
                    }

                    public MethodDescriptor<OReqT, ORespT> getMethodDescriptor() {
                        return MethodDescriptor.this;
                    }
                }, headers);
                return new PartialForwardingServerCallListener<WReqT>() {
                    /* access modifiers changed from: protected */
                    public ServerCall.Listener<OReqT> delegate() {
                        return originalListener;
                    }

                    public void onMessage(WReqT message) {
                        delegate().onMessage(MethodDescriptor.this.parseRequest(wrappedMethod.streamRequest(message)));
                    }
                };
            }
        };
    }
}
