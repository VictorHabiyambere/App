package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzeyu implements zzhkp {
    private final zzhlg zza;
    private final zzhlg zzb;
    private final zzhlg zzc;
    private final zzhlg zzd;
    private final zzhlg zze;
    private final zzhlg zzf;
    private final zzhlg zzg;

    public zzeyu(zzhlg zzhlg, zzhlg zzhlg2, zzhlg zzhlg3, zzhlg zzhlg4, zzhlg zzhlg5, zzhlg zzhlg6, zzhlg zzhlg7) {
        this.zza = zzhlg;
        this.zzb = zzhlg2;
        this.zzc = zzhlg3;
        this.zzd = zzhlg4;
        this.zze = zzhlg5;
        this.zzf = zzhlg6;
        this.zzg = zzhlg7;
    }

    public static zzeys zza(zzcbp zzcbp, Context context, ScheduledExecutorService scheduledExecutorService, Executor executor, int i, boolean z, boolean z2) {
        return new zzeys(zzcbp, context, scheduledExecutorService, executor, i, z, z2);
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        zzgge zzgge = zzcci.zza;
        zzhkx.zzb(zzgge);
        return new zzeys(new zzcbp(), ((zzcjj) this.zzb).zza(), (ScheduledExecutorService) this.zzc.zzb(), zzgge, ((zzfba) this.zze).zzb().intValue(), ((zzfbb) this.zzf).zzb().booleanValue(), ((zzfbd) this.zzg).zzb().booleanValue());
    }
}
