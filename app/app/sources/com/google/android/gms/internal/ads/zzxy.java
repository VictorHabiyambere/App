package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzxy extends zzya {
    private final zzzu zzd;
    private final zzgbc zze;
    private final zzer zzf;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    protected zzxy(zzde zzde, int[] iArr, int i, zzzu zzzu, long j, long j2, long j3, int i2, int i3, float f, float f2, List list, zzer zzer) {
        super(zzde, iArr, 0);
        zzde zzde2 = zzde;
        int[] iArr2 = iArr;
        this.zzd = zzzu;
        this.zze = zzgbc.zzk(list);
        this.zzf = zzer;
    }

    static /* bridge */ /* synthetic */ zzgbc zzf(zzzf[] zzzfArr) {
        int i;
        int i2;
        double d;
        ArrayList arrayList = new ArrayList();
        int i3 = 0;
        int i4 = 0;
        while (true) {
            i = 2;
            i2 = 1;
            if (i4 >= 2) {
                break;
            }
            zzzf zzzf = zzzfArr[i4];
            if (zzzf == null || zzzf.zzb.length <= 1) {
                arrayList.add((Object) null);
            } else {
                zzgaz zzgaz = new zzgaz();
                zzgaz.zzf(new zzxw(0, 0));
                arrayList.add(zzgaz);
            }
            i4++;
        }
        long[][] jArr = new long[2][];
        for (int i5 = 0; i5 < 2; i5++) {
            zzzf zzzf2 = zzzfArr[i5];
            if (zzzf2 == null) {
                jArr[i5] = new long[0];
            } else {
                jArr[i5] = new long[zzzf2.zzb.length];
                int i6 = 0;
                while (true) {
                    int[] iArr = zzzf2.zzb;
                    if (i6 >= iArr.length) {
                        break;
                    }
                    long j = (long) zzzf2.zza.zzb(iArr[i6]).zzj;
                    long[] jArr2 = jArr[i5];
                    if (j == -1) {
                        j = 0;
                    }
                    jArr2[i6] = j;
                    i6++;
                }
                Arrays.sort(jArr[i5]);
            }
        }
        int[] iArr2 = new int[2];
        long[] jArr3 = new long[2];
        for (int i7 = 0; i7 < 2; i7++) {
            long[] jArr4 = jArr[i7];
            jArr3[i7] = jArr4.length == 0 ? 0 : jArr4[0];
        }
        zzg(arrayList, jArr3);
        zzgbn zza = zzgci.zzc(zzgcn.zzc()).zzb(2).zza();
        int i8 = 0;
        while (i8 < i) {
            int length = jArr[i8].length;
            if (length > i2) {
                double[] dArr = new double[length];
                int i9 = i3;
                while (true) {
                    long[] jArr5 = jArr[i8];
                    double d2 = 0.0d;
                    if (i9 >= jArr5.length) {
                        break;
                    }
                    long j2 = jArr5[i9];
                    if (j2 != -1) {
                        d2 = Math.log((double) j2);
                    }
                    dArr[i9] = d2;
                    i9++;
                }
                int i10 = length - 1;
                double d3 = dArr[i10] - dArr[i3];
                int i11 = i3;
                while (i11 < i10) {
                    double d4 = dArr[i11];
                    i11++;
                    double d5 = d4 + dArr[i11];
                    if (d3 == 0.0d) {
                        d = 1.0d;
                    } else {
                        d = ((d5 * 0.5d) - dArr[i3]) / d3;
                    }
                    zza.zzq(Double.valueOf(d), Integer.valueOf(i8));
                    i3 = 0;
                }
            }
            i8++;
            i3 = 0;
            i = 2;
            i2 = 1;
        }
        zzgbc zzk = zzgbc.zzk(zza.zzr());
        for (int i12 = 0; i12 < zzk.size(); i12++) {
            int intValue = ((Integer) zzk.get(i12)).intValue();
            int i13 = iArr2[intValue] + 1;
            iArr2[intValue] = i13;
            jArr3[intValue] = jArr[intValue][i13];
            zzg(arrayList, jArr3);
        }
        for (int i14 = 0; i14 < 2; i14++) {
            if (arrayList.get(i14) != null) {
                long j3 = jArr3[i14];
                jArr3[i14] = j3 + j3;
            }
        }
        zzg(arrayList, jArr3);
        zzgaz zzgaz2 = new zzgaz();
        for (int i15 = 0; i15 < arrayList.size(); i15++) {
            zzgaz zzgaz3 = (zzgaz) arrayList.get(i15);
            zzgaz2.zzf(zzgaz3 == null ? zzgbc.zzm() : zzgaz3.zzi());
        }
        return zzgaz2.zzi();
    }

    private static void zzg(List list, long[] jArr) {
        long j = 0;
        for (int i = 0; i < 2; i++) {
            j += jArr[i];
        }
        for (int i2 = 0; i2 < list.size(); i2++) {
            zzgaz zzgaz = (zzgaz) list.get(i2);
            if (zzgaz != null) {
                zzgaz.zzf(new zzxw(j, jArr[i2]));
            }
        }
    }
}
