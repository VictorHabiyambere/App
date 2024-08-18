package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.2.0 */
public final class zzbqx {
    private static zzbqx zza;
    private final AtomicBoolean zzb = new AtomicBoolean(false);

    zzbqx() {
    }

    public static zzbqx zza() {
        if (zza == null) {
            zza = new zzbqx();
        }
        return zza;
    }

    public final Thread zzb(Context context, String str) {
        if (!this.zzb.compareAndSet(false, true)) {
            return null;
        }
        Thread thread = new Thread(new zzbqw(this, context, str));
        thread.start();
        return thread;
    }
}
