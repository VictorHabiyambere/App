package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final /* synthetic */ class zzejc implements Runnable {
    public final /* synthetic */ zzejf zza;
    public final /* synthetic */ zzfhf zzb;
    public final /* synthetic */ zzfgt zzc;

    public /* synthetic */ zzejc(zzejf zzejf, zzfhf zzfhf, zzfgt zzfgt) {
        this.zza = zzejf;
        this.zzb = zzfhf;
        this.zzc = zzfgt;
    }

    public final void run() {
        this.zza.zzf(this.zzb, this.zzc);
    }
}
