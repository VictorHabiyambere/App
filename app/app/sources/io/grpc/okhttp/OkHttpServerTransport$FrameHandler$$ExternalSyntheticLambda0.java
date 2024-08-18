package io.grpc.okhttp;

import io.grpc.okhttp.OkHttpServerTransport;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class OkHttpServerTransport$FrameHandler$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ OkHttpServerTransport.FrameHandler f$0;
    public final /* synthetic */ OkHttpServerTransport.Http2ErrorStreamState f$1;

    public /* synthetic */ OkHttpServerTransport$FrameHandler$$ExternalSyntheticLambda0(OkHttpServerTransport.FrameHandler frameHandler, OkHttpServerTransport.Http2ErrorStreamState http2ErrorStreamState) {
        this.f$0 = frameHandler;
        this.f$1 = http2ErrorStreamState;
    }

    public final void run() {
        this.f$0.m294lambda$respondWithHttpError$0$iogrpcokhttpOkHttpServerTransport$FrameHandler(this.f$1);
    }
}
