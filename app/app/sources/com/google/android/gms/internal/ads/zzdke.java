package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzdke implements zzhkp {
    private final zzhlg zza;

    public zzdke(zzhlg zzhlg) {
        this.zza = zzhlg;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        Set set;
        if (((zzdkb) this.zza).zza().zze() != null) {
            set = Collections.singleton("banner");
        } else {
            set = Collections.emptySet();
        }
        zzhkx.zzb(set);
        return set;
    }
}
