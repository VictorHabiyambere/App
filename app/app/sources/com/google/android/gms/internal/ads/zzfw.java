package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzfw implements zzer {
    protected zzfw() {
    }

    public final long zza() {
        return SystemClock.elapsedRealtime();
    }

    public final zzfb zzb(Looper looper, Handler.Callback callback) {
        return new zzfz(new Handler(looper, callback));
    }
}
