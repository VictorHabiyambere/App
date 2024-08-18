package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final /* synthetic */ class zzdzk implements Callable {
    public final /* synthetic */ zzaxd zza;
    public final /* synthetic */ Context zzb;

    public /* synthetic */ zzdzk(zzaxd zzaxd, Context context) {
        this.zza = zzaxd;
        this.zzb = context;
    }

    public final Object call() {
        return this.zza.zzc().zzg(this.zzb);
    }
}
