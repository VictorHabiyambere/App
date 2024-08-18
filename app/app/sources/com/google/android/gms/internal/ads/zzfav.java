package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzfav implements zzexw {
    final ScheduledExecutorService zza;
    final Context zzb;
    final zzbvk zzc;

    public zzfav(zzbvk zzbvk, ScheduledExecutorService scheduledExecutorService, Context context) {
        this.zzc = zzbvk;
        this.zza = scheduledExecutorService;
        this.zzb = context;
    }

    public final int zza() {
        return 49;
    }

    public final ListenableFuture zzb() {
        return zzgft.zzm(zzgft.zzo(zzgft.zzh(new Bundle()), ((Long) zzba.zzc().zza(zzbep.zzee)).longValue(), TimeUnit.MILLISECONDS, this.zza), new zzfau(), zzcci.zza);
    }
}
