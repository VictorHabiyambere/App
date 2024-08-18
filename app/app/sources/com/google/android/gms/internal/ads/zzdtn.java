package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzba;
import java.util.Collections;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzdtn implements zzhkp {
    private final zzhlg zza;
    private final zzhlg zzb;

    public zzdtn(zzhlg zzhlg, zzhlg zzhlg2) {
        this.zza = zzhlg;
        this.zzb = zzhlg2;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        Set set;
        zzgge zzgge = zzcci.zza;
        zzhkx.zzb(zzgge);
        zzduf zza2 = ((zzdug) this.zzb).zzb();
        if (((Boolean) zzba.zzc().zza(zzbep.zzeT)).booleanValue()) {
            set = Collections.singleton(new zzdha(zza2, zzgge));
        } else {
            set = Collections.emptySet();
        }
        zzhkx.zzb(set);
        return set;
    }
}
