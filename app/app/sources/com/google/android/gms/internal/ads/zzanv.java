package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzanv implements zzaoc {
    private final zzft zza;
    private final zzfu zzb;
    private final String zzc;
    private final int zzd;
    private String zze;
    private zzafa zzf;
    private int zzg;
    private int zzh;
    private boolean zzi;
    private long zzj;
    private zzan zzk;
    private int zzl;
    private long zzm;

    public zzanv() {
        throw null;
    }

    public zzanv(String str, int i) {
        this.zza = new zzft(new byte[16], 16);
        this.zzb = new zzfu(this.zza.zza);
        this.zzg = 0;
        this.zzh = 0;
        this.zzi = false;
        this.zzm = -9223372036854775807L;
        this.zzc = str;
        this.zzd = i;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x00d1, code lost:
        if (r12.zzb() <= 0) goto L_0x0005;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x00d7, code lost:
        if (r11.zzi != false) goto L_0x00e5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x00dd, code lost:
        if (r12.zzm() != 172) goto L_0x00e1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x00df, code lost:
        r0 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x00e1, code lost:
        r0 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00e2, code lost:
        r11.zzi = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00e5, code lost:
        r0 = r12.zzm();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00e9, code lost:
        if (r0 != 172) goto L_0x00ed;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00eb, code lost:
        r4 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00ed, code lost:
        r4 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00ee, code lost:
        r11.zzi = r4;
        r4 = com.google.common.primitives.SignedBytes.MAX_POWER_OF_TWO;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00f4, code lost:
        if (r0 == 64) goto L_0x00fb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00f6, code lost:
        if (r0 != 65) goto L_0x00cd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00f8, code lost:
        r0 = 65;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00fb, code lost:
        r11.zzg = 1;
        r6 = r11.zzb;
        r6.zzM()[0] = -84;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0107, code lost:
        if (r0 != 65) goto L_0x010c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x0109, code lost:
        r4 = 65;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x010c, code lost:
        r6.zzM()[1] = r4;
        r11.zzh = 2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(com.google.android.gms.internal.ads.zzfu r12) {
        /*
            r11 = this;
            com.google.android.gms.internal.ads.zzafa r0 = r11.zzf
            com.google.android.gms.internal.ads.zzeq.zzb(r0)
        L_0x0005:
            int r0 = r12.zzb()
            if (r0 <= 0) goto L_0x0131
            int r0 = r11.zzg
            r1 = 2
            r2 = 1
            r3 = 0
            switch(r0) {
                case 0: goto L_0x00cd;
                case 1: goto L_0x003b;
                default: goto L_0x0013;
            }
        L_0x0013:
            int r0 = r12.zzb()
            int r1 = r11.zzl
            int r4 = r11.zzh
            int r1 = r1 - r4
            int r0 = java.lang.Math.min(r0, r1)
            com.google.android.gms.internal.ads.zzafa r1 = r11.zzf
            r1.zzq(r12, r0)
            int r1 = r11.zzh
            int r1 = r1 + r0
            r11.zzh = r1
            int r0 = r11.zzl
            if (r1 != r0) goto L_0x0005
            long r0 = r11.zzm
            r4 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r0 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r0 == 0) goto L_0x0116
            goto L_0x0117
        L_0x003b:
            com.google.android.gms.internal.ads.zzfu r0 = r11.zzb
            byte[] r0 = r0.zzM()
            int r2 = r12.zzb()
            int r4 = r11.zzh
            r5 = 16
            int r4 = 16 - r4
            int r2 = java.lang.Math.min(r2, r4)
            int r4 = r11.zzh
            r12.zzG(r0, r4, r2)
            int r0 = r11.zzh
            int r0 = r0 + r2
            r11.zzh = r0
            if (r0 != r5) goto L_0x0005
            com.google.android.gms.internal.ads.zzft r0 = r11.zza
            r0.zzk(r3)
            com.google.android.gms.internal.ads.zzft r0 = r11.zza
            com.google.android.gms.internal.ads.zzacv r0 = com.google.android.gms.internal.ads.zzacw.zza(r0)
            com.google.android.gms.internal.ads.zzan r2 = r11.zzk
            java.lang.String r4 = "audio/ac4"
            if (r2 == 0) goto L_0x007e
            int r6 = r2.zzA
            if (r6 != r1) goto L_0x007e
            int r6 = r0.zza
            int r7 = r2.zzB
            if (r6 != r7) goto L_0x007e
            java.lang.String r2 = r2.zzn
            boolean r2 = r4.equals(r2)
            if (r2 != 0) goto L_0x00aa
        L_0x007e:
            com.google.android.gms.internal.ads.zzal r2 = new com.google.android.gms.internal.ads.zzal
            r2.<init>()
            java.lang.String r6 = r11.zze
            r2.zzK(r6)
            r2.zzX(r4)
            r2.zzy(r1)
            int r4 = r0.zza
            r2.zzY(r4)
            java.lang.String r4 = r11.zzc
            r2.zzO(r4)
            int r4 = r11.zzd
            r2.zzV(r4)
            com.google.android.gms.internal.ads.zzan r2 = r2.zzad()
            r11.zzk = r2
            com.google.android.gms.internal.ads.zzafa r2 = r11.zzf
            com.google.android.gms.internal.ads.zzan r4 = r11.zzk
            r2.zzl(r4)
        L_0x00aa:
            int r2 = r0.zzb
            r11.zzl = r2
            int r0 = r0.zzc
            com.google.android.gms.internal.ads.zzan r2 = r11.zzk
            int r2 = r2.zzB
            long r6 = (long) r0
            r8 = 1000000(0xf4240, double:4.940656E-318)
            long r6 = r6 * r8
            long r8 = (long) r2
            long r6 = r6 / r8
            r11.zzj = r6
            com.google.android.gms.internal.ads.zzfu r0 = r11.zzb
            r0.zzK(r3)
            com.google.android.gms.internal.ads.zzafa r0 = r11.zzf
            com.google.android.gms.internal.ads.zzfu r2 = r11.zzb
            r0.zzq(r2, r5)
            r11.zzg = r1
            goto L_0x0005
        L_0x00cd:
            int r0 = r12.zzb()
            if (r0 <= 0) goto L_0x0005
            boolean r0 = r11.zzi
            r4 = 172(0xac, float:2.41E-43)
            if (r0 != 0) goto L_0x00e5
            int r0 = r12.zzm()
            if (r0 != r4) goto L_0x00e1
            r0 = r2
            goto L_0x00e2
        L_0x00e1:
            r0 = r3
        L_0x00e2:
            r11.zzi = r0
            goto L_0x00cd
        L_0x00e5:
            int r0 = r12.zzm()
            if (r0 != r4) goto L_0x00ed
            r4 = r2
            goto L_0x00ee
        L_0x00ed:
            r4 = r3
        L_0x00ee:
            r11.zzi = r4
            r4 = 64
            r5 = 65
            if (r0 == r4) goto L_0x00fa
            if (r0 != r5) goto L_0x00cd
            r0 = r5
            goto L_0x00fb
        L_0x00fa:
        L_0x00fb:
            r11.zzg = r2
            com.google.android.gms.internal.ads.zzfu r6 = r11.zzb
            byte[] r7 = r6.zzM()
            r8 = -84
            r7[r3] = r8
            if (r0 != r5) goto L_0x010b
            r4 = r5
            goto L_0x010c
        L_0x010b:
        L_0x010c:
            byte[] r0 = r6.zzM()
            r0[r2] = r4
            r11.zzh = r1
            goto L_0x0005
        L_0x0116:
            r2 = r3
        L_0x0117:
            com.google.android.gms.internal.ads.zzeq.zzf(r2)
            com.google.android.gms.internal.ads.zzafa r4 = r11.zzf
            long r5 = r11.zzm
            int r8 = r11.zzl
            r7 = 1
            r9 = 0
            r10 = 0
            r4.zzs(r5, r7, r8, r9, r10)
            long r0 = r11.zzm
            long r4 = r11.zzj
            long r0 = r0 + r4
            r11.zzm = r0
            r11.zzg = r3
            goto L_0x0005
        L_0x0131:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzanv.zza(com.google.android.gms.internal.ads.zzfu):void");
    }

    public final void zzb(zzadx zzadx, zzapo zzapo) {
        zzapo.zzc();
        this.zze = zzapo.zzb();
        this.zzf = zzadx.zzw(zzapo.zza(), 1);
    }

    public final void zzc() {
    }

    public final void zzd(long j, int i) {
        this.zzm = j;
    }

    public final void zze() {
        this.zzg = 0;
        this.zzh = 0;
        this.zzi = false;
        this.zzm = -9223372036854775807L;
    }
}
