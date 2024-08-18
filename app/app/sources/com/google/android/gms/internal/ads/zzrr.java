package com.google.android.gms.internal.ads;

import android.media.AudioRouting;
import android.media.AudioTrack;
import android.os.Handler;
import android.os.Looper;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
final class zzrr {
    private final AudioTrack zza;
    private final zzpw zzb;
    private AudioRouting.OnRoutingChangedListener zzc = new zzrq(this);

    public zzrr(AudioTrack audioTrack, zzpw zzpw) {
        this.zza = audioTrack;
        this.zzb = zzpw;
        audioTrack.addOnRoutingChangedListener(this.zzc, new Handler(Looper.myLooper()));
    }

    /* access modifiers changed from: private */
    public void zzc(AudioRouting router) {
        if (this.zzc != null && router.getRoutedDevice() != null) {
            this.zzb.zzh(router.getRoutedDevice());
        }
    }

    public void zzb() {
        AudioRouting.OnRoutingChangedListener onRoutingChangedListener = this.zzc;
        if (onRoutingChangedListener != null) {
            this.zza.removeOnRoutingChangedListener(onRoutingChangedListener);
            this.zzc = null;
            return;
        }
        throw null;
    }
}
