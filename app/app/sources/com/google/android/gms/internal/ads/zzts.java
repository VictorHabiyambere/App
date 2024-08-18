package com.google.android.gms.internal.ads;

import android.media.metrics.LogSessionId;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
final class zzts {
    public static void zza(zztk codecConfiguration, zzpj playerId) {
        zzpj playerId2 = playerId.zza();
        if (!playerId2.equals(LogSessionId.LOG_SESSION_ID_NONE)) {
            codecConfiguration.zzb.setString("log-session-id", playerId2.getStringId());
        }
    }
}
