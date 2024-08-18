package com.google.android.gms.ads.internal;

import com.google.android.gms.internal.ads.zzdvc;
import com.google.android.gms.internal.ads.zzfmc;
import com.google.android.gms.internal.ads.zzfmq;
import com.google.android.gms.internal.ads.zzgfa;
import com.google.common.util.concurrent.ListenableFuture;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final /* synthetic */ class zzd implements zzgfa {
    public final /* synthetic */ zzf zza;
    public final /* synthetic */ Long zzb;
    public final /* synthetic */ zzdvc zzc;
    public final /* synthetic */ zzfmq zzd;
    public final /* synthetic */ zzfmc zze;

    public /* synthetic */ zzd(zzf zzf, Long l, zzdvc zzdvc, zzfmq zzfmq, zzfmc zzfmc) {
        this.zza = zzf;
        this.zzb = l;
        this.zzc = zzdvc;
        this.zzd = zzfmq;
        this.zze = zzfmc;
    }

    public final ListenableFuture zza(Object obj) {
        return zzf.zzd(this.zzb, this.zzc, this.zzd, this.zze, (JSONObject) obj);
    }
}
