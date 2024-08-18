package com.google.android.gms.internal.ads;

import android.content.Context;
import java.lang.ref.WeakReference;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzdxg implements zzhkp {
    private final zzhlg zza;
    private final zzhlg zzb;
    private final zzhlg zzc;
    private final zzhlg zzd;
    private final zzhlg zze;
    private final zzhlg zzf;
    private final zzhlg zzg;
    private final zzhlg zzh;
    private final zzhlg zzi;
    private final zzhlg zzj;

    public zzdxg(zzhlg zzhlg, zzhlg zzhlg2, zzhlg zzhlg3, zzhlg zzhlg4, zzhlg zzhlg5, zzhlg zzhlg6, zzhlg zzhlg7, zzhlg zzhlg8, zzhlg zzhlg9, zzhlg zzhlg10) {
        this.zza = zzhlg;
        this.zzb = zzhlg2;
        this.zzc = zzhlg3;
        this.zzd = zzhlg4;
        this.zze = zzhlg5;
        this.zzf = zzhlg6;
        this.zzg = zzhlg7;
        this.zzh = zzhlg8;
        this.zzi = zzhlg9;
        this.zzj = zzhlg10;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        Context zza2 = ((zzcjj) this.zzb).zza();
        WeakReference zza3 = ((zzcjk) this.zzc).zza();
        zzgge zzgge = zzcci.zza;
        zzhkx.zzb(zzgge);
        return new zzdxf((Executor) this.zza.zzb(), zza2, zza3, zzgge, (zzdst) this.zze.zzb(), (ScheduledExecutorService) this.zzf.zzb(), (zzdvm) this.zzg.zzb(), ((zzcjv) this.zzh).zza(), ((zzdgi) this.zzi).zzb(), (zzfmq) this.zzj.zzb());
    }
}
