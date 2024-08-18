package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzekp {
    private final Executor zza;
    private final ScheduledExecutorService zzb;
    private final zzcus zzc;
    private final zzelf zzd;
    private final zzfoa zze;
    private final zzggm zzf = zzggm.zze();
    private final AtomicBoolean zzg = new AtomicBoolean();
    /* access modifiers changed from: private */
    public zzekq zzh;
    private zzfhf zzi;

    zzekp(Executor executor, ScheduledExecutorService scheduledExecutorService, zzcus zzcus, zzelf zzelf, zzfoa zzfoa) {
        this.zza = executor;
        this.zzb = scheduledExecutorService;
        this.zzc = zzcus;
        this.zzd = zzelf;
        this.zze = zzfoa;
    }

    private final synchronized ListenableFuture zzd(zzfgt zzfgt) {
        for (String zza2 : zzfgt.zza) {
            zzehl zza3 = this.zzc.zza(zzfgt.zzb, zza2);
            if (zza3 != null && zza3.zzb(this.zzi, zzfgt)) {
                ListenableFuture zza4 = zza3.zza(this.zzi, zzfgt);
                int i = zzfgt.zzS;
                return zzgft.zzo(zza4, (long) i, TimeUnit.MILLISECONDS, this.zzb);
            }
        }
        return zzgft.zzg(new zzdzd(3));
    }

    /* access modifiers changed from: private */
    public final void zze(zzfgt zzfgt) {
        ListenableFuture zzd2 = zzd(zzfgt);
        this.zzd.zzf(this.zzi, zzfgt, zzd2, this.zze);
        zzgft.zzr(zzd2, new zzeko(this, zzfgt), this.zza);
    }

    public final synchronized ListenableFuture zzb(zzfhf zzfhf) {
        if (!this.zzg.getAndSet(true)) {
            if (zzfhf.zzb.zza.isEmpty()) {
                this.zzf.zzd(new zzelj(3, zzelm.zzc(zzfhf)));
            } else {
                this.zzi = zzfhf;
                this.zzh = new zzekq(zzfhf, this.zzd, this.zzf);
                this.zzd.zzk(zzfhf.zzb.zza);
                zzfgt zza2 = this.zzh.zza();
                while (zza2 != null) {
                    zze(zza2);
                    zza2 = this.zzh.zza();
                }
            }
        }
        return this.zzf;
    }
}
