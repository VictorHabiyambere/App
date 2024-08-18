package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzezz implements zzexw {
    private final Context zza;
    private final zzcby zzb;
    private final ScheduledExecutorService zzc;
    private final Executor zzd;
    private final String zze;
    private final zzcbp zzf;

    public zzezz(zzcbp zzcbp, int i, Context context, zzcby zzcby, ScheduledExecutorService scheduledExecutorService, Executor executor, String str) {
        this.zzf = zzcbp;
        this.zza = context;
        this.zzb = zzcby;
        this.zzc = scheduledExecutorService;
        this.zzd = executor;
        this.zze = str;
    }

    public final int zza() {
        return 44;
    }

    public final ListenableFuture zzb() {
        return zzgft.zze((zzgfk) zzgft.zzo(zzgft.zzm(zzgfk.zzu(zzgft.zzk(new zzezw(this), this.zzd)), new zzezx(), this.zzd), ((Long) zzba.zzc().zza(zzbep.zzaW)).longValue(), TimeUnit.MILLISECONDS, this.zzc), Exception.class, new zzezy(this), zzggk.zzb());
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzfaa zzc(Exception exc) {
        this.zzb.zzw(exc, "AttestationTokenSignal");
        return null;
    }
}
