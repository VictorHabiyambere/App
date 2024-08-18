package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzba;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzerq implements zzexw {
    private final Executor zza;
    private final zzcby zzb;

    zzerq(Executor executor, zzcby zzcby) {
        this.zza = executor;
        this.zzb = zzcby;
    }

    public final int zza() {
        return 10;
    }

    public final ListenableFuture zzb() {
        if (((Boolean) zzba.zzc().zza(zzbep.zzcJ)).booleanValue()) {
            return zzgft.zzh((Object) null);
        }
        return zzgft.zzm(this.zzb.zzk(), new zzerp(), this.zza);
    }
}
