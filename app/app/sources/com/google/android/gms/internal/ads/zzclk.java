package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
final class zzclk implements zzfbu {
    private final zzcla zza;
    private final zzclk zzb = this;
    private final zzhky zzc;
    private final zzhky zzd;
    private final zzhky zze;
    private final zzhky zzf;
    private final zzhky zzg;
    private final zzhky zzh;

    /* synthetic */ zzclk(zzcla zzcla, Context context, String str, zzclj zzclj) {
        this.zza = zzcla;
        this.zzc = zzhkq.zza(context);
        this.zzd = zzhkq.zza(str);
        zzhky zzhky = this.zzc;
        zzcla zzcla2 = this.zza;
        this.zze = new zzfem(zzhky, zzcla2.zzaE, zzcla2.zzaF);
        this.zzf = zzhko.zzc(new zzfcs(zzcla2.zzaE));
        zzhky zzP = zzcla2.zzc;
        zzhky zzL = zzcla2.zzO;
        zzhky zzhky2 = this.zze;
        zzhky zzhky3 = this.zzf;
        this.zzg = zzhko.zzc(new zzfcu(zzhky, zzP, zzL, zzhky2, zzhky3, zzfhq.zza(), zzcla2.zzl));
        this.zzh = zzhko.zzc(new zzfda(zzcla2.zzO, zzhky, this.zzd, this.zzg, zzhky3, zzcla2.zzl, zzcla2.zzM));
    }

    public final zzfcz zza() {
        return (zzfcz) this.zzh.zzb();
    }
}
