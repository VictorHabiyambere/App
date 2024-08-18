package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
final class zzcbx {
    private final Object zza = new Object();
    private volatile long zzb = 0;
    private volatile int zzc = 1;

    private zzcbx() {
    }

    /* synthetic */ zzcbx(zzcbw zzcbw) {
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0046, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza() {
        /*
            r9 = this;
            com.google.android.gms.common.util.Clock r0 = com.google.android.gms.ads.internal.zzu.zzB()
            long r0 = r0.currentTimeMillis()
            java.lang.Object r2 = r9.zza
            monitor-enter(r2)
            int r3 = r9.zzc     // Catch:{ all -> 0x004a }
            r4 = 3
            if (r3 != r4) goto L_0x002a
            long r5 = r9.zzb     // Catch:{ all -> 0x004a }
            com.google.android.gms.internal.ads.zzbeg r3 = com.google.android.gms.internal.ads.zzbep.zzgg     // Catch:{ all -> 0x004a }
            com.google.android.gms.internal.ads.zzben r7 = com.google.android.gms.ads.internal.client.zzba.zzc()     // Catch:{ all -> 0x004a }
            java.lang.Object r3 = r7.zza(r3)     // Catch:{ all -> 0x004a }
            java.lang.Long r3 = (java.lang.Long) r3     // Catch:{ all -> 0x004a }
            long r7 = r3.longValue()     // Catch:{ all -> 0x004a }
            long r5 = r5 + r7
            int r0 = (r5 > r0 ? 1 : (r5 == r0 ? 0 : -1))
            if (r0 > 0) goto L_0x002a
            r0 = 1
            r9.zzc = r0     // Catch:{ all -> 0x004a }
        L_0x002a:
            monitor-exit(r2)     // Catch:{ all -> 0x004a }
            com.google.android.gms.common.util.Clock r0 = com.google.android.gms.ads.internal.zzu.zzB()
            long r0 = r0.currentTimeMillis()
            java.lang.Object r3 = r9.zza
            monitor-enter(r3)
            int r2 = r9.zzc     // Catch:{ all -> 0x0047 }
            r5 = 2
            if (r2 == r5) goto L_0x003d
            monitor-exit(r3)     // Catch:{ all -> 0x0047 }
            return
        L_0x003d:
            r9.zzc = r4     // Catch:{ all -> 0x0047 }
            int r2 = r9.zzc     // Catch:{ all -> 0x0047 }
            if (r2 != r4) goto L_0x0045
            r9.zzb = r0     // Catch:{ all -> 0x0047 }
        L_0x0045:
            monitor-exit(r3)     // Catch:{ all -> 0x0047 }
            return
        L_0x0047:
            r0 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x0047 }
            throw r0
        L_0x004a:
            r0 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x004a }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcbx.zza():void");
    }
}
