package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzacq {
    public static final /* synthetic */ int zza = 0;
    private static final int[] zzb = {96000, 88200, 64000, 48000, 44100, 32000, 24000, 22050, 16000, 12000, 11025, 8000, 7350};
    private static final int[] zzc = {0, 1, 2, 3, 4, 5, 6, 8, -1, -1, -1, 7, 8, -1, 8, -1};

    public static zzacp zza(byte[] bArr) throws zzch {
        return zzb(new zzft(bArr, bArr.length), false);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00ab, code lost:
        if (r8 != 3) goto L_0x00cb;
     */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0080  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00a3  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.android.gms.internal.ads.zzacp zzb(com.google.android.gms.internal.ads.zzft r8, boolean r9) throws com.google.android.gms.internal.ads.zzch {
        /*
            int r0 = zzc(r8)
            int r1 = zzd(r8)
            r2 = 4
            int r3 = r8.zzd(r2)
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "mp4a.40."
            r4.append(r5)
            r4.append(r0)
            java.lang.String r4 = r4.toString()
            r5 = 5
            r6 = 22
            if (r0 == r5) goto L_0x0027
            r5 = 29
            if (r0 != r5) goto L_0x0035
        L_0x0027:
            int r1 = zzd(r8)
            int r0 = zzc(r8)
            if (r0 != r6) goto L_0x0035
            int r3 = r8.zzd(r2)
        L_0x0035:
            if (r9 == 0) goto L_0x00cb
            switch(r0) {
                case 1: goto L_0x0050;
                case 2: goto L_0x0050;
                case 3: goto L_0x0050;
                case 4: goto L_0x0050;
                case 5: goto L_0x003a;
                case 6: goto L_0x0050;
                case 7: goto L_0x0050;
                case 8: goto L_0x003a;
                case 9: goto L_0x003a;
                case 10: goto L_0x003a;
                case 11: goto L_0x003a;
                case 12: goto L_0x003a;
                case 13: goto L_0x003a;
                case 14: goto L_0x003a;
                case 15: goto L_0x003a;
                case 16: goto L_0x003a;
                case 17: goto L_0x0050;
                case 18: goto L_0x003a;
                case 19: goto L_0x0050;
                case 20: goto L_0x0050;
                case 21: goto L_0x0050;
                case 22: goto L_0x0050;
                case 23: goto L_0x0050;
                default: goto L_0x003a;
            }
        L_0x003a:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r9 = "Unsupported audio object type: "
            r8.append(r9)
            r8.append(r0)
            java.lang.String r8 = r8.toString()
            com.google.android.gms.internal.ads.zzch r8 = com.google.android.gms.internal.ads.zzch.zzc(r8)
            throw r8
        L_0x0050:
            boolean r9 = r8.zzo()
            if (r9 == 0) goto L_0x005d
            java.lang.String r9 = "AacUtil"
            java.lang.String r2 = "Unexpected frameLengthFlag = 1"
            com.google.android.gms.internal.ads.zzfk.zzf(r9, r2)
        L_0x005d:
            boolean r9 = r8.zzo()
            if (r9 == 0) goto L_0x0068
            r9 = 14
            r8.zzm(r9)
        L_0x0068:
            boolean r9 = r8.zzo()
            if (r3 == 0) goto L_0x00c5
            r2 = 6
            r5 = 20
            r7 = 3
            if (r0 == r2) goto L_0x0079
            if (r0 != r5) goto L_0x0078
            r0 = r5
            goto L_0x007a
        L_0x0078:
            goto L_0x007e
        L_0x0079:
        L_0x007a:
            r8.zzm(r7)
        L_0x007e:
            if (r9 == 0) goto L_0x009f
            if (r0 != r6) goto L_0x0088
            r9 = 16
            r8.zzm(r9)
            goto L_0x0089
        L_0x0088:
            r6 = r0
        L_0x0089:
            r9 = 17
            if (r6 == r9) goto L_0x0097
            r9 = 19
            if (r6 == r9) goto L_0x0097
            if (r6 == r5) goto L_0x0097
            r9 = 23
            if (r6 != r9) goto L_0x009a
        L_0x0097:
            r8.zzm(r7)
        L_0x009a:
            r9 = 1
            r8.zzm(r9)
        L_0x009f:
            switch(r0) {
                case 17: goto L_0x00a3;
                case 18: goto L_0x00a2;
                case 19: goto L_0x00a3;
                case 20: goto L_0x00a3;
                case 21: goto L_0x00a3;
                case 22: goto L_0x00a3;
                case 23: goto L_0x00a3;
                default: goto L_0x00a2;
            }
        L_0x00a2:
            goto L_0x00cb
        L_0x00a3:
            r9 = 2
            int r8 = r8.zzd(r9)
            if (r8 == r9) goto L_0x00ae
            if (r8 == r7) goto L_0x00af
            goto L_0x00cb
        L_0x00ae:
            r7 = r8
        L_0x00af:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r9 = "Unsupported epConfig: "
            r8.append(r9)
            r8.append(r7)
            java.lang.String r8 = r8.toString()
            com.google.android.gms.internal.ads.zzch r8 = com.google.android.gms.internal.ads.zzch.zzc(r8)
            throw r8
        L_0x00c5:
            java.lang.UnsupportedOperationException r8 = new java.lang.UnsupportedOperationException
            r8.<init>()
            throw r8
        L_0x00cb:
            int[] r8 = zzc
            r8 = r8[r3]
            r9 = -1
            r0 = 0
            if (r8 == r9) goto L_0x00d9
            com.google.android.gms.internal.ads.zzacp r9 = new com.google.android.gms.internal.ads.zzacp
            r9.<init>(r1, r8, r4, r0)
            return r9
        L_0x00d9:
            com.google.android.gms.internal.ads.zzch r8 = com.google.android.gms.internal.ads.zzch.zza(r0, r0)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzacq.zzb(com.google.android.gms.internal.ads.zzft, boolean):com.google.android.gms.internal.ads.zzacp");
    }

    private static int zzc(zzft zzft) {
        int zzd = zzft.zzd(5);
        return zzd == 31 ? zzft.zzd(6) + 32 : zzd;
    }

    private static int zzd(zzft zzft) throws zzch {
        int zzd = zzft.zzd(4);
        if (zzd == 15) {
            if (zzft.zza() >= 24) {
                return zzft.zzd(24);
            }
            throw zzch.zza("AAC header insufficient data", (Throwable) null);
        } else if (zzd < 13) {
            return zzb[zzd];
        } else {
            throw zzch.zza("AAC header wrong Sampling Frequency Index", (Throwable) null);
        }
    }
}
