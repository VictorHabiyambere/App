package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzaot implements zzapp {
    private final zzaoc zza;
    private final zzft zzb = new zzft(new byte[10], 10);
    private int zzc = 0;
    private int zzd;
    private zzgb zze;
    private boolean zzf;
    private boolean zzg;
    private boolean zzh;
    private int zzi;
    private int zzj;
    private boolean zzk;

    public zzaot(zzaoc zzaoc) {
        this.zza = zzaoc;
    }

    private final void zzd(int i) {
        this.zzc = i;
        this.zzd = 0;
    }

    private final boolean zze(zzfu zzfu, byte[] bArr, int i) {
        int min = Math.min(zzfu.zzb(), i - this.zzd);
        if (min <= 0) {
            return true;
        }
        if (bArr == null) {
            zzfu.zzL(min);
        } else {
            zzfu.zzG(bArr, this.zzd, min);
        }
        int i2 = this.zzd + min;
        this.zzd = i2;
        if (i2 == i) {
            return true;
        }
        return false;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(com.google.android.gms.internal.ads.zzfu r20, int r21) throws com.google.android.gms.internal.ads.zzch {
        /*
            r19 = this;
            r0 = r19
            r1 = r20
            com.google.android.gms.internal.ads.zzgb r2 = r0.zze
            com.google.android.gms.internal.ads.zzeq.zzb(r2)
            r2 = r21 & 1
            java.lang.String r3 = "PesReader"
            r4 = -1
            r5 = 1
            if (r2 == 0) goto L_0x0044
            int r2 = r0.zzc
            switch(r2) {
                case 0: goto L_0x0040;
                case 1: goto L_0x0040;
                case 2: goto L_0x0034;
                default: goto L_0x0016;
            }
        L_0x0016:
            int r2 = r0.zzj
            if (r2 == r4) goto L_0x003b
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = "Unexpected start indicator: expected "
            r6.append(r7)
            r6.append(r2)
            java.lang.String r2 = " more bytes"
            r6.append(r2)
            java.lang.String r2 = r6.toString()
            com.google.android.gms.internal.ads.zzfk.zzf(r3, r2)
            goto L_0x003b
        L_0x0034:
            java.lang.String r2 = "Unexpected start indicator reading extended header"
            com.google.android.gms.internal.ads.zzfk.zzf(r3, r2)
            goto L_0x0040
        L_0x003b:
            com.google.android.gms.internal.ads.zzaoc r2 = r0.zza
            r2.zzc()
        L_0x0040:
            r0.zzd(r5)
        L_0x0044:
            r2 = r21
        L_0x0046:
            int r6 = r20.zzb()
            if (r6 <= 0) goto L_0x0203
            int r6 = r0.zzc
            r7 = 0
            switch(r6) {
                case 0: goto L_0x01cc;
                case 1: goto L_0x0126;
                case 2: goto L_0x005f;
                default: goto L_0x0052;
            }
        L_0x0052:
            r5 = r7
            int r4 = r20.zzb()
            int r6 = r0.zzj
            r7 = -1
            if (r6 != r7) goto L_0x01d6
            r7 = r5
            goto L_0x01d8
        L_0x005f:
            int r6 = r0.zzi
            r8 = 10
            int r6 = java.lang.Math.min(r8, r6)
            com.google.android.gms.internal.ads.zzft r8 = r0.zzb
            byte[] r8 = r8.zza
            boolean r6 = r0.zze(r1, r8, r6)
            if (r6 == 0) goto L_0x0122
            int r6 = r0.zzi
            r8 = 0
            boolean r6 = r0.zze(r1, r8, r6)
            if (r6 == 0) goto L_0x011e
            com.google.android.gms.internal.ads.zzft r6 = r0.zzb
            r6.zzk(r7)
            boolean r6 = r0.zzf
            r8 = 3
            r9 = 4
            if (r6 == 0) goto L_0x0103
            com.google.android.gms.internal.ads.zzft r6 = r0.zzb
            r6.zzm(r9)
            com.google.android.gms.internal.ads.zzft r6 = r0.zzb
            int r6 = r6.zzd(r8)
            long r10 = (long) r6
            com.google.android.gms.internal.ads.zzft r6 = r0.zzb
            r6.zzm(r5)
            com.google.android.gms.internal.ads.zzft r6 = r0.zzb
            r12 = 15
            int r6 = r6.zzd(r12)
            int r6 = r6 << r12
            com.google.android.gms.internal.ads.zzft r13 = r0.zzb
            r13.zzm(r5)
            com.google.android.gms.internal.ads.zzft r13 = r0.zzb
            int r13 = r13.zzd(r12)
            long r13 = (long) r13
            com.google.android.gms.internal.ads.zzft r15 = r0.zzb
            r15.zzm(r5)
            boolean r15 = r0.zzh
            r16 = 30
            if (r15 != 0) goto L_0x00f4
            boolean r15 = r0.zzg
            if (r15 == 0) goto L_0x00f4
            com.google.android.gms.internal.ads.zzft r15 = r0.zzb
            r15.zzm(r9)
            com.google.android.gms.internal.ads.zzft r15 = r0.zzb
            int r15 = r15.zzd(r8)
            long r7 = (long) r15
            long r7 = r7 << r16
            com.google.android.gms.internal.ads.zzft r15 = r0.zzb
            r15.zzm(r5)
            com.google.android.gms.internal.ads.zzft r15 = r0.zzb
            int r15 = r15.zzd(r12)
            int r15 = r15 << r12
            com.google.android.gms.internal.ads.zzft r9 = r0.zzb
            r9.zzm(r5)
            com.google.android.gms.internal.ads.zzft r9 = r0.zzb
            int r9 = r9.zzd(r12)
            long r4 = (long) r9
            com.google.android.gms.internal.ads.zzft r9 = r0.zzb
            r12 = 1
            r9.zzm(r12)
            com.google.android.gms.internal.ads.zzgb r9 = r0.zze
            r17 = r13
            long r12 = (long) r15
            long r7 = r7 | r12
            long r4 = r4 | r7
            r9.zzb(r4)
            r4 = 1
            r0.zzh = r4
            goto L_0x00f6
        L_0x00f4:
            r17 = r13
        L_0x00f6:
            long r4 = r10 << r16
            long r6 = (long) r6
            long r4 = r4 | r6
            long r4 = r4 | r17
            com.google.android.gms.internal.ads.zzgb r6 = r0.zze
            long r4 = r6.zzb(r4)
            goto L_0x0108
        L_0x0103:
            r4 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
        L_0x0108:
            boolean r6 = r0.zzk
            r7 = 1
            if (r7 == r6) goto L_0x010f
            r7 = 0
            goto L_0x0110
        L_0x010f:
            r7 = 4
        L_0x0110:
            r2 = r2 | r7
            com.google.android.gms.internal.ads.zzaoc r6 = r0.zza
            r6.zzd(r4, r2)
            r4 = 3
            r0.zzd(r4)
            r4 = -1
            r5 = 1
            goto L_0x0046
        L_0x011e:
            r4 = 1
            r6 = -1
            goto L_0x01ff
        L_0x0122:
            r4 = 1
            r6 = -1
            goto L_0x01ff
        L_0x0126:
            com.google.android.gms.internal.ads.zzft r4 = r0.zzb
            byte[] r4 = r4.zza
            r5 = 9
            boolean r4 = r0.zze(r1, r4, r5)
            if (r4 == 0) goto L_0x01c9
            com.google.android.gms.internal.ads.zzft r4 = r0.zzb
            r5 = 0
            r4.zzk(r5)
            com.google.android.gms.internal.ads.zzft r4 = r0.zzb
            r6 = 24
            int r4 = r4.zzd(r6)
            r6 = 1
            if (r4 == r6) goto L_0x015c
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = "Unexpected start code prefix: "
            r6.append(r7)
            r6.append(r4)
            java.lang.String r4 = r6.toString()
            com.google.android.gms.internal.ads.zzfk.zzf(r3, r4)
            r4 = -1
            r0.zzj = r4
            r7 = r5
            goto L_0x01c3
        L_0x015c:
            com.google.android.gms.internal.ads.zzft r4 = r0.zzb
            r5 = 8
            r4.zzm(r5)
            com.google.android.gms.internal.ads.zzft r4 = r0.zzb
            com.google.android.gms.internal.ads.zzft r6 = r0.zzb
            r7 = 16
            int r4 = r4.zzd(r7)
            r7 = 5
            r6.zzm(r7)
            com.google.android.gms.internal.ads.zzft r6 = r0.zzb
            boolean r6 = r6.zzo()
            r0.zzk = r6
            com.google.android.gms.internal.ads.zzft r6 = r0.zzb
            r7 = 2
            r6.zzm(r7)
            com.google.android.gms.internal.ads.zzft r6 = r0.zzb
            boolean r6 = r6.zzo()
            r0.zzf = r6
            com.google.android.gms.internal.ads.zzft r6 = r0.zzb
            boolean r6 = r6.zzo()
            r0.zzg = r6
            com.google.android.gms.internal.ads.zzft r6 = r0.zzb
            r8 = 6
            r6.zzm(r8)
            com.google.android.gms.internal.ads.zzft r6 = r0.zzb
            int r5 = r6.zzd(r5)
            r0.zzi = r5
            if (r4 != 0) goto L_0x01a3
            r4 = -1
            r0.zzj = r4
            goto L_0x01c3
        L_0x01a3:
            int r4 = r4 + -3
            int r4 = r4 - r5
            r0.zzj = r4
            if (r4 >= 0) goto L_0x01c2
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "Found negative packet payload size: "
            r5.append(r6)
            r5.append(r4)
            java.lang.String r4 = r5.toString()
            com.google.android.gms.internal.ads.zzfk.zzf(r3, r4)
            r4 = -1
            r0.zzj = r4
            goto L_0x01c3
        L_0x01c2:
        L_0x01c3:
            r0.zzd(r7)
            r4 = 1
            r6 = -1
            goto L_0x01ff
        L_0x01c9:
            r4 = 1
            r6 = -1
            goto L_0x01ff
        L_0x01cc:
            int r4 = r20.zzb()
            r1.zzL(r4)
            r4 = 1
            r6 = -1
            goto L_0x01ff
        L_0x01d6:
            int r7 = r4 - r6
        L_0x01d8:
            if (r7 <= 0) goto L_0x01e4
            int r4 = r4 - r7
            int r5 = r20.zzd()
            int r5 = r5 + r4
            r1.zzJ(r5)
            goto L_0x01e5
        L_0x01e4:
        L_0x01e5:
            com.google.android.gms.internal.ads.zzaoc r5 = r0.zza
            r5.zza(r1)
            int r5 = r0.zzj
            r6 = -1
            if (r5 == r6) goto L_0x01fe
            int r5 = r5 - r4
            r0.zzj = r5
            if (r5 != 0) goto L_0x01fe
            com.google.android.gms.internal.ads.zzaoc r4 = r0.zza
            r4.zzc()
            r4 = 1
            r0.zzd(r4)
            goto L_0x01ff
        L_0x01fe:
            r4 = 1
        L_0x01ff:
            r5 = r4
            r4 = r6
            goto L_0x0046
        L_0x0203:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaot.zza(com.google.android.gms.internal.ads.zzfu, int):void");
    }

    public final void zzb(zzgb zzgb, zzadx zzadx, zzapo zzapo) {
        this.zze = zzgb;
        this.zza.zzb(zzadx, zzapo);
    }

    public final void zzc() {
        this.zzc = 0;
        this.zzd = 0;
        this.zzh = false;
        this.zza.zze();
    }
}
