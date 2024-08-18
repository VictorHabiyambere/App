package com.google.android.gms.internal.ads;

import java.util.Set;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzdaa implements zzhkp {
    private final zzhlg zza;
    private final zzhlg zzb;
    private final zzhlg zzc;
    private final zzhlg zzd;

    public zzdaa(zzhlg zzhlg, zzhlg zzhlg2, zzhlg zzhlg3, zzhlg zzhlg4) {
        this.zza = zzhlg;
        this.zzb = zzhlg2;
        this.zzc = zzhlg3;
        this.zzd = zzhlg4;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        zzczx zza2 = ((zzczz) this.zza).zzb();
        Set zzc2 = ((zzhld) this.zzb).zzb();
        zzgge zzgge = zzcci.zza;
        zzhkx.zzb(zzgge);
        return new zzczy(zza2, zzc2, zzgge, (ScheduledExecutorService) this.zzd.zzb());
    }
}
