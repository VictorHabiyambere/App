package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
final class zzcdq implements Runnable {
    final /* synthetic */ zzcds zza;

    zzcdq(zzcds zzcds) {
        this.zza = zzcds;
    }

    public final void run() {
        this.zza.zzK("surfaceDestroyed", new String[0]);
    }
}
