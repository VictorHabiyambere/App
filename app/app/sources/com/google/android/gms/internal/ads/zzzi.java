package com.google.android.gms.internal.ads;

import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzzi {
    private final String[] zza;
    private final int[] zzb;
    private final zzxr[] zzc;
    private final int[] zzd;
    private final int[][][] zze;
    private final zzxr zzf;

    zzzi(String[] strArr, int[] iArr, zzxr[] zzxrArr, int[] iArr2, int[][][] iArr3, zzxr zzxr) {
        this.zza = strArr;
        this.zzb = iArr;
        this.zzc = zzxrArr;
        this.zze = iArr3;
        this.zzd = iArr2;
        this.zzf = zzxr;
    }

    public final int zza(int i, int i2, boolean z) {
        int i3 = this.zzc[i].zzb(i2).zzb;
        int[] iArr = new int[i3];
        int i4 = 0;
        int i5 = 0;
        for (int i6 = 0; i6 < i3; i6++) {
            if ((this.zze[i][i2][i6] & 7) == 4) {
                iArr[i5] = i6;
                i5++;
            }
        }
        int[] copyOf = Arrays.copyOf(iArr, i5);
        String str = null;
        int i7 = 0;
        int i8 = 16;
        boolean z2 = false;
        while (i4 < copyOf.length) {
            String str2 = this.zzc[i].zzb(i2).zzb(copyOf[i4]).zzn;
            int i9 = i7 + 1;
            if (i7 == 0) {
                str = str2;
            } else {
                z2 |= !zzgd.zzG(str, str2);
            }
            i8 = Math.min(i8, this.zze[i][i2][i4] & 24);
            i4++;
            i7 = i9;
        }
        return z2 ? Math.min(i8, this.zzd[i]) : i8;
    }

    public final int zzb(int i, int i2, int i3) {
        return this.zze[i][i2][i3];
    }

    public final int zzc(int i) {
        return this.zzb[i];
    }

    public final zzxr zzd(int i) {
        return this.zzc[i];
    }

    public final zzxr zze() {
        return this.zzf;
    }
}
