package com.google.android.gms.internal.ads;

import android.media.MediaCodec;
import android.os.Bundle;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
final class zzum implements zztn {
    private final MediaCodec zza;

    public zzum(MediaCodec mediaCodec) {
        this.zza = mediaCodec;
    }

    public final void zzb() {
    }

    public final void zzc() {
    }

    public final void zzd(int i, int i2, int i3, long j, int i4) {
        this.zza.queueInputBuffer(i, 0, i3, j, i4);
    }

    public final void zze(int i, int i2, zzik zzik, long j, int i3) {
        this.zza.queueSecureInputBuffer(i, 0, zzik.zza(), j, 0);
    }

    public final void zzf(Bundle bundle) {
        this.zza.setParameters(bundle);
    }

    public final void zzg() {
    }

    public final void zzh() {
    }
}
