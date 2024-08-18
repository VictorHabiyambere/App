package com.google.android.gms.internal.ads;

import android.media.AudioAttributes;
import android.media.AudioFormat;
import android.media.AudioManager;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
final class zzrb {
    public static zzqa zza(AudioFormat audioFormat, AudioAttributes audioAttributes, boolean isOffloadVariableRateSupported) {
        if (!AudioManager.isOffloadedPlaybackSupported(audioFormat, audioAttributes)) {
            return zzqa.zza;
        }
        zzpy zzpy = new zzpy();
        zzpy.zza(true);
        zzpy.zzc(isOffloadVariableRateSupported);
        return zzpy.zzd();
    }
}
