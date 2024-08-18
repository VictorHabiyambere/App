package com.google.android.gms.internal.ads;

import android.media.AudioAttributes;
import android.media.AudioFormat;
import android.media.AudioManager;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
final class zzrc {
    public static zzqa zza(AudioFormat audioFormat, AudioAttributes audioAttributes, boolean isOffloadVariableRateSupported) {
        int playbackOffloadSupport = AudioManager.getPlaybackOffloadSupport(audioFormat, audioAttributes);
        if (playbackOffloadSupport == 0) {
            return zzqa.zza;
        }
        zzpy zzpy = new zzpy();
        boolean z = false;
        if (zzgd.zza > 32 && playbackOffloadSupport == 2) {
            z = true;
        }
        zzpy.zza(true);
        zzpy.zzb(z);
        zzpy.zzc(isOffloadVariableRateSupported);
        return zzpy.zzd();
    }
}
