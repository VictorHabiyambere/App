package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
final class zzzd extends zzza {
    private final boolean zze;
    private final zzys zzf;
    private final boolean zzg;
    private final boolean zzh;
    private final boolean zzi;
    private final int zzj;
    private final int zzk;
    private final int zzl;
    private final int zzm;
    private final boolean zzn;
    private final int zzo;
    private final boolean zzp;
    private final boolean zzq;
    private final int zzr;

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0031, code lost:
        if (r2 <= 2.14748365E9f) goto L_0x0033;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x004a, code lost:
        if (r1 >= 0) goto L_0x004c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0052, code lost:
        if (r1 >= 0) goto L_0x0054;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x005f, code lost:
        if (r1 >= 0.0f) goto L_0x0061;
     */
    /* JADX WARNING: Removed duplicated region for block: B:101:0x0143  */
    /* JADX WARNING: Removed duplicated region for block: B:102:0x0145  */
    /* JADX WARNING: Removed duplicated region for block: B:122:0x00ce A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0042  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0084  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0086  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00a5  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00ac  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00b8  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x00d9  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00db  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x00e4  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x00e6  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x00f0  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x00f2  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public zzzd(int r5, com.google.android.gms.internal.ads.zzde r6, int r7, com.google.android.gms.internal.ads.zzys r8, int r9, int r10, boolean r11) {
        /*
            r4 = this;
            r4.<init>(r5, r6, r7)
            r4.zzf = r8
            boolean r5 = r8.zzK
            r6 = 1
            if (r6 == r5) goto L_0x000d
            r5 = 16
            goto L_0x000f
        L_0x000d:
            r5 = 24
        L_0x000f:
            boolean r7 = r8.zzJ
            r7 = -1082130432(0xffffffffbf800000, float:-1.0)
            r10 = -1
            r0 = 0
            if (r11 == 0) goto L_0x003d
            com.google.android.gms.internal.ads.zzan r1 = r4.zzd
            int r2 = r1.zzs
            if (r2 == r10) goto L_0x001f
            int r2 = r8.zzd
        L_0x001f:
            int r2 = r1.zzt
            if (r2 == r10) goto L_0x0025
            int r2 = r8.zze
        L_0x0025:
            float r2 = r1.zzu
            int r3 = (r2 > r7 ? 1 : (r2 == r7 ? 0 : -1))
            if (r3 == 0) goto L_0x0033
            int r3 = r8.zzf
            r3 = 1325400064(0x4f000000, float:2.14748365E9)
            int r2 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
            if (r2 > 0) goto L_0x003d
        L_0x0033:
            int r1 = r1.zzj
            if (r1 == r10) goto L_0x003b
            int r1 = r8.zzg
            r1 = r6
            goto L_0x003e
        L_0x003b:
            r1 = r6
            goto L_0x003e
        L_0x003d:
            r1 = r0
        L_0x003e:
            r4.zze = r1
            if (r11 == 0) goto L_0x006d
            com.google.android.gms.internal.ads.zzan r11 = r4.zzd
            int r1 = r11.zzs
            if (r1 == r10) goto L_0x004c
            int r2 = r8.zzh
            if (r1 < 0) goto L_0x006d
        L_0x004c:
            int r1 = r11.zzt
            if (r1 == r10) goto L_0x0054
            int r2 = r8.zzi
            if (r1 < 0) goto L_0x006d
        L_0x0054:
            float r1 = r11.zzu
            int r2 = (r1 > r7 ? 1 : (r1 == r7 ? 0 : -1))
            if (r2 == 0) goto L_0x0061
            int r2 = r8.zzj
            r2 = 0
            int r1 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r1 < 0) goto L_0x006d
        L_0x0061:
            int r11 = r11.zzj
            if (r11 == r10) goto L_0x006b
            int r1 = r8.zzk
            if (r11 < 0) goto L_0x006d
            r11 = r6
            goto L_0x006e
        L_0x006b:
            r11 = r6
            goto L_0x006e
        L_0x006d:
            r11 = r0
        L_0x006e:
            r4.zzg = r11
            boolean r11 = com.google.android.gms.internal.ads.zzze.zzo(r9, r0)
            r4.zzh = r11
            com.google.android.gms.internal.ads.zzan r11 = r4.zzd
            float r1 = r11.zzu
            int r7 = (r1 > r7 ? 1 : (r1 == r7 ? 0 : -1))
            if (r7 == 0) goto L_0x0086
            r7 = 1092616192(0x41200000, float:10.0)
            int r7 = (r1 > r7 ? 1 : (r1 == r7 ? 0 : -1))
            if (r7 < 0) goto L_0x0086
            r7 = r6
            goto L_0x0087
        L_0x0086:
            r7 = r0
        L_0x0087:
            r4.zzi = r7
            int r7 = r11.zzj
            r4.zzj = r7
            int r7 = r11.zza()
            r4.zzk = r7
            com.google.android.gms.internal.ads.zzan r7 = r4.zzd
            int r7 = r7.zzg
            int r11 = r8.zzp
            int r7 = com.google.android.gms.internal.ads.zzze.zzb(r7, r0)
            r4.zzm = r7
            com.google.android.gms.internal.ads.zzan r7 = r4.zzd
            int r7 = r7.zzg
            if (r7 == 0) goto L_0x00ac
            r7 = r7 & r6
            if (r7 == 0) goto L_0x00aa
            r7 = r6
            goto L_0x00ad
        L_0x00aa:
            r7 = r0
            goto L_0x00ad
        L_0x00ac:
            r7 = r6
        L_0x00ad:
            r4.zzn = r7
            r7 = r0
        L_0x00b0:
            com.google.android.gms.internal.ads.zzgbc r11 = r8.zzo
            int r11 = r11.size()
            if (r7 >= r11) goto L_0x00ce
            com.google.android.gms.internal.ads.zzan r11 = r4.zzd
            java.lang.String r11 = r11.zzn
            if (r11 == 0) goto L_0x00cb
            com.google.android.gms.internal.ads.zzgbc r1 = r8.zzo
            java.lang.Object r1 = r1.get(r7)
            boolean r11 = r11.equals(r1)
            if (r11 == 0) goto L_0x00cb
            goto L_0x00d1
        L_0x00cb:
            int r7 = r7 + 1
            goto L_0x00b0
        L_0x00ce:
            r7 = 2147483647(0x7fffffff, float:NaN)
        L_0x00d1:
            r4.zzl = r7
            r7 = r9 & 384(0x180, float:5.38E-43)
            r8 = 128(0x80, float:1.794E-43)
            if (r7 != r8) goto L_0x00db
            r7 = r6
            goto L_0x00dc
        L_0x00db:
            r7 = r0
        L_0x00dc:
            r4.zzp = r7
            r7 = r9 & 64
            r8 = 64
            if (r7 != r8) goto L_0x00e6
            r7 = r6
            goto L_0x00e7
        L_0x00e6:
            r7 = r0
        L_0x00e7:
            r4.zzq = r7
            com.google.android.gms.internal.ads.zzan r7 = r4.zzd
            java.lang.String r8 = r7.zzn
            r11 = 2
            if (r8 != 0) goto L_0x00f2
            r2 = r0
            goto L_0x013b
        L_0x00f2:
            int r1 = r8.hashCode()
            r2 = 3
            r3 = 4
            switch(r1) {
                case -1851077871: goto L_0x0124;
                case -1662735862: goto L_0x011a;
                case -1662541442: goto L_0x0110;
                case 1331836730: goto L_0x0106;
                case 1599127257: goto L_0x00fc;
                default: goto L_0x00fb;
            }
        L_0x00fb:
            goto L_0x012e
        L_0x00fc:
            java.lang.String r1 = "video/x-vnd.on2.vp9"
            boolean r8 = r8.equals(r1)
            if (r8 == 0) goto L_0x00fb
            r8 = r2
            goto L_0x012f
        L_0x0106:
            java.lang.String r1 = "video/avc"
            boolean r8 = r8.equals(r1)
            if (r8 == 0) goto L_0x00fb
            r8 = r3
            goto L_0x012f
        L_0x0110:
            java.lang.String r1 = "video/hevc"
            boolean r8 = r8.equals(r1)
            if (r8 == 0) goto L_0x00fb
            r8 = r11
            goto L_0x012f
        L_0x011a:
            java.lang.String r1 = "video/av01"
            boolean r8 = r8.equals(r1)
            if (r8 == 0) goto L_0x00fb
            r8 = r6
            goto L_0x012f
        L_0x0124:
            java.lang.String r1 = "video/dolby-vision"
            boolean r8 = r8.equals(r1)
            if (r8 == 0) goto L_0x00fb
            r8 = r0
            goto L_0x012f
        L_0x012e:
            r8 = r10
        L_0x012f:
            switch(r8) {
                case 0: goto L_0x013a;
                case 1: goto L_0x0138;
                case 2: goto L_0x013b;
                case 3: goto L_0x0136;
                case 4: goto L_0x0134;
                default: goto L_0x0132;
            }
        L_0x0132:
            r2 = r0
            goto L_0x013b
        L_0x0134:
            r2 = r6
            goto L_0x013b
        L_0x0136:
            r2 = r11
            goto L_0x013b
        L_0x0138:
            r2 = r3
            goto L_0x013b
        L_0x013a:
            r2 = 5
        L_0x013b:
            r4.zzr = r2
            int r8 = r7.zzg
            r8 = r8 & 16384(0x4000, float:2.2959E-41)
            if (r8 == 0) goto L_0x0145
            r6 = r0
            goto L_0x0175
        L_0x0145:
            com.google.android.gms.internal.ads.zzys r8 = r4.zzf
            boolean r1 = r8.zzT
            boolean r1 = com.google.android.gms.internal.ads.zzze.zzo(r9, r1)
            if (r1 != 0) goto L_0x0151
            r6 = r0
            goto L_0x0175
        L_0x0151:
            boolean r1 = r4.zze
            if (r1 != 0) goto L_0x015b
            boolean r2 = r8.zzI
            if (r2 != 0) goto L_0x015b
            r6 = r0
            goto L_0x0175
        L_0x015b:
            boolean r0 = com.google.android.gms.internal.ads.zzze.zzo(r9, r0)
            if (r0 == 0) goto L_0x0174
            boolean r0 = r4.zzg
            if (r0 == 0) goto L_0x0174
            if (r1 == 0) goto L_0x0174
            int r7 = r7.zzj
            if (r7 == r10) goto L_0x0174
            boolean r7 = r8.zzC
            boolean r7 = r8.zzB
            r5 = r5 & r9
            if (r5 == 0) goto L_0x0174
            r6 = r11
            goto L_0x0175
        L_0x0174:
        L_0x0175:
            r4.zzo = r6
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzzd.<init>(int, com.google.android.gms.internal.ads.zzde, int, com.google.android.gms.internal.ads.zzys, int, int, boolean):void");
    }

    public static /* synthetic */ int zza(zzzd zzzd, zzzd zzzd2) {
        zzgcn zzgcn;
        if (!zzzd.zze || !zzzd.zzh) {
            zzgcn = zzze.zzb.zza();
        } else {
            zzgcn = zzze.zzb;
        }
        zzgar zzk2 = zzgar.zzk();
        boolean z = zzzd.zzf.zzB;
        return zzk2.zzd(Integer.valueOf(zzzd.zzk), Integer.valueOf(zzzd2.zzk), zzgcn).zzd(Integer.valueOf(zzzd.zzj), Integer.valueOf(zzzd2.zzj), zzgcn).zza();
    }

