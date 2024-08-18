package com.google.android.gms.ads.internal;

import com.google.android.gms.internal.ads.zzdvc;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final /* synthetic */ class zze implements Runnable {
    public final /* synthetic */ zzf zza;
    public final /* synthetic */ zzdvc zzb;
    public final /* synthetic */ Long zzc;

    public /* synthetic */ zze(zzf zzf, zzdvc zzdvc, Long l) {
        this.zza = zzf;
        this.zzb = zzdvc;
        this.zzc = l;
    }

    public final void run() {
        zzf.zzf(this.zzb, "cld_r", zzu.zzB().elapsedRealtime() - this.zzc.longValue());
    }
}
