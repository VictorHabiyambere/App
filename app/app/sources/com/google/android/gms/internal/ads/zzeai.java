package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzeai implements zzhkp {
    private final zzhlg zza;
    private final zzhlg zzb;
    private final zzhlg zzc;
    private final zzhlg zzd;
    private final zzhlg zze;
    private final zzhlg zzf;
    private final zzhlg zzg;

    public zzeai(zzhlg zzhlg, zzhlg zzhlg2, zzhlg zzhlg3, zzhlg zzhlg4, zzhlg zzhlg5, zzhlg zzhlg6, zzhlg zzhlg7) {
        this.zza = zzhlg;
        this.zzb = zzhlg2;
        this.zzc = zzhlg3;
        this.zzd = zzhlg4;
        this.zze = zzhlg5;
        this.zzf = zzhlg6;
        this.zzg = zzhlg7;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        Context zza2 = ((zzcjj) this.zza).zza();
        zzfho zza3 = ((zzczc) this.zzb).zza();
        zzdzi zza4 = ((zzdzj) this.zzc).zzb();
        zzgge zzgge = zzcci.zza;
        zzhkx.zzb(zzgge);
        return new zzeah(zza2, zza3, zza4, zzgge, (ScheduledExecutorService) this.zze.zzb(), (zzeev) this.zzf.zzb(), (zzfmn) this.zzg.zzb());
    }
}
