package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final /* synthetic */ class zzcas implements Callable {
    public final /* synthetic */ zzcau zza;
    public final /* synthetic */ Context zzb;

    public /* synthetic */ zzcas(zzcau zzcau, Context context) {
        this.zza = zzcau;
        this.zzb = context;
    }

    public final Object call() {
        return this.zza.zze(this.zzb);
    }
}
