package com.google.android.gms.internal.ads;

import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final /* synthetic */ class zzdxa implements Runnable {
    public final /* synthetic */ zzdxf zza;
    public final /* synthetic */ String zzb;
    public final /* synthetic */ zzbnr zzc;
    public final /* synthetic */ zzfim zzd;
    public final /* synthetic */ List zze;

    public /* synthetic */ zzdxa(zzdxf zzdxf, String str, zzbnr zzbnr, zzfim zzfim, List list) {
        this.zza = zzdxf;
        this.zzb = str;
        this.zzc = zzbnr;
        this.zzd = zzfim;
        this.zze = list;
    }

    public final void run() {
        this.zza.zzn(this.zzb, this.zzc, this.zzd, this.zze);
    }
}
