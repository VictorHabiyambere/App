package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzq;
import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final /* synthetic */ class zzdoo implements zzgfa {
    public final /* synthetic */ zzdow zza;
    public final /* synthetic */ zzq zzb;
    public final /* synthetic */ zzfgt zzc;
    public final /* synthetic */ zzfgw zzd;
    public final /* synthetic */ String zze;
    public final /* synthetic */ String zzf;

    public /* synthetic */ zzdoo(zzdow zzdow, zzq zzq, zzfgt zzfgt, zzfgw zzfgw, String str, String str2) {
        this.zza = zzdow;
        this.zzb = zzq;
        this.zzc = zzfgt;
        this.zzd = zzfgw;
        this.zze = str;
        this.zzf = str2;
    }

    public final ListenableFuture zza(Object obj) {
        return this.zza.zzb(this.zzb, this.zzc, this.zzd, this.zze, this.zzf, obj);
    }
}
