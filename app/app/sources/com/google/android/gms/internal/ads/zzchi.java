package com.google.android.gms.internal.ads;

import android.view.View;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
final class zzchi implements View.OnAttachStateChangeListener {
    final /* synthetic */ zzcaf zza;
    final /* synthetic */ zzchl zzb;

    zzchi(zzchl zzchl, zzcaf zzcaf) {
        this.zza = zzcaf;
        this.zzb = zzchl;
    }

    public final void onViewAttachedToWindow(View view) {
        this.zzb.zzW(view, this.zza, 10);
    }

    public final void onViewDetachedFromWindow(View view) {
    }
}
