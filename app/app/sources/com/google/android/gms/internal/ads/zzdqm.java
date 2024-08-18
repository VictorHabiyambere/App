package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzba;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
final class zzdqm implements zzgfp {
    final /* synthetic */ zzfgt zza;
    final /* synthetic */ zzfgw zzb;
    final /* synthetic */ zzcqd zzc;
    final /* synthetic */ zzdqs zzd;

    zzdqm(zzdqs zzdqs, zzfgt zzfgt, zzfgw zzfgw, zzcqd zzcqd) {
        this.zza = zzfgt;
        this.zzb = zzfgw;
        this.zzc = zzcqd;
        this.zzd = zzdqs;
    }

    public final void zza(Throwable th) {
    }

    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzchd zzchd = (zzchd) obj;
        zzchd.zzW(this.zza, this.zzb);
        zzciv zzN = zzchd.zzN();
        if (((Boolean) zzba.zzc().zza(zzbep.zzke)).booleanValue() && zzN != null) {
            zzcqd zzcqd = this.zzc;
            zzdqs zzdqs = this.zzd;
            zzN.zzI(zzcqd, zzdqs.zzj, zzdqs.zzk);
            zzcqd zzcqd2 = this.zzc;
            zzdqs zzdqs2 = this.zzd;
            zzN.zzK(zzcqd2, zzdqs2.zzj, zzdqs2.zze);
        }
    }
}
