package io.grpc.inprocess;

import io.grpc.Metadata;
import io.grpc.inprocess.InProcessTransport;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class InProcessTransport$InProcessStream$InProcessServerStream$$ExternalSyntheticLambda3 implements Runnable {
    public final /* synthetic */ InProcessTransport.InProcessStream.InProcessServerStream f$0;
    public final /* synthetic */ Metadata f$1;

    public /* synthetic */ InProcessTransport$InProcessStream$InProcessServerStream$$ExternalSyntheticLambda3(InProcessTransport.InProcessStream.InProcessServerStream inProcessServerStream, Metadata metadata) {
        this.f$0 = inProcessServerStream;
        this.f$1 = metadata;
    }

    public final void run() {
        this.f$0.m286lambda$writeHeaders$4$iogrpcinprocessInProcessTransport$InProcessStream$InProcessServerStream(this.f$1);
    }
}
