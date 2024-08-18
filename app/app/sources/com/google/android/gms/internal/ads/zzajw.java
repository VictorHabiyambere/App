package com.google.android.gms.internal.ads;

import android.util.Pair;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import kotlinx.coroutines.scheduling.WorkQueueKt;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
final class zzajw {
    private static final byte[] zza = "OpusHead".getBytes(zzfxs.zzc);

    static {
        int i = zzgd.zza;
    }

    public static zzcd zza(zzajm zzajm) {
        zzgh zzgh;
        zzajn zzb = zzajm.zzb(1751411826);
        zzajn zzb2 = zzajm.zzb(1801812339);
        zzajn zzb3 = zzajm.zzb(1768715124);
        if (!(zzb == null || zzb2 == null || zzb3 == null || zzg(zzb.zza) != 1835299937)) {
            zzfu zzfu = zzb2.zza;
            zzfu.zzK(12);
            int zzg = zzfu.zzg();
            String[] strArr = new String[zzg];
            for (int i = 0; i < zzg; i++) {
                int zzg2 = zzfu.zzg();
                zzfu.zzL(4);
                strArr[i] = zzfu.zzA(zzg2 - 8, zzfxs.zzc);
            }
            zzfu zzfu2 = zzb3.zza;
            zzfu2.zzK(8);
            ArrayList arrayList = new ArrayList();
            while (zzfu2.zzb() > 8) {
                int zzd = zzfu2.zzd() + zzfu2.zzg();
                int zzg3 = zzfu2.zzg() - 1;
                if (zzg3 < 0 || zzg3 >= zzg) {
                    zzfk.zzf("AtomParsers", "Skipped metadata with unknown key index: " + zzg3);
                } else {
                    String str = strArr[zzg3];
                    int i2 = zzakf.zzb;
                    while (true) {
                        int zzd2 = zzfu2.zzd();
                        if (zzd2 >= zzd) {
                            zzgh = null;
                            break;
                        }
                        int zzg4 = zzfu2.zzg();
                        if (zzfu2.zzg() == 1684108385) {
                            int zzg5 = zzfu2.zzg();
                            int zzg6 = zzfu2.zzg();
                            int i3 = zzg4 - 16;
                            byte[] bArr = new byte[i3];
                            zzfu2.zzG(bArr, 0, i3);
                            zzgh = new zzgh(str, bArr, zzg6, zzg5);
                            break;
                        }
                        zzfu2.zzK(zzd2 + zzg4);
                    }
                    if (zzgh != null) {
                        arrayList.add(zzgh);
                    }
                }
                zzfu2.zzK(zzd);
            }
            if (!arrayList.isEmpty()) {
                return new zzcd((List) arrayList);
            }
        }
        return null;
    }

    public static zzcd zzb(zzajn zzajn) {
        int i;
        zzfu zzfu = zzajn.zza;
        zzfu.zzK(8);
        zzcd zzcd = new zzcd(-9223372036854775807L, new zzcc[0]);
        while (zzfu.zzb() >= 8) {
            int zzd = zzfu.zzd();
            int zzg = zzfu.zzg() + zzd;
            int zzg2 = zzfu.zzg();
            zzcd zzcd2 = null;
            if (zzg2 == 1835365473) {
                zzfu.zzK(zzd);
                zzfu.zzL(8);
                zze(zzfu);
                while (true) {
                    if (zzfu.zzd() >= zzg) {
                        break;
                    }
                    int zzd2 = zzfu.zzd();
                    int zzg3 = zzfu.zzg() + zzd2;
                    if (zzfu.zzg() == 1768715124) {
                        zzfu.zzK(zzd2);
                        zzfu.zzL(8);
                        ArrayList arrayList = new ArrayList();
                        while (zzfu.zzd() < zzg3) {
                            zzcc zza2 = zzakf.zza(zzfu);
                            if (zza2 != null) {
                                arrayList.add(zza2);
                            }
                        }
                        if (!arrayList.isEmpty()) {
                            zzcd2 = new zzcd((List) arrayList);
                        }
                    } else {
                        zzfu.zzK(zzg3);
                    }
                }
                zzcd = zzcd.zzd(zzcd2);
            } else if (zzg2 == 1936553057) {
                zzfu.zzK(zzd);
                zzfu.zzL(12);
                while (true) {
                    if (zzfu.zzd() >= zzg) {
                        break;
                    }
                    int zzd3 = zzfu.zzd();
                    int zzg4 = zzfu.zzg();
                    if (zzfu.zzg() != 1935766900) {
                        zzfu.zzK(zzd3 + zzg4);
                    } else if (zzg4 >= 16) {
                        zzfu.zzL(4);
                        int i2 = -1;
                        int i3 = 0;
                        for (int i4 = 0; i4 < 2; i4++) {
                            int zzm = zzfu.zzm();
                            int zzm2 = zzfu.zzm();
                            if (zzm == 0) {
                                i2 = zzm2;
                            } else if (zzm == 1) {
                                i3 = zzm2;
                            }
                        }
                        if (i2 == 12) {
                            i = 240;
                        } else if (i2 == 13) {
                            i = 120;
                        } else {
                            if (i2 == 21) {
                                if (zzfu.zzb() >= 8) {
                                    if (zzfu.zzd() + 8 <= zzg) {
                                        int zzg5 = zzfu.zzg();
                                        int zzg6 = zzfu.zzg();
                                        if (zzg5 >= 12) {
                                            i = zzg6 != 1936877170 ? -2147483647 : zzfu.zzn();
                                        }
                                    }
                                }
                                i = -2147483647;
                            }
                            i = -2147483647;
                        }
                        if (i != -2147483647) {
                            zzcd2 = new zzcd(-9223372036854775807L, new zzaim((float) i, i3));
                        }
                    }
                }
                zzcd = zzcd.zzd(zzcd2);
            } else if (zzg2 == -1451722374) {
                zzcd = zzcd.zzd(zzi(zzfu));
            }
            zzfu.zzK(zzg);
        }
        return zzcd;
    }

