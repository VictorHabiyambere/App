package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final /* synthetic */ class zzcpv implements Runnable {
    public final /* synthetic */ zzcqd zza;
    public final /* synthetic */ Throwable zzb;

    public /* synthetic */ zzcpv(zzcqd zzcqd, Throwable th) {
        this.zza = zzcqd;
        this.zzb = th;
    }

    public final void run() {
        this.zza.zzh(this.zzb);
    }
}
