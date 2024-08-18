package io.grpc.inprocess;

import io.grpc.Status;
import io.grpc.inprocess.InProcessTransport;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class InProcessTransport$InProcessStream$InProcessClientStream$$ExternalSyntheticLambda2 implements Runnable {
    public final /* synthetic */ InProcessTransport.InProcessStream.InProcessClientStream f$0;
    public final /* synthetic */ Status f$1;

    public /* synthetic */ InProcessTransport$InProcessStream$InProcessClientStream$$ExternalSyntheticLambda2(InProcessTransport.InProcessStream.InProcessClientStream inProcessClientStream, Status status) {
        this.f$0 = inProcessClientStream;
        this.f$1 = status;
    }

    public final void run() {
        this.f$0.m276lambda$internalCancel$4$iogrpcinprocessInProcessTransport$InProcessStream$InProcessClientStream(this.f$1);
    }
}
