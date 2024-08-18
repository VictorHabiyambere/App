package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final /* synthetic */ class zzdlk implements Runnable {
    public final /* synthetic */ zzdlo zza;
    public final /* synthetic */ boolean zzb;

    public /* synthetic */ zzdlk(zzdlo zzdlo, boolean z) {
        this.zza = zzdlo;
        this.zzb = z;
    }

    public final void run() {
        this.zza.zzy(this.zzb);
    }
}
