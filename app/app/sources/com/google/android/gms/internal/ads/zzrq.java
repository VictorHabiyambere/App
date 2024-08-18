package com.google.android.gms.internal.ads;

import android.media.AudioRouting;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final /* synthetic */ class zzrq implements AudioRouting.OnRoutingChangedListener {
    public final /* synthetic */ zzrr zza;

    public /* synthetic */ zzrq(zzrr zzrr) {
        this.zza = zzrr;
    }

    public final void onRoutingChanged(AudioRouting audioRouting) {
        this.zza.zzc(audioRouting);
    }
}
