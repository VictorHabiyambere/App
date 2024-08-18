package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final /* synthetic */ class zzzq implements Runnable {
    public final /* synthetic */ zzzr zza;
    public final /* synthetic */ int zzb;
    public final /* synthetic */ long zzc;
    public final /* synthetic */ long zzd;

    public /* synthetic */ zzzq(zzzr zzzr, int i, long j, long j2) {
        this.zza = zzzr;
        this.zzb = i;
        this.zzc = j;
        this.zzd = j2;
    }

    public final void run() {
        this.zza.zzb.zzX(this.zzb, this.zzc, this.zzd);
    }
}
