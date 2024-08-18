package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final /* synthetic */ class zzefv implements Callable {
    public final /* synthetic */ zzefz zza;

    public /* synthetic */ zzefv(zzefz zzefz) {
        this.zza = zzefz;
    }

    public final Object call() {
        return this.zza.getWritableDatabase();
    }
}
