package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
final class zzaks {
    public final zzakp zza;
    public final int zzb;
    public final long[] zzc;
    public final int[] zzd;
    public final int zze;
    public final long[] zzf;
    public final int[] zzg;
    public final long zzh;

    public zzaks(zzakp zzakp, long[] jArr, int[] iArr, int i, long[] jArr2, int[] iArr2, long j) {
        boolean z;
        boolean z2;
        int length = iArr.length;
        int length2 = jArr2.length;
        boolean z3 = true;
        if (length == length2) {
            z = true;
        } else {
            z = false;
        }
        zzeq.zzd(z);
        int length3 = jArr.length;
        if (length3 == length2) {
            z2 = true;
        } else {
            z2 = false;
        }
        zzeq.zzd(z2);
        int length4 = iArr2.length;
        zzeq.zzd(length4 != length2 ? false : z3);
        this.zza = zzakp;
        this.zzc = jArr;
        this.zzd = iArr;
        this.zze = i;
        this.zzf = jArr2;
        this.zzg = iArr2;
        this.zzh = j;
        this.zzb = length3;
        if (length4 > 0) {
            int i2 = length4 - 1;
            iArr2[i2] = iArr2[i2] | 536870912;
        }
    }

    public final int zza(long j) {
        for (int zzc2 = zzgd.zzc(this.zzf, j, true, false); zzc2 >= 0; zzc2--) {
            if ((this.zzg[zzc2] & 1) != 0) {
                return zzc2;
            }
        }
        return -1;
    }

    public final int zzb(long j) {
        for (int zza2 = zzgd.zza(this.zzf, j, true, false); zza2 < this.zzf.length; zza2++) {
            if ((this.zzg[zza2] & 1) != 0) {
                return zza2;
            }
        }
        return -1;
    }
}
