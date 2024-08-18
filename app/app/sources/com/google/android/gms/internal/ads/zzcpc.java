package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzba;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
final class zzcpc implements zzcot {
    ListenableFuture zza;
    private final zzehj zzb;

    zzcpc(zzehj zzehj) {
        this.zzb = zzehj;
    }

    public final void zza(Map map) {
        if (((Boolean) zzba.zzc().zza(zzbep.zzkt)).booleanValue()) {
            this.zza = zzgft.zzf(zzgfk.zzu(this.zzb.zza(true)), Throwable.class, new zzcpb(), zzcci.zza);
        }
    }
}
