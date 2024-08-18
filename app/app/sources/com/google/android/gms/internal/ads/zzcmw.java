package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
final class zzcmw implements zzfgn {
    private final zzcla zza;
    private final zzcmw zzb = this;
    private final zzhky zzc;
    private final zzhky zzd;
    private final zzhky zze;
    private final zzhky zzf;
    private final zzhky zzg;
    private final zzhky zzh;
    private final zzhky zzi;
    private final zzhky zzj;

    /* synthetic */ zzcmw(zzcla zzcla, Context context, String str, zzcmv zzcmv) {
        this.zza = zzcla;
        this.zzc = zzhkq.zza(context);
        zzhky zzhky = this.zzc;
        zzcla zzcla2 = this.zza;
        this.zzd = new zzfen(zzhky, zzcla2.zzaE, zzcla2.zzaF);
        this.zze = zzhko.zzc(new zzffx(zzcla2.zzaE));
        this.zzf = zzhko.zzc(zzfhl.zza());
        zzhky zzP = zzcla2.zzc;
        zzhky zzL = zzcla2.zzO;
        zzhky zzhky2 = this.zzd;
        zzhky zzhky3 = this.zze;
        zzfhq zza2 = zzfhq.zza();
        zzhky zzhky4 = this.zzf;
        this.zzg = zzhko.zzc(new zzfgh(zzhky, zzP, zzL, zzhky2, zzhky3, zza2, zzhky4));
        zzhky zzhky5 = this.zzg;
        this.zzh = zzhko.zzc(new zzfgr(zzhky5, zzhky3, zzhky4));
        this.zzi = zzhkq.zzc(str);
        this.zzj = zzhko.zzc(new zzfgl(this.zzi, zzhky5, zzhky, zzhky3, zzhky4, zzcla2.zzl, zzcla2.zzQ, zzcla2.zzM));
    }

    public final zzfgk zza() {
        return (zzfgk) this.zzj.zzb();
    }

    public final zzfgq zzb() {
        return (zzfgq) this.zzh.zzb();
    }
}
