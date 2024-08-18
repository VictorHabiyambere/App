package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.zzu;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzckf implements zzhkp {
    private final zzhlg zza;
    private final zzhlg zzb;

    public zzckf(zzhlg zzhlg, zzhlg zzhlg2) {
        this.zza = zzhlg;
        this.zzb = zzhlg2;
    }

    /* renamed from: zza */
    public final zzbxo zzb() {
        Context zza2 = ((zzcjj) this.zza).zza();
        zzfmq zzfmq = (zzfmq) this.zzb.zzb();
        zzu.zzf().zzb(zza2, VersionInfoParcel.forPackage(), zzfmq).zza("google.afma.request.getAdDictionary", zzbqe.zza, zzbqe.zza);
        zzbqh zzb2 = zzu.zzf().zzb(zza2, VersionInfoParcel.forPackage(), zzfmq);
        zzbqb zzbqb = zzbqe.zza;
        return new zzbxq(zza2, zzb2.zza("google.afma.sdkConstants.getSdkConstants", zzbqb, zzbqb), VersionInfoParcel.forPackage());
    }
}
