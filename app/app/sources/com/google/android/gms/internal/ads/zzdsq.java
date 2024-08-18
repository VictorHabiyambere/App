package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzba;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzdsq {
    private final Map zza = new HashMap();

    zzdsq() {
    }

    @Nullable
    public final synchronized zzdsp zza(String str) {
        return (zzdsp) this.zza.get(str);
    }

    public final String zzb(String str) {
        zzbtt zzbtt;
        zzdsp zza2 = zza(str);
        if (zza2 == null || (zzbtt = zza2.zzb) == null) {
            return "";
        }
        return zzbtt.toString();
    }

    /* access modifiers changed from: package-private */
    public final synchronized void zzc(String str, @Nullable zzfim zzfim) {
        zzbtt zzbtt;
        if (!this.zza.containsKey(str)) {
            zzbtt zzbtt2 = null;
            if (zzfim == null) {
                zzbtt = null;
            } else {
                try {
                    zzbtt = zzfim.zze();
                } catch (zzfhv e) {
                    zzbtt = null;
                }
            }
            if (zzfim != null) {
                try {
                    zzbtt2 = zzfim.zzf();
                } catch (zzfhv e2) {
                }
            }
            boolean z = true;
            if (((Boolean) zzba.zzc().zza(zzbep.zzjr)).booleanValue()) {
                if (zzfim == null) {
                    z = false;
                } else {
                    try {
                        zzfim.zzC();
                    } catch (zzfhv e3) {
                        z = false;
                    }
                }
            }
            this.zza.put(str, new zzdsp(str, zzbtt, zzbtt2, z));
        }
    }

    /* access modifiers changed from: package-private */
    public final synchronized void zzd(String str, zzbte zzbte) {
        if (!this.zza.containsKey(str)) {
            try {
                this.zza.put(str, new zzdsp(str, zzbte.zzf(), zzbte.zzg(), true));
            } catch (Throwable th) {
            }
        }
    }
}
