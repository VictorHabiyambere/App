package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final /* synthetic */ class zzehv implements zzfxu {
    public final /* synthetic */ zzehw zza;
    public final /* synthetic */ zzchd zzb;
    public final /* synthetic */ zzfgt zzc;
    public final /* synthetic */ zzcrq zzd;

    public /* synthetic */ zzehv(zzehw zzehw, zzchd zzchd, zzfgt zzfgt, zzcrq zzcrq) {
        this.zza = zzehw;
        this.zzb = zzchd;
        this.zzc = zzfgt;
        this.zzd = zzcrq;
    }

    public final Object apply(Object obj) {
        zzchd zzchd = this.zzb;
        if (this.zzc.zzN) {
            zzchd.zzah();
        }
        zzcrq zzcrq = this.zzd;
        zzchd.zzab();
        zzchd.onPause();
        return zzcrq.zza();
    }
}
