package com.google.android.gms.ads.internal;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final /* synthetic */ class zzh implements Runnable {
    public final /* synthetic */ zzj zza;
    public final /* synthetic */ boolean zzb;

    public /* synthetic */ zzh(zzj zzj, boolean z) {
        this.zza = zzj;
        this.zzb = z;
    }

    public final void run() {
        this.zza.zzb(this.zzb);
    }
}
