package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzans implements zzaoc {
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

    public zzans() {
        throw null;
    }

    public zzans(String str, int i) {
        this.zza = new zzft(new byte[128], 128);
        this.zzb = new zzfu(this.zza.zza);
        this.zzg = 0;
        this.zzm = -9223372036854775807L;
        this.zzc = str;
        this.zzd = i;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x00eb, code lost:
        if (r12.zzb() <= 0) goto L_0x0005;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x00f1, code lost:
        if (r11.zzi != false) goto L_0x00ff;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00f7, code lost:
        if (r12.zzm() != 11) goto L_0x00fb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00f9, code lost:
        r0 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00fb, code lost:
        r0 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00fc, code lost:
        r11.zzi = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00ff, code lost:
        r0 = r12.zzm();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0105, code lost:
        if (r0 != 119) goto L_0x011d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0107, code lost:
        r11.zzi = false;
        r11.zzg = 1;
        r0 = r11.zzb;
        r0.zzM()[0] = com.google.common.base.Ascii.VT;
        r0.zzM()[1] = 119;
        r11.zzh = 2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x011d, code lost:
        if (r0 != 11) goto L_0x0121;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x011f, code lost:
        r0 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0121, code lost:
        r0 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0122, code lost:
        r11.zzi = r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(com.google.android.gms.internal.ads.zzfu r12) {
        /*
            r11 = this;
            com.google.android.gms.internal.ads.zzafa r0 = r11.zzf
            com.google.android.gms.internal.ads.zzeq.zzb(r0)
        L_0x0005:
            int r0 = r12.zzb()
            if (r0 <= 0) goto L_0x0140
            int r0 = r11.zzg
            r1 = 2
            r2 = 1
            r3 = 0
            switch(r0) {
                case 0: goto L_0x00e7;
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
            if (r0 == 0) goto L_0x0125
            goto L_0x0126
        L_0x003b:
            com.google.android.gms.internal.ads.zzfu r0 = r11.zzb
            byte[] r0 = r0.zzM()
            int r2 = r12.zzb()
            int r4 = r11.zzh
            r5 = 128(0x80, float:1.794E-43)
            int r4 = 128 - r4
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
            com.google.android.gms.internal.ads.zzacs r0 = com.google.android.gms.internal.ads.zzact.zze(r0)
            com.google.android.gms.internal.ads.zzan r2 = r11.zzk
            if (r2 == 0) goto L_0x0080
            int r4 = r0.zzc
            int r6 = r2.zzA
            if (r4 != r6) goto L_0x0080
            int r4 = r0.zzb
            int r6 = r2.zzB
            if (r4 != r6) goto L_0x0080
            java.lang.String r4 = r0.zza
            java.lang.String r2 = r2.zzn
            boolean r2 = com.google.android.gms.internal.ads.zzgd.zzG(r4, r2)
            if (r2 != 0) goto L_0x00c4
        L_0x0080:
            com.google.android.gms.internal.ads.zzal r2 = new com.google.android.gms.internal.ads.zzal
            r2.<init>()
            java.lang.String r4 = r11.zze
            r2.zzK(r4)
            java.lang.String r4 = r0.zza
            r2.zzX(r4)
            int r4 = r0.zzc
            r2.zzy(r4)
            int r4 = r0.zzb
            r2.zzY(r4)
            java.lang.String r4 = r11.zzc
            r2.zzO(r4)
            int r4 = r11.zzd
            r2.zzV(r4)
            int r4 = r0.zzf
            r2.zzS(r4)
            java.lang.String r4 = r0.zza
            java.lang.String r6 = "audio/ac3"
            boolean r4 = r6.equals(r4)
            if (r4 == 0) goto L_0x00b7
            int r4 = r0.zzf
            r2.zzx(r4)
        L_0x00b7:
            com.google.android.gms.internal.ads.zzan r2 = r2.zzad()
            r11.zzk = r2
            com.google.android.gms.internal.ads.zzafa r2 = r11.zzf
            com.google.android.gms.internal.ads.zzan r4 = r11.zzk
            r2.zzl(r4)
        L_0x00c4:
            int r2 = r0.zzd
            r11.zzl = r2
            int r0 = r0.zze
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
        L_0x00e7:
            int r0 = r12.zzb()
            if (r0 <= 0) goto L_0x0005
            boolean r0 = r11.zzi
            r4 = 11
            if (r0 != 0) goto L_0x00ff
            int r0 = r12.zzm()
            if (r0 != r4) goto L_0x00fb
            r0 = r2
            goto L_0x00fc
        L_0x00fb:
            r0 = r3
        L_0x00fc:
            r11.zzi = r0
            goto L_0x00e7
        L_0x00ff:
            int r0 = r12.zzm()
            r5 = 119(0x77, float:1.67E-43)
            if (r0 != r5) goto L_0x011d
            r11.zzi = r3
            r11.zzg = r2
            com.google.android.gms.internal.ads.zzfu r0 = r11.zzb
            byte[] r6 = r0.zzM()
            r6[r3] = r4
            byte[] r0 = r0.zzM()
            r0[r2] = r5
            r11.zzh = r1
            goto L_0x0005
        L_0x011d:
            if (r0 != r4) goto L_0x0121
            r0 = r2
            goto L_0x0122
        L_0x0121:
            r0 = r3
        L_0x0122:
            r11.zzi = r0
            goto L_0x00e7
        L_0x0125:
            r2 = r3
        L_0x0126:
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
        L_0x0140:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzans.zza(com.google.android.gms.internal.ads.zzfu):void");
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
