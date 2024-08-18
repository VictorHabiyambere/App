package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.tasks.CancellationTokenSource;
import com.google.android.gms.tasks.Tasks;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzezt implements zzexw {
    private final zzcby zza;
    private final String zzb;
    private final ScheduledExecutorService zzc;
    private final zzgge zzd;
    private final zzbcp zze;

    zzezt(String str, zzbcp zzbcp, zzcby zzcby, ScheduledExecutorService scheduledExecutorService, zzgge zzgge) {
        this.zzb = str;
        this.zze = zzbcp;
        this.zza = zzcby;
        this.zzc = scheduledExecutorService;
        this.zzd = zzgge;
    }

    public final int zza() {
        return 43;
    }

    public final ListenableFuture zzb() {
        if (((Boolean) zzba.zzc().zza(zzbep.zzcK)).booleanValue()) {
            if (((Boolean) zzba.zzc().zza(zzbep.zzcP)).booleanValue()) {
                ListenableFuture zzn = zzgft.zzn(zzfvk.zza(Tasks.forResult(null), (CancellationTokenSource) null), new zzezr(), this.zzd);
                if (((Boolean) zzbfy.zza.zze()).booleanValue()) {
                    zzn = zzgft.zzo(zzn, ((Long) zzbfy.zzb.zze()).longValue(), TimeUnit.MILLISECONDS, this.zzc);
                }
                return zzgft.zze(zzn, Exception.class, new zzezs(this), this.zzd);
            }
        }
        return zzgft.zzh(new zzezu((String) null, -1));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzezu zzc(Exception exc) {
        this.zza.zzw(exc, "AppSetIdInfoGmscoreSignal");
        return new zzezu((String) null, -1);
    }
}
