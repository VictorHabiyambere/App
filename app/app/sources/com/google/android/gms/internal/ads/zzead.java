package com.google.android.gms.internal.ads;

import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzead implements zzhkp {
    private final zzhlg zza;
    private final zzhlg zzb;
    private final zzhlg zzc;
    private final zzhlg zzd;
    private final zzhlg zze;

    public zzead(zzhlg zzhlg, zzhlg zzhlg2, zzhlg zzhlg3, zzhlg zzhlg4, zzhlg zzhlg5) {
        this.zza = zzhlg;
        this.zzb = zzhlg2;
        this.zzc = zzhlg3;
        this.zzd = zzhlg4;
        this.zze = zzhlg5;
    }

    /* renamed from: zza */
    public final zzeac zzb() {
        zzgge zzgge = zzcci.zza;
        zzhkx.zzb(zzgge);
        zzgge zzgge2 = zzcci.zzb;
        zzhkx.zzb(zzgge2);
        return new zzeac((ScheduledExecutorService) this.zza.zzb(), zzgge, zzgge2, ((zzeav) this.zzd).zzb(), zzhko.zza(zzhla.zza(this.zze)));
    }
}
