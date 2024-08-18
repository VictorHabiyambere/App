package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
final class zzaqp implements Runnable {
    final /* synthetic */ zzare zza;
    final /* synthetic */ zzaqq zzb;

    zzaqp(zzaqq zzaqq, zzare zzare) {
        this.zza = zzare;
        this.zzb = zzaqq;
    }

    public final void run() {
        try {
            this.zzb.zzc.put(this.zza);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
