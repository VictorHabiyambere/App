package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.zzu;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzewe implements zzexw {
    private final zzexw zza;
    private final long zzb;
    private final ScheduledExecutorService zzc;

    public zzewe(zzexw zzexw, long j, ScheduledExecutorService scheduledExecutorService) {
        this.zza = zzexw;
        this.zzb = j;
        this.zzc = scheduledExecutorService;
    }

    public final int zza() {
        return this.zza.zza();
    }

    public final ListenableFuture zzb() {
        ListenableFuture zzb2 = this.zza.zzb();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        if (((Boolean) zzba.zzc().zza(zzbep.zzci)).booleanValue()) {
            timeUnit = TimeUnit.MICROSECONDS;
        }
        long j = this.zzb;
        if (j > 0) {
            zzb2 = zzgft.zzo(zzb2, j, timeUnit, this.zzc);
        }
        return zzgft.zzf(zzb2, Throwable.class, new zzewd(this), zzcci.zzf);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ ListenableFuture zzc(Throwable th) throws Exception {
        if (((Boolean) zzba.zzc().zza(zzbep.zzch)).booleanValue()) {
            zzexw zzexw = this.zza;
            zzcby zzo = zzu.zzo();
            int zza2 = zzexw.zza();
            zzo.zzw(th, "OptionalSignalTimeout:" + zza2);
        }
        return zzgft.zzh((Object) null);
    }
}
