package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzba;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzeuc implements zzhkp {
    private final zzhlg zza;
    private final zzhlg zzb;

    public zzeuc(zzhlg zzhlg, zzhlg zzhlg2) {
        this.zza = zzhlg;
        this.zzb = zzhlg2;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzewe(((zzexu) this.zza).zzb(), (long) ((Integer) zzba.zzc().zza(zzbep.zzma)).intValue(), (ScheduledExecutorService) this.zzb.zzb());
    }
}
