package com.google.android.gms.internal.ads;

import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzdqo {
    private final zzczj zza;
    private final zzdas zzb;
    private final zzdbf zzc;
    private final zzdbr zzd;
    private final zzdef zze;
    private final zzfgt zzf;
    private final zzfgw zzg;
    private final zzcqd zzh;

    public zzdqo(zzczj zzczj, zzdas zzdas, zzdbf zzdbf, zzdbr zzdbr, zzdef zzdef, zzfgt zzfgt, zzfgw zzfgw, zzcqd zzcqd) {
        this.zza = zzczj;
        this.zzb = zzdas;
        this.zzc = zzdbf;
        this.zzd = zzdbr;
        this.zze = zzdef;
        this.zzf = zzfgt;
        this.zzg = zzfgw;
        this.zzh = zzcqd;
    }

    public final void zza(zzdqs zzdqs) {
        zzdas zzdas = this.zzb;
        zzdqf zzb2 = zzdqs.zza;
        Objects.requireNonNull(zzdas);
        zzb2.zzh(this.zza, this.zzc, this.zzd, this.zze, new zzdqn(zzdas));
        zzdqs.zzh(this.zzf, this.zzg, this.zzh);
    }
}
