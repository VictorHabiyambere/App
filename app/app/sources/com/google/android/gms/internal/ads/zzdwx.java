package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final /* synthetic */ class zzdwx implements Callable {
    public final /* synthetic */ zzdxf zza;
    public final /* synthetic */ zzfmc zzb;

    public /* synthetic */ zzdwx(zzdxf zzdxf, zzfmc zzfmc) {
        this.zza = zzdxf;
        this.zzb = zzfmc;
    }

    public final Object call() {
        this.zza.zzf(this.zzb);
        return null;
    }
}
