package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final /* synthetic */ class zzeme implements zzfxu {
    public final /* synthetic */ zzemi zza;
    public final /* synthetic */ zzchd zzb;
    public final /* synthetic */ zzfgt zzc;
    public final /* synthetic */ zzdri zzd;

    public /* synthetic */ zzeme(zzemi zzemi, zzchd zzchd, zzfgt zzfgt, zzdri zzdri) {
        this.zza = zzemi;
        this.zzb = zzchd;
        this.zzc = zzfgt;
        this.zzd = zzdri;
    }

    public final Object apply(Object obj) {
        zzchd zzchd = this.zzb;
        if (this.zzc.zzN) {
            zzchd.zzah();
        }
        zzdri zzdri = this.zzd;
        zzchd.zzab();
        zzchd.onPause();
        return zzdri.zzi();
    }
}
