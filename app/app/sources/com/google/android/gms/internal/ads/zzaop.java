package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzaop implements zzaoc {
    private final String zza;
    private final int zzb;
    private final zzfu zzc = new zzfu(1024);
    private final zzft zzd;
    private zzafa zze;
    private String zzf;
    private zzan zzg;
    private int zzh;
    private int zzi;
    private int zzj;
    private int zzk;
    private long zzl;
    private boolean zzm;
    private int zzn;
    private int zzo;
    private int zzp;
    private boolean zzq;
    private long zzr;
    private int zzs;
    private long zzt;
    private int zzu;
    private String zzv;

    public zzaop(String str, int i) {
        this.zza = str;
        this.zzb = i;
        byte[] zzM = this.zzc.zzM();
        this.zzd = new zzft(zzM, zzM.length);
        this.zzl = -9223372036854775807L;
    }

    private final int zzf(zzft zzft) throws zzch {
        int zza2 = zzft.zza();
        zzacp zzb2 = zzacq.zzb(zzft, true);
        this.zzv = zzb2.zzc;
        this.zzs = zzb2.zza;
        this.zzu = zzb2.zzb;
        return zza2 - zzft.zza();
    }

    private static long zzg(zzft zzft) {
        return (long) zzft.zzd((zzft.zzd(2) + 1) * 8);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:63:0x0197, code lost:
        if (r13.zzm == false) goto L_0x0204;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(com.google.android.gms.internal.ads.zzfu r14) throws com.google.android.gms.internal.ads.zzch {
        /*
            r13 = this;
            com.google.android.gms.internal.ads.zzafa r0 = r13.zze
            com.google.android.gms.internal.ads.zzeq.zzb(r0)
        L_0x0005:
            int r0 = r14.zzb()
            if (r0 <= 0) goto L_0x021c
            int r0 = r13.zzh
            r1 = 86
            r2 = 3
            r3 = 8
            r4 = 0
            r5 = 1
            switch(r0) {
                case 0: goto L_0x0092;
                case 1: goto L_0x007b;
                case 2: goto L_0x0052;
                default: goto L_0x0017;
            }
        L_0x0017:
            int r0 = r14.zzb()
            int r1 = r13.zzj
            int r6 = r13.zzi
            int r1 = r1 - r6
            int r0 = java.lang.Math.min(r0, r1)
            com.google.android.gms.internal.ads.zzft r1 = r13.zzd
            byte[] r1 = r1.zza
            int r6 = r13.zzi
            r14.zzG(r1, r6, r0)
            int r1 = r13.zzi
            int r1 = r1 + r0
            r13.zzi = r1
            int r0 = r13.zzj
            if (r1 != r0) goto L_0x0005
            com.google.android.gms.internal.ads.zzft r0 = r13.zzd
            r0.zzk(r4)
            com.google.android.gms.internal.ads.zzft r0 = r13.zzd
            boolean r1 = r0.zzo()
            r6 = 0
            if (r1 != 0) goto L_0x0195
            r13.zzm = r5
            int r1 = r0.zzd(r5)
            if (r1 != r5) goto L_0x009c
            int r1 = r0.zzd(r5)
            r7 = r5
            goto L_0x009e
        L_0x0052:
            int r0 = r13.zzk
            r0 = r0 & -225(0xffffffffffffff1f, float:NaN)
            int r0 = r0 << r3
            int r1 = r14.zzm()
            r0 = r0 | r1
            r13.zzj = r0
            com.google.android.gms.internal.ads.zzfu r1 = r13.zzc
            byte[] r3 = r1.zzM()
            int r3 = r3.length
            if (r0 <= r3) goto L_0x0076
            r1.zzH(r0)
            com.google.android.gms.internal.ads.zzft r0 = r13.zzd
            com.google.android.gms.internal.ads.zzfu r1 = r13.zzc
            byte[] r1 = r1.zzM()
            int r3 = r1.length
            r0.zzj(r1, r3)
        L_0x0076:
            r13.zzi = r4
            r13.zzh = r2
            goto L_0x0005
        L_0x007b:
            int r0 = r14.zzm()
            r2 = r0 & 224(0xe0, float:3.14E-43)
            r3 = 224(0xe0, float:3.14E-43)
            if (r2 != r3) goto L_0x008c
            r13.zzk = r0
            r0 = 2
            r13.zzh = r0
            goto L_0x0005
        L_0x008c:
            if (r0 == r1) goto L_0x0005
            r13.zzh = r4
            goto L_0x0005
        L_0x0092:
            int r0 = r14.zzm()
            if (r0 != r1) goto L_0x0005
            r13.zzh = r5
            goto L_0x0005
        L_0x009c:
            r7 = r1
            r1 = r4
        L_0x009e:
            r13.zzn = r1
            if (r1 != 0) goto L_0x018f
            if (r7 != r5) goto L_0x00a8
            zzg(r0)
            r7 = r5
        L_0x00a8:
            boolean r1 = r0.zzo()
            if (r1 == 0) goto L_0x018a
            r1 = 6
            int r8 = r0.zzd(r1)
            r13.zzo = r8
            r8 = 4
            int r8 = r0.zzd(r8)
            int r9 = r0.zzd(r2)
            if (r8 != 0) goto L_0x0185
            if (r9 != 0) goto L_0x0185
            if (r7 != 0) goto L_0x0124
            int r8 = r0.zzc()
            int r9 = r13.zzf(r0)
            r0.zzk(r8)
            int r8 = r9 + 7
            int r8 = r8 / r3
            byte[] r8 = new byte[r8]
            r0.zzg(r8, r4, r9)
            com.google.android.gms.internal.ads.zzal r9 = new com.google.android.gms.internal.ads.zzal
            r9.<init>()
            java.lang.String r10 = r13.zzf
            r9.zzK(r10)
            java.lang.String r10 = "audio/mp4a-latm"
            r9.zzX(r10)
            java.lang.String r10 = r13.zzv
            r9.zzz(r10)
            int r10 = r13.zzu
            r9.zzy(r10)
            int r10 = r13.zzs
            r9.zzY(r10)
            java.util.List r8 = java.util.Collections.singletonList(r8)
            r9.zzL(r8)
            java.lang.String r8 = r13.zza
            r9.zzO(r8)
            int r8 = r13.zzb
            r9.zzV(r8)
            com.google.android.gms.internal.ads.zzan r8 = r9.zzad()
            com.google.android.gms.internal.ads.zzan r9 = r13.zzg
            boolean r9 = r8.equals(r9)
            if (r9 != 0) goto L_0x0131
            r13.zzg = r8
            int r9 = r8.zzB
            long r9 = (long) r9
            r11 = 1024000000(0x3d090000, double:5.059232213E-315)
            long r11 = r11 / r9
            r13.zzt = r11
            com.google.android.gms.internal.ads.zzafa r9 = r13.zze
            r9.zzl(r8)
            goto L_0x0131
        L_0x0124:
            long r8 = zzg(r0)
            int r8 = (int) r8
            int r9 = r13.zzf(r0)
            int r8 = r8 - r9
            r0.zzm(r8)
        L_0x0131:
            int r2 = r0.zzd(r2)
            r13.zzp = r2
            switch(r2) {
                case 0: goto L_0x0151;
                case 1: goto L_0x014a;
                case 2: goto L_0x013b;
                case 3: goto L_0x0145;
                case 4: goto L_0x0145;
                case 5: goto L_0x0145;
                case 6: goto L_0x0141;
                case 7: goto L_0x0141;
                default: goto L_0x013b;
            }
        L_0x013b:
            java.lang.IllegalStateException r14 = new java.lang.IllegalStateException
            r14.<init>()
            throw r14
        L_0x0141:
            r0.zzm(r5)
            goto L_0x0155
        L_0x0145:
            r0.zzm(r1)
            goto L_0x0155
        L_0x014a:
            r1 = 9
            r0.zzm(r1)
            goto L_0x0155
        L_0x0151:
            r0.zzm(r3)
        L_0x0155:
            boolean r1 = r0.zzo()
            r13.zzq = r1
            r8 = 0
            r13.zzr = r8
            if (r1 == 0) goto L_0x017b
            if (r7 == r5) goto L_0x0175
        L_0x0163:
            boolean r1 = r0.zzo()
            long r7 = r13.zzr
            long r7 = r7 << r3
            int r2 = r0.zzd(r3)
            long r9 = (long) r2
            long r7 = r7 + r9
            r13.zzr = r7
            if (r1 != 0) goto L_0x0163
            goto L_0x017b
        L_0x0175:
            long r1 = zzg(r0)
            r13.zzr = r1
        L_0x017b:
            boolean r1 = r0.zzo()
            if (r1 == 0) goto L_0x019a
            r0.zzm(r3)
            goto L_0x019a
        L_0x0185:
            com.google.android.gms.internal.ads.zzch r14 = com.google.android.gms.internal.ads.zzch.zza(r6, r6)
            throw r14
        L_0x018a:
            com.google.android.gms.internal.ads.zzch r14 = com.google.android.gms.internal.ads.zzch.zza(r6, r6)
            throw r14
        L_0x018f:
            com.google.android.gms.internal.ads.zzch r14 = com.google.android.gms.internal.ads.zzch.zza(r6, r6)
            throw r14
        L_0x0195:
            boolean r1 = r13.zzm
            if (r1 != 0) goto L_0x019a
            goto L_0x0204
        L_0x019a:
            int r1 = r13.zzn
            if (r1 != 0) goto L_0x0216
            int r1 = r13.zzo
            if (r1 != 0) goto L_0x0210
            int r1 = r13.zzp
            if (r1 != 0) goto L_0x020a
            r1 = r4
        L_0x01a7:
            int r2 = r0.zzd(r3)
            int r10 = r1 + r2
            r1 = 255(0xff, float:3.57E-43)
            if (r2 == r1) goto L_0x0208
            int r1 = r0.zzc()
            r2 = r1 & 7
            if (r2 != 0) goto L_0x01c2
            com.google.android.gms.internal.ads.zzfu r2 = r13.zzc
            int r1 = r1 >> 3
            r2.zzK(r1)
            goto L_0x01d2
        L_0x01c2:
            com.google.android.gms.internal.ads.zzfu r1 = r13.zzc
            int r2 = r10 * 8
            byte[] r1 = r1.zzM()
            r0.zzg(r1, r4, r2)
            com.google.android.gms.internal.ads.zzfu r1 = r13.zzc
            r1.zzK(r4)
        L_0x01d2:
            com.google.android.gms.internal.ads.zzafa r1 = r13.zze
            com.google.android.gms.internal.ads.zzfu r2 = r13.zzc
            r1.zzq(r2, r10)
            long r1 = r13.zzl
            r6 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r1 = (r1 > r6 ? 1 : (r1 == r6 ? 0 : -1))
            if (r1 == 0) goto L_0x01e5
            goto L_0x01e6
        L_0x01e5:
            r5 = r4
        L_0x01e6:
            com.google.android.gms.internal.ads.zzeq.zzf(r5)
            com.google.android.gms.internal.ads.zzafa r6 = r13.zze
            long r7 = r13.zzl
            r9 = 1
            r11 = 0
            r12 = 0
            r6.zzs(r7, r9, r10, r11, r12)
            long r1 = r13.zzl
            long r5 = r13.zzt
            long r1 = r1 + r5
            r13.zzl = r1
            boolean r1 = r13.zzq
            if (r1 == 0) goto L_0x0204
            long r1 = r13.zzr
            int r1 = (int) r1
            r0.zzm(r1)
        L_0x0204:
            r13.zzh = r4
            goto L_0x0005
        L_0x0208:
            r1 = r10
            goto L_0x01a7
        L_0x020a:
            com.google.android.gms.internal.ads.zzch r14 = com.google.android.gms.internal.ads.zzch.zza(r6, r6)
            throw r14
        L_0x0210:
            com.google.android.gms.internal.ads.zzch r14 = com.google.android.gms.internal.ads.zzch.zza(r6, r6)
            throw r14
        L_0x0216:
            com.google.android.gms.internal.ads.zzch r14 = com.google.android.gms.internal.ads.zzch.zza(r6, r6)
            throw r14
        L_0x021c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaop.zza(com.google.android.gms.internal.ads.zzfu):void");
    }

    public final void zzb(zzadx zzadx, zzapo zzapo) {
        zzapo.zzc();
        this.zze = zzadx.zzw(zzapo.zza(), 1);
        this.zzf = zzapo.zzb();
    }

    public final void zzc() {
    }

    public final void zzd(long j, int i) {
        this.zzl = j;
    }

    public final void zze() {
        this.zzh = 0;
        this.zzl = -9223372036854775807L;
        this.zzm = false;
    }
}
