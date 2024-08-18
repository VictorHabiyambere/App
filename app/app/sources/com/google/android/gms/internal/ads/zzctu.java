package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final /* synthetic */ class zzctu implements Runnable {
    public final /* synthetic */ zzctv zza;
    public final /* synthetic */ Runnable zzb;

    public /* synthetic */ zzctu(zzctv zzctv, Runnable runnable) {
        this.zza = zzctv;
        this.zzb = runnable;
    }

    public final void run() {
        this.zza.zzk(this.zzb);
    }
}
