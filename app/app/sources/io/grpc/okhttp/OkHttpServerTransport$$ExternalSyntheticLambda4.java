package io.grpc.okhttp;

import io.grpc.internal.TransportTracer;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class OkHttpServerTransport$$ExternalSyntheticLambda4 implements TransportTracer.FlowControlReader {
    public final /* synthetic */ OkHttpServerTransport f$0;

    public /* synthetic */ OkHttpServerTransport$$ExternalSyntheticLambda4(OkHttpServerTransport okHttpServerTransport) {
        this.f$0 = okHttpServerTransport;
    }

    public final TransportTracer.FlowControlWindows read() {
        return this.f$0.readFlowControlWindow();
    }
}
