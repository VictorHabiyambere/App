package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzeqv implements zzhkp {
    private final zzhlg zza;
    private final zzhlg zzb;
    private final zzhlg zzc;

    public zzeqv(zzhlg zzhlg, zzhlg zzhlg2, zzhlg zzhlg3) {
        this.zza = zzhlg;
        this.zzb = zzhlg2;
        this.zzc = zzhlg3;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        zzgge zzgge = zzcci.zza;
        zzhkx.zzb(zzgge);
        return new zzequ((ListenableFuture) this.zza.zzb(), zzgge, (ScheduledExecutorService) this.zzc.zzb());
    }
}
