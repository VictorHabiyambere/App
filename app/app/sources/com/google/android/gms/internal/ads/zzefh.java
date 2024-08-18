package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.zzu;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzefh implements zzflu {
    private final zzeev zza;
    private final zzeez zzb;

    zzefh(zzeev zzeev, zzeez zzeez) {
        this.zza = zzeev;
        this.zzb = zzeez;
    }

    public final void zzd(zzfln zzfln, String str) {
        if (((Boolean) zzba.zzc().zza(zzbep.zzgs)).booleanValue() && zzfln.RENDERER == zzfln && this.zza.zzc() != 0) {
            this.zza.zzf(zzu.zzB().elapsedRealtime() - this.zza.zzc());
        }
    }

    public final void zzdC(zzfln zzfln, String str) {
    }

    public final void zzdD(zzfln zzfln, String str, Throwable th) {
        if (((Boolean) zzba.zzc().zza(zzbep.zzgs)).booleanValue() && zzfln.RENDERER == zzfln && this.zza.zzc() != 0) {
            this.zza.zzf(zzu.zzB().elapsedRealtime() - this.zza.zzc());
        }
    }

    public final void zzdE(zzfln zzfln, String str) {
        if (((Boolean) zzba.zzc().zza(zzbep.zzgs)).booleanValue()) {
            if (zzfln.RENDERER == zzfln) {
                this.zza.zzg(zzu.zzB().elapsedRealtime());
            } else if (zzfln.PRELOADED_LOADER == zzfln || zzfln.SERVER_TRANSACTION == zzfln) {
                this.zza.zzh(zzu.zzB().elapsedRealtime());
                zzeez zzeez = this.zzb;
                zzeez.zza.zza(new zzeey(zzeez, this.zza.zzd()));
            }
        }
    }
}
