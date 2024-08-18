package com.google.android.gms.internal.ads;

import android.view.GestureDetector;
import android.view.MotionEvent;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzdmv implements GestureDetector.OnGestureListener {
    private final zzdlo zza;
    private final zzdmp zzb;

    zzdmv(zzdlo zzdlo, zzdmp zzdmp) {
        this.zza = zzdlo;
        this.zzb = zzdmp;
    }

    public final boolean onDown(MotionEvent motionEvent) {
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:27:0x007a, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized boolean onFling(android.view.MotionEvent r6, android.view.MotionEvent r7, float r8, float r9) {
        /*
            r5 = this;
            monitor-enter(r5)
            com.google.android.gms.internal.ads.zzdlo r0 = r5.zza     // Catch:{ all -> 0x007b }
            r1 = 0
            if (r0 != 0) goto L_0x0008
            goto L_0x0079
        L_0x0008:
            float r0 = java.lang.Math.abs(r8)     // Catch:{ all -> 0x007b }
            float r2 = java.lang.Math.abs(r9)     // Catch:{ all -> 0x007b }
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            r2 = -1
            r3 = 1148846080(0x447a0000, float:1000.0)
            r4 = 0
            if (r0 <= 0) goto L_0x003e
            int r9 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1))
            if (r9 <= 0) goto L_0x002a
            float r7 = r7.getX()     // Catch:{ all -> 0x007b }
            float r6 = r6.getX()     // Catch:{ all -> 0x007b }
            float r7 = r7 - r6
            float r7 = r7 / r8
            float r7 = r7 * r3
            int r6 = (int) r7     // Catch:{ all -> 0x007b }
            r2 = 1
            goto L_0x0064
        L_0x002a:
            int r9 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1))
            if (r9 >= 0) goto L_0x003c
            float r7 = r7.getX()     // Catch:{ all -> 0x007b }
            float r6 = r6.getX()     // Catch:{ all -> 0x007b }
            float r7 = r7 - r6
            float r7 = r7 / r8
            float r7 = r7 * r3
            int r6 = (int) r7     // Catch:{ all -> 0x007b }
            r2 = 2
            goto L_0x0064
        L_0x003c:
            r6 = r1
            goto L_0x0064
        L_0x003e:
            int r8 = (r9 > r4 ? 1 : (r9 == r4 ? 0 : -1))
            if (r8 <= 0) goto L_0x0051
            float r7 = r7.getY()     // Catch:{ all -> 0x007b }
            float r6 = r6.getY()     // Catch:{ all -> 0x007b }
            float r7 = r7 - r6
            float r7 = r7 / r9
            float r7 = r7 * r3
            int r6 = (int) r7     // Catch:{ all -> 0x007b }
            r2 = 8
            goto L_0x0064
        L_0x0051:
            int r8 = (r9 > r4 ? 1 : (r9 == r4 ? 0 : -1))
            if (r8 >= 0) goto L_0x0063
            float r7 = r7.getY()     // Catch:{ all -> 0x007b }
            float r6 = r6.getY()     // Catch:{ all -> 0x007b }
            float r7 = r7 - r6
            float r7 = r7 / r9
            float r7 = r7 * r3
            int r6 = (int) r7     // Catch:{ all -> 0x007b }
            r2 = 4
            goto L_0x0064
        L_0x0063:
            r6 = r1
        L_0x0064:
            com.google.android.gms.internal.ads.zzdlo r7 = r5.zza     // Catch:{ all -> 0x007b }
            int r7 = r7.zza()     // Catch:{ all -> 0x007b }
            if (r2 != r7) goto L_0x0079
            com.google.android.gms.internal.ads.zzdlo r7 = r5.zza     // Catch:{ all -> 0x007b }
            com.google.android.gms.internal.ads.zzdmp r8 = r5.zzb     // Catch:{ all -> 0x007b }
            android.widget.FrameLayout r8 = r8.zzr()     // Catch:{ all -> 0x007b }
            r7.zzE(r8, r6)     // Catch:{ all -> 0x007b }
            monitor-exit(r5)
            return r1
        L_0x0079:
            monitor-exit(r5)
            return r1
        L_0x007b:
            r6 = move-exception
            monitor-exit(r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdmv.onFling(android.view.MotionEvent, android.view.MotionEvent, float, float):boolean");
    }

    public final void onLongPress(MotionEvent motionEvent) {
    }

    public final boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        return false;
    }

    public final void onShowPress(MotionEvent motionEvent) {
    }

    public final synchronized boolean onSingleTapUp(MotionEvent motionEvent) {
        return false;
    }
}
