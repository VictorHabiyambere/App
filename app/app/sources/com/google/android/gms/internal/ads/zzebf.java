package com.google.android.gms.internal.ads;

import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzebf implements zzhkp {
    private final zzhlg zza;
    private final zzhlg zzb;
    private final zzhlg zzc;

    public zzebf(zzhlg zzhlg, zzhlg zzhlg2, zzhlg zzhlg3) {
        this.zza = zzhlg;
        this.zzb = zzhlg2;
        this.zzc = zzhlg3;
    }

    /* renamed from: zza */
    public final zzebe zzb() {
        Map zzd = ((zzhkw) this.zza).zzd();
        zzgge zzgge = zzcci.zza;
        zzhkx.zzb(zzgge);
        return new zzebe(zzd, zzgge, ((zzdcf) this.zzc).zzb());
    }
}
