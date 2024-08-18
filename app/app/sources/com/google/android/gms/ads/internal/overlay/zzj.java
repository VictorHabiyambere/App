package com.google.android.gms.ads.internal.overlay;

import android.graphics.drawable.Drawable;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final /* synthetic */ class zzj implements Runnable {
    public final /* synthetic */ zzl zza;
    public final /* synthetic */ Drawable zzb;

    public /* synthetic */ zzj(zzl zzl, Drawable drawable) {
        this.zza = zzl;
        this.zzb = drawable;
    }

    public final void run() {
        this.zza.zza.zzb.getWindow().setBackgroundDrawable(this.zzb);
    }
}
