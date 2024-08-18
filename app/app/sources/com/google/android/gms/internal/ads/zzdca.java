package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;
import java.util.Collections;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzdca extends zzdez {
    private final ScheduledExecutorService zzb;
    private final Clock zzc;
    private long zzd = -1;
    private long zze = -1;
    private boolean zzf = false;
    private ScheduledFuture zzg;

    public zzdca(ScheduledExecutorService scheduledExecutorService, Clock clock) {
        super(Collections.emptySet());
        this.zzb = scheduledExecutorService;
        this.zzc = clock;
    }

    private final synchronized void zze(long j) {
        ScheduledFuture scheduledFuture = this.zzg;
        if (scheduledFuture != null && !scheduledFuture.isDone()) {
            this.zzg.cancel(true);
        }
        this.zzd = this.zzc.elapsedRealtime() + j;
        this.zzg = this.zzb.schedule(new zzdbz(this, (zzdby) null), j, TimeUnit.MILLISECONDS);
    }

    public final synchronized void zza() {
        this.zzf = false;
        zze(0);
    }

    public final synchronized void zzb() {
        if (!this.zzf) {
            ScheduledFuture scheduledFuture = this.zzg;
            if (scheduledFuture == null || scheduledFuture.isCancelled()) {
                this.zze = -1;
            } else {
                this.zzg.cancel(true);
                this.zze = this.zzd - this.zzc.elapsedRealtime();
            }
            this.zzf = true;
        }
    }

    public final synchronized void zzc() {
        if (this.zzf) {
            if (this.zze > 0 && this.zzg.isCancelled()) {
                zze(this.zze);
            }
            this.zzf = false;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0020, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void zzd(int r7) {
        /*
            r6 = this;
            monitor-enter(r6)
            if (r7 > 0) goto L_0x0004
            goto L_0x001f
        L_0x0004:
            java.util.concurrent.TimeUnit r0 = java.util.concurrent.TimeUnit.SECONDS     // Catch:{ all -> 0x003d }
            long r1 = (long) r7     // Catch:{ all -> 0x003d }
            long r0 = r0.toMillis(r1)     // Catch:{ all -> 0x003d }
            boolean r7 = r6.zzf     // Catch:{ all -> 0x003d }
            if (r7 == 0) goto L_0x0021
            long r2 = r6.zze     // Catch:{ all -> 0x003d }
            r4 = 0
            int r7 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r7 <= 0) goto L_0x001c
            int r7 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r7 >= 0) goto L_0x001c
            goto L_0x001d
        L_0x001c:
            r0 = r2
        L_0x001d:
            r6.zze = r0     // Catch:{ all -> 0x003d }
        L_0x001f:
            monitor-exit(r6)
            return
        L_0x0021:
            com.google.android.gms.common.util.Clock r7 = r6.zzc     // Catch:{ all -> 0x003d }
            long r2 = r7.elapsedRealtime()     // Catch:{ all -> 0x003d }
            long r4 = r6.zzd     // Catch:{ all -> 0x003d }
            int r7 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r7 > 0) goto L_0x0038
            com.google.android.gms.common.util.Clock r7 = r6.zzc     // Catch:{ all -> 0x003d }
            long r2 = r7.elapsedRealtime()     // Catch:{ all -> 0x003d }
            long r4 = r4 - r2
            int r7 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1))
            if (r7 <= 0) goto L_0x001f
        L_0x0038:
            r6.zze(r0)     // Catch:{ all -> 0x003d }
            monitor-exit(r6)
            return
        L_0x003d:
            r7 = move-exception
            monitor-exit(r6)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdca.zzd(int):void");
    }
}
