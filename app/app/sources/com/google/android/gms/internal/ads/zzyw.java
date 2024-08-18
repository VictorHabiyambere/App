package com.google.android.gms.internal.ads;

import android.media.Spatializer;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
final class zzyw implements Spatializer.OnSpatializerStateChangedListener {
    final /* synthetic */ zzze zza;

    zzyw(zzyx zzyx, zzze zzze) {
        this.zza = zzze;
    }

    public final void onSpatializerAvailableChanged(Spatializer spatializer, boolean z) {
        this.zza.zzv();
    }

    public final void onSpatializerEnabledChanged(Spatializer spatializer, boolean z) {
        this.zza.zzv();
    }
}
