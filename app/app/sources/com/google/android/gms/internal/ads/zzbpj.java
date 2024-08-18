package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zze;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
final class zzbpj implements zzccp {
    final /* synthetic */ zzbps zza;
    final /* synthetic */ zzfmc zzb;
    final /* synthetic */ zzbpt zzc;

    zzbpj(zzbpt zzbpt, zzbps zzbps, zzfmc zzfmc) {
        this.zza = zzbps;
        this.zzb = zzfmc;
        this.zzc = zzbpt;
    }

    public final void zza() {
        zze.zza("loadNewJavascriptEngine (failure): Trying to acquire lock");
        synchronized (this.zzc.zza) {
            zze.zza("loadNewJavascriptEngine (failure): Lock acquired");
            this.zzc.zzi = 1;
            zze.zza("Failed loading new engine. Marking new engine destroyable.");
            this.zza.zzb();
            if (((Boolean) zzbgd.zzd.zze()).booleanValue()) {
                zzbpt zzbpt = this.zzc;
                if (zzbpt.zze != null) {
                    zzfmq zze = zzbpt.zze;
                    zzfmc zzfmc = this.zzb;
                    zzfmc.zzc("Failed loading new engine");
                    zzfmc.zzh(false);
                    zze.zzb(zzfmc.zzn());
                }
            }
        }
        zze.zza("loadNewJavascriptEngine (failure): Lock released");
    }
}
