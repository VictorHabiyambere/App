package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzctr implements zzban {
    private final zzchd zza;
    private final Executor zzb;
    private final AtomicReference zzc = new AtomicReference();

    zzctr(zzchd zzchd, Executor executor) {
        this.zza = zzchd;
        this.zzb = executor;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x006a, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void zzdp(com.google.android.gms.internal.ads.zzbam r4) {
        /*
            r3 = this;
            monitor-enter(r3)
            com.google.android.gms.internal.ads.zzchd r0 = r3.zza     // Catch:{ all -> 0x006b }
            if (r0 == 0) goto L_0x0069
            com.google.android.gms.internal.ads.zzbeg r0 = com.google.android.gms.internal.ads.zzbep.zzmA     // Catch:{ all -> 0x006b }
            com.google.android.gms.internal.ads.zzben r1 = com.google.android.gms.ads.internal.client.zzba.zzc()     // Catch:{ all -> 0x006b }
            java.lang.Object r0 = r1.zza(r0)     // Catch:{ all -> 0x006b }
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch:{ all -> 0x006b }
            boolean r0 = r0.booleanValue()     // Catch:{ all -> 0x006b }
            if (r0 != 0) goto L_0x0018
            goto L_0x0069
        L_0x0018:
            boolean r0 = r4.zzj     // Catch:{ all -> 0x006b }
            if (r0 == 0) goto L_0x0041
            java.util.concurrent.atomic.AtomicReference r0 = r3.zzc     // Catch:{ all -> 0x006b }
            java.lang.Boolean r1 = java.lang.Boolean.TRUE     // Catch:{ all -> 0x006b }
            r2 = 1
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)     // Catch:{ all -> 0x006b }
            java.lang.Object r0 = r0.getAndSet(r2)     // Catch:{ all -> 0x006b }
            boolean r0 = r1.equals(r0)     // Catch:{ all -> 0x006b }
            if (r0 == 0) goto L_0x0030
            goto L_0x0041
        L_0x0030:
            java.util.concurrent.Executor r4 = r3.zzb     // Catch:{ all -> 0x006b }
            com.google.android.gms.internal.ads.zzchd r0 = r3.zza     // Catch:{ all -> 0x006b }
            java.util.Objects.requireNonNull(r0)     // Catch:{ all -> 0x006b }
            com.google.android.gms.internal.ads.zzctp r1 = new com.google.android.gms.internal.ads.zzctp     // Catch:{ all -> 0x006b }
            r1.<init>(r0)     // Catch:{ all -> 0x006b }
            r4.execute(r1)     // Catch:{ all -> 0x006b }
            monitor-exit(r3)
            return
        L_0x0041:
            boolean r4 = r4.zzj     // Catch:{ all -> 0x006b }
            if (r4 != 0) goto L_0x0069
            java.util.concurrent.atomic.AtomicReference r4 = r3.zzc     // Catch:{ all -> 0x006b }
            java.lang.Boolean r0 = java.lang.Boolean.FALSE     // Catch:{ all -> 0x006b }
            r1 = 0
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r1)     // Catch:{ all -> 0x006b }
            java.lang.Object r4 = r4.getAndSet(r1)     // Catch:{ all -> 0x006b }
            boolean r4 = r0.equals(r4)     // Catch:{ all -> 0x006b }
            if (r4 != 0) goto L_0x0069
            java.util.concurrent.Executor r4 = r3.zzb     // Catch:{ all -> 0x006b }
            com.google.android.gms.internal.ads.zzchd r0 = r3.zza     // Catch:{ all -> 0x006b }
            java.util.Objects.requireNonNull(r0)     // Catch:{ all -> 0x006b }
            com.google.android.gms.internal.ads.zzctq r1 = new com.google.android.gms.internal.ads.zzctq     // Catch:{ all -> 0x006b }
            r1.<init>(r0)     // Catch:{ all -> 0x006b }
            r4.execute(r1)     // Catch:{ all -> 0x006b }
            monitor-exit(r3)
            return
        L_0x0069:
            monitor-exit(r3)
            return
        L_0x006b:
            r4 = move-exception
            monitor-exit(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzctr.zzdp(com.google.android.gms.internal.ads.zzbam):void");
    }
}
