package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzba;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzety implements zzhkp {
    private final zzhlg zza;
    private final zzhlg zzb;

    public zzety(zzhlg zzhlg, zzhlg zzhlg2) {
        this.zza = zzhlg;
        this.zzb = zzhlg2;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzewe(((zzewc) this.zza).zzb(), (long) ((Integer) zzba.zzc().zza(zzbep.zzmf)).intValue(), (ScheduledExecutorService) this.zzb.zzb());
    }
}
