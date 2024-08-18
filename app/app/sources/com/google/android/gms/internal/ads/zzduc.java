package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.client.zzba;
import java.util.Collections;
import java.util.Map;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzduc implements zzhkp {
    private final zzhlg zza;
    private final zzhlg zzb;
    private final zzhlg zzc;
    private final zzhlg zzd;

    public zzduc(zzhlg zzhlg, zzhlg zzhlg2, zzhlg zzhlg3, zzhlg zzhlg4) {
        this.zza = zzhlg;
        this.zzb = zzhlg2;
        this.zzc = zzhlg3;
        this.zzd = zzhlg4;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        Set set;
        String str = (String) this.zza.zzb();
        Context zza2 = ((zzcjj) this.zzb).zza();
        zzgge zzgge = zzcci.zza;
        zzhkx.zzb(zzgge);
        Map zzd2 = ((zzhkt) this.zzd).zzb();
        if (((Boolean) zzba.zzc().zza(zzbep.zzeT)).booleanValue()) {
            zzbdm zzbdm = new zzbdm(new zzbdu(zza2));
            zzbdm.zzc(new zzdud(str));
            set = Collections.singleton(new zzdha(new zzduf(zzbdm, zzd2), zzgge));
        } else {
            set = Collections.emptySet();
        }
        zzhkx.zzb(set);
        return set;
    }
}
