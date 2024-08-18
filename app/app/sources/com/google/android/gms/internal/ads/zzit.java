package com.google.android.gms.internal.ads;

import android.media.AudioManager;
import android.os.Handler;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
final class zzit implements AudioManager.OnAudioFocusChangeListener {
    final /* synthetic */ zziv zza;
    private final Handler zzb;

    public zzit(zziv zziv, Handler handler) {
        this.zza = zziv;
        this.zzb = handler;
    }

    public final void onAudioFocusChange(int i) {
        this.zzb.post(new zzis(this, i));
    }
}
