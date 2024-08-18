package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final /* synthetic */ class zzqj implements Runnable {
    public final /* synthetic */ zzqn zza;
    public final /* synthetic */ zzan zzb;
    public final /* synthetic */ zziy zzc;

    public /* synthetic */ zzqj(zzqn zzqn, zzan zzan, zziy zziy) {
        this.zza = zzqn;
        this.zzb = zzan;
        this.zzc = zziy;
    }

    public final void run() {
        this.zza.zzr(this.zzb, this.zzc);
    }
}
