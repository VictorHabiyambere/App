package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final /* synthetic */ class zzeep implements Callable {
    public final /* synthetic */ zzeen zza;

    public /* synthetic */ zzeep(zzeen zzeen) {
        this.zza = zzeen;
    }

    public final Object call() {
        return this.zza.getWritableDatabase();
    }
}
