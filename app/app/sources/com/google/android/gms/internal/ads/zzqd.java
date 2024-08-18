package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final /* synthetic */ class zzqd implements Runnable {
    public final /* synthetic */ zzqn zza;
    public final /* synthetic */ long zzb;

    public /* synthetic */ zzqd(zzqn zzqn, long j) {
        this.zza = zzqn;
        this.zzb = j;
    }

    public final void run() {
        this.zza.zzs(this.zzb);
    }
}
