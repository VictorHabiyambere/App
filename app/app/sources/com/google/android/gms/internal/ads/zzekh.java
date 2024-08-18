package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.zzbw;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzekh implements zzehr {
    private final Context zza;
    private final zzdkd zzb;
    private final Executor zzc;

    public zzekh(Context context, zzdkd zzdkd, Executor executor) {
        this.zza = context;
        this.zzb = zzdkd;
        this.zzc = executor;
    }

    private static final boolean zzc(zzfhf zzfhf, int i) {
        return zzfhf.zza.zza.zzg.contains(Integer.toString(i));
    }

    public final /* bridge */ /* synthetic */ Object zza(zzfhf zzfhf, zzfgt zzfgt, zzeho zzeho) throws zzfhv, zzelj {
        zzdlt zzdlt;
        zzbrq zzD = ((zzfim) zzeho.zzb).zzD();
        zzbrr zzE = ((zzfim) zzeho.zzb).zzE();
        zzbru zzd = ((zzfim) zzeho.zzb).zzd();
        if (zzd != null && zzc(zzfhf, 6)) {
            zzdlt = zzdlt.zzt(zzd);
        } else if (zzD != null && zzc(zzfhf, 6)) {
            zzdlt = zzdlt.zzai(zzD);
        } else if (zzD != null && zzc(zzfhf, 2)) {
            zzdlt = zzdlt.zzag(zzD);
        } else if (zzE != null && zzc(zzfhf, 6)) {
            zzdlt = zzdlt.zzaj(zzE);
        } else if (zzE == null || !zzc(zzfhf, 1)) {
            throw new zzelj(1, "No native ad mappers");
        } else {
            zzdlt = zzdlt.zzah(zzE);
        }
        zzfho zzfho = zzfhf.zza.zza;
        if (zzfho.zzg.contains(Integer.toString(zzdlt.zzc()))) {
            zzdlv zze = this.zzb.zze(new zzcvf(zzfhf, zzfgt, zzeho.zza), new zzdmf(zzdlt), new zzdnw(zzE, zzD, zzd));
            ((zzejh) zzeho.zzc).zzc(zze.zzk());
            zze.zzd().zzo(new zzcpt((zzfim) zzeho.zzb), this.zzc);
            return zze.zza();
        }
        throw new zzelj(1, "No corresponding native ad listener");
    }

    public final void zzb(zzfhf zzfhf, zzfgt zzfgt, zzeho zzeho) throws zzfhv {
        zzfho zzfho = zzfhf.zza.zza;
        zzfho zzfho2 = zzfhf.zza.zza;
        zzbhk zzbhk = zzfho2.zzi;
        ((zzfim) zzeho.zzb).zzp(this.zza, zzfho.zzd, zzfgt.zzw.toString(), zzbw.zzm(zzfgt.zzt), (zzbrl) zzeho.zzc, zzbhk, zzfho2.zzg);
    }
}
