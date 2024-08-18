package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zziy {
    public final String zza;
    public final zzan zzb;
    public final zzan zzc;
    public final int zzd;
    public final int zze;

    public zziy(String str, zzan zzan, zzan zzan2, int i, int i2) {
        boolean z = true;
        if (i != 0) {
            if (i2 == 0) {
                i2 = 0;
            } else {
                z = false;
            }
        }
        zzeq.zzd(z);
        zzeq.zzc(str);
        this.zza = str;
        this.zzb = zzan;
        if (zzan2 != null) {
            this.zzc = zzan2;
            this.zzd = i;
            this.zze = i2;
            return;
        }
        throw null;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        zziy zziy = (zziy) obj;
        return this.zzd == zziy.zzd && this.zze == zziy.zze && this.zza.equals(zziy.zza) && this.zzb.equals(zziy.zzb) && this.zzc.equals(zziy.zzc);
    }

    public final int hashCode() {
        return ((((((((this.zzd + 527) * 31) + this.zze) * 31) + this.zza.hashCode()) * 31) + this.zzb.hashCode()) * 31) + this.zzc.hashCode();
    }
}
