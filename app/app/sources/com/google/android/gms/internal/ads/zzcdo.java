package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final /* synthetic */ class zzcdo implements Runnable {
    public final /* synthetic */ zzcds zza;
    public final /* synthetic */ boolean zzb;

    public /* synthetic */ zzcdo(zzcds zzcds, boolean z) {
        this.zza = zzcds;
        this.zzb = z;
    }

    public final void run() {
        this.zza.zzq(this.zzb);
    }
}
