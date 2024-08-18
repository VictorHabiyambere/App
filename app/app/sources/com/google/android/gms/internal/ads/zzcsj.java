package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzcsj implements zzhkp {
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

    public zzcsj(zzhlg zzhlg, zzhlg zzhlg2, zzhlg zzhlg3, zzhlg zzhlg4, zzhlg zzhlg5, zzhlg zzhlg6, zzhlg zzhlg7, zzhlg zzhlg8, zzhlg zzhlg9, zzhlg zzhlg10) {
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

    public static zzcsi zzc(zzcuo zzcuo, Context context, zzfgu zzfgu, View view, zzchd zzchd, zzcun zzcun, zzdme zzdme, zzdhk zzdhk, zzhkj zzhkj, Executor executor) {
        return new zzcsi(zzcuo, context, zzfgu, view, zzchd, zzcun, zzdme, zzdhk, zzhkj, executor);
    }

    /* renamed from: zza */
    public final zzcsi zzb() {
        return new zzcsi(((zzcwz) this.zza).zzb(), (Context) this.zzb.zzb(), ((zzcsp) this.zzc).zza(), ((zzcso) this.zzd).zza(), ((zzctb) this.zze).zza(), ((zzcsq) this.zzf).zza(), ((zzdkb) this.zzg).zza(), (zzdhk) this.zzh.zzb(), zzhko.zza(zzhla.zza(this.zzi)), (Executor) this.zzj.zzb());
    }
}
