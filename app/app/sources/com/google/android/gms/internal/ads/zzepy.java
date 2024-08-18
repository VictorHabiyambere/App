package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zze;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
final class zzepy implements zzgfp {
    final /* synthetic */ zzepr zza;
    final /* synthetic */ zzfmn zzb;
    final /* synthetic */ zzfmc zzc;
    final /* synthetic */ zzdkd zzd;
    final /* synthetic */ zzepz zze;

    zzepy(zzepz zzepz, zzepr zzepr, zzfmn zzfmn, zzfmc zzfmc, zzdkd zzdkd) {
        this.zza = zzepr;
        this.zzb = zzfmn;
        this.zzc = zzfmc;
        this.zzd = zzdkd;
        this.zze = zzepz;
    }

    public final void zza(Throwable th) {
        zzfmn zzfmn;
        zze zza2 = this.zzd.zza().zza(th);
        this.zzd.zzb().zzdB(zza2);
        this.zze.zzb.zzB().execute(new zzepx(this, zza2));
        zzfil.zzb(zza2.zza, th, "NativeAdLoader.onFailure");
        this.zza.zza();
        if (!((Boolean) zzbgd.zzc.zze()).booleanValue() || (zzfmn = this.zzb) == null) {
            zzepz zzepz = this.zze;
            zzfmc zzfmc = this.zzc;
            zzfmq zze2 = zzepz.zze;
            zzfmc.zza(zza2);
            zzfmc.zzi(th);
            zzfmc.zzh(false);
            zze2.zzb(zzfmc.zzn());
            return;
        }
        zzfmn.zzc(zza2);
        zzfmc zzfmc2 = this.zzc;
        zzfmc2.zzi(th);
        zzfmc2.zzh(false);
        zzfmn.zza(zzfmc2);
        zzfmn.zzi();
    }

    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzfmn zzfmn;
        zzcup zzcup = (zzcup) obj;
        synchronized (this.zze) {
            zzcup.zzn().zza(this.zze.zzd.zzd());
            this.zza.zzb(zzcup);
            this.zze.zzb.zzB().execute(new zzepw(this));
            if (!((Boolean) zzbgd.zzc.zze()).booleanValue() || (zzfmn = this.zzb) == null) {
                zzfmq zze2 = this.zze.zze;
                zzfmc zzfmc = this.zzc;
                zzfmc.zzb(zzcup.zzp().zzb);
                zzfmc.zze(zzcup.zzl().zzg());
                zzfmc.zzh(true);
                zze2.zzb(zzfmc.zzn());
            } else {
                zzfmn.zzh(zzcup.zzp().zzb);
                zzfmn.zzf(zzcup.zzl().zzg());
                zzfmc zzfmc2 = this.zzc;
                zzfmc2.zzh(true);
                zzfmn.zza(zzfmc2);
                zzfmn.zzi();
            }
        }
    }
}
