package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzhk implements zzha {
    private final zzhy zza = new zzhy();
    private zzie zzb;
    private String zzc;
    private int zzd = 8000;
    private int zze = 8000;
    private boolean zzf;

    public final zzhk zzb(boolean z) {
        this.zzf = true;
        return this;
    }

    public final zzhk zzc(int i) {
        this.zzd = i;
        return this;
    }

    public final zzhk zzd(int i) {
        this.zze = i;
        return this;
    }

    public final zzhk zze(zzie zzie) {
        this.zzb = zzie;
        return this;
    }

    public final zzhk zzf(String str) {
        this.zzc = str;
        return this;
    }

    /* renamed from: zzg */
    public final zzhp zza() {
        zzhp zzhp = new zzhp(this.zzc, this.zzd, this.zze, this.zzf, this.zza, (zzfyh) null, false, (zzho) null);
        zzie zzie = this.zzb;
        if (zzie != null) {
            zzhp.zzf(zzie);
        }
        return zzhp;
    }
}
