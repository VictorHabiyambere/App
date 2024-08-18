package com.google.android.gms.internal.ads;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.BlockingQueue;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
final class zzarr implements zzard {
    private final Map zza = new HashMap();
    private final zzaqq zzb;
    private final BlockingQueue zzc;
    private final zzaqv zzd;

    zzarr(zzaqq zzaqq, BlockingQueue blockingQueue, zzaqv zzaqv) {
        this.zzd = zzaqv;
        this.zzb = zzaqq;
        this.zzc = blockingQueue;
    }

    public final synchronized void zza(zzare zzare) {
        Map map = this.zza;
        String zzj = zzare.zzj();
        List list = (List) map.remove(zzj);
        if (list != null && !list.isEmpty()) {
            if (zzarq.zzb) {
                zzarq.zzd("%d waiting requests for cacheKey=%s; resend to network", Integer.valueOf(list.size()), zzj);
            }
            zzare zzare2 = (zzare) list.remove(0);
            this.zza.put(zzj, list);
            zzare2.zzu(this);
            try {
                this.zzc.put(zzare2);
            } catch (InterruptedException e) {
                zzarq.zzb("Couldn't add request to queue. %s", e.toString());
                Thread.currentThread().interrupt();
                this.zzb.zzb();
            }
        }
    }

    public final void zzb(zzare zzare, zzark zzark) {
        List<zzare> list;
        zzaqn zzaqn = zzark.zzb;
        if (zzaqn == null || zzaqn.zza(System.currentTimeMillis())) {
            zza(zzare);
            return;
        }
        String zzj = zzare.zzj();
        synchronized (this) {
            list = (List) this.zza.remove(zzj);
        }
        if (list != null) {
            if (zzarq.zzb) {
                zzarq.zzd("Releasing %d waiting requests for cacheKey=%s.", Integer.valueOf(list.size()), zzj);
            }
            for (zzare zzb2 : list) {
                this.zzd.zzb(zzb2, zzark, (Runnable) null);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0037, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0050, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized boolean zzc(com.google.android.gms.internal.ads.zzare r4) {
        /*
            r3 = this;
            monitor-enter(r3)
            java.util.Map r0 = r3.zza     // Catch:{ all -> 0x0052 }
            java.lang.String r1 = r4.zzj()     // Catch:{ all -> 0x0052 }
            boolean r0 = r0.containsKey(r1)     // Catch:{ all -> 0x0052 }
            if (r0 == 0) goto L_0x0039
            java.util.Map r0 = r3.zza     // Catch:{ all -> 0x0052 }
            java.lang.Object r0 = r0.get(r1)     // Catch:{ all -> 0x0052 }
            java.util.List r0 = (java.util.List) r0     // Catch:{ all -> 0x0052 }
            if (r0 != 0) goto L_0x001c
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch:{ all -> 0x0052 }
            r0.<init>()     // Catch:{ all -> 0x0052 }
        L_0x001c:
            java.lang.String r2 = "waiting-for-response"
            r4.zzm(r2)     // Catch:{ all -> 0x0052 }
            r0.add(r4)     // Catch:{ all -> 0x0052 }
            java.util.Map r4 = r3.zza     // Catch:{ all -> 0x0052 }
            r4.put(r1, r0)     // Catch:{ all -> 0x0052 }
            boolean r4 = com.google.android.gms.internal.ads.zzarq.zzb     // Catch:{ all -> 0x0052 }
            if (r4 == 0) goto L_0x0036
            java.lang.Object[] r4 = new java.lang.Object[]{r1}     // Catch:{ all -> 0x0052 }
            java.lang.String r0 = "Request for cacheKey=%s is in flight, putting on hold."
            com.google.android.gms.internal.ads.zzarq.zza(r0, r4)     // Catch:{ all -> 0x0052 }
        L_0x0036:
            monitor-exit(r3)
            r4 = 1
            return r4
        L_0x0039:
            java.util.Map r0 = r3.zza     // Catch:{ all -> 0x0052 }
            r2 = 0
            r0.put(r1, r2)     // Catch:{ all -> 0x0052 }
            r4.zzu(r3)     // Catch:{ all -> 0x0052 }
            boolean r4 = com.google.android.gms.internal.ads.zzarq.zzb     // Catch:{ all -> 0x0052 }
            if (r4 == 0) goto L_0x004f
            java.lang.Object[] r4 = new java.lang.Object[]{r1}     // Catch:{ all -> 0x0052 }
            java.lang.String r0 = "new request, sending to network %s"
            com.google.android.gms.internal.ads.zzarq.zza(r0, r4)     // Catch:{ all -> 0x0052 }
        L_0x004f:
            monitor-exit(r3)
            r4 = 0
            return r4
        L_0x0052:
            r4 = move-exception
            monitor-exit(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzarr.zzc(com.google.android.gms.internal.ads.zzare):boolean");
    }
}
