package com.google.android.gms.internal.ads;

import android.util.Pair;
import android.util.SparseArray;
import androidx.compose.animation.core.AnimationKt;
import androidx.core.view.ViewCompat;
import com.google.common.base.Ascii;
import java.io.IOException;
import java.math.RoundingMode;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzakd implements zzadu {
    @Deprecated
    public static final zzaea zza = new zzajz();
    private static final byte[] zzb = {-94, 57, 79, 82, 90, -101, 79, Ascii.DC4, -94, 68, 108, 66, 124, 100, -115, -12};
    private static final zzan zzc;
    private zzakc zzA;
    private int zzB;
    private int zzC;
    private int zzD;
    private boolean zzE;
    private zzadx zzF;
    private zzafa[] zzG;
    private zzafa[] zzH;
    private boolean zzI;
    private final zzalt zzd;
    private final List zze;
    private final SparseArray zzf;
    private final zzfu zzg;
    private final zzfu zzh;
    private final zzfu zzi;
    private final byte[] zzj;
    private final zzfu zzk;
    private final zzagu zzl;
    private final zzfu zzm;
    private final ArrayDeque zzn;
    private final ArrayDeque zzo;
    private zzgbc zzp;
    private int zzq;
    private int zzr;
    private long zzs;
    private int zzt;
    private zzfu zzu;
    private long zzv;
    private int zzw;
    private long zzx;
    private long zzy;
    private long zzz;

    static {
        zzal zzal = new zzal();
        zzal.zzX("application/x-emsg");
        zzc = zzal.zzad();
    }

    @Deprecated
    public zzakd() {
        this(zzalt.zza, 32, (zzgb) null, (zzakp) null, zzgbc.zzm(), (zzafa) null);
    }

    private static int zza(int i) throws zzch {
        if (i >= 0) {
            return i;
        }
        throw zzch.zza("Unexpected negative value: " + i, (Throwable) null);
    }

    private static zzae zzg(List list) {
        int i;
        ArrayList arrayList;
        zzakl zzakl;
        UUID[] uuidArr;
        int size = list.size();
        int i2 = 0;
        ArrayList arrayList2 = null;
        while (i2 < size) {
            zzajn zzajn = (zzajn) list.get(i2);
            if (zzajn.zzd == 1886614376) {
                if (arrayList2 == null) {
                    arrayList2 = new ArrayList();
                }
                byte[] zzM = zzajn.zza.zzM();
                zzfu zzfu = new zzfu(zzM);
                if (zzfu.zze() < 32) {
                    i = i2;
                    arrayList = arrayList2;
                    zzakl = null;
                } else {
                    zzfu.zzK(0);
                    int zzb2 = zzfu.zzb();
                    int zzg2 = zzfu.zzg();
                    if (zzg2 != zzb2) {
                        zzfk.zzf("PsshAtomUtil", "Advertised atom size (" + zzg2 + ") does not match buffer size: " + zzb2);
                        i = i2;
                        arrayList = arrayList2;
                        zzakl = null;
                    } else {
                        int zzg3 = zzfu.zzg();
                        if (zzg3 != 1886614376) {
                            zzfk.zzf("PsshAtomUtil", "Atom type is not pssh: " + zzg3);
                            i = i2;
                            arrayList = arrayList2;
                            zzakl = null;
                        } else {
                            int zze2 = zzajo.zze(zzfu.zzg());
                            if (zze2 > 1) {
                                zzfk.zzf("PsshAtomUtil", "Unsupported pssh version: " + zze2);
                                i = i2;
                                arrayList = arrayList2;
                                zzakl = null;
                            } else {
                                UUID uuid = new UUID(zzfu.zzt(), zzfu.zzt());
                                if (zze2 == 1) {
                                    int zzp2 = zzfu.zzp();
                                    uuidArr = new UUID[zzp2];
                                    int i3 = 0;
                                    while (i3 < zzp2) {
                                        uuidArr[i3] = new UUID(zzfu.zzt(), zzfu.zzt());
                                        i3++;
                                        List list2 = list;
                                        i2 = i2;
                                        arrayList2 = arrayList2;
                                    }
                                    i = i2;
                                    arrayList = arrayList2;
                                } else {
                                    i = i2;
                                    arrayList = arrayList2;
                                    uuidArr = null;
                                }
                                int zzp3 = zzfu.zzp();
                                int zzb3 = zzfu.zzb();
                                if (zzp3 != zzb3) {
                                    zzfk.zzf("PsshAtomUtil", "Atom data size (" + zzp3 + ") does not match the bytes left: " + zzb3);
                                    zzakl = null;
                                } else {
                                    byte[] bArr = new byte[zzp3];
                                    zzfu.zzG(bArr, 0, zzp3);
                                    zzakl = new zzakl(uuid, zze2, bArr, uuidArr);
                                }
                            }
                        }
                    }
                }
                UUID uuid2 = zzakl == null ? null : zzakl.zza;
                if (uuid2 == null) {
                    zzfk.zzf("FragmentedMp4Extractor", "Skipped pssh atom (failed to extract uuid)");
                    arrayList2 = arrayList;
                } else {
                    arrayList2 = arrayList;
                    arrayList2.add(new zzad(uuid2, (String) null, "video/mp4", zzM));
                }
            } else {
                i = i2;
            }
            i2 = i + 1;
        }
        if (arrayList2 == null) {
            return null;
        }
        return new zzae((List) arrayList2);
    }

    private final void zzh() {
        this.zzq = 0;
        this.zzt = 0;
    }

    private static void zzi(zzfu zzfu, int i, zzakr zzakr) throws zzch {
        boolean z;
        zzfu.zzK(i + 8);
        int zzg2 = zzfu.zzg() & ViewCompat.MEASURED_SIZE_MASK;
        if ((zzg2 & 1) == 0) {
            if ((zzg2 & 2) != 0) {
                z = true;
            } else {
                z = false;
            }
            int zzp2 = zzfu.zzp();
            if (zzp2 == 0) {
                Arrays.fill(zzakr.zzl, 0, zzakr.zze, false);
                return;
            }
            int i2 = zzakr.zze;
            if (zzp2 == i2) {
                Arrays.fill(zzakr.zzl, 0, zzp2, z);
                zzakr.zza(zzfu.zzb());
                zzfu zzfu2 = zzakr.zzn;
                zzfu.zzG(zzfu2.zzM(), 0, zzfu2.zze());
                zzakr.zzn.zzK(0);
                zzakr.zzo = false;
                return;
            }
            throw zzch.zza("Senc sample count " + zzp2 + " is different from fragment sample count" + i2, (Throwable) null);
        }
        throw zzch.zzc("Overriding TrackEncryptionBox parameters is unsupported.");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v0, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v17, resolved type: com.google.android.gms.internal.ads.zzakc} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v8, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v11, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v12, resolved type: java.lang.String} */
    /* JADX WARNING: type inference failed for: r1v24, types: [java.lang.Throwable] */
    /* JADX WARNING: Code restructure failed: missing block: B:117:0x0336, code lost:
        if (com.google.android.gms.internal.ads.zzgd.zzt(r32 + r2[0], androidx.compose.animation.core.AnimationKt.MillisToNanos, r5.zzd, java.math.RoundingMode.FLOOR) < r5.zze) goto L_0x034c;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:124:0x0364  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void zzj(long r50) throws com.google.android.gms.internal.ads.zzch {
        /*
            r49 = this;
            r0 = r49
        L_0x0002:
            java.util.ArrayDeque r1 = r0.zzn
            boolean r1 = r1.isEmpty()
            if (r1 != 0) goto L_0x074f
            java.util.ArrayDeque r1 = r0.zzn
            java.lang.Object r1 = r1.peek()
            com.google.android.gms.internal.ads.zzajm r1 = (com.google.android.gms.internal.ads.zzajm) r1
            long r1 = r1.zza
            int r1 = (r1 > r50 ? 1 : (r1 == r50 ? 0 : -1))
            if (r1 != 0) goto L_0x074f
            java.util.ArrayDeque r1 = r0.zzn
            java.lang.Object r1 = r1.pop()
            r2 = r1
            com.google.android.gms.internal.ads.zzajm r2 = (com.google.android.gms.internal.ads.zzajm) r2
            int r1 = r2.zzd
            r3 = 1836019574(0x6d6f6f76, float:4.631354E27)
            r6 = 12
            r7 = 8
            r8 = 0
            if (r1 != r3) goto L_0x0140
            java.util.List r1 = r2.zzb
            com.google.android.gms.internal.ads.zzae r1 = zzg(r1)
            r3 = 1836475768(0x6d766578, float:4.7659988E27)
            com.google.android.gms.internal.ads.zzajm r3 = r2.zza(r3)
            if (r3 == 0) goto L_0x013e
            android.util.SparseArray r12 = new android.util.SparseArray
            r12.<init>()
            java.util.List r8 = r3.zzb
            int r8 = r8.size()
            r4 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r9 = 0
        L_0x004d:
            if (r9 >= r8) goto L_0x00b9
            java.util.List r13 = r3.zzb
            java.lang.Object r13 = r13.get(r9)
            com.google.android.gms.internal.ads.zzajn r13 = (com.google.android.gms.internal.ads.zzajn) r13
            int r14 = r13.zzd
            r15 = 1953654136(0x74726578, float:7.6818474E31)
            if (r14 != r15) goto L_0x0096
            com.google.android.gms.internal.ads.zzfu r13 = r13.zza
            r13.zzK(r6)
            int r14 = r13.zzg()
            int r15 = r13.zzg()
            int r15 = r15 + -1
            int r10 = r13.zzg()
            int r6 = r13.zzg()
            int r13 = r13.zzg()
            java.lang.Integer r14 = java.lang.Integer.valueOf(r14)
            com.google.android.gms.internal.ads.zzajy r11 = new com.google.android.gms.internal.ads.zzajy
            r11.<init>(r15, r10, r6, r13)
            android.util.Pair r6 = android.util.Pair.create(r14, r11)
            java.lang.Object r10 = r6.first
            java.lang.Integer r10 = (java.lang.Integer) r10
            int r10 = r10.intValue()
            java.lang.Object r6 = r6.second
            com.google.android.gms.internal.ads.zzajy r6 = (com.google.android.gms.internal.ads.zzajy) r6
            r12.put(r10, r6)
            goto L_0x00b4
        L_0x0096:
            r6 = 1835362404(0x6d656864, float:4.4373917E27)
            if (r14 != r6) goto L_0x00b3
            com.google.android.gms.internal.ads.zzfu r4 = r13.zza
            r4.zzK(r7)
            int r5 = r4.zzg()
            int r5 = com.google.android.gms.internal.ads.zzajo.zze(r5)
            if (r5 != 0) goto L_0x00af
            long r4 = r4.zzu()
            goto L_0x00b3
        L_0x00af:
            long r4 = r4.zzv()
        L_0x00b3:
        L_0x00b4:
            int r9 = r9 + 1
            r6 = 12
            goto L_0x004d
        L_0x00b9:
            com.google.android.gms.internal.ads.zzaej r3 = new com.google.android.gms.internal.ads.zzaej
            r3.<init>()
            com.google.android.gms.internal.ads.zzaka r9 = new com.google.android.gms.internal.ads.zzaka
            r9.<init>(r0)
            r7 = 0
            r8 = 0
            r6 = r1
            java.util.List r1 = com.google.android.gms.internal.ads.zzajw.zzd(r2, r3, r4, r6, r7, r8, r9)
            int r2 = r1.size()
            android.util.SparseArray r3 = r0.zzf
            int r3 = r3.size()
            if (r3 != 0) goto L_0x010f
            r10 = 0
        L_0x00d7:
            if (r10 >= r2) goto L_0x0108
            java.lang.Object r3 = r1.get(r10)
            com.google.android.gms.internal.ads.zzaks r3 = (com.google.android.gms.internal.ads.zzaks) r3
            com.google.android.gms.internal.ads.zzakp r4 = r3.zza
            com.google.android.gms.internal.ads.zzakc r5 = new com.google.android.gms.internal.ads.zzakc
            com.google.android.gms.internal.ads.zzadx r6 = r0.zzF
            int r7 = r4.zzb
            com.google.android.gms.internal.ads.zzafa r6 = r6.zzw(r10, r7)
            int r7 = r4.zza
            com.google.android.gms.internal.ads.zzajy r7 = zzk(r12, r7)
            r5.<init>(r6, r3, r7)
            android.util.SparseArray r3 = r0.zzf
            int r6 = r4.zza
            r3.put(r6, r5)
            long r5 = r0.zzy
            long r3 = r4.zze
            long r3 = java.lang.Math.max(r5, r3)
            r0.zzy = r3
            int r10 = r10 + 1
            goto L_0x00d7
        L_0x0108:
            com.google.android.gms.internal.ads.zzadx r1 = r0.zzF
            r1.zzD()
            goto L_0x0002
        L_0x010f:
            android.util.SparseArray r3 = r0.zzf
            int r3 = r3.size()
            if (r3 != r2) goto L_0x0119
            r11 = 1
            goto L_0x011a
        L_0x0119:
            r11 = 0
        L_0x011a:
            com.google.android.gms.internal.ads.zzeq.zzf(r11)
            r10 = 0
        L_0x011e:
            if (r10 >= r2) goto L_0x0002
            java.lang.Object r3 = r1.get(r10)
            com.google.android.gms.internal.ads.zzaks r3 = (com.google.android.gms.internal.ads.zzaks) r3
            com.google.android.gms.internal.ads.zzakp r4 = r3.zza
            android.util.SparseArray r5 = r0.zzf
            int r6 = r4.zza
            java.lang.Object r5 = r5.get(r6)
            com.google.android.gms.internal.ads.zzakc r5 = (com.google.android.gms.internal.ads.zzakc) r5
            int r4 = r4.zza
            com.google.android.gms.internal.ads.zzajy r4 = zzk(r12, r4)
            r5.zzh(r3, r4)
            int r10 = r10 + 1
            goto L_0x011e
        L_0x013e:
            throw r8
        L_0x0140:
            r3 = 1836019558(0x6d6f6f66, float:4.6313494E27)
            if (r1 != r3) goto L_0x0731
            android.util.SparseArray r1 = r0.zzf
            byte[] r3 = r0.zzj
            java.util.List r6 = r2.zzc
            int r6 = r6.size()
            r9 = 0
        L_0x0150:
            if (r9 >= r6) goto L_0x0692
            java.util.List r10 = r2.zzc
            java.lang.Object r10 = r10.get(r9)
            com.google.android.gms.internal.ads.zzajm r10 = (com.google.android.gms.internal.ads.zzajm) r10
            int r11 = r10.zzd
            r12 = 1953653094(0x74726166, float:7.6813435E31)
            if (r11 != r12) goto L_0x0674
            r11 = 1952868452(0x74666864, float:7.301914E31)
            com.google.android.gms.internal.ads.zzajn r11 = r10.zzb(r11)
            if (r11 == 0) goto L_0x0672
            com.google.android.gms.internal.ads.zzfu r11 = r11.zza
            r11.zzK(r7)
            int r12 = r11.zzg()
            r13 = 16777215(0xffffff, float:2.3509886E-38)
            r12 = r12 & r13
            int r14 = r11.zzg()
            java.lang.Object r14 = r1.get(r14)
            com.google.android.gms.internal.ads.zzakc r14 = (com.google.android.gms.internal.ads.zzakc) r14
            if (r14 != 0) goto L_0x0185
            r14 = r8
            goto L_0x01ce
        L_0x0185:
            r15 = r12 & 1
            if (r15 == 0) goto L_0x0193
            long r4 = r11.zzv()
            com.google.android.gms.internal.ads.zzakr r15 = r14.zzb
            r15.zzb = r4
            r15.zzc = r4
        L_0x0193:
            com.google.android.gms.internal.ads.zzajy r4 = r14.zze
            r5 = r12 & 2
            if (r5 == 0) goto L_0x01a0
            int r5 = r11.zzg()
            int r5 = r5 + -1
            goto L_0x01a2
        L_0x01a0:
            int r5 = r4.zza
        L_0x01a2:
            r15 = r12 & 8
            if (r15 == 0) goto L_0x01ab
            int r15 = r11.zzg()
            goto L_0x01ad
        L_0x01ab:
            int r15 = r4.zzb
        L_0x01ad:
            r17 = r12 & 16
            if (r17 == 0) goto L_0x01b8
            int r17 = r11.zzg()
            r8 = r17
            goto L_0x01ba
        L_0x01b8:
            int r8 = r4.zzc
        L_0x01ba:
            r12 = r12 & 32
            if (r12 == 0) goto L_0x01c3
            int r4 = r11.zzg()
            goto L_0x01c5
        L_0x01c3:
            int r4 = r4.zzd
        L_0x01c5:
            com.google.android.gms.internal.ads.zzakr r11 = r14.zzb
            com.google.android.gms.internal.ads.zzajy r12 = new com.google.android.gms.internal.ads.zzajy
            r12.<init>(r5, r15, r8, r4)
            r11.zza = r12
        L_0x01ce:
            if (r14 != 0) goto L_0x01e1
            r19 = r1
            r26 = r2
            r23 = r6
            r5 = r7
            r28 = r9
            r0 = 1
            r1 = 0
            r6 = 0
            r11 = 12
            r7 = r3
            goto L_0x0683
        L_0x01e1:
            com.google.android.gms.internal.ads.zzakr r4 = r14.zzb
            long r11 = r4.zzp
            boolean r5 = r4.zzq
            r14.zzi()
            r8 = 1
            r14.zzl = true
            r8 = 1952867444(0x74666474, float:7.3014264E31)
            com.google.android.gms.internal.ads.zzajn r8 = r10.zzb(r8)
            if (r8 == 0) goto L_0x0217
            com.google.android.gms.internal.ads.zzfu r5 = r8.zza
            r5.zzK(r7)
            int r8 = r5.zzg()
            int r8 = com.google.android.gms.internal.ads.zzajo.zze(r8)
            r11 = 1
            if (r8 != r11) goto L_0x020c
            long r18 = r5.zzv()
            goto L_0x0210
        L_0x020c:
            long r18 = r5.zzu()
        L_0x0210:
            r7 = r18
            r4.zzp = r7
            r4.zzq = r11
            goto L_0x021b
        L_0x0217:
            r4.zzp = r11
            r4.zzq = r5
        L_0x021b:
            java.util.List r5 = r10.zzb
            int r7 = r5.size()
            r8 = 0
            r11 = 0
            r12 = 0
        L_0x0224:
            r15 = 1953658222(0x7472756e, float:7.683823E31)
            if (r8 >= r7) goto L_0x024f
            java.lang.Object r19 = r5.get(r8)
            r13 = r19
            com.google.android.gms.internal.ads.zzajn r13 = (com.google.android.gms.internal.ads.zzajn) r13
            r19 = r1
            int r1 = r13.zzd
            if (r1 != r15) goto L_0x0247
            com.google.android.gms.internal.ads.zzfu r1 = r13.zza
            r13 = 12
            r1.zzK(r13)
            int r1 = r1.zzp()
            if (r1 <= 0) goto L_0x0247
            int r12 = r12 + r1
            int r11 = r11 + 1
        L_0x0247:
            int r8 = r8 + 1
            r1 = r19
            r13 = 16777215(0xffffff, float:2.3509886E-38)
            goto L_0x0224
        L_0x024f:
            r19 = r1
            r1 = 0
            r14.zzh = r1
            r14.zzg = r1
            r14.zzf = r1
            com.google.android.gms.internal.ads.zzakr r1 = r14.zzb
            r1.zzd = r11
            r1.zze = r12
            int[] r8 = r1.zzg
            int r8 = r8.length
            if (r8 >= r11) goto L_0x026b
            long[] r8 = new long[r11]
            r1.zzf = r8
            int[] r8 = new int[r11]
            r1.zzg = r8
        L_0x026b:
            int[] r8 = r1.zzh
            int r8 = r8.length
            if (r8 >= r12) goto L_0x0288
            int r12 = r12 * 125
            int r12 = r12 / 100
            int[] r8 = new int[r12]
            r1.zzh = r8
            long[] r8 = new long[r12]
            r1.zzi = r8
            boolean[] r8 = new boolean[r12]
            r1.zzj = r8
            boolean[] r8 = new boolean[r12]
            r1.zzl = r8
            r1 = 0
            r8 = 0
            r11 = 0
            goto L_0x028b
        L_0x0288:
            r1 = 0
            r8 = 0
            r11 = 0
        L_0x028b:
            if (r1 >= r7) goto L_0x0439
            java.lang.Object r13 = r5.get(r1)
            com.google.android.gms.internal.ads.zzajn r13 = (com.google.android.gms.internal.ads.zzajn) r13
            int r12 = r13.zzd
            if (r12 != r15) goto L_0x0409
            int r12 = r8 + 1
            com.google.android.gms.internal.ads.zzfu r13 = r13.zza
            r15 = 8
            r13.zzK(r15)
            int r18 = r13.zzg()
            r20 = 16777215(0xffffff, float:2.3509886E-38)
            r15 = r18 & r20
            r18 = r5
            com.google.android.gms.internal.ads.zzaks r5 = r14.zzd
            com.google.android.gms.internal.ads.zzakp r5 = r5.zza
            r23 = r6
            com.google.android.gms.internal.ads.zzakr r6 = r14.zzb
            r24 = r7
            com.google.android.gms.internal.ads.zzajy r7 = r6.zza
            int r25 = com.google.android.gms.internal.ads.zzgd.zza
            r25 = r12
            int[] r12 = r6.zzg
            int r26 = r13.zzp()
            r12[r8] = r26
            long[] r12 = r6.zzf
            r26 = r2
            r27 = r3
            long r2 = r6.zzb
            r12[r8] = r2
            r28 = r15 & 1
            if (r28 == 0) goto L_0x02de
            int r0 = r13.zzg()
            r28 = r9
            r29 = r10
            long r9 = (long) r0
            long r2 = r2 + r9
            r12[r8] = r2
            goto L_0x02e2
        L_0x02de:
            r28 = r9
            r29 = r10
        L_0x02e2:
            r0 = r15 & 4
            if (r0 == 0) goto L_0x02e8
            r0 = 1
            goto L_0x02e9
        L_0x02e8:
            r0 = 0
        L_0x02e9:
            int r2 = r7.zzd
            if (r0 == 0) goto L_0x02f1
            int r2 = r13.zzg()
        L_0x02f1:
            r3 = r15 & 256(0x100, float:3.59E-43)
            r9 = r15 & 512(0x200, float:7.175E-43)
            r10 = r15 & 1024(0x400, float:1.435E-42)
            r12 = r15 & 2048(0x800, float:2.87E-42)
            long[] r15 = r5.zzh
            if (r15 == 0) goto L_0x0345
            r30 = r2
            int r2 = r15.length
            r31 = r4
            r4 = 1
            if (r2 != r4) goto L_0x0341
            long[] r2 = r5.zzi
            if (r2 != 0) goto L_0x030f
            r4 = r1
            r32 = r14
            r21 = 0
            goto L_0x034e
        L_0x030f:
            r4 = 0
            r32 = r15[r4]
            r15 = 0
            int r34 = (r32 > r15 ? 1 : (r32 == r15 ? 0 : -1))
            if (r34 != 0) goto L_0x031d
            r4 = r1
            r32 = r14
            goto L_0x0339
        L_0x031d:
            r34 = r2[r4]
            long r36 = r32 + r34
            r4 = r1
            long r1 = r5.zzd
            java.math.RoundingMode r42 = java.math.RoundingMode.FLOOR
            r38 = 1000000(0xf4240, double:4.940656E-318)
            r40 = r1
            long r1 = com.google.android.gms.internal.ads.zzgd.zzt(r36, r38, r40, r42)
            r32 = r14
            long r14 = r5.zze
            int r1 = (r1 > r14 ? 1 : (r1 == r14 ? 0 : -1))
            if (r1 >= 0) goto L_0x0339
            goto L_0x034c
        L_0x0339:
            long[] r1 = r5.zzi
            r2 = 0
            r14 = r1[r2]
            r21 = r14
            goto L_0x034e
        L_0x0341:
            r4 = r1
            r32 = r14
            goto L_0x034c
        L_0x0345:
            r30 = r2
            r31 = r4
            r32 = r14
            r4 = r1
        L_0x034c:
            r21 = 0
        L_0x034e:
            int[] r1 = r6.zzh
            long[] r2 = r6.zzi
            boolean[] r14 = r6.zzj
            int[] r15 = r6.zzg
            r8 = r15[r8]
            int r8 = r8 + r11
            r15 = r4
            long r4 = r5.zzc
            r40 = r14
            r41 = r15
            long r14 = r6.zzp
        L_0x0362:
            if (r11 >= r8) goto L_0x03fe
            if (r3 == 0) goto L_0x036f
            int r33 = r13.zzg()
            r42 = r3
            r3 = r33
            goto L_0x0373
        L_0x036f:
            r42 = r3
            int r3 = r7.zzb
        L_0x0373:
            zza(r3)
            if (r9 == 0) goto L_0x0381
            int r33 = r13.zzg()
            r43 = r8
            r8 = r33
            goto L_0x0385
        L_0x0381:
            r43 = r8
            int r8 = r7.zzc
        L_0x0385:
            zza(r8)
            if (r10 == 0) goto L_0x0393
            int r33 = r13.zzg()
            r44 = r0
            r0 = r33
            goto L_0x03a2
        L_0x0393:
            if (r11 != 0) goto L_0x039e
            if (r0 == 0) goto L_0x039d
            r44 = r0
            r0 = r30
            r11 = 0
            goto L_0x03a2
        L_0x039d:
            r11 = 0
        L_0x039e:
            r44 = r0
            int r0 = r7.zzd
        L_0x03a2:
            if (r12 == 0) goto L_0x03ad
            int r33 = r13.zzg()
            r45 = r7
            r7 = r33
            goto L_0x03b0
        L_0x03ad:
            r45 = r7
            r7 = 0
        L_0x03b0:
            r46 = r9
            r47 = r10
            long r9 = (long) r7
            long r9 = r9 + r14
            long r33 = r9 - r21
            java.math.RoundingMode r39 = java.math.RoundingMode.FLOOR
            r35 = 1000000(0xf4240, double:4.940656E-318)
            r37 = r4
            long r9 = com.google.android.gms.internal.ads.zzgd.zzt(r33, r35, r37, r39)
            r2[r11] = r9
            boolean r7 = r6.zzq
            if (r7 != 0) goto L_0x03d5
            r7 = r32
            r32 = r4
            com.google.android.gms.internal.ads.zzaks r4 = r7.zzd
            long r4 = r4.zzh
            long r9 = r9 + r4
            r2[r11] = r9
            goto L_0x03d9
        L_0x03d5:
            r7 = r32
            r32 = r4
        L_0x03d9:
            r1[r11] = r8
            r4 = 16
            int r0 = r0 >> r4
            r4 = 1
            r0 = r0 & r4
            r0 = r0 ^ r4
            if (r4 == r0) goto L_0x03e5
            r0 = 0
            goto L_0x03e6
        L_0x03e5:
            r0 = 1
        L_0x03e6:
            r40[r11] = r0
            long r3 = (long) r3
            long r14 = r14 + r3
            int r11 = r11 + 1
            r4 = r32
            r3 = r42
            r8 = r43
            r0 = r44
            r9 = r46
            r10 = r47
            r32 = r7
            r7 = r45
            goto L_0x0362
        L_0x03fe:
            r43 = r8
            r7 = r32
            r6.zzp = r14
            r8 = r25
            r11 = r43
            goto L_0x041f
        L_0x0409:
            r41 = r1
            r26 = r2
            r27 = r3
            r31 = r4
            r18 = r5
            r23 = r6
            r24 = r7
            r28 = r9
            r29 = r10
            r7 = r14
            r20 = 16777215(0xffffff, float:2.3509886E-38)
        L_0x041f:
            int r1 = r41 + 1
            r0 = r49
            r14 = r7
            r5 = r18
            r6 = r23
            r7 = r24
            r2 = r26
            r3 = r27
            r9 = r28
            r10 = r29
            r4 = r31
            r15 = 1953658222(0x7472756e, float:7.683823E31)
            goto L_0x028b
        L_0x0439:
            r26 = r2
            r27 = r3
            r31 = r4
            r23 = r6
            r28 = r9
            r29 = r10
            r7 = r14
            com.google.android.gms.internal.ads.zzaks r0 = r7.zzd
            com.google.android.gms.internal.ads.zzakp r0 = r0.zza
            r1 = r31
            com.google.android.gms.internal.ads.zzajy r2 = r1.zza
            if (r2 == 0) goto L_0x066f
            int r2 = r2.zza
            com.google.android.gms.internal.ads.zzakq r0 = r0.zza(r2)
            r2 = 1935763834(0x7361697a, float:1.785898E31)
            r10 = r29
            com.google.android.gms.internal.ads.zzajn r2 = r10.zzb(r2)
            if (r2 == 0) goto L_0x04d7
            if (r0 == 0) goto L_0x04d5
            com.google.android.gms.internal.ads.zzfu r2 = r2.zza
            r3 = 8
            r2.zzK(r3)
            int r4 = r2.zzg()
            r5 = 1
            r4 = r4 & r5
            if (r4 != r5) goto L_0x0475
            r2.zzL(r3)
        L_0x0475:
            int r3 = r2.zzm()
            int r4 = r2.zzp()
            int r5 = r1.zze
            if (r4 > r5) goto L_0x04b6
            int r5 = r0.zzd
            if (r3 != 0) goto L_0x049c
            boolean[] r3 = r1.zzl
            r6 = 0
            r7 = 0
        L_0x0489:
            if (r6 >= r4) goto L_0x049a
            int r8 = r2.zzm()
            int r7 = r7 + r8
            if (r8 <= r5) goto L_0x0494
            r8 = 1
            goto L_0x0495
        L_0x0494:
            r8 = 0
        L_0x0495:
            r3[r6] = r8
            int r6 = r6 + 1
            goto L_0x0489
        L_0x049a:
            r5 = 0
            goto L_0x04a9
        L_0x049c:
            if (r3 <= r5) goto L_0x04a0
            r2 = 1
            goto L_0x04a1
        L_0x04a0:
            r2 = 0
        L_0x04a1:
            int r7 = r3 * r4
            boolean[] r3 = r1.zzl
            r5 = 0
            java.util.Arrays.fill(r3, r5, r4, r2)
        L_0x04a9:
            boolean[] r2 = r1.zzl
            int r3 = r1.zze
            java.util.Arrays.fill(r2, r4, r3, r5)
            if (r7 <= 0) goto L_0x04d7
            r1.zza(r7)
            goto L_0x04d7
        L_0x04b6:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Saiz sample count "
            r0.append(r1)
            r0.append(r4)
            java.lang.String r1 = " is greater than fragment sample count"
            r0.append(r1)
            r0.append(r5)
            java.lang.String r0 = r0.toString()
            r1 = 0
            com.google.android.gms.internal.ads.zzch r0 = com.google.android.gms.internal.ads.zzch.zza(r0, r1)
            throw r0
        L_0x04d5:
            r1 = 0
            throw r1
        L_0x04d7:
            r2 = 1935763823(0x7361696f, float:1.7858967E31)
            com.google.android.gms.internal.ads.zzajn r2 = r10.zzb(r2)
            if (r2 == 0) goto L_0x0526
            com.google.android.gms.internal.ads.zzfu r2 = r2.zza
            r3 = 8
            r2.zzK(r3)
            int r4 = r2.zzg()
            r5 = r4 & 1
            r6 = 1
            if (r5 != r6) goto L_0x04f4
            r2.zzL(r3)
        L_0x04f4:
            int r3 = r2.zzp()
            if (r3 != r6) goto L_0x050f
            int r3 = com.google.android.gms.internal.ads.zzajo.zze(r4)
            long r4 = r1.zzc
            if (r3 != 0) goto L_0x0507
            long r2 = r2.zzu()
            goto L_0x050b
        L_0x0507:
            long r2 = r2.zzv()
        L_0x050b:
            long r4 = r4 + r2
            r1.zzc = r4
            goto L_0x0526
        L_0x050f:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Unexpected saio entry count: "
            r0.append(r1)
            r0.append(r3)
            java.lang.String r0 = r0.toString()
            r1 = 0
            com.google.android.gms.internal.ads.zzch r0 = com.google.android.gms.internal.ads.zzch.zza(r0, r1)
            throw r0
        L_0x0526:
            r2 = 1936027235(0x73656e63, float:1.8177412E31)
            com.google.android.gms.internal.ads.zzajn r2 = r10.zzb(r2)
            if (r2 == 0) goto L_0x0536
            com.google.android.gms.internal.ads.zzfu r2 = r2.zza
            r3 = 0
            zzi(r2, r3, r1)
        L_0x0536:
            if (r0 == 0) goto L_0x053c
            java.lang.String r0 = r0.zzb
            r4 = r0
            goto L_0x053d
        L_0x053c:
            r4 = 0
        L_0x053d:
            r0 = 0
            r2 = 0
            r3 = 0
        L_0x0540:
            java.util.List r5 = r10.zzb
            int r5 = r5.size()
            if (r3 >= r5) goto L_0x0582
            java.util.List r5 = r10.zzb
            java.lang.Object r5 = r5.get(r3)
            com.google.android.gms.internal.ads.zzajn r5 = (com.google.android.gms.internal.ads.zzajn) r5
            com.google.android.gms.internal.ads.zzfu r6 = r5.zza
            int r5 = r5.zzd
            r7 = 1935828848(0x73626770, float:1.7937577E31)
            r8 = 1936025959(0x73656967, float:1.817587E31)
            if (r5 != r7) goto L_0x056b
            r5 = 12
            r6.zzK(r5)
            int r5 = r6.zzg()
            if (r5 != r8) goto L_0x0568
            r0 = r6
        L_0x0568:
            r11 = 12
            goto L_0x057f
        L_0x056b:
            r7 = 1936158820(0x73677064, float:1.8336489E31)
            if (r5 != r7) goto L_0x057d
            r11 = 12
            r6.zzK(r11)
            int r5 = r6.zzg()
            if (r5 != r8) goto L_0x057f
            r2 = r6
            goto L_0x057f
        L_0x057d:
            r11 = 12
        L_0x057f:
            int r3 = r3 + 1
            goto L_0x0540
        L_0x0582:
            r11 = 12
            if (r0 == 0) goto L_0x0628
            if (r2 != 0) goto L_0x058b
            r0 = 1
            goto L_0x0629
        L_0x058b:
            r3 = 8
            r0.zzK(r3)
            int r3 = r0.zzg()
            int r3 = com.google.android.gms.internal.ads.zzajo.zze(r3)
            r5 = 4
            r0.zzL(r5)
            r6 = 1
            if (r3 != r6) goto L_0x05a3
            r0.zzL(r5)
        L_0x05a3:
            int r0 = r0.zzg()
            if (r0 != r6) goto L_0x0621
            r0 = 8
            r2.zzK(r0)
            int r0 = r2.zzg()
            int r0 = com.google.android.gms.internal.ads.zzajo.zze(r0)
            r2.zzL(r5)
            if (r0 != r6) goto L_0x05cf
            long r6 = r2.zzu()
            r8 = 0
            int r0 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r0 == 0) goto L_0x05c7
            goto L_0x05d5
        L_0x05c7:
            java.lang.String r0 = "Variable length description in sgpd found (unsupported)"
            com.google.android.gms.internal.ads.zzch r0 = com.google.android.gms.internal.ads.zzch.zzc(r0)
            throw r0
        L_0x05cf:
            r3 = 2
            if (r0 < r3) goto L_0x05d5
            r2.zzL(r5)
        L_0x05d5:
            long r6 = r2.zzu()
            r8 = 1
            int r0 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r0 != 0) goto L_0x061a
            r0 = 1
            r2.zzL(r0)
            int r3 = r2.zzm()
            r6 = r3 & 240(0xf0, float:3.36E-43)
            int r7 = r6 >> 4
            r8 = r3 & 15
            int r3 = r2.zzm()
            if (r3 != r0) goto L_0x0629
            int r5 = r2.zzm()
            r0 = 16
            byte[] r6 = new byte[r0]
            r3 = 0
            r2.zzG(r6, r3, r0)
            if (r5 != 0) goto L_0x060c
            int r0 = r2.zzm()
            byte[] r9 = new byte[r0]
            r2.zzG(r9, r3, r0)
            goto L_0x060d
        L_0x060c:
            r9 = 0
        L_0x060d:
            r0 = 1
            r1.zzk = r0
            com.google.android.gms.internal.ads.zzakq r12 = new com.google.android.gms.internal.ads.zzakq
            r3 = 1
            r2 = r12
            r2.<init>(r3, r4, r5, r6, r7, r8, r9)
            r1.zzm = r12
            goto L_0x0629
        L_0x061a:
            java.lang.String r0 = "Entry count in sgpd != 1 (unsupported)."
            com.google.android.gms.internal.ads.zzch r0 = com.google.android.gms.internal.ads.zzch.zzc(r0)
            throw r0
        L_0x0621:
            java.lang.String r0 = "Entry count in sbgp != 1 (unsupported)."
            com.google.android.gms.internal.ads.zzch r0 = com.google.android.gms.internal.ads.zzch.zzc(r0)
            throw r0
        L_0x0628:
            r0 = 1
        L_0x0629:
            java.util.List r2 = r10.zzb
            int r2 = r2.size()
            r3 = 0
        L_0x0630:
            if (r3 >= r2) goto L_0x0668
            java.util.List r4 = r10.zzb
            java.lang.Object r4 = r4.get(r3)
            com.google.android.gms.internal.ads.zzajn r4 = (com.google.android.gms.internal.ads.zzajn) r4
            int r5 = r4.zzd
            r6 = 1970628964(0x75756964, float:3.1109627E32)
            if (r5 != r6) goto L_0x065c
            com.google.android.gms.internal.ads.zzfu r4 = r4.zza
            r5 = 8
            r4.zzK(r5)
            r7 = r27
            r6 = 0
            r8 = 16
            r4.zzG(r7, r6, r8)
            byte[] r9 = zzb
            boolean r9 = java.util.Arrays.equals(r7, r9)
            if (r9 == 0) goto L_0x0663
            zzi(r4, r8, r1)
            goto L_0x0663
        L_0x065c:
            r7 = r27
            r5 = 8
            r6 = 0
            r8 = 16
        L_0x0663:
            int r3 = r3 + 1
            r27 = r7
            goto L_0x0630
        L_0x0668:
            r7 = r27
            r5 = 8
            r6 = 0
            r1 = 0
            goto L_0x0683
        L_0x066f:
            r1 = 0
            throw r1
        L_0x0672:
            r1 = r8
            throw r1
        L_0x0674:
            r19 = r1
            r26 = r2
            r23 = r6
            r5 = r7
            r1 = r8
            r28 = r9
            r0 = 1
            r6 = 0
            r11 = 12
            r7 = r3
        L_0x0683:
            int r9 = r28 + 1
            r0 = r49
            r8 = r1
            r3 = r7
            r1 = r19
            r6 = r23
            r2 = r26
            r7 = r5
            goto L_0x0150
        L_0x0692:
            r26 = r2
            r1 = r8
            r6 = 0
            r0 = r26
            java.util.List r0 = r0.zzb
            com.google.android.gms.internal.ads.zzae r0 = zzg(r0)
            if (r0 == 0) goto L_0x06e6
            r2 = r49
            android.util.SparseArray r3 = r2.zzf
            int r3 = r3.size()
            r4 = r6
        L_0x06a9:
            if (r4 >= r3) goto L_0x06e8
            android.util.SparseArray r5 = r2.zzf
            java.lang.Object r5 = r5.valueAt(r4)
            com.google.android.gms.internal.ads.zzakc r5 = (com.google.android.gms.internal.ads.zzakc) r5
            com.google.android.gms.internal.ads.zzaks r7 = r5.zzd
            com.google.android.gms.internal.ads.zzakp r7 = r7.zza
            com.google.android.gms.internal.ads.zzakr r8 = r5.zzb
            com.google.android.gms.internal.ads.zzajy r8 = r8.zza
            int r9 = com.google.android.gms.internal.ads.zzgd.zza
            int r8 = r8.zza
            com.google.android.gms.internal.ads.zzakq r7 = r7.zza(r8)
            if (r7 == 0) goto L_0x06c8
            java.lang.String r7 = r7.zzb
            goto L_0x06c9
        L_0x06c8:
            r7 = r1
        L_0x06c9:
            com.google.android.gms.internal.ads.zzae r7 = r0.zzb(r7)
            com.google.android.gms.internal.ads.zzaks r8 = r5.zzd
            com.google.android.gms.internal.ads.zzakp r8 = r8.zza
            com.google.android.gms.internal.ads.zzan r8 = r8.zzf
            com.google.android.gms.internal.ads.zzal r8 = r8.zzb()
            r8.zzE(r7)
            com.google.android.gms.internal.ads.zzan r7 = r8.zzad()
            com.google.android.gms.internal.ads.zzafa r5 = r5.zza
            r5.zzl(r7)
            int r4 = r4 + 1
            goto L_0x06a9
        L_0x06e6:
            r2 = r49
        L_0x06e8:
            long r0 = r2.zzx
            r3 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r0 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r0 == 0) goto L_0x072e
            android.util.SparseArray r0 = r2.zzf
            int r0 = r0.size()
            r10 = r6
        L_0x06fa:
            if (r10 >= r0) goto L_0x0724
            android.util.SparseArray r1 = r2.zzf
            java.lang.Object r1 = r1.valueAt(r10)
            com.google.android.gms.internal.ads.zzakc r1 = (com.google.android.gms.internal.ads.zzakc) r1
            long r3 = r2.zzx
            int r5 = r1.zzf
        L_0x0708:
            com.google.android.gms.internal.ads.zzakr r6 = r1.zzb
            int r7 = r6.zze
            if (r5 >= r7) goto L_0x0721
            long[] r7 = r6.zzi
            r8 = r7[r5]
            int r7 = (r8 > r3 ? 1 : (r8 == r3 ? 0 : -1))
            if (r7 > 0) goto L_0x0721
            boolean[] r6 = r6.zzj
            boolean r6 = r6[r5]
            if (r6 == 0) goto L_0x071e
            r1.zzi = r5
        L_0x071e:
            int r5 = r5 + 1
            goto L_0x0708
        L_0x0721:
            int r10 = r10 + 1
            goto L_0x06fa
        L_0x0724:
            r0 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r2.zzx = r0
            r0 = r2
            goto L_0x0002
        L_0x072e:
            r0 = r2
            goto L_0x0002
        L_0x0731:
            r48 = r2
            r2 = r0
            r0 = r48
            java.util.ArrayDeque r1 = r2.zzn
            boolean r1 = r1.isEmpty()
            if (r1 != 0) goto L_0x074c
            java.util.ArrayDeque r1 = r2.zzn
            java.lang.Object r1 = r1.peek()
            com.google.android.gms.internal.ads.zzajm r1 = (com.google.android.gms.internal.ads.zzajm) r1
            r1.zzc(r0)
            r0 = r2
            goto L_0x0002
        L_0x074c:
            r0 = r2
            goto L_0x0002
        L_0x074f:
            r2 = r0
            r49.zzh()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzakd.zzj(long):void");
    }

    private static final zzajy zzk(SparseArray sparseArray, int i) {
        if (sparseArray.size() == 1) {
            return (zzajy) sparseArray.valueAt(0);
        }
        zzajy zzajy = (zzajy) sparseArray.get(i);
        if (zzajy != null) {
            return zzajy;
        }
        throw null;
    }

    public final int zzb(zzadv zzadv, zzaeq zzaeq) throws IOException {
        long j;
        long j2;
        String str;
        String str2;
        long j3;
        long j4;
        long j5;
        long j6;
        zzakc zzakc;
        zzaez zzaez;
        int i;
        boolean z;
        int i2;
        int i3;
        zzadv zzadv2 = zzadv;
        while (true) {
            long j7 = Long.MAX_VALUE;
            int i4 = 4;
            int i5 = 0;
            switch (this.zzq) {
                case 0:
                    if (this.zzt == 0) {
                        if (!zzadv2.zzn(this.zzm.zzM(), 0, 8, true)) {
                            return -1;
                        }
                        this.zzt = 8;
                        this.zzm.zzK(0);
                        this.zzs = this.zzm.zzu();
                        this.zzr = this.zzm.zzg();
                    }
                    long j8 = this.zzs;
                    if (j8 == 1) {
                        ((zzadi) zzadv2).zzn(this.zzm.zzM(), 8, 8, false);
                        this.zzt += 8;
                        this.zzs = this.zzm.zzv();
                    } else if (j8 == 0) {
                        long zzd2 = zzadv.zzd();
                        if (zzd2 == -1) {
                            zzd2 = !this.zzn.isEmpty() ? ((zzajm) this.zzn.peek()).zza : -1;
                        }
                        if (zzd2 != -1) {
                            this.zzs = (zzd2 - zzadv.zzf()) + ((long) this.zzt);
                        }
                    }
                    long j9 = this.zzs;
                    long j10 = (long) this.zzt;
                    if (j9 >= j10) {
                        long zzf2 = zzadv.zzf() - j10;
                        int i6 = this.zzr;
                        if ((i6 == 1836019558 || i6 == 1835295092) && !this.zzI) {
                            this.zzF.zzO(new zzaes(this.zzy, zzf2));
                            this.zzI = true;
                        }
                        if (this.zzr == 1836019558) {
                            int size = this.zzf.size();
                            for (int i7 = 0; i7 < size; i7++) {
                                zzakr zzakr = ((zzakc) this.zzf.valueAt(i7)).zzb;
                                zzakr.zzc = zzf2;
                                zzakr.zzb = zzf2;
                            }
                        }
                        int i8 = this.zzr;
                        if (i8 == 1835295092) {
                            this.zzA = null;
                            this.zzv = zzf2 + this.zzs;
                            this.zzq = 2;
                            break;
                        } else if (i8 == 1836019574 || i8 == 1953653099 || i8 == 1835297121 || i8 == 1835626086 || i8 == 1937007212 || i8 == 1836019558 || i8 == 1953653094 || i8 == 1836475768 || i8 == 1701082227) {
                            long zzf3 = (zzadv.zzf() + this.zzs) - 8;
                            this.zzn.push(new zzajm(i8, zzf3));
                            if (this.zzs != ((long) this.zzt)) {
                                zzh();
                                break;
                            } else {
                                zzj(zzf3);
                                break;
                            }
                        } else if (i8 == 1751411826 || i8 == 1835296868 || i8 == 1836476516 || i8 == 1936286840 || i8 == 1937011556 || i8 == 1937011827 || i8 == 1668576371 || i8 == 1937011555 || i8 == 1937011578 || i8 == 1937013298 || i8 == 1937007471 || i8 == 1668232756 || i8 == 1937011571 || i8 == 1952867444 || i8 == 1952868452 || i8 == 1953196132 || i8 == 1953654136 || i8 == 1953658222 || i8 == 1886614376 || i8 == 1935763834 || i8 == 1935763823 || i8 == 1936027235 || i8 == 1970628964 || i8 == 1935828848 || i8 == 1936158820 || i8 == 1701606260 || i8 == 1835362404 || i8 == 1701671783) {
                            if (this.zzt != 8) {
                                throw zzch.zzc("Leaf atom defines extended atom size (unsupported).");
                            } else if (this.zzs <= 2147483647L) {
                                zzfu zzfu = new zzfu((int) this.zzs);
                                System.arraycopy(this.zzm.zzM(), 0, zzfu.zzM(), 0, 8);
                                this.zzu = zzfu;
                                this.zzq = 1;
                                break;
                            } else {
                                throw zzch.zzc("Leaf atom with length > 2147483647 (unsupported).");
                            }
                        } else if (this.zzs <= 2147483647L) {
                            this.zzu = null;
                            this.zzq = 1;
                            break;
                        } else {
                            throw zzch.zzc("Skipping atom with length > 2147483647 (unsupported).");
                        }
                    } else {
                        throw zzch.zzc("Atom size less than header length (unsupported).");
                    }
                case 1:
                    int i9 = ((int) this.zzs) - this.zzt;
                    zzfu zzfu2 = this.zzu;
                    if (zzfu2 != null) {
                        ((zzadi) zzadv2).zzn(zzfu2.zzM(), 8, i9, false);
                        zzajn zzajn = new zzajn(this.zzr, zzfu2);
                        long zzf4 = zzadv.zzf();
                        if (!this.zzn.isEmpty()) {
                            ((zzajm) this.zzn.peek()).zzd(zzajn);
                        } else {
                            int i10 = zzajn.zzd;
                            if (i10 == 1936286840) {
                                zzfu zzfu3 = zzajn.zza;
                                zzfu3.zzK(8);
                                int zze2 = zzajo.zze(zzfu3.zzg());
                                zzfu3.zzL(4);
                                long zzu2 = zzfu3.zzu();
                                if (zze2 == 0) {
                                    long zzu3 = zzfu3.zzu();
                                    j6 = zzf4 + zzfu3.zzu();
                                    j5 = zzu3;
                                } else {
                                    long zzv2 = zzfu3.zzv();
                                    j6 = zzf4 + zzfu3.zzv();
                                    j5 = zzv2;
                                }
                                long zzt2 = zzgd.zzt(j5, AnimationKt.MillisToNanos, zzu2, RoundingMode.FLOOR);
                                zzfu3.zzL(2);
                                int zzq2 = zzfu3.zzq();
                                int[] iArr = new int[zzq2];
                                long[] jArr = new long[zzq2];
                                long[] jArr2 = new long[zzq2];
                                long[] jArr3 = new long[zzq2];
                                long j11 = zzt2;
                                while (i5 < zzq2) {
                                    int zzg2 = zzfu3.zzg();
                                    if ((zzg2 & Integer.MIN_VALUE) == 0) {
                                        long zzu4 = zzfu3.zzu();
                                        iArr[i5] = zzg2 & Integer.MAX_VALUE;
                                        jArr[i5] = j6;
                                        jArr3[i5] = j11;
                                        j5 += zzu4;
                                        long[] jArr4 = jArr3;
                                        j11 = zzgd.zzt(j5, AnimationKt.MillisToNanos, zzu2, RoundingMode.FLOOR);
                                        jArr2[i5] = j11 - jArr4[i5];
                                        zzfu3.zzL(i4);
                                        j6 += (long) iArr[i5];
                                        i5++;
                                        jArr3 = jArr4;
                                        jArr2 = jArr2;
                                        i4 = 4;
                                    } else {
                                        throw zzch.zza("Unhandled indirect reference", (Throwable) null);
                                    }
                                }
                                Pair create = Pair.create(Long.valueOf(zzt2), new zzadg(iArr, jArr, jArr2, jArr3));
                                this.zzz = ((Long) create.first).longValue();
                                this.zzF.zzO((zzaet) create.second);
                                this.zzI = true;
                            } else if (i10 == 1701671783) {
                                zzfu zzfu4 = zzajn.zza;
                                if (this.zzG.length != 0) {
                                    zzfu4.zzK(8);
                                    int zze3 = zzajo.zze(zzfu4.zzg());
                                    switch (zze3) {
                                        case 0:
                                            String zzx2 = zzfu4.zzx(0);
                                            if (zzx2 != null) {
                                                String zzx3 = zzfu4.zzx(0);
                                                if (zzx3 != null) {
                                                    long zzu5 = zzfu4.zzu();
                                                    j3 = zzgd.zzt(zzfu4.zzu(), AnimationKt.MillisToNanos, zzu5, RoundingMode.FLOOR);
                                                    long j12 = this.zzz;
                                                    long j13 = j12 != -9223372036854775807L ? j12 + j3 : -9223372036854775807L;
                                                    j2 = zzgd.zzt(zzfu4.zzu(), 1000, zzu5, RoundingMode.FLOOR);
                                                    j4 = j13;
                                                    str2 = zzx2;
                                                    str = zzx3;
                                                    j = zzfu4.zzu();
                                                    break;
                                                } else {
                                                    throw null;
                                                }
                                            } else {
                                                throw null;
                                            }
                                        case 1:
                                            long zzu6 = zzfu4.zzu();
                                            long zzt3 = zzgd.zzt(zzfu4.zzv(), AnimationKt.MillisToNanos, zzu6, RoundingMode.FLOOR);
                                            long zzt4 = zzgd.zzt(zzfu4.zzu(), 1000, zzu6, RoundingMode.FLOOR);
                                            long zzu7 = zzfu4.zzu();
                                            String zzx4 = zzfu4.zzx(0);
                                            if (zzx4 != null) {
                                                String zzx5 = zzfu4.zzx(0);
                                                if (zzx5 != null) {
                                                    j2 = zzt4;
                                                    j4 = zzt3;
                                                    j = zzu7;
                                                    str2 = zzx4;
                                                    str = zzx5;
                                                    j3 = -9223372036854775807L;
                                                    break;
                                                } else {
                                                    throw null;
                                                }
                                            } else {
                                                throw null;
                                            }
                                        default:
                                            zzfk.zzf("FragmentedMp4Extractor", "Skipping unsupported emsg version: " + zze3);
                                            break;
                                    }
                                    byte[] bArr = new byte[zzfu4.zzb()];
                                    zzfu4.zzG(bArr, 0, zzfu4.zzb());
                                    zzfu zzfu5 = new zzfu(this.zzl.zza(new zzagt(str2, str, j2, j, bArr)));
                                    int zzb2 = zzfu5.zzb();
                                    for (zzafa zzq3 : this.zzG) {
                                        zzfu5.zzK(0);
                                        zzq3.zzq(zzfu5, zzb2);
                                    }
                                    if (j4 == -9223372036854775807L) {
                                        this.zzo.addLast(new zzakb(j3, true, zzb2));
                                        this.zzw += zzb2;
                                    } else if (!this.zzo.isEmpty()) {
                                        this.zzo.addLast(new zzakb(j4, false, zzb2));
                                        this.zzw += zzb2;
                                    } else {
                                        zzafa[] zzafaArr = this.zzG;
                                        int length = zzafaArr.length;
                                        while (i5 < length) {
                                            zzafaArr[i5].zzs(j4, 1, zzb2, 0, (zzaez) null);
                                            i5++;
                                        }
                                    }
                                }
                            }
                        }
                    } else {
                        ((zzadi) zzadv2).zzo(i9, false);
                    }
                    zzj(zzadv.zzf());
                    break;
                case 2:
                    int size2 = this.zzf.size();
                    zzakc zzakc2 = null;
                    for (int i11 = 0; i11 < size2; i11++) {
                        zzakr zzakr2 = ((zzakc) this.zzf.valueAt(i11)).zzb;
                        if (zzakr2.zzo) {
                            long j14 = zzakr2.zzc;
                            if (j14 < j7) {
                                zzakc2 = (zzakc) this.zzf.valueAt(i11);
                                j7 = j14;
                            }
                        }
                    }
                    if (zzakc2 == null) {
                        this.zzq = 3;
                        break;
                    } else {
                        int zzf5 = (int) (j7 - zzadv.zzf());
                        if (zzf5 >= 0) {
                            zzadi zzadi = (zzadi) zzadv2;
                            zzadi.zzo(zzf5, false);
                            zzakr zzakr3 = zzakc2.zzb;
                            zzfu zzfu6 = zzakr3.zzn;
                            zzadi.zzn(zzfu6.zzM(), 0, zzfu6.zze(), false);
                            zzakr3.zzn.zzK(0);
                            zzakr3.zzo = false;
                            break;
                        } else {
                            throw zzch.zza("Offset to encryption data was negative.", (Throwable) null);
                        }
                    }
                default:
                    zzakc = this.zzA;
                    if (zzakc != null) {
                        break;
                    } else {
                        SparseArray sparseArray = this.zzf;
                        int size3 = sparseArray.size();
                        zzakc zzakc3 = null;
                        for (int i12 = 0; i12 < size3; i12++) {
                            zzakc zzakc4 = (zzakc) sparseArray.valueAt(i12);
                            if ((zzakc4.zzl || zzakc4.zzf != zzakc4.zzd.zzb) && (!zzakc4.zzl || zzakc4.zzh != zzakc4.zzb.zzd)) {
                                long zzd3 = zzakc4.zzd();
                                if (zzd3 < j7) {
                                    zzakc3 = zzakc4;
                                    j7 = zzd3;
                                }
                            }
                        }
                        if (zzakc3 != null) {
                            int zzd4 = (int) (zzakc3.zzd() - zzadv.zzf());
                            if (zzd4 < 0) {
                                zzfk.zzf("FragmentedMp4Extractor", "Ignoring negative offset to sample data.");
                                zzd4 = 0;
                            }
                            ((zzadi) zzadv2).zzo(zzd4, false);
                            this.zzA = zzakc3;
                            zzakc = zzakc3;
                            break;
                        } else {
                            int zzf6 = (int) (this.zzv - zzadv.zzf());
                            if (zzf6 >= 0) {
                                ((zzadi) zzadv2).zzo(zzf6, false);
                                zzh();
                                break;
                            } else {
                                throw zzch.zza("Offset to end of mdat was negative.", (Throwable) null);
                            }
                        }
                    }
            }
        }
        byte b = 6;
        if (this.zzq == 3) {
            int zzb3 = zzakc.zzb();
            this.zzB = zzb3;
            if (zzakc.zzf < zzakc.zzi) {
                ((zzadi) zzadv2).zzo(zzb3, false);
                zzakq zzf7 = zzakc.zzf();
                if (zzf7 != null) {
                    zzfu zzfu7 = zzakc.zzb.zzn;
                    int i13 = zzf7.zzd;
                    if (i13 != 0) {
                        zzfu7.zzL(i13);
                    }
                    if (zzakc.zzb.zzb(zzakc.zzf)) {
                        zzfu7.zzL(zzfu7.zzq() * 6);
                    }
                }
                if (!zzakc.zzk()) {
                    this.zzA = null;
                }
                this.zzq = 3;
                return 0;
            }
            if (zzakc.zzd.zza.zzg == 1) {
                this.zzB = zzb3 - 8;
                ((zzadi) zzadv2).zzo(8, false);
            }
            if ("audio/ac4".equals(zzakc.zzd.zza.zzf.zzn)) {
                this.zzC = zzakc.zzc(this.zzB, 7);
                zzacw.zzb(this.zzB, this.zzk);
                zzakc.zza.zzq(this.zzk, 7);
                i3 = this.zzC + 7;
                this.zzC = i3;
                i2 = 0;
            } else {
                i2 = 0;
                i3 = zzakc.zzc(this.zzB, 0);
                this.zzC = i3;
            }
            this.zzB += i3;
            this.zzq = 4;
            this.zzD = i2;
        }
        zzakp zzakp = zzakc.zzd.zza;
        zzafa zzafa = zzakc.zza;
        long zze4 = zzakc.zze();
        int i14 = zzakp.zzj;
        if (i14 == 0) {
            while (true) {
                int i15 = this.zzC;
                int i16 = this.zzB;
                if (i15 < i16) {
                    this.zzC += zzafa.zzf(zzadv2, i16 - i15, false);
                }
            }
        } else {
            byte[] zzM = this.zzh.zzM();
            zzM[0] = 0;
            zzM[1] = 0;
            zzM[2] = 0;
            int i17 = i14 + 1;
            int i18 = 4 - i14;
            while (this.zzC < this.zzB) {
                int i19 = this.zzD;
                if (i19 == 0) {
                    ((zzadi) zzadv2).zzn(zzM, i18, i17, false);
                    this.zzh.zzK(0);
                    int zzg3 = this.zzh.zzg();
                    if (zzg3 > 0) {
                        this.zzD = zzg3 - 1;
                        this.zzg.zzK(0);
                        zzafa.zzq(this.zzg, 4);
                        zzafa.zzq(this.zzh, 1);
                        if (this.zzH.length > 0) {
                            String str3 = zzakp.zzf.zzn;
                            byte b2 = zzM[4];
                            byte[] bArr2 = zzgr.zza;
                            if ("video/avc".equals(str3) && (b2 & Ascii.US) == b) {
                                z = true;
                                this.zzE = z;
                                this.zzC += 5;
                                this.zzB += i18;
                            } else if ("video/hevc".equals(str3)) {
                                if (((b2 & 126) >> 1) == 39) {
                                    z = true;
                                    this.zzE = z;
                                    this.zzC += 5;
                                    this.zzB += i18;
                                }
                                z = false;
                                this.zzE = z;
                                this.zzC += 5;
                                this.zzB += i18;
                            }
                        }
                        z = false;
                        this.zzE = z;
                        this.zzC += 5;
                        this.zzB += i18;
                    } else {
                        throw zzch.zza("Invalid NAL length", (Throwable) null);
                    }
                } else {
                    if (this.zzE) {
                        this.zzi.zzH(i19);
                        ((zzadi) zzadv2).zzn(this.zzi.zzM(), 0, this.zzD, false);
                        zzafa.zzq(this.zzi, this.zzD);
                        i = this.zzD;
                        zzfu zzfu8 = this.zzi;
                        int zzb4 = zzgr.zzb(zzfu8.zzM(), zzfu8.zze());
                        this.zzi.zzK("video/hevc".equals(zzakp.zzf.zzn) ? 1 : 0);
                        this.zzi.zzJ(zzb4);
                        zzadf.zza(zze4, this.zzi, this.zzH);
                    } else {
                        i = zzafa.zzf(zzadv2, i19, false);
                    }
                    this.zzC += i;
                    this.zzD -= i;
                    b = 6;
                }
            }
        }
        int zza2 = zzakc.zza();
        zzakq zzf8 = zzakc.zzf();
        if (zzf8 != null) {
            zzaez = zzf8.zzc;
        } else {
            zzaez = null;
        }
        zzafa.zzs(zze4, zza2, this.zzB, 0, zzaez);
        while (!this.zzo.isEmpty()) {
            zzakb zzakb = (zzakb) this.zzo.removeFirst();
            this.zzw -= zzakb.zzc;
            long j15 = zzakb.zza;
            if (zzakb.zzb) {
                j15 += zze4;
            }
            for (zzafa zzs2 : this.zzG) {
                zzs2.zzs(j15, 1, zzakb.zzc, this.zzw, (zzaez) null);
            }
        }
        if (!zzakc.zzk()) {
            this.zzA = null;
        }
        this.zzq = 3;
        return 0;
    }

    public final /* synthetic */ List zzc() {
        return this.zzp;
    }

    public final void zzd(zzadx zzadx) {
        this.zzF = zzadx;
        zzh();
        this.zzG = new zzafa[2];
        int i = 0;
        this.zzG = (zzafa[]) zzgd.zzP(this.zzG, 0);
        for (zzafa zzl2 : this.zzG) {
            zzl2.zzl(zzc);
        }
        this.zzH = new zzafa[this.zze.size()];
        int i2 = 100;
        while (i < this.zzH.length) {
            int i3 = i2 + 1;
            zzafa zzw2 = this.zzF.zzw(i2, 3);
            zzw2.zzl((zzan) this.zze.get(i));
            this.zzH[i] = zzw2;
            i++;
            i2 = i3;
        }
    }

    public final void zze(long j, long j2) {
        int size = this.zzf.size();
        for (int i = 0; i < size; i++) {
            ((zzakc) this.zzf.valueAt(i)).zzi();
        }
        this.zzo.clear();
        this.zzw = 0;
        this.zzx = j2;
        this.zzn.clear();
        zzh();
    }

    public final boolean zzf(zzadv zzadv) throws IOException {
        zzaex zza2 = zzako.zza(zzadv);
        this.zzp = zza2 != null ? zzgbc.zzn(zza2) : zzgbc.zzm();
        return zza2 == null;
    }

    public zzakd(zzalt zzalt, int i) {
        this(zzalt, 32, (zzgb) null, (zzakp) null, zzgbc.zzm(), (zzafa) null);
    }

    public zzakd(zzalt zzalt, int i, zzgb zzgb, zzakp zzakp, List list, zzafa zzafa) {
        this.zzd = zzalt;
        this.zze = Collections.unmodifiableList(list);
        this.zzl = new zzagu();
        this.zzm = new zzfu(16);
        this.zzg = new zzfu(zzgr.zza);
        this.zzh = new zzfu(5);
        this.zzi = new zzfu();
        this.zzj = new byte[16];
        this.zzk = new zzfu(this.zzj);
        this.zzn = new ArrayDeque();
        this.zzo = new ArrayDeque();
        this.zzf = new SparseArray();
        this.zzp = zzgbc.zzm();
        this.zzy = -9223372036854775807L;
        this.zzx = -9223372036854775807L;
        this.zzz = -9223372036854775807L;
        this.zzF = zzadx.zza;
        this.zzG = new zzafa[0];
        this.zzH = new zzafa[0];
    }
}
