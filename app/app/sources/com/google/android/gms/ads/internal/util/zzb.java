package com.google.android.gms.ads.internal.util;

import com.google.android.gms.internal.ads.zzcci;
import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public abstract class zzb {
    private final Runnable zza = new zza(this);
    /* access modifiers changed from: private */
    public volatile Thread zzb;

    public abstract void zza();

    public ListenableFuture zzb() {
        return zzcci.zza.zza(this.zza);
    }
}
