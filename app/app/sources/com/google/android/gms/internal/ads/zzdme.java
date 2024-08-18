package com.google.android.gms.internal.ads;

import androidx.collection.SimpleArrayMap;
import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzdme {
    public static final zzdme zza = new zzdme(new zzdmc());
    private final zzbiw zzb;
    private final zzbit zzc;
    private final zzbjj zzd;
    private final zzbjg zze;
    private final zzboi zzf;
    private final SimpleArrayMap zzg;
    private final SimpleArrayMap zzh;

    private zzdme(zzdmc zzdmc) {
        this.zzb = zzdmc.zza;
        this.zzc = zzdmc.zzb;
        this.zzd = zzdmc.zzc;
        this.zzg = new SimpleArrayMap(zzdmc.zzf);
        this.zzh = new SimpleArrayMap(zzdmc.zzg);
        this.zze = zzdmc.zzd;
        this.zzf = zzdmc.zze;
    }

    public final zzbit zza() {
        return this.zzc;
    }

    public final zzbiw zzb() {
        return this.zzb;
    }

    public final zzbiz zzc(String str) {
        return (zzbiz) this.zzh.get(str);
    }

    public final zzbjc zzd(String str) {
        return (zzbjc) this.zzg.get(str);
    }

    public final zzbjg zze() {
        return this.zze;
    }

    public final zzbjj zzf() {
        return this.zzd;
    }

    public final zzboi zzg() {
        return this.zzf;
    }

    public final ArrayList zzh() {
        ArrayList arrayList = new ArrayList(this.zzg.size());
        for (int i = 0; i < this.zzg.size(); i++) {
            arrayList.add((String) this.zzg.keyAt(i));
        }
        return arrayList;
    }

    public final ArrayList zzi() {
        ArrayList arrayList = new ArrayList();
        if (this.zzd != null) {
            arrayList.add(Integer.toString(6));
        }
        if (this.zzb != null) {
            arrayList.add(Integer.toString(1));
        }
        if (this.zzc != null) {
            arrayList.add(Integer.toString(2));
        }
        if (!this.zzg.isEmpty()) {
            arrayList.add(Integer.toString(3));
        }
        if (this.zzf != null) {
            arrayList.add(Integer.toString(7));
        }
        return arrayList;
    }
}
