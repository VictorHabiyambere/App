package com.google.android.gms.internal.ads;

import android.graphics.SurfaceTexture;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.util.zzt;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzcdy {
    private final long zza = TimeUnit.MILLISECONDS.toNanos(((Long) zzba.zzc().zza(zzbep.zzD)).longValue());
    private long zzb;
    private boolean zzc = true;

    zzcdy() {
    }

    public final void zza(SurfaceTexture surfaceTexture, zzcdj zzcdj) {
        if (zzcdj != null) {
            long timestamp = surfaceTexture.getTimestamp();
            if (!this.zzc) {
                if (Math.abs(timestamp - this.zzb) < this.zza) {
                    return;
                }
            }
            this.zzc = false;
            this.zzb = timestamp;
            zzfuv zzfuv = zzt.zza;
            Objects.requireNonNull(zzcdj);
            zzfuv.post(new zzcdx(zzcdj));
        }
    }

    public final void zzb() {
        this.zzc = true;
    }
}
