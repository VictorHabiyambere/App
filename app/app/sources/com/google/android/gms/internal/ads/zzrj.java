package com.google.android.gms.internal.ads;

import android.media.AudioTrack;
import android.media.metrics.LogSessionId;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
final class zzrj {
    public static void zza(AudioTrack audioTrack, zzpj playerId) {
        zzpj playerId2 = playerId.zza();
        if (!playerId2.equals(LogSessionId.LOG_SESSION_ID_NONE)) {
            audioTrack.setLogSessionId(playerId2);
        }
    }
}
