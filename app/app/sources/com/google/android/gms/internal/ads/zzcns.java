package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final /* synthetic */ class zzcns implements Runnable {
    public final /* synthetic */ zzcnt zza;
    public final /* synthetic */ Runnable zzb;

    public /* synthetic */ zzcns(zzcnt zzcnt, Runnable runnable) {
        this.zza = zzcnt;
        this.zzb = runnable;
    }

    public final void run() {
        this.zza.zzc(this.zzb);
    }
}
