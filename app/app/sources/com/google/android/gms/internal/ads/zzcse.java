package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzcse implements zzhkp {
    private final zzhlg zza;
    private final zzhlg zzb;

    public zzcse(zzhlg zzhlg, zzhlg zzhlg2) {
        this.zza = zzhlg;
        this.zzb = zzhlg2;
    }

    /* renamed from: zza */
    public final zzdca zzb() {
        return new zzdca((ScheduledExecutorService) this.zza.zzb(), (Clock) this.zzb.zzb());
    }
}