    public static /* synthetic */ int zzd(zzzd zzzd, zzzd zzzd2) {
        zzgar zzd = zzgar.zzk().zze(zzzd.zzh, zzzd2.zzh).zzb(zzzd.zzm, zzzd2.zzm).zze(zzzd.zzn, zzzd2.zzn).zze(zzzd.zzi, zzzd2.zzi).zze(zzzd.zze, zzzd2.zze).zze(zzzd.zzg, zzzd2.zzg).zzd(Integer.valueOf(zzzd.zzl), Integer.valueOf(zzzd2.zzl), zzgcn.zzc().zza());
        boolean z = zzzd.zzp;
        zzgar zze2 = zzd.zze(z, zzzd2.zzp);
        boolean z2 = zzzd.zzq;
        zzgar zze3 = zze2.zze(z2, zzzd2.zzq);
        if (z && z2) {
            zze3 = zze3.zzb(zzzd.zzr, zzzd2.zzr);
        }
        return zze3.zza();
    }

    public final int zzb() {
        return this.zzo;
    }

    public final /* bridge */ /* synthetic */ boolean zzc(zzza zzza) {
        zzzd zzzd = (zzzd) zzza;
        if (!zzgd.zzG(this.zzd.zzn, zzzd.zzd.zzn)) {
            return false;
        }
        boolean z = this.zzf.zzL;
        return this.zzp == zzzd.zzp && this.zzq == zzzd.zzq;
    }
}
