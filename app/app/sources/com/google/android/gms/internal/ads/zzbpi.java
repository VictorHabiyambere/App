package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zze;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
final class zzbpi implements zzccr {
    final /* synthetic */ zzbps zza;
    final /* synthetic */ zzfmc zzb;
    final /* synthetic */ zzbpt zzc;

    zzbpi(zzbpt zzbpt, zzbps zzbps, zzfmc zzfmc) {
        this.zza = zzbps;
        this.zzb = zzfmc;
        this.zzc = zzbpt;
    }

    public final /* bridge */ /* synthetic */ void zza(Object obj) {
        zzboo zzboo = (zzboo) obj;
        zze.zza("loadNewJavascriptEngine (success): Trying to acquire lock");
        synchronized (this.zzc.zza) {
            zze.zza("loadNewJavascriptEngine (success): Lock acquired");
            this.zzc.zzi = 0;
            zzbpt zzbpt = this.zzc;
            if (!(zzbpt.zzh == null || this.zza == zzbpt.zzh)) {
                zze.zza("New JS engine is loaded, marking previous one as destroyable.");
                this.zzc.zzh.zzb();
            }
            this.zzc.zzh = this.zza;
            if (((Boolean) zzbgd.zzd.zze()).booleanValue()) {
                zzbpt zzbpt2 = this.zzc;
                if (zzbpt2.zze != null) {
                    zzfmq zze = zzbpt2.zze;
                    zzfmc zzfmc = this.zzb;
                    zzfmc.zzh(true);
                    zze.zzb(zzfmc.zzn());
                }
            }
        }
        zze.zza("loadNewJavascriptEngine (success): Lock released");
    }
}
