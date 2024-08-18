package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final /* synthetic */ class zzejk implements zzfxu {
    public final /* synthetic */ zzejo zza;
    public final /* synthetic */ zzchd zzb;
    public final /* synthetic */ zzfgt zzc;
    public final /* synthetic */ zzdih zzd;

    public /* synthetic */ zzejk(zzejo zzejo, zzchd zzchd, zzfgt zzfgt, zzdih zzdih) {
        this.zza = zzejo;
        this.zzb = zzchd;
        this.zzc = zzfgt;
        this.zzd = zzdih;
    }

    public final Object apply(Object obj) {
        zzchd zzchd = this.zzb;
        if (this.zzc.zzN) {
            zzchd.zzah();
        }
        zzdih zzdih = this.zzd;
        zzchd.zzab();
        zzchd.onPause();
        return zzdih.zzg();
    }
}
