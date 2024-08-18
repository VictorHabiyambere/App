package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzevm implements zzexw {
    private final zzfgs zza;

    zzevm(zzfgs zzfgs) {
        this.zza = zzfgs;
    }

    public final int zza() {
        return 25;
    }

    public final ListenableFuture zzb() {
        return zzgft.zzh(new zzevn(this.zza));
    }
}
