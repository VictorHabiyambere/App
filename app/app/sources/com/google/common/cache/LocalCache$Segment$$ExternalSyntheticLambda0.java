package com.google.common.cache;

import com.google.common.cache.LocalCache;
import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class LocalCache$Segment$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ LocalCache.Segment f$0;
    public final /* synthetic */ Object f$1;
    public final /* synthetic */ int f$2;
    public final /* synthetic */ LocalCache.LoadingValueReference f$3;
    public final /* synthetic */ ListenableFuture f$4;

    public /* synthetic */ LocalCache$Segment$$ExternalSyntheticLambda0(LocalCache.Segment segment, Object obj, int i, LocalCache.LoadingValueReference loadingValueReference, ListenableFuture listenableFuture) {
        this.f$0 = segment;
        this.f$1 = obj;
        this.f$2 = i;
        this.f$3 = loadingValueReference;
        this.f$4 = listenableFuture;
    }

    public final void run() {
        this.f$0.m2035lambda$loadAsync$0$comgooglecommoncacheLocalCache$Segment(this.f$1, this.f$2, this.f$3, this.f$4);
    }
}
