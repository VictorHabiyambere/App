package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.client.zzm;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzels implements zzehr {
    private final Context zza;
    private final Executor zzb;
    private final zzdrm zzc;

    public zzels(Context context, Executor executor, zzdrm zzdrm) {
        this.zza = context;
        this.zzb = executor;
        this.zzc = zzdrm;
    }

    public final /* bridge */ /* synthetic */ Object zza(zzfhf zzfhf, zzfgt zzfgt, zzeho zzeho) throws zzfhv, zzelj {
        zzdri zze = this.zzc.zze(new zzcvf(zzfhf, zzfgt, zzeho.zza), new zzdrj(new zzelr(zzeho)));
        zze.zzd().zzo(new zzcpt((zzfim) zzeho.zzb), this.zzb);
        ((zzejh) zzeho.zzc).zzc(zze.zzn());
        return zze.zzi();
    }

    public final void zzb(zzfhf zzfhf, zzfgt zzfgt, zzeho zzeho) throws zzfhv {
        try {
            zzfho zzfho = zzfhf.zza.zza;
            if (zzfho.zzo.zza == 3) {
                ((zzfim) zzeho.zzb).zzr(this.zza, zzfho.zzd, zzfgt.zzw.toString(), (zzbrl) zzeho.zzc);
            } else {
                ((zzfim) zzeho.zzb).zzq(this.zza, zzfho.zzd, zzfgt.zzw.toString(), (zzbrl) zzeho.zzc);
            }
        } catch (Exception e) {
            zzm.zzk("Fail to load ad from adapter ".concat(String.valueOf(zzeho.zza)), e);
        }
    }
}
