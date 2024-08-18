package com.google.android.gms.internal.ads;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzahq {
    public static final zzaho zza = new zzahn();

    public static final zzcd zza(byte[] bArr, int i, zzaho zzaho, zzagr zzagr) {
        zzahp zzahp;
        ArrayList arrayList = new ArrayList();
        zzfu zzfu = new zzfu(bArr, i);
        boolean z = false;
        int i2 = 10;
        if (zzfu.zzb() < 10) {
            zzfk.zzf("Id3Decoder", "Data too short to be an ID3 tag");
            zzahp = null;
        } else {
            int zzo = zzfu.zzo();
            if (zzo != 4801587) {
                zzfk.zzf("Id3Decoder", "Unexpected first three bytes of ID3 tag header: 0x".concat(String.valueOf(String.format("%06X", new Object[]{Integer.valueOf(zzo)}))));
                zzahp = null;
            } else {
                int zzm = zzfu.zzm();
                zzfu.zzL(1);
                int zzm2 = zzfu.zzm();
                int zzl = zzfu.zzl();
                if (zzm == 2) {
                    if ((zzm2 & 64) != 0) {
                        zzfk.zzf("Id3Decoder", "Skipped ID3 tag with majorVersion=2 and undefined compression scheme");
                        zzahp = null;
                    }
                } else if (zzm == 3) {
                    if ((zzm2 & 64) != 0) {
                        int zzg = zzfu.zzg();
                        zzfu.zzL(zzg);
                        zzl -= zzg + 4;
                    }
                } else if (zzm == 4) {
                    if ((zzm2 & 64) != 0) {
                        int zzl2 = zzfu.zzl();
                        zzfu.zzL(zzl2 - 4);
                        zzl -= zzl2;
                    }
                    if ((zzm2 & 16) != 0) {
                        zzl -= 10;
                    }
                } else {
                    zzfk.zzf("Id3Decoder", "Skipped ID3 tag with unsupported majorVersion=" + zzm);
                    zzahp = null;
                }
                zzahp = new zzahp(zzm, zzm < 4 && (zzm2 & 128) != 0, zzl);
            }
        }
        if (zzahp == null) {
            return null;
        }
        int zzd = zzfu.zzd();
        if (zzahp.zza == 2) {
            i2 = 6;
        }
        int zza2 = zzahp.zzc;
        if (zzahp.zzb) {
            zza2 = zze(zzfu, zzahp.zzc);
        }
        zzfu.zzJ(zzd + zza2);
        if (!zzk(zzfu, zzahp.zza, i2, false)) {
            if (zzahp.zza != 4 || !zzk(zzfu, 4, i2, true)) {
                zzfk.zzf("Id3Decoder", "Failed to validate ID3 tag with majorVersion=" + zzahp.zza);
                return null;
            }
            z = true;
        }
        while (zzfu.zzb() >= i2) {
            zzahr zzf = zzf(zzahp.zza, zzfu, z, i2, zzaho);
            if (zzf != null) {
                arrayList.add(zzf);
            }
        }
        return new zzcd((List) arrayList);
    }

    private static int zzb(int i) {
        return (i == 0 || i == 3) ? 1 : 2;
    }

    private static int zzc(byte[] bArr, int i, int i2) {
        int zzd = zzd(bArr, i);
        if (i2 == 0 || i2 == 3) {
            return zzd;
        }
        while (true) {
            int length = bArr.length;
            if (zzd >= length - 1) {
                return length;
            }
            int i3 = zzd + 1;
            if ((zzd - i) % 2 == 0 && bArr[i3] == 0) {
                return zzd;
            }
            zzd = zzd(bArr, i3);
        }
    }

    private static int zzd(byte[] bArr, int i) {
        while (true) {
            int length = bArr.length;
            if (i >= length) {
                return length;
            }
            if (bArr[i] == 0) {
                return i;
            }
            i++;
        }
    }

    private static int zze(zzfu zzfu, int i) {
        byte[] zzM = zzfu.zzM();
        int zzd = zzfu.zzd();
        int i2 = zzd;
        while (true) {
            int i3 = i2 + 1;
            if (i3 >= zzd + i) {
                return i;
            }
            if ((zzM[i2] & 255) == 255 && zzM[i3] == 0) {
                System.arraycopy(zzM, i2 + 2, zzM, i3, (i - (i2 - zzd)) - 2);
                i--;
            }
            i2 = i3;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v13, resolved type: com.google.android.gms.internal.ads.zzfu} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v15, resolved type: com.google.android.gms.internal.ads.zzfu} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v71, resolved type: com.google.android.gms.internal.ads.zzfu} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v74, resolved type: com.google.android.gms.internal.ads.zzfu} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v77, resolved type: com.google.android.gms.internal.ads.zzfu} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v78, resolved type: com.google.android.gms.internal.ads.zzfu} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v79, resolved type: com.google.android.gms.internal.ads.zzfu} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v80, resolved type: com.google.android.gms.internal.ads.zzfu} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v83, resolved type: com.google.android.gms.internal.ads.zzfu} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v86, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v87, resolved type: java.lang.String} */
    /* JADX WARNING: type inference failed for: r2v3 */
    /* JADX WARNING: type inference failed for: r2v10 */
    /* JADX WARNING: type inference failed for: r2v24 */
    /* JADX WARNING: type inference failed for: r2v36 */
    /* JADX WARNING: type inference failed for: r2v37 */
    /* JADX WARNING: type inference failed for: r2v42 */
    /* JADX WARNING: type inference failed for: r2v43 */
    /* JADX WARNING: type inference failed for: r2v44 */
    /* JADX WARNING: type inference failed for: r2v45 */
    /* JADX WARNING: type inference failed for: r2v46 */
    /* JADX WARNING: type inference failed for: r2v47 */
    /* JADX WARNING: type inference failed for: r2v48 */
    /* JADX WARNING: type inference failed for: r2v49 */
    /* JADX WARNING: type inference failed for: r2v50 */
    /* JADX WARNING: type inference failed for: r2v51 */
    /* JADX WARNING: type inference failed for: r25v3, types: [com.google.android.gms.internal.ads.zzahv] */
    /* JADX WARNING: type inference failed for: r25v4, types: [com.google.android.gms.internal.ads.zzahg] */
    /* JADX WARNING: Code restructure failed: missing block: B:138:0x02bd, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:139:0x02c0, code lost:
        r23 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:140:0x02c3, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:141:0x02c6, code lost:
        r23 = r5;
        r22 = "Id3Decoder";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:142:0x02ca, code lost:
        r8 = r2;
        r3 = r6;
        r4 = r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:168:0x0331, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:236:0x0488, code lost:
        r0 = th;
        r8 = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:263:0x050f, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:265:0x0511, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:266:0x0512, code lost:
        r21 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:267:0x0515, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:269:0x0517, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:270:0x0518, code lost:
        r21 = r6;
        r20 = r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:283:0x0563, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:284:0x0566, code lost:
        r2 = r0;
        r10 = r18;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:285:0x056a, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:286:0x056d, code lost:
        r21 = r6;
        r20 = r7;
        r18 = r10;
        r2 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:287:0x0574, code lost:
        r4 = r20;
        r3 = r21;
        r8 = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:301:0x05d9, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:302:0x05dc, code lost:
        r2 = r0;
        r8 = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x017e, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:0x017f, code lost:
        r1 = r0;
        r8 = r2;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:205:0x03c2, B:246:0x04a2] */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:205:0x03c2, B:255:0x04e8] */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:205:0x03c2, B:258:0x04ec] */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:205:0x03c2, B:261:0x04f6] */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:205:0x03c2, B:296:0x0594] */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:80:0x0110, B:129:0x0269] */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:80:0x0110, B:132:0x0281] */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:80:0x0110, B:135:0x0286] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:236:0x0488 A[ExcHandler: all (th java.lang.Throwable), PHI: r8 r24 
      PHI: (r8v15 com.google.android.gms.internal.ads.zzfu) = (r8v71 com.google.android.gms.internal.ads.zzfu), (r8v74 com.google.android.gms.internal.ads.zzfu), (r8v77 com.google.android.gms.internal.ads.zzfu), (r8v78 com.google.android.gms.internal.ads.zzfu), (r8v79 com.google.android.gms.internal.ads.zzfu), (r8v80 com.google.android.gms.internal.ads.zzfu), (r8v83 com.google.android.gms.internal.ads.zzfu), (r8v87 java.lang.String) binds: [B:296:0x0594, B:246:0x04a2, B:255:0x04e8, B:256:?, B:258:0x04ec, B:261:0x04f6, B:205:0x03c2, B:181:0x0367] A[DONT_GENERATE, DONT_INLINE]
      PHI: (r24v5 int) = (r24v6 int), (r24v6 int), (r24v6 int), (r24v6 int), (r24v6 int), (r24v6 int), (r24v6 int), (r24v13 int) binds: [B:296:0x0594, B:246:0x04a2, B:255:0x04e8, B:256:?, B:258:0x04ec, B:261:0x04f6, B:205:0x03c2, B:181:0x0367] A[DONT_GENERATE, DONT_INLINE], Splitter:B:205:0x03c2] */
    /* JADX WARNING: Removed duplicated region for block: B:290:0x0582  */
    /* JADX WARNING: Removed duplicated region for block: B:305:0x05e7  */
    /* JADX WARNING: Removed duplicated region for block: B:318:0x061b  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x017e A[Catch:{ OutOfMemoryError -> 0x0185, Exception -> 0x0183, all -> 0x017e }, ExcHandler: all (r0v1 'th' java.lang.Throwable A[CUSTOM_DECLARE, Catch:{ OutOfMemoryError -> 0x0185, Exception -> 0x0183, all -> 0x017e }]), Splitter:B:80:0x0110] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.google.android.gms.internal.ads.zzahr zzf(int r35, com.google.android.gms.internal.ads.zzfu r36, boolean r37, int r38, com.google.android.gms.internal.ads.zzaho r39) {
        /*
            r1 = r35
            r2 = r36
            r3 = r37
            r4 = r38
            int r5 = r36.zzm()
            int r6 = r36.zzm()
            int r7 = r36.zzm()
            r9 = 3
            if (r1 < r9) goto L_0x001c
            int r10 = r36.zzm()
            goto L_0x001d
        L_0x001c:
            r10 = 0
        L_0x001d:
            r11 = 4
            if (r1 != r11) goto L_0x003c
            int r12 = r36.zzp()
            if (r3 != 0) goto L_0x0047
            r13 = r12 & 255(0xff, float:3.57E-43)
            int r14 = r12 >> 8
            r14 = r14 & 255(0xff, float:3.57E-43)
            int r15 = r12 >> 16
            r15 = r15 & 255(0xff, float:3.57E-43)
            int r12 = r12 >> 24
            int r14 = r14 << 7
            r13 = r13 | r14
            int r14 = r15 << 14
            r13 = r13 | r14
            int r12 = r12 << 21
            r12 = r12 | r13
            goto L_0x0047
        L_0x003c:
            if (r1 != r9) goto L_0x0043
            int r12 = r36.zzp()
            goto L_0x0047
        L_0x0043:
            int r12 = r36.zzo()
        L_0x0047:
            if (r1 < r9) goto L_0x004e
            int r13 = r36.zzq()
            goto L_0x004f
        L_0x004e:
            r13 = 0
        L_0x004f:
            r14 = 0
            if (r5 != 0) goto L_0x0065
            if (r6 != 0) goto L_0x0065
            if (r7 != 0) goto L_0x0065
            if (r10 != 0) goto L_0x0065
            if (r12 != 0) goto L_0x0065
            if (r13 == 0) goto L_0x005d
            goto L_0x0065
        L_0x005d:
            int r1 = r36.zze()
            r2.zzK(r1)
            return r14
        L_0x0065:
            int r15 = r36.zzd()
            int r15 = r15 + r12
            int r8 = r36.zze()
            java.lang.String r11 = "Id3Decoder"
            if (r15 <= r8) goto L_0x007f
            java.lang.String r1 = "Frame size exceeds remaining tag data"
            com.google.android.gms.internal.ads.zzfk.zzf(r11, r1)
            int r1 = r36.zze()
            r2.zzK(r1)
            return r14
        L_0x007f:
            if (r39 != 0) goto L_0x064c
            r8 = 1
            if (r1 != r9) goto L_0x00a2
            r17 = r13 & 64
            r9 = r13 & 128(0x80, float:1.794E-43)
            if (r9 == 0) goto L_0x008c
            r9 = r8
            goto L_0x008d
        L_0x008c:
            r9 = 0
        L_0x008d:
            if (r17 == 0) goto L_0x0092
            r17 = r8
            goto L_0x0094
        L_0x0092:
            r17 = 0
        L_0x0094:
            r13 = r13 & 32
            if (r13 == 0) goto L_0x009a
            r13 = r8
            goto L_0x009b
        L_0x009a:
            r13 = 0
        L_0x009b:
            r19 = r17
            r20 = 0
            r17 = r9
            goto L_0x00d6
        L_0x00a2:
            r9 = 4
            if (r1 != r9) goto L_0x00ce
            r9 = r13 & 64
            if (r9 == 0) goto L_0x00ab
            r9 = r8
            goto L_0x00ac
        L_0x00ab:
            r9 = 0
        L_0x00ac:
            r17 = r13 & 8
            if (r17 == 0) goto L_0x00b3
            r17 = r8
            goto L_0x00b5
        L_0x00b3:
            r17 = 0
        L_0x00b5:
            r19 = r13 & 4
            if (r19 == 0) goto L_0x00bc
            r19 = r8
            goto L_0x00be
        L_0x00bc:
            r19 = 0
        L_0x00be:
            r20 = r13 & 2
            if (r20 == 0) goto L_0x00c5
            r20 = r8
            goto L_0x00c7
        L_0x00c5:
            r20 = 0
        L_0x00c7:
            r13 = r13 & r8
            r34 = r13
            r13 = r9
            r9 = r34
            goto L_0x00d6
        L_0x00ce:
            r9 = 0
            r13 = 0
            r17 = 0
            r19 = 0
            r20 = 0
        L_0x00d6:
            if (r17 != 0) goto L_0x0640
            if (r19 == 0) goto L_0x00de
            r8 = r2
            r3 = r11
            goto L_0x0642
        L_0x00de:
            if (r13 == 0) goto L_0x00e5
            r2.zzL(r8)
            int r12 = r12 + -1
        L_0x00e5:
            if (r9 == 0) goto L_0x00ed
            r9 = 4
            r2.zzL(r9)
            int r12 = r12 + -4
        L_0x00ed:
            if (r20 == 0) goto L_0x00f3
            int r12 = zze(r2, r12)
        L_0x00f3:
            r9 = 84
            r13 = 88
            r8 = 2
            if (r5 != r9) goto L_0x0145
            if (r6 != r13) goto L_0x0145
            if (r7 != r13) goto L_0x0145
            if (r1 == r8) goto L_0x0102
            if (r10 != r13) goto L_0x0145
        L_0x0102:
            if (r12 > 0) goto L_0x0110
            r8 = r2
            r23 = r5
            r3 = r6
            r4 = r7
            r22 = r11
            r2 = r14
            r24 = r15
            goto L_0x05fd
        L_0x0110:
            int r3 = r36.zzm()     // Catch:{ OutOfMemoryError -> 0x0185, Exception -> 0x0183, all -> 0x017e }
            int r4 = r12 + -1
            byte[] r8 = new byte[r4]     // Catch:{ OutOfMemoryError -> 0x0185, Exception -> 0x0183, all -> 0x017e }
            r9 = 0
            r2.zzG(r8, r9, r4)     // Catch:{ OutOfMemoryError -> 0x0185, Exception -> 0x0183, all -> 0x017e }
            int r4 = zzc(r8, r9, r3)     // Catch:{ OutOfMemoryError -> 0x0185, Exception -> 0x0183, all -> 0x017e }
            java.lang.String r13 = new java.lang.String     // Catch:{ OutOfMemoryError -> 0x0185, Exception -> 0x0183, all -> 0x017e }
            java.nio.charset.Charset r14 = zzj(r3)     // Catch:{ OutOfMemoryError -> 0x0185, Exception -> 0x0183, all -> 0x017e }
            r13.<init>(r8, r9, r4, r14)     // Catch:{ OutOfMemoryError -> 0x0185, Exception -> 0x0183, all -> 0x017e }
            int r9 = zzb(r3)     // Catch:{ OutOfMemoryError -> 0x0185, Exception -> 0x0183, all -> 0x017e }
            int r4 = r4 + r9
            com.google.android.gms.internal.ads.zzgbc r3 = zzg(r8, r3, r4)     // Catch:{ OutOfMemoryError -> 0x0185, Exception -> 0x0183, all -> 0x017e }
            com.google.android.gms.internal.ads.zzahz r4 = new com.google.android.gms.internal.ads.zzahz     // Catch:{ OutOfMemoryError -> 0x0185, Exception -> 0x0183, all -> 0x017e }
            java.lang.String r8 = "TXXX"
            r4.<init>(r8, r13, r3)     // Catch:{ OutOfMemoryError -> 0x0185, Exception -> 0x0183, all -> 0x017e }
            r8 = r2
            r2 = r4
            r23 = r5
            r3 = r6
            r4 = r7
            r22 = r11
            r24 = r15
            goto L_0x05fd
        L_0x0145:
            if (r5 != r9) goto L_0x0190
            java.lang.String r3 = zzi(r1, r9, r6, r7, r10)     // Catch:{ OutOfMemoryError -> 0x0185, Exception -> 0x0183, all -> 0x017e }
            if (r12 > 0) goto L_0x0159
            r8 = r2
            r23 = r5
            r3 = r6
            r4 = r7
            r22 = r11
            r24 = r15
            r2 = 0
            goto L_0x05fd
        L_0x0159:
            int r4 = r36.zzm()     // Catch:{ OutOfMemoryError -> 0x0185, Exception -> 0x0183, all -> 0x017e }
            int r8 = r12 + -1
            byte[] r9 = new byte[r8]     // Catch:{ OutOfMemoryError -> 0x0185, Exception -> 0x0183, all -> 0x017e }
            r13 = 0
            r2.zzG(r9, r13, r8)     // Catch:{ OutOfMemoryError -> 0x0185, Exception -> 0x0183, all -> 0x017e }
            com.google.android.gms.internal.ads.zzgbc r4 = zzg(r9, r4, r13)     // Catch:{ OutOfMemoryError -> 0x0185, Exception -> 0x0183, all -> 0x017e }
            com.google.android.gms.internal.ads.zzahz r8 = new com.google.android.gms.internal.ads.zzahz     // Catch:{ OutOfMemoryError -> 0x0185, Exception -> 0x0183, all -> 0x017e }
            r9 = 0
            r8.<init>(r3, r9, r4)     // Catch:{ OutOfMemoryError -> 0x0185, Exception -> 0x0183, all -> 0x017e }
            r23 = r5
            r3 = r6
            r4 = r7
            r22 = r11
            r24 = r15
            r34 = r8
            r8 = r2
            r2 = r34
            goto L_0x05fd
        L_0x017e:
            r0 = move-exception
            r1 = r0
            r8 = r2
            goto L_0x060a
        L_0x0183:
            r0 = move-exception
            goto L_0x0186
        L_0x0185:
            r0 = move-exception
        L_0x0186:
            r8 = r2
            r23 = r5
            r3 = r6
            r4 = r7
            r22 = r11
        L_0x018d:
            r2 = r0
            goto L_0x0615
        L_0x0190:
            r14 = 87
            if (r5 != r14) goto L_0x01ea
            if (r6 != r13) goto L_0x01e8
            if (r7 != r13) goto L_0x01e8
            if (r1 == r8) goto L_0x019f
            if (r10 != r13) goto L_0x019d
            goto L_0x019f
        L_0x019d:
            r13 = r14
            goto L_0x01eb
        L_0x019f:
            if (r12 > 0) goto L_0x01ad
            r8 = r2
            r23 = r5
            r3 = r6
            r4 = r7
            r22 = r11
            r24 = r15
            r2 = 0
            goto L_0x05fd
        L_0x01ad:
            int r3 = r36.zzm()     // Catch:{ OutOfMemoryError -> 0x0185, Exception -> 0x0183, all -> 0x017e }
            int r4 = r12 + -1
            byte[] r8 = new byte[r4]     // Catch:{ OutOfMemoryError -> 0x0185, Exception -> 0x0183, all -> 0x017e }
            r9 = 0
            r2.zzG(r8, r9, r4)     // Catch:{ OutOfMemoryError -> 0x0185, Exception -> 0x0183, all -> 0x017e }
            int r4 = zzc(r8, r9, r3)     // Catch:{ OutOfMemoryError -> 0x0185, Exception -> 0x0183, all -> 0x017e }
            java.lang.String r13 = new java.lang.String     // Catch:{ OutOfMemoryError -> 0x0185, Exception -> 0x0183, all -> 0x017e }
            java.nio.charset.Charset r14 = zzj(r3)     // Catch:{ OutOfMemoryError -> 0x0185, Exception -> 0x0183, all -> 0x017e }
            r13.<init>(r8, r9, r4, r14)     // Catch:{ OutOfMemoryError -> 0x0185, Exception -> 0x0183, all -> 0x017e }
            int r3 = zzb(r3)     // Catch:{ OutOfMemoryError -> 0x0185, Exception -> 0x0183, all -> 0x017e }
            int r4 = r4 + r3
            int r3 = zzd(r8, r4)     // Catch:{ OutOfMemoryError -> 0x0185, Exception -> 0x0183, all -> 0x017e }
            java.nio.charset.Charset r9 = com.google.android.gms.internal.ads.zzfxs.zzb     // Catch:{ OutOfMemoryError -> 0x0185, Exception -> 0x0183, all -> 0x017e }
            java.lang.String r3 = zzh(r8, r4, r3, r9)     // Catch:{ OutOfMemoryError -> 0x0185, Exception -> 0x0183, all -> 0x017e }
            com.google.android.gms.internal.ads.zzaib r4 = new com.google.android.gms.internal.ads.zzaib     // Catch:{ OutOfMemoryError -> 0x0185, Exception -> 0x0183, all -> 0x017e }
            java.lang.String r8 = "WXXX"
            r4.<init>(r8, r13, r3)     // Catch:{ OutOfMemoryError -> 0x0185, Exception -> 0x0183, all -> 0x017e }
            r8 = r2
            r2 = r4
            r23 = r5
            r3 = r6
            r4 = r7
            r22 = r11
            r24 = r15
            goto L_0x05fd
        L_0x01e8:
            r13 = r14
            goto L_0x01eb
        L_0x01ea:
            r13 = r5
        L_0x01eb:
            if (r13 != r14) goto L_0x0214
            java.lang.String r3 = zzi(r1, r14, r6, r7, r10)     // Catch:{ OutOfMemoryError -> 0x0185, Exception -> 0x0183, all -> 0x017e }
            byte[] r4 = new byte[r12]     // Catch:{ OutOfMemoryError -> 0x0185, Exception -> 0x0183, all -> 0x017e }
            r8 = 0
            r2.zzG(r4, r8, r12)     // Catch:{ OutOfMemoryError -> 0x0185, Exception -> 0x0183, all -> 0x017e }
            int r9 = zzd(r4, r8)     // Catch:{ OutOfMemoryError -> 0x0185, Exception -> 0x0183, all -> 0x017e }
            java.lang.String r13 = new java.lang.String     // Catch:{ OutOfMemoryError -> 0x0185, Exception -> 0x0183, all -> 0x017e }
            java.nio.charset.Charset r14 = com.google.android.gms.internal.ads.zzfxs.zzb     // Catch:{ OutOfMemoryError -> 0x0185, Exception -> 0x0183, all -> 0x017e }
            r13.<init>(r4, r8, r9, r14)     // Catch:{ OutOfMemoryError -> 0x0185, Exception -> 0x0183, all -> 0x017e }
            com.google.android.gms.internal.ads.zzaib r4 = new com.google.android.gms.internal.ads.zzaib     // Catch:{ OutOfMemoryError -> 0x0185, Exception -> 0x0183, all -> 0x017e }
            r8 = 0
            r4.<init>(r3, r8, r13)     // Catch:{ OutOfMemoryError -> 0x0185, Exception -> 0x0183, all -> 0x017e }
            r8 = r2
            r2 = r4
            r23 = r5
            r3 = r6
            r4 = r7
            r22 = r11
            r24 = r15
            goto L_0x05fd
        L_0x0214:
            r14 = 73
            r9 = 80
            if (r13 != r9) goto L_0x024f
            r13 = 82
            if (r6 != r13) goto L_0x024e
            if (r7 != r14) goto L_0x024e
            r13 = 86
            if (r10 != r13) goto L_0x024c
            byte[] r3 = new byte[r12]     // Catch:{ OutOfMemoryError -> 0x0185, Exception -> 0x0183, all -> 0x017e }
            r4 = 0
            r2.zzG(r3, r4, r12)     // Catch:{ OutOfMemoryError -> 0x0185, Exception -> 0x0183, all -> 0x017e }
            int r8 = zzd(r3, r4)     // Catch:{ OutOfMemoryError -> 0x0185, Exception -> 0x0183, all -> 0x017e }
            java.lang.String r9 = new java.lang.String     // Catch:{ OutOfMemoryError -> 0x0185, Exception -> 0x0183, all -> 0x017e }
            java.nio.charset.Charset r13 = com.google.android.gms.internal.ads.zzfxs.zzb     // Catch:{ OutOfMemoryError -> 0x0185, Exception -> 0x0183, all -> 0x017e }
            r9.<init>(r3, r4, r8, r13)     // Catch:{ OutOfMemoryError -> 0x0185, Exception -> 0x0183, all -> 0x017e }
            r4 = 1
            int r8 = r8 + r4
            byte[] r3 = zzl(r3, r8, r12)     // Catch:{ OutOfMemoryError -> 0x0185, Exception -> 0x0183, all -> 0x017e }
            com.google.android.gms.internal.ads.zzahx r4 = new com.google.android.gms.internal.ads.zzahx     // Catch:{ OutOfMemoryError -> 0x0185, Exception -> 0x0183, all -> 0x017e }
            r4.<init>(r9, r3)     // Catch:{ OutOfMemoryError -> 0x0185, Exception -> 0x0183, all -> 0x017e }
            r8 = r2
            r2 = r4
            r23 = r5
            r3 = r6
            r4 = r7
            r22 = r11
            r24 = r15
            goto L_0x05fd
        L_0x024c:
            r13 = r9
            goto L_0x024f
        L_0x024e:
            r13 = r9
        L_0x024f:
            r14 = 79
            r9 = 71
            if (r13 != r9) goto L_0x02d5
            r13 = 69
            if (r6 != r13) goto L_0x02cf
            if (r7 != r14) goto L_0x02cf
            r13 = 66
            if (r10 == r13) goto L_0x0269
            if (r1 != r8) goto L_0x0262
            goto L_0x0269
        L_0x0262:
            r23 = r5
            r13 = r9
            r22 = r11
            goto L_0x02d9
        L_0x0269:
            int r3 = r36.zzm()     // Catch:{ OutOfMemoryError -> 0x02c5, Exception -> 0x02c3, all -> 0x017e }
            java.nio.charset.Charset r4 = zzj(r3)     // Catch:{ OutOfMemoryError -> 0x02c5, Exception -> 0x02c3, all -> 0x017e }
            int r8 = r12 + -1
            byte[] r9 = new byte[r8]     // Catch:{ OutOfMemoryError -> 0x02c5, Exception -> 0x02c3, all -> 0x017e }
            r13 = 0
            r2.zzG(r9, r13, r8)     // Catch:{ OutOfMemoryError -> 0x02c5, Exception -> 0x02c3, all -> 0x017e }
            int r14 = zzd(r9, r13)     // Catch:{ OutOfMemoryError -> 0x02c5, Exception -> 0x02c3, all -> 0x017e }
            java.lang.String r13 = new java.lang.String     // Catch:{ OutOfMemoryError -> 0x02c5, Exception -> 0x02c3, all -> 0x017e }
            r22 = r11
            java.nio.charset.Charset r11 = com.google.android.gms.internal.ads.zzfxs.zzb     // Catch:{ OutOfMemoryError -> 0x02bf, Exception -> 0x02bd, all -> 0x017e }
            r23 = r5
            r5 = 0
            r13.<init>(r9, r5, r14, r11)     // Catch:{ OutOfMemoryError -> 0x0333, Exception -> 0x0331, all -> 0x017e }
            java.lang.String r5 = com.google.android.gms.internal.ads.zzcg.zze(r13)     // Catch:{ OutOfMemoryError -> 0x0333, Exception -> 0x0331, all -> 0x017e }
            r11 = 1
            int r14 = r14 + r11
            int r11 = zzc(r9, r14, r3)     // Catch:{ OutOfMemoryError -> 0x0333, Exception -> 0x0331, all -> 0x017e }
            java.lang.String r13 = zzh(r9, r14, r11, r4)     // Catch:{ OutOfMemoryError -> 0x0333, Exception -> 0x0331, all -> 0x017e }
            int r14 = zzb(r3)     // Catch:{ OutOfMemoryError -> 0x0333, Exception -> 0x0331, all -> 0x017e }
            int r11 = r11 + r14
            int r14 = zzc(r9, r11, r3)     // Catch:{ OutOfMemoryError -> 0x0333, Exception -> 0x0331, all -> 0x017e }
            java.lang.String r4 = zzh(r9, r11, r14, r4)     // Catch:{ OutOfMemoryError -> 0x0333, Exception -> 0x0331, all -> 0x017e }
            int r3 = zzb(r3)     // Catch:{ OutOfMemoryError -> 0x0333, Exception -> 0x0331, all -> 0x017e }
            int r14 = r14 + r3
            byte[] r3 = zzl(r9, r14, r8)     // Catch:{ OutOfMemoryError -> 0x0333, Exception -> 0x0331, all -> 0x017e }
            com.google.android.gms.internal.ads.zzahm r8 = new com.google.android.gms.internal.ads.zzahm     // Catch:{ OutOfMemoryError -> 0x0333, Exception -> 0x0331, all -> 0x017e }
            r8.<init>(r5, r13, r4, r3)     // Catch:{ OutOfMemoryError -> 0x0333, Exception -> 0x0331, all -> 0x017e }
            r3 = r6
            r4 = r7
            r24 = r15
            r34 = r8
            r8 = r2
            r2 = r34
            goto L_0x05fd
        L_0x02bd:
            r0 = move-exception
            goto L_0x02c0
        L_0x02bf:
            r0 = move-exception
        L_0x02c0:
            r23 = r5
            goto L_0x02ca
        L_0x02c3:
            r0 = move-exception
            goto L_0x02c6
        L_0x02c5:
            r0 = move-exception
        L_0x02c6:
            r23 = r5
            r22 = r11
        L_0x02ca:
            r8 = r2
            r3 = r6
            r4 = r7
            goto L_0x018d
        L_0x02cf:
            r23 = r5
            r22 = r11
            r13 = r9
            goto L_0x02d9
        L_0x02d5:
            r23 = r5
            r22 = r11
        L_0x02d9:
            r5 = 65
            r9 = 67
            if (r1 != r8) goto L_0x02ee
            r11 = 80
            if (r13 != r11) goto L_0x02ea
            r11 = 73
            if (r6 != r11) goto L_0x02ea
            if (r7 != r9) goto L_0x02ea
            goto L_0x02fa
        L_0x02ea:
            r24 = r15
            goto L_0x0399
        L_0x02ee:
            if (r13 != r5) goto L_0x0397
            r11 = 80
            if (r6 != r11) goto L_0x0397
            r11 = 73
            if (r7 != r11) goto L_0x0397
            if (r10 != r9) goto L_0x0397
        L_0x02fa:
            int r3 = r36.zzm()     // Catch:{ OutOfMemoryError -> 0x038d, Exception -> 0x038b, all -> 0x0383 }
            java.nio.charset.Charset r4 = zzj(r3)     // Catch:{ OutOfMemoryError -> 0x038d, Exception -> 0x038b, all -> 0x0383 }
            int r5 = r12 + -1
            byte[] r9 = new byte[r5]     // Catch:{ OutOfMemoryError -> 0x038d, Exception -> 0x038b, all -> 0x0383 }
            r11 = 0
            r2.zzG(r9, r11, r5)     // Catch:{ OutOfMemoryError -> 0x038d, Exception -> 0x038b, all -> 0x0383 }
            if (r1 != r8) goto L_0x0335
            java.lang.String r11 = new java.lang.String     // Catch:{ OutOfMemoryError -> 0x0333, Exception -> 0x0331, all -> 0x017e }
            java.nio.charset.Charset r13 = com.google.android.gms.internal.ads.zzfxs.zzb     // Catch:{ OutOfMemoryError -> 0x0333, Exception -> 0x0331, all -> 0x017e }
            r8 = 3
            r14 = 0
            r11.<init>(r9, r14, r8, r13)     // Catch:{ OutOfMemoryError -> 0x0333, Exception -> 0x0331, all -> 0x017e }
            java.lang.String r8 = com.google.android.gms.internal.ads.zzfxm.zza(r11)     // Catch:{ OutOfMemoryError -> 0x0333, Exception -> 0x0331, all -> 0x017e }
            java.lang.String r11 = "image/"
            java.lang.String r8 = java.lang.String.valueOf(r8)     // Catch:{ OutOfMemoryError -> 0x0333, Exception -> 0x0331, all -> 0x017e }
            java.lang.String r8 = r11.concat(r8)     // Catch:{ OutOfMemoryError -> 0x0333, Exception -> 0x0331, all -> 0x017e }
            java.lang.String r11 = "image/jpg"
            boolean r11 = r11.equals(r8)     // Catch:{ OutOfMemoryError -> 0x0333, Exception -> 0x0331, all -> 0x017e }
            if (r11 == 0) goto L_0x032f
            java.lang.String r8 = "image/jpeg"
            r11 = 2
            goto L_0x0359
        L_0x032f:
            r11 = 2
            goto L_0x0359
        L_0x0331:
            r0 = move-exception
            goto L_0x02ca
        L_0x0333:
            r0 = move-exception
            goto L_0x02ca
        L_0x0335:
            r8 = 0
            int r11 = zzd(r9, r8)     // Catch:{ OutOfMemoryError -> 0x038d, Exception -> 0x038b, all -> 0x0383 }
            java.lang.String r13 = new java.lang.String     // Catch:{ OutOfMemoryError -> 0x038d, Exception -> 0x038b, all -> 0x0383 }
            java.nio.charset.Charset r14 = com.google.android.gms.internal.ads.zzfxs.zzb     // Catch:{ OutOfMemoryError -> 0x038d, Exception -> 0x038b, all -> 0x0383 }
            r13.<init>(r9, r8, r11, r14)     // Catch:{ OutOfMemoryError -> 0x038d, Exception -> 0x038b, all -> 0x0383 }
            java.lang.String r8 = com.google.android.gms.internal.ads.zzfxm.zza(r13)     // Catch:{ OutOfMemoryError -> 0x038d, Exception -> 0x038b, all -> 0x0383 }
            r13 = 47
            int r13 = r8.indexOf(r13)     // Catch:{ OutOfMemoryError -> 0x038d, Exception -> 0x038b, all -> 0x0383 }
            r14 = -1
            if (r13 != r14) goto L_0x0359
            java.lang.String r13 = "image/"
            java.lang.String r8 = java.lang.String.valueOf(r8)     // Catch:{ OutOfMemoryError -> 0x0333, Exception -> 0x0331, all -> 0x017e }
            java.lang.String r8 = r13.concat(r8)     // Catch:{ OutOfMemoryError -> 0x0333, Exception -> 0x0331, all -> 0x017e }
        L_0x0359:
            int r13 = r11 + 1
            byte r13 = r9[r13]     // Catch:{ OutOfMemoryError -> 0x038d, Exception -> 0x038b, all -> 0x0383 }
            r13 = r13 & 255(0xff, float:3.57E-43)
            r14 = 2
            int r11 = r11 + r14
            int r14 = zzc(r9, r11, r3)     // Catch:{ OutOfMemoryError -> 0x038d, Exception -> 0x038b, all -> 0x0383 }
            r24 = r15
            java.lang.String r15 = new java.lang.String     // Catch:{ OutOfMemoryError -> 0x03f8, Exception -> 0x03f6, all -> 0x03f1 }
            int r2 = r14 - r11
            r15.<init>(r9, r11, r2, r4)     // Catch:{ OutOfMemoryError -> 0x03f8, Exception -> 0x03f6, all -> 0x03f1 }
            int r2 = zzb(r3)     // Catch:{ OutOfMemoryError -> 0x03f8, Exception -> 0x03f6, all -> 0x03f1 }
            int r14 = r14 + r2
            byte[] r2 = zzl(r9, r14, r5)     // Catch:{ OutOfMemoryError -> 0x03f8, Exception -> 0x03f6, all -> 0x03f1 }
            com.google.android.gms.internal.ads.zzahc r3 = new com.google.android.gms.internal.ads.zzahc     // Catch:{ OutOfMemoryError -> 0x03f8, Exception -> 0x03f6, all -> 0x03f1 }
            r3.<init>(r8, r15, r13, r2)     // Catch:{ OutOfMemoryError -> 0x03f8, Exception -> 0x03f6, all -> 0x03f1 }
            r8 = r36
            r2 = r3
            r3 = r6
            r4 = r7
            goto L_0x05fd
        L_0x0383:
            r0 = move-exception
            r24 = r15
            r8 = r36
        L_0x0388:
            r1 = r0
            goto L_0x060a
        L_0x038b:
            r0 = move-exception
            goto L_0x038e
        L_0x038d:
            r0 = move-exception
        L_0x038e:
            r24 = r15
            r8 = r36
            r2 = r0
            r3 = r6
            r4 = r7
            goto L_0x0615
        L_0x0397:
            r24 = r15
        L_0x0399:
            r2 = 77
            if (r13 != r9) goto L_0x03fd
            if (r6 != r14) goto L_0x03fd
            if (r7 != r2) goto L_0x03fd
            if (r10 == r2) goto L_0x03aa
            r8 = 2
            if (r1 != r8) goto L_0x03a7
            goto L_0x03aa
        L_0x03a7:
            r8 = r36
            goto L_0x03ff
        L_0x03aa:
            r2 = 4
            if (r12 >= r2) goto L_0x03b4
            r8 = r36
            r3 = r6
            r4 = r7
            r2 = 0
            goto L_0x05fd
        L_0x03b4:
            int r2 = r36.zzm()     // Catch:{ OutOfMemoryError -> 0x03f8, Exception -> 0x03f6, all -> 0x03f1 }
            java.nio.charset.Charset r3 = zzj(r2)     // Catch:{ OutOfMemoryError -> 0x03f8, Exception -> 0x03f6, all -> 0x03f1 }
            r4 = 3
            byte[] r5 = new byte[r4]     // Catch:{ OutOfMemoryError -> 0x03f8, Exception -> 0x03f6, all -> 0x03f1 }
            r8 = r36
            r9 = 0
            r8.zzG(r5, r9, r4)     // Catch:{ OutOfMemoryError -> 0x0490, Exception -> 0x048e, all -> 0x0488 }
            java.lang.String r11 = new java.lang.String     // Catch:{ OutOfMemoryError -> 0x0490, Exception -> 0x048e, all -> 0x0488 }
            r11.<init>(r5, r9, r4)     // Catch:{ OutOfMemoryError -> 0x0490, Exception -> 0x048e, all -> 0x0488 }
            int r4 = r12 + -4
            byte[] r5 = new byte[r4]     // Catch:{ OutOfMemoryError -> 0x0490, Exception -> 0x048e, all -> 0x0488 }
            r8.zzG(r5, r9, r4)     // Catch:{ OutOfMemoryError -> 0x0490, Exception -> 0x048e, all -> 0x0488 }
            int r4 = zzc(r5, r9, r2)     // Catch:{ OutOfMemoryError -> 0x0490, Exception -> 0x048e, all -> 0x0488 }
            java.lang.String r13 = new java.lang.String     // Catch:{ OutOfMemoryError -> 0x0490, Exception -> 0x048e, all -> 0x0488 }
            r13.<init>(r5, r9, r4, r3)     // Catch:{ OutOfMemoryError -> 0x0490, Exception -> 0x048e, all -> 0x0488 }
            int r9 = zzb(r2)     // Catch:{ OutOfMemoryError -> 0x0490, Exception -> 0x048e, all -> 0x0488 }
            int r4 = r4 + r9
            int r2 = zzc(r5, r4, r2)     // Catch:{ OutOfMemoryError -> 0x0490, Exception -> 0x048e, all -> 0x0488 }
            java.lang.String r2 = zzh(r5, r4, r2, r3)     // Catch:{ OutOfMemoryError -> 0x0490, Exception -> 0x048e, all -> 0x0488 }
            com.google.android.gms.internal.ads.zzahk r3 = new com.google.android.gms.internal.ads.zzahk     // Catch:{ OutOfMemoryError -> 0x0490, Exception -> 0x048e, all -> 0x0488 }
            r3.<init>(r11, r13, r2)     // Catch:{ OutOfMemoryError -> 0x0490, Exception -> 0x048e, all -> 0x0488 }
            r2 = r3
            r3 = r6
            r4 = r7
            goto L_0x05fd
        L_0x03f1:
            r0 = move-exception
            r8 = r36
            goto L_0x0489
        L_0x03f6:
            r0 = move-exception
            goto L_0x03f9
        L_0x03f8:
            r0 = move-exception
        L_0x03f9:
            r8 = r36
            goto L_0x0491
        L_0x03fd:
            r8 = r36
        L_0x03ff:
            if (r13 != r9) goto L_0x0498
            r11 = 72
            if (r6 != r11) goto L_0x0498
            if (r7 != r5) goto L_0x0498
            r5 = 80
            if (r10 != r5) goto L_0x0498
            int r2 = r36.zzd()     // Catch:{ OutOfMemoryError -> 0x0490, Exception -> 0x048e, all -> 0x0488 }
            byte[] r5 = r36.zzM()     // Catch:{ OutOfMemoryError -> 0x0490, Exception -> 0x048e, all -> 0x0488 }
            int r5 = zzd(r5, r2)     // Catch:{ OutOfMemoryError -> 0x0490, Exception -> 0x048e, all -> 0x0488 }
            java.lang.String r9 = new java.lang.String     // Catch:{ OutOfMemoryError -> 0x0490, Exception -> 0x048e, all -> 0x0488 }
            byte[] r11 = r36.zzM()     // Catch:{ OutOfMemoryError -> 0x0490, Exception -> 0x048e, all -> 0x0488 }
            int r13 = r5 - r2
            java.nio.charset.Charset r14 = com.google.android.gms.internal.ads.zzfxs.zzb     // Catch:{ OutOfMemoryError -> 0x0490, Exception -> 0x048e, all -> 0x0488 }
            r9.<init>(r11, r2, r13, r14)     // Catch:{ OutOfMemoryError -> 0x0490, Exception -> 0x048e, all -> 0x0488 }
            r11 = 1
            int r5 = r5 + r11
            r8.zzK(r5)     // Catch:{ OutOfMemoryError -> 0x0490, Exception -> 0x048e, all -> 0x0488 }
            int r27 = r36.zzg()     // Catch:{ OutOfMemoryError -> 0x0490, Exception -> 0x048e, all -> 0x0488 }
            int r28 = r36.zzg()     // Catch:{ OutOfMemoryError -> 0x0490, Exception -> 0x048e, all -> 0x0488 }
            long r13 = r36.zzu()     // Catch:{ OutOfMemoryError -> 0x0490, Exception -> 0x048e, all -> 0x0488 }
            r18 = 4294967295(0xffffffff, double:2.1219957905E-314)
            int r5 = (r13 > r18 ? 1 : (r13 == r18 ? 0 : -1))
            if (r5 != 0) goto L_0x0443
            r13 = -1
            r29 = r13
            goto L_0x0445
        L_0x0443:
            r29 = r13
        L_0x0445:
            long r13 = r36.zzu()     // Catch:{ OutOfMemoryError -> 0x0490, Exception -> 0x048e, all -> 0x0488 }
            r18 = 4294967295(0xffffffff, double:2.1219957905E-314)
            int r5 = (r13 > r18 ? 1 : (r13 == r18 ? 0 : -1))
            if (r5 != 0) goto L_0x0457
            r13 = -1
            r31 = r13
            goto L_0x0459
        L_0x0457:
            r31 = r13
        L_0x0459:
            java.util.ArrayList r5 = new java.util.ArrayList     // Catch:{ OutOfMemoryError -> 0x0490, Exception -> 0x048e, all -> 0x0488 }
            r5.<init>()     // Catch:{ OutOfMemoryError -> 0x0490, Exception -> 0x048e, all -> 0x0488 }
            int r2 = r2 + r12
        L_0x045f:
            int r11 = r36.zzd()     // Catch:{ OutOfMemoryError -> 0x0490, Exception -> 0x048e, all -> 0x0488 }
            if (r11 >= r2) goto L_0x0470
            r11 = 0
            com.google.android.gms.internal.ads.zzahr r13 = zzf(r1, r8, r3, r4, r11)     // Catch:{ OutOfMemoryError -> 0x0490, Exception -> 0x048e, all -> 0x0488 }
            if (r13 == 0) goto L_0x045f
            r5.add(r13)     // Catch:{ OutOfMemoryError -> 0x0490, Exception -> 0x048e, all -> 0x0488 }
            goto L_0x045f
        L_0x0470:
            r2 = 0
            com.google.android.gms.internal.ads.zzahr[] r2 = new com.google.android.gms.internal.ads.zzahr[r2]     // Catch:{ OutOfMemoryError -> 0x0490, Exception -> 0x048e, all -> 0x0488 }
            java.lang.Object[] r2 = r5.toArray(r2)     // Catch:{ OutOfMemoryError -> 0x0490, Exception -> 0x048e, all -> 0x0488 }
            r33 = r2
            com.google.android.gms.internal.ads.zzahr[] r33 = (com.google.android.gms.internal.ads.zzahr[]) r33     // Catch:{ OutOfMemoryError -> 0x0490, Exception -> 0x048e, all -> 0x0488 }
            com.google.android.gms.internal.ads.zzahg r2 = new com.google.android.gms.internal.ads.zzahg     // Catch:{ OutOfMemoryError -> 0x0490, Exception -> 0x048e, all -> 0x0488 }
            r25 = r2
            r26 = r9
            r25.<init>(r26, r27, r28, r29, r31, r33)     // Catch:{ OutOfMemoryError -> 0x0490, Exception -> 0x048e, all -> 0x0488 }
            r3 = r6
            r4 = r7
            goto L_0x05fd
        L_0x0488:
            r0 = move-exception
        L_0x0489:
            r1 = r0
            r15 = r24
            goto L_0x060a
        L_0x048e:
            r0 = move-exception
            goto L_0x0491
        L_0x0490:
            r0 = move-exception
        L_0x0491:
            r2 = r0
            r3 = r6
            r4 = r7
        L_0x0494:
            r15 = r24
            goto L_0x0615
        L_0x0498:
            if (r13 != r9) goto L_0x057a
            r5 = 84
            if (r6 != r5) goto L_0x057a
            if (r7 != r14) goto L_0x057a
            if (r10 != r9) goto L_0x057a
            int r2 = r36.zzd()     // Catch:{ OutOfMemoryError -> 0x056c, Exception -> 0x056a, all -> 0x0488 }
            byte[] r5 = r36.zzM()     // Catch:{ OutOfMemoryError -> 0x056c, Exception -> 0x056a, all -> 0x0488 }
            int r5 = zzd(r5, r2)     // Catch:{ OutOfMemoryError -> 0x056c, Exception -> 0x056a, all -> 0x0488 }
            java.lang.String r9 = new java.lang.String     // Catch:{ OutOfMemoryError -> 0x056c, Exception -> 0x056a, all -> 0x0488 }
            byte[] r11 = r36.zzM()     // Catch:{ OutOfMemoryError -> 0x056c, Exception -> 0x056a, all -> 0x0488 }
            int r13 = r5 - r2
            java.nio.charset.Charset r14 = com.google.android.gms.internal.ads.zzfxs.zzb     // Catch:{ OutOfMemoryError -> 0x056c, Exception -> 0x056a, all -> 0x0488 }
            r9.<init>(r11, r2, r13, r14)     // Catch:{ OutOfMemoryError -> 0x056c, Exception -> 0x056a, all -> 0x0488 }
            r11 = 1
            int r5 = r5 + r11
            r8.zzK(r5)     // Catch:{ OutOfMemoryError -> 0x056c, Exception -> 0x056a, all -> 0x0488 }
            int r5 = r36.zzm()     // Catch:{ OutOfMemoryError -> 0x056c, Exception -> 0x056a, all -> 0x0488 }
            r11 = r5 & 2
            if (r11 == 0) goto L_0x04cb
            r27 = 1
            goto L_0x04cd
        L_0x04cb:
            r27 = 0
        L_0x04cd:
            r11 = 1
            r5 = r5 & r11
            int r11 = r36.zzm()     // Catch:{ OutOfMemoryError -> 0x056c, Exception -> 0x056a, all -> 0x0488 }
            java.lang.String[] r13 = new java.lang.String[r11]     // Catch:{ OutOfMemoryError -> 0x056c, Exception -> 0x056a, all -> 0x0488 }
            r14 = 0
        L_0x04d6:
            if (r14 >= r11) goto L_0x051d
            int r15 = r36.zzd()     // Catch:{ OutOfMemoryError -> 0x056c, Exception -> 0x056a, all -> 0x0488 }
            r16 = r11
            byte[] r11 = r36.zzM()     // Catch:{ OutOfMemoryError -> 0x056c, Exception -> 0x056a, all -> 0x0488 }
            int r11 = zzd(r11, r15)     // Catch:{ OutOfMemoryError -> 0x056c, Exception -> 0x056a, all -> 0x0488 }
            r18 = r10
            java.lang.String r10 = new java.lang.String     // Catch:{ OutOfMemoryError -> 0x0517, Exception -> 0x0515, all -> 0x0488 }
            r20 = r7
            byte[] r7 = r36.zzM()     // Catch:{ OutOfMemoryError -> 0x0511, Exception -> 0x050f, all -> 0x0488 }
            r21 = r6
            int r6 = r11 - r15
            r19 = r9
            java.nio.charset.Charset r9 = com.google.android.gms.internal.ads.zzfxs.zzb     // Catch:{ OutOfMemoryError -> 0x0565, Exception -> 0x0563, all -> 0x0488 }
            r10.<init>(r7, r15, r6, r9)     // Catch:{ OutOfMemoryError -> 0x0565, Exception -> 0x0563, all -> 0x0488 }
            r13[r14] = r10     // Catch:{ OutOfMemoryError -> 0x0565, Exception -> 0x0563, all -> 0x0488 }
            int r11 = r11 + 1
            r8.zzK(r11)     // Catch:{ OutOfMemoryError -> 0x0565, Exception -> 0x0563, all -> 0x0488 }
            int r14 = r14 + 1
            r11 = r16
            r10 = r18
            r9 = r19
            r7 = r20
            r6 = r21
            goto L_0x04d6
        L_0x050f:
            r0 = move-exception
            goto L_0x0512
        L_0x0511:
            r0 = move-exception
        L_0x0512:
            r21 = r6
            goto L_0x0566
        L_0x0515:
            r0 = move-exception
            goto L_0x0518
        L_0x0517:
            r0 = move-exception
        L_0x0518:
            r21 = r6
            r20 = r7
            goto L_0x0566
        L_0x051d:
            r21 = r6
            r20 = r7
            r19 = r9
            r18 = r10
            java.util.ArrayList r6 = new java.util.ArrayList     // Catch:{ OutOfMemoryError -> 0x0565, Exception -> 0x0563, all -> 0x0488 }
            r6.<init>()     // Catch:{ OutOfMemoryError -> 0x0565, Exception -> 0x0563, all -> 0x0488 }
            int r2 = r2 + r12
        L_0x052b:
            int r7 = r36.zzd()     // Catch:{ OutOfMemoryError -> 0x0565, Exception -> 0x0563, all -> 0x0488 }
            if (r7 >= r2) goto L_0x053c
            r7 = 0
            com.google.android.gms.internal.ads.zzahr r9 = zzf(r1, r8, r3, r4, r7)     // Catch:{ OutOfMemoryError -> 0x0565, Exception -> 0x0563, all -> 0x0488 }
            if (r9 == 0) goto L_0x052b
            r6.add(r9)     // Catch:{ OutOfMemoryError -> 0x0565, Exception -> 0x0563, all -> 0x0488 }
            goto L_0x052b
        L_0x053c:
            r2 = 0
            com.google.android.gms.internal.ads.zzahr[] r3 = new com.google.android.gms.internal.ads.zzahr[r2]     // Catch:{ OutOfMemoryError -> 0x0565, Exception -> 0x0563, all -> 0x0488 }
            java.lang.Object[] r2 = r6.toArray(r3)     // Catch:{ OutOfMemoryError -> 0x0565, Exception -> 0x0563, all -> 0x0488 }
            r30 = r2
            com.google.android.gms.internal.ads.zzahr[] r30 = (com.google.android.gms.internal.ads.zzahr[]) r30     // Catch:{ OutOfMemoryError -> 0x0565, Exception -> 0x0563, all -> 0x0488 }
            com.google.android.gms.internal.ads.zzahi r4 = new com.google.android.gms.internal.ads.zzahi     // Catch:{ OutOfMemoryError -> 0x0565, Exception -> 0x0563, all -> 0x0488 }
            r2 = 1
            if (r2 == r5) goto L_0x054f
            r28 = 0
            goto L_0x0551
        L_0x054f:
            r28 = r2
        L_0x0551:
            r25 = r4
            r26 = r19
            r29 = r13
            r25.<init>(r26, r27, r28, r29, r30)     // Catch:{ OutOfMemoryError -> 0x0565, Exception -> 0x0563, all -> 0x0488 }
            r2 = r4
            r10 = r18
            r4 = r20
            r3 = r21
            goto L_0x05fd
        L_0x0563:
            r0 = move-exception
            goto L_0x0566
        L_0x0565:
            r0 = move-exception
        L_0x0566:
            r2 = r0
            r10 = r18
            goto L_0x0574
        L_0x056a:
            r0 = move-exception
            goto L_0x056d
        L_0x056c:
            r0 = move-exception
        L_0x056d:
            r21 = r6
            r20 = r7
            r18 = r10
            r2 = r0
        L_0x0574:
            r4 = r20
            r3 = r21
            goto L_0x0494
        L_0x057a:
            r21 = r6
            r20 = r7
            r18 = r10
            if (r13 != r2) goto L_0x05e7
            r2 = 76
            r3 = r21
            if (r3 != r2) goto L_0x05e2
            r2 = 76
            r4 = r20
            if (r4 != r2) goto L_0x05df
            r10 = r18
            r2 = 84
            if (r10 != r2) goto L_0x05ed
            int r26 = r36.zzq()     // Catch:{ OutOfMemoryError -> 0x05db, Exception -> 0x05d9, all -> 0x0488 }
            int r27 = r36.zzo()     // Catch:{ OutOfMemoryError -> 0x05db, Exception -> 0x05d9, all -> 0x0488 }
            int r28 = r36.zzo()     // Catch:{ OutOfMemoryError -> 0x05db, Exception -> 0x05d9, all -> 0x0488 }
            int r2 = r36.zzm()     // Catch:{ OutOfMemoryError -> 0x05db, Exception -> 0x05d9, all -> 0x0488 }
            int r5 = r36.zzm()     // Catch:{ OutOfMemoryError -> 0x05db, Exception -> 0x05d9, all -> 0x0488 }
            com.google.android.gms.internal.ads.zzft r6 = new com.google.android.gms.internal.ads.zzft     // Catch:{ OutOfMemoryError -> 0x05db, Exception -> 0x05d9, all -> 0x0488 }
            r6.<init>()     // Catch:{ OutOfMemoryError -> 0x05db, Exception -> 0x05d9, all -> 0x0488 }
            r6.zzi(r8)     // Catch:{ OutOfMemoryError -> 0x05db, Exception -> 0x05d9, all -> 0x0488 }
            int r7 = r12 + -10
            int r7 = r7 * 8
            int r9 = r2 + r5
            int r7 = r7 / r9
            int[] r9 = new int[r7]     // Catch:{ OutOfMemoryError -> 0x05db, Exception -> 0x05d9, all -> 0x0488 }
            int[] r11 = new int[r7]     // Catch:{ OutOfMemoryError -> 0x05db, Exception -> 0x05d9, all -> 0x0488 }
            r13 = 0
        L_0x05bc:
            if (r13 >= r7) goto L_0x05cd
            int r14 = r6.zzd(r2)     // Catch:{ OutOfMemoryError -> 0x05db, Exception -> 0x05d9, all -> 0x0488 }
            int r15 = r6.zzd(r5)     // Catch:{ OutOfMemoryError -> 0x05db, Exception -> 0x05d9, all -> 0x0488 }
            r9[r13] = r14     // Catch:{ OutOfMemoryError -> 0x05db, Exception -> 0x05d9, all -> 0x0488 }
            r11[r13] = r15     // Catch:{ OutOfMemoryError -> 0x05db, Exception -> 0x05d9, all -> 0x0488 }
            int r13 = r13 + 1
            goto L_0x05bc
        L_0x05cd:
            com.google.android.gms.internal.ads.zzahv r2 = new com.google.android.gms.internal.ads.zzahv     // Catch:{ OutOfMemoryError -> 0x05db, Exception -> 0x05d9, all -> 0x0488 }
            r25 = r2
            r29 = r9
            r30 = r11
            r25.<init>(r26, r27, r28, r29, r30)     // Catch:{ OutOfMemoryError -> 0x05db, Exception -> 0x05d9, all -> 0x0488 }
            goto L_0x05fd
        L_0x05d9:
            r0 = move-exception
            goto L_0x05dc
        L_0x05db:
            r0 = move-exception
        L_0x05dc:
            r2 = r0
            goto L_0x0494
        L_0x05df:
            r10 = r18
            goto L_0x05ed
        L_0x05e2:
            r10 = r18
            r4 = r20
            goto L_0x05ed
        L_0x05e7:
            r10 = r18
            r4 = r20
            r3 = r21
        L_0x05ed:
            java.lang.String r2 = zzi(r1, r13, r3, r4, r10)     // Catch:{ OutOfMemoryError -> 0x0610, Exception -> 0x060e, all -> 0x0605 }
            byte[] r5 = new byte[r12]     // Catch:{ OutOfMemoryError -> 0x0610, Exception -> 0x060e, all -> 0x0605 }
            r6 = 0
            r8.zzG(r5, r6, r12)     // Catch:{ OutOfMemoryError -> 0x0610, Exception -> 0x060e, all -> 0x0605 }
            com.google.android.gms.internal.ads.zzahe r6 = new com.google.android.gms.internal.ads.zzahe     // Catch:{ OutOfMemoryError -> 0x0610, Exception -> 0x060e, all -> 0x0605 }
            r6.<init>(r2, r5)     // Catch:{ OutOfMemoryError -> 0x0610, Exception -> 0x060e, all -> 0x0605 }
            r2 = r6
        L_0x05fd:
            r15 = r24
            r8.zzK(r15)
            r14 = r2
            r2 = 0
            goto L_0x0619
        L_0x0605:
            r0 = move-exception
            r15 = r24
            goto L_0x0388
        L_0x060a:
            r8.zzK(r15)
            throw r1
        L_0x060e:
            r0 = move-exception
            goto L_0x0611
        L_0x0610:
            r0 = move-exception
        L_0x0611:
            r15 = r24
            goto L_0x018d
        L_0x0615:
            r8.zzK(r15)
            r14 = 0
        L_0x0619:
            if (r14 != 0) goto L_0x063f
            r5 = r23
            java.lang.String r1 = zzi(r1, r5, r3, r4, r10)
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "Failed to decode frame: id="
            r3.append(r4)
            r3.append(r1)
            java.lang.String r1 = ", frameSize="
            r3.append(r1)
            r3.append(r12)
            java.lang.String r1 = r3.toString()
            r3 = r22
            com.google.android.gms.internal.ads.zzfk.zzg(r3, r1, r2)
        L_0x063f:
            return r14
        L_0x0640:
            r8 = r2
            r3 = r11
        L_0x0642:
            java.lang.String r1 = "Skipping unsupported compressed or encrypted frame"
            com.google.android.gms.internal.ads.zzfk.zzf(r3, r1)
            r8.zzK(r15)
            r1 = 0
            return r1
        L_0x064c:
            r8 = r2
            r1 = r14
            r8.zzK(r15)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzahq.zzf(int, com.google.android.gms.internal.ads.zzfu, boolean, int, com.google.android.gms.internal.ads.zzaho):com.google.android.gms.internal.ads.zzahr");
    }

    private static zzgbc zzg(byte[] bArr, int i, int i2) {
        if (i2 >= bArr.length) {
            return zzgbc.zzn("");
        }
        zzgaz zzgaz = new zzgaz();
        int zzc = zzc(bArr, i2, i);
        while (i2 < zzc) {
            zzgaz.zzf(new String(bArr, i2, zzc - i2, zzj(i)));
            i2 = zzb(i) + zzc;
            zzc = zzc(bArr, i2, i);
        }
        zzgbc zzi = zzgaz.zzi();
        return zzi.isEmpty() ? zzgbc.zzn("") : zzi;
    }

    private static String zzh(byte[] bArr, int i, int i2, Charset charset) {
        return (i2 <= i || i2 > bArr.length) ? "" : new String(bArr, i, i2 - i, charset);
    }

    private static String zzi(int i, int i2, int i3, int i4, int i5) {
        if (i == 2) {
            return String.format(Locale.US, "%c%c%c", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)});
        }
        return String.format(Locale.US, "%c%c%c%c", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)});
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0045, code lost:
        r4 = false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean zzk(com.google.android.gms.internal.ads.zzfu r21, int r22, int r23, boolean r24) {
        /*
            r1 = r21
            r0 = r22
            int r2 = r21.zzd()
        L_0x0008:
            int r3 = r21.zzb()     // Catch:{ all -> 0x00ab }
            r4 = 1
            r5 = r23
            if (r3 < r5) goto L_0x00a6
            r3 = 3
            r6 = 0
            if (r0 < r3) goto L_0x0022
            int r7 = r21.zzg()     // Catch:{ all -> 0x00ab }
            long r8 = r21.zzu()     // Catch:{ all -> 0x00ab }
            int r10 = r21.zzq()     // Catch:{ all -> 0x00ab }
            goto L_0x002c
        L_0x0022:
            int r7 = r21.zzo()     // Catch:{ all -> 0x00ab }
            int r8 = r21.zzo()     // Catch:{ all -> 0x00ab }
            long r8 = (long) r8     // Catch:{ all -> 0x00ab }
            r10 = r6
        L_0x002c:
            r11 = 0
            if (r7 != 0) goto L_0x0038
            int r7 = (r8 > r11 ? 1 : (r8 == r11 ? 0 : -1))
            if (r7 != 0) goto L_0x0038
            if (r10 != 0) goto L_0x0038
            goto L_0x00a7
        L_0x0038:
            r7 = 4
            if (r0 != r7) goto L_0x0069
            if (r24 != 0) goto L_0x0069
            r13 = 8421504(0x808080, double:4.160776E-317)
            long r13 = r13 & r8
            int r11 = (r13 > r11 ? 1 : (r13 == r11 ? 0 : -1))
            if (r11 == 0) goto L_0x0048
        L_0x0045:
            r4 = r6
            goto L_0x00a7
        L_0x0048:
            r11 = 255(0xff, double:1.26E-321)
            long r13 = r8 & r11
            r15 = 8
            long r15 = r8 >> r15
            r17 = 16
            long r17 = r8 >> r17
            r19 = 24
            long r8 = r8 >> r19
            long r15 = r15 & r11
            long r11 = r17 & r11
            r17 = 7
            long r15 = r15 << r17
            long r13 = r13 | r15
            r15 = 14
            long r11 = r11 << r15
            long r11 = r11 | r13
            r13 = 21
            long r8 = r8 << r13
            long r8 = r8 | r11
            goto L_0x006a
        L_0x0069:
        L_0x006a:
            if (r0 != r7) goto L_0x007a
            r3 = r10 & 64
            if (r3 == 0) goto L_0x0071
            goto L_0x0072
        L_0x0071:
            r4 = r6
        L_0x0072:
            r3 = r10 & 1
            r20 = r4
            r4 = r3
            r3 = r20
            goto L_0x008c
        L_0x007a:
            if (r0 != r3) goto L_0x008a
            r3 = r10 & 32
            if (r3 == 0) goto L_0x0082
            r3 = r4
            goto L_0x0083
        L_0x0082:
            r3 = r6
        L_0x0083:
            r7 = r10 & 128(0x80, float:1.794E-43)
            if (r7 == 0) goto L_0x0088
            goto L_0x008c
        L_0x0088:
            r4 = r6
            goto L_0x008c
        L_0x008a:
            r3 = r6
            r4 = r3
        L_0x008c:
            if (r4 == 0) goto L_0x0090
            int r3 = r3 + 4
        L_0x0090:
            long r3 = (long) r3     // Catch:{ all -> 0x00ab }
            int r3 = (r8 > r3 ? 1 : (r8 == r3 ? 0 : -1))
            if (r3 >= 0) goto L_0x0096
            goto L_0x0045
        L_0x0096:
            int r3 = r21.zzb()     // Catch:{ all -> 0x00ab }
            long r3 = (long) r3     // Catch:{ all -> 0x00ab }
            int r3 = (r3 > r8 ? 1 : (r3 == r8 ? 0 : -1))
            if (r3 >= 0) goto L_0x00a0
            goto L_0x0045
        L_0x00a0:
            int r3 = (int) r8     // Catch:{ all -> 0x00ab }
            r1.zzL(r3)     // Catch:{ all -> 0x00ab }
            goto L_0x0008
        L_0x00a6:
        L_0x00a7:
            r1.zzK(r2)
            return r4
        L_0x00ab:
            r0 = move-exception
            r1.zzK(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzahq.zzk(com.google.android.gms.internal.ads.zzfu, int, int, boolean):boolean");
    }

    private static byte[] zzl(byte[] bArr, int i, int i2) {
        if (i2 <= i) {
            return zzgd.zzf;
        }
        return Arrays.copyOfRange(bArr, i, i2);
    }

    private static Charset zzj(int i) {
        switch (i) {
            case 1:
                return zzfxs.zzf;
            case 2:
                return zzfxs.zzd;
            case 3:
                return zzfxs.zzc;
            default:
                return zzfxs.zzb;
        }
    }
}
