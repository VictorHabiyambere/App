package com.google.android.gms.internal.ads;

import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzgr {
    public static final byte[] zza = {0, 0, 0, 1};
    public static final float[] zzb = {1.0f, 1.0f, 1.0909091f, 0.90909094f, 1.4545455f, 1.2121212f, 2.1818182f, 1.8181819f, 2.909091f, 2.4242425f, 1.6363636f, 1.3636364f, 1.939394f, 1.6161616f, 1.3333334f, 1.5f, 2.0f};
    private static final Object zzc = new Object();
    private static int[] zzd = new int[10];

    public static int zza(byte[] bArr, int i, int i2, boolean[] zArr) {
        boolean z;
        boolean z2;
        int i3 = i2 - i;
        boolean z3 = false;
        zzeq.zzf(i3 >= 0);
        if (i3 == 0) {
            return i2;
        }
        if (zArr[0]) {
            zzf(zArr);
            return i - 3;
        } else if (i3 > 1 && zArr[1] && bArr[i] == 1) {
            zzf(zArr);
            return i - 2;
        } else if (i3 <= 2 || !zArr[2] || bArr[i] != 0 || bArr[i + 1] != 1) {
            int i4 = i2 - 1;
            int i5 = i + 2;
            while (i5 < i4) {
                byte b = bArr[i5];
                if ((b & 254) == 0) {
                    int i6 = i5 - 2;
                    if (bArr[i6] == 0 && bArr[i5 - 1] == 0 && b == 1) {
                        zzf(zArr);
                        return i6;
                    }
                    i5 = i6;
                }
                i5 += 3;
            }
            if (i3 > 2) {
                z = bArr[i2 + -3] == 0 && bArr[i2 + -2] == 0 && bArr[i4] == 1;
            } else if (i3 == 2) {
                z = zArr[2] && bArr[i2 + -2] == 0 && bArr[i4] == 1;
            } else {
                z = zArr[1] && bArr[i4] == 1;
            }
            zArr[0] = z;
            if (i3 > 1) {
                z2 = bArr[i2 + -2] == 0 && bArr[i4] == 0;
            } else {
                z2 = zArr[2] && bArr[i4] == 0;
            }
            zArr[1] = z2;
            if (bArr[i4] == 0) {
                z3 = true;
            }
            zArr[2] = z3;
            return i2;
        } else {
            zzf(zArr);
            return i - 1;
        }
    }

    public static zzgo zzc(byte[] bArr, int i, int i2) {
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int[] iArr;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        zzgs zzgs = new zzgs(bArr, i, i2);
        int i18 = 4;
        zzgs.zze(4);
        int zza2 = zzgs.zza(3);
        zzgs.zzd();
        int zza3 = zzgs.zza(2);
        boolean zzf = zzgs.zzf();
        int zza4 = zzgs.zza(5);
        int i19 = 0;
        for (int i20 = 0; i20 < 32; i20++) {
            if (zzgs.zzf()) {
                i19 |= 1 << i20;
            }
        }
        int i21 = 6;
        int[] iArr2 = new int[6];
        for (int i22 = 0; i22 < 6; i22++) {
            iArr2[i22] = zzgs.zza(8);
        }
        int zza5 = zzgs.zza(8);
        int i23 = 0;
        for (int i24 = 0; i24 < zza2; i24++) {
            if (zzgs.zzf()) {
                i23 += 89;
            }
            if (zzgs.zzf()) {
                i23 += 8;
            }
        }
        zzgs.zze(i23);
        if (zza2 > 0) {
            int i25 = 8 - zza2;
            zzgs.zze(i25 + i25);
        }
        int zzc2 = zzgs.zzc();
        int zzc3 = zzgs.zzc();
        if (zzc3 == 3) {
            zzgs.zzd();
            zzc3 = 3;
        }
        int zzc4 = zzgs.zzc();
        int zzc5 = zzgs.zzc();
        if (zzgs.zzf()) {
            int zzc6 = zzgs.zzc();
            int zzc7 = zzgs.zzc();
            int zzc8 = zzgs.zzc();
            int zzc9 = zzgs.zzc();
            if (zzc3 == 1) {
                i17 = 2;
            } else if (zzc3 == 2) {
                zzc3 = 2;
                i17 = 2;
            } else {
                i17 = 1;
            }
            int i26 = zzc4 - (i17 * (zzc6 + zzc7));
            i4 = zzc3;
            i5 = zzc5 - ((zzc3 == 1 ? 2 : 1) * (zzc8 + zzc9));
            i3 = i26;
        } else {
            int i27 = zzc4;
            i4 = zzc3;
            i5 = zzc5;
            i3 = i27;
        }
        int zzc10 = zzgs.zzc();
        int zzc11 = zzgs.zzc();
        int zzc12 = zzgs.zzc();
        for (int i28 = true != zzgs.zzf() ? zza2 : 0; i28 <= zza2; i28++) {
            zzgs.zzc();
            zzgs.zzc();
            zzgs.zzc();
        }
        zzgs.zzc();
        zzgs.zzc();
        zzgs.zzc();
        zzgs.zzc();
        zzgs.zzc();
        zzgs.zzc();
        if (zzgs.zzf() && zzgs.zzf()) {
            int i29 = 0;
            while (i29 < i18) {
                int i30 = 0;
                while (i30 < i21) {
                    if (!zzgs.zzf()) {
                        zzgs.zzc();
                    } else {
                        int min = Math.min(64, 1 << ((i29 + i29) + 4));
                        if (i29 > 1) {
                            zzgs.zzb();
                            i16 = 0;
                        } else {
                            i16 = 0;
                        }
                        while (i16 < min) {
                            zzgs.zzb();
                            i16++;
                        }
                    }
                    i30 += i29 == 3 ? 3 : 1;
                    i21 = 6;
                }
                i29++;
                i18 = 4;
                i21 = 6;
            }
        }
        zzgs.zze(2);
        if (zzgs.zzf()) {
            zzgs.zze(8);
            zzgs.zzc();
            zzgs.zzc();
            zzgs.zzd();
        }
        int zzc13 = zzgs.zzc();
        int i31 = 0;
        int[] iArr3 = new int[0];
        int[] iArr4 = new int[0];
        int i32 = -1;
        int i33 = -1;
        int i34 = -1;
        while (i31 < zzc13) {
            if (i31 == 0) {
                i10 = zzc13;
                i11 = i19;
                i12 = i4;
                iArr = iArr2;
            } else if (zzgs.zzf()) {
                int i35 = i33 + i34;
                boolean zzf2 = zzgs.zzf();
                int zzc14 = zzgs.zzc() + 1;
                int i36 = 1 - ((zzf2 ? 1 : 0) + zzf2);
                int i37 = i35 + 1;
                i10 = zzc13;
                boolean[] zArr = new boolean[i37];
                iArr = iArr2;
                for (int i38 = 0; i38 <= i35; i38++) {
                    if (!zzgs.zzf()) {
                        zArr[i38] = zzgs.zzf();
                    } else {
                        zArr[i38] = true;
                    }
                }
                int i39 = i34 - 1;
                int[] iArr5 = new int[i37];
                int[] iArr6 = new int[i37];
                int i40 = 0;
                while (true) {
                    i15 = i36 * zzc14;
                    if (i39 < 0) {
                        break;
                    }
                    int i41 = iArr4[i39] + i15;
                    if (i41 < 0 && zArr[i33 + i39]) {
                        iArr5[i40] = i41;
                        i40++;
                    }
                    i39--;
                }
                if (i15 < 0 && zArr[i35]) {
                    iArr5[i40] = i15;
                    i40++;
                }
                i11 = i19;
                i12 = i4;
                int i42 = i40;
                for (int i43 = 0; i43 < i33; i43++) {
                    int i44 = iArr3[i43] + i15;
                    if (i44 < 0 && zArr[i43]) {
                        iArr5[i42] = i44;
                        i42++;
                    }
                }
                int[] copyOf = Arrays.copyOf(iArr5, i42);
                int i45 = 0;
                for (int i46 = i33 - 1; i46 >= 0; i46--) {
                    int i47 = iArr3[i46] + i15;
                    if (i47 > 0 && zArr[i46]) {
                        iArr6[i45] = i47;
                        i45++;
                    }
                }
                if (i15 > 0 && zArr[i35]) {
                    iArr6[i45] = i15;
                    i45++;
                }
                int i48 = i45;
                for (int i49 = 0; i49 < i34; i49++) {
                    int i50 = iArr4[i49] + i15;
                    if (i50 > 0 && zArr[i33 + i49]) {
                        iArr6[i48] = i50;
                        i48++;
                    }
                }
                iArr4 = Arrays.copyOf(iArr6, i48);
                i34 = i48;
                iArr3 = copyOf;
                i33 = i42;
                i31++;
                i4 = i12;
                i19 = i11;
                zzc13 = i10;
                iArr2 = iArr;
            } else {
                i10 = zzc13;
                i11 = i19;
                i12 = i4;
                iArr = iArr2;
            }
            int zzc15 = zzgs.zzc();
            int zzc16 = zzgs.zzc();
            int[] iArr7 = new int[zzc15];
            for (int i51 = 0; i51 < zzc15; i51++) {
                if (i51 > 0) {
                    i14 = iArr7[i51 - 1];
                } else {
                    i14 = 0;
                }
                iArr7[i51] = i14 - (zzgs.zzc() + 1);
                zzgs.zzd();
            }
            int[] iArr8 = new int[zzc16];
            for (int i52 = 0; i52 < zzc16; i52++) {
                if (i52 > 0) {
                    i13 = iArr8[i52 - 1];
                } else {
                    i13 = 0;
                }
                iArr8[i52] = i13 + zzgs.zzc() + 1;
                zzgs.zzd();
            }
            i34 = zzc16;
            iArr4 = iArr8;
            i33 = zzc15;
            iArr3 = iArr7;
            i31++;
            i4 = i12;
            i19 = i11;
            zzc13 = i10;
            iArr2 = iArr;
        }
        int i53 = i19;
        int i54 = i4;
        int[] iArr9 = iArr2;
        if (zzgs.zzf()) {
            int zzc17 = zzgs.zzc();
            for (int i55 = 0; i55 < zzc17; i55++) {
                zzgs.zze(zzc12 + 5);
            }
        }
        zzgs.zze(2);
        float f = 1.0f;
        if (zzgs.zzf()) {
            if (zzgs.zzf()) {
                int zza6 = zzgs.zza(8);
                if (zza6 == 255) {
                    int zza7 = zzgs.zza(16);
                    int zza8 = zzgs.zza(16);
                    if (!(zza7 == 0 || zza8 == 0)) {
                        f = ((float) zza7) / ((float) zza8);
                    }
                } else if (zza6 < 17) {
                    f = zzb[zza6];
                } else {
                    zzfk.zzf("NalUnitUtil", "Unexpected aspect_ratio_idc value: " + zza6);
                }
            }
            if (zzgs.zzf()) {
                zzgs.zzd();
            }
            if (zzgs.zzf()) {
                zzgs.zze(3);
                int i56 = 1;
                if (true != zzgs.zzf()) {
                    i56 = 2;
                }
                if (zzgs.zzf()) {
                    int zza9 = zzgs.zza(8);
                    int zza10 = zzgs.zza(8);
                    zzgs.zze(8);
                    int zza11 = zzt.zza(zza9);
                    i9 = zzt.zzb(zza10);
                    i7 = zza11;
                    i32 = i56;
                } else {
                    i7 = -1;
                    i9 = -1;
                    i32 = i56;
                }
            } else {
                i7 = -1;
                i9 = -1;
            }
            if (zzgs.zzf()) {
                zzgs.zzc();
                zzgs.zzc();
            }
            zzgs.zzd();
            if (zzgs.zzf()) {
                i5 += i5;
            }
            i6 = i9;
            i8 = i5;
        } else {
            i8 = i5;
            i7 = -1;
            i6 = -1;
        }
        return new zzgo(zza3, zzf, zza4, i53, i54, zzc10, zzc11, iArr9, zza5, zzc2, i3, i8, f, i7, i32, i6);
    }

    public static zzgp zzd(byte[] bArr, int i, int i2) {
        zzgs zzgs = new zzgs(bArr, 4, i2);
        int zzc2 = zzgs.zzc();
        int zzc3 = zzgs.zzc();
        zzgs.zzd();
        return new zzgp(zzc2, zzc3, zzgs.zzf());
    }

    /* JADX WARNING: Removed duplicated region for block: B:104:0x01e0  */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x01e7  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00b9  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00c5  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x0108  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x011b  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x014e  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x0157  */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x01a5  */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x01ae  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.android.gms.internal.ads.zzgq zze(byte[] r26, int r27, int r28) {
        /*
            com.google.android.gms.internal.ads.zzgs r0 = new com.google.android.gms.internal.ads.zzgs
            r1 = r26
            r2 = r27
            r3 = r28
            r0.<init>(r1, r2, r3)
            r1 = 8
            int r2 = r0.zza(r1)
            int r5 = r0.zza(r1)
            int r6 = r0.zza(r1)
            int r7 = r0.zzc()
            r3 = 100
            r8 = 3
            r10 = 1
            if (r2 == r3) goto L_0x004f
            r3 = 110(0x6e, float:1.54E-43)
            if (r2 == r3) goto L_0x004f
            r3 = 122(0x7a, float:1.71E-43)
            if (r2 == r3) goto L_0x004f
            r3 = 244(0xf4, float:3.42E-43)
            if (r2 == r3) goto L_0x004f
            r3 = 44
            if (r2 == r3) goto L_0x004f
            r3 = 83
            if (r2 == r3) goto L_0x004f
            r3 = 86
            if (r2 == r3) goto L_0x004f
            r3 = 118(0x76, float:1.65E-43)
            if (r2 == r3) goto L_0x004f
            r3 = 128(0x80, float:1.794E-43)
            if (r2 == r3) goto L_0x004f
            r3 = 138(0x8a, float:1.93E-43)
            if (r2 != r3) goto L_0x0049
            r2 = r3
            goto L_0x004f
        L_0x0049:
            r3 = r10
            r12 = 0
            r13 = 0
            r14 = 0
            goto L_0x00ad
        L_0x004f:
            int r3 = r0.zzc()
            if (r3 != r8) goto L_0x005b
            boolean r11 = r0.zzf()
            r12 = r8
            goto L_0x005d
        L_0x005b:
            r12 = r3
            r11 = 0
        L_0x005d:
            int r13 = r0.zzc()
            int r14 = r0.zzc()
            r0.zzd()
            boolean r15 = r0.zzf()
            if (r15 == 0) goto L_0x00a9
            if (r12 == r8) goto L_0x0072
            r12 = r1
            goto L_0x0074
        L_0x0072:
            r12 = 12
        L_0x0074:
            r15 = 0
        L_0x0075:
            if (r15 >= r12) goto L_0x00a8
            boolean r16 = r0.zzf()
            if (r16 == 0) goto L_0x00a2
            r9 = 6
            if (r15 >= r9) goto L_0x0083
            r9 = 16
            goto L_0x0085
        L_0x0083:
            r9 = 64
        L_0x0085:
            r16 = r1
            r17 = r16
            r1 = 0
        L_0x008a:
            if (r1 >= r9) goto L_0x00a2
            if (r16 == 0) goto L_0x009a
            int r16 = r0.zzb()
            int r8 = r17 + r16
            int r8 = r8 + 256
            int r8 = r8 % 256
            r16 = r8
        L_0x009a:
            if (r16 == 0) goto L_0x009e
            r17 = r16
        L_0x009e:
            int r1 = r1 + 1
            r8 = 3
            goto L_0x008a
        L_0x00a2:
            int r15 = r15 + 1
            r1 = 8
            r8 = 3
            goto L_0x0075
        L_0x00a8:
            goto L_0x00aa
        L_0x00a9:
        L_0x00aa:
            r12 = r13
            r13 = r14
            r14 = r11
        L_0x00ad:
            int r1 = r0.zzc()
            int r16 = r1 + 4
            int r1 = r0.zzc()
            if (r1 != 0) goto L_0x00c5
            int r8 = r0.zzc()
            int r8 = r8 + 4
            r15 = r5
            r18 = r8
            r19 = 0
            goto L_0x00ef
        L_0x00c5:
            if (r1 != r10) goto L_0x00ea
            boolean r1 = r0.zzf()
            r0.zzb()
            r0.zzb()
            int r8 = r0.zzc()
            long r8 = (long) r8
            r11 = 0
        L_0x00d7:
            r15 = r5
            long r4 = (long) r11
            int r4 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1))
            if (r4 >= 0) goto L_0x00e4
            r0.zzc()
            int r11 = r11 + 1
            r5 = r15
            goto L_0x00d7
        L_0x00e4:
            r19 = r1
            r1 = r10
            r18 = 0
            goto L_0x00ef
        L_0x00ea:
            r15 = r5
            r18 = 0
            r19 = 0
        L_0x00ef:
            int r8 = r0.zzc()
            r0.zzd()
            int r4 = r0.zzc()
            int r4 = r4 + r10
            int r5 = r0.zzc()
            int r5 = r5 + r10
            boolean r20 = r0.zzf()
            int r9 = 2 - r20
            if (r20 != 0) goto L_0x010b
            r0.zzd()
        L_0x010b:
            int r5 = r5 * r9
            r0.zzd()
            r11 = 16
            int r4 = r4 * r11
            int r5 = r5 * r11
            boolean r11 = r0.zzf()
            r21 = 2
            if (r11 == 0) goto L_0x014e
            int r11 = r0.zzc()
            int r22 = r0.zzc()
            int r23 = r0.zzc()
            int r24 = r0.zzc()
            if (r3 != 0) goto L_0x012e
            goto L_0x0141
        L_0x012e:
            r10 = 3
            if (r3 != r10) goto L_0x0133
            r10 = 1
            goto L_0x0135
        L_0x0133:
            r10 = r21
        L_0x0135:
            r25 = r10
            r10 = 1
            if (r3 != r10) goto L_0x013d
            r10 = r21
            goto L_0x013e
        L_0x013d:
            r10 = 1
        L_0x013e:
            int r9 = r9 * r10
            r10 = r25
        L_0x0141:
            int r11 = r11 + r22
            int r11 = r11 * r10
            int r4 = r4 - r11
            int r23 = r23 + r24
            int r23 = r23 * r9
            int r5 = r5 - r23
            r9 = r4
            r10 = r5
            goto L_0x0150
        L_0x014e:
            r9 = r4
            r10 = r5
        L_0x0150:
            boolean r3 = r0.zzf()
            r5 = -1
            if (r3 == 0) goto L_0x01e7
            boolean r3 = r0.zzf()
            if (r3 == 0) goto L_0x019c
            r3 = 8
            int r11 = r0.zza(r3)
            r3 = 255(0xff, float:3.57E-43)
            if (r11 != r3) goto L_0x017c
            r3 = 16
            int r11 = r0.zza(r3)
            int r3 = r0.zza(r3)
            if (r11 == 0) goto L_0x0179
            if (r3 == 0) goto L_0x0179
            float r4 = (float) r11
            float r3 = (float) r3
            float r4 = r4 / r3
            goto L_0x019f
        L_0x0179:
            r4 = 1065353216(0x3f800000, float:1.0)
            goto L_0x019f
        L_0x017c:
            r3 = 17
            if (r11 >= r3) goto L_0x0185
            float[] r3 = zzb
            r4 = r3[r11]
            goto L_0x019f
        L_0x0185:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "Unexpected aspect_ratio_idc value: "
            r3.append(r4)
            r3.append(r11)
            java.lang.String r3 = r3.toString()
            java.lang.String r4 = "NalUnitUtil"
            com.google.android.gms.internal.ads.zzfk.zzf(r4, r3)
            goto L_0x019d
        L_0x019c:
        L_0x019d:
            r4 = 1065353216(0x3f800000, float:1.0)
        L_0x019f:
            boolean r3 = r0.zzf()
            if (r3 == 0) goto L_0x01a8
            r0.zzd()
        L_0x01a8:
            boolean r3 = r0.zzf()
            if (r3 == 0) goto L_0x01e0
            r3 = 3
            r0.zze(r3)
            boolean r3 = r0.zzf()
            r11 = 1
            if (r11 == r3) goto L_0x01ba
            goto L_0x01bc
        L_0x01ba:
            r21 = r11
        L_0x01bc:
            boolean r3 = r0.zzf()
            if (r3 == 0) goto L_0x01db
            r3 = 8
            int r5 = r0.zza(r3)
            int r11 = r0.zza(r3)
            r0.zze(r3)
            int r0 = com.google.android.gms.internal.ads.zzt.zza(r5)
            int r3 = com.google.android.gms.internal.ads.zzt.zzb(r11)
            r22 = r3
            r11 = r4
            goto L_0x01ee
        L_0x01db:
            r11 = r4
            r0 = r5
            r22 = r0
            goto L_0x01ee
        L_0x01e0:
            r11 = r4
            r0 = r5
            r21 = r0
            r22 = r21
            goto L_0x01ee
        L_0x01e7:
            r0 = r5
            r21 = r0
            r22 = r21
            r11 = 1065353216(0x3f800000, float:1.0)
        L_0x01ee:
            com.google.android.gms.internal.ads.zzgq r23 = new com.google.android.gms.internal.ads.zzgq
            r3 = r23
            r4 = r2
            r5 = r15
            r15 = r20
            r17 = r1
            r20 = r0
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22)
            return r23
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzgr.zze(byte[], int, int):com.google.android.gms.internal.ads.zzgq");
    }

    public static void zzf(boolean[] zArr) {
        zArr[0] = false;
        zArr[1] = false;
        zArr[2] = false;
    }

    public static int zzb(byte[] bArr, int i) {
        int i2;
        synchronized (zzc) {
            int i3 = 0;
            int i4 = 0;
            while (i3 < i) {
                while (true) {
                    if (i3 >= i - 2) {
                        i3 = i;
                        break;
                    }
                    int i5 = i3 + 1;
                    if (bArr[i3] == 0 && bArr[i5] == 0 && bArr[i3 + 2] == 3) {
                        break;
                    }
                    i3 = i5;
                }
                if (i3 < i) {
                    int[] iArr = zzd;
                    int length = iArr.length;
                    if (length <= i4) {
                        zzd = Arrays.copyOf(iArr, length + length);
                    }
                    zzd[i4] = i3;
                    i3 += 3;
                    i4++;
                }
            }
            i2 = i - i4;
            int i6 = 0;
            int i7 = 0;
            int i8 = 0;
            while (i6 < i4) {
                try {
                    int i9 = zzd[i6] - i7;
                    System.arraycopy(bArr, i7, bArr, i8, i9);
                    int i10 = i8 + i9;
                    int i11 = i10 + 1;
                    bArr[i10] = 0;
                    i8 = i11 + 1;
                    bArr[i11] = 0;
                    i7 += i9 + 3;
                    i6++;
                } catch (Throwable th) {
                    throw th;
                }
            }
            System.arraycopy(bArr, i7, bArr, i8, i2 - i8);
        }
        return i2;
    }
}
