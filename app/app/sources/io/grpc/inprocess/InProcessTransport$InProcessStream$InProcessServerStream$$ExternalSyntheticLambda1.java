package io.grpc.inprocess;

import io.grpc.Metadata;
import io.grpc.Status;
import io.grpc.inprocess.InProcessTransport;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class InProcessTransport$InProcessStream$InProcessServerStream$$ExternalSyntheticLambda1 implements Runnable {
    public final /* synthetic */ InProcessTransport.InProcessStream.InProcessServerStream f$0;
    public final /* synthetic */ Status f$1;
    public final /* synthetic */ Metadata f$2;

    public /* synthetic */ InProcessTransport$InProcessStream$InProcessServerStream$$ExternalSyntheticLambda1(InProcessTransport.InProcessStream.InProcessServerStream inProcessServerStream, Status status, Metadata metadata) {
        this.f$0 = inProcessServerStream;
        this.f$1 = status;
        this.f$2 = metadata;
    }

    public final void run() {
        this.f$0.m282lambda$clientRequested$2$iogrpcinprocessInProcessTransport$InProcessStream$InProcessServerStream(this.f$1, this.f$2);
    }
}
