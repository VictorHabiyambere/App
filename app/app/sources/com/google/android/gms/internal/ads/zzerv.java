package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.appset.AppSet;
import com.google.android.gms.appset.AppSetIdClient;
import com.google.android.gms.appset.AppSetIdInfo;
import com.google.android.gms.tasks.CancellationTokenSource;
import com.google.android.gms.tasks.Task;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzerv implements zzexw {
    final zzcby zza;
    AppSetIdClient zzb;
    private final ScheduledExecutorService zzc;
    private final zzgge zzd;
    private final Context zze;

    zzerv(Context context, zzcby zzcby, ScheduledExecutorService scheduledExecutorService, zzgge zzgge) {
        if (!((Boolean) zzba.zzc().zza(zzbep.zzcO)).booleanValue()) {
            this.zzb = AppSet.getClient(context);
        }
        this.zze = context;
        this.zza = zzcby;
        this.zzc = scheduledExecutorService;
        this.zzd = zzgge;
    }

    public final int zza() {
        return 11;
    }

    public final ListenableFuture zzb() {
        Task<AppSetIdInfo> task;
        if (((Boolean) zzba.zzc().zza(zzbep.zzcK)).booleanValue()) {
            if (!((Boolean) zzba.zzc().zza(zzbep.zzcP)).booleanValue()) {
                if (!((Boolean) zzba.zzc().zza(zzbep.zzcL)).booleanValue()) {
                    return zzgft.zzm(zzfvk.zza(this.zzb.getAppSetIdInfo(), (CancellationTokenSource) null), new zzers(), zzcci.zzf);
                }
                if (((Boolean) zzba.zzc().zza(zzbep.zzcO)).booleanValue()) {
                    task = zzfit.zza(this.zze);
                } else {
                    task = this.zzb.getAppSetIdInfo();
                }
                if (task == null) {
                    return zzgft.zzh(new zzerw((String) null, -1));
                }
                ListenableFuture zzn = zzgft.zzn(zzfvk.zza(task, (CancellationTokenSource) null), new zzert(), zzcci.zzf);
                if (((Boolean) zzba.zzc().zza(zzbep.zzcM)).booleanValue()) {
                    zzn = zzgft.zzo(zzn, ((Long) zzba.zzc().zza(zzbep.zzcN)).longValue(), TimeUnit.MILLISECONDS, this.zzc);
                }
                return zzgft.zze(zzn, Exception.class, new zzeru(this), this.zzd);
            }
        }
        return zzgft.zzh(new zzerw((String) null, -1));
    }
}
