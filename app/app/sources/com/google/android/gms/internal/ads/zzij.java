package com.google.android.gms.internal.ads;

import android.media.MediaCodec;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
final class zzij {
    private final MediaCodec.CryptoInfo zza;
    private final MediaCodec.CryptoInfo.Pattern zzb = new MediaCodec.CryptoInfo.Pattern(0, 0);

    /* synthetic */ zzij(MediaCodec.CryptoInfo cryptoInfo, zzii zzii) {
        this.zza = cryptoInfo;
    }

    static /* bridge */ /* synthetic */ void zza(zzij zzij, int i, int i2) {
        zzij.zzb.set(i, i2);
        zzij.zza.setPattern(zzij.zzb);
    }
}
