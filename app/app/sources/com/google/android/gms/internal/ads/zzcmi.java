package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
final class zzcmi implements zzdwm {
    /* access modifiers changed from: private */
    public final Context zza;
    private final zzbmo zzb;
    private final zzcla zzc;
    private final zzcmi zzd = this;
    private final zzhky zze;
    private final zzhky zzf;
    private final zzhky zzg;
    private final zzhky zzh;

    /* synthetic */ zzcmi(zzcla zzcla, Context context, zzbmo zzbmo, zzcmh zzcmh) {
        this.zzc = zzcla;
        this.zza = context;
        this.zzb = zzbmo;
        this.zze = zzhkq.zza(this.zzd);
        this.zzf = zzhkq.zza(zzbmo);
        this.zzg = new zzdwi(this.zzf);
        this.zzh = zzhko.zzc(new zzdwk(this.zze, this.zzg));
    }

    public final zzdwd zzb() {
        return new zzcmc(this.zzc, this.zzd, (zzcmb) null);
    }

    public final zzdwj zzd() {
        return (zzdwj) this.zzh.zzb();
    }
}
