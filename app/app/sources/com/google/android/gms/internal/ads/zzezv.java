package com.google.android.gms.internal.ads;

import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzezv implements zzhkp {
    private final zzhlg zza;
    private final zzhlg zzb;
    private final zzhlg zzc;
    private final zzhlg zzd;
    private final zzhlg zze;

    public zzezv(zzhlg zzhlg, zzhlg zzhlg2, zzhlg zzhlg3, zzhlg zzhlg4, zzhlg zzhlg5) {
        this.zza = zzhlg;
        this.zzb = zzhlg2;
        this.zzc = zzhlg3;
        this.zzd = zzhlg4;
        this.zze = zzhlg5;
    }

    public static zzezt zza(String str, zzbcp zzbcp, zzcby zzcby, ScheduledExecutorService scheduledExecutorService, zzgge zzgge) {
        return new zzezt(str, zzbcp, zzcby, scheduledExecutorService, zzgge);
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        zzgge zzgge = zzcci.zza;
        zzhkx.zzb(zzgge);
        return new zzezt(((zzfaz) this.zza).zza(), new zzbcp(), (zzcby) this.zzc.zzb(), (ScheduledExecutorService) this.zzd.zzb(), zzgge);
    }
}
