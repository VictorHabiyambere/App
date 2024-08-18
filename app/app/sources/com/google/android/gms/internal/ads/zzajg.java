package com.google.android.gms.internal.ads;

import androidx.compose.animation.core.AnimationKt;
import java.io.EOFException;
import java.io.IOException;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzajg implements zzadu {
    public static final zzaea zza = new zzaje();
    private static final zzaho zzb = new zzajf();
    private final zzfu zzc;
    private final zzaen zzd;
    private final zzaej zze;
    private final zzael zzf;
    private final zzafa zzg;
    private zzadx zzh;
    private zzafa zzi;
    private zzafa zzj;
    private int zzk;
    private zzcd zzl;
    private long zzm;
    private long zzn;
    private long zzo;
    private int zzp;
    private zzaji zzq;
    private boolean zzr;

    public zzajg() {
        throw null;
    }

    public zzajg(int i) {
        this.zzc = new zzfu(10);
        this.zzd = new zzaen();
        this.zze = new zzaej();
        this.zzm = -9223372036854775807L;
        this.zzf = new zzael();
        this.zzg = new zzadt();
        this.zzj = this.zzg;
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x007b  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0081  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x009b  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00e3  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x0135  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x013b  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x0192  */
    @org.checkerframework.checker.nullness.qual.RequiresNonNull({"extractorOutput", "realTrackOutput"})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final int zzg(com.google.android.gms.internal.ads.zzadv r19) throws java.io.IOException {
        /*
            r18 = this;
            r1 = r18
            r0 = r19
            int r2 = r1.zzk
            r3 = -1
            r4 = 0
            if (r2 != 0) goto L_0x0010
            r1.zzl(r0, r4)     // Catch:{ EOFException -> 0x000e }
            goto L_0x0010
        L_0x000e:
            r0 = move-exception
            return r3
        L_0x0010:
            com.google.android.gms.internal.ads.zzaji r2 = r1.zzq
            r8 = 1
            if (r2 != 0) goto L_0x01ab
            com.google.android.gms.internal.ads.zzaen r2 = r1.zzd
            com.google.android.gms.internal.ads.zzfu r14 = new com.google.android.gms.internal.ads.zzfu
            int r2 = r2.zzc
            r14.<init>((int) r2)
            byte[] r2 = r14.zzM()
            com.google.android.gms.internal.ads.zzaen r9 = r1.zzd
            int r9 = r9.zzc
            r15 = r0
            com.google.android.gms.internal.ads.zzadi r15 = (com.google.android.gms.internal.ads.zzadi) r15
            r15.zzm(r2, r4, r9, r4)
            com.google.android.gms.internal.ads.zzaen r2 = r1.zzd
            int r9 = r2.zza
            r9 = r9 & r8
            r10 = 36
            r11 = 21
            if (r9 == 0) goto L_0x003d
            int r2 = r2.zze
            if (r2 == r8) goto L_0x0041
            r11 = r10
            goto L_0x0044
        L_0x003d:
            int r2 = r2.zze
            if (r2 == r8) goto L_0x0042
        L_0x0041:
            goto L_0x0044
        L_0x0042:
            r11 = 13
        L_0x0044:
            int r2 = r14.zze()
            int r9 = r11 + 4
            r12 = 1483304551(0x58696e67, float:1.02664153E15)
            if (r2 < r9) goto L_0x005f
            r14.zzK(r11)
            int r2 = r14.zzg()
            if (r2 == r12) goto L_0x0076
            r9 = 1231971951(0x496e666f, float:976486.94)
            if (r2 != r9) goto L_0x005f
            r2 = r9
            goto L_0x0076
        L_0x005f:
            int r2 = r14.zze()
            r9 = 40
            if (r2 < r9) goto L_0x0075
            r14.zzK(r10)
            int r2 = r14.zzg()
            r9 = 1447187017(0x56425249, float:5.3414667E13)
            if (r2 != r9) goto L_0x0075
            r2 = r9
            goto L_0x0076
        L_0x0075:
            r2 = r4
        L_0x0076:
            r9 = -1
            switch(r2) {
                case 1231971951: goto L_0x009b;
                case 1447187017: goto L_0x0081;
                case 1483304551: goto L_0x009b;
                default: goto L_0x007b;
            }
        L_0x007b:
            r7 = r9
            r19.zzj()
            r2 = 0
            goto L_0x00db
        L_0x0081:
            long r11 = r19.zzd()
            long r16 = r19.zzf()
            com.google.android.gms.internal.ads.zzaen r13 = r1.zzd
            r7 = r9
            r9 = r11
            r11 = r16
            com.google.android.gms.internal.ads.zzajj r2 = com.google.android.gms.internal.ads.zzajj.zzb(r9, r11, r13, r14)
            com.google.android.gms.internal.ads.zzaen r9 = r1.zzd
            int r9 = r9.zzc
            r15.zzo(r9, r4)
            goto L_0x00db
        L_0x009b:
            r7 = r9
            com.google.android.gms.internal.ads.zzaen r9 = r1.zzd
            com.google.android.gms.internal.ads.zzajk r9 = com.google.android.gms.internal.ads.zzajk.zza(r9, r14)
            com.google.android.gms.internal.ads.zzaej r10 = r1.zze
            boolean r11 = r10.zza()
            if (r11 != 0) goto L_0x00b6
            int r11 = r9.zzd
            if (r11 == r3) goto L_0x00b6
            int r13 = r9.zze
            if (r13 == r3) goto L_0x00b6
            r10.zza = r11
            r10.zzb = r13
        L_0x00b6:
            long r10 = r19.zzf()
            com.google.android.gms.internal.ads.zzaen r13 = r1.zzd
            int r13 = r13.zzc
            r15.zzo(r13, r4)
            if (r2 != r12) goto L_0x00cc
            long r12 = r19.zzd()
            com.google.android.gms.internal.ads.zzajl r2 = com.google.android.gms.internal.ads.zzajl.zzb(r12, r9, r10)
            goto L_0x00db
        L_0x00cc:
            long r12 = r9.zzc
            int r2 = (r12 > r7 ? 1 : (r12 == r7 ? 0 : -1))
            if (r2 == 0) goto L_0x00d5
            long r9 = r10 + r12
            goto L_0x00d6
        L_0x00d5:
            r9 = r7
        L_0x00d6:
            com.google.android.gms.internal.ads.zzaji r2 = r1.zzi(r0, r9, r4)
        L_0x00db:
            com.google.android.gms.internal.ads.zzcd r9 = r1.zzl
            long r10 = r19.zzf()
            if (r9 == 0) goto L_0x0130
            int r12 = r9.zza()
            r13 = r4
        L_0x00e8:
            if (r13 >= r12) goto L_0x0130
            com.google.android.gms.internal.ads.zzcc r14 = r9.zzb(r13)
            boolean r15 = r14 instanceof com.google.android.gms.internal.ads.zzahv
            if (r15 == 0) goto L_0x012d
            com.google.android.gms.internal.ads.zzahv r14 = (com.google.android.gms.internal.ads.zzahv) r14
            int r12 = r9.zza()
            r13 = r4
        L_0x00f9:
            if (r13 >= r12) goto L_0x0123
            com.google.android.gms.internal.ads.zzcc r15 = r9.zzb(r13)
            boolean r5 = r15 instanceof com.google.android.gms.internal.ads.zzahz
            if (r5 == 0) goto L_0x0120
            com.google.android.gms.internal.ads.zzahz r15 = (com.google.android.gms.internal.ads.zzahz) r15
            java.lang.String r5 = r15.zzf
            java.lang.String r6 = "TLEN"
            boolean r5 = r5.equals(r6)
            if (r5 == 0) goto L_0x0120
            com.google.android.gms.internal.ads.zzgbc r5 = r15.zzc
            java.lang.Object r5 = r5.get(r4)
            java.lang.String r5 = (java.lang.String) r5
            long r5 = java.lang.Long.parseLong(r5)
            long r5 = com.google.android.gms.internal.ads.zzgd.zzr(r5)
            goto L_0x0128
        L_0x0120:
            int r13 = r13 + 1
            goto L_0x00f9
        L_0x0123:
            r5 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
        L_0x0128:
            com.google.android.gms.internal.ads.zzajd r5 = com.google.android.gms.internal.ads.zzajd.zzb(r10, r14, r5)
            goto L_0x0131
        L_0x012d:
            int r13 = r13 + 1
            goto L_0x00e8
        L_0x0130:
            r5 = 0
        L_0x0131:
            boolean r6 = r1.zzr
            if (r6 == 0) goto L_0x013b
            com.google.android.gms.internal.ads.zzajh r2 = new com.google.android.gms.internal.ads.zzajh
            r2.<init>()
            goto L_0x014c
        L_0x013b:
            if (r5 == 0) goto L_0x013f
            r2 = r5
            goto L_0x0142
        L_0x013f:
            if (r2 != 0) goto L_0x0142
            r2 = 0
        L_0x0142:
            if (r2 == 0) goto L_0x0148
            r2.zzh()
            goto L_0x014c
        L_0x0148:
            com.google.android.gms.internal.ads.zzaji r2 = r1.zzi(r0, r7, r4)
        L_0x014c:
            r1.zzq = r2
            com.google.android.gms.internal.ads.zzadx r2 = r1.zzh
            com.google.android.gms.internal.ads.zzaji r5 = r1.zzq
            r2.zzO(r5)
            com.google.android.gms.internal.ads.zzal r2 = new com.google.android.gms.internal.ads.zzal
            r2.<init>()
            com.google.android.gms.internal.ads.zzaen r5 = r1.zzd
            java.lang.String r5 = r5.zzb
            r2.zzX(r5)
            r5 = 4096(0x1000, float:5.74E-42)
            r2.zzP(r5)
            com.google.android.gms.internal.ads.zzaen r5 = r1.zzd
            int r5 = r5.zze
            r2.zzy(r5)
            com.google.android.gms.internal.ads.zzaen r5 = r1.zzd
            int r5 = r5.zzd
            r2.zzY(r5)
            com.google.android.gms.internal.ads.zzaej r5 = r1.zze
            int r5 = r5.zza
            r2.zzF(r5)
            com.google.android.gms.internal.ads.zzaej r5 = r1.zze
            int r5 = r5.zzb
            r2.zzG(r5)
            com.google.android.gms.internal.ads.zzcd r5 = r1.zzl
            r2.zzQ(r5)
            com.google.android.gms.internal.ads.zzaji r5 = r1.zzq
            int r5 = r5.zzc()
            r6 = -2147483647(0xffffffff80000001, float:-1.4E-45)
            if (r5 == r6) goto L_0x019b
            com.google.android.gms.internal.ads.zzaji r5 = r1.zzq
            int r5 = r5.zzc()
            r2.zzx(r5)
        L_0x019b:
            com.google.android.gms.internal.ads.zzafa r5 = r1.zzj
            com.google.android.gms.internal.ads.zzan r2 = r2.zzad()
            r5.zzl(r2)
            long r5 = r19.zzf()
            r1.zzo = r5
            goto L_0x01c3
        L_0x01ab:
            long r5 = r1.zzo
            r7 = 0
            int r2 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r2 == 0) goto L_0x01c3
            long r7 = r19.zzf()
            int r2 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
            if (r2 >= 0) goto L_0x01c3
            long r5 = r5 - r7
            r2 = r0
            com.google.android.gms.internal.ads.zzadi r2 = (com.google.android.gms.internal.ads.zzadi) r2
            int r5 = (int) r5
            r2.zzo(r5, r4)
        L_0x01c3:
            int r2 = r1.zzp
            if (r2 != 0) goto L_0x022f
            r19.zzj()
            boolean r2 = r18.zzk(r19)
            if (r2 == 0) goto L_0x01d2
            goto L_0x0241
        L_0x01d2:
            com.google.android.gms.internal.ads.zzfu r2 = r1.zzc
            r2.zzK(r4)
            com.google.android.gms.internal.ads.zzfu r2 = r1.zzc
            int r2 = r2.zzg()
            int r5 = r1.zzk
            long r5 = (long) r5
            boolean r5 = zzj(r2, r5)
            if (r5 == 0) goto L_0x0225
            int r5 = com.google.android.gms.internal.ads.zzaeo.zzb(r2)
            if (r5 != r3) goto L_0x01ed
            goto L_0x0225
        L_0x01ed:
            com.google.android.gms.internal.ads.zzaen r5 = r1.zzd
            r5.zza(r2)
            long r5 = r1.zzm
            r7 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r2 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r2 != 0) goto L_0x0209
            com.google.android.gms.internal.ads.zzaji r2 = r1.zzq
            long r5 = r19.zzf()
            long r5 = r2.zze(r5)
            r1.zzm = r5
        L_0x0209:
            com.google.android.gms.internal.ads.zzaen r2 = r1.zzd
            int r5 = r2.zzc
            r1.zzp = r5
            com.google.android.gms.internal.ads.zzaji r6 = r1.zzq
            boolean r7 = r6 instanceof com.google.android.gms.internal.ads.zzajc
            if (r7 != 0) goto L_0x0218
            r2 = r5
            r5 = 1
            goto L_0x0230
        L_0x0218:
            com.google.android.gms.internal.ads.zzajc r6 = (com.google.android.gms.internal.ads.zzajc) r6
            long r3 = r1.zzn
            int r0 = r2.zzg
            long r5 = (long) r0
            long r3 = r3 + r5
            r1.zzh(r3)
            r0 = 0
            throw r0
        L_0x0225:
            com.google.android.gms.internal.ads.zzadi r0 = (com.google.android.gms.internal.ads.zzadi) r0
            r5 = 1
            r0.zzo(r5, r4)
            r1.zzk = r4
            r3 = r4
            goto L_0x0241
        L_0x022f:
            r5 = 1
        L_0x0230:
            com.google.android.gms.internal.ads.zzafa r6 = r1.zzj
            int r0 = r6.zzf(r0, r2, r5)
            if (r0 != r3) goto L_0x0239
            goto L_0x0241
        L_0x0239:
            int r2 = r1.zzp
            int r2 = r2 - r0
            r1.zzp = r2
            if (r2 <= 0) goto L_0x0242
            r3 = r4
        L_0x0241:
            return r3
        L_0x0242:
            com.google.android.gms.internal.ads.zzafa r5 = r1.zzj
            long r2 = r1.zzn
            long r6 = r1.zzh(r2)
            com.google.android.gms.internal.ads.zzaen r0 = r1.zzd
            int r9 = r0.zzc
            r8 = 1
            r10 = 0
            r11 = 0
            r5.zzs(r6, r8, r9, r10, r11)
            long r2 = r1.zzn
            com.google.android.gms.internal.ads.zzaen r0 = r1.zzd
            int r0 = r0.zzg
            long r5 = (long) r0
            long r2 = r2 + r5
            r1.zzn = r2
            r1.zzp = r4
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzajg.zzg(com.google.android.gms.internal.ads.zzadv):int");
    }

    private final long zzh(long j) {
        zzaen zzaen = this.zzd;
        return this.zzm + ((j * AnimationKt.MillisToNanos) / ((long) zzaen.zzd));
    }

    private final zzaji zzi(zzadv zzadv, long j, boolean z) throws IOException {
        long j2;
        ((zzadi) zzadv).zzm(this.zzc.zzM(), 0, 4, false);
        this.zzc.zzK(0);
        this.zzd.zza(this.zzc.zzg());
        if (zzadv.zzd() != -1) {
            j2 = zzadv.zzd();
        } else {
            j2 = j;
        }
        return new zzajb(j2, zzadv.zzf(), this.zzd, false);
    }

    private static boolean zzj(int i, long j) {
        return ((long) (i & -128000)) == (j & -128000);
    }

    private final boolean zzk(zzadv zzadv) throws IOException {
        zzaji zzaji = this.zzq;
        if (zzaji != null) {
            long zzd2 = zzaji.zzd();
            if (zzd2 != -1 && zzadv.zze() > zzd2 - 4) {
                return true;
            }
        }
        try {
            return !zzadv.zzm(this.zzc.zzM(), 0, 4, true);
        } catch (EOFException e) {
            return true;
        }
    }

    private final boolean zzl(zzadv zzadv, boolean z) throws IOException {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int zzb2;
        zzadv.zzj();
        if (zzadv.zzf() == 0) {
            this.zzl = this.zzf.zza(zzadv, (zzaho) null);
            zzcd zzcd = this.zzl;
            if (zzcd != null) {
                this.zze.zzb(zzcd);
            }
            i4 = (int) zzadv.zze();
            if (!z) {
                ((zzadi) zzadv).zzo(i4, false);
                i3 = 0;
                i2 = 0;
                i = 0;
            } else {
                i3 = 0;
                i2 = 0;
                i = 0;
            }
        } else {
            i4 = 0;
            i3 = 0;
            i2 = 0;
            i = 0;
        }
        while (true) {
            if (!zzk(zzadv)) {
                this.zzc.zzK(0);
                int zzg2 = this.zzc.zzg();
                if ((i3 == 0 || zzj(zzg2, (long) i3)) && (zzb2 = zzaeo.zzb(zzg2)) != -1) {
                    i6 = i2 + 1;
                    if (i6 != 1) {
                        if (i6 == 4) {
                            break;
                        }
                    } else {
                        this.zzd.zza(zzg2);
                        i3 = zzg2;
                    }
                    ((zzadi) zzadv).zzl(zzb2 - 4, false);
                } else {
                    if (true != z) {
                        i5 = 131072;
                    } else {
                        i5 = 32768;
                    }
                    int i7 = i + 1;
                    if (i == i5) {
                        if (z) {
                            return false;
                        }
                        throw zzch.zza("Searched too many bytes.", (Throwable) null);
                    } else if (z) {
                        zzadv.zzj();
                        ((zzadi) zzadv).zzl(i4 + i7, false);
                        i3 = 0;
                        i = i7;
                        i6 = 0;
                    } else {
                        ((zzadi) zzadv).zzo(1, false);
                        i3 = 0;
                        i = i7;
                        i6 = 0;
                    }
                }
            } else if (i2 <= 0) {
                throw new EOFException();
            }
        }
        if (z) {
            ((zzadi) zzadv).zzo(i4 + i, false);
        } else {
            zzadv.zzj();
        }
        this.zzk = i3;
        return true;
    }

    public final void zza() {
        this.zzr = true;
    }

    public final int zzb(zzadv zzadv, zzaeq zzaeq) throws IOException {
        zzeq.zzb(this.zzi);
        int i = zzgd.zza;
        int zzg2 = zzg(zzadv);
        if (zzg2 == -1 && (this.zzq instanceof zzajc)) {
            if (this.zzq.zza() != zzh(this.zzn)) {
                zzajc zzajc = (zzajc) this.zzq;
                throw null;
            }
        }
        return zzg2;
    }

    public final /* synthetic */ List zzc() {
        return zzgbc.zzm();
    }

    public final void zzd(zzadx zzadx) {
        this.zzh = zzadx;
        this.zzi = this.zzh.zzw(0, 1);
        this.zzj = this.zzi;
        this.zzh.zzD();
    }

    public final void zze(long j, long j2) {
        this.zzk = 0;
        this.zzm = -9223372036854775807L;
        this.zzn = 0;
        this.zzp = 0;
        zzaji zzaji = this.zzq;
        if (zzaji instanceof zzajc) {
            zzajc zzajc = (zzajc) zzaji;
            throw null;
        }
    }

    public final boolean zzf(zzadv zzadv) throws IOException {
        return zzl(zzadv, true);
    }
}
