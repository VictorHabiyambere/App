package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final /* synthetic */ class zzvr implements Runnable {
    public final /* synthetic */ zzvx zza;
    public final /* synthetic */ zzvy zzb;
    public final /* synthetic */ zzvk zzc;

    public /* synthetic */ zzvr(zzvx zzvx, zzvy zzvy, zzvk zzvk) {
        this.zza = zzvx;
        this.zzb = zzvy;
        this.zzc = zzvk;
    }

    public final void run() {
        this.zzb.zzae(0, this.zza.zzb, this.zzc);
    }
}
