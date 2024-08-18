package com.google.android.gms.internal.ads;

import androidx.collection.SimpleArrayMap;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzdmc {
    zzbiw zza;
    zzbit zzb;
    zzbjj zzc;
    zzbjg zzd;
    zzboi zze;
    final SimpleArrayMap zzf = new SimpleArrayMap();
    final SimpleArrayMap zzg = new SimpleArrayMap();

    public final zzdmc zza(zzbit zzbit) {
        this.zzb = zzbit;
        return this;
    }

    public final zzdmc zzb(zzbiw zzbiw) {
        this.zza = zzbiw;
        return this;
    }

    public final zzdmc zzc(String str, zzbjc zzbjc, zzbiz zzbiz) {
        this.zzf.put(str, zzbjc);
        if (zzbiz != null) {
            this.zzg.put(str, zzbiz);
        }
        return this;
    }

    public final zzdmc zzd(zzboi zzboi) {
        this.zze = zzboi;
        return this;
    }

    public final zzdmc zze(zzbjg zzbjg) {
        this.zzd = zzbjg;
        return this;
    }

    public final zzdmc zzf(zzbjj zzbjj) {
        this.zzc = zzbjj;
        return this;
    }

    public final zzdme zzg() {
        return new zzdme(this);
    }
}
