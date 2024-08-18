package com.google.android.gms.internal.ads;

import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzcue implements zzdaz, zzban {
    private final zzfgt zza;
    private final zzdad zzb;
    private final zzdbi zzc;
    private final AtomicBoolean zzd = new AtomicBoolean();
    private final AtomicBoolean zze = new AtomicBoolean();

    public zzcue(zzfgt zzfgt, zzdad zzdad, zzdbi zzdbi) {
        this.zza = zzfgt;
        this.zzb = zzdad;
        this.zzc = zzdbi;
    }

    private final void zza() {
        if (this.zzd.compareAndSet(false, true)) {
            this.zzb.zza();
        }
    }

    public final void zzdp(zzbam zzbam) {
        if (this.zza.zzf == 1 && zzbam.zzj) {
            zza();
        }
        if (zzbam.zzj && this.zze.compareAndSet(false, true)) {
            this.zzc.zza();
        }
    }

    public final synchronized void zzs() {
        if (this.zza.zzf != 1) {
            zza();
        }
    }
}
