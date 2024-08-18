package com.google.android.gms.internal.ads;

import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzduf implements zzflu {
    private final Map zza;
    private final zzbdm zzb;

    zzduf(zzbdm zzbdm, Map map) {
        this.zza = map;
        this.zzb = zzbdm;
    }

    public final void zzd(zzfln zzfln, String str) {
        if (this.zza.containsKey(zzfln)) {
            this.zzb.zzb(((zzdue) this.zza.get(zzfln)).zzb);
        }
    }

    public final void zzdC(zzfln zzfln, String str) {
    }

    public final void zzdD(zzfln zzfln, String str, Throwable th) {
        if (this.zza.containsKey(zzfln)) {
            this.zzb.zzb(((zzdue) this.zza.get(zzfln)).zzc);
        }
    }

    public final void zzdE(zzfln zzfln, String str) {
        if (this.zza.containsKey(zzfln)) {
            this.zzb.zzb(((zzdue) this.zza.get(zzfln)).zza);
        }
    }
}
