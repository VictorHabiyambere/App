package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzakj implements zzadu, zzaet {
    @Deprecated
    public static final zzaea zza = new zzakh();
    private int zzA;
    private zzaie zzB;
    private final zzalt zzb;
    private final int zzc;
    private final zzfu zzd;
    private final zzfu zze;
    private final zzfu zzf;
    private final zzfu zzg;
    private final ArrayDeque zzh;
    private final zzakn zzi;
    private final List zzj;
    private zzgbc zzk;
    private int zzl;
    private int zzm;
    private long zzn;
    private int zzo;
    private zzfu zzp;
    private int zzq;
    private int zzr;
    private int zzs;
    private int zzt;
    private boolean zzu;
    private zzadx zzv;
    private zzaki[] zzw;
    private long[][] zzx;
    private int zzy;
    private long zzz;

    @Deprecated
    public zzakj() {
        this(zzalt.zza, 16);
    }

    private static int zzi(int i) {
        switch (i) {
            case 1751476579:
                return 2;
            case 1903435808:
                return 1;
            default:
                return 0;
        }
    }

    private static int zzj(zzaks zzaks, long j) {
        int zza2 = zzaks.zza(j);
        return zza2 == -1 ? zzaks.zzb(j) : zza2;
    }

    private static long zzk(zzaks zzaks, long j, long j2) {
        int zzj2 = zzj(zzaks, j);
        if (zzj2 == -1) {
            return j2;
        }
        return Math.min(zzaks.zzc[zzj2], j2);
    }

    private final void zzl() {
        this.zzl = 0;
        this.zzo = 0;
    }

    private final void zzm(long j) throws zzch {
        zzcd zzcd;
        zzcd zzcd2;
        long j2;
        List list;
        int i;
        zzcd zzcd3;
        int i2;
        int i3;
        int i4;
        while (!this.zzh.isEmpty() && ((zzajm) this.zzh.peek()).zza == j) {
            zzajm zzajm = (zzajm) this.zzh.pop();
            if (zzajm.zzd == 1836019574) {
                ArrayList arrayList = new ArrayList();
                int i5 = this.zzA;
                zzaej zzaej = new zzaej();
                zzajn zzb2 = zzajm.zzb(1969517665);
                if (zzb2 != null) {
                    zzcd zzb3 = zzajw.zzb(zzb2);
                    zzaej.zzb(zzb3);
                    zzcd = zzb3;
                } else {
                    zzcd = null;
                }
                zzajm zza2 = zzajm.zza(1835365473);
                if (zza2 != null) {
                    zzcd2 = zzajw.zza(zza2);
                } else {
                    zzcd2 = null;
                }
                zzcc[] zzccArr = new zzcc[1];
                zzajn zzb4 = zzajm.zzb(1836476516);
                if (zzb4 != null) {
                    boolean z = i5 == 1;
                    zzccArr[0] = zzajw.zzc(zzb4.zza);
                    zzcd zzcd4 = new zzcd(-9223372036854775807L, zzccArr);
                    zzcd zzcd5 = zzcd;
                    long j3 = -9223372036854775807L;
                    List zzd2 = zzajw.zzd(zzajm, zzaej, -9223372036854775807L, (zzae) null, 1 == (this.zzc & 1), z, new zzakg());
                    long j4 = -9223372036854775807L;
                    int i6 = 0;
                    int i7 = -1;
                    int i8 = 0;
                    while (true) {
                        j2 = 0;
                        if (i8 >= zzd2.size()) {
                            break;
                        }
                        zzaks zzaks = (zzaks) zzd2.get(i8);
                        if (zzaks.zzb == 0) {
                            list = zzd2;
                        } else {
                            zzakp zzakp = zzaks.zza;
                            list = zzd2;
                            long j5 = zzakp.zze;
                            if (j5 == j3) {
                                j5 = zzaks.zzh;
                            }
                            int i9 = i6 + 1;
                            long max = Math.max(j4, j5);
                            zzaki zzaki = new zzaki(zzakp, zzaks, this.zzv.zzw(i6, zzakp.zzb));
                            if ("audio/true-hd".equals(zzakp.zzf.zzn)) {
                                i = zzaks.zze * 16;
                            } else {
                                i = zzaks.zze + 30;
                            }
                            zzal zzb5 = zzakp.zzf.zzb();
                            zzb5.zzP(i);
                            if (zzakp.zzb == 2) {
                                if ((this.zzc & 8) != 0) {
                                    zzan zzan = zzakp.zzf;
                                    if (i7 == -1) {
                                        i4 = 1;
                                    } else {
                                        i4 = 2;
                                    }
                                    zzb5.zzV(zzan.zzg | i4);
                                }
                                if (j5 > 0 && (i3 = zzaks.zzb) > 0) {
                                    zzb5.zzH(((float) i3) / (((float) j5) / 1000000.0f));
                                }
                            }
                            int i10 = zzakp.zzb;
                            int i11 = zzakf.zzb;
                            if (i10 == 1 && zzaej.zza()) {
                                zzb5.zzF(zzaej.zza);
                                zzb5.zzG(zzaej.zzb);
                            }
                            int i12 = zzakp.zzb;
                            zzcd[] zzcdArr = new zzcd[3];
                            if (this.zzj.isEmpty()) {
                                zzcd3 = null;
                            } else {
                                zzcd3 = new zzcd(this.zzj);
                            }
                            zzcdArr[0] = zzcd3;
                            zzcdArr[1] = zzcd5;
                            zzcdArr[2] = zzcd4;
                            int i13 = i7;
                            zzcd zzcd6 = new zzcd(-9223372036854775807L, new zzcc[0]);
                            if (zzcd2 != null) {
                                for (int i14 = 0; i14 < zzcd2.zza(); i14++) {
                                    zzcc zzb6 = zzcd2.zzb(i14);
                                    if (zzb6 instanceof zzgh) {
                                        zzgh zzgh = (zzgh) zzb6;
                                        if (!zzgh.zza.equals("com.android.capture.fps")) {
                                            zzcd6 = zzcd6.zzc(zzgh);
                                        } else if (i12 == 2) {
                                            zzcd6 = zzcd6.zzc(zzgh);
                                        }
                                    }
                                }
                            }
                            for (int i15 = 0; i15 < 3; i15++) {
                                zzcd6 = zzcd6.zzd(zzcdArr[i15]);
                            }
                            if (zzcd6.zza() > 0) {
                                zzb5.zzQ(zzcd6);
                            }
                            zzaki.zzc.zzl(zzb5.zzad());
                            if (zzakp.zzb == 2) {
                                i2 = i13;
                                if (i2 == -1) {
                                    i7 = arrayList.size();
                                    arrayList.add(zzaki);
                                    i6 = i9;
                                    j4 = max;
                                }
                            } else {
                                i2 = i13;
                            }
                            i7 = i2;
                            arrayList.add(zzaki);
                            i6 = i9;
                            j4 = max;
                        }
                        i8++;
                        zzd2 = list;
                        j3 = -9223372036854775807L;
                    }
                    this.zzy = i7;
                    this.zzz = j4;
                    this.zzw = (zzaki[]) arrayList.toArray(new zzaki[0]);
                    zzaki[] zzakiArr = this.zzw;
                    int length = zzakiArr.length;
                    long[][] jArr = new long[length][];
                    int[] iArr = new int[length];
                    long[] jArr2 = new long[length];
                    boolean[] zArr = new boolean[length];
                    for (int i16 = 0; i16 < zzakiArr.length; i16++) {
                        jArr[i16] = new long[zzakiArr[i16].zzb.zzb];
                        jArr2[i16] = zzakiArr[i16].zzb.zzf[0];
                    }
                    int i17 = 0;
                    while (i17 < zzakiArr.length) {
                        int i18 = -1;
                        long j6 = Long.MAX_VALUE;
                        for (int i19 = 0; i19 < zzakiArr.length; i19++) {
                            if (!zArr[i19]) {
                                long j7 = jArr2[i19];
                                if (j7 <= j6) {
                                    i18 = i19;
                                    j6 = j7;
                                }
                            }
                        }
                        int i20 = iArr[i18];
                        long[] jArr3 = jArr[i18];
                        jArr3[i20] = j2;
                        zzaks zzaks2 = zzakiArr[i18].zzb;
                        j2 += (long) zzaks2.zzd[i20];
                        int i21 = i20 + 1;
                        iArr[i18] = i21;
                        if (i21 < jArr3.length) {
                            jArr2[i18] = zzaks2.zzf[i21];
                        } else {
                            zArr[i18] = true;
                            i17++;
                        }
                    }
                    this.zzx = jArr;
                    this.zzv.zzD();
                    this.zzv.zzO(this);
                    this.zzh.clear();
                    this.zzl = 2;
                } else {
                    throw null;
                }
            } else if (!this.zzh.isEmpty()) {
                ((zzajm) this.zzh.peek()).zzc(zzajm);
            }
        }
        if (this.zzl != 2) {
            zzl();
        }
    }

    public final long zza() {
        return this.zzz;
    }

    public final /* synthetic */ List zzc() {
        return this.zzk;
    }

    public final void zzd(zzadx zzadx) {
        if ((this.zzc & 16) == 0) {
            zzadx = new zzalw(zzadx, this.zzb);
        }
        this.zzv = zzadx;
    }

    public final void zze(long j, long j2) {
        this.zzh.clear();
        this.zzo = 0;
        this.zzq = -1;
        this.zzr = 0;
        this.zzs = 0;
        this.zzt = 0;
        if (j != 0) {
            for (zzaki zzaki : this.zzw) {
                zzaks zzaks = zzaki.zzb;
                int zza2 = zzaks.zza(j2);
                if (zza2 == -1) {
                    zza2 = zzaks.zzb(j2);
                }
                zzaki.zze = zza2;
                zzafb zzafb = zzaki.zzd;
                if (zzafb != null) {
                    zzafb.zzb();
                }
            }
        } else if (this.zzl != 3) {
            zzl();
        } else {
            this.zzi.zzb();
            this.zzj.clear();
        }
    }

    public final boolean zzf(zzadv zzadv) throws IOException {
        boolean z;
        if ((this.zzc & 2) != 0) {
            z = true;
        } else {
            z = false;
        }
        zzaex zzb2 = zzako.zzb(zzadv, z);
        this.zzk = zzb2 != null ? zzgbc.zzn(zzb2) : zzgbc.zzm();
        return zzb2 == null;
    }

    public final zzaer zzg(long j) {
        long j2;
        long j3;
        int zzb2;
        zzaki[] zzakiArr = this.zzw;
        if (zzakiArr.length == 0) {
            zzaeu zzaeu = zzaeu.zza;
            return new zzaer(zzaeu, zzaeu);
        }
        int i = this.zzy;
        long j4 = -1;
        if (i != -1) {
            zzaks zzaks = zzakiArr[i].zzb;
            int zzj2 = zzj(zzaks, j);
            if (zzj2 == -1) {
                zzaeu zzaeu2 = zzaeu.zza;
                return new zzaer(zzaeu2, zzaeu2);
            }
            long j5 = zzaks.zzf[zzj2];
            j2 = zzaks.zzc[zzj2];
            if (j5 >= j || zzj2 >= zzaks.zzb - 1 || (zzb2 = zzaks.zzb(j)) == -1 || zzb2 == zzj2) {
                j3 = -9223372036854775807L;
            } else {
                j3 = zzaks.zzf[zzb2];
                j4 = zzaks.zzc[zzb2];
            }
            j = j5;
        } else {
            j2 = Long.MAX_VALUE;
            j3 = -9223372036854775807L;
        }
        int i2 = 0;
        while (true) {
            zzaki[] zzakiArr2 = this.zzw;
            if (i2 >= zzakiArr2.length) {
                break;
            }
            if (i2 != this.zzy) {
                zzaks zzaks2 = zzakiArr2[i2].zzb;
                long zzk2 = zzk(zzaks2, j, j2);
                if (j3 != -9223372036854775807L) {
                    j4 = zzk(zzaks2, j3, j4);
                }
                j2 = zzk2;
            }
            i2++;
        }
        zzaeu zzaeu3 = new zzaeu(j, j2);
        if (j3 == -9223372036854775807L) {
            return new zzaer(zzaeu3, zzaeu3);
        }
        return new zzaer(zzaeu3, new zzaeu(j3, j4));
    }

    public final boolean zzh() {
        return true;
    }

    public zzakj(zzalt zzalt, int i) {
        int i2;
        this.zzb = zzalt;
        this.zzc = i;
        this.zzk = zzgbc.zzm();
        if ((i & 4) != 0) {
            i2 = 3;
        } else {
            i2 = 0;
        }
        this.zzl = i2;
        this.zzi = new zzakn();
        this.zzj = new ArrayList();
        this.zzg = new zzfu(16);
        this.zzh = new ArrayDeque();
        this.zzd = new zzfu(zzgr.zza);
        this.zze = new zzfu(4);
        this.zzf = new zzfu();
        this.zzq = -1;
        this.zzv = zzadx.zza;
        this.zzw = new zzaki[0];
    }

    /* JADX WARNING: Removed duplicated region for block: B:226:0x0091 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x008b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int zzb(com.google.android.gms.internal.ads.zzadv r31, com.google.android.gms.internal.ads.zzaeq r32) throws java.io.IOException {
        /*
            r30 = this;
            r0 = r30
            r1 = r31
            r2 = r32
        L_0x0006:
            int r3 = r0.zzl
            r4 = 1718909296(0x66747970, float:2.8862439E23)
            r5 = 262144(0x40000, double:1.295163E-318)
            r10 = 0
            r12 = -1
            r13 = 8
            switch(r3) {
                case 0: goto L_0x0275;
                case 1: goto L_0x01df;
                case 2: goto L_0x0028;
                default: goto L_0x0016;
            }
        L_0x0016:
            com.google.android.gms.internal.ads.zzakn r3 = r0.zzi
            java.util.List r4 = r0.zzj
            r3.zza(r1, r2, r4)
            long r1 = r2.zza
            int r1 = (r1 > r10 ? 1 : (r1 == r10 ? 0 : -1))
            if (r1 != 0) goto L_0x0472
            r30.zzl()
            goto L_0x0472
        L_0x0028:
            long r3 = r31.zzf()
            int r13 = r0.zzq
            if (r13 != r12) goto L_0x00ae
            r16 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            r25 = r12
            r26 = r25
            r18 = r16
            r21 = r18
            r23 = r21
            r13 = 0
            r20 = 1
            r27 = 1
        L_0x0044:
            com.google.android.gms.internal.ads.zzaki[] r7 = r0.zzw
            int r9 = r7.length
            if (r13 >= r9) goto L_0x0094
            r7 = r7[r13]
            int r9 = r7.zze
            com.google.android.gms.internal.ads.zzaks r7 = r7.zzb
            int r8 = r7.zzb
            if (r9 != r8) goto L_0x0054
            goto L_0x0091
        L_0x0054:
            long[] r7 = r7.zzc
            r28 = r7[r9]
            long[][] r7 = r0.zzx
            int r8 = com.google.android.gms.internal.ads.zzgd.zza
            r7 = r7[r13]
            r8 = r7[r9]
            long r28 = r28 - r3
            int r7 = (r28 > r10 ? 1 : (r28 == r10 ? 0 : -1))
            if (r7 < 0) goto L_0x006d
            int r7 = (r28 > r5 ? 1 : (r28 == r5 ? 0 : -1))
            if (r7 < 0) goto L_0x006b
            goto L_0x006d
        L_0x006b:
            r7 = 0
            goto L_0x006e
        L_0x006d:
            r7 = 1
        L_0x006e:
            if (r7 != 0) goto L_0x0074
            if (r27 != 0) goto L_0x007c
            r15 = 0
            goto L_0x0076
        L_0x0074:
            r15 = r27
        L_0x0076:
            if (r7 != r15) goto L_0x0085
            int r27 = (r28 > r23 ? 1 : (r28 == r23 ? 0 : -1))
            if (r27 >= 0) goto L_0x0085
        L_0x007c:
            r27 = r7
            r21 = r8
            r26 = r13
            r23 = r28
            goto L_0x0087
        L_0x0085:
            r27 = r15
        L_0x0087:
            int r15 = (r8 > r18 ? 1 : (r8 == r18 ? 0 : -1))
            if (r15 >= 0) goto L_0x0091
            r20 = r7
            r18 = r8
            r25 = r13
        L_0x0091:
            int r13 = r13 + 1
            goto L_0x0044
        L_0x0094:
            int r7 = (r18 > r16 ? 1 : (r18 == r16 ? 0 : -1))
            if (r7 == 0) goto L_0x00a6
            if (r20 == 0) goto L_0x00a6
            r7 = 10485760(0xa00000, double:5.180654E-317)
            long r18 = r18 + r7
            int r7 = (r21 > r18 ? 1 : (r21 == r18 ? 0 : -1))
            if (r7 < 0) goto L_0x00a6
            r13 = r25
            goto L_0x00a8
        L_0x00a6:
            r13 = r26
        L_0x00a8:
            r0.zzq = r13
            if (r13 != r12) goto L_0x00ae
            goto L_0x01de
        L_0x00ae:
            com.google.android.gms.internal.ads.zzaki[] r7 = r0.zzw
            r7 = r7[r13]
            com.google.android.gms.internal.ads.zzafa r8 = r7.zzc
            int r9 = r7.zze
            com.google.android.gms.internal.ads.zzaks r13 = r7.zzb
            long[] r15 = r13.zzc
            r14 = r15[r9]
            int[] r13 = r13.zzd
            r13 = r13[r9]
            com.google.android.gms.internal.ads.zzafb r12 = r7.zzd
            long r3 = r14 - r3
            int r5 = r0.zzr
            long r5 = (long) r5
            long r3 = r3 + r5
            int r5 = (r3 > r10 ? 1 : (r3 == r10 ? 0 : -1))
            if (r5 < 0) goto L_0x01db
            r5 = 262144(0x40000, double:1.295163E-318)
            int r5 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r5 < 0) goto L_0x00d5
            goto L_0x01db
        L_0x00d5:
            com.google.android.gms.internal.ads.zzakp r2 = r7.zza
            int r2 = r2.zzg
            r5 = 1
            if (r2 != r5) goto L_0x00e2
            r5 = 8
            long r3 = r3 + r5
            int r13 = r13 + -8
            goto L_0x00e3
        L_0x00e2:
        L_0x00e3:
            int r2 = (int) r3
            r1.zzk(r2)
            com.google.android.gms.internal.ads.zzakp r2 = r7.zza
            int r3 = r2.zzj
            if (r3 == 0) goto L_0x014e
            com.google.android.gms.internal.ads.zzfu r2 = r0.zze
            byte[] r2 = r2.zzM()
            r4 = 0
            r2[r4] = r4
            r5 = 1
            r2[r5] = r4
            r5 = 2
            r2[r5] = r4
            int r4 = 4 - r3
        L_0x00fe:
            int r5 = r0.zzs
            if (r5 >= r13) goto L_0x0191
            int r5 = r0.zzt
            if (r5 != 0) goto L_0x0138
            r1.zzi(r2, r4, r3)
            int r5 = r0.zzr
            int r5 = r5 + r3
            r0.zzr = r5
            com.google.android.gms.internal.ads.zzfu r5 = r0.zze
            r6 = 0
            r5.zzK(r6)
            com.google.android.gms.internal.ads.zzfu r5 = r0.zze
            int r5 = r5.zzg()
            if (r5 < 0) goto L_0x0130
            r0.zzt = r5
            com.google.android.gms.internal.ads.zzfu r5 = r0.zzd
            r5.zzK(r6)
            com.google.android.gms.internal.ads.zzfu r5 = r0.zzd
            r6 = 4
            r8.zzq(r5, r6)
            int r5 = r0.zzs
            int r5 = r5 + r6
            r0.zzs = r5
            int r13 = r13 + r4
            goto L_0x00fe
        L_0x0130:
            java.lang.String r1 = "Invalid NAL length"
            r2 = 0
            com.google.android.gms.internal.ads.zzch r1 = com.google.android.gms.internal.ads.zzch.zza(r1, r2)
            throw r1
        L_0x0138:
            r6 = 0
            int r5 = r8.zzf(r1, r5, r6)
            int r6 = r0.zzr
            int r6 = r6 + r5
            r0.zzr = r6
            int r6 = r0.zzs
            int r6 = r6 + r5
            r0.zzs = r6
            int r6 = r0.zzt
            int r6 = r6 - r5
            r0.zzt = r6
            goto L_0x00fe
        L_0x014e:
            com.google.android.gms.internal.ads.zzan r2 = r2.zzf
            java.lang.String r2 = r2.zzn
            java.lang.String r3 = "audio/ac4"
            boolean r2 = r3.equals(r2)
            if (r2 == 0) goto L_0x0171
            int r2 = r0.zzs
            if (r2 != 0) goto L_0x016e
            com.google.android.gms.internal.ads.zzfu r2 = r0.zzf
            com.google.android.gms.internal.ads.zzacw.zzb(r13, r2)
            com.google.android.gms.internal.ads.zzfu r2 = r0.zzf
            r3 = 7
            r8.zzq(r2, r3)
            int r2 = r0.zzs
            int r2 = r2 + r3
            r0.zzs = r2
        L_0x016e:
            int r13 = r13 + 7
            goto L_0x0176
        L_0x0171:
            if (r12 == 0) goto L_0x0176
            r12.zzd(r1)
        L_0x0176:
            int r2 = r0.zzs
            if (r2 >= r13) goto L_0x0191
            int r2 = r13 - r2
            r3 = 0
            int r2 = r8.zzf(r1, r2, r3)
            int r3 = r0.zzr
            int r3 = r3 + r2
            r0.zzr = r3
            int r3 = r0.zzs
            int r3 = r3 + r2
            r0.zzs = r3
            int r3 = r0.zzt
            int r3 = r3 - r2
            r0.zzt = r3
            goto L_0x0176
        L_0x0191:
            com.google.android.gms.internal.ads.zzaks r1 = r7.zzb
            long[] r2 = r1.zzf
            r3 = r2[r9]
            int[] r1 = r1.zzg
            r1 = r1[r9]
            if (r12 == 0) goto L_0x01ba
            r21 = 0
            r22 = 0
            r15 = r12
            r16 = r8
            r17 = r3
            r19 = r1
            r20 = r13
            r15.zzc(r16, r17, r19, r20, r21, r22)
            r1 = 1
            int r9 = r9 + r1
            com.google.android.gms.internal.ads.zzaks r1 = r7.zzb
            int r1 = r1.zzb
            if (r9 != r1) goto L_0x01c9
            r1 = 0
            r12.zza(r8, r1)
            goto L_0x01c9
        L_0x01ba:
            r20 = 0
            r21 = 0
            r15 = r8
            r16 = r3
            r18 = r1
            r19 = r13
            r15.zzs(r16, r18, r19, r20, r21)
        L_0x01c9:
            int r1 = r7.zze
            r2 = 1
            int r1 = r1 + r2
            r7.zze = r1
            r1 = -1
            r0.zzq = r1
            r1 = 0
            r0.zzr = r1
            r0.zzs = r1
            r0.zzt = r1
            r12 = 0
            goto L_0x01de
        L_0x01db:
            r2.zza = r14
            r12 = 1
        L_0x01de:
            return r12
        L_0x01df:
            long r5 = r0.zzn
            int r3 = r0.zzo
            long r7 = (long) r3
            long r5 = r5 - r7
            long r7 = r31.zzf()
            long r7 = r7 + r5
            com.google.android.gms.internal.ads.zzfu r3 = r0.zzp
            if (r3 == 0) goto L_0x0246
            byte[] r9 = r3.zzM()
            int r10 = r0.zzo
            int r5 = (int) r5
            r1.zzi(r9, r10, r5)
            int r5 = r0.zzm
            if (r5 != r4) goto L_0x0228
            r4 = 1
            r0.zzu = r4
            r3.zzK(r13)
            int r4 = r3.zzg()
            int r4 = zzi(r4)
            if (r4 == 0) goto L_0x020d
            goto L_0x0224
        L_0x020d:
            r4 = 4
            r3.zzL(r4)
        L_0x0212:
            int r4 = r3.zzb()
            if (r4 <= 0) goto L_0x0223
            int r4 = r3.zzg()
            int r4 = zzi(r4)
            if (r4 == 0) goto L_0x0212
            goto L_0x0224
        L_0x0223:
            r4 = 0
        L_0x0224:
            r0.zzA = r4
            r15 = 0
            goto L_0x0269
        L_0x0228:
            java.util.ArrayDeque r4 = r0.zzh
            boolean r4 = r4.isEmpty()
            if (r4 != 0) goto L_0x0243
            java.util.ArrayDeque r4 = r0.zzh
            java.lang.Object r4 = r4.peek()
            com.google.android.gms.internal.ads.zzajm r4 = (com.google.android.gms.internal.ads.zzajm) r4
            com.google.android.gms.internal.ads.zzajn r5 = new com.google.android.gms.internal.ads.zzajn
            int r6 = r0.zzm
            r5.<init>(r6, r3)
            r4.zzd(r5)
            goto L_0x0244
        L_0x0243:
        L_0x0244:
            r15 = 0
            goto L_0x0269
        L_0x0246:
            boolean r3 = r0.zzu
            if (r3 != 0) goto L_0x0254
            int r3 = r0.zzm
            r4 = 1835295092(0x6d646174, float:4.4175247E27)
            if (r3 != r4) goto L_0x0254
            r3 = 1
            r0.zzA = r3
        L_0x0254:
            r3 = 262144(0x40000, double:1.295163E-318)
            int r3 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r3 >= 0) goto L_0x0261
            int r3 = (int) r5
            r1.zzk(r3)
            r15 = 0
            goto L_0x0269
        L_0x0261:
            long r3 = r31.zzf()
            long r3 = r3 + r5
            r2.zza = r3
            r15 = 1
        L_0x0269:
            r0.zzm(r7)
            if (r15 == 0) goto L_0x0006
            int r3 = r0.zzl
            r4 = 2
            if (r3 == r4) goto L_0x0006
            r1 = 1
            return r1
        L_0x0275:
            int r3 = r0.zzo
            if (r3 != 0) goto L_0x02e6
            com.google.android.gms.internal.ads.zzfu r3 = r0.zzg
            byte[] r3 = r3.zzM()
            r5 = 1
            r6 = 0
            boolean r3 = r1.zzn(r3, r6, r13, r5)
            if (r3 != 0) goto L_0x02ce
            int r1 = r0.zzA
            r2 = 2
            if (r1 != r2) goto L_0x02cc
            int r1 = r0.zzc
            r1 = r1 & r2
            if (r1 == 0) goto L_0x02cc
            com.google.android.gms.internal.ads.zzadx r1 = r0.zzv
            r2 = 4
            r3 = 0
            com.google.android.gms.internal.ads.zzafa r1 = r1.zzw(r3, r2)
            com.google.android.gms.internal.ads.zzaie r2 = r0.zzB
            r4 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            if (r2 != 0) goto L_0x02a4
            r7 = 0
            goto L_0x02ae
        L_0x02a4:
            com.google.android.gms.internal.ads.zzcd r7 = new com.google.android.gms.internal.ads.zzcd
            r6 = 1
            com.google.android.gms.internal.ads.zzcc[] r6 = new com.google.android.gms.internal.ads.zzcc[r6]
            r6[r3] = r2
            r7.<init>(r4, r6)
        L_0x02ae:
            com.google.android.gms.internal.ads.zzal r2 = new com.google.android.gms.internal.ads.zzal
            r2.<init>()
            r2.zzQ(r7)
            com.google.android.gms.internal.ads.zzan r2 = r2.zzad()
            r1.zzl(r2)
            com.google.android.gms.internal.ads.zzadx r1 = r0.zzv
            r1.zzD()
            com.google.android.gms.internal.ads.zzadx r1 = r0.zzv
            com.google.android.gms.internal.ads.zzaes r2 = new com.google.android.gms.internal.ads.zzaes
            r2.<init>(r4, r10)
            r1.zzO(r2)
        L_0x02cc:
            r1 = -1
            return r1
        L_0x02ce:
            r0.zzo = r13
            com.google.android.gms.internal.ads.zzfu r3 = r0.zzg
            r5 = 0
            r3.zzK(r5)
            com.google.android.gms.internal.ads.zzfu r3 = r0.zzg
            long r5 = r3.zzu()
            r0.zzn = r5
            com.google.android.gms.internal.ads.zzfu r3 = r0.zzg
            int r3 = r3.zzg()
            r0.zzm = r3
        L_0x02e6:
            long r5 = r0.zzn
            r7 = 1
            int r3 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r3 != 0) goto L_0x0305
            com.google.android.gms.internal.ads.zzfu r3 = r0.zzg
            byte[] r3 = r3.zzM()
            r1.zzi(r3, r13, r13)
            int r3 = r0.zzo
            int r3 = r3 + r13
            r0.zzo = r3
            com.google.android.gms.internal.ads.zzfu r3 = r0.zzg
            long r5 = r3.zzv()
            r0.zzn = r5
            goto L_0x0330
        L_0x0305:
            int r3 = (r5 > r10 ? 1 : (r5 == r10 ? 0 : -1))
            if (r3 != 0) goto L_0x0330
            long r5 = r31.zzd()
            r7 = -1
            int r3 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r3 != 0) goto L_0x0321
            java.util.ArrayDeque r3 = r0.zzh
            java.lang.Object r3 = r3.peek()
            com.google.android.gms.internal.ads.zzajm r3 = (com.google.android.gms.internal.ads.zzajm) r3
            if (r3 == 0) goto L_0x0320
            long r5 = r3.zza
            goto L_0x0321
        L_0x0320:
            r5 = r7
        L_0x0321:
            int r3 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r3 == 0) goto L_0x0330
            long r7 = r31.zzf()
            long r5 = r5 - r7
            int r3 = r0.zzo
            long r7 = (long) r3
            long r5 = r5 + r7
            r0.zzn = r5
        L_0x0330:
            long r5 = r0.zzn
            int r3 = r0.zzo
            long r7 = (long) r3
            int r5 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r5 < 0) goto L_0x046b
            int r5 = r0.zzm
            r6 = 1836019574(0x6d6f6f76, float:4.631354E27)
            r7 = 1835365473(0x6d657461, float:4.4382975E27)
            if (r5 == r6) goto L_0x0419
            r6 = 1953653099(0x7472616b, float:7.681346E31)
            if (r5 == r6) goto L_0x0419
            r6 = 1835297121(0x6d646961, float:4.4181236E27)
            if (r5 == r6) goto L_0x0419
            r6 = 1835626086(0x6d696e66, float:4.515217E27)
            if (r5 == r6) goto L_0x0419
            r6 = 1937007212(0x7374626c, float:1.9362132E31)
            if (r5 == r6) goto L_0x0419
            r6 = 1701082227(0x65647473, float:6.742798E22)
            if (r5 == r6) goto L_0x0419
            if (r5 != r7) goto L_0x0360
            goto L_0x0419
        L_0x0360:
            r6 = 1835296868(0x6d646864, float:4.418049E27)
            if (r5 == r6) goto L_0x03e5
            r6 = 1836476516(0x6d766864, float:4.7662196E27)
            if (r5 == r6) goto L_0x03e5
            r6 = 1751411826(0x68646c72, float:4.3148E24)
            if (r5 == r6) goto L_0x03e5
            r6 = 1937011556(0x73747364, float:1.9367383E31)
            if (r5 == r6) goto L_0x03e5
            r6 = 1937011827(0x73747473, float:1.9367711E31)
            if (r5 == r6) goto L_0x03e5
            r6 = 1937011571(0x73747373, float:1.9367401E31)
            if (r5 == r6) goto L_0x03e5
            r6 = 1668576371(0x63747473, float:4.5093966E21)
            if (r5 == r6) goto L_0x03e5
            r6 = 1701606260(0x656c7374, float:6.9788014E22)
            if (r5 == r6) goto L_0x03e5
            r6 = 1937011555(0x73747363, float:1.9367382E31)
            if (r5 == r6) goto L_0x03e5
            r6 = 1937011578(0x7374737a, float:1.936741E31)
            if (r5 == r6) goto L_0x03e5
            r6 = 1937013298(0x73747a32, float:1.9369489E31)
            if (r5 == r6) goto L_0x03e5
            r6 = 1937007471(0x7374636f, float:1.9362445E31)
            if (r5 == r6) goto L_0x03e5
            r6 = 1668232756(0x636f3634, float:4.4126776E21)
            if (r5 == r6) goto L_0x03e5
            r6 = 1953196132(0x746b6864, float:7.46037E31)
            if (r5 == r6) goto L_0x03e5
            if (r5 == r4) goto L_0x03e5
            r4 = 1969517665(0x75647461, float:2.8960062E32)
            if (r5 == r4) goto L_0x03e5
            r4 = 1801812339(0x6b657973, float:2.7741754E26)
            if (r5 == r4) goto L_0x03e5
            r4 = 1768715124(0x696c7374, float:1.7865732E25)
            if (r5 != r4) goto L_0x03b8
            goto L_0x03e5
        L_0x03b8:
            long r3 = r31.zzf()
            int r5 = r0.zzo
            long r5 = (long) r5
            long r10 = r3 - r5
            int r3 = r0.zzm
            r4 = 1836086884(0x6d707664, float:4.6512205E27)
            if (r3 != r4) goto L_0x03dd
            long r14 = r10 + r5
            com.google.android.gms.internal.ads.zzaie r3 = new com.google.android.gms.internal.ads.zzaie
            long r7 = r0.zzn
            long r16 = r7 - r5
            r8 = 0
            r12 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r7 = r3
            r7.<init>(r8, r10, r12, r14, r16)
            r0.zzB = r3
        L_0x03dd:
            r3 = 0
            r0.zzp = r3
            r3 = 1
            r0.zzl = r3
            goto L_0x0006
        L_0x03e5:
            if (r3 != r13) goto L_0x03e9
            r3 = 1
            goto L_0x03ea
        L_0x03e9:
            r3 = 0
        L_0x03ea:
            com.google.android.gms.internal.ads.zzeq.zzf(r3)
            long r3 = r0.zzn
            r5 = 2147483647(0x7fffffff, double:1.060997895E-314)
            int r3 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r3 > 0) goto L_0x03f8
            r3 = 1
            goto L_0x03f9
        L_0x03f8:
            r3 = 0
        L_0x03f9:
            com.google.android.gms.internal.ads.zzeq.zzf(r3)
            com.google.android.gms.internal.ads.zzfu r3 = new com.google.android.gms.internal.ads.zzfu
            long r4 = r0.zzn
            int r4 = (int) r4
            r3.<init>((int) r4)
            com.google.android.gms.internal.ads.zzfu r4 = r0.zzg
            byte[] r4 = r4.zzM()
            byte[] r5 = r3.zzM()
            r6 = 0
            java.lang.System.arraycopy(r4, r6, r5, r6, r13)
            r0.zzp = r3
            r3 = 1
            r0.zzl = r3
            goto L_0x0006
        L_0x0419:
            long r3 = r31.zzf()
            long r5 = r0.zzn
            long r3 = r3 + r5
            int r8 = r0.zzo
            long r8 = (long) r8
            int r5 = (r5 > r8 ? 1 : (r5 == r8 ? 0 : -1))
            if (r5 == 0) goto L_0x044b
            int r5 = r0.zzm
            if (r5 != r7) goto L_0x044b
            com.google.android.gms.internal.ads.zzfu r5 = r0.zzf
            r5.zzH(r13)
            com.google.android.gms.internal.ads.zzfu r5 = r0.zzf
            byte[] r5 = r5.zzM()
            r6 = 0
            r1.zzh(r5, r6, r13)
            com.google.android.gms.internal.ads.zzfu r5 = r0.zzf
            com.google.android.gms.internal.ads.zzajw.zze(r5)
            com.google.android.gms.internal.ads.zzfu r5 = r0.zzf
            int r5 = r5.zzd()
            r1.zzk(r5)
            r31.zzj()
        L_0x044b:
            long r3 = r3 - r8
            java.util.ArrayDeque r5 = r0.zzh
            com.google.android.gms.internal.ads.zzajm r6 = new com.google.android.gms.internal.ads.zzajm
            int r7 = r0.zzm
            r6.<init>(r7, r3)
            r5.push(r6)
            long r5 = r0.zzn
            int r7 = r0.zzo
            long r7 = (long) r7
            int r5 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r5 != 0) goto L_0x0466
            r0.zzm(r3)
            goto L_0x0006
        L_0x0466:
            r30.zzl()
            goto L_0x0006
        L_0x046b:
            java.lang.String r1 = "Atom size less than header length (unsupported)."
            com.google.android.gms.internal.ads.zzch r1 = com.google.android.gms.internal.ads.zzch.zzc(r1)
            throw r1
        L_0x0472:
            r1 = 1
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzakj.zzb(com.google.android.gms.internal.ads.zzadv, com.google.android.gms.internal.ads.zzaeq):int");
    }
}
