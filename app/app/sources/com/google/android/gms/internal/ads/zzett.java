package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.util.zzt;
import com.google.android.gms.ads.internal.zzu;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzett implements zzhkp {
    private final zzhlg zza;
    private final zzhlg zzb;

    public zzett(zzhlg zzhlg, zzhlg zzhlg2) {
        this.zza = zzhlg;
        this.zzb = zzhlg2;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        zzgbh zzgbh;
        zzeut zza2 = ((zzeuv) this.zza).zzb();
        Context zza3 = ((zzcjj) this.zzb).zza();
        if (((Boolean) zzba.zzc().zza(zzbep.zzlr)).booleanValue()) {
            zzu.zzp();
            if (zzt.zzB(zza3)) {
                zzgbh = zzgbh.zzo(zza2);
                zzhkx.zzb(zzgbh);
                return zzgbh;
            }
        }
        zzgbh = zzgbh.zzn();
        zzhkx.zzb(zzgbh);
        return zzgbh;
    }
}
