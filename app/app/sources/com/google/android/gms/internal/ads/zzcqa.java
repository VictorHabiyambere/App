package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzba;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final /* synthetic */ class zzcqa implements Runnable {
    public final /* synthetic */ zzcqc zza;
    public final /* synthetic */ Throwable zzb;
    public final /* synthetic */ zzfoe zzc;
    public final /* synthetic */ String zzd;

    public /* synthetic */ zzcqa(zzcqc zzcqc, Throwable th, zzfoe zzfoe, String str) {
        this.zza = zzcqc;
        this.zzb = th;
        this.zzc = zzfoe;
        this.zzd = str;
    }

    public final void run() {
        boolean booleanValue = ((Boolean) zzba.zzc().zza(zzbep.zzko)).booleanValue();
        zzcqc zzcqc = this.zza;
        Throwable th = this.zzb;
        if (booleanValue) {
            zzcqd zzcqd = zzcqc.zzc;
            zzcqd.zzb = zzbwj.zzc(zzcqd.zzc);
            zzcqc.zzc.zzb.zzh(th, "AttributionReporting.registerSourceAndPingClickUrl");
        } else {
            zzcqd zzcqd2 = zzcqc.zzc;
            zzcqd2.zza = zzbwj.zza(zzcqd2.zzc);
            zzcqc.zzc.zza.zzh(th, "AttributionReportingSampled.registerSourceAndPingClickUrl");
        }
        this.zzc.zzc(this.zzd, (zzfmn) null);
    }
}
