package io.grpc.okhttp;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class OkHttpServer$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ OkHttpServer f$0;

    public /* synthetic */ OkHttpServer$$ExternalSyntheticLambda0(OkHttpServer okHttpServer) {
        this.f$0 = okHttpServer;
    }

    public final void run() {
        this.f$0.acceptConnections();
    }
}
