package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
final class zzamm {
    public final int zza;
    public final int zzb;
    public final int zzc;
    public final int zzd;
    public final int zze;
    public final int zzf;
    public final int zzg;
    public final int zzh;
    public final int zzi;
    public final int zzj;
    public final int zzk;

    private zzamm(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11) {
        this.zza = i;
        this.zzb = i2;
        this.zzc = i3;
        this.zzd = i4;
        this.zze = i5;
        this.zzf = i6;
        this.zzg = i7;
        this.zzh = i8;
        this.zzi = i9;
        this.zzj = i10;
        this.zzk = i11;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.android.gms.internal.ads.zzamm zza(java.lang.String r17) {
        /*
            r0 = 7
            r1 = r17
            java.lang.String r1 = r1.substring(r0)
            java.lang.String r2 = ","
            java.lang.String[] r1 = android.text.TextUtils.split(r1, r2)
            r2 = 0
            r3 = -1
            r4 = r2
            r6 = r3
            r7 = r6
            r8 = r7
            r9 = r8
            r10 = r9
            r11 = r10
            r12 = r11
            r13 = r12
            r14 = r13
            r15 = r14
        L_0x001a:
            int r5 = r1.length
            if (r4 >= r5) goto L_0x00b3
            r5 = r1[r4]
            java.lang.String r5 = r5.trim()
            java.lang.String r5 = com.google.android.gms.internal.ads.zzfxm.zza(r5)
            int r16 = r5.hashCode()
            switch(r16) {
                case -1178781136: goto L_0x008c;
                case -1026963764: goto L_0x0082;
                case -192095652: goto L_0x0077;
                case -70925746: goto L_0x006d;
                case 3029637: goto L_0x0063;
                case 3373707: goto L_0x0059;
                case 366554320: goto L_0x004f;
                case 767321349: goto L_0x0044;
                case 1767875043: goto L_0x003a;
                case 1988365454: goto L_0x0030;
                default: goto L_0x002e;
            }
        L_0x002e:
            goto L_0x0096
        L_0x0030:
            java.lang.String r0 = "outlinecolour"
            boolean r0 = r5.equals(r0)
            if (r0 == 0) goto L_0x002e
            r0 = 3
            goto L_0x0097
        L_0x003a:
            java.lang.String r0 = "alignment"
            boolean r0 = r5.equals(r0)
            if (r0 == 0) goto L_0x002e
            r0 = 1
            goto L_0x0097
        L_0x0044:
            java.lang.String r0 = "borderstyle"
            boolean r0 = r5.equals(r0)
            if (r0 == 0) goto L_0x002e
            r0 = 9
            goto L_0x0097
        L_0x004f:
            java.lang.String r0 = "fontsize"
            boolean r0 = r5.equals(r0)
            if (r0 == 0) goto L_0x002e
            r0 = 4
            goto L_0x0097
        L_0x0059:
            java.lang.String r0 = "name"
            boolean r0 = r5.equals(r0)
            if (r0 == 0) goto L_0x002e
            r0 = r2
            goto L_0x0097
        L_0x0063:
            java.lang.String r0 = "bold"
            boolean r0 = r5.equals(r0)
            if (r0 == 0) goto L_0x002e
            r0 = 5
            goto L_0x0097
        L_0x006d:
            java.lang.String r0 = "primarycolour"
            boolean r0 = r5.equals(r0)
            if (r0 == 0) goto L_0x002e
            r0 = 2
            goto L_0x0097
        L_0x0077:
            java.lang.String r0 = "strikeout"
            boolean r0 = r5.equals(r0)
            if (r0 == 0) goto L_0x002e
            r0 = 8
            goto L_0x0097
        L_0x0082:
            java.lang.String r0 = "underline"
            boolean r0 = r5.equals(r0)
            if (r0 == 0) goto L_0x002e
            r0 = 7
            goto L_0x0097
        L_0x008c:
            java.lang.String r0 = "italic"
            boolean r0 = r5.equals(r0)
            if (r0 == 0) goto L_0x002e
            r0 = 6
            goto L_0x0097
        L_0x0096:
            r0 = r3
        L_0x0097:
            switch(r0) {
                case 0: goto L_0x00ad;
                case 1: goto L_0x00ab;
                case 2: goto L_0x00a9;
                case 3: goto L_0x00a7;
                case 4: goto L_0x00a5;
                case 5: goto L_0x00a3;
                case 6: goto L_0x00a1;
                case 7: goto L_0x009f;
                case 8: goto L_0x009d;
                case 9: goto L_0x009b;
                default: goto L_0x009a;
            }
        L_0x009a:
            goto L_0x00ae
        L_0x009b:
            r15 = r4
            goto L_0x00ae
        L_0x009d:
            r14 = r4
            goto L_0x00ae
        L_0x009f:
            r13 = r4
            goto L_0x00ae
        L_0x00a1:
            r12 = r4
            goto L_0x00ae
        L_0x00a3:
            r11 = r4
            goto L_0x00ae
        L_0x00a5:
            r10 = r4
            goto L_0x00ae
        L_0x00a7:
            r9 = r4
            goto L_0x00ae
        L_0x00a9:
            r8 = r4
            goto L_0x00ae
        L_0x00ab:
            r7 = r4
            goto L_0x00ae
        L_0x00ad:
            r6 = r4
        L_0x00ae:
            int r4 = r4 + 1
            r0 = 7
            goto L_0x001a
        L_0x00b3:
            if (r6 == r3) goto L_0x00bf
            com.google.android.gms.internal.ads.zzamm r0 = new com.google.android.gms.internal.ads.zzamm
            r1 = r5
            r5 = r0
            r16 = r1
            r5.<init>(r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16)
            return r0
        L_0x00bf:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzamm.zza(java.lang.String):com.google.android.gms.internal.ads.zzamm");
    }
}
