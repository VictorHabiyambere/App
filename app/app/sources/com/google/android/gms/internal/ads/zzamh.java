package com.google.android.gms.internal.ads;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PathEffect;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.util.SparseArray;
import androidx.core.view.ViewCompat;
import com.google.common.base.Ascii;
import java.util.ArrayList;
import java.util.List;
import kotlinx.coroutines.scheduling.WorkQueueKt;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzamh implements zzalv {
    private static final byte[] zza = {0, 7, 8, Ascii.SI};
    private static final byte[] zzb = {0, 119, -120, -1};
    private static final byte[] zzc = {0, 17, 34, 51, 68, 85, 102, 119, -120, -103, -86, -69, -52, -35, -18, -1};
    private final Paint zzd = new Paint();
    private final Paint zze;
    private final Canvas zzf;
    private final zzama zzg;
    private final zzalz zzh;
    private final zzamg zzi;
    private Bitmap zzj;

    public zzamh(List list) {
        zzfu zzfu = new zzfu((byte[]) list.get(0));
        int zzq = zzfu.zzq();
        int zzq2 = zzfu.zzq();
        this.zzd.setStyle(Paint.Style.FILL_AND_STROKE);
        this.zzd.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
        this.zzd.setPathEffect((PathEffect) null);
        this.zze = new Paint();
        this.zze.setStyle(Paint.Style.FILL);
        this.zze.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OVER));
        this.zze.setPathEffect((PathEffect) null);
        this.zzf = new Canvas();
        this.zzg = new zzama(719, 575, 0, 719, 0, 575);
        this.zzh = new zzalz(0, zzg(), zzh(), zzi());
        this.zzi = new zzamg(zzq, zzq2);
    }

    private static int zzb(int i, int i2, int i3, int i4) {
        return (i << 24) | (i2 << 16) | (i3 << 8) | i4;
    }

    private static zzalz zzc(zzft zzft, int i) {
        int i2;
        int i3;
        int i4;
        int i5;
        zzft zzft2 = zzft;
        int i6 = 8;
        int zzd2 = zzft2.zzd(8);
        zzft2.zzm(8);
        int[] zzg2 = zzg();
        int[] zzh2 = zzh();
        int[] zzi2 = zzi();
        int i7 = i - 2;
        while (i7 > 0) {
            int zzd3 = zzft2.zzd(i6);
            int zzd4 = zzft2.zzd(i6);
            int i8 = i7 - 2;
            int[] iArr = (zzd4 & 128) != 0 ? zzg2 : (zzd4 & 64) != 0 ? zzh2 : zzi2;
            if ((zzd4 & 1) != 0) {
                i5 = zzft2.zzd(i6);
                i4 = zzft2.zzd(i6);
                i3 = zzft2.zzd(i6);
                i2 = zzft2.zzd(i6);
                i7 = i8 - 4;
            } else {
                int zzd5 = zzft2.zzd(2) << 6;
                i7 = i8 - 2;
                i3 = zzft2.zzd(4) << 4;
                i2 = zzd5;
                i5 = zzft2.zzd(6) << 2;
                i4 = zzft2.zzd(4) << 4;
            }
            if (i5 == 0) {
                i2 = 255;
            }
            if (i5 == 0) {
                i3 = 0;
            }
            if (i5 == 0) {
                i4 = 0;
            }
            double d = (double) i5;
            double d2 = (double) (i4 - 128);
            double d3 = (double) (i3 - 128);
            iArr[zzd3] = zzb((byte) (255 - (i2 & 255)), Math.max(0, Math.min((int) (d + (1.402d * d2)), 255)), Math.max(0, Math.min((int) ((d - (0.34414d * d3)) - (d2 * 0.71414d)), 255)), Math.max(0, Math.min((int) (d + (d3 * 1.772d)), 255)));
            zzd2 = zzd2;
            i6 = 8;
        }
        return new zzalz(zzd2, zzg2, zzh2, zzi2);
    }

    private static zzamb zzd(zzft zzft) {
        int zzd2 = zzft.zzd(16);
        zzft.zzm(4);
        int zzd3 = zzft.zzd(2);
        boolean zzo = zzft.zzo();
        zzft.zzm(1);
        byte[] bArr = zzgd.zzf;
        byte[] bArr2 = zzgd.zzf;
        if (zzd3 == 1) {
            zzft.zzm(zzft.zzd(8) * 16);
        } else if (zzd3 == 0) {
            int zzd4 = zzft.zzd(16);
            int zzd5 = zzft.zzd(16);
            if (zzd4 > 0) {
                bArr = new byte[zzd4];
                zzft.zzh(bArr, 0, zzd4);
            }
            if (zzd5 > 0) {
                bArr2 = new byte[zzd5];
                zzft.zzh(bArr2, 0, zzd5);
            } else {
                bArr2 = bArr;
            }
        }
        return new zzamb(zzd2, zzo, bArr, bArr2);
    }

    /* JADX WARNING: Incorrect type for immutable var: ssa=byte, code=int, for r3v28, types: [byte] */
    /* JADX WARNING: Incorrect type for immutable var: ssa=byte, code=int, for r3v6, types: [byte] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void zze(byte[] r23, int[] r24, int r25, int r26, int r27, android.graphics.Paint r28, android.graphics.Canvas r29) {
        /*
            r0 = r23
            r1 = r25
            r8 = r28
            com.google.android.gms.internal.ads.zzft r9 = new com.google.android.gms.internal.ads.zzft
            int r2 = r0.length
            r9.<init>(r0, r2)
            r2 = r26
            r10 = r27
            r11 = 0
            r12 = 0
            r13 = 0
        L_0x0013:
            int r3 = r9.zza()
            if (r3 == 0) goto L_0x0229
            r14 = 8
            int r3 = r9.zzd(r14)
            r15 = 3
            r7 = 4
            r16 = 1
            r6 = 2
            r17 = 0
            switch(r3) {
                case 16: goto L_0x015e;
                case 17: goto L_0x009c;
                case 18: goto L_0x0042;
                case 32: goto L_0x003c;
                case 33: goto L_0x0036;
                case 34: goto L_0x002f;
                case 240: goto L_0x002a;
                default: goto L_0x0029;
            }
        L_0x0029:
            goto L_0x0013
        L_0x002a:
            int r10 = r10 + 2
            r2 = r26
            goto L_0x0013
        L_0x002f:
            r3 = 16
            byte[] r12 = zzf(r3, r14, r9)
            goto L_0x0013
        L_0x0036:
            byte[] r11 = zzf(r7, r14, r9)
            goto L_0x0013
        L_0x003c:
            byte[] r13 = zzf(r7, r7, r9)
            goto L_0x0013
        L_0x0042:
            r15 = r2
            r2 = r17
        L_0x0045:
            int r3 = r9.zzd(r14)
            if (r3 == 0) goto L_0x0051
            r18 = r2
            r19 = r16
            goto L_0x007a
        L_0x0051:
            boolean r3 = r9.zzo()
            r4 = 7
            if (r3 != 0) goto L_0x006c
            int r3 = r9.zzd(r4)
            if (r3 == 0) goto L_0x0065
            r18 = r2
            r19 = r3
            r3 = r17
            goto L_0x007a
        L_0x0065:
            r18 = r16
            r3 = r17
            r19 = r3
            goto L_0x007a
        L_0x006c:
            int r3 = r9.zzd(r4)
            int r4 = r9.zzd(r14)
            r18 = r2
            r19 = r3
            r3 = r4
        L_0x007a:
            if (r19 == 0) goto L_0x0092
            if (r8 == 0) goto L_0x0092
            int r2 = r10 + 1
            float r4 = (float) r10
            r3 = r24[r3]
            r8.setColor(r3)
            float r3 = (float) r15
            int r5 = r15 + r19
            float r5 = (float) r5
            float r6 = (float) r2
            r2 = r29
            r7 = r28
            r2.drawRect(r3, r4, r5, r6, r7)
        L_0x0092:
            int r15 = r15 + r19
            if (r18 != 0) goto L_0x0099
            r2 = r18
            goto L_0x0045
        L_0x0099:
            r2 = r15
            goto L_0x0013
        L_0x009c:
            if (r1 != r15) goto L_0x00a8
            if (r12 != 0) goto L_0x00a5
            byte[] r3 = zzc
            r18 = r3
            goto L_0x00aa
        L_0x00a5:
            r18 = r12
            goto L_0x00aa
        L_0x00a8:
            r18 = 0
        L_0x00aa:
            r5 = r2
            r2 = r17
        L_0x00ad:
            int r3 = r9.zzd(r7)
            if (r3 == 0) goto L_0x00ba
            r19 = r2
            r20 = r16
            goto L_0x0126
        L_0x00ba:
            boolean r3 = r9.zzo()
            if (r3 != 0) goto L_0x00d6
            int r3 = r9.zzd(r15)
            if (r3 == 0) goto L_0x00cf
            int r3 = r3 + 2
            r19 = r2
            r20 = r3
            r3 = r17
            goto L_0x0126
        L_0x00cf:
            r19 = r16
            r3 = r17
            r20 = r3
            goto L_0x0126
        L_0x00d6:
            boolean r3 = r9.zzo()
            if (r3 != 0) goto L_0x00eb
            int r3 = r9.zzd(r6)
            int r3 = r3 + r7
            int r4 = r9.zzd(r7)
            r19 = r2
            r20 = r3
            r3 = r4
            goto L_0x0126
        L_0x00eb:
            int r3 = r9.zzd(r6)
            switch(r3) {
                case 0: goto L_0x0120;
                case 1: goto L_0x011b;
                case 2: goto L_0x010a;
                case 3: goto L_0x00fa;
                default: goto L_0x00f3;
            }
        L_0x00f3:
            r19 = r2
            r3 = r17
            r20 = r3
            goto L_0x0126
        L_0x00fa:
            int r3 = r9.zzd(r14)
            int r3 = r3 + 25
            int r4 = r9.zzd(r7)
            r19 = r2
            r20 = r3
            r3 = r4
            goto L_0x0126
        L_0x010a:
            int r3 = r9.zzd(r7)
            int r3 = r3 + 9
            int r4 = r9.zzd(r7)
            r19 = r2
            r20 = r3
            r3 = r4
            goto L_0x0126
        L_0x011b:
            r19 = r2
            r20 = r6
            goto L_0x0124
        L_0x0120:
            r19 = r2
            r20 = r16
        L_0x0124:
            r3 = r17
        L_0x0126:
            if (r20 == 0) goto L_0x014b
            if (r8 == 0) goto L_0x014b
            int r2 = r10 + 1
            float r4 = (float) r10
            if (r18 == 0) goto L_0x0131
            byte r3 = r18[r3]
        L_0x0131:
            float r2 = (float) r2
            r3 = r24[r3]
            r8.setColor(r3)
            float r3 = (float) r5
            int r0 = r5 + r20
            float r0 = (float) r0
            r21 = r2
            r2 = r29
            r22 = r5
            r5 = r0
            r0 = r6
            r6 = r21
            r7 = r28
            r2.drawRect(r3, r4, r5, r6, r7)
            goto L_0x014e
        L_0x014b:
            r22 = r5
            r0 = r6
        L_0x014e:
            int r5 = r22 + r20
            if (r19 == 0) goto L_0x0158
            r9.zze()
            r2 = r5
            goto L_0x0013
        L_0x0158:
            r6 = r0
            r2 = r19
            r7 = 4
            goto L_0x00ad
        L_0x015e:
            r0 = r6
            if (r1 != r15) goto L_0x016b
            if (r11 != 0) goto L_0x0168
            byte[] r3 = zzb
            r18 = r3
            goto L_0x0179
        L_0x0168:
            r18 = r11
            goto L_0x0179
        L_0x016b:
            if (r1 != r0) goto L_0x0177
            if (r13 != 0) goto L_0x0174
            byte[] r3 = zza
            r18 = r3
            goto L_0x0179
        L_0x0174:
            r18 = r13
            goto L_0x0179
        L_0x0177:
            r18 = 0
        L_0x0179:
            r7 = r2
            r2 = r17
        L_0x017c:
            int r3 = r9.zzd(r0)
            if (r3 == 0) goto L_0x018a
            r19 = r2
            r20 = r16
            r6 = 4
            goto L_0x01ee
        L_0x018a:
            boolean r3 = r9.zzo()
            if (r3 == 0) goto L_0x01a0
            int r3 = r9.zzd(r15)
            int r6 = r3 + 3
            int r3 = r9.zzd(r0)
            r19 = r2
            r20 = r6
            r6 = 4
            goto L_0x01ee
        L_0x01a0:
            boolean r3 = r9.zzo()
            if (r3 == 0) goto L_0x01ae
            r19 = r2
            r20 = r16
            r3 = r17
            r6 = 4
            goto L_0x01ee
        L_0x01ae:
            int r3 = r9.zzd(r0)
            switch(r3) {
                case 0: goto L_0x01e7;
                case 1: goto L_0x01df;
                case 2: goto L_0x01cd;
                case 3: goto L_0x01bd;
                default: goto L_0x01b5;
            }
        L_0x01b5:
            r6 = 4
            r19 = r2
            r3 = r17
            r20 = r3
            goto L_0x01ee
        L_0x01bd:
            int r3 = r9.zzd(r14)
            int r6 = r3 + 29
            int r3 = r9.zzd(r0)
            r19 = r2
            r20 = r6
            r6 = 4
            goto L_0x01ee
        L_0x01cd:
            r6 = 4
            int r3 = r9.zzd(r6)
            int r3 = r3 + 12
            int r4 = r9.zzd(r0)
            r19 = r2
            r20 = r3
            r3 = r4
            goto L_0x01ee
        L_0x01df:
            r6 = 4
            r20 = r0
            r19 = r2
            r3 = r17
            goto L_0x01ee
        L_0x01e7:
            r6 = 4
            r19 = r16
            r3 = r17
            r20 = r3
        L_0x01ee:
            if (r20 == 0) goto L_0x0217
            if (r8 == 0) goto L_0x0217
            int r2 = r10 + 1
            float r4 = (float) r10
            if (r18 == 0) goto L_0x01f9
            byte r3 = r18[r3]
        L_0x01f9:
            float r5 = (float) r2
            r2 = r24[r3]
            r8.setColor(r2)
            float r3 = (float) r7
            int r2 = r7 + r20
            float r2 = (float) r2
            r21 = r2
            r2 = r29
            r22 = r5
            r5 = r21
            r21 = r6
            r6 = r22
            r22 = r7
            r7 = r28
            r2.drawRect(r3, r4, r5, r6, r7)
            goto L_0x021b
        L_0x0217:
            r21 = r6
            r22 = r7
        L_0x021b:
            int r7 = r22 + r20
            if (r19 == 0) goto L_0x0225
            r9.zze()
            r2 = r7
            goto L_0x0013
        L_0x0225:
            r2 = r19
            goto L_0x017c
        L_0x0229:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzamh.zze(byte[], int[], int, int, int, android.graphics.Paint, android.graphics.Canvas):void");
    }

    private static byte[] zzf(int i, int i2, zzft zzft) {
        byte[] bArr = new byte[i];
        for (int i3 = 0; i3 < i; i3++) {
            bArr[i3] = (byte) zzft.zzd(i2);
        }
        return bArr;
    }

    private static int[] zzg() {
        return new int[]{0, -1, ViewCompat.MEASURED_STATE_MASK, -8421505};
    }

    private static int[] zzh() {
        int i;
        int i2;
        int[] iArr = new int[16];
        iArr[0] = 0;
        for (int i3 = 1; i3 < 16; i3++) {
            int i4 = i3 & 4;
            int i5 = i3 & 2;
            int i6 = i3 & 1;
            if (i3 < 8) {
                iArr[i3] = zzb(255, 1 != i6 ? 0 : 255, i5 != 0 ? 255 : 0, i4 != 0 ? 255 : 0);
            } else {
                int i7 = WorkQueueKt.MASK;
                if (1 != i6) {
                    i = 0;
                } else {
                    i = 127;
                }
                if (i5 != 0) {
                    i2 = 127;
                } else {
                    i2 = 0;
                }
                if (i4 == 0) {
                    i7 = 0;
                }
                iArr[i3] = zzb(255, i, i2, i7);
            }
        }
        return iArr;
    }

    private static int[] zzi() {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int[] iArr = new int[256];
        iArr[0] = 0;
        for (int i17 = 0; i17 < 256; i17++) {
            int i18 = 255;
            if (i17 >= 8) {
                int i19 = 170;
                int i20 = 43;
                int i21 = 85;
                switch (i17 & 136) {
                    case 0:
                        int i22 = i17 & 16;
                        int i23 = i17 & 32;
                        int i24 = i17 & 2;
                        int i25 = i17 & 64;
                        int i26 = i17 & 4;
                        if (1 != (i17 & 1)) {
                            i = 0;
                        } else {
                            i = 85;
                        }
                        if (i22 != 0) {
                            i2 = 170;
                        } else {
                            i2 = 0;
                        }
                        if (i24 != 0) {
                            i3 = 85;
                        } else {
                            i3 = 0;
                        }
                        if (i23 != 0) {
                            i4 = 170;
                        } else {
                            i4 = 0;
                        }
                        if (i26 == 0) {
                            i21 = 0;
                        }
                        if (i25 == 0) {
                            i19 = 0;
                        }
                        iArr[i17] = zzb(255, i + i2, i3 + i4, i21 + i19);
                        break;
                    case 8:
                        int i27 = i17 & 16;
                        int i28 = i17 & 32;
                        int i29 = i17 & 2;
                        int i30 = i17 & 64;
                        int i31 = i17 & 4;
                        if (1 != (i17 & 1)) {
                            i5 = 0;
                        } else {
                            i5 = 85;
                        }
                        if (i27 != 0) {
                            i6 = 170;
                        } else {
                            i6 = 0;
                        }
                        if (i29 != 0) {
                            i7 = 85;
                        } else {
                            i7 = 0;
                        }
                        if (i28 != 0) {
                            i8 = 170;
                        } else {
                            i8 = 0;
                        }
                        if (i31 == 0) {
                            i21 = 0;
                        }
                        if (i30 == 0) {
                            i19 = 0;
                        }
                        iArr[i17] = zzb(WorkQueueKt.MASK, i5 + i6, i7 + i8, i21 + i19);
                        break;
                    case 128:
                        int i32 = i17 & 16;
                        int i33 = i17 & 32;
                        int i34 = i17 & 2;
                        int i35 = i17 & 64;
                        int i36 = i17 & 4;
                        if (1 != (i17 & 1)) {
                            i9 = 0;
                        } else {
                            i9 = 43;
                        }
                        int i37 = i9 + WorkQueueKt.MASK;
                        if (i32 != 0) {
                            i10 = 85;
                        } else {
                            i10 = 0;
                        }
                        if (i34 != 0) {
                            i11 = 43;
                        } else {
                            i11 = 0;
                        }
                        int i38 = i11 + WorkQueueKt.MASK;
                        if (i33 != 0) {
                            i12 = 85;
                        } else {
                            i12 = 0;
                        }
                        if (i36 == 0) {
                            i20 = 0;
                        }
                        int i39 = i20 + WorkQueueKt.MASK;
                        if (i35 == 0) {
                            i21 = 0;
                        }
                        iArr[i17] = zzb(255, i37 + i10, i38 + i12, i39 + i21);
                        break;
                    case 136:
                        int i40 = i17 & 16;
                        int i41 = i17 & 32;
                        int i42 = i17 & 2;
                        int i43 = i17 & 64;
                        int i44 = i17 & 4;
                        if (1 != (i17 & 1)) {
                            i13 = 0;
                        } else {
                            i13 = 43;
                        }
                        if (i40 != 0) {
                            i14 = 85;
                        } else {
                            i14 = 0;
                        }
                        if (i42 != 0) {
                            i15 = 43;
                        } else {
                            i15 = 0;
                        }
                        if (i41 != 0) {
                            i16 = 85;
                        } else {
                            i16 = 0;
                        }
                        if (i44 == 0) {
                            i20 = 0;
                        }
                        if (i43 == 0) {
                            i21 = 0;
                        }
                        iArr[i17] = zzb(255, i13 + i14, i15 + i16, i20 + i21);
                        break;
                }
            } else {
                int i45 = i17 & 2;
                int i46 = i17 & 4;
                int i47 = 1 != (i17 & 1) ? 0 : 255;
                int i48 = i45 != 0 ? 255 : 0;
                if (i46 == 0) {
                    i18 = 0;
                }
                iArr[i17] = zzb(63, i47, i48, i18);
            }
        }
        return iArr;
    }

    public final void zza(byte[] bArr, int i, int i2, zzalu zzalu, zzev zzev) {
        zzaln zzaln;
        char c;
        char c2;
        int i3;
        int i4;
        SparseArray sparseArray;
        SparseArray sparseArray2;
        Paint paint;
        int[] iArr;
        zzame zzame;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12 = i;
        zzft zzft = new zzft(bArr, i12 + i2);
        zzft.zzk(i12);
        while (zzft.zza() >= 48 && zzft.zzd(8) == 15) {
            zzamg zzamg = this.zzi;
            int zzd2 = zzft.zzd(8);
            int zzd3 = zzft.zzd(16);
            int zzd4 = zzft.zzd(16);
            int zzb2 = zzft.zzb() + zzd4;
            if (zzd4 * 8 > zzft.zza()) {
                zzfk.zzf("DvbParser", "Data field length exceeds limit");
                zzft.zzm(zzft.zza());
            } else {
                switch (zzd2) {
                    case 16:
                        if (zzd3 == zzamg.zza) {
                            zzamc zzamc = zzamg.zzi;
                            int zzd5 = zzft.zzd(8);
                            int zzd6 = zzft.zzd(4);
                            int zzd7 = zzft.zzd(2);
                            zzft.zzm(2);
                            SparseArray sparseArray3 = new SparseArray();
                            for (int i13 = zzd4 - 2; i13 > 0; i13 -= 6) {
                                int zzd8 = zzft.zzd(8);
                                zzft.zzm(8);
                                sparseArray3.put(zzd8, new zzamd(zzft.zzd(16), zzft.zzd(16)));
                            }
                            zzamc zzamc2 = new zzamc(zzd5, zzd6, zzd7, sparseArray3);
                            if (zzamc2.zzb == 0) {
                                if (!(zzamc == null || zzamc.zza == zzamc2.zza)) {
                                    zzamg.zzi = zzamc2;
                                    break;
                                }
                            } else {
                                zzamg.zzi = zzamc2;
                                zzamg.zzc.clear();
                                zzamg.zzd.clear();
                                zzamg.zze.clear();
                                break;
                            }
                        }
                        break;
                    case 17:
                        zzamc zzamc3 = zzamg.zzi;
                        if (zzd3 == zzamg.zza && zzamc3 != null) {
                            int zzd9 = zzft.zzd(8);
                            zzft.zzm(4);
                            boolean zzo = zzft.zzo();
                            zzft.zzm(3);
                            int zzd10 = zzft.zzd(16);
                            int zzd11 = zzft.zzd(16);
                            int zzd12 = zzft.zzd(3);
                            int zzd13 = zzft.zzd(3);
                            zzft.zzm(2);
                            int zzd14 = zzft.zzd(8);
                            int zzd15 = zzft.zzd(8);
                            int zzd16 = zzft.zzd(4);
                            int zzd17 = zzft.zzd(2);
                            zzft.zzm(2);
                            int i14 = zzd4 - 10;
                            SparseArray sparseArray4 = new SparseArray();
                            while (i14 > 0) {
                                int zzd18 = zzft.zzd(16);
                                int zzd19 = zzft.zzd(2);
                                int zzd20 = zzft.zzd(2);
                                int zzd21 = zzft.zzd(12);
                                zzft.zzm(4);
                                int zzd22 = zzft.zzd(12);
                                i14 -= 6;
                                if (zzd19 != 1) {
                                    if (zzd19 == 2) {
                                        zzd19 = 2;
                                    } else {
                                        i7 = zzd19;
                                        i6 = 0;
                                        i5 = 0;
                                        sparseArray4.put(zzd18, new zzamf(i7, zzd20, zzd21, zzd22, i6, i5));
                                    }
                                }
                                i14 -= 2;
                                i7 = zzd19;
                                i6 = zzft.zzd(8);
                                i5 = zzft.zzd(8);
                                sparseArray4.put(zzd18, new zzamf(i7, zzd20, zzd21, zzd22, i6, i5));
                            }
                            zzame zzame2 = new zzame(zzd9, zzo, zzd10, zzd11, zzd12, zzd13, zzd14, zzd15, zzd16, zzd17, sparseArray4);
                            if (zzamc3.zzb == 0 && (zzame = (zzame) zzamg.zzc.get(zzame2.zza)) != null) {
                                int i15 = 0;
                                while (true) {
                                    SparseArray sparseArray5 = zzame.zzj;
                                    if (i15 < sparseArray5.size()) {
                                        zzame2.zzj.put(sparseArray5.keyAt(i15), (zzamf) sparseArray5.valueAt(i15));
                                        i15++;
                                    }
                                }
                            }
                            zzamg.zzc.put(zzame2.zza, zzame2);
                            break;
                        }
                    case 18:
                        if (zzd3 != zzamg.zza) {
                            if (zzd3 == zzamg.zzb) {
                                zzalz zzc2 = zzc(zzft, zzd4);
                                zzamg.zzf.put(zzc2.zza, zzc2);
                                break;
                            }
                        } else {
                            zzalz zzc3 = zzc(zzft, zzd4);
                            zzamg.zzd.put(zzc3.zza, zzc3);
                            break;
                        }
                        break;
                    case 19:
                        if (zzd3 != zzamg.zza) {
                            if (zzd3 == zzamg.zzb) {
                                zzamb zzd23 = zzd(zzft);
                                zzamg.zzg.put(zzd23.zza, zzd23);
                                break;
                            }
                        } else {
                            zzamb zzd24 = zzd(zzft);
                            zzamg.zze.put(zzd24.zza, zzd24);
                            break;
                        }
                        break;
                    case 20:
                        if (zzd3 == zzamg.zza) {
                            zzft.zzm(4);
                            boolean zzo2 = zzft.zzo();
                            zzft.zzm(3);
                            int zzd25 = zzft.zzd(16);
                            int zzd26 = zzft.zzd(16);
                            if (zzo2) {
                                int zzd27 = zzft.zzd(16);
                                i10 = zzft.zzd(16);
                                i9 = zzft.zzd(16);
                                i8 = zzft.zzd(16);
                                i11 = zzd27;
                            } else {
                                i10 = zzd25;
                                i8 = zzd26;
                                i11 = 0;
                                i9 = 0;
                            }
                            zzamg.zzh = new zzama(zzd25, zzd26, i11, i10, i9, i8);
                            break;
                        }
                        break;
                }
                zzft.zzn(zzb2 - zzft.zzb());
            }
        }
        zzamg zzamg2 = this.zzi;
        zzamc zzamc4 = zzamg2.zzi;
        if (zzamc4 == null) {
            zzaln = new zzaln(zzgbc.zzm(), -9223372036854775807L, -9223372036854775807L);
        } else {
            zzama zzama = zzamg2.zzh;
            if (zzama == null) {
                zzama = this.zzg;
            }
            Bitmap bitmap = this.zzj;
            if (!(bitmap != null && zzama.zza + 1 == bitmap.getWidth() && zzama.zzb + 1 == this.zzj.getHeight())) {
                this.zzj = Bitmap.createBitmap(zzama.zza + 1, zzama.zzb + 1, Bitmap.Config.ARGB_8888);
                this.zzf.setBitmap(this.zzj);
            }
            ArrayList arrayList = new ArrayList();
            SparseArray sparseArray6 = zzamc4.zzc;
            int i16 = 0;
            while (i16 < sparseArray6.size()) {
                this.zzf.save();
                zzamd zzamd = (zzamd) sparseArray6.valueAt(i16);
                zzame zzame3 = (zzame) this.zzi.zzc.get(sparseArray6.keyAt(i16));
                int i17 = zzamd.zza + zzama.zzc;
                int i18 = zzamd.zzb + zzama.zze;
                this.zzf.clipRect(i17, i18, Math.min(zzame3.zzc + i17, zzama.zzd), Math.min(zzame3.zzd + i18, zzama.zzf));
                zzalz zzalz = (zzalz) this.zzi.zzd.get(zzame3.zzf);
                if (zzalz == null) {
                    zzalz = (zzalz) this.zzi.zzf.get(zzame3.zzf);
                    if (zzalz == null) {
                        zzalz = this.zzh;
                    }
                }
                SparseArray sparseArray7 = zzame3.zzj;
                int i19 = 0;
                while (i19 < sparseArray7.size()) {
                    int keyAt = sparseArray7.keyAt(i19);
                    zzamf zzamf = (zzamf) sparseArray7.valueAt(i19);
                    zzamb zzamb = (zzamb) this.zzi.zze.get(keyAt);
                    if (zzamb == null) {
                        zzamb = (zzamb) this.zzi.zzg.get(keyAt);
                    }
                    if (zzamb != null) {
                        if (zzamb.zzb) {
                            paint = null;
                        } else {
                            paint = this.zzd;
                        }
                        int i20 = zzame3.zze;
                        int i21 = zzamf.zza + i17;
                        int i22 = zzamf.zzb + i18;
                        sparseArray2 = sparseArray6;
                        Canvas canvas = this.zzf;
                        sparseArray = sparseArray7;
                        if (i20 == 3) {
                            iArr = zzalz.zzd;
                        } else if (i20 == 2) {
                            iArr = zzalz.zzc;
                        } else {
                            iArr = zzalz.zzb;
                        }
                        i4 = i16;
                        int[] iArr2 = iArr;
                        int i23 = i20;
                        int i24 = i21;
                        Paint paint2 = paint;
                        Canvas canvas2 = canvas;
                        zze(zzamb.zzc, iArr2, i23, i24, i22, paint2, canvas2);
                        zze(zzamb.zzd, iArr2, i23, i24, i22 + 1, paint2, canvas2);
                    } else {
                        sparseArray2 = sparseArray6;
                        i4 = i16;
                        sparseArray = sparseArray7;
                    }
                    i19++;
                    sparseArray6 = sparseArray2;
                    sparseArray7 = sparseArray;
                    i16 = i4;
                }
                SparseArray sparseArray8 = sparseArray6;
                int i25 = i16;
                float f = (float) i18;
                float f2 = (float) i17;
                if (zzame3.zzb) {
                    int i26 = zzame3.zze;
                    c2 = 3;
                    if (i26 == 3) {
                        i3 = zzalz.zzd[zzame3.zzg];
                        c = 2;
                    } else {
                        c = 2;
                        if (i26 == 2) {
                            i3 = zzalz.zzc[zzame3.zzh];
                        } else {
                            i3 = zzalz.zzb[zzame3.zzi];
                        }
                    }
                    this.zze.setColor(i3);
                    this.zzf.drawRect(f2, f, (float) (zzame3.zzc + i17), (float) (zzame3.zzd + i18), this.zze);
                } else {
                    c2 = 3;
                    c = 2;
                }
                zzeg zzeg = new zzeg();
                zzeg.zzc(Bitmap.createBitmap(this.zzj, i17, i18, zzame3.zzc, zzame3.zzd));
                zzeg.zzh(f2 / ((float) zzama.zza));
                zzeg.zzi(0);
                zzeg.zze(f / ((float) zzama.zzb), 0);
                zzeg.zzf(0);
                zzeg.zzk(((float) zzame3.zzc) / ((float) zzama.zza));
                zzeg.zzd(((float) zzame3.zzd) / ((float) zzama.zzb));
                arrayList.add(zzeg.zzp());
                this.zzf.drawColor(0, PorterDuff.Mode.CLEAR);
                this.zzf.restore();
                i16 = i25 + 1;
                char c3 = c2;
                char c4 = c;
                sparseArray6 = sparseArray8;
            }
            zzaln = new zzaln(arrayList, -9223372036854775807L, -9223372036854775807L);
        }
        zzev.zza(zzaln);
    }
}
