package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzesj implements zzexw {
    private final zzgge zza;
    private final zzfho zzb;

    zzesj(zzgge zzgge, zzfho zzfho) {
        this.zza = zzgge;
        this.zzb = zzfho;
    }

    public final int zza() {
        return 58;
    }

    public final ListenableFuture zzb() {
        return zzgft.zzh(new zzesk(this.zzb.zzp));
    }
}
