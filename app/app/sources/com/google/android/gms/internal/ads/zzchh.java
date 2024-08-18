package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final /* synthetic */ class zzchh implements Runnable {
    public final /* synthetic */ zzchl zza;
    public final /* synthetic */ boolean zzb;
    public final /* synthetic */ long zzc;

    public /* synthetic */ zzchh(zzchl zzchl, boolean z, long j) {
        this.zza = zzchl;
        this.zzb = z;
        this.zzc = j;
    }

    public final void run() {
        this.zza.zzo(this.zzb, this.zzc);
    }
}
