package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final /* synthetic */ class zzeml implements Runnable {
    public final /* synthetic */ zzemm zza;
    public final /* synthetic */ zzfhf zzb;
    public final /* synthetic */ zzfgt zzc;
    public final /* synthetic */ zzeho zzd;

    public /* synthetic */ zzeml(zzemm zzemm, zzfhf zzfhf, zzfgt zzfgt, zzeho zzeho) {
        this.zza = zzemm;
        this.zzb = zzfhf;
        this.zzc = zzfgt;
        this.zzd = zzeho;
    }

    public final void run() {
        zzemo.zze(this.zzb, this.zzc, this.zzd);
    }
}
