package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzba;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzequ implements zzexw {
    private final ListenableFuture zza;
    private final Executor zzb;
    private final ScheduledExecutorService zzc;

    public zzequ(ListenableFuture listenableFuture, Executor executor, ScheduledExecutorService scheduledExecutorService) {
        this.zza = listenableFuture;
        this.zzb = executor;
        this.zzc = scheduledExecutorService;
    }

    public final int zza() {
        return 6;
    }

    public final ListenableFuture zzb() {
        ListenableFuture zzn = zzgft.zzn(this.zza, new zzeqq(), this.zzb);
        if (((Integer) zzba.zzc().zza(zzbep.zzmv)).intValue() > 0) {
            zzbeg zzbeg = zzbep.zzmv;
            zzn = zzgft.zzo(zzn, (long) ((Integer) zzba.zzc().zza(zzbeg)).intValue(), TimeUnit.MILLISECONDS, this.zzc);
        }
        return zzgft.zzf(zzn, Throwable.class, new zzeqr(), this.zzb);
    }
}
