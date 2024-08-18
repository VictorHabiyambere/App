package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final /* synthetic */ class zzqh implements Runnable {
    public final /* synthetic */ zzqn zza;
    public final /* synthetic */ Exception zzb;

    public /* synthetic */ zzqh(zzqn zzqn, Exception exc) {
        this.zza = zzqn;
        this.zzb = exc;
    }

    public final void run() {
        this.zza.zzj(this.zzb);
    }
}
