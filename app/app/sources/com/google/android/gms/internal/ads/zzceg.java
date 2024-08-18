package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zzt;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
final class zzceg implements Runnable {
    private final zzcds zza;
    private boolean zzb = false;

    zzceg(zzcds zzcds) {
        this.zza = zzcds;
    }

    private final void zzc() {
        zzt.zza.removeCallbacks(this);
        zzt.zza.postDelayed(this, 250);
    }

    public final void run() {
        if (!this.zzb) {
            this.zza.zzt();
            zzc();
        }
    }

    public final void zza() {
        this.zzb = true;
        this.zza.zzt();
    }

    public final void zzb() {
        this.zzb = false;
        zzc();
    }
}
