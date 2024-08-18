package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzba;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzeto implements zzhkp {
    private final zzhlg zza;
    private final zzhlg zzb;

    public zzeto(zzhlg zzhlg, zzhlg zzhlg2) {
        this.zza = zzhlg;
        this.zzb = zzhlg2;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        zzgbh zzgbh;
        zzesw zza2 = zzesy.zza();
        ScheduledExecutorService scheduledExecutorService = (ScheduledExecutorService) this.zzb.zzb();
        if (((Boolean) zzba.zzc().zza(zzbep.zzea)).booleanValue()) {
            zzgbh = zzgbh.zzo(new zzewe(zza2, (long) ((Integer) zzba.zzc().zza(zzbep.zzeb)).intValue(), scheduledExecutorService));
        } else {
            zzgbh = zzgbh.zzn();
        }
        zzhkx.zzb(zzgbh);
        return zzgbh;
    }
}