    public static zzgn zzc(zzfu zzfu) {
        long j;
        long j2;
        zzfu.zzK(8);
        if (zzajo.zze(zzfu.zzg()) == 0) {
            j2 = zzfu.zzu();
            j = zzfu.zzu();
        } else {
            j2 = zzfu.zzt();
            j = zzfu.zzt();
        }
        return new zzgn(j2, j, zzfu.zzu());
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v21, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v5, resolved type: long[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r34v0, resolved type: com.google.android.gms.internal.ads.zzgbc} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r34v1, resolved type: com.google.android.gms.internal.ads.zzgbc} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r34v2, resolved type: com.google.android.gms.internal.ads.zzgbc} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r34v3, resolved type: com.google.android.gms.internal.ads.zzgbc} */
    /* JADX WARNING: Code restructure failed: missing block: B:359:0x07d2, code lost:
        if (r2.zzd(1) > 0) goto L_0x07d4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:371:0x07f7, code lost:
        if (r14 == 1) goto L_0x07f9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:448:0x0a28, code lost:
        r8 = r47;
        r7 = r49;
        r10 = r56;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:325:0x06f5  */
    /* JADX WARNING: Removed duplicated region for block: B:326:0x070f  */
    /* JADX WARNING: Removed duplicated region for block: B:378:0x0809  */
    /* JADX WARNING: Removed duplicated region for block: B:392:0x083f  */
    /* JADX WARNING: Removed duplicated region for block: B:393:0x0841  */
    /* JADX WARNING: Removed duplicated region for block: B:469:0x0a88  */
    /* JADX WARNING: Removed duplicated region for block: B:470:0x0a8a  */
    /* JADX WARNING: Removed duplicated region for block: B:523:0x0c42  */
    /* JADX WARNING: Removed duplicated region for block: B:524:0x0c44  */
    /* JADX WARNING: Removed duplicated region for block: B:569:0x0cbc A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x0145  */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x014c  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x015b  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x0173  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.List zzd(com.google.android.gms.internal.ads.zzajm r58, com.google.android.gms.internal.ads.zzaej r59, long r60, com.google.android.gms.internal.ads.zzae r62, boolean r63, boolean r64, com.google.android.gms.internal.ads.zzfxu r65) throws com.google.android.gms.internal.ads.zzch {
        /*
            r0 = r58
            r11 = r62
            java.util.ArrayList r12 = new java.util.ArrayList
            r12.<init>()
            r14 = 0
        L_0x000a:
            java.util.List r1 = r0.zzc
            int r1 = r1.size()
            if (r14 >= r1) goto L_0x0cc6
            java.util.List r1 = r0.zzc
            java.lang.Object r1 = r1.get(r14)
            r15 = r1
            com.google.android.gms.internal.ads.zzajm r15 = (com.google.android.gms.internal.ads.zzajm) r15
            int r1 = r15.zzd
            r2 = 1953653099(0x7472616b, float:7.681346E31)
            if (r1 == r2) goto L_0x002d
            r3 = r59
            r0 = r65
            r2 = r12
            r32 = r14
            r37 = 0
            goto L_0x0ca7
        L_0x002d:
            r1 = 1836476516(0x6d766864, float:4.7662196E27)
            com.google.android.gms.internal.ads.zzajn r1 = r0.zzb(r1)
            if (r1 == 0) goto L_0x0cc4
            r2 = 1835297121(0x6d646961, float:4.4181236E27)
            com.google.android.gms.internal.ads.zzajm r2 = r15.zza(r2)
            if (r2 == 0) goto L_0x0cc2
            r3 = 1751411826(0x68646c72, float:4.3148E24)
            com.google.android.gms.internal.ads.zzajn r3 = r2.zzb(r3)
            if (r3 == 0) goto L_0x0cc0
            com.google.android.gms.internal.ads.zzfu r3 = r3.zza
            int r3 = zzg(r3)
            r4 = 1936684398(0x736f756e, float:1.8971874E31)
            r7 = -1
            if (r3 != r4) goto L_0x0056
            r4 = 1
            goto L_0x007c
        L_0x0056:
            r4 = 1986618469(0x76696465, float:1.1834389E33)
            if (r3 != r4) goto L_0x005d
            r4 = 2
            goto L_0x007c
        L_0x005d:
            r4 = 1952807028(0x74657874, float:7.272211E31)
            if (r3 == r4) goto L_0x007b
            r4 = 1935832172(0x7362746c, float:1.7941596E31)
            if (r3 == r4) goto L_0x007b
            r4 = 1937072756(0x73756274, float:1.944137E31)
            if (r3 == r4) goto L_0x007b
            r4 = 1668047728(0x636c6370, float:4.3605968E21)
            if (r3 != r4) goto L_0x0072
            goto L_0x007b
        L_0x0072:
            r4 = 1835365473(0x6d657461, float:4.4382975E27)
            if (r3 != r4) goto L_0x0079
            r4 = 5
            goto L_0x007c
        L_0x0079:
            r4 = r7
            goto L_0x007c
        L_0x007b:
            r4 = 3
        L_0x007c:
            if (r4 != r7) goto L_0x0088
            r33 = r12
            r32 = r14
            r1 = r15
            r10 = 0
            r37 = 0
            goto L_0x0c6b
        L_0x0088:
            r3 = 1953196132(0x746b6864, float:7.46037E31)
            com.google.android.gms.internal.ads.zzajn r3 = r15.zzb(r3)
            if (r3 == 0) goto L_0x0cbe
            com.google.android.gms.internal.ads.zzfu r3 = r3.zza
            r5 = 8
            r3.zzK(r5)
            int r17 = r3.zzg()
            int r17 = com.google.android.gms.internal.ads.zzajo.zze(r17)
            r13 = 16
            if (r17 != 0) goto L_0x00a7
            r6 = r5
            goto L_0x00a8
        L_0x00a7:
            r6 = r13
        L_0x00a8:
            r3.zzL(r6)
            int r6 = r3.zzg()
            r5 = 4
            r3.zzL(r5)
            int r20 = r3.zzd()
            r8 = 0
        L_0x00b8:
            if (r17 != 0) goto L_0x00bc
            r9 = r5
            goto L_0x00be
        L_0x00bc:
            r9 = 8
        L_0x00be:
            r23 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            if (r8 >= r9) goto L_0x00e7
            byte[] r9 = r3.zzM()
            int r25 = r20 + r8
            byte r9 = r9[r25]
            if (r9 == r7) goto L_0x00e4
            if (r17 != 0) goto L_0x00d6
            long r8 = r3.zzu()
            goto L_0x00da
        L_0x00d6:
            long r8 = r3.zzv()
        L_0x00da:
            r25 = 0
            int r17 = (r8 > r25 ? 1 : (r8 == r25 ? 0 : -1))
            if (r17 != 0) goto L_0x00e3
            r8 = r23
            goto L_0x00ec
        L_0x00e3:
            goto L_0x00ec
        L_0x00e4:
            int r8 = r8 + 1
            goto L_0x00b8
        L_0x00e7:
            r3.zzL(r9)
            r8 = r23
        L_0x00ec:
            r3.zzL(r13)
            int r17 = r3.zzg()
            int r7 = r3.zzg()
            r3.zzL(r5)
            int r5 = r3.zzg()
            int r3 = r3.zzg()
            r10 = 65536(0x10000, float:9.18355E-41)
            r13 = -65536(0xffffffffffff0000, float:NaN)
            if (r17 != 0) goto L_0x011b
            if (r7 != r10) goto L_0x0117
            if (r5 != r13) goto L_0x0115
            if (r3 != 0) goto L_0x0112
            r3 = 90
            goto L_0x013c
        L_0x0112:
            r7 = r10
            r5 = r13
            goto L_0x0118
        L_0x0115:
            r7 = r10
            goto L_0x0118
        L_0x0117:
        L_0x0118:
            r17 = 0
            goto L_0x011c
        L_0x011b:
        L_0x011c:
            if (r17 != 0) goto L_0x012d
            if (r7 != r13) goto L_0x012a
            if (r5 != r10) goto L_0x0127
            if (r3 != 0) goto L_0x0128
            r3 = 270(0x10e, float:3.78E-43)
            goto L_0x013c
        L_0x0127:
            r10 = r5
        L_0x0128:
            r7 = r13
            goto L_0x012b
        L_0x012a:
            r10 = r5
        L_0x012b:
            r5 = 0
            goto L_0x0130
        L_0x012d:
            r10 = r5
            r5 = r17
        L_0x0130:
            if (r5 != r13) goto L_0x013b
            if (r7 != 0) goto L_0x013b
            if (r10 != 0) goto L_0x013b
            if (r3 != r13) goto L_0x013b
            r3 = 180(0xb4, float:2.52E-43)
            goto L_0x013c
        L_0x013b:
            r3 = 0
        L_0x013c:
            com.google.android.gms.internal.ads.zzajv r13 = new com.google.android.gms.internal.ads.zzajv
            r13.<init>(r6, r8, r3)
            int r3 = (r60 > r23 ? 1 : (r60 == r23 ? 0 : -1))
            if (r3 != 0) goto L_0x014c
            long r5 = r13.zzb
            r32 = r5
            goto L_0x014e
        L_0x014c:
            r32 = r60
        L_0x014e:
            com.google.android.gms.internal.ads.zzfu r1 = r1.zza
            com.google.android.gms.internal.ads.zzgn r1 = zzc(r1)
            long r9 = r1.zzc
            int r1 = (r32 > r23 ? 1 : (r32 == r23 ? 0 : -1))
            if (r1 != 0) goto L_0x015b
            goto L_0x0169
        L_0x015b:
            java.math.RoundingMode r38 = java.math.RoundingMode.FLOOR
            r34 = 1000000(0xf4240, double:4.940656E-318)
            r36 = r9
            long r5 = com.google.android.gms.internal.ads.zzgd.zzt(r32, r34, r36, r38)
            r23 = r5
        L_0x0169:
            r1 = 1835626086(0x6d696e66, float:4.515217E27)
            com.google.android.gms.internal.ads.zzajm r1 = r2.zza(r1)
            if (r1 == 0) goto L_0x0cbc
            r3 = 1937007212(0x7374626c, float:1.9362132E31)
            com.google.android.gms.internal.ads.zzajm r1 = r1.zza(r3)
            if (r1 == 0) goto L_0x0cba
            r3 = 1835296868(0x6d646864, float:4.418049E27)
            com.google.android.gms.internal.ads.zzajn r2 = r2.zzb(r3)
            if (r2 == 0) goto L_0x0cb8
            com.google.android.gms.internal.ads.zzfu r2 = r2.zza
            r5 = 8
            r2.zzK(r5)
            int r3 = r2.zzg()
            int r3 = com.google.android.gms.internal.ads.zzajo.zze(r3)
            if (r3 != 0) goto L_0x0198
            r6 = r5
            goto L_0x019a
        L_0x0198:
            r6 = 16
        L_0x019a:
            r2.zzL(r6)
            if (r3 != 0) goto L_0x01a1
            r3 = 4
            goto L_0x01a2
        L_0x01a1:
            r3 = r5
        L_0x01a2:
            long r6 = r2.zzu()
            r2.zzL(r3)
            int r2 = r2.zzq()
            int r3 = r2 >> 10
            int r8 = r2 >> 5
            r2 = r2 & 31
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            r3 = r3 & 31
            int r3 = r3 + 96
            char r3 = (char) r3
            r5.append(r3)
            r3 = r8 & 31
            int r3 = r3 + 96
            char r3 = (char) r3
            r5.append(r3)
            int r2 = r2 + 96
            char r2 = (char) r2
            r5.append(r2)
            java.lang.String r2 = r5.toString()
            java.lang.Long r3 = java.lang.Long.valueOf(r6)
            android.util.Pair r8 = android.util.Pair.create(r3, r2)
            r2 = 1937011556(0x73747364, float:1.9367383E31)
            com.google.android.gms.internal.ads.zzajn r1 = r1.zzb(r2)
            if (r1 == 0) goto L_0x0cb0
            int r7 = r13.zza
            int r6 = r13.zzc
            java.lang.Object r2 = r8.second
            r5 = r2
            java.lang.String r5 = (java.lang.String) r5
            com.google.android.gms.internal.ads.zzfu r3 = r1.zza
            r2 = 12
            r3.zzK(r2)
            int r1 = r3.zzg()
            com.google.android.gms.internal.ads.zzajs r0 = new com.google.android.gms.internal.ads.zzajs
            r0.<init>(r1)
            r32 = r14
            r14 = 0
        L_0x0203:
            if (r14 >= r1) goto L_0x0baa
            r33 = r12
            int r12 = r3.zzd()
            r17 = r13
            int r13 = r3.zzg()
            if (r13 <= 0) goto L_0x0215
            r2 = 1
            goto L_0x0216
        L_0x0215:
            r2 = 0
        L_0x0216:
            r29 = r1
            java.lang.String r1 = "childAtomSize must be positive"
            com.google.android.gms.internal.ads.zzady.zzb(r2, r1)
            int r2 = r3.zzg()
            r1 = 1635148593(0x61766331, float:2.840654E20)
            r30 = r4
            r4 = 1701733238(0x656e6376, float:7.035987E22)
            if (r2 == r1) goto L_0x0484
            r1 = 1635148595(0x61766333, float:2.8406544E20)
            if (r2 == r1) goto L_0x0484
            if (r2 == r4) goto L_0x0484
            r1 = 1831958048(0x6d317620, float:3.4326032E27)
            if (r2 == r1) goto L_0x0484
            r1 = 1836070006(0x6d703476, float:4.646239E27)
            if (r2 == r1) goto L_0x0484
            r1 = 1752589105(0x68766331, float:4.6541277E24)
            if (r2 == r1) goto L_0x0484
            r1 = 1751479857(0x68657631, float:4.3344087E24)
            if (r2 == r1) goto L_0x0484
            r1 = 1932670515(0x73323633, float:1.4119387E31)
            if (r2 == r1) goto L_0x0484
            r1 = 1211250227(0x48323633, float:182488.8)
            if (r2 == r1) goto L_0x0484
            r1 = 1987063864(0x76703038, float:1.21789965E33)
            if (r2 == r1) goto L_0x0484
            r1 = 1987063865(0x76703039, float:1.2178997E33)
            if (r2 == r1) goto L_0x0484
            r1 = 1635135537(0x61763031, float:2.8383572E20)
            if (r2 == r1) goto L_0x0484
            r1 = 1685479798(0x64766176, float:1.8179687E22)
            if (r2 == r1) goto L_0x0484
            r1 = 1685479729(0x64766131, float:1.817961E22)
            if (r2 == r1) goto L_0x0484
            r1 = 1685481573(0x64766865, float:1.8181686E22)
            if (r2 == r1) goto L_0x0484
            r1 = 1685481521(0x64766831, float:1.8181627E22)
            if (r2 != r1) goto L_0x0289
            r19 = r5
            r43 = r6
            r44 = r7
            r45 = r8
            r21 = r9
            r31 = r15
            r16 = r29
            r28 = r30
            r37 = 0
            r15 = r3
            goto L_0x0497
        L_0x0289:
            r1 = 1836069985(0x6d703461, float:4.6462328E27)
            if (r2 == r1) goto L_0x0448
            r1 = 1701733217(0x656e6361, float:7.0359778E22)
            if (r2 == r1) goto L_0x0448
            r1 = 1633889587(0x61632d33, float:2.6191674E20)
            if (r2 == r1) goto L_0x0448
            r1 = 1700998451(0x65632d33, float:6.7050686E22)
            if (r2 == r1) goto L_0x0448
            r1 = 1633889588(0x61632d34, float:2.6191676E20)
            if (r2 == r1) goto L_0x0448
            r1 = 1835823201(0x6d6c7061, float:4.573395E27)
            if (r2 == r1) goto L_0x0448
            r1 = 1685353315(0x64747363, float:1.803728E22)
            if (r2 == r1) goto L_0x0448
            r1 = 1685353317(0x64747365, float:1.8037282E22)
            if (r2 == r1) goto L_0x0448
            r1 = 1685353320(0x64747368, float:1.8037286E22)
            if (r2 == r1) goto L_0x0448
            r1 = 1685353324(0x6474736c, float:1.803729E22)
            if (r2 == r1) goto L_0x0448
            r1 = 1685353336(0x64747378, float:1.8037304E22)
            if (r2 == r1) goto L_0x0448
            r1 = 1935764850(0x73616d72, float:1.7860208E31)
            if (r2 == r1) goto L_0x0448
            r1 = 1935767394(0x73617762, float:1.7863284E31)
            if (r2 == r1) goto L_0x0448
            r1 = 1819304813(0x6c70636d, float:1.1624469E27)
            if (r2 == r1) goto L_0x0448
            r1 = 1936684916(0x736f7774, float:1.89725E31)
            if (r2 == r1) goto L_0x0448
            r1 = 1953984371(0x74776f73, float:7.841539E31)
            if (r2 == r1) goto L_0x0448
            r1 = 778924082(0x2e6d7032, float:5.398721E-11)
            if (r2 == r1) goto L_0x0448
            r1 = 778924083(0x2e6d7033, float:5.3987214E-11)
            if (r2 == r1) goto L_0x0448
            r1 = 1835557169(0x6d686131, float:4.4948762E27)
            if (r2 == r1) goto L_0x0448
            r1 = 1835560241(0x6d686d31, float:4.495783E27)
            if (r2 == r1) goto L_0x0448
            r1 = 1634492771(0x616c6163, float:2.7252807E20)
            if (r2 == r1) goto L_0x0448
            r1 = 1634492791(0x616c6177, float:2.7252842E20)
            if (r2 == r1) goto L_0x0448
            r1 = 1970037111(0x756c6177, float:2.9964816E32)
            if (r2 == r1) goto L_0x0448
            r1 = 1332770163(0x4f707573, float:4.03422899E9)
            if (r2 == r1) goto L_0x0448
            r1 = 1716281667(0x664c6143, float:2.4128923E23)
            if (r2 != r1) goto L_0x030c
            r36 = r5
            r35 = r6
            goto L_0x044c
        L_0x030c:
            r1 = 1414810956(0x54544d4c, float:3.64731957E12)
            if (r2 == r1) goto L_0x03bf
            r1 = 1954034535(0x74783367, float:7.865797E31)
            if (r2 == r1) goto L_0x03bf
            r1 = 2004251764(0x77767474, float:4.998699E33)
            if (r2 == r1) goto L_0x03bf
            r1 = 1937010800(0x73747070, float:1.9366469E31)
            if (r2 == r1) goto L_0x03bf
            r1 = 1664495672(0x63363038, float:3.360782E21)
            if (r2 != r1) goto L_0x0327
            goto L_0x03bf
        L_0x0327:
            r1 = 1835365492(0x6d657474, float:4.4383032E27)
            if (r2 != r1) goto L_0x036b
            int r1 = r12 + 16
            r3.zzK(r1)
            r1 = 0
            r3.zzx(r1)
            java.lang.String r2 = r3.zzx(r1)
            if (r2 == 0) goto L_0x034d
            com.google.android.gms.internal.ads.zzal r1 = new com.google.android.gms.internal.ads.zzal
            r1.<init>()
            r1.zzJ(r7)
            r1.zzX(r2)
            com.google.android.gms.internal.ads.zzan r1 = r1.zzad()
            r0.zzb = r1
            goto L_0x03a1
        L_0x034d:
            r4 = r0
            r19 = r5
            r2 = r6
            r5 = r7
            r45 = r8
            r21 = r9
            r38 = r12
            r40 = r13
            r18 = r14
            r31 = r15
            r16 = r29
            r28 = r30
            r0 = -1
            r37 = 0
            r42 = 5
            r15 = r3
            r3 = 3
            goto L_0x0b89
        L_0x036b:
            r1 = 1667329389(0x63616d6d, float:4.1584024E21)
            if (r2 != r1) goto L_0x03a1
            com.google.android.gms.internal.ads.zzal r1 = new com.google.android.gms.internal.ads.zzal
            r1.<init>()
            r1.zzJ(r7)
            java.lang.String r2 = "application/x-camera-motion"
            r1.zzX(r2)
            com.google.android.gms.internal.ads.zzan r1 = r1.zzad()
            r0.zzb = r1
            r4 = r0
            r19 = r5
            r2 = r6
            r5 = r7
            r45 = r8
            r21 = r9
            r38 = r12
            r40 = r13
            r18 = r14
            r31 = r15
            r16 = r29
            r28 = r30
            r0 = -1
            r37 = 0
            r42 = 5
            r15 = r3
            r3 = 3
            goto L_0x0b89
        L_0x03a1:
            r4 = r0
            r19 = r5
            r2 = r6
            r5 = r7
            r45 = r8
            r21 = r9
            r38 = r12
            r40 = r13
            r18 = r14
            r31 = r15
            r16 = r29
            r28 = r30
            r0 = -1
            r37 = 0
            r42 = 5
            r15 = r3
            r3 = 3
            goto L_0x0b89
        L_0x03bf:
            int r1 = r12 + 16
            r3.zzK(r1)
            r1 = 1414810956(0x54544d4c, float:3.64731957E12)
            r34 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            if (r2 != r1) goto L_0x03d6
            java.lang.String r1 = "application/ttml+xml"
            r2 = r1
            r39 = r34
            r1 = 0
            r4 = 0
            goto L_0x0409
        L_0x03d6:
            r1 = 1954034535(0x74783367, float:7.865797E31)
            if (r2 != r1) goto L_0x03ec
            int r1 = r13 + -16
            byte[] r2 = new byte[r1]
            r4 = 0
            r3.zzG(r2, r4, r1)
            com.google.android.gms.internal.ads.zzgbc r1 = com.google.android.gms.internal.ads.zzgbc.zzn(r2)
            java.lang.String r2 = "application/x-quicktime-tx3g"
            r39 = r34
            goto L_0x0409
        L_0x03ec:
            r4 = 0
            r1 = 2004251764(0x77767474, float:4.998699E33)
            if (r2 != r1) goto L_0x03f9
            java.lang.String r1 = "application/x-mp4-vtt"
        L_0x03f4:
            r2 = r1
        L_0x03f5:
            r39 = r34
            r1 = 0
            goto L_0x0409
        L_0x03f9:
            r1 = 1937010800(0x73747070, float:1.9366469E31)
            if (r2 != r1) goto L_0x0403
            r34 = 0
            java.lang.String r1 = "application/ttml+xml"
            goto L_0x03f4
        L_0x0403:
            r1 = 1
            r0.zzd = r1
            java.lang.String r2 = "application/x-mp4-cea-608"
            goto L_0x03f5
        L_0x0409:
            com.google.android.gms.internal.ads.zzal r4 = new com.google.android.gms.internal.ads.zzal
            r4.<init>()
            r4.zzJ(r7)
            r4.zzX(r2)
            r4.zzO(r5)
            r36 = r5
            r35 = r6
            r5 = r39
            r4.zzab(r5)
            r4.zzL(r1)
            com.google.android.gms.internal.ads.zzan r1 = r4.zzad()
            r0.zzb = r1
            r4 = r0
            r5 = r7
            r45 = r8
            r21 = r9
            r38 = r12
            r40 = r13
            r18 = r14
            r31 = r15
            r16 = r29
            r28 = r30
            r2 = r35
            r19 = r36
            r0 = -1
            r37 = 0
            r42 = 5
            r15 = r3
            r3 = 3
            goto L_0x0b89
        L_0x0448:
            r36 = r5
            r35 = r6
        L_0x044c:
            r16 = r29
            r5 = 1
            r1 = r3
            r6 = 12
            r4 = r3
            r3 = r12
            r31 = r15
            r28 = r30
            r37 = 0
            r15 = r4
            r4 = r13
            r19 = r36
            r5 = r7
            r43 = r35
            r6 = r19
            r44 = r7
            r7 = r64
            r45 = r8
            r8 = r62
            r21 = r9
            r10 = 5
            r9 = r0
            r10 = r14
            zzm(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10)
            r4 = r0
            r38 = r12
            r40 = r13
            r18 = r14
            r2 = r43
            r5 = r44
            r0 = -1
            r3 = 3
            r42 = 5
            goto L_0x0b89
        L_0x0484:
            r19 = r5
            r43 = r6
            r44 = r7
            r45 = r8
            r21 = r9
            r31 = r15
            r16 = r29
            r28 = r30
            r37 = 0
            r15 = r3
        L_0x0497:
            int r1 = r12 + 16
            r15.zzK(r1)
            r1 = 16
            r15.zzL(r1)
            int r3 = r15.zzq()
            int r5 = r15.zzq()
            r6 = 50
            r15.zzL(r6)
            int r6 = r15.zzd()
            if (r2 != r4) goto L_0x04e0
            android.util.Pair r2 = zzh(r15, r12, r13)
            if (r2 == 0) goto L_0x04da
            java.lang.Object r4 = r2.first
            java.lang.Integer r4 = (java.lang.Integer) r4
            int r4 = r4.intValue()
            if (r11 != 0) goto L_0x04c6
            r10 = 0
            goto L_0x04d0
        L_0x04c6:
            java.lang.Object r7 = r2.second
            com.google.android.gms.internal.ads.zzakq r7 = (com.google.android.gms.internal.ads.zzakq) r7
            java.lang.String r7 = r7.zzb
            com.google.android.gms.internal.ads.zzae r10 = r11.zzb(r7)
        L_0x04d0:
            com.google.android.gms.internal.ads.zzakq[] r7 = r0.zza
            java.lang.Object r2 = r2.second
            com.google.android.gms.internal.ads.zzakq r2 = (com.google.android.gms.internal.ads.zzakq) r2
            r7[r14] = r2
            r2 = r4
            goto L_0x04dc
        L_0x04da:
            r2 = r4
            r10 = r11
        L_0x04dc:
            r15.zzK(r6)
            goto L_0x04e1
        L_0x04e0:
            r10 = r11
        L_0x04e1:
            r4 = 1831958048(0x6d317620, float:3.4326032E27)
            if (r2 != r4) goto L_0x04ee
            java.lang.String r4 = "video/mpeg"
            r57 = r4
            r4 = r2
            r2 = r57
            goto L_0x04f8
        L_0x04ee:
            r4 = 1211250227(0x48323633, float:182488.8)
            if (r2 != r4) goto L_0x04f6
            java.lang.String r2 = "video/3gpp"
            goto L_0x04f8
        L_0x04f6:
            r4 = r2
            r2 = 0
        L_0x04f8:
            r7 = 1065353216(0x3f800000, float:1.0)
            r9 = r6
            r30 = r10
            r18 = r14
            r8 = r37
            r1 = -1
            r6 = -1
            r10 = 0
            r11 = 0
            r14 = -1
            r20 = 8
            r25 = 8
            r26 = 0
            r29 = -1
            r34 = 0
            r35 = 0
        L_0x0512:
            r36 = r6
            int r6 = r9 - r12
            if (r6 >= r13) goto L_0x0ae5
            r15.zzK(r9)
            int r6 = r15.zzd()
            int r38 = r15.zzg()
            if (r38 != 0) goto L_0x0546
            int r38 = r15.zzd()
            r39 = r11
            int r11 = r38 - r12
            if (r11 != r13) goto L_0x0543
            r48 = r0
            r51 = r3
            r50 = r5
            r49 = r7
            r56 = r10
            r38 = r12
            r40 = r13
            r0 = -1
            r3 = 3
            r42 = 5
            goto L_0x0af9
        L_0x0543:
            r11 = r37
            goto L_0x054a
        L_0x0546:
            r39 = r11
            r11 = r38
        L_0x054a:
            if (r11 <= 0) goto L_0x0550
            r38 = r12
            r12 = 1
            goto L_0x0554
        L_0x0550:
            r38 = r12
            r12 = r37
        L_0x0554:
            r40 = r13
            java.lang.String r13 = "childAtomSize must be positive"
            com.google.android.gms.internal.ads.zzady.zzb(r12, r13)
            int r12 = r15.zzg()
            r13 = 1635148611(0x61766343, float:2.8406573E20)
            if (r12 != r13) goto L_0x05b2
            int r6 = r6 + 8
            if (r2 != 0) goto L_0x056b
            r1 = 1
            goto L_0x056d
        L_0x056b:
            r1 = r37
        L_0x056d:
            r13 = 0
            com.google.android.gms.internal.ads.zzady.zzb(r1, r13)
            r15.zzK(r6)
            com.google.android.gms.internal.ads.zzacx r1 = com.google.android.gms.internal.ads.zzacx.zza(r15)
            java.util.List r2 = r1.zza
            int r6 = r1.zzb
            r0.zzc = r6
            if (r8 != 0) goto L_0x0586
            float r7 = r1.zzj
            r6 = r37
            goto L_0x0587
        L_0x0586:
            r6 = 1
        L_0x0587:
            java.lang.String r8 = r1.zzk
            int r10 = r1.zzg
            int r12 = r1.zzh
            int r14 = r1.zzi
            int r13 = r1.zze
            int r1 = r1.zzf
            java.lang.String r20 = "video/avc"
            r48 = r0
            r34 = r2
            r51 = r3
            r46 = r4
            r50 = r5
            r29 = r12
            r25 = r13
            r2 = r20
            r0 = -1
            r3 = 3
            r42 = 5
            r20 = r1
            r1 = r10
            r10 = r8
            r8 = r6
            r6 = r36
            goto L_0x0ad4
        L_0x05b2:
            r13 = 1752589123(0x68766343, float:4.6541328E24)
            if (r12 != r13) goto L_0x0605
            int r6 = r6 + 8
            if (r2 != 0) goto L_0x05bd
            r1 = 1
            goto L_0x05bf
        L_0x05bd:
            r1 = r37
        L_0x05bf:
            r2 = 0
            com.google.android.gms.internal.ads.zzady.zzb(r1, r2)
            r15.zzK(r6)
            com.google.android.gms.internal.ads.zzaek r1 = com.google.android.gms.internal.ads.zzaek.zza(r15)
            java.util.List r2 = r1.zza
            int r6 = r1.zzb
            r0.zzc = r6
            if (r8 != 0) goto L_0x05d8
            float r7 = r1.zzh
            r6 = r37
            goto L_0x05d9
        L_0x05d8:
            r6 = 1
        L_0x05d9:
            java.lang.String r8 = r1.zzi
            int r10 = r1.zze
            int r12 = r1.zzf
            int r13 = r1.zzg
            int r14 = r1.zzc
            int r1 = r1.zzd
            java.lang.String r20 = "video/hevc"
            r48 = r0
            r34 = r2
            r51 = r3
            r46 = r4
            r50 = r5
            r29 = r12
            r25 = r14
            r2 = r20
            r0 = -1
            r3 = 3
            r42 = 5
            r20 = r1
            r1 = r10
            r14 = r13
            r10 = r8
            r8 = r6
            r6 = r36
            goto L_0x0ad4
        L_0x0605:
            r13 = 1685480259(0x64766343, float:1.8180206E22)
            if (r12 == r13) goto L_0x0aa7
            r13 = 1685485123(0x64767643, float:1.8185683E22)
            if (r12 != r13) goto L_0x0623
            r48 = r0
            r51 = r3
            r46 = r4
            r50 = r5
            r49 = r7
            r47 = r8
            r56 = r10
            r0 = -1
            r3 = 3
            r42 = 5
            goto L_0x0ab9
        L_0x0623:
            r13 = 1987076931(0x76706343, float:1.21891066E33)
            if (r12 != r13) goto L_0x067b
            if (r2 != 0) goto L_0x062c
            r1 = 1
            goto L_0x062e
        L_0x062c:
            r1 = r37
        L_0x062e:
            r2 = 0
            com.google.android.gms.internal.ads.zzady.zzb(r1, r2)
            int r6 = r6 + 12
            r15.zzK(r6)
            r13 = 2
            r15.zzL(r13)
            int r1 = r15.zzm()
            int r2 = r1 >> 4
            r6 = 1
            r1 = r1 & r6
            int r12 = r15.zzm()
            int r14 = r15.zzm()
            int r12 = com.google.android.gms.internal.ads.zzt.zza(r12)
            if (r6 == r1) goto L_0x0654
            r1 = r13
            goto L_0x0655
        L_0x0654:
            r1 = r6
        L_0x0655:
            int r14 = com.google.android.gms.internal.ads.zzt.zzb(r14)
            r6 = 1987063864(0x76703038, float:1.21789965E33)
            if (r4 != r6) goto L_0x0661
            java.lang.String r6 = "video/x-vnd.on2.vp8"
            goto L_0x0663
        L_0x0661:
            java.lang.String r6 = "video/x-vnd.on2.vp9"
        L_0x0663:
            r48 = r0
            r29 = r1
            r20 = r2
            r25 = r20
            r51 = r3
            r46 = r4
            r50 = r5
            r2 = r6
            r1 = r12
            r6 = r36
            r0 = -1
            r3 = 3
            r42 = 5
            goto L_0x0ad4
        L_0x067b:
            r13 = 1
            r13 = 1635135811(0x61763143, float:2.8384055E20)
            r46 = r4
            java.lang.String r4 = "AtomParsers"
            if (r12 != r13) goto L_0x0876
            int r6 = r6 + 8
            r15.zzK(r6)
            com.google.android.gms.internal.ads.zzr r1 = new com.google.android.gms.internal.ads.zzr
            r1.<init>()
            com.google.android.gms.internal.ads.zzft r2 = new com.google.android.gms.internal.ads.zzft
            byte[] r6 = r15.zzM()
            int r12 = r6.length
            r2.<init>(r6, r12)
            int r6 = r15.zzd()
            r13 = 8
            int r6 = r6 * r13
            r2.zzk(r6)
            r6 = 1
            r2.zzn(r6)
            r6 = 3
            int r12 = r2.zzd(r6)
            r14 = 6
            r2.zzm(r14)
            boolean r14 = r2.zzo()
            boolean r6 = r2.zzo()
            r20 = 10
            r13 = 2
            if (r12 != r13) goto L_0x06d2
            if (r14 == 0) goto L_0x06ce
            r12 = 1
            if (r12 == r6) goto L_0x06c5
            r6 = r20
            goto L_0x06c7
        L_0x06c5:
            r6 = 12
        L_0x06c7:
            r1.zzf(r6)
            r1.zza(r6)
            goto L_0x06e4
        L_0x06ce:
            r14 = r37
            r6 = 2
            goto L_0x06d3
        L_0x06d2:
            r6 = r12
        L_0x06d3:
            r12 = 2
            if (r6 > r12) goto L_0x06e4
            r6 = 1
            if (r6 == r14) goto L_0x06dc
            r6 = 8
            goto L_0x06de
        L_0x06dc:
            r6 = r20
        L_0x06de:
            r1.zzf(r6)
            r1.zza(r6)
        L_0x06e4:
            r6 = 13
            r2.zzm(r6)
            r2.zzl()
            r13 = 4
            int r12 = r2.zzd(r13)
            r14 = 1
            if (r12 == r14) goto L_0x070f
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r6 = "Unsupported obu_type: "
            r2.append(r6)
            r2.append(r12)
            java.lang.String r2 = r2.toString()
            com.google.android.gms.internal.ads.zzfk.zze(r4, r2)
            com.google.android.gms.internal.ads.zzt r1 = r1.zzg()
            goto L_0x0850
        L_0x070f:
            boolean r12 = r2.zzo()
            if (r12 == 0) goto L_0x0720
            java.lang.String r2 = "Unsupported obu_extension_flag"
            com.google.android.gms.internal.ads.zzfk.zze(r4, r2)
            com.google.android.gms.internal.ads.zzt r1 = r1.zzg()
            goto L_0x0850
        L_0x0720:
            boolean r12 = r2.zzo()
            r2.zzl()
            if (r12 == 0) goto L_0x073e
            r12 = 8
            int r14 = r2.zzd(r12)
            r12 = 127(0x7f, float:1.78E-43)
            if (r14 <= r12) goto L_0x073e
            java.lang.String r2 = "Excessive obu_size"
            com.google.android.gms.internal.ads.zzfk.zze(r4, r2)
            com.google.android.gms.internal.ads.zzt r1 = r1.zzg()
            goto L_0x0850
        L_0x073e:
            r12 = 3
            int r14 = r2.zzd(r12)
            r2.zzl()
            boolean r12 = r2.zzo()
            if (r12 == 0) goto L_0x0758
            java.lang.String r2 = "Unsupported reduced_still_picture_header"
            com.google.android.gms.internal.ads.zzfk.zze(r4, r2)
            com.google.android.gms.internal.ads.zzt r1 = r1.zzg()
            goto L_0x0850
        L_0x0758:
            boolean r12 = r2.zzo()
            if (r12 == 0) goto L_0x0769
            java.lang.String r2 = "Unsupported timing_info_present_flag"
            com.google.android.gms.internal.ads.zzfk.zze(r4, r2)
            com.google.android.gms.internal.ads.zzt r1 = r1.zzg()
            goto L_0x0850
        L_0x0769:
            boolean r12 = r2.zzo()
            if (r12 == 0) goto L_0x077a
            java.lang.String r2 = "Unsupported initial_display_delay_present_flag"
            com.google.android.gms.internal.ads.zzfk.zze(r4, r2)
            com.google.android.gms.internal.ads.zzt r1 = r1.zzg()
            goto L_0x0850
        L_0x077a:
            r4 = 5
            int r12 = r2.zzd(r4)
            r6 = r37
        L_0x0782:
            if (r6 > r12) goto L_0x0798
            r13 = 12
            r2.zzm(r13)
            int r13 = r2.zzd(r4)
            r4 = 7
            if (r13 <= r4) goto L_0x0793
            r2.zzl()
        L_0x0793:
            int r6 = r6 + 1
            r4 = 5
            r13 = 4
            goto L_0x0782
        L_0x0798:
            r13 = 4
            int r4 = r2.zzd(r13)
            int r6 = r2.zzd(r13)
            r12 = 1
            int r4 = r4 + r12
            r2.zzm(r4)
            int r6 = r6 + r12
            r2.zzm(r6)
            boolean r4 = r2.zzo()
            if (r4 == 0) goto L_0x07b5
            r4 = 7
            r2.zzm(r4)
        L_0x07b5:
            r4 = 7
            r2.zzm(r4)
            boolean r4 = r2.zzo()
            if (r4 == 0) goto L_0x07c4
            r6 = 2
            r2.zzm(r6)
        L_0x07c4:
            boolean r6 = r2.zzo()
            if (r6 == 0) goto L_0x07cc
            r6 = 1
            goto L_0x07d4
        L_0x07cc:
            r6 = 1
            int r12 = r2.zzd(r6)
            if (r12 <= 0) goto L_0x07dd
        L_0x07d4:
            boolean r12 = r2.zzo()
            if (r12 != 0) goto L_0x07dd
            r2.zzm(r6)
        L_0x07dd:
            if (r4 == 0) goto L_0x07e4
            r4 = 3
            r2.zzm(r4)
            goto L_0x07e5
        L_0x07e4:
            r4 = 3
        L_0x07e5:
            r2.zzm(r4)
            boolean r6 = r2.zzo()
            r12 = 2
            if (r14 != r12) goto L_0x07f6
            if (r6 == 0) goto L_0x07fc
            r2.zzl()
            goto L_0x07fc
        L_0x07f6:
            r6 = 1
            if (r14 != r6) goto L_0x07fc
        L_0x07f9:
            r6 = r37
            goto L_0x0803
        L_0x07fc:
            boolean r6 = r2.zzo()
            if (r6 == 0) goto L_0x07f9
            r6 = 1
        L_0x0803:
            boolean r12 = r2.zzo()
            if (r12 == 0) goto L_0x084c
            r12 = 8
            int r14 = r2.zzd(r12)
            int r4 = r2.zzd(r12)
            int r25 = r2.zzd(r12)
            if (r6 != 0) goto L_0x082c
            r6 = 1
            if (r14 != r6) goto L_0x082c
            r6 = 13
            if (r4 != r6) goto L_0x0829
            if (r25 != 0) goto L_0x0827
            r2 = 1
            r4 = 1
            r41 = 1
            goto L_0x0836
        L_0x0827:
            r14 = 1
            goto L_0x082e
        L_0x0829:
            r6 = r4
            r14 = 1
            goto L_0x082e
        L_0x082c:
            r6 = r4
        L_0x082e:
            r4 = 1
            int r2 = r2.zzd(r4)
            r41 = r14
        L_0x0836:
            int r12 = com.google.android.gms.internal.ads.zzt.zza(r41)
            r1.zzc(r12)
            if (r2 != r4) goto L_0x0841
            r2 = 1
            goto L_0x0842
        L_0x0841:
            r2 = 2
        L_0x0842:
            r1.zzb(r2)
            int r2 = com.google.android.gms.internal.ads.zzt.zzb(r6)
            r1.zzd(r2)
        L_0x084c:
            com.google.android.gms.internal.ads.zzt r1 = r1.zzg()
        L_0x0850:
            int r2 = r1.zzf
            int r4 = r1.zze
            int r6 = r1.zzd
            int r12 = r1.zzi
            int r1 = r1.zzh
            java.lang.String r14 = "video/av01"
            r48 = r0
            r25 = r1
            r51 = r3
            r29 = r4
            r50 = r5
            r1 = r6
            r20 = r12
            r6 = r36
            r0 = -1
            r3 = 3
            r42 = 5
            r57 = r14
            r14 = r2
            r2 = r57
            goto L_0x0ad4
        L_0x0876:
            r13 = 3
            r42 = 5
            r13 = 1668050025(0x636c6c69, float:4.3612434E21)
            if (r12 != r13) goto L_0x08ab
            if (r26 != 0) goto L_0x0887
            java.nio.ByteBuffer r26 = zzl()
            r4 = r26
            goto L_0x0889
        L_0x0887:
            r4 = r26
        L_0x0889:
            r6 = 21
            r4.position(r6)
            short r6 = r15.zzD()
            r4.putShort(r6)
            short r6 = r15.zzD()
            r4.putShort(r6)
            r48 = r0
            r51 = r3
            r26 = r4
            r50 = r5
            r6 = r36
            r0 = -1
            r3 = 3
            goto L_0x0ad4
        L_0x08ab:
            r13 = 1835295606(0x6d646376, float:4.4176764E27)
            if (r12 != r13) goto L_0x092b
            if (r26 != 0) goto L_0x08b9
            java.nio.ByteBuffer r26 = zzl()
            r4 = r26
            goto L_0x08bb
        L_0x08b9:
            r4 = r26
        L_0x08bb:
            short r6 = r15.zzD()
            short r12 = r15.zzD()
            short r13 = r15.zzD()
            r47 = r8
            short r8 = r15.zzD()
            r48 = r0
            short r0 = r15.zzD()
            r49 = r7
            short r7 = r15.zzD()
            r50 = r5
            short r5 = r15.zzD()
            r51 = r3
            short r3 = r15.zzD()
            long r52 = r15.zzu()
            long r54 = r15.zzu()
            r56 = r10
            r10 = 1
            r4.position(r10)
            r4.putShort(r0)
            r4.putShort(r7)
            r4.putShort(r6)
            r4.putShort(r12)
            r4.putShort(r13)
            r4.putShort(r8)
            r4.putShort(r5)
            r4.putShort(r3)
            r5 = 10000(0x2710, double:4.9407E-320)
            long r5 = r52 / r5
            int r0 = (int) r5
            short r0 = (short) r0
            r4.putShort(r0)
            r5 = 10000(0x2710, double:4.9407E-320)
            long r5 = r54 / r5
            int r0 = (int) r5
            short r0 = (short) r0
            r4.putShort(r0)
            r26 = r4
            r6 = r36
            r8 = r47
            r7 = r49
            r10 = r56
            r0 = -1
            r3 = 3
            goto L_0x0ad4
        L_0x092b:
            r48 = r0
            r51 = r3
            r50 = r5
            r49 = r7
            r47 = r8
            r56 = r10
            r0 = 1681012275(0x64323633, float:1.3149704E22)
            if (r12 != r0) goto L_0x0956
            if (r2 != 0) goto L_0x0940
            r5 = 1
            goto L_0x0942
        L_0x0940:
            r5 = r37
        L_0x0942:
            r0 = 0
            com.google.android.gms.internal.ads.zzady.zzb(r5, r0)
            java.lang.String r0 = "video/3gpp"
            r2 = r0
            r6 = r36
            r8 = r47
            r7 = r49
            r10 = r56
            r0 = -1
            r3 = 3
            goto L_0x0ad4
        L_0x0956:
            r0 = 1702061171(0x65736473, float:7.183675E22)
            if (r12 != r0) goto L_0x0996
            if (r2 != 0) goto L_0x095f
            r5 = 1
            goto L_0x0961
        L_0x095f:
            r5 = r37
        L_0x0961:
            r0 = 0
            com.google.android.gms.internal.ads.zzady.zzb(r5, r0)
            com.google.android.gms.internal.ads.zzajq r0 = zzj(r15, r6)
            java.lang.String r2 = r0.zza
            byte[] r3 = r0.zzb
            if (r3 == 0) goto L_0x0988
            com.google.android.gms.internal.ads.zzgbc r3 = com.google.android.gms.internal.ads.zzgbc.zzn(r3)
            r35 = r0
            r34 = r3
            r6 = r36
            r8 = r47
            r7 = r49
            r10 = r56
            r0 = -1
            r3 = 3
            goto L_0x0ad4
        L_0x0988:
            r35 = r0
            r6 = r36
            r8 = r47
            r7 = r49
            r10 = r56
            r0 = -1
            r3 = 3
            goto L_0x0ad4
        L_0x0996:
            r0 = 1885434736(0x70617370, float:2.7909473E29)
            if (r12 != r0) goto L_0x09b5
            int r6 = r6 + 8
            r15.zzK(r6)
            int r0 = r15.zzp()
            int r3 = r15.zzp()
            float r0 = (float) r0
            float r3 = (float) r3
            float r0 = r0 / r3
            r7 = r0
            r6 = r36
            r10 = r56
            r0 = -1
            r3 = 3
            r8 = 1
            goto L_0x0ad4
        L_0x09b5:
            r0 = 1937126244(0x73763364, float:1.9506033E31)
            if (r12 != r0) goto L_0x09f7
            int r0 = r6 + 8
        L_0x09bc:
            int r3 = r0 - r6
            if (r3 >= r11) goto L_0x09e9
            r15.zzK(r0)
            int r3 = r15.zzg()
            int r3 = r3 + r0
            int r4 = r15.zzg()
            r5 = 1886547818(0x70726f6a, float:3.0012025E29)
            if (r4 != r5) goto L_0x09e7
            byte[] r4 = r15.zzM()
            byte[] r0 = java.util.Arrays.copyOfRange(r4, r0, r3)
            r39 = r0
            r6 = r36
            r8 = r47
            r7 = r49
            r10 = r56
            r0 = -1
            r3 = 3
            goto L_0x0ad4
        L_0x09e7:
            r0 = r3
            goto L_0x09bc
        L_0x09e9:
            r6 = r36
            r8 = r47
            r7 = r49
            r10 = r56
            r0 = -1
            r3 = 3
            r39 = 0
            goto L_0x0ad4
        L_0x09f7:
            r0 = 1936995172(0x73743364, float:1.9347576E31)
            if (r12 != r0) goto L_0x0a34
            int r0 = r15.zzm()
            r3 = 3
            r15.zzL(r3)
            if (r0 != 0) goto L_0x0a31
            int r0 = r15.zzm()
            switch(r0) {
                case 0: goto L_0x0a26;
                case 1: goto L_0x0a1c;
                case 2: goto L_0x0a12;
                case 3: goto L_0x0a10;
                default: goto L_0x0a0d;
            }
        L_0x0a0d:
            r0 = -1
            goto L_0x0acc
        L_0x0a10:
            r6 = r3
            goto L_0x0a28
        L_0x0a12:
            r8 = r47
            r7 = r49
            r10 = r56
            r0 = -1
            r6 = 2
            goto L_0x0ad4
        L_0x0a1c:
            r8 = r47
            r7 = r49
            r10 = r56
            r0 = -1
            r6 = 1
            goto L_0x0ad4
        L_0x0a26:
            r6 = r37
        L_0x0a28:
            r8 = r47
            r7 = r49
            r10 = r56
            r0 = -1
            goto L_0x0ad4
        L_0x0a31:
            r0 = -1
            goto L_0x0acc
        L_0x0a34:
            r3 = 3
            r0 = 1668246642(0x636f6c72, float:4.4165861E21)
            if (r12 != r0) goto L_0x0aa5
            r0 = -1
            if (r1 != r0) goto L_0x0acc
            if (r14 != r0) goto L_0x0a9b
            int r1 = r15.zzg()
            r5 = 1852009592(0x6e636c78, float:1.7596057E28)
            if (r1 == r5) goto L_0x0a5f
            r5 = 1852009571(0x6e636c63, float:1.7596032E28)
            if (r1 != r5) goto L_0x0a4e
            goto L_0x0a5f
        L_0x0a4e:
            java.lang.String r1 = com.google.android.gms.internal.ads.zzajo.zzf(r1)
            java.lang.String r5 = "Unsupported color type: "
            java.lang.String r1 = r5.concat(r1)
            com.google.android.gms.internal.ads.zzfk.zzf(r4, r1)
            r1 = r0
            r14 = r1
            goto L_0x0a9c
        L_0x0a5f:
            int r1 = r15.zzq()
            int r4 = r15.zzq()
            r5 = 2
            r15.zzL(r5)
            r5 = 19
            if (r11 != r5) goto L_0x0a7e
            int r5 = r15.zzm()
            r5 = r5 & 128(0x80, float:1.794E-43)
            if (r5 == 0) goto L_0x0a7b
            r11 = 19
            r5 = 1
            goto L_0x0a81
        L_0x0a7b:
            r11 = 19
            goto L_0x0a7f
        L_0x0a7e:
        L_0x0a7f:
            r5 = r37
        L_0x0a81:
            int r1 = com.google.android.gms.internal.ads.zzt.zza(r1)
            r6 = 1
            if (r6 == r5) goto L_0x0a8a
            r6 = 2
            goto L_0x0a8b
        L_0x0a8a:
            r6 = 1
        L_0x0a8b:
            int r4 = com.google.android.gms.internal.ads.zzt.zzb(r4)
            r14 = r4
            r29 = r6
            r6 = r36
            r8 = r47
            r7 = r49
            r10 = r56
            goto L_0x0ad4
        L_0x0a9b:
            r1 = r0
        L_0x0a9c:
            r6 = r36
            r8 = r47
            r7 = r49
            r10 = r56
            goto L_0x0ad4
        L_0x0aa5:
            r0 = -1
            goto L_0x0acc
        L_0x0aa7:
            r48 = r0
            r51 = r3
            r46 = r4
            r50 = r5
            r49 = r7
            r47 = r8
            r56 = r10
            r0 = -1
            r3 = 3
            r42 = 5
        L_0x0ab9:
            com.google.android.gms.internal.ads.zzado r4 = com.google.android.gms.internal.ads.zzado.zza(r15)
            if (r4 == 0) goto L_0x0acc
            java.lang.String r2 = r4.zza
            java.lang.String r4 = "video/dolby-vision"
            r10 = r2
            r2 = r4
            r6 = r36
            r8 = r47
            r7 = r49
            goto L_0x0ad4
        L_0x0acc:
            r6 = r36
            r8 = r47
            r7 = r49
            r10 = r56
        L_0x0ad4:
            int r9 = r9 + r11
            r12 = r38
            r11 = r39
            r13 = r40
            r4 = r46
            r0 = r48
            r5 = r50
            r3 = r51
            goto L_0x0512
        L_0x0ae5:
            r48 = r0
            r51 = r3
            r50 = r5
            r49 = r7
            r56 = r10
            r39 = r11
            r38 = r12
            r40 = r13
            r0 = -1
            r3 = 3
            r42 = 5
        L_0x0af9:
            if (r2 != 0) goto L_0x0b03
            r2 = r43
            r5 = r44
            r4 = r48
            goto L_0x0b89
        L_0x0b03:
            com.google.android.gms.internal.ads.zzal r4 = new com.google.android.gms.internal.ads.zzal
            r4.<init>()
            r5 = r44
            r4.zzJ(r5)
            r4.zzX(r2)
            r10 = r56
            r4.zzz(r10)
            r2 = r51
            r4.zzac(r2)
            r2 = r50
            r4.zzI(r2)
            r7 = r49
            r4.zzT(r7)
            r2 = r43
            r4.zzW(r2)
            r6 = r39
            r4.zzU(r6)
            r6 = r36
            r4.zzaa(r6)
            r6 = r34
            r4.zzL(r6)
            r10 = r30
            r4.zzE(r10)
            com.google.android.gms.internal.ads.zzr r6 = new com.google.android.gms.internal.ads.zzr
            r6.<init>()
            r6.zzc(r1)
            r1 = r29
            r6.zzb(r1)
            r6.zzd(r14)
            if (r26 == 0) goto L_0x0b54
            byte[] r10 = r26.array()
            goto L_0x0b55
        L_0x0b54:
            r10 = 0
        L_0x0b55:
            r6.zze(r10)
            r1 = r25
            r6.zzf(r1)
            r1 = r20
            r6.zza(r1)
            com.google.android.gms.internal.ads.zzt r1 = r6.zzg()
            r4.zzA(r1)
            if (r35 == 0) goto L_0x0b81
            long r6 = r35.zzc
            int r1 = com.google.android.gms.internal.ads.zzgea.zze(r6)
            r4.zzx(r1)
            long r6 = r35.zzd
            int r1 = com.google.android.gms.internal.ads.zzgea.zze(r6)
            r4.zzS(r1)
        L_0x0b81:
            com.google.android.gms.internal.ads.zzan r1 = r4.zzad()
            r4 = r48
            r4.zzb = r1
        L_0x0b89:
            int r12 = r38 + r40
            r15.zzK(r12)
            int r14 = r18 + 1
            r11 = r62
            r6 = r2
            r0 = r4
            r7 = r5
            r3 = r15
            r1 = r16
            r13 = r17
            r5 = r19
            r9 = r21
            r4 = r28
            r15 = r31
            r12 = r33
            r8 = r45
            r2 = 12
            goto L_0x0203
        L_0x0baa:
            r28 = r4
            r45 = r8
            r21 = r9
            r33 = r12
            r17 = r13
            r31 = r15
            r37 = 0
            r4 = r0
            if (r63 != 0) goto L_0x0c38
            r0 = 1701082227(0x65647473, float:6.742798E22)
            r1 = r31
            com.google.android.gms.internal.ads.zzajm r0 = r1.zza(r0)
            if (r0 == 0) goto L_0x0c3a
            r2 = 1701606260(0x656c7374, float:6.9788014E22)
            com.google.android.gms.internal.ads.zzajn r0 = r0.zzb(r2)
            if (r0 != 0) goto L_0x0bd1
            r10 = 0
            goto L_0x0c23
        L_0x0bd1:
            com.google.android.gms.internal.ads.zzfu r0 = r0.zza
            r2 = 8
            r0.zzK(r2)
            int r2 = r0.zzg()
            int r2 = com.google.android.gms.internal.ads.zzajo.zze(r2)
            int r3 = r0.zzp()
            long[] r5 = new long[r3]
            long[] r6 = new long[r3]
            r7 = r37
        L_0x0bea:
            if (r7 >= r3) goto L_0x0c1f
            r8 = 1
            if (r2 != r8) goto L_0x0bf4
            long r9 = r0.zzv()
            goto L_0x0bf8
        L_0x0bf4:
            long r9 = r0.zzu()
        L_0x0bf8:
            r5[r7] = r9
            if (r2 != r8) goto L_0x0c01
            long r8 = r0.zzt()
            goto L_0x0c06
        L_0x0c01:
            int r8 = r0.zzg()
            long r8 = (long) r8
        L_0x0c06:
            r6[r7] = r8
            short r8 = r0.zzD()
            r9 = 1
            if (r8 != r9) goto L_0x0c17
            r8 = 2
            r0.zzL(r8)
            int r7 = r7 + 1
            goto L_0x0bea
        L_0x0c17:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "Unsupported media rate."
            r0.<init>(r1)
            throw r0
        L_0x0c1f:
            android.util.Pair r10 = android.util.Pair.create(r5, r6)
        L_0x0c23:
            if (r10 == 0) goto L_0x0c33
            java.lang.Object r0 = r10.first
            long[] r0 = (long[]) r0
            java.lang.Object r2 = r10.second
            r10 = r2
            long[] r10 = (long[]) r10
            r29 = r0
            r30 = r10
            goto L_0x0c3e
        L_0x0c33:
            r29 = 0
            r30 = 0
            goto L_0x0c3e
        L_0x0c38:
            r1 = r31
        L_0x0c3a:
            r29 = 0
            r30 = 0
        L_0x0c3e:
            com.google.android.gms.internal.ads.zzan r0 = r4.zzb
            if (r0 != 0) goto L_0x0c44
            r10 = 0
            goto L_0x0c6b
        L_0x0c44:
            com.google.android.gms.internal.ads.zzakp r10 = new com.google.android.gms.internal.ads.zzakp
            int r17 = r17.zza
            r0 = r45
            java.lang.Object r0 = r0.first
            java.lang.Long r0 = (java.lang.Long) r0
            long r19 = r0.longValue()
            com.google.android.gms.internal.ads.zzan r0 = r4.zzb
            int r2 = r4.zzd
            com.google.android.gms.internal.ads.zzakq[] r3 = r4.zza
            int r4 = r4.zzc
            r16 = r10
            r18 = r28
            r25 = r0
            r26 = r2
            r27 = r3
            r28 = r4
            r16.<init>(r17, r18, r19, r21, r23, r25, r26, r27, r28, r29, r30)
        L_0x0c6b:
            r0 = r65
            java.lang.Object r2 = r0.apply(r10)
            com.google.android.gms.internal.ads.zzakp r2 = (com.google.android.gms.internal.ads.zzakp) r2
            if (r2 == 0) goto L_0x0ca3
            r3 = 1835297121(0x6d646961, float:4.4181236E27)
            com.google.android.gms.internal.ads.zzajm r1 = r1.zza(r3)
            if (r1 == 0) goto L_0x0ca1
            r3 = 1835626086(0x6d696e66, float:4.515217E27)
            com.google.android.gms.internal.ads.zzajm r1 = r1.zza(r3)
            if (r1 == 0) goto L_0x0c9f
            r3 = 1937007212(0x7374626c, float:1.9362132E31)
            com.google.android.gms.internal.ads.zzajm r1 = r1.zza(r3)
            if (r1 == 0) goto L_0x0c9c
            r3 = r59
            com.google.android.gms.internal.ads.zzaks r1 = zzk(r2, r1, r3)
            r2 = r33
            r2.add(r1)
            goto L_0x0ca7
        L_0x0c9c:
            r1 = 0
            throw r1
        L_0x0c9f:
            r1 = 0
            throw r1
        L_0x0ca1:
            r1 = 0
            throw r1
        L_0x0ca3:
            r3 = r59
            r2 = r33
        L_0x0ca7:
            int r14 = r32 + 1
            r0 = r58
            r11 = r62
            r12 = r2
            goto L_0x000a
        L_0x0cb0:
            r1 = 0
            java.lang.String r0 = "Malformed sample table (stbl) missing sample description (stsd)"
            com.google.android.gms.internal.ads.zzch r0 = com.google.android.gms.internal.ads.zzch.zza(r0, r1)
            throw r0
        L_0x0cb8:
            r1 = 0
            throw r1
        L_0x0cba:
            r1 = 0
            throw r1
        L_0x0cbc:
            r1 = 0
            throw r1
        L_0x0cbe:
            r1 = 0
            throw r1
        L_0x0cc0:
            r1 = 0
            throw r1
        L_0x0cc2:
            r1 = 0
            throw r1
        L_0x0cc4:
            r1 = 0
            throw r1
        L_0x0cc6:
            r2 = r12
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzajw.zzd(com.google.android.gms.internal.ads.zzajm, com.google.android.gms.internal.ads.zzaej, long, com.google.android.gms.internal.ads.zzae, boolean, boolean, com.google.android.gms.internal.ads.zzfxu):java.util.List");
    }

    public static void zze(zzfu zzfu) {
        int zzd = zzfu.zzd();
        zzfu.zzL(4);
        if (zzfu.zzg() != 1751411826) {
            zzd += 4;
        }
        zzfu.zzK(zzd);
    }

    private static int zzf(zzfu zzfu) {
        int zzm = zzfu.zzm();
        int i = zzm & WorkQueueKt.MASK;
        while ((zzm & 128) == 128) {
            zzm = zzfu.zzm();
            i = (i << 7) | (zzm & WorkQueueKt.MASK);
        }
        return i;
    }

    private static int zzg(zzfu zzfu) {
        zzfu.zzK(16);
        return zzfu.zzg();
    }

    private static Pair zzh(zzfu zzfu, int i, int i2) throws zzch {
        Pair pair;
        boolean z;
        boolean z2;
        Integer num;
        zzakq zzakq;
        int i3;
        int i4;
        boolean z3;
        byte[] bArr;
        zzfu zzfu2 = zzfu;
        int zzd = zzfu.zzd();
        while (zzd - i < i2) {
            zzfu2.zzK(zzd);
            int zzg = zzfu.zzg();
            boolean z4 = true;
            zzady.zzb(zzg > 0, "childAtomSize must be positive");
            if (zzfu.zzg() == 1936289382) {
                int i5 = zzd + 8;
                int i6 = 0;
                int i7 = -1;
                String str = null;
                Integer num2 = null;
                while (i5 - zzd < zzg) {
                    zzfu2.zzK(i5);
                    int zzg2 = zzfu.zzg();
                    int zzg3 = zzfu.zzg();
                    if (zzg3 == 1718775137) {
                        num2 = Integer.valueOf(zzfu.zzg());
                    } else if (zzg3 == 1935894637) {
                        zzfu2.zzL(4);
                        str = zzfu2.zzA(4, zzfxs.zzc);
                    } else if (zzg3 == 1935894633) {
                        i7 = i5;
                        i6 = zzg2;
                    }
                    i5 += zzg2;
                }
                if ("cenc".equals(str) || "cbc1".equals(str) || "cens".equals(str) || "cbcs".equals(str)) {
                    if (num2 != null) {
                        z = true;
                    } else {
                        z = false;
                    }
                    zzady.zzb(z, "frma atom is mandatory");
                    if (i7 != -1) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    zzady.zzb(z2, "schi atom is mandatory");
                    int i8 = i7 + 8;
                    while (true) {
                        if (i8 - i7 >= i6) {
                            num = num2;
                            zzakq = null;
                            break;
                        }
                        zzfu2.zzK(i8);
                        int zzg4 = zzfu.zzg();
                        if (zzfu.zzg() == 1952804451) {
                            int zze = zzajo.zze(zzfu.zzg());
                            zzfu2.zzL(1);
                            if (zze == 0) {
                                zzfu2.zzL(1);
                                i4 = 0;
                                i3 = 0;
                            } else {
                                int zzm = zzfu.zzm();
                                i4 = zzm & 15;
                                i3 = (zzm & 240) >> 4;
                            }
                            if (zzfu.zzm() == 1) {
                                z3 = true;
                            } else {
                                z3 = false;
                            }
                            int zzm2 = zzfu.zzm();
                            byte[] bArr2 = new byte[16];
                            zzfu2.zzG(bArr2, 0, 16);
                            if (!z3 || zzm2 != 0) {
                                bArr = null;
                            } else {
                                int zzm3 = zzfu.zzm();
                                byte[] bArr3 = new byte[zzm3];
                                zzfu2.zzG(bArr3, 0, zzm3);
                                bArr = bArr3;
                            }
                            num = num2;
                            zzakq = new zzakq(z3, str, zzm2, bArr2, i3, i4, bArr);
                        } else {
                            Integer num3 = num2;
                            i8 += zzg4;
                        }
                    }
                    if (zzakq == null) {
                        z4 = false;
                    }
                    zzady.zzb(z4, "tenc atom is mandatory");
                    int i9 = zzgd.zza;
                    pair = Pair.create(num, zzakq);
                } else {
                    pair = null;
                }
                if (pair != null) {
                    return pair;
                }
            }
            zzd += zzg;
        }
        return null;
    }

    private static zzcd zzi(zzfu zzfu) {
        short zzD = zzfu.zzD();
        zzfu.zzL(2);
        String zzA = zzfu.zzA(zzD, zzfxs.zzc);
        int max = Math.max(zzA.lastIndexOf(43), zzA.lastIndexOf(45));
        try {
            return new zzcd(-9223372036854775807L, new zzgk(Float.parseFloat(zzA.substring(0, max)), Float.parseFloat(zzA.substring(max, zzA.length() - 1))));
        } catch (IndexOutOfBoundsException | NumberFormatException e) {
            return null;
        }
    }

    private static zzajq zzj(zzfu zzfu, int i) {
        zzfu.zzK(i + 12);
        zzfu.zzL(1);
        zzf(zzfu);
        zzfu.zzL(2);
        int zzm = zzfu.zzm();
        if ((zzm & 128) != 0) {
            zzfu.zzL(2);
        }
        if ((zzm & 64) != 0) {
            zzfu.zzL(zzfu.zzm());
        }
        if ((zzm & 32) != 0) {
            zzfu.zzL(2);
        }
        zzfu.zzL(1);
        zzf(zzfu);
        String zzd = zzcg.zzd(zzfu.zzm());
        if ("audio/mpeg".equals(zzd) || "audio/vnd.dts".equals(zzd) || "audio/vnd.dts.hd".equals(zzd)) {
            return new zzajq(zzd, (byte[]) null, -1, -1);
        }
        zzfu.zzL(4);
        long zzu = zzfu.zzu();
        long zzu2 = zzfu.zzu();
        zzfu.zzL(1);
        int zzf = zzf(zzfu);
        byte[] bArr = new byte[zzf];
        zzfu.zzG(bArr, 0, zzf);
        return new zzajq(zzd, bArr, zzu2 <= 0 ? -1 : zzu2, zzu > 0 ? zzu : -1);
    }

    /* JADX WARNING: Removed duplicated region for block: B:111:0x0294 A[LOOP:7: B:111:0x0294->B:115:0x029e, LOOP_START, PHI: r16 
      PHI: (r16v13 int) = (r16v8 int), (r16v14 int) binds: [B:110:0x0292, B:115:0x029e] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARNING: Removed duplicated region for block: B:118:0x02a7  */
    /* JADX WARNING: Removed duplicated region for block: B:130:0x02e5  */
    /* JADX WARNING: Removed duplicated region for block: B:133:0x0330  */
    /* JADX WARNING: Removed duplicated region for block: B:134:0x0333  */
    /* JADX WARNING: Removed duplicated region for block: B:139:0x035b  */
    /* JADX WARNING: Removed duplicated region for block: B:141:0x0369  */
    /* JADX WARNING: Removed duplicated region for block: B:264:0x0285 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x01b0  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.google.android.gms.internal.ads.zzaks zzk(com.google.android.gms.internal.ads.zzakp r43, com.google.android.gms.internal.ads.zzajm r44, com.google.android.gms.internal.ads.zzaej r45) throws com.google.android.gms.internal.ads.zzch {
        /*
            r1 = r43
            r0 = r44
            r2 = r45
            r3 = 1937011578(0x7374737a, float:1.936741E31)
            com.google.android.gms.internal.ads.zzajn r3 = r0.zzb(r3)
            r4 = 0
            if (r3 == 0) goto L_0x0018
            com.google.android.gms.internal.ads.zzan r5 = r1.zzf
            com.google.android.gms.internal.ads.zzajt r6 = new com.google.android.gms.internal.ads.zzajt
            r6.<init>(r3, r5)
            goto L_0x0027
        L_0x0018:
            r3 = 1937013298(0x73747a32, float:1.9369489E31)
            com.google.android.gms.internal.ads.zzajn r3 = r0.zzb(r3)
            if (r3 == 0) goto L_0x05eb
            com.google.android.gms.internal.ads.zzaju r6 = new com.google.android.gms.internal.ads.zzaju
            r6.<init>(r3)
        L_0x0027:
            int r3 = r6.zzb()
            r5 = 0
            if (r3 != 0) goto L_0x0045
            com.google.android.gms.internal.ads.zzaks r9 = new com.google.android.gms.internal.ads.zzaks
            long[] r2 = new long[r5]
            int[] r3 = new int[r5]
            long[] r6 = new long[r5]
            int[] r7 = new int[r5]
            r4 = 0
            r10 = 0
            r0 = r9
            r1 = r43
            r5 = r6
            r6 = r7
            r7 = r10
            r0.<init>(r1, r2, r3, r4, r5, r6, r7)
            return r9
        L_0x0045:
            r7 = 1937007471(0x7374636f, float:1.9362445E31)
            com.google.android.gms.internal.ads.zzajn r7 = r0.zzb(r7)
            if (r7 != 0) goto L_0x005c
            r7 = 1668232756(0x636f3634, float:4.4126776E21)
            com.google.android.gms.internal.ads.zzajn r7 = r0.zzb(r7)
            if (r7 == 0) goto L_0x005a
            r9 = 1
            goto L_0x005d
        L_0x005a:
            throw r4
        L_0x005c:
            r9 = r5
        L_0x005d:
            r10 = 1937011555(0x73747363, float:1.9367382E31)
            com.google.android.gms.internal.ads.zzajn r10 = r0.zzb(r10)
            if (r10 == 0) goto L_0x05e9
            r11 = 1937011827(0x73747473, float:1.9367711E31)
            com.google.android.gms.internal.ads.zzajn r11 = r0.zzb(r11)
            if (r11 == 0) goto L_0x05e7
            r12 = 1937011571(0x73747373, float:1.9367401E31)
            com.google.android.gms.internal.ads.zzajn r12 = r0.zzb(r12)
            if (r12 == 0) goto L_0x007c
            com.google.android.gms.internal.ads.zzfu r12 = r12.zza
            goto L_0x007d
        L_0x007c:
            r12 = r4
        L_0x007d:
            r13 = 1668576371(0x63747473, float:4.5093966E21)
            com.google.android.gms.internal.ads.zzajn r0 = r0.zzb(r13)
            if (r0 == 0) goto L_0x008a
            com.google.android.gms.internal.ads.zzfu r0 = r0.zza
            goto L_0x008b
        L_0x008a:
            r0 = r4
        L_0x008b:
            com.google.android.gms.internal.ads.zzfu r11 = r11.zza
            com.google.android.gms.internal.ads.zzfu r10 = r10.zza
            com.google.android.gms.internal.ads.zzfu r7 = r7.zza
            com.google.android.gms.internal.ads.zzajp r13 = new com.google.android.gms.internal.ads.zzajp
            r13.<init>(r10, r7, r9)
            r7 = 12
            r11.zzK(r7)
            int r9 = r11.zzp()
            r10 = -1
            int r9 = r9 + r10
            int r14 = r11.zzp()
            int r15 = r11.zzp()
            if (r0 == 0) goto L_0x00b3
            r0.zzK(r7)
            int r16 = r0.zzp()
            goto L_0x00b5
        L_0x00b3:
            r16 = r5
        L_0x00b5:
            if (r12 == 0) goto L_0x00c9
            r12.zzK(r7)
            int r7 = r12.zzp()
            if (r7 <= 0) goto L_0x00c7
            int r17 = r12.zzp()
            int r17 = r17 + -1
            goto L_0x00cc
        L_0x00c7:
            r12 = r4
            goto L_0x00ca
        L_0x00c9:
            r7 = r5
        L_0x00ca:
            r17 = r10
        L_0x00cc:
            int r5 = r6.zza()
            com.google.android.gms.internal.ads.zzan r4 = r1.zzf
            java.lang.String r4 = r4.zzn
            r44 = r9
            if (r5 == r10) goto L_0x0190
            java.lang.String r8 = "audio/raw"
            boolean r8 = r8.equals(r4)
            if (r8 != 0) goto L_0x00f0
            java.lang.String r8 = "audio/g711-mlaw"
            boolean r8 = r8.equals(r4)
            if (r8 != 0) goto L_0x00f0
            java.lang.String r8 = "audio/g711-alaw"
            boolean r4 = r8.equals(r4)
            if (r4 == 0) goto L_0x0190
        L_0x00f0:
            if (r44 != 0) goto L_0x0190
            if (r16 != 0) goto L_0x018e
            if (r7 != 0) goto L_0x018c
            int r0 = r13.zza
            long[] r4 = new long[r0]
            int[] r6 = new int[r0]
        L_0x00fc:
            boolean r7 = r13.zza()
            if (r7 == 0) goto L_0x010d
            int r7 = r13.zzb
            long r8 = r13.zzd
            r4[r7] = r8
            int r8 = r13.zzc
            r6[r7] = r8
            goto L_0x00fc
        L_0x010d:
            long r7 = (long) r15
            r9 = 8192(0x2000, float:1.14794E-41)
            int r9 = r9 / r5
            r11 = 0
            r12 = 0
        L_0x0113:
            if (r11 >= r0) goto L_0x0120
            r13 = r6[r11]
            int r14 = com.google.android.gms.internal.ads.zzgd.zza
            int r13 = r13 + r9
            int r13 = r13 + r10
            int r13 = r13 / r9
            int r12 = r12 + r13
            int r11 = r11 + 1
            goto L_0x0113
        L_0x0120:
            long[] r10 = new long[r12]
            int[] r11 = new int[r12]
            long[] r13 = new long[r12]
            int[] r12 = new int[r12]
            r14 = 0
            r15 = 0
            r16 = 0
            r17 = 0
        L_0x012e:
            if (r14 >= r0) goto L_0x017e
            r23 = r6[r14]
            r24 = r4[r14]
            r40 = r17
            r17 = r0
            r0 = r16
            r16 = r40
            r41 = r23
            r23 = r4
            r4 = r41
        L_0x0142:
            if (r4 <= 0) goto L_0x016d
            int r26 = java.lang.Math.min(r9, r4)
            r10[r16] = r24
            r44 = r6
            int r6 = r5 * r26
            r11[r16] = r6
            int r0 = java.lang.Math.max(r0, r6)
            r27 = r5
            long r5 = (long) r15
            long r5 = r5 * r7
            r13[r16] = r5
            r5 = 1
            r12[r16] = r5
            r5 = r11[r16]
            long r5 = (long) r5
            long r24 = r24 + r5
            int r15 = r15 + r26
            int r4 = r4 - r26
            int r16 = r16 + 1
            r6 = r44
            r5 = r27
            goto L_0x0142
        L_0x016d:
            r27 = r5
            r44 = r6
            int r14 = r14 + 1
            r4 = r23
            r40 = r16
            r16 = r0
            r0 = r17
            r17 = r40
            goto L_0x012e
        L_0x017e:
            long r4 = (long) r15
            long r7 = r7 * r4
            r15 = r1
            r0 = r3
            r2 = r10
            r3 = r11
            r6 = r12
            r5 = r13
            r4 = r16
            r16 = r7
            goto L_0x034a
        L_0x018c:
            r9 = 0
            goto L_0x0192
        L_0x018e:
            r9 = 0
            goto L_0x0192
        L_0x0190:
            r9 = r44
        L_0x0192:
            long[] r4 = new long[r3]
            int[] r5 = new int[r3]
            long[] r8 = new long[r3]
            int[] r10 = new int[r3]
            r23 = r9
            r9 = r17
            r1 = 0
            r2 = 0
            r17 = 0
            r24 = 0
            r25 = 0
            r26 = 0
            r28 = 0
        L_0x01aa:
            r30 = r11
            java.lang.String r11 = "AtomParsers"
            if (r2 >= r3) goto L_0x0285
            r31 = r26
            r26 = 1
        L_0x01b4:
            if (r17 != 0) goto L_0x01d9
            boolean r26 = r13.zza()
            if (r26 == 0) goto L_0x01d1
            r27 = r14
            r33 = r15
            long r14 = r13.zzd
            r34 = r3
            int r3 = r13.zzc
            r17 = r3
            r31 = r14
            r14 = r27
            r15 = r33
            r3 = r34
            goto L_0x01b4
        L_0x01d1:
            r34 = r3
            r27 = r14
            r33 = r15
            r3 = 0
            goto L_0x01e1
        L_0x01d9:
            r34 = r3
            r27 = r14
            r33 = r15
            r3 = r17
        L_0x01e1:
            if (r26 != 0) goto L_0x01fb
            java.lang.String r3 = "Unexpected end of chunk data"
            com.google.android.gms.internal.ads.zzfk.zzf(r11, r3)
            long[] r4 = java.util.Arrays.copyOf(r4, r2)
            int[] r5 = java.util.Arrays.copyOf(r5, r2)
            long[] r8 = java.util.Arrays.copyOf(r8, r2)
            int[] r10 = java.util.Arrays.copyOf(r10, r2)
            r3 = r2
            goto L_0x028d
        L_0x01fb:
            if (r0 != 0) goto L_0x0200
            r11 = r24
            goto L_0x0216
        L_0x0200:
            if (r25 != 0) goto L_0x0211
            if (r16 <= 0) goto L_0x020f
            int r16 = r16 + -1
            int r25 = r0.zzp()
            int r24 = r0.zzg()
            goto L_0x0200
        L_0x020f:
            r25 = 0
        L_0x0211:
            r11 = -1
            int r25 = r25 + -1
            r11 = r24
        L_0x0216:
            r4[r2] = r31
            int r14 = r6.zzc()
            r5[r2] = r14
            if (r14 <= r1) goto L_0x0221
            r1 = r14
        L_0x0221:
            long r14 = (long) r11
            long r14 = r28 + r14
            r8[r2] = r14
            if (r12 != 0) goto L_0x022a
            r14 = 1
            goto L_0x022b
        L_0x022a:
            r14 = 0
        L_0x022b:
            r10[r2] = r14
            if (r2 != r9) goto L_0x0242
            r14 = 1
            r10[r2] = r14
            int r7 = r7 + -1
            if (r7 <= 0) goto L_0x0242
            if (r12 == 0) goto L_0x023f
            int r9 = r12.zzp()
            r14 = -1
            int r9 = r9 + r14
            goto L_0x0242
        L_0x023f:
            r0 = 0
            throw r0
        L_0x0242:
            r14 = r6
            r17 = r7
            r15 = r33
            long r6 = (long) r15
            long r28 = r28 + r6
            int r6 = r27 + -1
            if (r6 != 0) goto L_0x025d
            if (r23 <= 0) goto L_0x025c
            int r6 = r30.zzp()
            int r7 = r30.zzg()
            int r23 = r23 + -1
            r15 = r7
            goto L_0x025d
        L_0x025c:
            r6 = 0
        L_0x025d:
            r7 = r5[r2]
            r26 = r4
            r33 = r5
            long r4 = (long) r7
            long r4 = r31 + r4
            r31 = -1
            int r3 = r3 + -1
            int r2 = r2 + 1
            r24 = r11
            r7 = r17
            r11 = r30
            r17 = r3
            r3 = r34
            r40 = r14
            r14 = r6
            r6 = r40
            r41 = r4
            r4 = r26
            r26 = r41
            r5 = r33
            goto L_0x01aa
        L_0x0285:
            r34 = r3
            r26 = r4
            r33 = r5
            r27 = r14
        L_0x028d:
            r2 = r24
            long r12 = (long) r2
            long r12 = r28 + r12
            if (r0 == 0) goto L_0x02a4
        L_0x0294:
            if (r16 <= 0) goto L_0x02a4
            int r2 = r0.zzp()
            if (r2 == 0) goto L_0x029e
            r0 = 0
            goto L_0x02a5
        L_0x029e:
            r0.zzg()
            int r16 = r16 + -1
            goto L_0x0294
        L_0x02a4:
            r0 = 1
        L_0x02a5:
            if (r7 != 0) goto L_0x02e5
            if (r27 != 0) goto L_0x02da
            if (r17 != 0) goto L_0x02d1
            if (r23 != 0) goto L_0x02c9
            if (r25 != 0) goto L_0x02c2
            if (r0 != 0) goto L_0x02b8
            r0 = 0
            r2 = 0
            r6 = 0
            r7 = 0
            r9 = 0
            r14 = 0
            goto L_0x02ee
        L_0x02b8:
            r15 = r43
            r16 = r1
            r44 = r3
            r17 = r4
            goto L_0x033f
        L_0x02c2:
            r14 = r0
            r9 = r25
            r0 = 0
            r2 = 0
            r6 = 0
            goto L_0x02e3
        L_0x02c9:
            r14 = r0
            r6 = r23
            r9 = r25
            r0 = 0
            r2 = 0
            goto L_0x02e3
        L_0x02d1:
            r14 = r0
            r2 = r17
            r6 = r23
            r9 = r25
            r0 = 0
            goto L_0x02e3
        L_0x02da:
            r14 = r0
            r2 = r17
            r6 = r23
            r9 = r25
            r0 = r27
        L_0x02e3:
            r7 = 0
            goto L_0x02ee
        L_0x02e5:
            r14 = r0
            r2 = r17
            r6 = r23
            r9 = r25
            r0 = r27
        L_0x02ee:
            r15 = r43
            r16 = r1
            int r1 = r15.zza
            r44 = r3
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r17 = r4
            java.lang.String r4 = "Inconsistent stbl box for track "
            r3.append(r4)
            r3.append(r1)
            java.lang.String r1 = ": remainingSynchronizationSamples "
            r3.append(r1)
            r3.append(r7)
            java.lang.String r1 = ", remainingSamplesAtTimestampDelta "
            r3.append(r1)
            r3.append(r0)
            java.lang.String r0 = ", remainingSamplesInChunk "
            r3.append(r0)
            r3.append(r2)
            java.lang.String r0 = ", remainingTimestampDeltaChanges "
            r3.append(r0)
            r3.append(r6)
            java.lang.String r0 = ", remainingSamplesAtTimestampOffset "
            r3.append(r0)
            r3.append(r9)
            r0 = 1
            if (r0 == r14) goto L_0x0333
            java.lang.String r0 = ", ctts invalid"
            goto L_0x0335
        L_0x0333:
            java.lang.String r0 = ""
        L_0x0335:
            r3.append(r0)
            java.lang.String r0 = r3.toString()
            com.google.android.gms.internal.ads.zzfk.zzf(r11, r0)
        L_0x033f:
            r0 = r44
            r3 = r5
            r5 = r8
            r6 = r10
            r4 = r16
            r2 = r17
            r16 = r12
        L_0x034a:
            long r11 = r15.zzc
            java.math.RoundingMode r13 = java.math.RoundingMode.FLOOR
            r9 = 1000000(0xf4240, double:4.940656E-318)
            r7 = r16
            long r7 = com.google.android.gms.internal.ads.zzgd.zzt(r7, r9, r11, r13)
            long[] r1 = r15.zzh
            if (r1 != 0) goto L_0x0369
            long r0 = r15.zzc
            com.google.android.gms.internal.ads.zzgd.zzF(r5, r9, r0)
            com.google.android.gms.internal.ads.zzaks r9 = new com.google.android.gms.internal.ads.zzaks
            r0 = r9
            r1 = r43
            r0.<init>(r1, r2, r3, r4, r5, r6, r7)
            return r9
        L_0x0369:
            int r7 = r1.length
            r8 = 1
            if (r7 != r8) goto L_0x0428
            int r7 = r15.zzb
            if (r7 != r8) goto L_0x0428
            int r7 = r5.length
            r8 = 2
            if (r7 < r8) goto L_0x0426
            long[] r8 = r15.zzi
            if (r8 == 0) goto L_0x0423
            r11 = 0
            r12 = r8[r11]
            r23 = r1[r11]
            long r9 = r15.zzc
            r8 = r0
            long r0 = r15.zzd
            java.math.RoundingMode r29 = java.math.RoundingMode.FLOOR
            r25 = r9
            r27 = r0
            long r0 = com.google.android.gms.internal.ads.zzgd.zzt(r23, r25, r27, r29)
            long r0 = r0 + r12
            int r9 = r7 + -1
            r10 = 4
            int r10 = java.lang.Math.min(r10, r9)
            r11 = 0
            int r10 = java.lang.Math.max(r11, r10)
            int r7 = r7 + -4
            int r7 = java.lang.Math.min(r7, r9)
            int r7 = java.lang.Math.max(r11, r7)
            r23 = r5[r11]
            int r9 = (r23 > r12 ? 1 : (r23 == r12 ? 0 : -1))
            if (r9 > 0) goto L_0x0429
            r9 = r5[r10]
            int r9 = (r12 > r9 ? 1 : (r12 == r9 ? 0 : -1))
            if (r9 >= 0) goto L_0x0429
            r9 = r5[r7]
            int r7 = (r9 > r0 ? 1 : (r9 == r0 ? 0 : -1))
            if (r7 >= 0) goto L_0x0429
            int r7 = (r0 > r16 ? 1 : (r0 == r16 ? 0 : -1))
            if (r7 > 0) goto L_0x0429
            long r32 = r12 - r23
            com.google.android.gms.internal.ads.zzan r7 = r15.zzf
            int r7 = r7.zzB
            long r9 = (long) r7
            long r11 = r15.zzc
            java.math.RoundingMode r38 = java.math.RoundingMode.FLOOR
            r34 = r9
            r36 = r11
            long r9 = com.google.android.gms.internal.ads.zzgd.zzt(r32, r34, r36, r38)
            com.google.android.gms.internal.ads.zzan r7 = r15.zzf
            int r7 = r7.zzB
            long r11 = (long) r7
            long r13 = r15.zzc
            long r23 = r16 - r0
            java.math.RoundingMode r29 = java.math.RoundingMode.FLOOR
            r25 = r11
            r27 = r13
            long r0 = com.google.android.gms.internal.ads.zzgd.zzt(r23, r25, r27, r29)
            r11 = 0
            int r7 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r7 != 0) goto L_0x03ed
            int r7 = (r0 > r11 ? 1 : (r0 == r11 ? 0 : -1))
            if (r7 == 0) goto L_0x0429
            r9 = 0
            goto L_0x03ee
        L_0x03ed:
        L_0x03ee:
            r11 = 2147483647(0x7fffffff, double:1.060997895E-314)
            int r7 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r7 > 0) goto L_0x0429
            int r7 = (r0 > r11 ? 1 : (r0 == r11 ? 0 : -1))
            if (r7 <= 0) goto L_0x03fa
            goto L_0x0429
        L_0x03fa:
            int r7 = (int) r9
            r8 = r45
            r8.zza = r7
            int r0 = (int) r0
            r8.zzb = r0
            long r0 = r15.zzc
            r7 = 1000000(0xf4240, double:4.940656E-318)
            com.google.android.gms.internal.ads.zzgd.zzF(r5, r7, r0)
            long[] r0 = r15.zzh
            r1 = 0
            r7 = r0[r1]
            long r11 = r15.zzd
            java.math.RoundingMode r13 = java.math.RoundingMode.FLOOR
            r9 = 1000000(0xf4240, double:4.940656E-318)
            long r7 = com.google.android.gms.internal.ads.zzgd.zzt(r7, r9, r11, r13)
            com.google.android.gms.internal.ads.zzaks r9 = new com.google.android.gms.internal.ads.zzaks
            r0 = r9
            r1 = r43
            r0.<init>(r1, r2, r3, r4, r5, r6, r7)
            return r9
        L_0x0423:
            r0 = 0
            throw r0
        L_0x0426:
            r8 = r0
            goto L_0x0429
        L_0x0428:
            r8 = r0
        L_0x0429:
            long[] r0 = r15.zzh
            int r1 = r0.length
            r7 = 1
            if (r1 != r7) goto L_0x0475
            r1 = 0
            r9 = r0[r1]
            r11 = 0
            int r0 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r0 != 0) goto L_0x0473
            long[] r0 = r15.zzi
            if (r0 == 0) goto L_0x0470
            r7 = r0[r1]
            r0 = 0
        L_0x043f:
            int r1 = r5.length
            if (r0 >= r1) goto L_0x0458
            r9 = r5[r0]
            long r18 = r9 - r7
            long r9 = r15.zzc
            java.math.RoundingMode r24 = java.math.RoundingMode.FLOOR
            r20 = 1000000(0xf4240, double:4.940656E-318)
            r22 = r9
            long r9 = com.google.android.gms.internal.ads.zzgd.zzt(r18, r20, r22, r24)
            r5[r0] = r9
            int r0 = r0 + 1
            goto L_0x043f
        L_0x0458:
            long r18 = r16 - r7
            long r0 = r15.zzc
            java.math.RoundingMode r24 = java.math.RoundingMode.FLOOR
            r20 = 1000000(0xf4240, double:4.940656E-318)
            r22 = r0
            long r7 = com.google.android.gms.internal.ads.zzgd.zzt(r18, r20, r22, r24)
            com.google.android.gms.internal.ads.zzaks r9 = new com.google.android.gms.internal.ads.zzaks
            r0 = r9
            r1 = r43
            r0.<init>(r1, r2, r3, r4, r5, r6, r7)
            return r9
        L_0x0470:
            r0 = 0
            throw r0
        L_0x0473:
            r1 = 1
            goto L_0x0476
        L_0x0475:
        L_0x0476:
            int r0 = r15.zzb
            r7 = 1
            if (r0 != r7) goto L_0x047d
            r0 = 1
            goto L_0x047e
        L_0x047d:
            r0 = 0
        L_0x047e:
            long[] r7 = r15.zzi
            int[] r9 = new int[r1]
            int[] r1 = new int[r1]
            if (r7 == 0) goto L_0x05e4
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 0
        L_0x048a:
            long[] r14 = r15.zzh
            r44 = r4
            int r4 = r14.length
            if (r11 >= r4) goto L_0x04f2
            r16 = r3
            r3 = r7[r11]
            r23 = -1
            int r17 = (r3 > r23 ? 1 : (r3 == r23 ? 0 : -1))
            if (r17 == 0) goto L_0x04e1
            r23 = r14[r11]
            r17 = r7
            r14 = r8
            long r7 = r15.zzc
            r45 = r12
            r19 = r13
            long r12 = r15.zzd
            java.math.RoundingMode r29 = java.math.RoundingMode.FLOOR
            r25 = r7
            r27 = r12
            long r7 = com.google.android.gms.internal.ads.zzgd.zzt(r23, r25, r27, r29)
            r12 = 1
            int r13 = com.google.android.gms.internal.ads.zzgd.zzc(r5, r3, r12, r12)
            r9[r11] = r13
            long r3 = r3 + r7
            r7 = 0
            int r3 = com.google.android.gms.internal.ads.zzgd.zza(r5, r3, r0, r7)
            r1[r11] = r3
        L_0x04c1:
            r3 = r9[r11]
            r4 = r1[r11]
            if (r3 >= r4) goto L_0x04d2
            r8 = r6[r3]
            r12 = 1
            r8 = r8 & r12
            if (r8 != 0) goto L_0x04d2
            int r3 = r3 + 1
            r9[r11] = r3
            goto L_0x04c1
        L_0x04d2:
            int r8 = r4 - r3
            int r10 = r10 + r8
            r8 = r19
            if (r8 == r3) goto L_0x04db
            r3 = 1
            goto L_0x04dc
        L_0x04db:
            r3 = r7
        L_0x04dc:
            r3 = r45 | r3
            r12 = r3
            r13 = r4
            goto L_0x04e8
        L_0x04e1:
            r17 = r7
            r14 = r8
            r45 = r12
            r8 = r13
            r7 = 0
        L_0x04e8:
            int r11 = r11 + 1
            r4 = r44
            r8 = r14
            r3 = r16
            r7 = r17
            goto L_0x048a
        L_0x04f2:
            r16 = r3
            r14 = r8
            r45 = r12
            r7 = 0
            r3 = r14
            if (r10 == r3) goto L_0x04fd
            r0 = 1
            goto L_0x04fe
        L_0x04fd:
            r0 = r7
        L_0x04fe:
            r0 = r45 | r0
            if (r0 == 0) goto L_0x0505
            long[] r3 = new long[r10]
            goto L_0x0506
        L_0x0505:
            r3 = r2
        L_0x0506:
            if (r0 == 0) goto L_0x050b
            int[] r4 = new int[r10]
            goto L_0x050d
        L_0x050b:
            r4 = r16
        L_0x050d:
            r8 = 1
            if (r8 != r0) goto L_0x0512
            r8 = r7
            goto L_0x0514
        L_0x0512:
            r8 = r44
        L_0x0514:
            if (r0 == 0) goto L_0x0519
            int[] r11 = new int[r10]
            goto L_0x051a
        L_0x0519:
            r11 = r6
        L_0x051a:
            long[] r10 = new long[r10]
            r12 = r7
            r13 = 0
        L_0x051f:
            r44 = r8
            long[] r8 = r15.zzh
            int r8 = r8.length
            if (r7 >= r8) goto L_0x05c6
            long[] r8 = r15.zzi
            r17 = r8[r7]
            r8 = r9[r7]
            r30 = r9
            r9 = r1[r7]
            if (r0 == 0) goto L_0x0544
            r31 = r1
            int r1 = r9 - r8
            java.lang.System.arraycopy(r2, r8, r3, r12, r1)
            r32 = r2
            r2 = r16
            java.lang.System.arraycopy(r2, r8, r4, r12, r1)
            java.lang.System.arraycopy(r6, r8, r11, r12, r1)
            goto L_0x054a
        L_0x0544:
            r31 = r1
            r32 = r2
            r2 = r16
        L_0x054a:
            r1 = r44
        L_0x054c:
            if (r8 >= r9) goto L_0x05a3
            r16 = r6
            r19 = r7
            long r6 = r15.zzd
            java.math.RoundingMode r29 = java.math.RoundingMode.FLOOR
            r25 = 1000000(0xf4240, double:4.940656E-318)
            r23 = r13
            r27 = r6
            long r6 = com.google.android.gms.internal.ads.zzgd.zzt(r23, r25, r27, r29)
            r23 = r5[r8]
            long r33 = r23 - r17
            r23 = r13
            long r13 = r15.zzc
            java.math.RoundingMode r39 = java.math.RoundingMode.FLOOR
            r35 = 1000000(0xf4240, double:4.940656E-318)
            r37 = r13
            long r13 = com.google.android.gms.internal.ads.zzgd.zzt(r33, r35, r37, r39)
            r25 = r5
            int r5 = r15.zzb
            r45 = r9
            r9 = 1
            if (r5 == r9) goto L_0x0585
            r5 = r10
            r9 = 0
            long r13 = java.lang.Math.max(r9, r13)
            goto L_0x0588
        L_0x0585:
            r5 = r10
            r9 = 0
        L_0x0588:
            long r6 = r6 + r13
            r5[r12] = r6
            if (r0 == 0) goto L_0x0593
            r6 = r4[r12]
            if (r6 <= r1) goto L_0x0593
            r1 = r2[r8]
        L_0x0593:
            int r12 = r12 + 1
            int r8 = r8 + 1
            r9 = r45
            r10 = r5
            r6 = r16
            r7 = r19
            r13 = r23
            r5 = r25
            goto L_0x054c
        L_0x05a3:
            r25 = r5
            r16 = r6
            r19 = r7
            r5 = r10
            r23 = r13
            r9 = 0
            long[] r6 = r15.zzh
            r7 = r6[r19]
            long r13 = r23 + r7
            int r7 = r19 + 1
            r8 = r1
            r10 = r5
            r6 = r16
            r5 = r25
            r9 = r30
            r1 = r31
            r16 = r2
            r2 = r32
            goto L_0x051f
        L_0x05c6:
            r5 = r10
            r23 = r13
            long r0 = r15.zzd
            java.math.RoundingMode r29 = java.math.RoundingMode.FLOOR
            r25 = 1000000(0xf4240, double:4.940656E-318)
            r27 = r0
            long r7 = com.google.android.gms.internal.ads.zzgd.zzt(r23, r25, r27, r29)
            com.google.android.gms.internal.ads.zzaks r9 = new com.google.android.gms.internal.ads.zzaks
            r0 = r9
            r1 = r43
            r2 = r3
            r3 = r4
            r4 = r44
            r6 = r11
            r0.<init>(r1, r2, r3, r4, r5, r6, r7)
            return r9
        L_0x05e4:
            r0 = 0
            throw r0
        L_0x05e7:
            r0 = r4
            throw r0
        L_0x05e9:
            r0 = r4
            throw r0
        L_0x05eb:
            r0 = r4
            java.lang.String r1 = "Track has no sample table size information"
            com.google.android.gms.internal.ads.zzch r0 = com.google.android.gms.internal.ads.zzch.zza(r1, r0)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzajw.zzk(com.google.android.gms.internal.ads.zzakp, com.google.android.gms.internal.ads.zzajm, com.google.android.gms.internal.ads.zzaej):com.google.android.gms.internal.ads.zzaks");
    }

    private static ByteBuffer zzl() {
        return ByteBuffer.allocate(25).order(ByteOrder.LITTLE_ENDIAN);
    }

    private static void zzm(zzfu zzfu, int i, int i2, int i3, int i4, String str, boolean z, zzae zzae, zzajs zzajs, int i5) throws zzch {
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        zzae zzae2;
        int i11;
        String str2;
        String str3;
        int i12;
        String str4;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        boolean z2;
        String str5;
        zzfu zzfu2 = zzfu;
        int i18 = i2;
        int i19 = i3;
        int i20 = i4;
        String str6 = str;
        zzae zzae3 = zzae;
        zzajs zzajs2 = zzajs;
        zzfu2.zzK(i18 + 16);
        if (z) {
            i6 = zzfu.zzq();
            zzfu2.zzL(6);
        } else {
            zzfu2.zzL(8);
            i6 = 0;
        }
        if (i6 == 0 || i6 == 1) {
            int zzq = zzfu.zzq();
            zzfu2.zzL(6);
            i10 = zzfu.zzn();
            zzfu2.zzK(zzfu.zzd() - 4);
            i7 = zzfu.zzg();
            if (i6 == 1) {
                zzfu2.zzL(16);
                i8 = zzq;
                i9 = -1;
            } else {
                i8 = zzq;
                i9 = -1;
            }
        } else if (i6 == 2) {
            zzfu2.zzL(16);
            i10 = (int) Math.round(Double.longBitsToDouble(zzfu.zzt()));
            i8 = zzfu.zzp();
            zzfu2.zzL(4);
            int zzp = zzfu.zzp();
            int zzp2 = zzfu.zzp();
            int i21 = zzp2 & 1;
            int i22 = zzp2 & 2;
            if (i21 == 0) {
                if (zzp == 8) {
                    i9 = 3;
                } else if (zzp == 16) {
                    i9 = i22 != 0 ? 268435456 : 2;
                } else if (zzp == 24) {
                    i9 = i22 != 0 ? 1342177280 : 21;
                } else if (zzp == 32) {
                    i9 = i22 != 0 ? 1610612736 : 22;
                }
                zzfu2.zzL(8);
                i7 = 0;
            } else if (zzp == 32) {
                i9 = 4;
                zzfu2.zzL(8);
                i7 = 0;
            }
            i9 = -1;
            zzfu2.zzL(8);
            i7 = 0;
        } else {
            return;
        }
        int zzd = zzfu.zzd();
        int i23 = 1701733217;
        int i24 = i;
        if (i24 == 1701733217) {
            Pair zzh = zzh(zzfu2, i18, i19);
            if (zzh != null) {
                i23 = ((Integer) zzh.first).intValue();
                if (zzae3 == null) {
                    zzae2 = null;
                } else {
                    zzae2 = zzae3.zzb(((zzakq) zzh.second).zzb);
                }
                zzajs2.zza[i5] = (zzakq) zzh.second;
            } else {
                zzae2 = zzae3;
            }
            zzfu2.zzK(zzd);
            i24 = i23;
        } else {
            zzae2 = zzae3;
        }
        String str7 = "audio/mhm1";
        if (i24 == 1633889587) {
            str2 = "audio/ac3";
            i11 = i9;
        } else {
            if (i24 == 1700998451) {
                str2 = "audio/eac3";
            } else if (i24 == 1633889588) {
                i11 = i9;
                str2 = "audio/ac4";
            } else if (i24 == 1685353315) {
                str2 = "audio/vnd.dts";
            } else if (i24 == 1685353320 || i24 == 1685353324) {
                str2 = "audio/vnd.dts.hd";
            } else if (i24 == 1685353317) {
                str2 = "audio/vnd.dts.hd;profile=lbr";
            } else if (i24 == 1685353336) {
                str2 = "audio/vnd.dts.uhd;profile=p2";
            } else if (i24 == 1935764850) {
                str2 = "audio/3gpp";
            } else if (i24 == 1935767394) {
                str2 = "audio/amr-wb";
            } else {
                if (i24 != 1936684916) {
                    if (i24 == 1953984371) {
                        str2 = "audio/raw";
                        i11 = 268435456;
                    } else if (i24 == 1819304813) {
                        if (i9 != -1) {
                            i11 = i9;
                            str2 = "audio/raw";
                        }
                    } else if (i24 == 778924082 || i24 == 778924083) {
                        str2 = "audio/mpeg";
                    } else if (i24 == 1835557169) {
                        str2 = "audio/mha1";
                    } else if (i24 == 1835560241) {
                        i11 = i9;
                        str2 = str7;
                    } else if (i24 == 1634492771) {
                        str2 = "audio/alac";
                    } else if (i24 == 1634492791) {
                        str2 = "audio/g711-alaw";
                    } else if (i24 == 1970037111) {
                        str2 = "audio/g711-mlaw";
                    } else if (i24 == 1332770163) {
                        str2 = "audio/opus";
                    } else if (i24 == 1716281667) {
                        str2 = "audio/flac";
                    } else if (i24 == 1835823201) {
                        str2 = "audio/true-hd";
                    } else {
                        i11 = i9;
                        str2 = null;
                    }
                }
                str2 = "audio/raw";
                i11 = 2;
            }
            i11 = i9;
        }
        int i25 = i11;
        String str8 = null;
        List list = null;
        zzajq zzajq = null;
        while (true) {
            String str9 = str8;
            if (zzd - i18 < i19) {
                zzfu2.zzK(zzd);
                int zzg = zzfu.zzg();
                String str10 = "childAtomSize must be positive";
                zzady.zzb(zzg > 0, str10);
                int zzg2 = zzfu.zzg();
                int i26 = i10;
                if (zzg2 == 1835557187) {
                    zzfu2.zzK(zzd + 8);
                    zzfu2.zzL(1);
                    int zzm = zzfu.zzm();
                    zzfu2.zzL(1);
                    if (Objects.equals(str2, str7)) {
                        str5 = String.format("mhm1.%02X", new Object[]{Integer.valueOf(zzm)});
                    } else {
                        str5 = String.format("mha1.%02X", new Object[]{Integer.valueOf(zzm)});
                    }
                    int zzq2 = zzfu.zzq();
                    byte[] bArr = new byte[zzq2];
                    String str11 = str5;
                    zzfu2.zzG(bArr, 0, zzq2);
                    if (list == null) {
                        list = zzgbc.zzn(bArr);
                        str4 = str11;
                        i14 = i26;
                        i12 = i7;
                        str3 = str7;
                    } else {
                        list = zzgbc.zzo(bArr, (byte[]) list.get(0));
                        str4 = str11;
                        i14 = i26;
                        i12 = i7;
                        str3 = str7;
                    }
                } else {
                    if (zzg2 == 1835557200) {
                        zzfu2.zzK(zzd + 8);
                        int zzm2 = zzfu.zzm();
                        if (zzm2 > 0) {
                            byte[] bArr2 = new byte[zzm2];
                            zzfu2.zzG(bArr2, 0, zzm2);
                            if (list == null) {
                                list = zzgbc.zzn(bArr2);
                                str4 = str9;
                                i12 = i7;
                                str3 = str7;
                                i14 = i26;
                            } else {
                                list = zzgbc.zzo((byte[]) list.get(0), bArr2);
                                str4 = str9;
                                i14 = i26;
                                i12 = i7;
                                str3 = str7;
                            }
                        } else {
                            i13 = i26;
                            i16 = i7;
                            str3 = str7;
                        }
                    } else {
                        if (zzg2 != 1702061171) {
                            if (z && zzg2 == 2002876005) {
                                int zzd2 = zzfu.zzd();
                                zzady.zzb(zzd2 >= zzd, (String) null);
                                i15 = zzd2;
                                while (true) {
                                    if (i15 - zzd >= zzg) {
                                        str3 = str7;
                                        i13 = i26;
                                        i15 = -1;
                                        break;
                                    }
                                    zzfu2.zzK(i15);
                                    int zzg3 = zzfu.zzg();
                                    if (zzg3 > 0) {
                                        str3 = str7;
                                        z2 = true;
                                    } else {
                                        str3 = str7;
                                        z2 = false;
                                    }
                                    zzady.zzb(z2, str10);
                                    String str12 = str10;
                                    if (zzfu.zzg() == 1702061171) {
                                        i13 = i26;
                                        break;
                                    }
                                    i15 += zzg3;
                                    str7 = str3;
                                    str10 = str12;
                                }
                            } else {
                                str3 = str7;
                                if (zzg2 == 1684103987) {
                                    zzfu2.zzK(zzd + 8);
                                    zzajs2.zzb = zzact.zzc(zzfu2, Integer.toString(i4), str6, zzae2);
                                    i13 = i26;
                                    i16 = i7;
                                } else if (zzg2 == 1684366131) {
                                    zzfu2.zzK(zzd + 8);
                                    zzajs2.zzb = zzact.zzd(zzfu2, Integer.toString(i4), str6, zzae2);
                                    i13 = i26;
                                    i16 = i7;
                                } else if (zzg2 == 1684103988) {
                                    zzfu2.zzK(zzd + 8);
                                    String num = Integer.toString(i4);
                                    int i27 = zzacw.zza;
                                    zzfu2.zzL(1);
                                    zzal zzal = new zzal();
                                    zzal.zzK(num);
                                    zzal.zzX("audio/ac4");
                                    zzal.zzy(2);
                                    if (1 != ((zzfu.zzm() & 32) >> 5)) {
                                        i17 = 44100;
                                    } else {
                                        i17 = 48000;
                                    }
                                    zzal.zzY(i17);
                                    zzal.zzE(zzae2);
                                    zzal.zzO(str6);
                                    zzajs2.zzb = zzal.zzad();
                                    i13 = i26;
                                    i16 = i7;
                                } else if (zzg2 != 1684892784) {
                                    if (zzg2 != 1684305011) {
                                        if (zzg2 != 1969517683) {
                                            if (zzg2 == 1682927731) {
                                                int i28 = zzg - 8;
                                                byte[] bArr3 = zza;
                                                byte[] copyOf = Arrays.copyOf(bArr3, bArr3.length + i28);
                                                zzfu2.zzK(zzd + 8);
                                                zzfu2.zzG(copyOf, zza.length, i28);
                                                list = zzaep.zze(copyOf);
                                                str4 = str9;
                                                i14 = i26;
                                                i12 = i7;
                                            } else if (zzg2 == 1684425825) {
                                                int i29 = zzg - 12;
                                                byte[] bArr4 = new byte[(i29 + 4)];
                                                bArr4[0] = 102;
                                                bArr4[1] = 76;
                                                bArr4[2] = 97;
                                                bArr4[3] = 67;
                                                zzfu2.zzK(zzd + 12);
                                                zzfu2.zzG(bArr4, 4, i29);
                                                list = zzgbc.zzn(bArr4);
                                                str4 = str9;
                                                i14 = i26;
                                                i12 = i7;
                                            } else if (zzg2 == 1634492771) {
                                                int i30 = zzg - 12;
                                                byte[] bArr5 = new byte[i30];
                                                zzfu2.zzK(zzd + 12);
                                                zzfu2.zzG(bArr5, 0, i30);
                                                int i31 = zzes.zza;
                                                zzfu zzfu3 = new zzfu(bArr5);
                                                zzfu3.zzK(9);
                                                int zzm3 = zzfu3.zzm();
                                                zzfu3.zzK(20);
                                                Pair create = Pair.create(Integer.valueOf(zzfu3.zzp()), Integer.valueOf(zzm3));
                                                int intValue = ((Integer) create.first).intValue();
                                                int intValue2 = ((Integer) create.second).intValue();
                                                list = zzgbc.zzn(bArr5);
                                                str4 = str9;
                                                i8 = intValue2;
                                                i14 = intValue;
                                                i12 = i7;
                                            } else {
                                                i13 = i26;
                                                i16 = i7;
                                            }
                                        }
                                    }
                                    zzal zzal2 = new zzal();
                                    zzal2.zzJ(i20);
                                    zzal2.zzX(str2);
                                    zzal2.zzy(i8);
                                    i13 = i26;
                                    zzal2.zzY(i13);
                                    zzal2.zzE(zzae2);
                                    zzal2.zzO(str6);
                                    zzajs2.zzb = zzal2.zzad();
                                    i16 = i7;
                                } else if (i7 > 0) {
                                    str4 = str9;
                                    i14 = i7;
                                    i12 = i14;
                                    i8 = 2;
                                } else {
                                    throw zzch.zza("Invalid sample rate for Dolby TrueHD MLP stream: " + i7, (Throwable) null);
                                }
                            }
                        } else {
                            i13 = i26;
                            str3 = str7;
                            i15 = zzd;
                        }
                        if (i15 != -1) {
                            zzajq = zzj(zzfu2, i15);
                            String zzc = zzajq.zza;
                            byte[] zzd3 = zzajq.zzb;
                            if (zzd3 == null) {
                                i12 = i7;
                                str4 = str9;
                                str2 = zzc;
                                i14 = i13;
                            } else if ("audio/vorbis".equals(zzc)) {
                                zzfu zzfu4 = new zzfu(zzd3);
                                zzfu4.zzL(1);
                                int i32 = 0;
                                while (zzfu4.zzb() > 0 && zzfu4.zzf() == 255) {
                                    zzfu4.zzL(1);
                                    i32 += 255;
                                    zzfu zzfu5 = zzfu;
                                }
                                int zzm4 = i32 + zzfu4.zzm();
                                int i33 = 0;
                                while (true) {
                                    if (zzfu4.zzb() <= 0) {
                                        i12 = i7;
                                        break;
                                    }
                                    i12 = i7;
                                    if (zzfu4.zzf() != 255) {
                                        break;
                                    }
                                    zzfu4.zzL(1);
                                    i33 += 255;
                                    i7 = i12;
                                }
                                int zzm5 = i33 + zzfu4.zzm();
                                byte[] bArr6 = new byte[zzm4];
                                int zzd4 = zzfu4.zzd();
                                System.arraycopy(zzd3, zzd4, bArr6, 0, zzm4);
                                int i34 = zzd4 + zzm4 + zzm5;
                                int length = zzd3.length - i34;
                                byte[] bArr7 = new byte[length];
                                System.arraycopy(zzd3, i34, bArr7, 0, length);
                                list = zzgbc.zzo(bArr6, bArr7);
                                str4 = str9;
                                str2 = zzc;
                                i14 = i13;
                            } else {
                                i12 = i7;
                                if ("audio/mp4a-latm".equals(zzc)) {
                                    zzacp zza2 = zzacq.zza(zzd3);
                                    i14 = zza2.zza;
                                    i8 = zza2.zzb;
                                    str4 = zza2.zzc;
                                } else {
                                    str4 = str9;
                                    i14 = i13;
                                }
                                list = zzgbc.zzn(zzd3);
                                str2 = zzc;
                            }
                        } else {
                            i16 = i7;
                        }
                    }
                    str4 = str9;
                    i14 = i13;
                }
                zzd += zzg;
                i18 = i2;
                i19 = i3;
                str8 = str4;
                i7 = i12;
                str7 = str3;
                zzfu2 = zzfu;
            } else {
                int i35 = i10;
                if (zzajs2.zzb == null && str2 != null) {
                    zzal zzal3 = new zzal();
                    zzal3.zzJ(i20);
                    zzal3.zzX(str2);
                    zzal3.zzz(str9);
                    zzal3.zzy(i8);
                    zzal3.zzY(i35);
                    zzal3.zzR(i25);
                    zzal3.zzL(list);
                    zzal3.zzE(zzae2);
                    zzal3.zzO(str6);
                    if (zzajq != null) {
                        zzal3.zzx(zzgea.zze(zzajq.zzc));
                        zzal3.zzS(zzgea.zze(zzajq.zzd));
                    }
                    zzajs2.zzb = zzal3.zzad();
                    return;
                }
                return;
            }
        }
    }
}
