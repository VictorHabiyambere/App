package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final /* synthetic */ class zzaax implements Runnable {
    public final /* synthetic */ zzaba zza;
    public final /* synthetic */ zzack zzb;
    public final /* synthetic */ zzdv zzc;

    public /* synthetic */ zzaax(zzaba zzaba, zzack zzack, zzdv zzdv) {
        this.zza = zzaba;
        this.zzb = zzack;
        this.zzc = zzdv;
    }

    public final void run() {
        this.zzb.zzc(this.zza, this.zzc);
    }
}
