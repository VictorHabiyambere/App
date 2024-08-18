package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final /* synthetic */ class zzcnr implements Runnable {
    public final /* synthetic */ zzcnt zza;
    public final /* synthetic */ Runnable zzb;

    public /* synthetic */ zzcnr(zzcnt zzcnt, Runnable runnable) {
        this.zza = zzcnt;
        this.zzb = runnable;
    }

    public final void run() {
        zzcci.zze.execute(new zzcns(this.zza, this.zzb));
    }
}
