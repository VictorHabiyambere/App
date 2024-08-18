package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;
import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzeqi implements zzexw {
    private final Clock zza;
    private final zzfho zzb;

    zzeqi(Clock clock, zzfho zzfho) {
        this.zza = clock;
        this.zzb = zzfho;
    }

    public final int zza() {
        return 4;
    }

    public final ListenableFuture zzb() {
        return zzgft.zzh(new zzeqj(this.zzb, this.zza.currentTimeMillis()));
    }
}
