package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.client.zzm;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzemo implements zzehr {
    private final Context zza;
    /* access modifiers changed from: private */
    public final Executor zzb;
    private final zzdrm zzc;

    public zzemo(Context context, Executor executor, zzdrm zzdrm) {
        this.zza = context;
        this.zzb = executor;
        this.zzc = zzdrm;
    }

    /* access modifiers changed from: private */
    public static final void zze(zzfhf zzfhf, zzfgt zzfgt, zzeho zzeho) {
        try {
            ((zzfim) zzeho.zzb).zzk(zzfhf.zza.zza.zzd, zzfgt.zzw.toString());
        } catch (Exception e) {
            zzm.zzk("Fail to load ad from adapter ".concat(String.valueOf(zzeho.zza)), e);
        }
    }

    public final /* bridge */ /* synthetic */ Object zza(zzfhf zzfhf, zzfgt zzfgt, zzeho zzeho) throws zzfhv, zzelj {
        zzdri zze = this.zzc.zze(new zzcvf(zzfhf, zzfgt, zzeho.zza), new zzdrj(new zzemk(zzeho)));
        zze.zzd().zzo(new zzcpt((zzfim) zzeho.zzb), this.zzb);
        zzdas zze2 = zze.zze();
        zzczj zzb2 = zze.zzb();
        ((zzeji) zzeho.zzc).zzc(new zzemn(this, zze.zza(), zzb2, zze2, zze.zzg()));
        return zze.zzi();
    }

    public final void zzb(zzfhf zzfhf, zzfgt zzfgt, zzeho zzeho) throws zzfhv {
        if (!((zzfim) zzeho.zzb).zzC()) {
            ((zzeji) zzeho.zzc).zzd(new zzemm(this, zzfhf, zzfgt, zzeho));
            Object obj = zzeho.zzb;
            Context context = this.zza;
            zzfho zzfho = zzfhf.zza.zza;
            String jSONObject = zzfgt.zzw.toString();
            ((zzfim) obj).zzh(context, zzfho.zzd, (String) null, (zzbys) zzeho.zzc, jSONObject);
            return;
        }
        zze(zzfhf, zzfgt, zzeho);
    }
}
