package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzakq {
    public final boolean zza;
    public final String zzb;
    public final zzaez zzc;
    public final int zzd;
    public final byte[] zze;

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0039, code lost:
        if (r6.equals("cenc") != false) goto L_0x0051;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public zzakq(boolean r5, java.lang.String r6, int r7, byte[] r8, int r9, int r10, byte[] r11) {
        /*
            r4 = this;
            r4.<init>()
            r0 = 0
            r1 = 1
            if (r7 != 0) goto L_0x0009
            r2 = r1
            goto L_0x000a
        L_0x0009:
            r2 = r0
        L_0x000a:
            if (r11 != 0) goto L_0x000e
            r3 = r1
            goto L_0x000f
        L_0x000e:
            r3 = r0
        L_0x000f:
            r2 = r2 ^ r3
            com.google.android.gms.internal.ads.zzeq.zzd(r2)
            r4.zza = r5
            r4.zzb = r6
            r4.zzd = r7
            r4.zze = r11
            com.google.android.gms.internal.ads.zzaez r5 = new com.google.android.gms.internal.ads.zzaez
            if (r6 != 0) goto L_0x0020
            goto L_0x0073
        L_0x0020:
            int r7 = r6.hashCode()
            r11 = 2
            switch(r7) {
                case 3046605: goto L_0x0046;
                case 3046671: goto L_0x003c;
                case 3049879: goto L_0x0033;
                case 3049895: goto L_0x0029;
                default: goto L_0x0028;
            }
        L_0x0028:
            goto L_0x0050
        L_0x0029:
            java.lang.String r7 = "cens"
            boolean r7 = r6.equals(r7)
            if (r7 == 0) goto L_0x0050
            r0 = r1
            goto L_0x0051
        L_0x0033:
            java.lang.String r7 = "cenc"
            boolean r7 = r6.equals(r7)
            if (r7 == 0) goto L_0x0050
            goto L_0x0051
        L_0x003c:
            java.lang.String r7 = "cbcs"
            boolean r7 = r6.equals(r7)
            if (r7 == 0) goto L_0x0050
            r0 = 3
            goto L_0x0051
        L_0x0046:
            java.lang.String r7 = "cbc1"
            boolean r7 = r6.equals(r7)
            if (r7 == 0) goto L_0x0050
            r0 = r11
            goto L_0x0051
        L_0x0050:
            r0 = -1
        L_0x0051:
            switch(r0) {
                case 0: goto L_0x0072;
                case 1: goto L_0x0072;
                case 2: goto L_0x0070;
                case 3: goto L_0x0070;
                default: goto L_0x0054;
            }
        L_0x0054:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r11 = "Unsupported protection scheme type '"
            r7.append(r11)
            r7.append(r6)
            java.lang.String r6 = "'. Assuming AES-CTR crypto mode."
            r7.append(r6)
            java.lang.String r6 = r7.toString()
            java.lang.String r7 = "TrackEncryptionBox"
            com.google.android.gms.internal.ads.zzfk.zzf(r7, r6)
            goto L_0x0073
        L_0x0070:
            r1 = r11
            goto L_0x0073
        L_0x0072:
        L_0x0073:
            r5.<init>(r1, r8, r9, r10)
            r4.zzc = r5
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzakq.<init>(boolean, java.lang.String, int, byte[], int, int, byte[]):void");
    }
}
