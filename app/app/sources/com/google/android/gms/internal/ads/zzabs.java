package com.google.android.gms.internal.ads;

import android.hardware.display.DisplayManager;
import android.os.Handler;
import android.view.Display;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
final class zzabs implements DisplayManager.DisplayListener {
    final /* synthetic */ zzabu zza;
    private final DisplayManager zzb;

    public zzabs(zzabu zzabu, DisplayManager displayManager) {
        this.zza = zzabu;
        this.zzb = displayManager;
    }

    private final Display zzc() {
        return this.zzb.getDisplay(0);
    }

    public final void onDisplayAdded(int i) {
    }

    public final void onDisplayChanged(int i) {
        if (i == 0) {
            zzabu.zzb(this.zza, zzc());
        }
    }

    public final void onDisplayRemoved(int i) {
    }

    public final void zza() {
        this.zzb.registerDisplayListener(this, zzgd.zzx((Handler.Callback) null));
        zzabu.zzb(this.zza, zzc());
    }

    public final void zzb() {
        this.zzb.unregisterDisplayListener(this);
    }
}
