package com.google.android.gms.internal.ads;

import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzdo {
    @Deprecated
    public static final zzn zza = new zzdn();
    private static final String zzc = Integer.toString(0, 36);
    private static final String zzd = Integer.toString(1, 36);
    private static final String zze = Integer.toString(3, 36);
    private static final String zzf = Integer.toString(4, 36);
    public final int zzb;
    private final zzde zzg;
    private final boolean zzh;
    private final int[] zzi;
    private final boolean[] zzj;

    public zzdo(zzde zzde, boolean z, int[] iArr, boolean[] zArr) {
        boolean z2;
        int i = zzde.zzb;
        this.zzb = i;
        boolean z3 = true;
        if (i == iArr.length && i == zArr.length) {
            z2 = true;
        } else {
            z2 = false;
        }
        zzeq.zzd(z2);
        this.zzg = zzde;
        this.zzh = (!z || this.zzb <= 1) ? false : z3;
        this.zzi = (int[]) iArr.clone();
        this.zzj = (boolean[]) zArr.clone();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        zzdo zzdo = (zzdo) obj;
        return this.zzh == zzdo.zzh && this.zzg.equals(zzdo.zzg) && Arrays.equals(this.zzi, zzdo.zzi) && Arrays.equals(this.zzj, zzdo.zzj);
    }

    public final int hashCode() {
        return (((((this.zzg.hashCode() * 31) + (this.zzh ? 1 : 0)) * 31) + Arrays.hashCode(this.zzi)) * 31) + Arrays.hashCode(this.zzj);
    }

    public final int zza() {
        return this.zzg.zzd;
    }

    public final zzan zzb(int i) {
        return this.zzg.zzb(i);
    }

    public final boolean zzc() {
        for (boolean z : this.zzj) {
            if (z) {
                return true;
            }
        }
        return false;
    }

    public final boolean zzd(int i) {
        return this.zzj[i];
    }
}
