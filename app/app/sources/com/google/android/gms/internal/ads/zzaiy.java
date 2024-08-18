package com.google.android.gms.internal.ads;

import android.util.SparseArray;
import androidx.compose.animation.core.AnimationKt;
import com.google.firebase.FirebaseError;
import java.io.IOException;
import java.math.RoundingMode;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzaiy implements zzadu {
    @Deprecated
    public static final zzaea zza = new zzaiu();
    private static final byte[] zzb = {49, 10, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 48, 48, 32, 45, 45, 62, 32, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 48, 48, 10};
    /* access modifiers changed from: private */
    public static final byte[] zzc = "Format: Start, End, ReadOrder, Layer, Style, Name, MarginL, MarginR, MarginV, Effect, Text".getBytes(zzfxs.zzc);
    private static final byte[] zzd = {68, 105, 97, 108, 111, 103, 117, 101, 58, 32, 48, 58, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 58, 48, 48, 58, 48, 48, 58, 48, 48, 44};
    private static final byte[] zze = {87, 69, 66, 86, 84, 84, 10, 10, 48, 48, 58, 48, 48, 58, 48, 48, 46, 48, 48, 48, 32, 45, 45, 62, 32, 48, 48, 58, 48, 48, 58, 48, 48, 46, 48, 48, 48, 10};
    /* access modifiers changed from: private */
    public static final UUID zzf = new UUID(72057594037932032L, -9223371306706625679L);
    /* access modifiers changed from: private */
    public static final Map zzg;
    private long zzA;
    private long zzB;
    private zzaix zzC;
    private boolean zzD;
    private int zzE;
    private long zzF;
    private boolean zzG;
    private long zzH;
    private long zzI;
    private long zzJ;
    private zzfl zzK;
    private zzfl zzL;
    private boolean zzM;
    private boolean zzN;
    private int zzO;
    private long zzP;
    private long zzQ;
    private int zzR;
    private int zzS;
    private int[] zzT;
    private int zzU;
    private int zzV;
    private int zzW;
    private int zzX;
    private boolean zzY;
    private long zzZ;
    private int zzaa;
    private int zzab;
    private int zzac;
    private boolean zzad;
    private boolean zzae;
    private boolean zzaf;
    private int zzag;
    private byte zzah;
    private boolean zzai;
    private zzadx zzaj;
    private final zzait zzh;
    private final zzaja zzi;
    private final SparseArray zzj;
    private final boolean zzk;
    private final zzalt zzl;
    private final zzfu zzm;
    private final zzfu zzn;
    private final zzfu zzo;
    private final zzfu zzp;
    private final zzfu zzq;
    private final zzfu zzr;
    private final zzfu zzs;
    private final zzfu zzt;
    private final zzfu zzu;
    private final zzfu zzv;
    private ByteBuffer zzw;
    private long zzx;
    private long zzy;
    private long zzz;

    static {
        int i = zzgd.zza;
        HashMap hashMap = new HashMap();
        hashMap.put("htc_video_rotA-000", 0);
        hashMap.put("htc_video_rotA-090", 90);
        hashMap.put("htc_video_rotA-180", 180);
        hashMap.put("htc_video_rotA-270", 270);
        zzg = Collections.unmodifiableMap(hashMap);
    }

    @Deprecated
    public zzaiy() {
        this(new zzair(), 2, zzalt.zza);
    }

    @RequiresNonNull({"#2.output"})
    private final int zzo(zzadv zzadv, zzaix zzaix, int i, boolean z) throws IOException {
        int i2;
        if ("S_TEXT/UTF8".equals(zzaix.zzb)) {
            zzw(zzadv, zzb, i);
            int i3 = this.zzab;
            zzv();
            return i3;
        } else if ("S_TEXT/ASS".equals(zzaix.zzb)) {
            zzw(zzadv, zzd, i);
            int i4 = this.zzab;
            zzv();
            return i4;
        } else if ("S_TEXT/WEBVTT".equals(zzaix.zzb)) {
            zzw(zzadv, zze, i);
            int i5 = this.zzab;
            zzv();
            return i5;
        } else {
            zzafa zzafa = zzaix.zzW;
            boolean z2 = true;
            if (!this.zzad) {
                if (zzaix.zzg) {
                    this.zzW &= -1073741825;
                    int i6 = 128;
                    if (!this.zzae) {
                        ((zzadi) zzadv).zzn(this.zzo.zzM(), 0, 1, false);
                        this.zzaa++;
                        if ((this.zzo.zzM()[0] & 128) != 128) {
                            this.zzah = this.zzo.zzM()[0];
                            this.zzae = true;
                        } else {
                            throw zzch.zza("Extension bit is set in signal byte", (Throwable) null);
                        }
                    }
                    byte b = this.zzah;
                    if ((b & 1) == 1) {
                        byte b2 = b & 2;
                        this.zzW |= 1073741824;
                        if (!this.zzai) {
                            ((zzadi) zzadv).zzn(this.zzt.zzM(), 0, 8, false);
                            this.zzaa += 8;
                            this.zzai = true;
                            zzfu zzfu = this.zzo;
                            if (b2 != 2) {
                                i6 = 0;
                            }
                            zzfu.zzM()[0] = (byte) (i6 | 8);
                            this.zzo.zzK(0);
                            zzafa.zzr(this.zzo, 1, 1);
                            this.zzab++;
                            this.zzt.zzK(0);
                            zzafa.zzr(this.zzt, 8, 1);
                            this.zzab += 8;
                        }
                        if (b2 == 2) {
                            if (!this.zzaf) {
                                ((zzadi) zzadv).zzn(this.zzo.zzM(), 0, 1, false);
                                this.zzaa++;
                                this.zzo.zzK(0);
                                this.zzag = this.zzo.zzm();
                                this.zzaf = true;
                            }
                            int i7 = this.zzag * 4;
                            this.zzo.zzH(i7);
                            ((zzadi) zzadv).zzn(this.zzo.zzM(), 0, i7, false);
                            this.zzaa += i7;
                            int i8 = (this.zzag >> 1) + 1;
                            int i9 = (i8 * 6) + 2;
                            ByteBuffer byteBuffer = this.zzw;
                            if (byteBuffer == null || byteBuffer.capacity() < i9) {
                                this.zzw = ByteBuffer.allocate(i9);
                            }
                            this.zzw.position(0);
                            this.zzw.putShort((short) i8);
                            int i10 = 0;
                            int i11 = 0;
                            while (true) {
                                i2 = this.zzag;
                                if (i10 >= i2) {
                                    break;
                                }
                                int zzp2 = this.zzo.zzp();
                                int i12 = zzp2 - i11;
                                if (i10 % 2 == 0) {
                                    this.zzw.putShort((short) i12);
                                } else {
                                    this.zzw.putInt(i12);
                                }
                                i10++;
                                i11 = zzp2;
                            }
                            int i13 = (i - this.zzaa) - i11;
                            if ((i2 & 1) == 1) {
                                this.zzw.putInt(i13);
                            } else {
                                this.zzw.putShort((short) i13);
                                this.zzw.putInt(0);
                            }
                            this.zzu.zzI(this.zzw.array(), i9);
                            zzafa.zzr(this.zzu, i9, 1);
                            this.zzab += i9;
                        }
                    }
                } else {
                    byte[] bArr = zzaix.zzh;
                    if (bArr != null) {
                        this.zzr.zzI(bArr, bArr.length);
                    }
                }
                if (!"A_OPUS".equals(zzaix.zzb) ? zzaix.zzf > 0 : z) {
                    this.zzW |= 268435456;
                    this.zzv.zzH(0);
                    int zze2 = (this.zzr.zze() + i) - this.zzaa;
                    this.zzo.zzH(4);
                    this.zzo.zzM()[0] = (byte) ((zze2 >> 24) & 255);
                    this.zzo.zzM()[1] = (byte) ((zze2 >> 16) & 255);
                    this.zzo.zzM()[2] = (byte) ((zze2 >> 8) & 255);
                    this.zzo.zzM()[3] = (byte) (zze2 & 255);
                    zzafa.zzr(this.zzo, 4, 2);
                    this.zzab += 4;
                }
                this.zzad = true;
            }
            int zze3 = i + this.zzr.zze();
            if (!"V_MPEG4/ISO/AVC".equals(zzaix.zzb) && !"V_MPEGH/ISO/HEVC".equals(zzaix.zzb)) {
                if (zzaix.zzT != null) {
                    if (this.zzr.zze() != 0) {
                        z2 = false;
                    }
                    zzeq.zzf(z2);
                    zzaix.zzT.zzd(zzadv);
                }
                while (true) {
                    int i14 = this.zzaa;
                    if (i14 >= zze3) {
                        break;
                    }
                    int zzp3 = zzp(zzadv, zzafa, zze3 - i14);
                    this.zzaa += zzp3;
                    this.zzab += zzp3;
                }
            } else {
                byte[] zzM2 = this.zzn.zzM();
                zzM2[0] = 0;
                zzM2[1] = 0;
                zzM2[2] = 0;
                int i15 = zzaix.zzX;
                int i16 = 4 - i15;
                while (this.zzaa < zze3) {
                    int i17 = this.zzac;
                    if (i17 == 0) {
                        int min = Math.min(i15, this.zzr.zzb());
                        ((zzadi) zzadv).zzn(zzM2, i16 + min, i15 - min, false);
                        if (min > 0) {
                            this.zzr.zzG(zzM2, i16, min);
                        }
                        this.zzaa += i15;
                        this.zzn.zzK(0);
                        this.zzac = this.zzn.zzp();
                        this.zzm.zzK(0);
                        zzaey.zzb(zzafa, this.zzm, 4);
                        this.zzab += 4;
                    } else {
                        int zzp4 = zzp(zzadv, zzafa, i17);
                        this.zzaa += zzp4;
                        this.zzab += zzp4;
                        this.zzac -= zzp4;
                    }
                }
            }
            if ("A_VORBIS".equals(zzaix.zzb)) {
                this.zzp.zzK(0);
                zzaey.zzb(zzafa, this.zzp, 4);
                this.zzab += 4;
            }
            int i18 = this.zzab;
            zzv();
            return i18;
        }
    }

    private final int zzp(zzadv zzadv, zzafa zzafa, int i) throws IOException {
        int zzb2 = this.zzr.zzb();
        if (zzb2 <= 0) {
            return zzaey.zza(zzafa, zzadv, i, false);
        }
        int min = Math.min(i, zzb2);
        zzaey.zzb(zzafa, this.zzr, min);
        return min;
    }

    private final long zzq(long j) throws zzch {
        long j2 = this.zzz;
        if (j2 != -9223372036854775807L) {
            return zzgd.zzt(j, j2, 1000, RoundingMode.FLOOR);
        }
        throw zzch.zza("Can't scale timecode prior to timecodeScale being set.", (Throwable) null);
    }

    @EnsuresNonNull({"cueTimesUs", "cueClusterPositions"})
    private final void zzr(int i) throws zzch {
        if (this.zzK == null || this.zzL == null) {
            throw zzch.zza("Element " + i + " must be in a Cues", (Throwable) null);
        }
    }

    @EnsuresNonNull({"currentTrack"})
    private final void zzs(int i) throws zzch {
        if (this.zzC == null) {
            throw zzch.zza("Element " + i + " must be in a TrackEntry", (Throwable) null);
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00ee  */
    @org.checkerframework.checker.nullness.qual.RequiresNonNull({"#1.output"})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void zzt(com.google.android.gms.internal.ads.zzaix r18, long r19, int r21, int r22, int r23) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            com.google.android.gms.internal.ads.zzafb r2 = r1.zzT
            r9 = 1
            if (r2 == 0) goto L_0x001c
            com.google.android.gms.internal.ads.zzafa r3 = r1.zzW
            com.google.android.gms.internal.ads.zzaez r8 = r1.zzi
            r1 = r2
            r2 = r3
            r3 = r19
            r5 = r21
            r6 = r22
            r7 = r23
            r1.zzc(r2, r3, r5, r6, r7, r8)
            goto L_0x0118
        L_0x001c:
            java.lang.String r2 = r1.zzb
            java.lang.String r3 = "S_TEXT/UTF8"
            boolean r2 = r3.equals(r2)
            r4 = 2
            java.lang.String r5 = "S_TEXT/WEBVTT"
            java.lang.String r6 = "S_TEXT/ASS"
            r7 = 0
            if (r2 != 0) goto L_0x003c
            java.lang.String r2 = r1.zzb
            boolean r2 = r6.equals(r2)
            if (r2 != 0) goto L_0x003c
            java.lang.String r2 = r1.zzb
            boolean r2 = r5.equals(r2)
            if (r2 == 0) goto L_0x0058
        L_0x003c:
            int r2 = r0.zzS
            java.lang.String r8 = "MatroskaExtractor"
            if (r2 <= r9) goto L_0x0048
            java.lang.String r2 = "Skipping subtitle sample in laced block."
            com.google.android.gms.internal.ads.zzfk.zzf(r8, r2)
            goto L_0x0058
        L_0x0048:
            long r10 = r0.zzQ
            r12 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r2 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r2 != 0) goto L_0x005c
            java.lang.String r2 = "Skipping subtitle sample with no duration."
            com.google.android.gms.internal.ads.zzfk.zzf(r8, r2)
        L_0x0058:
            r2 = r22
            goto L_0x00e8
        L_0x005c:
            java.lang.String r2 = r1.zzb
            com.google.android.gms.internal.ads.zzfu r8 = r0.zzs
            byte[] r8 = r8.zzM()
            int r12 = r2.hashCode()
            switch(r12) {
                case 738597099: goto L_0x007d;
                case 1045209816: goto L_0x0075;
                case 1422270023: goto L_0x006c;
                default: goto L_0x006b;
            }
        L_0x006b:
            goto L_0x0085
        L_0x006c:
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x006b
            r2 = r7
            goto L_0x0086
        L_0x0075:
            boolean r2 = r2.equals(r5)
            if (r2 == 0) goto L_0x006b
            r2 = r4
            goto L_0x0086
        L_0x007d:
            boolean r2 = r2.equals(r6)
            if (r2 == 0) goto L_0x006b
            r2 = r9
            goto L_0x0086
        L_0x0085:
            r2 = -1
        L_0x0086:
            r5 = 1000(0x3e8, double:4.94E-321)
            switch(r2) {
                case 0: goto L_0x00a6;
                case 1: goto L_0x009a;
                case 2: goto L_0x0091;
                default: goto L_0x008b;
            }
        L_0x008b:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            r1.<init>()
            throw r1
        L_0x0091:
            java.lang.String r2 = "%02d:%02d:%02d.%03d"
            byte[] r2 = zzx(r10, r2, r5)
            r3 = 25
            goto L_0x00af
        L_0x009a:
            java.lang.String r2 = "%01d:%02d:%02d:%02d"
            r5 = 10000(0x2710, double:4.9407E-320)
            byte[] r2 = zzx(r10, r2, r5)
            r3 = 21
            goto L_0x00af
        L_0x00a6:
            java.lang.String r2 = "%02d:%02d:%02d,%03d"
            byte[] r2 = zzx(r10, r2, r5)
            r3 = 19
        L_0x00af:
            int r5 = r2.length
            java.lang.System.arraycopy(r2, r7, r8, r3, r5)
            com.google.android.gms.internal.ads.zzfu r2 = r0.zzs
            int r2 = r2.zzd()
        L_0x00ba:
            com.google.android.gms.internal.ads.zzfu r3 = r0.zzs
            int r3 = r3.zze()
            if (r2 >= r3) goto L_0x00d5
            com.google.android.gms.internal.ads.zzfu r3 = r0.zzs
            byte[] r3 = r3.zzM()
            byte r3 = r3[r2]
            if (r3 != 0) goto L_0x00d2
            com.google.android.gms.internal.ads.zzfu r3 = r0.zzs
            r3.zzJ(r2)
            goto L_0x00d5
        L_0x00d2:
            int r2 = r2 + 1
            goto L_0x00ba
        L_0x00d5:
            com.google.android.gms.internal.ads.zzafa r2 = r1.zzW
            com.google.android.gms.internal.ads.zzfu r3 = r0.zzs
            int r5 = r3.zze()
            com.google.android.gms.internal.ads.zzaey.zzb(r2, r3, r5)
            com.google.android.gms.internal.ads.zzfu r2 = r0.zzs
            int r2 = r2.zze()
            int r2 = r22 + r2
        L_0x00e8:
            r3 = 268435456(0x10000000, float:2.5243549E-29)
            r3 = r21 & r3
            if (r3 == 0) goto L_0x0108
            int r3 = r0.zzS
            if (r3 <= r9) goto L_0x00f8
            com.google.android.gms.internal.ads.zzfu r3 = r0.zzv
            r3.zzH(r7)
            goto L_0x0108
        L_0x00f8:
            com.google.android.gms.internal.ads.zzfu r3 = r0.zzv
            int r3 = r3.zze()
            com.google.android.gms.internal.ads.zzafa r5 = r1.zzW
            com.google.android.gms.internal.ads.zzfu r6 = r0.zzv
            r5.zzr(r6, r3, r4)
            int r2 = r2 + r3
            r14 = r2
            goto L_0x0109
        L_0x0108:
            r14 = r2
        L_0x0109:
            com.google.android.gms.internal.ads.zzafa r10 = r1.zzW
            com.google.android.gms.internal.ads.zzaez r1 = r1.zzi
            r11 = r19
            r13 = r21
            r15 = r23
            r16 = r1
            r10.zzs(r11, r13, r14, r15, r16)
        L_0x0118:
            r0.zzN = r9
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaiy.zzt(com.google.android.gms.internal.ads.zzaix, long, int, int, int):void");
    }

    private final void zzu(zzadv zzadv, int i) throws IOException {
        if (this.zzo.zze() < i) {
            if (this.zzo.zzc() < i) {
                zzfu zzfu = this.zzo;
                int zzc2 = zzfu.zzc();
                zzfu.zzE(Math.max(zzc2 + zzc2, i));
            }
            zzfu zzfu2 = this.zzo;
            ((zzadi) zzadv).zzn(zzfu2.zzM(), zzfu2.zze(), i - zzfu2.zze(), false);
            this.zzo.zzJ(i);
        }
    }

    private final void zzv() {
        this.zzaa = 0;
        this.zzab = 0;
        this.zzac = 0;
        this.zzad = false;
        this.zzae = false;
        this.zzaf = false;
        this.zzag = 0;
        this.zzah = 0;
        this.zzai = false;
        this.zzr.zzH(0);
    }

    private final void zzw(zzadv zzadv, byte[] bArr, int i) throws IOException {
        int length = bArr.length;
        int i2 = length + i;
        if (this.zzs.zzc() < i2) {
            zzfu zzfu = this.zzs;
            byte[] copyOf = Arrays.copyOf(bArr, i2 + i);
            zzfu.zzI(copyOf, copyOf.length);
        } else {
            System.arraycopy(bArr, 0, this.zzs.zzM(), 0, length);
        }
        ((zzadi) zzadv).zzn(this.zzs.zzM(), length, i, false);
        this.zzs.zzK(0);
        this.zzs.zzJ(i2);
    }

    private static byte[] zzx(long j, String str, long j2) {
        boolean z;
        if (j != -9223372036854775807L) {
            z = true;
        } else {
            z = false;
        }
        zzeq.zzd(z);
        Locale locale = Locale.US;
        int i = (int) (j / 3600000000L);
        Integer valueOf = Integer.valueOf(i);
        long j3 = j - (((long) i) * 3600000000L);
        int i2 = (int) (j3 / 60000000);
        Integer valueOf2 = Integer.valueOf(i2);
        long j4 = j3 - (((long) i2) * 60000000);
        int i3 = (int) (j4 / AnimationKt.MillisToNanos);
        String format = String.format(locale, str, new Object[]{valueOf, valueOf2, Integer.valueOf(i3), Integer.valueOf((int) ((j4 - (((long) i3) * AnimationKt.MillisToNanos)) / j2))});
        int i4 = zzgd.zza;
        return format.getBytes(zzfxs.zzc);
    }

    private static int[] zzy(int[] iArr, int i) {
        if (iArr == null) {
            return new int[i];
        }
        int length = iArr.length;
        return length >= i ? iArr : new int[Math.max(length + length, i)];
    }

    public final int zzb(zzadv zzadv, zzaeq zzaeq) throws IOException {
        this.zzN = false;
        while (!this.zzN) {
            if (this.zzh.zzc(zzadv)) {
                long zzf2 = zzadv.zzf();
                if (this.zzG) {
                    this.zzI = zzf2;
                    zzaeq.zza = this.zzH;
                    this.zzG = false;
                    return 1;
                } else if (this.zzD) {
                    long j = this.zzI;
                    if (j != -1) {
                        zzaeq.zza = j;
                        this.zzI = -1;
                        return 1;
                    }
                }
            } else {
                for (int i = 0; i < this.zzj.size(); i++) {
                    zzaix zzaix = (zzaix) this.zzj.valueAt(i);
                    zzaix.zzd(zzaix);
                    zzafb zzafb = zzaix.zzT;
                    if (zzafb != null) {
                        zzafb.zza(zzaix.zzW, zzaix.zzi);
                    }
                }
                return -1;
            }
        }
        return 0;
    }

    public final /* synthetic */ List zzc() {
        return zzgbc.zzm();
    }

    public final void zzd(zzadx zzadx) {
        this.zzaj = zzadx;
    }

    public final void zze(long j, long j2) {
        this.zzJ = -9223372036854775807L;
        this.zzO = 0;
        this.zzh.zzb();
        this.zzi.zze();
        zzv();
        for (int i = 0; i < this.zzj.size(); i++) {
            zzafb zzafb = ((zzaix) this.zzj.valueAt(i)).zzT;
            if (zzafb != null) {
                zzafb.zzb();
            }
        }
    }

    public final boolean zzf(zzadv zzadv) throws IOException {
        return new zzaiz().zza(zzadv);
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x0267, code lost:
        throw com.google.android.gms.internal.ads.zzch.zza("EBML lacing sample size out of range.", (java.lang.Throwable) null);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzh(int r20, int r21, com.google.android.gms.internal.ads.zzadv r22) throws java.io.IOException {
        /*
            r19 = this;
            r7 = r19
            r0 = r20
            r1 = r21
            r8 = r22
            r3 = 4
            r4 = 2
            r9 = 1
            r10 = 0
            switch(r0) {
                case 161: goto L_0x00fa;
                case 163: goto L_0x00fa;
                case 165: goto L_0x00c3;
                case 16877: goto L_0x0097;
                case 16981: goto L_0x0085;
                case 18402: goto L_0x0070;
                case 21419: goto L_0x004a;
                case 25506: goto L_0x0038;
                case 30322: goto L_0x0026;
                default: goto L_0x000f;
            }
        L_0x000f:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Unexpected id: "
            r1.append(r2)
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            r1 = 0
            com.google.android.gms.internal.ads.zzch r0 = com.google.android.gms.internal.ads.zzch.zza(r0, r1)
            throw r0
        L_0x0026:
            r19.zzs(r20)
            com.google.android.gms.internal.ads.zzaix r0 = r7.zzC
            byte[] r2 = new byte[r1]
            r0.zzv = r2
            byte[] r0 = r0.zzv
            r2 = r8
            com.google.android.gms.internal.ads.zzadi r2 = (com.google.android.gms.internal.ads.zzadi) r2
            r2.zzn(r0, r10, r1, r10)
            return
        L_0x0038:
            r19.zzs(r20)
            com.google.android.gms.internal.ads.zzaix r0 = r7.zzC
            byte[] r2 = new byte[r1]
            r0.zzj = r2
            byte[] r0 = r0.zzj
            r2 = r8
            com.google.android.gms.internal.ads.zzadi r2 = (com.google.android.gms.internal.ads.zzadi) r2
            r2.zzn(r0, r10, r1, r10)
            return
        L_0x004a:
            com.google.android.gms.internal.ads.zzfu r0 = r7.zzq
            byte[] r0 = r0.zzM()
            java.util.Arrays.fill(r0, r10)
            com.google.android.gms.internal.ads.zzfu r0 = r7.zzq
            int r2 = 4 - r1
            byte[] r0 = r0.zzM()
            r3 = r8
            com.google.android.gms.internal.ads.zzadi r3 = (com.google.android.gms.internal.ads.zzadi) r3
            r3.zzn(r0, r2, r1, r10)
            com.google.android.gms.internal.ads.zzfu r0 = r7.zzq
            r0.zzK(r10)
            com.google.android.gms.internal.ads.zzfu r0 = r7.zzq
            long r0 = r0.zzu()
            int r0 = (int) r0
            r7.zzE = r0
            return
        L_0x0070:
            byte[] r2 = new byte[r1]
            r3 = r8
            com.google.android.gms.internal.ads.zzadi r3 = (com.google.android.gms.internal.ads.zzadi) r3
            r3.zzn(r2, r10, r1, r10)
            r19.zzs(r20)
            com.google.android.gms.internal.ads.zzaix r0 = r7.zzC
            com.google.android.gms.internal.ads.zzaez r1 = new com.google.android.gms.internal.ads.zzaez
            r1.<init>(r9, r2, r10, r10)
            r0.zzi = r1
            return
        L_0x0085:
            r19.zzs(r20)
            com.google.android.gms.internal.ads.zzaix r0 = r7.zzC
            byte[] r2 = new byte[r1]
            r0.zzh = r2
            byte[] r0 = r0.zzh
            r2 = r8
            com.google.android.gms.internal.ads.zzadi r2 = (com.google.android.gms.internal.ads.zzadi) r2
            r2.zzn(r0, r10, r1, r10)
            return
        L_0x0097:
            r19.zzs(r20)
            com.google.android.gms.internal.ads.zzaix r0 = r7.zzC
            int r2 = r0.zzY
            r3 = 1685485123(0x64767643, float:1.8185683E22)
            if (r2 == r3) goto L_0x00b6
            int r2 = r0.zzY
            r3 = 1685480259(0x64766343, float:1.8180206E22)
            if (r2 != r3) goto L_0x00af
            goto L_0x00b6
        L_0x00af:
            r0 = r8
            com.google.android.gms.internal.ads.zzadi r0 = (com.google.android.gms.internal.ads.zzadi) r0
            r0.zzo(r1, r10)
            return
        L_0x00b6:
            byte[] r2 = new byte[r1]
            r0.zzN = r2
            byte[] r0 = r0.zzN
            r2 = r8
            com.google.android.gms.internal.ads.zzadi r2 = (com.google.android.gms.internal.ads.zzadi) r2
            r2.zzn(r0, r10, r1, r10)
            return
        L_0x00c3:
            int r0 = r7.zzO
            if (r0 == r4) goto L_0x00c9
            goto L_0x0314
        L_0x00c9:
            android.util.SparseArray r0 = r7.zzj
            int r2 = r7.zzU
            java.lang.Object r0 = r0.get(r2)
            com.google.android.gms.internal.ads.zzaix r0 = (com.google.android.gms.internal.ads.zzaix) r0
            int r2 = r7.zzX
            if (r2 != r3) goto L_0x00f3
            java.lang.String r0 = r0.zzb
            java.lang.String r2 = "V_VP9"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x00f3
            com.google.android.gms.internal.ads.zzfu r0 = r7.zzv
            r0.zzH(r1)
            com.google.android.gms.internal.ads.zzfu r0 = r7.zzv
            byte[] r0 = r0.zzM()
            r2 = r8
            com.google.android.gms.internal.ads.zzadi r2 = (com.google.android.gms.internal.ads.zzadi) r2
            r2.zzn(r0, r10, r1, r10)
            return
        L_0x00f3:
            r0 = r8
            com.google.android.gms.internal.ads.zzadi r0 = (com.google.android.gms.internal.ads.zzadi) r0
            r0.zzo(r1, r10)
            return
        L_0x00fa:
            int r5 = r7.zzO
            r6 = 8
            if (r5 != 0) goto L_0x011f
            com.google.android.gms.internal.ads.zzaja r5 = r7.zzi
            long r11 = r5.zzd(r8, r10, r9, r6)
            int r5 = (int) r11
            r7.zzU = r5
            com.google.android.gms.internal.ads.zzaja r5 = r7.zzi
            int r5 = r5.zza()
            r7.zzV = r5
            r11 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r7.zzQ = r11
            r7.zzO = r9
            com.google.android.gms.internal.ads.zzfu r5 = r7.zzo
            r5.zzH(r10)
        L_0x011f:
            android.util.SparseArray r5 = r7.zzj
            int r11 = r7.zzU
            java.lang.Object r5 = r5.get(r11)
            r11 = r5
            com.google.android.gms.internal.ads.zzaix r11 = (com.google.android.gms.internal.ads.zzaix) r11
            if (r11 != 0) goto L_0x0139
            int r0 = r7.zzV
            int r0 = r1 - r0
            r1 = r8
            com.google.android.gms.internal.ads.zzadi r1 = (com.google.android.gms.internal.ads.zzadi) r1
            r1.zzo(r0, r10)
            r7.zzO = r10
            return
        L_0x0139:
            com.google.android.gms.internal.ads.zzaix.zzd(r11)
            int r5 = r7.zzO
            if (r5 != r9) goto L_0x02cb
            r5 = 3
            r7.zzu(r8, r5)
            com.google.android.gms.internal.ads.zzfu r13 = r7.zzo
            byte[] r13 = r13.zzM()
            byte r13 = r13[r4]
            r13 = r13 & 6
            int r13 = r13 >> r9
            r14 = 255(0xff, float:3.57E-43)
            if (r13 != 0) goto L_0x0168
            r7.zzS = r9
            int[] r2 = r7.zzT
            int[] r2 = zzy(r2, r9)
            r7.zzT = r2
            int[] r2 = r7.zzT
            int r3 = r7.zzV
            int r1 = r1 - r3
            int r1 = r1 + -3
            r2[r10] = r1
            goto L_0x0279
        L_0x0168:
            r7.zzu(r8, r3)
            com.google.android.gms.internal.ads.zzfu r15 = r7.zzo
            byte[] r15 = r15.zzM()
            byte r15 = r15[r5]
            r15 = r15 & r14
            int r15 = r15 + r9
            r7.zzS = r15
            int[] r3 = r7.zzT
            int[] r3 = zzy(r3, r15)
            r7.zzT = r3
            if (r13 != r4) goto L_0x0191
            int r2 = r7.zzV
            int r1 = r1 - r2
            int r1 = r1 + -4
            int r2 = r7.zzS
            int r1 = r1 / r2
            int[] r3 = r7.zzT
            java.util.Arrays.fill(r3, r10, r2, r1)
            goto L_0x0279
        L_0x0191:
            if (r13 != r9) goto L_0x01c9
            r2 = r10
            r5 = r2
            r3 = 4
        L_0x0196:
            int r13 = r7.zzS
            int r13 = r13 + -1
            if (r2 >= r13) goto L_0x01be
            int[] r13 = r7.zzT
            r13[r2] = r10
        L_0x01a0:
            int r3 = r3 + r9
            r7.zzu(r8, r3)
            com.google.android.gms.internal.ads.zzfu r13 = r7.zzo
            int r15 = r3 + -1
            byte[] r13 = r13.zzM()
            byte r13 = r13[r15]
            r13 = r13 & r14
            int[] r15 = r7.zzT
            r16 = r15[r2]
            int r16 = r16 + r13
            r15[r2] = r16
            if (r13 == r14) goto L_0x01a0
            int r5 = r5 + r16
            int r2 = r2 + 1
            goto L_0x0196
        L_0x01be:
            int[] r2 = r7.zzT
            int r15 = r7.zzV
            int r1 = r1 - r15
            int r1 = r1 - r3
            int r1 = r1 - r5
            r2[r13] = r1
            goto L_0x0279
        L_0x01c9:
            if (r13 != r5) goto L_0x02c2
            r5 = r10
            r13 = r5
            r3 = 4
        L_0x01ce:
            int r15 = r7.zzS
            int r15 = r15 + -1
            if (r5 >= r15) goto L_0x0270
            int[] r15 = r7.zzT
            r15[r5] = r10
            int r3 = r3 + 1
            r7.zzu(r8, r3)
            com.google.android.gms.internal.ads.zzfu r15 = r7.zzo
            int r16 = r3 + -1
            byte[] r15 = r15.zzM()
            byte r15 = r15[r16]
            if (r15 == 0) goto L_0x0268
            r15 = r10
        L_0x01ea:
            if (r15 >= r6) goto L_0x023c
            int r17 = 7 - r15
            int r12 = r9 << r17
            com.google.android.gms.internal.ads.zzfu r4 = r7.zzo
            byte[] r4 = r4.zzM()
            byte r4 = r4[r16]
            r4 = r4 & r12
            if (r4 == 0) goto L_0x0236
            int r3 = r3 + r15
            r7.zzu(r8, r3)
            com.google.android.gms.internal.ads.zzfu r4 = r7.zzo
            int r18 = r16 + 1
            byte[] r4 = r4.zzM()
            byte r4 = r4[r16]
            r4 = r4 & r14
            int r12 = ~r12
            r4 = r4 & r12
            long r9 = (long) r4
            r4 = r18
        L_0x020f:
            if (r4 >= r3) goto L_0x0224
            long r9 = r9 << r6
            com.google.android.gms.internal.ads.zzfu r12 = r7.zzo
            int r16 = r4 + 1
            byte[] r12 = r12.zzM()
            byte r4 = r12[r4]
            r4 = r4 & r14
            r12 = r3
            long r2 = (long) r4
            long r9 = r9 | r2
            r3 = r12
            r4 = r16
            goto L_0x020f
        L_0x0224:
            r12 = r3
            if (r5 <= 0) goto L_0x0234
            int r15 = r15 * 7
            int r15 = r15 + 6
            r2 = 1
            long r2 = r2 << r15
            r15 = -1
            long r2 = r2 + r15
            long r9 = r9 - r2
            r3 = r12
            goto L_0x023e
        L_0x0234:
            r3 = r12
            goto L_0x023e
        L_0x0236:
            int r15 = r15 + 1
            r4 = 2
            r9 = 1
            r10 = 0
            goto L_0x01ea
        L_0x023c:
            r9 = 0
        L_0x023e:
            r15 = -2147483648(0xffffffff80000000, double:NaN)
            int r2 = (r9 > r15 ? 1 : (r9 == r15 ? 0 : -1))
            if (r2 < 0) goto L_0x0260
            r15 = 2147483647(0x7fffffff, double:1.060997895E-314)
            int r2 = (r9 > r15 ? 1 : (r9 == r15 ? 0 : -1))
            if (r2 > 0) goto L_0x0260
            int[] r2 = r7.zzT
            int r4 = (int) r9
            if (r5 == 0) goto L_0x0256
            int r9 = r5 + -1
            r9 = r2[r9]
            int r4 = r4 + r9
        L_0x0256:
            r2[r5] = r4
            int r13 = r13 + r4
            int r5 = r5 + 1
            r4 = 2
            r9 = 1
            r10 = 0
            goto L_0x01ce
        L_0x0260:
            java.lang.String r0 = "EBML lacing sample size out of range."
            r1 = 0
            com.google.android.gms.internal.ads.zzch r0 = com.google.android.gms.internal.ads.zzch.zza(r0, r1)
            throw r0
        L_0x0268:
            r1 = 0
            java.lang.String r0 = "No valid varint length mask found"
            com.google.android.gms.internal.ads.zzch r0 = com.google.android.gms.internal.ads.zzch.zza(r0, r1)
            throw r0
        L_0x0270:
            int[] r2 = r7.zzT
            int r4 = r7.zzV
            int r1 = r1 - r4
            int r1 = r1 - r3
            int r1 = r1 - r13
            r2[r15] = r1
        L_0x0279:
            com.google.android.gms.internal.ads.zzfu r1 = r7.zzo
            byte[] r1 = r1.zzM()
            r2 = 0
            byte r1 = r1[r2]
            int r1 = r1 << r6
            com.google.android.gms.internal.ads.zzfu r2 = r7.zzo
            byte[] r2 = r2.zzM()
            r3 = 1
            byte r2 = r2[r3]
            r2 = r2 & r14
            long r3 = r7.zzJ
            r1 = r1 | r2
            long r1 = (long) r1
            long r1 = r7.zzq(r1)
            long r3 = r3 + r1
            r7.zzP = r3
            int r1 = r11.zzd
            r2 = 2
            if (r1 == r2) goto L_0x02b8
            r1 = 163(0xa3, float:2.28E-43)
            if (r0 != r1) goto L_0x02b5
            com.google.android.gms.internal.ads.zzfu r0 = r7.zzo
            byte[] r0 = r0.zzM()
            byte r0 = r0[r2]
            r1 = 128(0x80, float:1.794E-43)
            r0 = r0 & r1
            if (r0 != r1) goto L_0x02b2
            r0 = 163(0xa3, float:2.28E-43)
            r1 = 1
            goto L_0x02b9
        L_0x02b2:
            r0 = 163(0xa3, float:2.28E-43)
            goto L_0x02b6
        L_0x02b5:
        L_0x02b6:
            r1 = 0
            goto L_0x02b9
        L_0x02b8:
            r1 = 1
        L_0x02b9:
            r7.zzW = r1
            r1 = 2
            r7.zzO = r1
            r1 = 0
            r7.zzR = r1
            goto L_0x02cb
        L_0x02c2:
            java.lang.String r0 = "Unexpected lacing value: 2"
            r1 = 0
            com.google.android.gms.internal.ads.zzch r0 = com.google.android.gms.internal.ads.zzch.zza(r0, r1)
            throw r0
        L_0x02cb:
            r1 = 163(0xa3, float:2.28E-43)
            if (r0 != r1) goto L_0x02fd
        L_0x02cf:
            int r0 = r7.zzR
            int r1 = r7.zzS
            if (r0 >= r1) goto L_0x02f9
            int[] r1 = r7.zzT
            r0 = r1[r0]
            r1 = 0
            int r5 = r7.zzo(r8, r11, r0, r1)
            long r0 = r7.zzP
            int r2 = r7.zzR
            int r3 = r11.zze
            int r2 = r2 * r3
            int r2 = r2 / 1000
            long r2 = (long) r2
            long r2 = r2 + r0
            int r4 = r7.zzW
            r6 = 0
            r0 = r19
            r1 = r11
            r0.zzt(r1, r2, r4, r5, r6)
            int r0 = r7.zzR
            r1 = 1
            int r0 = r0 + r1
            r7.zzR = r0
            goto L_0x02cf
        L_0x02f9:
            r0 = 0
            r7.zzO = r0
            return
        L_0x02fd:
            int r0 = r7.zzR
            int r1 = r7.zzS
            if (r0 >= r1) goto L_0x0314
            int[] r1 = r7.zzT
            r2 = r1[r0]
            r3 = 1
            int r2 = r7.zzo(r8, r11, r2, r3)
            r1[r0] = r2
            int r0 = r7.zzR
            int r0 = r0 + r3
            r7.zzR = r0
            goto L_0x02fd
        L_0x0314:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaiy.zzh(int, int, com.google.android.gms.internal.ads.zzadv):void");
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:89:0x01cc, code lost:
        if (r3.equals("V_MPEGH/ISO/HEVC") != false) goto L_0x02f9;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzi(int r22) throws com.google.android.gms.internal.ads.zzch {
        /*
            r21 = this;
            r7 = r21
            com.google.android.gms.internal.ads.zzadx r0 = r7.zzaj
            com.google.android.gms.internal.ads.zzeq.zzb(r0)
            r0 = 8
            java.lang.String r1 = "A_OPUS"
            r2 = -1
            r4 = 2
            r5 = 0
            r8 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r10 = -1
            switch(r22) {
                case 160: goto L_0x0317;
                case 174: goto L_0x016e;
                case 19899: goto L_0x0153;
                case 25152: goto L_0x0120;
                case 28032: goto L_0x0109;
                case 357149030: goto L_0x00f1;
                case 374648427: goto L_0x00db;
                case 475249515: goto L_0x001b;
                default: goto L_0x0019;
            }
        L_0x0019:
            goto L_0x0399
        L_0x001b:
            boolean r0 = r7.zzD
            if (r0 != 0) goto L_0x00d5
            com.google.android.gms.internal.ads.zzadx r0 = r7.zzaj
            com.google.android.gms.internal.ads.zzfl r1 = r7.zzK
            com.google.android.gms.internal.ads.zzfl r4 = r7.zzL
            long r14 = r7.zzy
            int r2 = (r14 > r2 ? 1 : (r14 == r2 ? 0 : -1))
            if (r2 == 0) goto L_0x00c8
            long r2 = r7.zzB
            int r2 = (r2 > r8 ? 1 : (r2 == r8 ? 0 : -1))
            if (r2 == 0) goto L_0x00c8
            if (r1 == 0) goto L_0x00c8
            int r2 = r1.zza()
            if (r2 == 0) goto L_0x00c8
            if (r4 == 0) goto L_0x00c8
            int r2 = r4.zza()
            int r3 = r1.zza()
            if (r2 == r3) goto L_0x0047
            goto L_0x00c8
        L_0x0047:
            int r2 = r1.zza()
            int[] r3 = new int[r2]
            long[] r8 = new long[r2]
            long[] r9 = new long[r2]
            long[] r14 = new long[r2]
            r15 = 0
        L_0x0054:
            if (r15 >= r2) goto L_0x0069
            long r16 = r1.zzb(r15)
            r14[r15] = r16
            long r12 = r7.zzy
            long r18 = r4.zzb(r15)
            long r12 = r12 + r18
            r8[r15] = r12
            int r15 = r15 + 1
            goto L_0x0054
        L_0x0069:
            r13 = 0
        L_0x006a:
            int r1 = r2 + -1
            if (r13 >= r1) goto L_0x0084
            int r1 = r13 + 1
            r17 = r8[r1]
            r19 = r8[r13]
            long r10 = r17 - r19
            int r4 = (int) r10
            r3[r13] = r4
            r10 = r14[r1]
            r17 = r14[r13]
            long r10 = r10 - r17
            r9[r13] = r10
            r13 = r1
            r10 = -1
            goto L_0x006a
        L_0x0084:
            long r10 = r7.zzy
            long r12 = r7.zzx
            long r10 = r10 + r12
            r12 = r8[r1]
            long r10 = r10 - r12
            int r2 = (int) r10
            r3[r1] = r2
            long r10 = r7.zzB
            r12 = r14[r1]
            long r10 = r10 - r12
            r9[r1] = r10
            int r2 = (r10 > r5 ? 1 : (r10 == r5 ? 0 : -1))
            if (r2 > 0) goto L_0x00c1
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r4 = "Discarding last cue point with unexpected duration: "
            r2.append(r4)
            r2.append(r10)
            java.lang.String r2 = r2.toString()
            java.lang.String r4 = "MatroskaExtractor"
            com.google.android.gms.internal.ads.zzfk.zzf(r4, r2)
            int[] r3 = java.util.Arrays.copyOf(r3, r1)
            long[] r8 = java.util.Arrays.copyOf(r8, r1)
            long[] r9 = java.util.Arrays.copyOf(r9, r1)
            long[] r14 = java.util.Arrays.copyOf(r14, r1)
            goto L_0x00c2
        L_0x00c1:
        L_0x00c2:
            com.google.android.gms.internal.ads.zzadg r1 = new com.google.android.gms.internal.ads.zzadg
            r1.<init>(r3, r8, r9, r14)
            goto L_0x00cf
        L_0x00c8:
            com.google.android.gms.internal.ads.zzaes r1 = new com.google.android.gms.internal.ads.zzaes
            long r2 = r7.zzB
            r1.<init>(r2, r5)
        L_0x00cf:
            r0.zzO(r1)
            r0 = 1
            r7.zzD = r0
        L_0x00d5:
            r0 = 0
            r7.zzK = r0
            r7.zzL = r0
            return
        L_0x00db:
            android.util.SparseArray r0 = r7.zzj
            int r0 = r0.size()
            if (r0 == 0) goto L_0x00e9
            com.google.android.gms.internal.ads.zzadx r0 = r7.zzaj
            r0.zzD()
            return
        L_0x00e9:
            java.lang.String r0 = "No valid tracks were found"
            r1 = 0
            com.google.android.gms.internal.ads.zzch r0 = com.google.android.gms.internal.ads.zzch.zza(r0, r1)
            throw r0
        L_0x00f1:
            long r0 = r7.zzz
            int r0 = (r0 > r8 ? 1 : (r0 == r8 ? 0 : -1))
            if (r0 != 0) goto L_0x00fc
            r0 = 1000000(0xf4240, double:4.940656E-318)
            r7.zzz = r0
        L_0x00fc:
            long r0 = r7.zzA
            int r2 = (r0 > r8 ? 1 : (r0 == r8 ? 0 : -1))
            if (r2 == 0) goto L_0x0399
            long r0 = r7.zzq(r0)
            r7.zzB = r0
            return
        L_0x0109:
            r21.zzs(r22)
            com.google.android.gms.internal.ads.zzaix r0 = r7.zzC
            boolean r1 = r0.zzg
            if (r1 == 0) goto L_0x0399
            byte[] r0 = r0.zzh
            if (r0 != 0) goto L_0x0118
            goto L_0x0399
        L_0x0118:
            java.lang.String r0 = "Combining encryption and compression is not supported"
            r1 = 0
            com.google.android.gms.internal.ads.zzch r0 = com.google.android.gms.internal.ads.zzch.zza(r0, r1)
            throw r0
        L_0x0120:
            r21.zzs(r22)
            com.google.android.gms.internal.ads.zzaix r0 = r7.zzC
            boolean r1 = r0.zzg
            if (r1 == 0) goto L_0x0399
            com.google.android.gms.internal.ads.zzaez r1 = r0.zzi
            if (r1 == 0) goto L_0x014b
            com.google.android.gms.internal.ads.zzae r1 = new com.google.android.gms.internal.ads.zzae
            r2 = 1
            com.google.android.gms.internal.ads.zzad[] r2 = new com.google.android.gms.internal.ads.zzad[r2]
            com.google.android.gms.internal.ads.zzad r3 = new com.google.android.gms.internal.ads.zzad
            java.util.UUID r4 = com.google.android.gms.internal.ads.zzo.zza
            com.google.android.gms.internal.ads.zzaix r5 = r7.zzC
            com.google.android.gms.internal.ads.zzaez r5 = r5.zzi
            byte[] r5 = r5.zzb
            java.lang.String r6 = "video/webm"
            r8 = 0
            r3.<init>(r4, r8, r6, r5)
            r4 = 0
            r2[r4] = r3
            r1.<init>(r8, r2)
            r0.zzk = r1
            return
        L_0x014b:
            r8 = 0
            java.lang.String r0 = "Encrypted Track found but ContentEncKeyID was not found"
            com.google.android.gms.internal.ads.zzch r0 = com.google.android.gms.internal.ads.zzch.zza(r0, r8)
            throw r0
        L_0x0153:
            int r0 = r7.zzE
            r5 = -1
            if (r0 == r5) goto L_0x0166
            long r4 = r7.zzF
            int r1 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r1 == 0) goto L_0x0166
            r1 = 475249515(0x1c53bb6b, float:7.0056276E-22)
            if (r0 != r1) goto L_0x0399
            r7.zzH = r4
            return
        L_0x0166:
            java.lang.String r0 = "Mandatory element SeekID or SeekPosition not found"
            r1 = 0
            com.google.android.gms.internal.ads.zzch r0 = com.google.android.gms.internal.ads.zzch.zza(r0, r1)
            throw r0
        L_0x016e:
            r5 = r10
            com.google.android.gms.internal.ads.zzaix r2 = r7.zzC
            com.google.android.gms.internal.ads.zzeq.zzb(r2)
            java.lang.String r3 = r2.zzb
            if (r3 == 0) goto L_0x030f
            int r6 = r3.hashCode()
            switch(r6) {
                case -2095576542: goto L_0x02ee;
                case -2095575984: goto L_0x02e4;
                case -1985379776: goto L_0x02d9;
                case -1784763192: goto L_0x02ce;
                case -1730367663: goto L_0x02c3;
                case -1482641358: goto L_0x02b8;
                case -1482641357: goto L_0x02ad;
                case -1373388978: goto L_0x02a2;
                case -933872740: goto L_0x0297;
                case -538363189: goto L_0x028c;
                case -538363109: goto L_0x0281;
                case -425012669: goto L_0x0275;
                case -356037306: goto L_0x0269;
                case 62923557: goto L_0x025d;
                case 62923603: goto L_0x0251;
                case 62927045: goto L_0x0245;
                case 82318131: goto L_0x023a;
                case 82338133: goto L_0x022f;
                case 82338134: goto L_0x0224;
                case 99146302: goto L_0x0218;
                case 444813526: goto L_0x020c;
                case 542569478: goto L_0x0200;
                case 635596514: goto L_0x01f4;
                case 725948237: goto L_0x01e8;
                case 725957860: goto L_0x01dc;
                case 738597099: goto L_0x01d0;
                case 855502857: goto L_0x01c6;
                case 1045209816: goto L_0x01ba;
                case 1422270023: goto L_0x01ae;
                case 1809237540: goto L_0x01a3;
                case 1950749482: goto L_0x0197;
                case 1950789798: goto L_0x018b;
                case 1951062397: goto L_0x0181;
                default: goto L_0x017f;
            }
        L_0x017f:
            goto L_0x02f8
        L_0x0181:
            boolean r0 = r3.equals(r1)
            if (r0 == 0) goto L_0x02f8
            r0 = 11
            goto L_0x02f9
        L_0x018b:
            java.lang.String r0 = "A_FLAC"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x02f8
            r0 = 22
            goto L_0x02f9
        L_0x0197:
            java.lang.String r0 = "A_EAC3"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x02f8
            r0 = 17
            goto L_0x02f9
        L_0x01a3:
            java.lang.String r0 = "V_MPEG2"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x02f8
            r0 = 3
            goto L_0x02f9
        L_0x01ae:
            java.lang.String r0 = "S_TEXT/UTF8"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x02f8
            r0 = 27
            goto L_0x02f9
        L_0x01ba:
            java.lang.String r0 = "S_TEXT/WEBVTT"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x02f8
            r0 = 29
            goto L_0x02f9
        L_0x01c6:
            java.lang.String r1 = "V_MPEGH/ISO/HEVC"
            boolean r1 = r3.equals(r1)
            if (r1 == 0) goto L_0x02f8
            goto L_0x02f9
        L_0x01d0:
            java.lang.String r0 = "S_TEXT/ASS"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x02f8
            r0 = 28
            goto L_0x02f9
        L_0x01dc:
            java.lang.String r0 = "A_PCM/INT/LIT"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x02f8
            r0 = 24
            goto L_0x02f9
        L_0x01e8:
            java.lang.String r0 = "A_PCM/INT/BIG"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x02f8
            r0 = 25
            goto L_0x02f9
        L_0x01f4:
            java.lang.String r0 = "A_PCM/FLOAT/IEEE"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x02f8
            r0 = 26
            goto L_0x02f9
        L_0x0200:
            java.lang.String r0 = "A_DTS/EXPRESS"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x02f8
            r0 = 20
            goto L_0x02f9
        L_0x020c:
            java.lang.String r0 = "V_THEORA"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x02f8
            r0 = 10
            goto L_0x02f9
        L_0x0218:
            java.lang.String r0 = "S_HDMV/PGS"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x02f8
            r0 = 31
            goto L_0x02f9
        L_0x0224:
            java.lang.String r0 = "V_VP9"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x02f8
            r0 = 1
            goto L_0x02f9
        L_0x022f:
            java.lang.String r0 = "V_VP8"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x02f8
            r0 = 0
            goto L_0x02f9
        L_0x023a:
            java.lang.String r0 = "V_AV1"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x02f8
            r0 = r4
            goto L_0x02f9
        L_0x0245:
            java.lang.String r0 = "A_DTS"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x02f8
            r0 = 19
            goto L_0x02f9
        L_0x0251:
            java.lang.String r0 = "A_AC3"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x02f8
            r0 = 16
            goto L_0x02f9
        L_0x025d:
            java.lang.String r0 = "A_AAC"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x02f8
            r0 = 13
            goto L_0x02f9
        L_0x0269:
            java.lang.String r0 = "A_DTS/LOSSLESS"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x02f8
            r0 = 21
            goto L_0x02f9
        L_0x0275:
            java.lang.String r0 = "S_VOBSUB"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x02f8
            r0 = 30
            goto L_0x02f9
        L_0x0281:
            java.lang.String r0 = "V_MPEG4/ISO/AVC"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x02f8
            r0 = 7
            goto L_0x02f9
        L_0x028c:
            java.lang.String r0 = "V_MPEG4/ISO/ASP"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x02f8
            r0 = 5
            goto L_0x02f9
        L_0x0297:
            java.lang.String r0 = "S_DVBSUB"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x02f8
            r0 = 32
            goto L_0x02f9
        L_0x02a2:
            java.lang.String r0 = "V_MS/VFW/FOURCC"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x02f8
            r0 = 9
            goto L_0x02f9
        L_0x02ad:
            java.lang.String r0 = "A_MPEG/L3"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x02f8
            r0 = 15
            goto L_0x02f9
        L_0x02b8:
            java.lang.String r0 = "A_MPEG/L2"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x02f8
            r0 = 14
            goto L_0x02f9
        L_0x02c3:
            java.lang.String r0 = "A_VORBIS"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x02f8
            r0 = 12
            goto L_0x02f9
        L_0x02ce:
            java.lang.String r0 = "A_TRUEHD"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x02f8
            r0 = 18
            goto L_0x02f9
        L_0x02d9:
            java.lang.String r0 = "A_MS/ACM"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x02f8
            r0 = 23
            goto L_0x02f9
        L_0x02e4:
            java.lang.String r0 = "V_MPEG4/ISO/SP"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x02f8
            r0 = 4
            goto L_0x02f9
        L_0x02ee:
            java.lang.String r0 = "V_MPEG4/ISO/AP"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x02f8
            r0 = 6
            goto L_0x02f9
        L_0x02f8:
            r0 = r5
        L_0x02f9:
            switch(r0) {
                case 0: goto L_0x02fd;
                case 1: goto L_0x02fd;
                case 2: goto L_0x02fd;
                case 3: goto L_0x02fd;
                case 4: goto L_0x02fd;
                case 5: goto L_0x02fd;
                case 6: goto L_0x02fd;
                case 7: goto L_0x02fd;
                case 8: goto L_0x02fd;
                case 9: goto L_0x02fd;
                case 10: goto L_0x02fd;
                case 11: goto L_0x02fd;
                case 12: goto L_0x02fd;
                case 13: goto L_0x02fd;
                case 14: goto L_0x02fd;
                case 15: goto L_0x02fd;
                case 16: goto L_0x02fd;
                case 17: goto L_0x02fd;
                case 18: goto L_0x02fd;
                case 19: goto L_0x02fd;
                case 20: goto L_0x02fd;
                case 21: goto L_0x02fd;
                case 22: goto L_0x02fd;
                case 23: goto L_0x02fd;
                case 24: goto L_0x02fd;
                case 25: goto L_0x02fd;
                case 26: goto L_0x02fd;
                case 27: goto L_0x02fd;
                case 28: goto L_0x02fd;
                case 29: goto L_0x02fd;
                case 30: goto L_0x02fd;
                case 31: goto L_0x02fd;
                case 32: goto L_0x02fd;
                default: goto L_0x02fc;
            }
        L_0x02fc:
            goto L_0x030b
        L_0x02fd:
            com.google.android.gms.internal.ads.zzadx r0 = r7.zzaj
            int r1 = r2.zzc
            r2.zze(r0, r1)
            android.util.SparseArray r0 = r7.zzj
            int r1 = r2.zzc
            r0.put(r1, r2)
        L_0x030b:
            r0 = 0
            r7.zzC = r0
            return
        L_0x030f:
            r0 = 0
            java.lang.String r1 = "CodecId is missing in TrackEntry element"
            com.google.android.gms.internal.ads.zzch r0 = com.google.android.gms.internal.ads.zzch.zza(r1, r0)
            throw r0
        L_0x0317:
            int r2 = r7.zzO
            if (r2 != r4) goto L_0x0399
            android.util.SparseArray r2 = r7.zzj
            int r3 = r7.zzU
            java.lang.Object r2 = r2.get(r3)
            r8 = r2
            com.google.android.gms.internal.ads.zzaix r8 = (com.google.android.gms.internal.ads.zzaix) r8
            com.google.android.gms.internal.ads.zzaix.zzd(r8)
            long r2 = r7.zzZ
            int r2 = (r2 > r5 ? 1 : (r2 == r5 ? 0 : -1))
            if (r2 <= 0) goto L_0x0354
            java.lang.String r2 = r8.zzb
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0354
            com.google.android.gms.internal.ads.zzfu r1 = r7.zzv
            java.nio.ByteBuffer r0 = java.nio.ByteBuffer.allocate(r0)
            java.nio.ByteOrder r2 = java.nio.ByteOrder.LITTLE_ENDIAN
            java.nio.ByteBuffer r0 = r0.order(r2)
            long r2 = r7.zzZ
            java.nio.ByteBuffer r0 = r0.putLong(r2)
            byte[] r0 = r0.array()
            int r2 = r0.length
            r1.zzI(r0, r2)
            r0 = 0
            r4 = 0
            goto L_0x0356
        L_0x0354:
            r0 = 0
            r4 = 0
        L_0x0356:
            int r1 = r7.zzS
            if (r4 >= r1) goto L_0x0362
            int[] r1 = r7.zzT
            r1 = r1[r4]
            int r0 = r0 + r1
            int r4 = r4 + 1
            goto L_0x0356
        L_0x0362:
            r4 = 0
        L_0x0363:
            int r1 = r7.zzS
            if (r4 >= r1) goto L_0x0395
            long r1 = r7.zzP
            int r3 = r8.zze
            int r3 = r3 * r4
            int r3 = r3 / 1000
            long r5 = (long) r3
            long r2 = r1 + r5
            int r1 = r7.zzW
            if (r4 != 0) goto L_0x0381
            boolean r4 = r7.zzY
            if (r4 != 0) goto L_0x037e
            r1 = r1 | 1
            r4 = r1
            r9 = 0
            goto L_0x0383
        L_0x037e:
            r4 = r1
            r9 = 0
            goto L_0x0383
        L_0x0381:
            r9 = r4
            r4 = r1
        L_0x0383:
            int[] r1 = r7.zzT
            r5 = r1[r9]
            int r10 = r0 - r5
            r0 = r21
            r1 = r8
            r6 = r10
            r0.zzt(r1, r2, r4, r5, r6)
            r0 = 1
            int r4 = r9 + 1
            r0 = r10
            goto L_0x0363
        L_0x0395:
            r0 = 0
            r7.zzO = r0
            return
        L_0x0399:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaiy.zzi(int):void");
    }

    /* access modifiers changed from: protected */
    public final void zzj(int i, double d) throws zzch {
        switch (i) {
            case 181:
                zzs(i);
                this.zzC.zzQ = (int) d;
                return;
            case 17545:
                this.zzA = (long) d;
                return;
            case 21969:
                zzs(i);
                this.zzC.zzD = (float) d;
                return;
            case 21970:
                zzs(i);
                this.zzC.zzE = (float) d;
                return;
            case 21971:
                zzs(i);
                this.zzC.zzF = (float) d;
                return;
            case 21972:
                zzs(i);
                this.zzC.zzG = (float) d;
                return;
            case 21973:
                zzs(i);
                this.zzC.zzH = (float) d;
                return;
            case 21974:
                zzs(i);
                this.zzC.zzI = (float) d;
                return;
            case 21975:
                zzs(i);
                this.zzC.zzJ = (float) d;
                return;
            case 21976:
                zzs(i);
                this.zzC.zzK = (float) d;
                return;
            case 21977:
                zzs(i);
                this.zzC.zzL = (float) d;
                return;
            case 21978:
                zzs(i);
                this.zzC.zzM = (float) d;
                return;
            case 30323:
                zzs(i);
                this.zzC.zzs = (float) d;
                return;
            case 30324:
                zzs(i);
                this.zzC.zzt = (float) d;
                return;
            case 30325:
                zzs(i);
                this.zzC.zzu = (float) d;
                return;
            default:
                return;
        }
    }

    /* access modifiers changed from: protected */
    public final void zzl(int i, long j, long j2) throws zzch {
        zzeq.zzb(this.zzaj);
        switch (i) {
            case 160:
                this.zzY = false;
                this.zzZ = 0;
                return;
            case 174:
                this.zzC = new zzaix();
                return;
            case 187:
                this.zzM = false;
                return;
            case 19899:
                this.zzE = -1;
                this.zzF = -1;
                return;
            case 20533:
                zzs(i);
                this.zzC.zzg = true;
                return;
            case 21968:
                zzs(i);
                this.zzC.zzx = true;
                return;
            case 408125543:
                long j3 = this.zzy;
                if (j3 == -1 || j3 == j) {
                    this.zzy = j;
                    this.zzx = j2;
                    return;
                }
                throw zzch.zza("Multiple Segment elements not supported", (Throwable) null);
            case 475249515:
                this.zzK = new zzfl(32);
                this.zzL = new zzfl(32);
                return;
            case 524531317:
                if (this.zzD) {
                    return;
                }
                if (!this.zzk || this.zzH == -1) {
                    this.zzaj.zzO(new zzaes(this.zzB, 0));
                    this.zzD = true;
                    return;
                }
                this.zzG = true;
                return;
            default:
                return;
        }
    }

    zzaiy(zzait zzait, int i, zzalt zzalt) {
        this.zzy = -1;
        this.zzz = -9223372036854775807L;
        this.zzA = -9223372036854775807L;
        this.zzB = -9223372036854775807L;
        this.zzH = -1;
        this.zzI = -1;
        this.zzJ = -9223372036854775807L;
        this.zzh = zzait;
        this.zzh.zza(new zzaiw(this, (zzaiv) null));
        this.zzl = zzalt;
        this.zzk = true;
        this.zzi = new zzaja();
        this.zzj = new SparseArray();
        this.zzo = new zzfu(4);
        this.zzp = new zzfu(ByteBuffer.allocate(4).putInt(-1).array());
        this.zzq = new zzfu(4);
        this.zzm = new zzfu(zzgr.zza);
        this.zzn = new zzfu(4);
        this.zzr = new zzfu();
        this.zzs = new zzfu();
        this.zzt = new zzfu(8);
        this.zzu = new zzfu();
        this.zzv = new zzfu();
        this.zzT = new int[1];
    }

    /* access modifiers changed from: protected */
    public final void zzm(int i, String str) throws zzch {
        switch (i) {
            case 134:
                zzs(i);
                this.zzC.zzb = str;
                return;
            case FirebaseError.ERROR_WEAK_PASSWORD /*17026*/:
                if (!"webm".equals(str) && !"matroska".equals(str)) {
                    throw zzch.zza("DocType " + str + " not supported", (Throwable) null);
                }
                return;
            case 21358:
                zzs(i);
                this.zzC.zza = str;
                return;
            case 2274716:
                zzs(i);
                this.zzC.zzZ = str;
                return;
            default:
                return;
        }
    }

    public zzaiy(zzalt zzalt, int i) {
        this(new zzair(), 2, zzalt);
    }

    /* access modifiers changed from: protected */
    public final void zzk(int i, long j) throws zzch {
        boolean z = false;
        switch (i) {
            case 131:
                zzs(i);
                this.zzC.zzd = (int) j;
                return;
            case 136:
                if (j == 1) {
                    z = true;
                }
                zzs(i);
                this.zzC.zzV = z;
                return;
            case 155:
                this.zzQ = zzq(j);
                return;
            case 159:
                zzs(i);
                this.zzC.zzO = (int) j;
                return;
            case 176:
                zzs(i);
                this.zzC.zzl = (int) j;
                return;
            case 179:
                zzr(i);
                this.zzK.zzc(zzq(j));
                return;
            case 186:
                zzs(i);
                this.zzC.zzm = (int) j;
                return;
            case 215:
                zzs(i);
                this.zzC.zzc = (int) j;
                return;
            case 231:
                this.zzJ = zzq(j);
                return;
            case 238:
                this.zzX = (int) j;
                return;
            case 241:
                if (!this.zzM) {
                    zzr(i);
                    this.zzL.zzc(j);
                    this.zzM = true;
                    return;
                }
                return;
            case 251:
                this.zzY = true;
                return;
            case 16871:
                zzs(i);
                this.zzC.zzY = (int) j;
                return;
            case 16980:
                if (j != 3) {
                    throw zzch.zza("ContentCompAlgo " + j + " not supported", (Throwable) null);
                }
                return;
            case 17029:
                if (j < 1 || j > 2) {
                    throw zzch.zza("DocTypeReadVersion " + j + " not supported", (Throwable) null);
                }
                return;
            case 17143:
                if (j != 1) {
                    throw zzch.zza("EBMLReadVersion " + j + " not supported", (Throwable) null);
                }
                return;
            case 18401:
                if (j != 5) {
                    throw zzch.zza("ContentEncAlgo " + j + " not supported", (Throwable) null);
                }
                return;
            case 18408:
                if (j != 1) {
                    throw zzch.zza("AESSettingsCipherMode " + j + " not supported", (Throwable) null);
                }
                return;
            case 20529:
                if (j != 0) {
                    throw zzch.zza("ContentEncodingOrder " + j + " not supported", (Throwable) null);
                }
                return;
            case 20530:
                if (j != 1) {
                    throw zzch.zza("ContentEncodingScope " + j + " not supported", (Throwable) null);
                }
                return;
            case 21420:
                this.zzF = j + this.zzy;
                return;
            case 21432:
                int i2 = (int) j;
                zzs(i);
                switch (i2) {
                    case 0:
                        this.zzC.zzw = 0;
                        return;
                    case 1:
                        this.zzC.zzw = 2;
                        return;
                    case 3:
                        this.zzC.zzw = 1;
                        return;
                    case 15:
                        this.zzC.zzw = 3;
                        return;
                    default:
                        return;
                }
            case 21680:
                zzs(i);
                this.zzC.zzo = (int) j;
                return;
            case 21682:
                zzs(i);
                this.zzC.zzq = (int) j;
                return;
            case 21690:
                zzs(i);
                this.zzC.zzp = (int) j;
                return;
            case 21930:
                if (j == 1) {
                    z = true;
                }
                zzs(i);
                this.zzC.zzU = z;
                return;
            case 21938:
                zzs(i);
                zzaix zzaix = this.zzC;
                zzaix.zzx = true;
                zzaix.zzn = (int) j;
                return;
            case 21945:
                int i3 = (int) j;
                zzs(i);
                switch (i3) {
                    case 1:
                        this.zzC.zzA = 2;
                        return;
                    case 2:
                        this.zzC.zzA = 1;
                        return;
                    default:
                        return;
                }
            case 21946:
                zzs(i);
                int zzb2 = zzt.zzb((int) j);
                if (zzb2 != -1) {
                    this.zzC.zzz = zzb2;
                    return;
                }
                return;
            case 21947:
                zzs(i);
                this.zzC.zzx = true;
                int zza2 = zzt.zza((int) j);
                if (zza2 != -1) {
                    this.zzC.zzy = zza2;
                    return;
                }
                return;
            case 21948:
                zzs(i);
                this.zzC.zzB = (int) j;
                return;
            case 21949:
                zzs(i);
                this.zzC.zzC = (int) j;
                return;
            case 21998:
                zzs(i);
                this.zzC.zzf = (int) j;
                return;
            case 22186:
                zzs(i);
                this.zzC.zzR = j;
                return;
            case 22203:
                zzs(i);
                this.zzC.zzS = j;
                return;
            case 25188:
                zzs(i);
                this.zzC.zzP = (int) j;
                return;
            case 30114:
                this.zzZ = j;
                return;
            case 30321:
                int i4 = (int) j;
                zzs(i);
                switch (i4) {
                    case 0:
                        this.zzC.zzr = 0;
                        return;
                    case 1:
                        this.zzC.zzr = 1;
                        return;
                    case 2:
                        this.zzC.zzr = 2;
                        return;
                    case 3:
                        this.zzC.zzr = 3;
                        return;
                    default:
                        return;
                }
            case 2352003:
                zzs(i);
                this.zzC.zze = (int) j;
                return;
            case 2807729:
                this.zzz = j;
                return;
            default:
                return;
        }
    }
}
