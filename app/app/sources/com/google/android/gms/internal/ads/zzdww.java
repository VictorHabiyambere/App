package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final /* synthetic */ class zzdww implements Runnable {
    public final /* synthetic */ zzdxf zza;
    public final /* synthetic */ Object zzb;
    public final /* synthetic */ zzccn zzc;
    public final /* synthetic */ String zzd;
    public final /* synthetic */ long zze;
    public final /* synthetic */ zzfmc zzf;

    public /* synthetic */ zzdww(zzdxf zzdxf, Object obj, zzccn zzccn, String str, long j, zzfmc zzfmc) {
        this.zza = zzdxf;
        this.zzb = obj;
        this.zzc = zzccn;
        this.zzd = str;
        this.zze = j;
        this.zzf = zzfmc;
    }

    public final void run() {
        this.zza.zzq(this.zzb, this.zzc, this.zzd, this.zze, this.zzf);
    }
}
