package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.zzg;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzeyp implements zzhkp {
    private final zzhlg zza;
    private final zzhlg zzb;
    private final zzhlg zzc;
    private final zzhlg zzd;
    private final zzhlg zze;
    private final zzhlg zzf;
    private final zzhlg zzg;

    public zzeyp(zzhlg zzhlg, zzhlg zzhlg2, zzhlg zzhlg3, zzhlg zzhlg4, zzhlg zzhlg5, zzhlg zzhlg6, zzhlg zzhlg7) {
        this.zza = zzhlg;
        this.zzb = zzhlg2;
        this.zzc = zzhlg3;
        this.zzd = zzhlg4;
        this.zze = zzhlg5;
        this.zzf = zzhlg6;
        this.zzg = zzhlg7;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        zzg zza2 = ((zzcjh) this.zza).zzb();
        Context zza3 = ((zzcjj) this.zzb).zza();
        zzgge zzgge = zzcci.zza;
        zzhkx.zzb(zzgge);
        return new zzeym(zza2, zza3, zzgge, (ScheduledExecutorService) this.zzd.zzb(), ((zzehk) this.zze).zzb(), ((zzczc) this.zzf).zza(), ((zzcjv) this.zzg).zza());
    }
}
