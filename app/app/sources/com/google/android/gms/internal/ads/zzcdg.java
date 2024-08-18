package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
final class zzcdg implements Runnable {
    final /* synthetic */ zzcdi zza;

    zzcdg(zzcdi zzcdi) {
        this.zza = zzcdi;
    }

    public final void run() {
        zzcdi zzcdi = this.zza;
        if (zzcdi.zzq != null) {
            if (!zzcdi.zzr) {
                zzcdi.zzq.zzg();
                this.zza.zzr = true;
            }
            this.zza.zzq.zze();
        }
    }
}
