package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzba;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzcwi implements zzhkp {
    private final zzhlg zza;

    public zzcwi(zzhlg zzhlg) {
        this.zza = zzhlg;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        zzgbh zzgbh;
        zzcwu zzcwu = (zzcwu) this.zza.zzb();
        if (((Boolean) zzba.zzc().zza(zzbep.zzfK)).booleanValue()) {
            zzgbh = zzgbh.zzo(new zzdha(zzcwu, zzcci.zzf));
        } else {
            zzgbh = zzgbh.zzn();
        }
        zzhkx.zzb(zzgbh);
        return zzgbh;
    }
}
