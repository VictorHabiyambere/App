package io.grpc.inprocess;

import io.grpc.inprocess.InProcessTransport;
import io.grpc.internal.StreamListener;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class InProcessTransport$InProcessStream$InProcessClientStream$$ExternalSyntheticLambda4 implements Runnable {
    public final /* synthetic */ InProcessTransport.InProcessStream.InProcessClientStream f$0;
    public final /* synthetic */ StreamListener.MessageProducer f$1;

    public /* synthetic */ InProcessTransport$InProcessStream$InProcessClientStream$$ExternalSyntheticLambda4(InProcessTransport.InProcessStream.InProcessClientStream inProcessClientStream, StreamListener.MessageProducer messageProducer) {
        this.f$0 = inProcessClientStream;
        this.f$1 = messageProducer;
    }

    public final void run() {
        this.f$0.m278lambda$serverRequested$1$iogrpcinprocessInProcessTransport$InProcessStream$InProcessClientStream(this.f$1);
    }
}
