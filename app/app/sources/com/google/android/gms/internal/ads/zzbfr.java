package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.nonagon.signalgeneration.zze;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzbfr implements zzhkp {
    private final zzhlg zza;
    private final zzhlg zzb;

    public zzbfr(zzhlg zzhlg, zzhlg zzhlg2) {
        this.zza = zzhlg;
        this.zzb = zzhlg2;
    }

    /* renamed from: zza */
    public final zzbfq zzb() {
        return new zzbfq((ScheduledExecutorService) this.zza.zzb(), (zze) this.zzb.zzb());
    }
}
