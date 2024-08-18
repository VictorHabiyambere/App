package com.google.android.gms.ads.nonagon.signalgeneration;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final /* synthetic */ class zzb implements Runnable {
    public final /* synthetic */ zze zza;
    public final /* synthetic */ boolean zzb;
    public final /* synthetic */ boolean zzc;

    public /* synthetic */ zzb(zze zze, boolean z, boolean z2) {
        this.zza = zze;
        this.zzb = z;
        this.zzc = z2;
    }

    public final void run() {
        this.zza.zzd(this.zzb, this.zzc);
    }
}
