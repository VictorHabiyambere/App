package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzba;
import java.util.Collections;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzcjp implements zzhkp {
    private final zzhlg zza;
    private final zzhlg zzb;

    public zzcjp(zzhlg zzhlg, zzhlg zzhlg2) {
        this.zza = zzhlg;
        this.zzb = zzhlg2;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        Set set;
        zzdxh zzdxh = (zzdxh) this.zza.zzb();
        zzgge zzgge = zzcci.zza;
        zzhkx.zzb(zzgge);
        if (((Boolean) zzba.zzc().zza(zzbep.zzbE)).booleanValue()) {
            set = Collections.singleton(new zzdha(zzdxh, zzgge));
        } else {
            set = Collections.emptySet();
        }
        zzhkx.zzb(set);
        return set;
    }
}
