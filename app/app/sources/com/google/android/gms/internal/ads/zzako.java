package com.google.android.gms.internal.ads;

import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
final class zzako {
    private static final int[] zza = {1769172845, 1769172786, 1769172787, 1769172788, 1769172789, 1769172790, 1769172793, 1635148593, 1752589105, 1751479857, 1635135537, 1836069937, 1836069938, 862401121, 862401122, 862417462, 862417718, 862414134, 862414646, 1295275552, 1295270176, 1714714144, 1801741417, 1295275600, 1903435808, 1297305174, 1684175153, 1769172332, 1885955686};

    public static zzaex zza(zzadv zzadv) throws IOException {
        return zzc(zzadv, true, false);
    }

    public static zzaex zzb(zzadv zzadv, boolean z) throws IOException {
        return zzc(zzadv, false, z);
    }

    private static zzaex zzc(zzadv zzadv, boolean z, boolean z2) throws IOException {
        int i;
        long j;
        boolean z3;
        boolean z4;
        zzfu zzfu;
        int[] iArr;
        zzadv zzadv2 = zzadv;
        boolean z5 = z2;
        long zzd = zzadv.zzd();
        long j2 = -1;
        int i2 = (zzd > -1 ? 1 : (zzd == -1 ? 0 : -1));
        long j3 = 4096;
        if (i2 != 0 && zzd <= 4096) {
            j3 = zzd;
        }
        zzfu zzfu2 = new zzfu(64);
        int i3 = (int) j3;
        boolean z6 = false;
        int i4 = 0;
        boolean z7 = false;
        while (true) {
            if (i4 >= i3) {
                boolean z8 = z6;
                break;
            }
            zzfu2.zzH(8);
            boolean z9 = true;
            if (zzadv2.zzm(zzfu2.zzM(), z6 ? 1 : 0, 8, true)) {
                long zzu = zzfu2.zzu();
                int zzg = zzfu2.zzg();
                if (zzu == 1) {
                    zzadv2.zzh(zzfu2.zzM(), 8, 8);
                    i = 16;
                    zzfu2.zzJ(16);
                    j = zzfu2.zzt();
                } else {
                    if (zzu == 0) {
                        long zzd2 = zzadv.zzd();
                        if (zzd2 != j2) {
                            zzu = (zzd2 - zzadv.zze()) + 8;
                        }
                    }
                    i = 8;
                    j = zzu;
                }
                zzfu zzfu3 = zzfu2;
                long j4 = (long) i;
                if (j >= j4) {
                    i4 += i;
                    if (zzg != 1836019574) {
                        if (zzg == 1836019558) {
                            z6 = true;
                            break;
                        } else if (zzg == 1836475768) {
                            z6 = true;
                            break;
                        } else {
                            if (zzg == 1835295092) {
                                z3 = false;
                            } else {
                                z3 = true;
                            }
                            z7 |= !z3;
                            int i5 = zzg;
                            long j5 = zzd;
                            if ((((long) i4) + j) - j4 >= ((long) i3)) {
                                z6 = false;
                                break;
                            }
                            int i6 = (int) (j - j4);
                            i4 += i6;
                            if (i5 != 1718909296) {
                                zzfu = zzfu3;
                                z4 = false;
                                if (i6 != 0) {
                                    zzadv2.zzg(i6);
                                }
                            } else if (i6 < 8) {
                                return new zzajx(1718909296, (long) i6, 8);
                            } else {
                                zzfu = zzfu3;
                                zzfu.zzH(i6);
                                z4 = false;
                                zzadv2.zzh(zzfu.zzM(), 0, i6);
                                int zzg2 = zzfu.zzg();
                                boolean zzd3 = zzd(zzg2, z5) | z7;
                                zzfu.zzL(4);
                                int zzb = zzfu.zzb() / 4;
                                if (!zzd3 && zzb > 0) {
                                    iArr = new int[zzb];
                                    int i7 = 0;
                                    while (true) {
                                        if (i7 >= zzb) {
                                            z9 = zzd3;
                                            break;
                                        }
                                        int zzg3 = zzfu.zzg();
                                        iArr[i7] = zzg3;
                                        if (zzd(zzg3, z5)) {
                                            break;
                                        }
                                        i7++;
                                    }
                                } else {
                                    z9 = zzd3;
                                    iArr = null;
                                }
                                if (!z9) {
                                    return new zzakt(zzg2, iArr);
                                }
                                z7 = z9;
                            }
                            zzfu2 = zzfu;
                            z6 = z4;
                            zzd = j5;
                            j2 = -1;
                        }
                    } else {
                        i3 += (int) j;
                        if (i2 == 0 || ((long) i3) <= zzd) {
                            zzfu2 = zzfu3;
                            j2 = -1;
                            z6 = false;
                        } else {
                            i3 = (int) zzd;
                            zzfu2 = zzfu3;
                            j2 = -1;
                            z6 = false;
                        }
                    }
                } else {
                    return new zzajx(zzg, j, i);
                }
            } else {
                break;
            }
        }
        if (!z7) {
            return zzakk.zza;
        }
        if (z != z6) {
            return z6 ? zzake.zza : zzake.zzb;
        }
        return null;
    }

    private static boolean zzd(int i, boolean z) {
        if ((i >>> 8) == 3368816) {
            return true;
        }
        if (i == 1751476579) {
            if (z) {
                return true;
            }
            i = 1751476579;
        }
        int[] iArr = zza;
        for (int i2 = 0; i2 < 29; i2++) {
            if (iArr[i2] == i) {
                return true;
            }
        }
        return false;
    }
}
