package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
final class zzcdr implements Runnable {
    final /* synthetic */ boolean zza;
    final /* synthetic */ zzcds zzb;

    zzcdr(zzcds zzcds, boolean z) {
        this.zza = z;
        this.zzb = zzcds;
    }

    public final void run() {
        this.zzb.zzK("windowVisibilityChanged", "isVisible", String.valueOf(this.zza));
    }
}
