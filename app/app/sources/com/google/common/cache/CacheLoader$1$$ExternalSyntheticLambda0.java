package com.google.common.cache;

import java.util.concurrent.Callable;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class CacheLoader$1$$ExternalSyntheticLambda0 implements Callable {
    public final /* synthetic */ CacheLoader f$0;
    public final /* synthetic */ Object f$1;
    public final /* synthetic */ Object f$2;

    public /* synthetic */ CacheLoader$1$$ExternalSyntheticLambda0(CacheLoader cacheLoader, Object obj, Object obj2) {
        this.f$0 = cacheLoader;
        this.f$1 = obj;
        this.f$2 = obj2;
    }

    public final Object call() {
        return this.f$0.reload(this.f$1, this.f$2).get();
    }
}
