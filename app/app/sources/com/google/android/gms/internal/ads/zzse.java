package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
final class zzse implements zzqs {
    final /* synthetic */ zzsf zza;

    /* synthetic */ zzse(zzsf zzsf, zzsd zzsd) {
        this.zza = zzsf;
    }

    public final void zza(Exception exc) {
        zzfk.zzd("MediaCodecAudioRenderer", "Audio sink error", exc);
        this.zza.zzc.zzb(exc);
    }

    public final void zzb() {
        zzsf zzsf = this.zza;
        if (zzsf.zzm != null) {
            zzsf.zzm.zzb();
        }
    }
}
