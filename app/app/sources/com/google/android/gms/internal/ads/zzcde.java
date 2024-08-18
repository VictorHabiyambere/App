package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
final class zzcde implements Runnable {
    final /* synthetic */ int zza;
    final /* synthetic */ int zzb;
    final /* synthetic */ zzcdi zzc;

    zzcde(zzcdi zzcdi, int i, int i2) {
        this.zza = i;
        this.zzb = i2;
        this.zzc = zzcdi;
    }

    public final void run() {
        zzcdi zzcdi = this.zzc;
        if (zzcdi.zzq != null) {
            zzcdi.zzq.zzj(this.zza, this.zzb);
        }
    }
}
