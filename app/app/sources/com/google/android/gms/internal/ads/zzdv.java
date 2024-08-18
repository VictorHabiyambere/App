package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzdv {
    public static final zzdv zza = new zzdv(0, 0, 0, 1.0f);
    @Deprecated
    public static final zzn zzb = new zzdu();
    private static final String zzg = Integer.toString(0, 36);
    private static final String zzh = Integer.toString(1, 36);
    private static final String zzi = Integer.toString(2, 36);
    private static final String zzj = Integer.toString(3, 36);
    public final int zzc;
    public final int zzd;
    public final int zze = 0;
    public final float zzf;

    public zzdv(int i, int i2, int i3, float f) {
        this.zzc = i;
        this.zzd = i2;
        this.zzf = f;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzdv) {
            zzdv zzdv = (zzdv) obj;
            if (this.zzc == zzdv.zzc && this.zzd == zzdv.zzd) {
                int i = zzdv.zze;
                if (this.zzf == zzdv.zzf) {
                    return true;
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((((this.zzc + 217) * 31) + this.zzd) * 961) + Float.floatToRawIntBits(this.zzf);
    }
}
