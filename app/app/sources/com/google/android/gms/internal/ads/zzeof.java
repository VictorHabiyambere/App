package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.formats.AdManagerAdViewOptions;
import com.google.android.gms.ads.formats.PublisherAdViewOptions;
import com.google.android.gms.ads.internal.client.zzbh;
import com.google.android.gms.ads.internal.client.zzbn;
import com.google.android.gms.ads.internal.client.zzbp;
import com.google.android.gms.ads.internal.client.zzcf;
import com.google.android.gms.ads.internal.client.zzq;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzeof extends zzbp {
    final zzfhm zza = new zzfhm();
    final zzdmc zzb = new zzdmc();
    private final Context zzc;
    private final zzcjd zzd;
    private zzbh zze;

    public zzeof(zzcjd zzcjd, Context context, String str) {
        this.zzd = zzcjd;
        this.zza.zzt(str);
        this.zzc = context;
    }

    public final zzbn zze() {
        zzdme zzg = this.zzb.zzg();
        this.zza.zzE(zzg.zzi());
        this.zza.zzF(zzg.zzh());
        zzfhm zzfhm = this.zza;
        if (zzfhm.zzh() == null) {
            zzfhm.zzs(zzq.zzc());
        }
        return new zzeog(this.zzc, this.zzd, this.zza, zzg, this.zze);
    }

    public final void zzf(zzbit zzbit) {
        this.zzb.zza(zzbit);
    }

    public final void zzg(zzbiw zzbiw) {
        this.zzb.zzb(zzbiw);
    }

    public final void zzh(String str, zzbjc zzbjc, zzbiz zzbiz) {
        this.zzb.zzc(str, zzbjc, zzbiz);
    }

    public final void zzi(zzboi zzboi) {
        this.zzb.zzd(zzboi);
    }

    public final void zzj(zzbjg zzbjg, zzq zzq) {
        this.zzb.zze(zzbjg);
        this.zza.zzs(zzq);
    }

    public final void zzk(zzbjj zzbjj) {
        this.zzb.zzf(zzbjj);
    }

    public final void zzl(zzbh zzbh) {
        this.zze = zzbh;
    }

    public final void zzm(AdManagerAdViewOptions adManagerAdViewOptions) {
        this.zza.zzr(adManagerAdViewOptions);
    }

    public final void zzn(zzbnz zzbnz) {
        this.zza.zzw(zzbnz);
    }

    public final void zzo(zzbhk zzbhk) {
        this.zza.zzD(zzbhk);
    }

    public final void zzp(PublisherAdViewOptions publisherAdViewOptions) {
        this.zza.zzG(publisherAdViewOptions);
    }

    public final void zzq(zzcf zzcf) {
        this.zza.zzU(zzcf);
    }
}
