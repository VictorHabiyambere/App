package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzaoe implements zzaoc {
    private static final double[] zza = {23.976023976023978d, 24.0d, 25.0d, 29.97002997002997d, 30.0d, 50.0d, 59.94005994005994d, 60.0d};
    private String zzb;
    private zzafa zzc;
    private final zzapr zzd;
    private final zzfu zze;
    private final zzaor zzf;
    private final boolean[] zzg;
    private final zzaod zzh;
    private long zzi;
    private boolean zzj;
    private boolean zzk;
    private long zzl;
    private long zzm;
    private long zzn;
    private long zzo;
    private boolean zzp;
    private boolean zzq;

    public zzaoe() {
        throw null;
    }

    zzaoe(zzapr zzapr) {
        zzfu zzfu;
        this.zzd = zzapr;
        this.zzg = new boolean[4];
        this.zzh = new zzaod(128);
        if (zzapr != null) {
            this.zzf = new zzaor(178, 128);
            zzfu = new zzfu();
        } else {
            zzfu = null;
            this.zzf = null;
        }
        this.zze = zzfu;
        this.zzm = -9223372036854775807L;
        this.zzo = -9223372036854775807L;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:26:0x00af, code lost:
        r14 = ((float) r14) / ((float) r15);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x00b2, code lost:
        r15 = new com.google.android.gms.internal.ads.zzal();
        r15.zzK(r12);
        r15.zzX("video/mpeg2");
        r15.zzac(r10);
        r15.zzI(r11);
        r15.zzT(r14);
        r15.zzL(java.util.Collections.singletonList(r13));
        r10 = r15.zzad();
        r11 = (r13[7] & com.google.common.base.Ascii.SI) - 1;
        r14 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x00db, code lost:
        if (r11 < 0) goto L_0x0109;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00df, code lost:
        if (r11 >= 8) goto L_0x0109;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00e1, code lost:
        r11 = zza[r11];
        r9 = r13[r9.zzb + 9];
        r13 = (r9 & 96) >> 5;
        r9 = r9 & com.google.common.base.Ascii.US;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00f1, code lost:
        if (r13 == r9) goto L_0x00ff;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00f3, code lost:
        r16 = r7;
        r11 = r11 * ((((double) r13) + 1.0d) / ((double) (r9 + 1)));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00ff, code lost:
        r16 = r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0101, code lost:
        r14 = (long) (1000000.0d / r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0109, code lost:
        r16 = r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x010b, code lost:
        r6 = android.util.Pair.create(r10, java.lang.Long.valueOf(r14));
        r0.zzc.zzl((com.google.android.gms.internal.ads.zzan) r6.first);
        r0.zzl = ((java.lang.Long) r6.second).longValue();
        r0.zzk = true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(com.google.android.gms.internal.ads.zzfu r21) {
        /*
            r20 = this;
            r0 = r20
            com.google.android.gms.internal.ads.zzafa r1 = r0.zzc
            com.google.android.gms.internal.ads.zzeq.zzb(r1)
            int r1 = r21.zzd()
            int r2 = r21.zze()
            byte[] r3 = r21.zzM()
            long r4 = r0.zzi
            int r6 = r21.zzb()
            long r6 = (long) r6
            long r4 = r4 + r6
            r0.zzi = r4
            com.google.android.gms.internal.ads.zzafa r4 = r0.zzc
            int r5 = r21.zzb()
            r6 = r21
            r4.zzq(r6, r5)
        L_0x0028:
            boolean[] r4 = r0.zzg
            int r4 = com.google.android.gms.internal.ads.zzgr.zza(r3, r1, r2, r4)
            if (r4 != r2) goto L_0x0041
            boolean r4 = r0.zzk
            if (r4 != 0) goto L_0x0039
            com.google.android.gms.internal.ads.zzaod r4 = r0.zzh
            r4.zza(r3, r1, r2)
        L_0x0039:
            com.google.android.gms.internal.ads.zzaor r4 = r0.zzf
            if (r4 == 0) goto L_0x0040
            r4.zza(r3, r1, r2)
        L_0x0040:
            return
        L_0x0041:
            byte[] r5 = r21.zzM()
            int r7 = r4 + 3
            byte r5 = r5[r7]
            r5 = r5 & 255(0xff, float:3.57E-43)
            int r8 = r4 - r1
            boolean r9 = r0.zzk
            if (r9 != 0) goto L_0x0130
            if (r8 <= 0) goto L_0x0058
            com.google.android.gms.internal.ads.zzaod r9 = r0.zzh
            r9.zza(r3, r1, r4)
        L_0x0058:
            if (r8 >= 0) goto L_0x005c
            int r9 = -r8
            goto L_0x005d
        L_0x005c:
            r9 = 0
        L_0x005d:
            com.google.android.gms.internal.ads.zzaod r12 = r0.zzh
            boolean r9 = r12.zzc(r5, r9)
            if (r9 == 0) goto L_0x012d
            com.google.android.gms.internal.ads.zzaod r9 = r0.zzh
            java.lang.String r12 = r0.zzb
            if (r12 == 0) goto L_0x012a
            byte[] r13 = r9.zzc
            int r14 = r9.zza
            byte[] r13 = java.util.Arrays.copyOf(r13, r14)
            r14 = 4
            byte r15 = r13[r14]
            r15 = r15 & 255(0xff, float:3.57E-43)
            r16 = 5
            byte r10 = r13[r16]
            r10 = r10 & 255(0xff, float:3.57E-43)
            r17 = 6
            byte r11 = r13[r17]
            r11 = r11 & 255(0xff, float:3.57E-43)
            r17 = 7
            byte r14 = r13[r17]
            r14 = r14 & 240(0xf0, float:3.36E-43)
            r19 = r10 & 15
            r18 = 4
            int r15 = r15 << 4
            int r10 = r10 >> 4
            r10 = r10 | r15
            int r14 = r14 >> 4
            r15 = 8
            int r18 = r19 << 8
            r11 = r18 | r11
            switch(r14) {
                case 2: goto L_0x00ab;
                case 3: goto L_0x00a6;
                case 4: goto L_0x00a1;
                default: goto L_0x009e;
            }
        L_0x009e:
            r14 = 1065353216(0x3f800000, float:1.0)
            goto L_0x00b2
        L_0x00a1:
            int r14 = r11 * 121
            int r15 = r10 * 100
            goto L_0x00af
        L_0x00a6:
            int r14 = r11 * 16
            int r15 = r10 * 9
            goto L_0x00af
        L_0x00ab:
            int r14 = r11 * 4
            int r15 = r10 * 3
        L_0x00af:
            float r14 = (float) r14
            float r15 = (float) r15
            float r14 = r14 / r15
        L_0x00b2:
            com.google.android.gms.internal.ads.zzal r15 = new com.google.android.gms.internal.ads.zzal
            r15.<init>()
            r15.zzK(r12)
            java.lang.String r12 = "video/mpeg2"
            r15.zzX(r12)
            r15.zzac(r10)
            r15.zzI(r11)
            r15.zzT(r14)
            java.util.List r10 = java.util.Collections.singletonList(r13)
            r15.zzL(r10)
            com.google.android.gms.internal.ads.zzan r10 = r15.zzad()
            byte r11 = r13[r17]
            r11 = r11 & 15
            int r11 = r11 + -1
            r14 = 0
            if (r11 < 0) goto L_0x0109
            r12 = 8
            if (r11 >= r12) goto L_0x0109
            double[] r12 = zza
            r11 = r12[r11]
            int r9 = r9.zzb
            int r9 = r9 + 9
            byte r9 = r13[r9]
            r13 = r9 & 96
            int r13 = r13 >> 5
            r9 = r9 & 31
            if (r13 == r9) goto L_0x00ff
            double r13 = (double) r13
            int r9 = r9 + 1
            r15 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            double r13 = r13 + r15
            r16 = r7
            double r6 = (double) r9
            double r13 = r13 / r6
            double r11 = r11 * r13
            goto L_0x0101
        L_0x00ff:
            r16 = r7
        L_0x0101:
            r6 = 4696837146684686336(0x412e848000000000, double:1000000.0)
            double r6 = r6 / r11
            long r14 = (long) r6
            goto L_0x010b
        L_0x0109:
            r16 = r7
        L_0x010b:
            java.lang.Long r6 = java.lang.Long.valueOf(r14)
            android.util.Pair r6 = android.util.Pair.create(r10, r6)
            com.google.android.gms.internal.ads.zzafa r7 = r0.zzc
            java.lang.Object r9 = r6.first
            com.google.android.gms.internal.ads.zzan r9 = (com.google.android.gms.internal.ads.zzan) r9
            r7.zzl(r9)
            java.lang.Object r6 = r6.second
            java.lang.Long r6 = (java.lang.Long) r6
            long r6 = r6.longValue()
            r0.zzl = r6
            r6 = 1
            r0.zzk = r6
            goto L_0x0132
        L_0x012a:
            r1 = 0
            throw r1
        L_0x012d:
            r16 = r7
            goto L_0x0132
        L_0x0130:
            r16 = r7
        L_0x0132:
            com.google.android.gms.internal.ads.zzaor r6 = r0.zzf
            if (r6 == 0) goto L_0x017c
            if (r8 <= 0) goto L_0x013d
            r6.zza(r3, r1, r4)
            r1 = 0
            goto L_0x013e
        L_0x013d:
            int r1 = -r8
        L_0x013e:
            com.google.android.gms.internal.ads.zzaor r6 = r0.zzf
            boolean r1 = r6.zzd(r1)
            if (r1 == 0) goto L_0x0164
            com.google.android.gms.internal.ads.zzaor r1 = r0.zzf
            byte[] r6 = r1.zza
            int r1 = r1.zzb
            int r1 = com.google.android.gms.internal.ads.zzgr.zzb(r6, r1)
            com.google.android.gms.internal.ads.zzfu r6 = r0.zze
            int r7 = com.google.android.gms.internal.ads.zzgd.zza
            com.google.android.gms.internal.ads.zzaor r7 = r0.zzf
            byte[] r7 = r7.zza
            r6.zzI(r7, r1)
            com.google.android.gms.internal.ads.zzapr r1 = r0.zzd
            long r6 = r0.zzo
            com.google.android.gms.internal.ads.zzfu r8 = r0.zze
            r1.zza(r6, r8)
        L_0x0164:
            r1 = 178(0xb2, float:2.5E-43)
            if (r5 != r1) goto L_0x017c
            byte[] r5 = r21.zzM()
            int r6 = r4 + 2
            byte r5 = r5[r6]
            r6 = 1
            if (r5 != r6) goto L_0x017a
            com.google.android.gms.internal.ads.zzaor r5 = r0.zzf
            r5.zzc(r1)
            r5 = r1
            goto L_0x017d
        L_0x017a:
            r5 = r1
            goto L_0x017d
        L_0x017c:
        L_0x017d:
            if (r5 == 0) goto L_0x018c
            r1 = 179(0xb3, float:2.51E-43)
            if (r5 != r1) goto L_0x0184
            goto L_0x018c
        L_0x0184:
            r1 = 184(0xb8, float:2.58E-43)
            if (r5 != r1) goto L_0x01ec
            r1 = 1
            r0.zzp = r1
            goto L_0x01ec
        L_0x018c:
            int r1 = r2 - r4
            boolean r4 = r0.zzq
            r13 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            if (r4 == 0) goto L_0x01b2
            boolean r4 = r0.zzk
            if (r4 == 0) goto L_0x01b2
            long r7 = r0.zzo
            int r4 = (r7 > r13 ? 1 : (r7 == r13 ? 0 : -1))
            if (r4 == 0) goto L_0x01b2
            boolean r9 = r0.zzp
            long r10 = r0.zzi
            long r13 = r0.zzn
            long r10 = r10 - r13
            int r4 = (int) r10
            int r10 = r4 - r1
            com.google.android.gms.internal.ads.zzafa r6 = r0.zzc
            r12 = 0
            r11 = r1
            r6.zzs(r7, r9, r10, r11, r12)
        L_0x01b2:
            boolean r4 = r0.zzj
            if (r4 == 0) goto L_0x01be
            boolean r4 = r0.zzq
            if (r4 == 0) goto L_0x01bb
            goto L_0x01be
        L_0x01bb:
            r1 = 0
            r4 = 1
            goto L_0x01e5
        L_0x01be:
            long r6 = r0.zzi
            long r8 = (long) r1
            long r6 = r6 - r8
            r0.zzn = r6
            long r6 = r0.zzm
            r8 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r1 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r1 == 0) goto L_0x01d0
            goto L_0x01db
        L_0x01d0:
            long r6 = r0.zzo
            int r1 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r1 == 0) goto L_0x01da
            long r10 = r0.zzl
            long r6 = r6 + r10
            goto L_0x01db
        L_0x01da:
            r6 = r8
        L_0x01db:
            r0.zzo = r6
            r1 = 0
            r0.zzp = r1
            r0.zzm = r8
            r4 = 1
            r0.zzj = r4
        L_0x01e5:
            if (r5 != 0) goto L_0x01e9
            r10 = r4
            goto L_0x01ea
        L_0x01e9:
            r10 = r1
        L_0x01ea:
            r0.zzq = r10
        L_0x01ec:
            r6 = r21
            r1 = r16
            goto L_0x0028
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaoe.zza(com.google.android.gms.internal.ads.zzfu):void");
    }

    public final void zzb(zzadx zzadx, zzapo zzapo) {
        zzapo.zzc();
        this.zzb = zzapo.zzb();
        this.zzc = zzadx.zzw(zzapo.zza(), 2);
        zzapr zzapr = this.zzd;
        if (zzapr != null) {
            zzapr.zzb(zzadx, zzapo);
        }
    }

    public final void zzc() {
    }

    public final void zzd(long j, int i) {
        this.zzm = j;
    }

    public final void zze() {
        zzgr.zzf(this.zzg);
        this.zzh.zzb();
        zzaor zzaor = this.zzf;
        if (zzaor != null) {
            zzaor.zzb();
        }
        this.zzi = 0;
        this.zzj = false;
        this.zzm = -9223372036854775807L;
        this.zzo = -9223372036854775807L;
    }
}
