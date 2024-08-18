package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
final class zzank {
    public long zza = 0;
    public long zzb = 0;
    public CharSequence zzc;
    public int zzd = 2;
    public float zze = -3.4028235E38f;
    public int zzf = 1;
    public int zzg = 0;
    public float zzh = -3.4028235E38f;
    public int zzi = Integer.MIN_VALUE;
    public float zzj = 1.0f;
    public int zzk = Integer.MIN_VALUE;

    /* JADX WARNING: Code restructure failed: missing block: B:29:0x006d, code lost:
        if (r8 == 0) goto L_0x006f;
     */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0085  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x008f  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0099  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00ab  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.ads.zzeg zza() {
        /*
            r10 = this;
            float r0 = r10.zzh
            r1 = -8388609(0xffffffffff7fffff, float:-3.4028235E38)
            int r2 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            r3 = 1056964608(0x3f000000, float:0.5)
            r4 = 0
            r5 = 1065353216(0x3f800000, float:1.0)
            if (r2 == 0) goto L_0x000f
            goto L_0x0019
        L_0x000f:
            int r0 = r10.zzd
            switch(r0) {
                case 4: goto L_0x0018;
                case 5: goto L_0x0016;
                default: goto L_0x0014;
            }
        L_0x0014:
            r0 = r3
            goto L_0x0019
        L_0x0016:
            r0 = r5
            goto L_0x0019
        L_0x0018:
            r0 = r4
        L_0x0019:
            int r2 = r10.zzi
            r6 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r2 == r6) goto L_0x0020
            goto L_0x002a
        L_0x0020:
            int r2 = r10.zzd
            switch(r2) {
                case 1: goto L_0x0029;
                case 2: goto L_0x0025;
                case 3: goto L_0x0027;
                case 4: goto L_0x0029;
                case 5: goto L_0x0027;
                default: goto L_0x0025;
            }
        L_0x0025:
            r2 = 1
            goto L_0x002a
        L_0x0027:
            r2 = 2
            goto L_0x002a
        L_0x0029:
            r2 = 0
        L_0x002a:
            com.google.android.gms.internal.ads.zzeg r6 = new com.google.android.gms.internal.ads.zzeg
            r6.<init>()
            int r7 = r10.zzd
            switch(r7) {
                case 1: goto L_0x0052;
                case 2: goto L_0x004f;
                case 3: goto L_0x004c;
                case 4: goto L_0x0052;
                case 5: goto L_0x004c;
                default: goto L_0x0034;
            }
        L_0x0034:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r9 = "Unknown textAlignment: "
            r8.append(r9)
            r8.append(r7)
            java.lang.String r7 = r8.toString()
            java.lang.String r8 = "WebvttCueParser"
            com.google.android.gms.internal.ads.zzfk.zzf(r8, r7)
            r7 = 0
            goto L_0x0054
        L_0x004c:
            android.text.Layout$Alignment r7 = android.text.Layout.Alignment.ALIGN_OPPOSITE
            goto L_0x0054
        L_0x004f:
            android.text.Layout$Alignment r7 = android.text.Layout.Alignment.ALIGN_CENTER
            goto L_0x0054
        L_0x0052:
            android.text.Layout$Alignment r7 = android.text.Layout.Alignment.ALIGN_NORMAL
        L_0x0054:
            r6.zzm(r7)
            float r7 = r10.zze
            int r8 = r10.zzf
            int r9 = (r7 > r1 ? 1 : (r7 == r1 ? 0 : -1))
            if (r9 == 0) goto L_0x006b
            if (r8 != 0) goto L_0x006b
            int r4 = (r7 > r4 ? 1 : (r7 == r4 ? 0 : -1))
            if (r4 < 0) goto L_0x006f
            int r4 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
            if (r4 <= 0) goto L_0x006b
            r1 = r5
            goto L_0x0072
        L_0x006b:
            if (r9 != 0) goto L_0x0071
            if (r8 != 0) goto L_0x0072
        L_0x006f:
            r1 = r5
            goto L_0x0072
        L_0x0071:
            r1 = r7
        L_0x0072:
            r6.zze(r1, r8)
            int r1 = r10.zzg
            r6.zzf(r1)
            r6.zzh(r0)
            r6.zzi(r2)
            float r1 = r10.zzj
            switch(r2) {
                case 0: goto L_0x0099;
                case 1: goto L_0x008f;
                case 2: goto L_0x009b;
                default: goto L_0x0085;
            }
        L_0x0085:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = java.lang.String.valueOf(r2)
            r0.<init>(r1)
            throw r0
        L_0x008f:
            int r2 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r2 > 0) goto L_0x0095
            float r0 = r0 + r0
            goto L_0x009b
        L_0x0095:
            float r5 = r5 - r0
            float r0 = r5 + r5
            goto L_0x009b
        L_0x0099:
            float r0 = r5 - r0
        L_0x009b:
            float r0 = java.lang.Math.min(r1, r0)
            r6.zzk(r0)
            int r0 = r10.zzk
            r6.zzo(r0)
            java.lang.CharSequence r0 = r10.zzc
            if (r0 == 0) goto L_0x00ae
            r6.zzl(r0)
        L_0x00ae:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzank.zza():com.google.android.gms.internal.ads.zzeg");
    }
}
