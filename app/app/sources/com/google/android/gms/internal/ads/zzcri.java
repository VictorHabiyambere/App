package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Set;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzcri implements zzhkp {
    private final zzhlg zza;
    private final zzhlg zzb;
    private final zzhlg zzc;

    public zzcri(zzhlg zzhlg, zzhlg zzhlg2, zzhlg zzhlg3) {
        this.zza = zzhlg;
        this.zzb = zzhlg2;
        this.zzc = zzhlg3;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        Set set;
        zzcra zzcra = (zzcra) this.zza.zzb();
        zzgge zzgge = zzcci.zza;
        zzhkx.zzb(zzgge);
        if (((JSONObject) this.zzc.zzb()) == null) {
            set = Collections.emptySet();
        } else {
            set = Collections.singleton(new zzdha(zzcra, zzgge));
        }
        zzhkx.zzb(set);
        return set;
    }
}
