package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzmr {
    public static final zzmr zza = new zzmr(0, 0);
    public static final zzmr zzb = new zzmr(Long.MAX_VALUE, Long.MAX_VALUE);
    public static final zzmr zzc = new zzmr(Long.MAX_VALUE, 0);
    public static final zzmr zzd = new zzmr(0, Long.MAX_VALUE);
    public static final zzmr zze = zza;
    public final long zzf;
    public final long zzg;

    public zzmr(long j, long j2) {
        boolean z;
        boolean z2 = true;
        if (j >= 0) {
            z = true;
        } else {
            z = false;
        }
        zzeq.zzd(z);
        zzeq.zzd(j2 < 0 ? false : z2);
        this.zzf = j;
        this.zzg = j2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            zzmr zzmr = (zzmr) obj;
            return this.zzf == zzmr.zzf && this.zzg == zzmr.zzg;
        }
    }

    public final int hashCode() {
        return (((int) this.zzf) * 31) + ((int) this.zzg);
    }
}
