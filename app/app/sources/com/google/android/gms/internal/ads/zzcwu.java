package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzcwu implements zzdew, zzdaz {
    private final Clock zza;
    private final zzcww zzb;
    private final zzfho zzc;
    private final String zzd;

    zzcwu(Clock clock, zzcww zzcww, zzfho zzfho, String str) {
        this.zza = clock;
        this.zzb = zzcww;
        this.zzc = zzfho;
        this.zzd = str;
    }

    public final void zza() {
        this.zzb.zze(this.zzd, this.zza.elapsedRealtime());
    }

    public final void zzs() {
        zzfho zzfho = this.zzc;
        this.zzb.zzd(zzfho.zzf, this.zzd, this.zza.elapsedRealtime());
    }
}
