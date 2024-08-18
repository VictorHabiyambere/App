package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzba;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzejf implements zzehl {
    /* access modifiers changed from: private */
    public final zzctg zza;
    private final zzeim zzb;
    private final zzgge zzc;
    /* access modifiers changed from: private */
    public final zzczn zzd;
    private final ScheduledExecutorService zze;
    private final zzdux zzf;

    public zzejf(zzctg zzctg, zzeim zzeim, zzczn zzczn, ScheduledExecutorService scheduledExecutorService, zzgge zzgge, zzdux zzdux) {
        this.zza = zzctg;
        this.zzb = zzeim;
        this.zzd = zzczn;
        this.zze = scheduledExecutorService;
        this.zzc = zzgge;
        this.zzf = zzdux;
    }

    public final ListenableFuture zza(zzfhf zzfhf, zzfgt zzfgt) {
        return this.zzc.zzb(new zzejd(this, zzfhf, zzfgt));
    }

    public final boolean zzb(zzfhf zzfhf, zzfgt zzfgt) {
        zzbjm zza2 = zzfhf.zza.zza.zza();
        boolean zzb2 = this.zzb.zzb(zzfhf, zzfgt);
        if (((Boolean) zzba.zzc().zza(zzbep.zzlV)).booleanValue()) {
            String str = "1";
            this.zzf.zzb().put("has_dbl", zza2 != null ? str : "0");
            zzdux zzdux = this.zzf;
            if (true != zzb2) {
                str = "0";
            }
            zzdux.zzb().put("crdb", str);
        }
        if (zza2 == null || !zzb2) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzcsf zzc(zzfhf zzfhf, zzfgt zzfgt) throws Exception {
        return this.zza.zzb(new zzcvf(zzfhf, zzfgt, (String) null), new zzctx(zzfhf.zza.zza.zza(), new zzejc(this, zzfhf, zzfgt))).zza();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzf(zzfhf zzfhf, zzfgt zzfgt) {
        zzgft.zzr(zzgft.zzo(this.zzb.zza(zzfhf, zzfgt), (long) zzfgt.zzS, TimeUnit.SECONDS, this.zze), new zzeje(this), this.zzc);
    }
}
