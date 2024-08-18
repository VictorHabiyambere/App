package com.google.common.util.concurrent;

import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.Futures;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class Futures$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ Futures.InCompletionOrderState f$0;
    public final /* synthetic */ ImmutableList f$1;
    public final /* synthetic */ int f$2;

    public /* synthetic */ Futures$$ExternalSyntheticLambda0(Futures.InCompletionOrderState inCompletionOrderState, ImmutableList immutableList, int i) {
        this.f$0 = inCompletionOrderState;
        this.f$1 = immutableList;
        this.f$2 = i;
    }

    public final void run() {
        this.f$0.recordInputCompletion(this.f$1, this.f$2);
    }
}
