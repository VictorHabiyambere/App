package com.google.android.gms.internal.ads;

import java.security.MessageDigest;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzbbx extends zzbbo {
    private MessageDigest zzb;
    private final int zzc;
    private final int zzd;

    public zzbbx(int i) {
        int i2 = i >> 3;
        this.zzc = (i & 7) > 0 ? i2 + 1 : i2;
        this.zzd = i;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0069, code lost:
        return r3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final byte[] zzb(java.lang.String r9) {
        /*
            r8 = this;
            java.lang.Object r0 = r8.zza
            monitor-enter(r0)
            java.security.MessageDigest r1 = r8.zza()     // Catch:{ all -> 0x006a }
            r8.zzb = r1     // Catch:{ all -> 0x006a }
            java.security.MessageDigest r1 = r8.zzb     // Catch:{ all -> 0x006a }
            r2 = 0
            if (r1 != 0) goto L_0x0012
            byte[] r9 = new byte[r2]     // Catch:{ all -> 0x006a }
            monitor-exit(r0)     // Catch:{ all -> 0x006a }
            return r9
        L_0x0012:
            r1.reset()     // Catch:{ all -> 0x006a }
            java.security.MessageDigest r1 = r8.zzb     // Catch:{ all -> 0x006a }
            java.lang.String r3 = "UTF-8"
            java.nio.charset.Charset r3 = java.nio.charset.Charset.forName(r3)     // Catch:{ all -> 0x006a }
            byte[] r9 = r9.getBytes(r3)     // Catch:{ all -> 0x006a }
            r1.update(r9)     // Catch:{ all -> 0x006a }
            java.security.MessageDigest r9 = r8.zzb     // Catch:{ all -> 0x006a }
            byte[] r9 = r9.digest()     // Catch:{ all -> 0x006a }
            int r1 = r9.length     // Catch:{ all -> 0x006a }
            int r3 = r8.zzc     // Catch:{ all -> 0x006a }
            if (r1 <= r3) goto L_0x0030
            r1 = r3
        L_0x0030:
            byte[] r3 = new byte[r1]     // Catch:{ all -> 0x006a }
            java.lang.System.arraycopy(r9, r2, r3, r2, r1)     // Catch:{ all -> 0x006a }
            int r9 = r8.zzd     // Catch:{ all -> 0x006a }
            r9 = r9 & 7
            if (r9 <= 0) goto L_0x0068
            r4 = 0
        L_0x003d:
            r9 = 8
            if (r2 >= r1) goto L_0x004f
            if (r2 <= 0) goto L_0x0045
            long r4 = r4 << r9
            goto L_0x0046
        L_0x0045:
        L_0x0046:
            byte r9 = r3[r2]     // Catch:{ all -> 0x006a }
            r9 = r9 & 255(0xff, float:3.57E-43)
            long r6 = (long) r9     // Catch:{ all -> 0x006a }
            long r4 = r4 + r6
            int r2 = r2 + 1
            goto L_0x003d
        L_0x004f:
            int r1 = r8.zzd     // Catch:{ all -> 0x006a }
            r1 = r1 & 7
            int r1 = 8 - r1
            long r1 = r4 >>> r1
            int r4 = r8.zzc     // Catch:{ all -> 0x006a }
            int r4 = r4 + -1
        L_0x005b:
            if (r4 < 0) goto L_0x0068
            r5 = 255(0xff, double:1.26E-321)
            long r5 = r5 & r1
            int r5 = (int) r5     // Catch:{ all -> 0x006a }
            byte r5 = (byte) r5     // Catch:{ all -> 0x006a }
            r3[r4] = r5     // Catch:{ all -> 0x006a }
            long r1 = r1 >>> r9
            int r4 = r4 + -1
            goto L_0x005b
        L_0x0068:
            monitor-exit(r0)     // Catch:{ all -> 0x006a }
            return r3
        L_0x006a:
            r9 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x006a }
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbbx.zzb(java.lang.String):byte[]");
    }
}
