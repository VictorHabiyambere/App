package io.grpc.okhttp;

import io.grpc.okhttp.OkHttpServerStream;
import java.util.List;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class OkHttpServerStream$TransportState$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ OkHttpServerStream.TransportState f$0;
    public final /* synthetic */ List f$1;

    public /* synthetic */ OkHttpServerStream$TransportState$$ExternalSyntheticLambda0(OkHttpServerStream.TransportState transportState, List list) {
        this.f$0 = transportState;
        this.f$1 = list;
    }

    public final void run() {
        this.f$0.m290lambda$sendTrailers$0$iogrpcokhttpOkHttpServerStream$TransportState(this.f$1);
    }
}
