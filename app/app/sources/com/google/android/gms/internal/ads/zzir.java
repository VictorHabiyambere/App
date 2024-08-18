package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Handler;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
final class zzir {
    private final Context zza;
    private final zzip zzb;

    public zzir(Context context, Handler handler, zziq zziq) {
        this.zza = context.getApplicationContext();
        this.zzb = new zzip(this, handler, zziq);
    }
}
