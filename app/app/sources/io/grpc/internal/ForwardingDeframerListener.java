package io.grpc.internal;

import io.grpc.internal.MessageDeframer;
import io.grpc.internal.StreamListener;

abstract class ForwardingDeframerListener implements MessageDeframer.Listener {
    /* access modifiers changed from: protected */
    public abstract MessageDeframer.Listener delegate();

    ForwardingDeframerListener() {
    }

    public void bytesRead(int numBytes) {
        delegate().bytesRead(numBytes);
    }

    public void messagesAvailable(StreamListener.MessageProducer producer) {
        delegate().messagesAvailable(producer);
    }

    public void deframerClosed(boolean hasPartialMessage) {
        delegate().deframerClosed(hasPartialMessage);
    }

    public void deframeFailed(Throwable cause) {
        delegate().deframeFailed(cause);
    }
}
