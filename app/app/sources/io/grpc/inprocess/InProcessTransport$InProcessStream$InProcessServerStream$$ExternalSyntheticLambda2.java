package io.grpc.inprocess;

import io.grpc.Status;
import io.grpc.inprocess.InProcessTransport;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class InProcessTransport$InProcessStream$InProcessServerStream$$ExternalSyntheticLambda2 implements Runnable {
    public final /* synthetic */ InProcessTransport.InProcessStream.InProcessServerStream f$0;
    public final /* synthetic */ Status f$1;

    public /* synthetic */ InProcessTransport$InProcessStream$InProcessServerStream$$ExternalSyntheticLambda2(InProcessTransport.InProcessStream.InProcessServerStream inProcessServerStream, Status status) {
        this.f$0 = inProcessServerStream;
        this.f$1 = status;
    }

    public final void run() {
        this.f$0.m283lambda$internalCancel$6$iogrpcinprocessInProcessTransport$InProcessStream$InProcessServerStream(this.f$1);
    }
}
