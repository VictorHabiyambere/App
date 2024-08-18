package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final /* synthetic */ class zzvt implements Runnable {
    public final /* synthetic */ zzvx zza;
    public final /* synthetic */ zzvy zzb;
    public final /* synthetic */ zzvf zzc;
    public final /* synthetic */ zzvk zzd;

    public /* synthetic */ zzvt(zzvx zzvx, zzvy zzvy, zzvf zzvf, zzvk zzvk) {
        this.zza = zzvx;
        this.zzb = zzvy;
        this.zzc = zzvf;
        this.zzd = zzvk;
    }

    public final void run() {
        this.zzb.zzag(0, this.zza.zzb, this.zzc, this.zzd);
    }
}
