package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzba;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzdns implements zzdaf {
    private final zzdlt zza;
    private final zzdly zzb;
    private final Executor zzc;
    private final Executor zzd;

    public zzdns(zzdlt zzdlt, zzdly zzdly, Executor executor, Executor executor2) {
        this.zza = zzdlt;
        this.zzb = zzdly;
        this.zzc = executor;
        this.zzd = executor2;
    }

    /* access modifiers changed from: private */
    public final void zzb(zzchd zzchd) {
        this.zzc.execute(new zzdnq(zzchd));
    }

    public final void zzr() {
        if (this.zzb.zzd()) {
            zzdlt zzdlt = this.zza;
            zzehg zzu = zzdlt.zzu();
            if (zzu == null && zzdlt.zzw() != null) {
                if (((Boolean) zzba.zzc().zza(zzbep.zzfi)).booleanValue()) {
                    zzdlt zzdlt2 = this.zza;
                    ListenableFuture zzw = zzdlt2.zzw();
                    zzccn zzp = zzdlt2.zzp();
                    if (zzw != null && zzp != null) {
                        zzgft.zzr(zzgft.zzl(zzw, zzp), new zzdnr(this), this.zzd);
                        return;
                    }
                    return;
                }
            }
            if (zzu != null) {
                zzdlt zzdlt3 = this.zza;
                zzchd zzr = zzdlt3.zzr();
                zzchd zzs = zzdlt3.zzs();
                if (zzr == null) {
                    zzr = zzs != null ? zzs : null;
                }
                if (zzr != null) {
                    zzb(zzr);
                }
            }
        }
    }
}
