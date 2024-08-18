package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final /* synthetic */ class zzchu implements Runnable {
    public final /* synthetic */ zzchv zza;
    public final /* synthetic */ zzehe zzb;

    public /* synthetic */ zzchu(zzchv zzchv, zzehe zzehe) {
        this.zza = zzchv;
        this.zzb = zzehe;
    }

    public final void run() {
        this.zzb.zzf(new zzchs(this.zza));
    }
}
