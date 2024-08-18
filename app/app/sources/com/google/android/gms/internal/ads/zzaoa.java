package com.google.android.gms.internal.ads;

import java.util.concurrent.atomic.AtomicInteger;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzaoa implements zzaoc {
    private final zzfu zza;
    private final AtomicInteger zzb = new AtomicInteger();
    private final String zzc;
    private final int zzd;
    private String zze;
    private zzafa zzf;
    private int zzg = 0;
    private int zzh;
    private int zzi;
    private long zzj;
    private zzan zzk;
    private int zzl;
    private int zzm;
    private int zzn = -1;
    private int zzo = -1;
    private long zzp = -9223372036854775807L;

    public zzaoa(String str, int i, int i2) {
        this.zza = new zzfu(new byte[i2]);
        this.zzc = str;
        this.zzd = i;
    }

    @RequiresNonNull({"output"})
    private final void zzf(zzadq zzadq) {
        int i;
        zzal zzal;
        int i2 = zzadq.zzb;
        if (i2 != -2147483647 && (i = zzadq.zzc) != -1) {
            zzan zzan = this.zzk;
            if (zzan == null || i != zzan.zzA || i2 != zzan.zzB || !zzgd.zzG(zzadq.zza, zzan.zzn)) {
                zzan zzan2 = this.zzk;
                if (zzan2 == null) {
                    zzal = new zzal();
                } else {
                    zzal = zzan2.zzb();
                }
                zzal.zzK(this.zze);
                zzal.zzX(zzadq.zza);
                zzal.zzy(zzadq.zzc);
                zzal.zzY(zzadq.zzb);
                zzal.zzO(this.zzc);
                zzal.zzV(this.zzd);
                this.zzk = zzal.zzad();
                this.zzf.zzl(this.zzk);
            }
        }
    }

    private final boolean zzg(zzfu zzfu, byte[] bArr, int i) {
        int min = Math.min(zzfu.zzb(), i - this.zzh);
        zzfu.zzG(bArr, this.zzh, min);
        int i2 = this.zzh + min;
        this.zzh = i2;
        return i2 == i;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x01f6, code lost:
        if (r17.zzb() <= 0) goto L_0x0009;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x01f8, code lost:
        r2 = r0.zzi << 8;
        r0.zzi = r2;
        r2 = r2 | r17.zzm();
        r0.zzi = r2;
        r3 = com.google.android.gms.internal.ads.zzadr.zza;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x0209, code lost:
        if (r2 == 2147385345) goto L_0x0245;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x020e, code lost:
        if (r2 == -25230976) goto L_0x0245;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x0213, code lost:
        if (r2 == 536864768) goto L_0x0245;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x0218, code lost:
        if (r2 != -14745368) goto L_0x021c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x021a, code lost:
        r2 = 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x021f, code lost:
        if (r2 == 1683496997) goto L_0x0243;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x0224, code lost:
        if (r2 != 622876772) goto L_0x0227;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x022a, code lost:
        if (r2 == 1078008818) goto L_0x0241;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x022f, code lost:
        if (r2 != -233094848) goto L_0x0232;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x0235, code lost:
        if (r2 == 1908687592) goto L_0x023f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x023a, code lost:
        if (r2 != -398277519) goto L_0x023d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x023d, code lost:
        r2 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x023f, code lost:
        r2 = 4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x0241, code lost:
        r2 = 3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x0243, code lost:
        r2 = 2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x0245, code lost:
        r2 = 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x0246, code lost:
        r0.zzm = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x024a, code lost:
        r3 = r0.zza.zzM();
        r4 = r0.zzi;
        r3[0] = (byte) ((r4 >> 24) & 255);
        r3[1] = (byte) ((r4 >> 16) & 255);
        r3[2] = (byte) ((r4 >> 8) & 255);
        r3[3] = (byte) (r4 & 255);
        r0.zzh = 4;
        r0.zzi = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x0270, code lost:
        if (r2 == 3) goto L_0x027f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x0272, code lost:
        if (r2 != 4) goto L_0x0275;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x0275, code lost:
        if (r2 != 1) goto L_0x027b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:0x0277, code lost:
        r0.zzg = 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:89:0x027b, code lost:
        r0.zzg = 2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:90:0x027f, code lost:
        r0.zzg = 4;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(com.google.android.gms.internal.ads.zzfu r17) throws com.google.android.gms.internal.ads.zzch {
        /*
            r16 = this;
            r0 = r16
            r1 = r17
            com.google.android.gms.internal.ads.zzafa r2 = r0.zzf
            com.google.android.gms.internal.ads.zzeq.zzb(r2)
        L_0x0009:
            int r2 = r17.zzb()
            if (r2 <= 0) goto L_0x02a4
            int r2 = r0.zzg
            r3 = 0
            r5 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r7 = 8
            r8 = 5
            r9 = 7
            r10 = 2
            r11 = 3
            r12 = 6
            r13 = 0
            r14 = 4
            r15 = 1
            switch(r2) {
                case 0: goto L_0x01f2;
                case 1: goto L_0x010d;
                case 2: goto L_0x00f1;
                case 3: goto L_0x00b6;
                case 4: goto L_0x0089;
                case 5: goto L_0x0049;
                default: goto L_0x0025;
            }
        L_0x0025:
            int r2 = r17.zzb()
            int r3 = r0.zzl
            int r4 = r0.zzh
            int r3 = r3 - r4
            int r2 = java.lang.Math.min(r2, r3)
            com.google.android.gms.internal.ads.zzafa r3 = r0.zzf
            r3.zzq(r1, r2)
            int r3 = r0.zzh
            int r3 = r3 + r2
            r0.zzh = r3
            int r2 = r0.zzl
            if (r3 != r2) goto L_0x0009
            long r2 = r0.zzp
            int r2 = (r2 > r5 ? 1 : (r2 == r5 ? 0 : -1))
            if (r2 == 0) goto L_0x0283
            r2 = r15
            goto L_0x0284
        L_0x0049:
            com.google.android.gms.internal.ads.zzfu r2 = r0.zza
            byte[] r2 = r2.zzM()
            int r7 = r0.zzo
            boolean r2 = r0.zzg(r1, r2, r7)
            if (r2 == 0) goto L_0x0009
            com.google.android.gms.internal.ads.zzfu r2 = r0.zza
            java.util.concurrent.atomic.AtomicInteger r7 = r0.zzb
            byte[] r2 = r2.zzM()
            com.google.android.gms.internal.ads.zzadq r2 = com.google.android.gms.internal.ads.zzadr.zze(r2, r7)
            int r7 = r0.zzm
            if (r7 != r11) goto L_0x006a
            r0.zzf(r2)
        L_0x006a:
            int r7 = r2.zzd
            r0.zzl = r7
            long r7 = r2.zze
            int r2 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
            if (r2 != 0) goto L_0x0075
            goto L_0x0076
        L_0x0075:
            r3 = r7
        L_0x0076:
            r0.zzj = r3
            com.google.android.gms.internal.ads.zzfu r2 = r0.zza
            r2.zzK(r13)
            com.google.android.gms.internal.ads.zzafa r2 = r0.zzf
            com.google.android.gms.internal.ads.zzfu r3 = r0.zza
            int r4 = r0.zzo
            r2.zzq(r3, r4)
            r0.zzg = r12
            goto L_0x0009
        L_0x0089:
            com.google.android.gms.internal.ads.zzfu r2 = r0.zza
            byte[] r2 = r2.zzM()
            boolean r2 = r0.zzg(r1, r2, r12)
            if (r2 == 0) goto L_0x0009
            com.google.android.gms.internal.ads.zzfu r2 = r0.zza
            byte[] r2 = r2.zzM()
            int r2 = com.google.android.gms.internal.ads.zzadr.zzb(r2)
            r0.zzo = r2
            int r3 = r0.zzh
            if (r3 <= r2) goto L_0x00b2
            int r2 = r3 - r2
            int r3 = r3 - r2
            r0.zzh = r3
            int r3 = r17.zzd()
            int r3 = r3 - r2
            r1.zzK(r3)
        L_0x00b2:
            r0.zzg = r8
            goto L_0x0009
        L_0x00b6:
            com.google.android.gms.internal.ads.zzfu r2 = r0.zza
            byte[] r2 = r2.zzM()
            int r7 = r0.zzn
            boolean r2 = r0.zzg(r1, r2, r7)
            if (r2 == 0) goto L_0x0009
            com.google.android.gms.internal.ads.zzfu r2 = r0.zza
            byte[] r2 = r2.zzM()
            com.google.android.gms.internal.ads.zzadq r2 = com.google.android.gms.internal.ads.zzadr.zzd(r2)
            r0.zzf(r2)
            int r7 = r2.zzd
            r0.zzl = r7
            long r7 = r2.zze
            int r2 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
            if (r2 != 0) goto L_0x00dc
            goto L_0x00dd
        L_0x00dc:
            r3 = r7
        L_0x00dd:
            r0.zzj = r3
            com.google.android.gms.internal.ads.zzfu r2 = r0.zza
            r2.zzK(r13)
            com.google.android.gms.internal.ads.zzafa r2 = r0.zzf
            com.google.android.gms.internal.ads.zzfu r3 = r0.zza
            int r4 = r0.zzn
            r2.zzq(r3, r4)
            r0.zzg = r12
            goto L_0x0009
        L_0x00f1:
            com.google.android.gms.internal.ads.zzfu r2 = r0.zza
            byte[] r2 = r2.zzM()
            boolean r2 = r0.zzg(r1, r2, r9)
            if (r2 == 0) goto L_0x0009
            com.google.android.gms.internal.ads.zzfu r2 = r0.zza
            byte[] r2 = r2.zzM()
            int r2 = com.google.android.gms.internal.ads.zzadr.zza(r2)
            r0.zzn = r2
            r0.zzg = r11
            goto L_0x0009
        L_0x010d:
            com.google.android.gms.internal.ads.zzfu r2 = r0.zza
            byte[] r2 = r2.zzM()
            r3 = 18
            boolean r2 = r0.zzg(r1, r2, r3)
            if (r2 == 0) goto L_0x0009
            com.google.android.gms.internal.ads.zzfu r2 = r0.zza
            byte[] r2 = r2.zzM()
            com.google.android.gms.internal.ads.zzan r4 = r0.zzk
            if (r4 != 0) goto L_0x0139
            java.lang.String r4 = r0.zze
            java.lang.String r5 = r0.zzc
            int r6 = r0.zzd
            r3 = 0
            com.google.android.gms.internal.ads.zzan r3 = com.google.android.gms.internal.ads.zzadr.zzc(r2, r4, r5, r6, r3)
            r0.zzk = r3
            com.google.android.gms.internal.ads.zzafa r3 = r0.zzf
            com.google.android.gms.internal.ads.zzan r4 = r0.zzk
            r3.zzl(r4)
        L_0x0139:
            int r3 = com.google.android.gms.internal.ads.zzadr.zza
            byte r3 = r2[r13]
            switch(r3) {
                case -2: goto L_0x0180;
                case -1: goto L_0x0169;
                case 31: goto L_0x0154;
                default: goto L_0x0140;
            }
        L_0x0140:
            byte r4 = r2[r8]
            r4 = r4 & r11
            int r4 = r4 << 12
            byte r5 = r2[r12]
            r5 = r5 & 255(0xff, float:3.57E-43)
            int r5 = r5 << r14
            byte r6 = r2[r9]
            r6 = r6 & 240(0xf0, float:3.36E-43)
            int r6 = r6 >> r14
            r4 = r4 | r5
            r4 = r4 | r6
            int r4 = r4 + r15
            r5 = r13
            goto L_0x0194
        L_0x0154:
            byte r4 = r2[r12]
            r4 = r4 & r11
            int r4 = r4 << 12
            byte r5 = r2[r9]
            r5 = r5 & 255(0xff, float:3.57E-43)
            int r5 = r5 << r14
            byte r6 = r2[r7]
            r6 = r6 & 60
            int r6 = r6 >> r10
            r4 = r4 | r5
            r4 = r4 | r6
            int r4 = r4 + r15
            r5 = r15
            goto L_0x0194
        L_0x0169:
            byte r4 = r2[r9]
            r4 = r4 & r11
            int r4 = r4 << 12
            byte r5 = r2[r12]
            r5 = r5 & 255(0xff, float:3.57E-43)
            int r5 = r5 << r14
            r6 = 9
            byte r6 = r2[r6]
            r6 = r6 & 60
            int r6 = r6 >> r10
            r4 = r4 | r5
            r4 = r4 | r6
            int r4 = r4 + r15
            r5 = r15
            goto L_0x0194
        L_0x0180:
            byte r4 = r2[r14]
            r4 = r4 & r11
            int r4 = r4 << 12
            byte r5 = r2[r9]
            r5 = r5 & 255(0xff, float:3.57E-43)
            int r5 = r5 << r14
            byte r6 = r2[r12]
            r6 = r6 & 240(0xf0, float:3.36E-43)
            int r6 = r6 >> r14
            r4 = r4 | r5
            r4 = r4 | r6
            int r4 = r4 + r15
            r5 = r13
        L_0x0194:
            if (r5 == 0) goto L_0x019a
            int r4 = r4 * 16
            int r4 = r4 / 14
        L_0x019a:
            r0.zzl = r4
            switch(r3) {
                case -2: goto L_0x01c2;
                case -1: goto L_0x01b6;
                case 31: goto L_0x01aa;
                default: goto L_0x019f;
            }
        L_0x019f:
            byte r3 = r2[r14]
            r3 = r3 & r15
            int r3 = r3 << r12
            byte r2 = r2[r8]
            r2 = r2 & 252(0xfc, float:3.53E-43)
            int r2 = r2 >> r10
            r2 = r2 | r3
            goto L_0x01cd
        L_0x01aa:
            byte r3 = r2[r8]
            r3 = r3 & r9
            int r3 = r3 << r14
            byte r2 = r2[r12]
            r2 = r2 & 60
            int r2 = r2 >> r10
            r2 = r2 | r3
            goto L_0x01cd
        L_0x01b6:
            byte r3 = r2[r14]
            r3 = r3 & r9
            int r3 = r3 << r14
            byte r2 = r2[r9]
            r2 = r2 & 60
            int r2 = r2 >> r10
            r2 = r2 | r3
            goto L_0x01cd
        L_0x01c2:
            byte r3 = r2[r8]
            r3 = r3 & r15
            int r3 = r3 << r12
            byte r2 = r2[r14]
            r2 = r2 & 252(0xfc, float:3.53E-43)
            int r2 = r2 >> r10
            r2 = r2 | r3
        L_0x01cd:
            int r2 = r2 + r15
            com.google.android.gms.internal.ads.zzan r3 = r0.zzk
            int r3 = r3.zzB
            int r2 = r2 * 32
            long r4 = (long) r2
            long r2 = com.google.android.gms.internal.ads.zzgd.zzs(r4, r3)
            int r2 = com.google.android.gms.internal.ads.zzgea.zzb(r2)
            long r2 = (long) r2
            r0.zzj = r2
            com.google.android.gms.internal.ads.zzfu r2 = r0.zza
            r2.zzK(r13)
            com.google.android.gms.internal.ads.zzafa r2 = r0.zzf
            com.google.android.gms.internal.ads.zzfu r3 = r0.zza
            r4 = 18
            r2.zzq(r3, r4)
            r0.zzg = r12
            goto L_0x0009
        L_0x01f2:
            int r2 = r17.zzb()
            if (r2 <= 0) goto L_0x0009
            int r2 = r0.zzi
            int r2 = r2 << r7
            r0.zzi = r2
            int r3 = r17.zzm()
            r2 = r2 | r3
            r0.zzi = r2
            int r3 = com.google.android.gms.internal.ads.zzadr.zza
            r3 = 2147385345(0x7ffe8001, float:NaN)
            if (r2 == r3) goto L_0x0245
            r3 = -25230976(0xfffffffffe7f0180, float:-8.474023E37)
            if (r2 == r3) goto L_0x0245
            r3 = 536864768(0x1fffe800, float:1.0838051E-19)
            if (r2 == r3) goto L_0x0245
            r3 = -14745368(0xffffffffff1f00e8, float:-2.1135196E38)
            if (r2 != r3) goto L_0x021c
            r2 = r15
            goto L_0x0246
        L_0x021c:
            r3 = 1683496997(0x64582025, float:1.5947252E22)
            if (r2 == r3) goto L_0x0243
            r3 = 622876772(0x25205864, float:1.3907736E-16)
            if (r2 != r3) goto L_0x0227
            goto L_0x0243
        L_0x0227:
            r3 = 1078008818(0x40411bf2, float:3.0173306)
            if (r2 == r3) goto L_0x0241
            r3 = -233094848(0xfffffffff21b4140, float:-3.0751398E30)
            if (r2 != r3) goto L_0x0232
            goto L_0x0241
        L_0x0232:
            r3 = 1908687592(0x71c442e8, float:1.9436783E30)
            if (r2 == r3) goto L_0x023f
            r3 = -398277519(0xffffffffe842c471, float:-3.6790512E24)
            if (r2 != r3) goto L_0x023d
            goto L_0x023f
        L_0x023d:
            r2 = r13
            goto L_0x0246
        L_0x023f:
            r2 = r14
            goto L_0x0246
        L_0x0241:
            r2 = r11
            goto L_0x0246
        L_0x0243:
            r2 = r10
            goto L_0x0246
        L_0x0245:
            r2 = r15
        L_0x0246:
            r0.zzm = r2
            if (r2 == 0) goto L_0x01f2
            com.google.android.gms.internal.ads.zzfu r3 = r0.zza
            byte[] r3 = r3.zzM()
            int r4 = r0.zzi
            int r5 = r4 >> 24
            r5 = r5 & 255(0xff, float:3.57E-43)
            byte r5 = (byte) r5
            r3[r13] = r5
            int r5 = r4 >> 16
            r5 = r5 & 255(0xff, float:3.57E-43)
            byte r5 = (byte) r5
            r3[r15] = r5
            int r5 = r4 >> 8
            r5 = r5 & 255(0xff, float:3.57E-43)
            byte r5 = (byte) r5
            r3[r10] = r5
            r4 = r4 & 255(0xff, float:3.57E-43)
            byte r4 = (byte) r4
            r3[r11] = r4
            r0.zzh = r14
            r0.zzi = r13
            if (r2 == r11) goto L_0x027f
            if (r2 != r14) goto L_0x0275
            goto L_0x027f
        L_0x0275:
            if (r2 != r15) goto L_0x027b
            r0.zzg = r15
            goto L_0x0009
        L_0x027b:
            r0.zzg = r10
            goto L_0x0009
        L_0x027f:
            r0.zzg = r14
            goto L_0x0009
        L_0x0283:
            r2 = r13
        L_0x0284:
            com.google.android.gms.internal.ads.zzeq.zzf(r2)
            com.google.android.gms.internal.ads.zzafa r3 = r0.zzf
            long r4 = r0.zzp
            int r2 = r0.zzm
            if (r2 != r14) goto L_0x0291
            r6 = r13
            goto L_0x0292
        L_0x0291:
            r6 = r15
        L_0x0292:
            int r7 = r0.zzl
            r8 = 0
            r9 = 0
            r3.zzs(r4, r6, r7, r8, r9)
            long r2 = r0.zzp
            long r4 = r0.zzj
            long r2 = r2 + r4
            r0.zzp = r2
            r0.zzg = r13
            goto L_0x0009
        L_0x02a4:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaoa.zza(com.google.android.gms.internal.ads.zzfu):void");
    }

    public final void zzb(zzadx zzadx, zzapo zzapo) {
        zzapo.zzc();
        this.zze = zzapo.zzb();
        this.zzf = zzadx.zzw(zzapo.zza(), 1);
    }

    public final void zzc() {
    }

    public final void zzd(long j, int i) {
        this.zzp = j;
    }

    public final void zze() {
        this.zzg = 0;
        this.zzh = 0;
        this.zzi = 0;
        this.zzp = -9223372036854775807L;
        this.zzb.set(0);
    }
}
