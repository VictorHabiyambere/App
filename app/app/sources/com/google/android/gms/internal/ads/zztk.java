package com.google.android.gms.internal.ads;

import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.view.Surface;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zztk {
    public final zztp zza;
    public final MediaFormat zzb;
    public final zzan zzc;
    public final Surface zzd;
    public final MediaCrypto zze = null;

    private zztk(zztp zztp, MediaFormat mediaFormat, zzan zzan, Surface surface, MediaCrypto mediaCrypto, int i) {
        this.zza = zztp;
        this.zzb = mediaFormat;
        this.zzc = zzan;
        this.zzd = surface;
    }

    public static zztk zza(zztp zztp, MediaFormat mediaFormat, zzan zzan, MediaCrypto mediaCrypto) {
        return new zztk(zztp, mediaFormat, zzan, (Surface) null, (MediaCrypto) null, 0);
    }

    public static zztk zzb(zztp zztp, MediaFormat mediaFormat, zzan zzan, Surface surface, MediaCrypto mediaCrypto) {
        return new zztk(zztp, mediaFormat, zzan, surface, (MediaCrypto) null, 0);
    }
}
