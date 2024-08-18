package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzeia implements zzehr {
    private final Context zza;
    private final zzcrt zzb;
    private final Executor zzc;

    zzeia(Context context, zzcrt zzcrt, Executor executor) {
        this.zza = context;
        this.zzb = zzcrt;
        this.zzc = executor;
    }

    public final /* bridge */ /* synthetic */ Object zza(zzfhf zzfhf, zzfgt zzfgt, zzeho zzeho) throws zzfhv, zzelj {
        zzcrq zza2 = this.zzb.zza(new zzcvf(zzfhf, zzfgt, zzeho.zza), new zzdik(new zzehz(zzeho), (zzchd) null), new zzcrr(zzfgt.zzab));
        zza2.zzd().zzo(new zzcpt((zzfim) zzeho.zzb), this.zzc);
        ((zzejh) zzeho.zzc).zzc(zza2.zzk());
        return zza2.zza();
    }

    public final void zzb(zzfhf zzfhf, zzfgt zzfgt, zzeho zzeho) throws zzfhv {
        zzfho zzfho = zzfhf.zza.zza;
        ((zzfim) zzeho.zzb).zzl(this.zza, zzfho.zzd, zzfgt.zzw.toString(), (zzbrl) zzeho.zzc);
    }
}
