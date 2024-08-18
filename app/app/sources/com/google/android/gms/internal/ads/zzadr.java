package com.google.android.gms.internal.ads;

import androidx.compose.animation.core.AnimationKt;
import java.math.RoundingMode;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzadr {
    public static final /* synthetic */ int zza = 0;
    private static final int[] zzb = {1, 2, 2, 2, 2, 3, 3, 4, 4, 5, 6, 6, 6, 7, 8, 8};
    private static final int[] zzc = {-1, 8000, 16000, 32000, -1, -1, 11025, 22050, 44100, -1, -1, 12000, 24000, 48000, -1, -1};
    private static final int[] zzd = {64, 112, 128, 192, 224, 256, 384, 448, 512, 640, 768, 896, 1024, 1152, 1280, 1536, 1920, 2048, 2304, 2560, 2688, 2816, 2823, 2944, 3072, 3840, 4096, 6144, 7680};
    private static final int[] zze = {8000, 16000, 32000, 64000, 128000, 22050, 44100, 88200, 176400, 352800, 12000, 24000, 48000, 96000, 192000, 384000};
    private static final int[] zzf = {5, 8, 10, 12};
    private static final int[] zzg = {6, 9, 12, 15};
    private static final int[] zzh = {2, 4, 6, 8};
    private static final int[] zzi = {9, 11, 13, 16};
    private static final int[] zzj = {5, 8, 10, 12};

    public static int zza(byte[] bArr) {
        int i;
        zzft zzg2 = zzg(bArr);
        zzg2.zzm(42);
        if (true != zzg2.zzo()) {
            i = 8;
        } else {
            i = 12;
        }
        return zzg2.zzd(i) + 1;
    }

    public static int zzb(byte[] bArr) {
        zzft zzg2 = zzg(bArr);
        zzg2.zzm(32);
        return zzf(zzg2, zzj, true) + 1;
    }

    public static zzan zzc(byte[] bArr, String str, String str2, int i, zzae zzae) {
        int i2;
        int i3;
        zzft zzg2 = zzg(bArr);
        zzg2.zzm(60);
        int i4 = zzb[zzg2.zzd(6)];
        int i5 = zzc[zzg2.zzd(4)];
        int zzd2 = zzg2.zzd(5);
        if (zzd2 >= 29) {
            i2 = -1;
        } else {
            i2 = (zzd[zzd2] * 1000) / 2;
        }
        zzg2.zzm(10);
        if (zzg2.zzd(2) > 0) {
            i3 = 1;
        } else {
            i3 = 0;
        }
        int i6 = i4 + i3;
        zzal zzal = new zzal();
        zzal.zzK(str);
        zzal.zzX("audio/vnd.dts");
        zzal.zzx(i2);
        zzal.zzy(i6);
        zzal.zzY(i5);
        zzal.zzE((zzae) null);
        zzal.zzO(str2);
        zzal.zzV(i);
        return zzal.zzad();
    }

    public static zzadq zzd(byte[] bArr) throws zzch {
        int i;
        int i2;
        int i3;
        long j;
        int i4;
        zzft zzg2 = zzg(bArr);
        zzg2.zzm(40);
        int zzd2 = zzg2.zzd(2);
        boolean zzo = zzg2.zzo();
        int i5 = true != zzo ? 16 : 20;
        zzg2.zzm(true != zzo ? 8 : 12);
        int zzd3 = zzg2.zzd(i5) + 1;
        boolean zzo2 = zzg2.zzo();
        int i6 = 0;
        if (zzo2) {
            i = zzg2.zzd(2);
            int zzd4 = zzg2.zzd(3) + 1;
            if (zzg2.zzo()) {
                zzg2.zzm(36);
            }
            int zzd5 = zzg2.zzd(3) + 1;
            int zzd6 = zzg2.zzd(3) + 1;
            if (zzd5 == 1 && zzd6 == 1) {
                int i7 = zzd2 + 1;
                int zzd7 = zzg2.zzd(i7);
                for (int i8 = 0; i8 < i7; i8++) {
                    if (((zzd7 >> i8) & 1) == 1) {
                        zzg2.zzm(8);
                    }
                }
                int i9 = zzd4 * 512;
                if (zzg2.zzo()) {
                    zzg2.zzm(2);
                    int zzd8 = (zzg2.zzd(2) + 1) << 2;
                    int zzd9 = zzg2.zzd(2) + 1;
                    while (i6 < zzd9) {
                        zzg2.zzm(zzd8);
                        i6++;
                    }
                }
                i6 = i9;
            } else {
                throw zzch.zzc("Multiple audio presentations or assets not supported");
            }
        } else {
            i = -1;
        }
        zzg2.zzm(i5);
        zzg2.zzm(12);
        if (zzo2) {
            if (zzg2.zzo()) {
                zzg2.zzm(4);
            }
            if (zzg2.zzo()) {
                zzg2.zzm(24);
            }
            if (zzg2.zzo()) {
                zzg2.zzn(zzg2.zzd(10) + 1);
            }
            zzg2.zzm(5);
            int i10 = zze[zzg2.zzd(4)];
            i3 = zzg2.zzd(8) + 1;
            i2 = i10;
        } else {
            i2 = -2147483647;
            i3 = -1;
        }
        if (zzo2) {
            switch (i) {
                case 0:
                    i4 = 32000;
                    break;
                case 1:
                    i4 = 44100;
                    break;
                case 2:
                    i4 = 48000;
                    break;
                default:
                    throw zzch.zza("Unsupported reference clock code in DTS HD header: " + i, (Throwable) null);
            }
            j = zzgd.zzt((long) i6, AnimationKt.MillisToNanos, (long) i4, RoundingMode.FLOOR);
        } else {
            j = -9223372036854775807L;
        }
        return new zzadq("audio/vnd.dts.hd;profile=lbr", i3, i2, zzd3, j, 0, (zzadp) null);
    }

    public static zzadq zze(byte[] bArr, AtomicInteger atomicInteger) throws zzch {
        long j;
        int i;
        int i2;
        int i3;
        byte[] bArr2 = bArr;
        zzft zzg2 = zzg(bArr);
        int zzd2 = zzg2.zzd(32);
        int zzf2 = zzf(zzg2, zzf, true) + 1;
        char c = zzd2 == 1078008818 ? (char) 1 : 0;
        if (c == 0) {
            i = -2147483647;
            j = -9223372036854775807L;
        } else if (zzg2.zzo()) {
            int i4 = zzf2 - 2;
            if ((((char) (bArr2[i4] << 8)) | (bArr2[zzf2 - 1] & 255)) == zzgd.zzd(bArr2, 0, i4, 65535)) {
                int zzd3 = zzg2.zzd(2);
                switch (zzd3) {
                    case 0:
                        i2 = 512;
                        break;
                    case 1:
                        i2 = 480;
                        break;
                    case 2:
                        i2 = 384;
                        break;
                    default:
                        throw zzch.zza("Unsupported base duration index in DTS UHD header: " + zzd3, (Throwable) null);
                }
                int zzd4 = zzg2.zzd(3) + 1;
                int zzd5 = zzg2.zzd(2);
                switch (zzd5) {
                    case 0:
                        i3 = 32000;
                        break;
                    case 1:
                        i3 = 44100;
                        break;
                    case 2:
                        i3 = 48000;
                        break;
                    default:
                        throw zzch.zza("Unsupported clock rate index in DTS UHD header: " + zzd5, (Throwable) null);
                }
                if (zzg2.zzo()) {
                    zzg2.zzm(36);
                }
                i = (1 << zzg2.zzd(2)) * i3;
                j = zzgd.zzt((long) (i2 * zzd4), AnimationKt.MillisToNanos, (long) i3, RoundingMode.FLOOR);
            } else {
                throw zzch.zza("CRC check failed", (Throwable) null);
            }
        } else {
            throw zzch.zzc("Only supports full channel mask-based audio presentation");
        }
        int i5 = 0;
        for (char c2 = 0; c2 < c; c2 = 1) {
            i5 += zzf(zzg2, zzg, true);
        }
        for (int i6 = 0; i6 <= 0; i6++) {
            if (c != 0) {
                atomicInteger.set(zzf(zzg2, zzh, true));
            } else {
                AtomicInteger atomicInteger2 = atomicInteger;
            }
            i5 += atomicInteger.get() != 0 ? zzf(zzg2, zzi, true) : 0;
        }
        return new zzadq("audio/vnd.dts.uhd;profile=p2", 2, i, zzf2 + i5, j, 0, (zzadp) null);
    }

    private static int zzf(zzft zzft, int[] iArr, boolean z) {
        int i;
        int i2 = 0;
        int i3 = 0;
        while (true) {
            if (i2 < 3) {
                if (!zzft.zzo()) {
                    i = 0;
                    break;
                }
                i3++;
                i2++;
            } else {
                i = 0;
                break;
            }
        }
        for (int i4 = 0; i4 < i3; i4++) {
            i += 1 << iArr[i4];
        }
        return i + zzft.zzd(iArr[i3]);
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0034 A[LOOP:0: B:19:0x0030->B:21:0x0034, LOOP_END] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.google.android.gms.internal.ads.zzft zzg(byte[] r6) {
        /*
            r0 = 0
            byte r1 = r6[r0]
            r2 = 127(0x7f, float:1.78E-43)
            if (r1 == r2) goto L_0x006d
            r2 = 100
            if (r1 == r2) goto L_0x006d
            r2 = 64
            if (r1 == r2) goto L_0x006d
            r2 = 113(0x71, float:1.58E-43)
            if (r1 != r2) goto L_0x0014
            goto L_0x006d
        L_0x0014:
            int r1 = r6.length
            byte[] r6 = java.util.Arrays.copyOf(r6, r1)
            byte r1 = r6[r0]
            r2 = -2
            r3 = -1
            if (r1 == r2) goto L_0x002f
            if (r1 == r3) goto L_0x002f
            r2 = 37
            if (r1 == r2) goto L_0x002f
            r2 = -14
            if (r1 == r2) goto L_0x002f
            r2 = -24
            if (r1 != r2) goto L_0x0041
            r1 = r0
            goto L_0x0030
        L_0x002f:
            r1 = r0
        L_0x0030:
            int r2 = r6.length
            int r2 = r2 + r3
            if (r1 >= r2) goto L_0x0041
            byte r2 = r6[r1]
            int r4 = r1 + 1
            byte r5 = r6[r4]
            r6[r1] = r5
            r6[r4] = r2
            int r1 = r1 + 2
            goto L_0x0030
        L_0x0041:
            com.google.android.gms.internal.ads.zzft r1 = new com.google.android.gms.internal.ads.zzft
            int r2 = r6.length
            r1.<init>(r6, r2)
            byte r0 = r6[r0]
            r3 = 31
            if (r0 != r3) goto L_0x0068
            com.google.android.gms.internal.ads.zzft r0 = new com.google.android.gms.internal.ads.zzft
            r0.<init>(r6, r2)
        L_0x0052:
            int r2 = r0.zza()
            r3 = 16
            if (r2 < r3) goto L_0x0068
            r2 = 2
            r0.zzm(r2)
            r2 = 14
            int r3 = r0.zzd(r2)
            r1.zzf(r3, r2)
            goto L_0x0052
        L_0x0068:
            int r0 = r6.length
            r1.zzj(r6, r0)
            return r1
        L_0x006d:
            com.google.android.gms.internal.ads.zzft r0 = new com.google.android.gms.internal.ads.zzft
            int r1 = r6.length
            r0.<init>(r6, r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzadr.zzg(byte[]):com.google.android.gms.internal.ads.zzft");
    }
}
