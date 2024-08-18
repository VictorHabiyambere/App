package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
final class zzcdc implements Runnable {
    final /* synthetic */ String zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ zzcdi zzc;

    zzcdc(zzcdi zzcdi, String str, String str2) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = zzcdi;
    }

    public final void run() {
        zzcdi zzcdi = this.zzc;
        if (zzcdi.zzq != null) {
            zzcdi.zzq.zzb(this.zza, this.zzb);
        }
    }
}
