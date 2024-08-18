package com.google.android.gms.internal.ads;

import android.content.Context;
import android.media.metrics.LogSessionId;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
final class zzkn {
    public static zzpj zza(Context context, zzkw player, boolean usePlatformDiagnostics, String playerName) {
        zzpf zzb = zzpf.zzb(context);
        if (zzb == null) {
            zzfk.zzf("ExoPlayerImpl", "MediaMetricsService unavailable.");
            return new zzpj(LogSessionId.LOG_SESSION_ID_NONE, playerName);
        }
        if (usePlatformDiagnostics) {
            player.zzz(zzb);
        }
        return new zzpj(zzb.zza(), playerName);
    }
}
