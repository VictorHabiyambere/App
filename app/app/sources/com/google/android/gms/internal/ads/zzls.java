package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final /* synthetic */ class zzls implements Runnable {
    public final /* synthetic */ zzlt zza;
    public final /* synthetic */ zzgaz zzb;
    public final /* synthetic */ zzvo zzc;

    public /* synthetic */ zzls(zzlt zzlt, zzgaz zzgaz, zzvo zzvo) {
        this.zza = zzlt;
        this.zzb = zzgaz;
        this.zzc = zzvo;
    }

    public final void run() {
        this.zza.zzk(this.zzb, this.zzc);
    }
}
