package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final /* synthetic */ class zzqk implements Runnable {
    public final /* synthetic */ zzqn zza;
    public final /* synthetic */ boolean zzb;

    public /* synthetic */ zzqk(zzqn zzqn, boolean z) {
        this.zza = zzqn;
        this.zzb = z;
    }

    public final void run() {
        this.zza.zzt(this.zzb);
    }
}
