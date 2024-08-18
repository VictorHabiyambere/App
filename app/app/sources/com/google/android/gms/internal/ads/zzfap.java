package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzfap implements zzexw {
    final zzgge zza;
    final List zzb;
    final zzbdy zzc;

    public zzfap(zzbdy zzbdy, zzgge zzgge, List list) {
        this.zzc = zzbdy;
        this.zza = zzgge;
        this.zzb = list;
    }

    public final int zza() {
        return 48;
    }

    public final ListenableFuture zzb() {
        return this.zza.zzb(new zzfao(this));
    }
}
