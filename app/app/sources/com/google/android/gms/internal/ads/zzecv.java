package com.google.android.gms.internal.ads;

import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzecv implements zzhkp {
    private final zzhlg zza;
    private final zzhlg zzb;

    public zzecv(zzhlg zzhlg, zzhlg zzhlg2) {
        this.zza = zzhlg;
        this.zzb = zzhlg2;
    }

    /* renamed from: zza */
    public final zzecu zzb() {
        return new zzecu(((zzcjj) this.zza).zza(), (ScheduledExecutorService) this.zzb.zzb());
    }
}
