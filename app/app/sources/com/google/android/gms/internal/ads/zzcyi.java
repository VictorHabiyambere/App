package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.util.zze;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzcyi implements zzczl, zzdgn, zzded, zzdab, zzban {
    /* access modifiers changed from: private */
    public final zzdad zza;
    private final zzfgt zzb;
    private final ScheduledExecutorService zzc;
    private final Executor zzd;
    private final zzggm zze = zzggm.zze();
    private ScheduledFuture zzf;
    private final AtomicBoolean zzg = new AtomicBoolean();
    private final String zzh;

    zzcyi(zzdad zzdad, zzfgt zzfgt, ScheduledExecutorService scheduledExecutorService, Executor executor, String str) {
        this.zza = zzdad;
        this.zzb = zzfgt;
        this.zzc = scheduledExecutorService;
        this.zzd = executor;
        this.zzh = str;
    }

    private final boolean zzm() {
        return this.zzh.equals("com.google.ads.mediation.admob.AdMobAdapter");
    }

    public final void zza() {
    }

    public final void zzb() {
    }

    public final void zzc() {
        zzfgt zzfgt = this.zzb;
        if (zzfgt.zzf != 3) {
            int i = zzfgt.zzZ;
            if (i == 0 || i == 1) {
                if (!((Boolean) zzba.zzc().zza(zzbep.zzlw)).booleanValue() || !zzm()) {
                    this.zza.zza();
                }
            }
        }
    }

    public final void zzdp(zzbam zzbam) {
        if (((Boolean) zzba.zzc().zza(zzbep.zzlw)).booleanValue() && zzm() && zzbam.zzj && this.zzg.compareAndSet(false, true) && this.zzb.zzf != 3) {
            zze.zza("Full screen 1px impression occurred");
            this.zza.zza();
        }
    }

    public final void zzds(zzbyh zzbyh, String str, String str2) {
    }

    public final void zze() {
    }

    public final void zzf() {
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzh() {
        synchronized (this) {
            if (!this.zze.isDone()) {
                this.zze.zzc(true);
            }
        }
    }

    public final void zzi() {
    }

    public final synchronized void zzj() {
        if (!this.zze.isDone()) {
            ScheduledFuture scheduledFuture = this.zzf;
            if (scheduledFuture != null) {
                scheduledFuture.cancel(true);
            }
            this.zze.zzc(true);
        }
    }

    public final void zzk() {
        if (this.zzb.zzf != 3) {
            if (((Boolean) zzba.zzc().zza(zzbep.zzbx)).booleanValue()) {
                zzfgt zzfgt = this.zzb;
                if (zzfgt.zzZ != 2) {
                    return;
                }
                if (zzfgt.zzr == 0) {
                    this.zza.zza();
                    return;
                }
                zzgft.zzr(this.zze, new zzcyh(this), this.zzd);
                this.zzf = this.zzc.schedule(new zzcyg(this), (long) this.zzb.zzr, TimeUnit.MILLISECONDS);
            }
        }
    }

    public final void zzl() {
    }

    public final synchronized void zzq(com.google.android.gms.ads.internal.client.zze zze2) {
        if (!this.zze.isDone()) {
            ScheduledFuture scheduledFuture = this.zzf;
            if (scheduledFuture != null) {
                scheduledFuture.cancel(true);
            }
            this.zze.zzd(new Exception());
        }
    }
}
