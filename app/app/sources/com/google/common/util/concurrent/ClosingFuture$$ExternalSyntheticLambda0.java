package com.google.common.util.concurrent;

import java.io.Closeable;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class ClosingFuture$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ Closeable f$0;

    public /* synthetic */ ClosingFuture$$ExternalSyntheticLambda0(Closeable closeable) {
        this.f$0 = closeable;
    }

    public final void run() {
        ClosingFuture.lambda$closeQuietly$0(this.f$0);
    }
}
