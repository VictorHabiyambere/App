package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzehm implements zzehl {
    public final zzehl zza;
    private final zzfxu zzb;

    public zzehm(zzehl zzehl, zzfxu zzfxu) {
        this.zza = zzehl;
        this.zzb = zzfxu;
    }

    public final ListenableFuture zza(zzfhf zzfhf, zzfgt zzfgt) {
        return zzgft.zzm(this.zza.zza(zzfhf, zzfgt), this.zzb, zzcci.zza);
    }

    public final boolean zzb(zzfhf zzfhf, zzfgt zzfgt) {
        return this.zza.zzb(zzfhf, zzfgt);
    }
}
