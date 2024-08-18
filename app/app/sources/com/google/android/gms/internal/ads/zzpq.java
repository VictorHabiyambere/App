package com.google.android.gms.internal.ads;

import android.content.Context;
import android.media.AudioDeviceCallback;
import android.media.AudioManager;
import android.os.Handler;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
final class zzpq {
    public static void zza(Context context, AudioDeviceCallback callback, Handler handler) {
        AudioManager audioManager = (AudioManager) context.getSystemService("audio");
        if (audioManager != null) {
            audioManager.registerAudioDeviceCallback(callback, handler);
            return;
        }
        throw null;
    }

    public static void zzb(Context context, AudioDeviceCallback callback) {
        AudioManager audioManager = (AudioManager) context.getSystemService("audio");
        if (audioManager != null) {
            audioManager.unregisterAudioDeviceCallback(callback);
            return;
        }
        throw null;
    }
}
