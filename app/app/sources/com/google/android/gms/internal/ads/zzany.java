package com.google.android.gms.internal.ads;

import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzany implements zzaoc {
    private static final byte[] zza = {73, 68, 51};
    private final boolean zzb;
    private final zzft zzc = new zzft(new byte[7], 7);
    private final zzfu zzd = new zzfu(Arrays.copyOf(zza, 10));
    private final String zze;
    private final int zzf;
    private String zzg;
    private zzafa zzh;
    private zzafa zzi;
    private int zzj;
    private int zzk;
    private int zzl;
    private boolean zzm;
    private boolean zzn;
    private int zzo;
    private int zzp;
    private int zzq;
    private boolean zzr;
    private long zzs;
    private int zzt;
    private long zzu;
    private zzafa zzv;
    private long zzw;

    public zzany(boolean z, String str, int i) {
        zzh();
        this.zzo = -1;
        this.zzp = -1;
        this.zzs = -9223372036854775807L;
        this.zzu = -9223372036854775807L;
        this.zzb = z;
        this.zze = str;
        this.zzf = i;
    }

    public static boolean zzf(int i) {
        return (i & 65526) == 65520;
    }

    private final void zzg() {
        this.zzn = false;
        zzh();
    }

    private final void zzh() {
        this.zzj = 0;
        this.zzk = 0;
        this.zzl = 256;
    }

    private final void zzi() {
        this.zzj = 3;
        this.zzk = 0;
    }

    private final void zzj(zzafa zzafa, long j, int i, int i2) {
        this.zzj = 4;
        this.zzk = i;
        this.zzv = zzafa;
        this.zzw = j;
        this.zzt = i2;
    }

    private final boolean zzk(zzfu zzfu, byte[] bArr, int i) {
        int min = Math.min(zzfu.zzb(), i - this.zzk);
        zzfu.zzG(bArr, this.zzk, min);
        int i2 = this.zzk + min;
        this.zzk = i2;
        return i2 == i;
    }

    private static final boolean zzl(byte b, byte b2) {
        return zzf((b2 & 255) | 65280);
    }

    private static final boolean zzm(zzfu zzfu, byte[] bArr, int i) {
        if (zzfu.zzb() < i) {
            return false;
        }
        zzfu.zzG(bArr, 0, i);
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:104:0x0294, code lost:
        r6.zzl = r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(com.google.android.gms.internal.ads.zzfu r19) throws com.google.android.gms.internal.ads.zzch {
        /*
            r18 = this;
            r6 = r18
            r7 = r19
            com.google.android.gms.internal.ads.zzafa r0 = r6.zzh
            if (r0 == 0) goto L_0x02bf
            int r0 = com.google.android.gms.internal.ads.zzgd.zza
        L_0x000a:
            int r0 = r19.zzb()
            if (r0 <= 0) goto L_0x02be
            int r0 = r6.zzj
            r1 = 13
            r2 = 10
            r3 = 7
            r4 = 3
            r5 = 4
            r8 = -1
            r9 = 2
            r10 = 0
            r11 = 1
            switch(r0) {
                case 0: goto L_0x0181;
                case 1: goto L_0x0146;
                case 2: goto L_0x0118;
                case 3: goto L_0x0049;
                default: goto L_0x0020;
            }
        L_0x0020:
            int r0 = r19.zzb()
            int r1 = r6.zzt
            int r2 = r6.zzk
            int r1 = r1 - r2
            int r0 = java.lang.Math.min(r0, r1)
            com.google.android.gms.internal.ads.zzafa r1 = r6.zzv
            r1.zzq(r7, r0)
            int r1 = r6.zzk
            int r1 = r1 + r0
            r6.zzk = r1
            int r0 = r6.zzt
            if (r1 != r0) goto L_0x000a
            long r0 = r6.zzu
            r2 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 == 0) goto L_0x02a0
            r10 = r11
            goto L_0x02a1
        L_0x0049:
            boolean r0 = r6.zzm
            r8 = 5
            if (r11 == r0) goto L_0x0050
            r0 = r8
            goto L_0x0051
        L_0x0050:
            r0 = r3
        L_0x0051:
            com.google.android.gms.internal.ads.zzft r12 = r6.zzc
            byte[] r12 = r12.zza
            boolean r0 = r6.zzk(r7, r12, r0)
            if (r0 == 0) goto L_0x000a
            com.google.android.gms.internal.ads.zzft r0 = r6.zzc
            r0.zzk(r10)
            boolean r0 = r6.zzr
            if (r0 != 0) goto L_0x00f3
            com.google.android.gms.internal.ads.zzft r0 = r6.zzc
            int r0 = r0.zzd(r9)
            int r0 = r0 + r11
            if (r0 == r9) goto L_0x0088
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r12 = "Detected audio object type: "
            r2.append(r12)
            r2.append(r0)
            java.lang.String r0 = ", but assuming AAC LC."
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            java.lang.String r2 = "AdtsReader"
            com.google.android.gms.internal.ads.zzfk.zzf(r2, r0)
        L_0x0088:
            com.google.android.gms.internal.ads.zzft r0 = r6.zzc
            r0.zzm(r8)
            com.google.android.gms.internal.ads.zzft r0 = r6.zzc
            int r0 = r0.zzd(r4)
            int r2 = r6.zzp
            int r8 = com.google.android.gms.internal.ads.zzacq.zza
            int r8 = r2 >> 1
            r8 = r8 & r3
            r8 = r8 | 16
            byte r8 = (byte) r8
            int r2 = r2 << r3
            int r0 = r0 << r4
            r2 = r2 & 128(0x80, float:1.794E-43)
            r0 = r0 & 120(0x78, float:1.68E-43)
            r0 = r0 | r2
            byte r0 = (byte) r0
            byte[] r2 = new byte[r9]
            r2[r10] = r8
            r2[r11] = r0
            com.google.android.gms.internal.ads.zzacp r0 = com.google.android.gms.internal.ads.zzacq.zza(r2)
            com.google.android.gms.internal.ads.zzal r3 = new com.google.android.gms.internal.ads.zzal
            r3.<init>()
            java.lang.String r4 = r6.zzg
            r3.zzK(r4)
            java.lang.String r4 = "audio/mp4a-latm"
            r3.zzX(r4)
            java.lang.String r4 = r0.zzc
            r3.zzz(r4)
            int r4 = r0.zzb
            r3.zzy(r4)
            int r0 = r0.zza
            r3.zzY(r0)
            java.util.List r0 = java.util.Collections.singletonList(r2)
            r3.zzL(r0)
            java.lang.String r0 = r6.zze
            r3.zzO(r0)
            int r0 = r6.zzf
            r3.zzV(r0)
            com.google.android.gms.internal.ads.zzan r0 = r3.zzad()
            int r2 = r0.zzB
            long r2 = (long) r2
            r8 = 1024000000(0x3d090000, double:5.059232213E-315)
            long r8 = r8 / r2
            r6.zzs = r8
            com.google.android.gms.internal.ads.zzafa r2 = r6.zzh
            r2.zzl(r0)
            r6.zzr = r11
            goto L_0x00f8
        L_0x00f3:
            com.google.android.gms.internal.ads.zzft r0 = r6.zzc
            r0.zzm(r2)
        L_0x00f8:
            com.google.android.gms.internal.ads.zzft r0 = r6.zzc
            r0.zzm(r5)
            com.google.android.gms.internal.ads.zzft r0 = r6.zzc
            int r0 = r0.zzd(r1)
            int r0 = r0 + -7
            boolean r1 = r6.zzm
            if (r1 == 0) goto L_0x010b
            int r0 = r0 + -2
        L_0x010b:
            r5 = r0
            com.google.android.gms.internal.ads.zzafa r1 = r6.zzh
            long r2 = r6.zzs
            r4 = 0
            r0 = r18
            r0.zzj(r1, r2, r4, r5)
            goto L_0x000a
        L_0x0118:
            com.google.android.gms.internal.ads.zzfu r0 = r6.zzd
            byte[] r0 = r0.zzM()
            boolean r0 = r6.zzk(r7, r0, r2)
            if (r0 == 0) goto L_0x000a
            com.google.android.gms.internal.ads.zzafa r0 = r6.zzi
            com.google.android.gms.internal.ads.zzfu r1 = r6.zzd
            r0.zzq(r1, r2)
            com.google.android.gms.internal.ads.zzfu r0 = r6.zzd
            r1 = 6
            r0.zzK(r1)
            com.google.android.gms.internal.ads.zzafa r1 = r6.zzi
            com.google.android.gms.internal.ads.zzfu r0 = r6.zzd
            int r0 = r0.zzl()
            r4 = 10
            int r5 = r0 + 10
            r2 = 0
            r0 = r18
            r0.zzj(r1, r2, r4, r5)
            goto L_0x000a
        L_0x0146:
            int r0 = r19.zzb()
            if (r0 == 0) goto L_0x000a
            com.google.android.gms.internal.ads.zzft r0 = r6.zzc
            byte[] r1 = r0.zza
            byte[] r2 = r19.zzM()
            int r3 = r19.zzd()
            byte r2 = r2[r3]
            r1[r10] = r2
            r0.zzk(r9)
            com.google.android.gms.internal.ads.zzft r0 = r6.zzc
            int r0 = r0.zzd(r5)
            int r1 = r6.zzp
            if (r1 == r8) goto L_0x0170
            if (r0 == r1) goto L_0x0170
            r18.zzg()
            goto L_0x000a
        L_0x0170:
            boolean r1 = r6.zzn
            if (r1 != 0) goto L_0x017c
            r6.zzn = r11
            int r1 = r6.zzq
            r6.zzo = r1
            r6.zzp = r0
        L_0x017c:
            r18.zzi()
            goto L_0x000a
        L_0x0181:
            byte[] r0 = r19.zzM()
            int r2 = r19.zzd()
            int r12 = r19.zze()
        L_0x018d:
            if (r2 >= r12) goto L_0x029b
            int r13 = r2 + 1
            byte r2 = r0[r2]
            r2 = r2 & 255(0xff, float:3.57E-43)
            int r14 = r6.zzl
            r15 = 512(0x200, float:7.175E-43)
            if (r14 != r15) goto L_0x0260
            byte r14 = (byte) r2
            boolean r14 = zzl(r8, r14)
            if (r14 == 0) goto L_0x0260
            boolean r14 = r6.zzn
            if (r14 != 0) goto L_0x023f
            int r14 = r13 + -2
            int r15 = r14 + 1
            r7.zzK(r15)
            com.google.android.gms.internal.ads.zzft r15 = r6.zzc
            byte[] r15 = r15.zza
            boolean r15 = zzm(r7, r15, r11)
            if (r15 != 0) goto L_0x01b9
            goto L_0x0260
        L_0x01b9:
            com.google.android.gms.internal.ads.zzft r15 = r6.zzc
            r15.zzk(r5)
            com.google.android.gms.internal.ads.zzft r15 = r6.zzc
            int r15 = r15.zzd(r11)
            int r10 = r6.zzo
            if (r10 == r8) goto L_0x01ca
            if (r15 != r10) goto L_0x0260
        L_0x01ca:
            int r10 = r6.zzp
            if (r10 == r8) goto L_0x01ed
            com.google.android.gms.internal.ads.zzft r10 = r6.zzc
            byte[] r10 = r10.zza
            boolean r10 = zzm(r7, r10, r11)
            if (r10 != 0) goto L_0x01d9
            goto L_0x023f
        L_0x01d9:
            com.google.android.gms.internal.ads.zzft r10 = r6.zzc
            r10.zzk(r9)
            com.google.android.gms.internal.ads.zzft r10 = r6.zzc
            int r10 = r10.zzd(r5)
            int r9 = r6.zzp
            if (r10 != r9) goto L_0x0260
            int r9 = r14 + 2
            r7.zzK(r9)
        L_0x01ed:
            com.google.android.gms.internal.ads.zzft r9 = r6.zzc
            byte[] r9 = r9.zza
            boolean r9 = zzm(r7, r9, r5)
            if (r9 == 0) goto L_0x023f
            com.google.android.gms.internal.ads.zzft r9 = r6.zzc
            r10 = 14
            r9.zzk(r10)
            com.google.android.gms.internal.ads.zzft r9 = r6.zzc
            int r9 = r9.zzd(r1)
            if (r9 < r3) goto L_0x0260
            byte[] r10 = r19.zzM()
            int r1 = r19.zze()
            int r14 = r14 + r9
            if (r14 >= r1) goto L_0x023f
            byte r9 = r10[r14]
            if (r9 != r8) goto L_0x0227
            int r14 = r14 + 1
            if (r14 == r1) goto L_0x023f
            byte r1 = r10[r14]
            boolean r9 = zzl(r8, r1)
            if (r9 == 0) goto L_0x0260
            r1 = r1 & 8
            int r1 = r1 >> r4
            if (r1 != r15) goto L_0x0260
            goto L_0x023f
        L_0x0227:
            r15 = 73
            if (r9 != r15) goto L_0x0260
            int r9 = r14 + 1
            if (r9 == r1) goto L_0x023f
            byte r9 = r10[r9]
            r15 = 68
            if (r9 != r15) goto L_0x0260
            int r14 = r14 + 2
            if (r14 == r1) goto L_0x023f
            byte r1 = r10[r14]
            r9 = 51
            if (r1 != r9) goto L_0x0260
        L_0x023f:
            r0 = r2 & 8
            int r0 = r0 >> r4
            r6.zzq = r0
            r0 = r2 & 1
            r0 = r0 ^ r11
            if (r11 == r0) goto L_0x024b
            r0 = 0
            goto L_0x024c
        L_0x024b:
            r0 = r11
        L_0x024c:
            r6.zzm = r0
            boolean r0 = r6.zzn
            if (r0 != 0) goto L_0x0258
            r6.zzj = r11
            r0 = 0
            r6.zzk = r0
            goto L_0x025b
        L_0x0258:
            r18.zzi()
        L_0x025b:
            r7.zzK(r13)
            goto L_0x000a
        L_0x0260:
            int r1 = r6.zzl
            r2 = r2 | r1
            switch(r2) {
                case 329: goto L_0x0290;
                case 511: goto L_0x028b;
                case 836: goto L_0x0286;
                case 1075: goto L_0x0274;
                default: goto L_0x0266;
            }
        L_0x0266:
            r9 = 2
            r10 = 0
            r2 = 256(0x100, float:3.59E-43)
            if (r1 == r2) goto L_0x0296
            r6.zzl = r2
            int r2 = r13 + -1
            r1 = 13
            goto L_0x018d
        L_0x0274:
            r9 = 2
            r6.zzj = r9
            r6.zzk = r4
            r10 = 0
            r6.zzt = r10
            com.google.android.gms.internal.ads.zzfu r0 = r6.zzd
            r0.zzK(r10)
            r7.zzK(r13)
            goto L_0x000a
        L_0x0286:
            r9 = 2
            r10 = 0
            r1 = 1024(0x400, float:1.435E-42)
            goto L_0x0294
        L_0x028b:
            r9 = 2
            r10 = 0
            r1 = 512(0x200, float:7.175E-43)
            goto L_0x0294
        L_0x0290:
            r9 = 2
            r10 = 0
            r1 = 768(0x300, float:1.076E-42)
        L_0x0294:
            r6.zzl = r1
        L_0x0296:
            r2 = r13
            r1 = 13
            goto L_0x018d
        L_0x029b:
            r7.zzK(r2)
            goto L_0x000a
        L_0x02a0:
        L_0x02a1:
            com.google.android.gms.internal.ads.zzeq.zzf(r10)
            com.google.android.gms.internal.ads.zzafa r11 = r6.zzv
            long r12 = r6.zzu
            int r15 = r6.zzt
            r14 = 1
            r16 = 0
            r17 = 0
            r11.zzs(r12, r14, r15, r16, r17)
            long r0 = r6.zzu
            long r2 = r6.zzw
            long r0 = r0 + r2
            r6.zzu = r0
            r18.zzh()
            goto L_0x000a
        L_0x02be:
            return
        L_0x02bf:
            r0 = 0
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzany.zza(com.google.android.gms.internal.ads.zzfu):void");
    }

    public final void zzb(zzadx zzadx, zzapo zzapo) {
        zzapo.zzc();
        this.zzg = zzapo.zzb();
        this.zzh = zzadx.zzw(zzapo.zza(), 1);
        this.zzv = this.zzh;
        if (this.zzb) {
            zzapo.zzc();
            this.zzi = zzadx.zzw(zzapo.zza(), 5);
            zzafa zzafa = this.zzi;
            zzal zzal = new zzal();
            zzal.zzK(zzapo.zzb());
            zzal.zzX("application/id3");
            zzafa.zzl(zzal.zzad());
            return;
        }
        this.zzi = new zzadt();
    }

    public final void zzc() {
    }

    public final void zzd(long j, int i) {
        this.zzu = j;
    }

    public final void zze() {
        this.zzu = -9223372036854775807L;
        zzg();
    }
}
