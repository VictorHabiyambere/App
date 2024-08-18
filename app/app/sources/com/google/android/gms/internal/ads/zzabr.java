package com.google.android.gms.internal.ads;

import android.view.Surface;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
final class zzabr {
    public static void zza(Surface surface, float frameRate) {
        try {
            surface.setFrameRate(frameRate, frameRate == 0.0f ? 0 : 1);
        } catch (IllegalStateException e) {
            zzfk.zzd("VideoFrameReleaseHelper", "Failed to call Surface.setFrameRate", e);
        }
    }
}
