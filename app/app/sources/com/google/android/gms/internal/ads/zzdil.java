package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzdil implements zzhkp {
    private final zzdik zza;
    private final zzhlg zzb;

    public zzdil(zzdik zzdik, zzhlg zzhlg) {
        this.zza = zzdik;
        this.zzb = zzhlg;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        Set singleton = Collections.singleton(new zzdha((zzcyi) this.zzb.zzb(), zzcci.zzf));
        zzhkx.zzb(singleton);
        return singleton;
    }
}
