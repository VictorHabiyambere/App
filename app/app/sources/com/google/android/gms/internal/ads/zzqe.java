package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final /* synthetic */ class zzqe implements Runnable {
    public final /* synthetic */ zzqn zza;
    public final /* synthetic */ int zzb;
    public final /* synthetic */ long zzc;
    public final /* synthetic */ long zzd;

    public /* synthetic */ zzqe(zzqn zzqn, int i, long j, long j2) {
        this.zza = zzqn;
        this.zzb = i;
        this.zzc = j;
        this.zzd = j2;
    }

    public final void run() {
        this.zza.zzu(this.zzb, this.zzc, this.zzd);
    }
}
