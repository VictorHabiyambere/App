package com.google.android.gms.internal.ads;

import android.view.View;
import com.google.android.gms.ads.internal.zzg;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzend implements zzg {
    final AtomicBoolean zza = new AtomicBoolean(false);
    private final zzczj zzb;
    private final zzdad zzc;
    private final zzdhk zzd;
    private final zzdhc zze;
    private final zzcra zzf;

    zzend(zzczj zzczj, zzdad zzdad, zzdhk zzdhk, zzdhc zzdhc, zzcra zzcra) {
        this.zzb = zzczj;
        this.zzc = zzdad;
        this.zzd = zzdhk;
        this.zze = zzdhc;
        this.zzf = zzcra;
    }

    public final synchronized void zza(View view) {
        if (this.zza.compareAndSet(false, true)) {
            this.zzf.zzr();
            this.zze.zza(view);
        }
    }

    public final void zzb() {
        if (this.zza.get()) {
            this.zzb.onAdClicked();
        }
    }

    public final void zzc() {
        if (this.zza.get()) {
            this.zzc.zza();
            this.zzd.zza();
        }
    }
}
