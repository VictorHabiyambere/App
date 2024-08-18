package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzba;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzcxp implements zzhkp {
    private final zzhlg zza;
    private final zzhlg zzb;

    public zzcxp(zzhlg zzhlg, zzhlg zzhlg2) {
        this.zza = zzhlg;
        this.zzb = zzhlg2;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        zzgbh zzgbh;
        zzcws zzcws = (zzcws) this.zza.zzb();
        zzgge zzgge = zzcci.zza;
        zzhkx.zzb(zzgge);
        if (((Boolean) zzba.zzc().zza(zzbep.zzfK)).booleanValue()) {
            zzgbh = zzgbh.zzo(new zzdha(zzcws, zzgge));
        } else {
            zzgbh = zzgbh.zzn();
        }
        zzhkx.zzb(zzgbh);
        return zzgbh;
    }
}
