package com.google.android.gms.internal.ads;

import android.media.AudioTrack;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
final class zzrw extends AudioTrack.StreamEventCallback {
    final /* synthetic */ zzrz zza;
    final /* synthetic */ zzrx zzb;

    zzrw(zzrx zzrx, zzrz zzrz) {
        this.zza = zzrz;
        this.zzb = zzrx;
    }

    public final void onDataRequest(AudioTrack audioTrack, int i) {
        if (audioTrack.equals(this.zzb.zza.zzu)) {
            zzrz zzrz = this.zzb.zza;
            if (zzrz.zzq != null && zzrz.zzS) {
                zzrz.zzq.zzb();
            }
        }
    }

    public final void onPresentationEnded(AudioTrack audioTrack) {
        if (audioTrack.equals(this.zzb.zza.zzu)) {
            this.zzb.zza.zzR = true;
        }
    }

    public final void onTearDown(AudioTrack audioTrack) {
        if (audioTrack.equals(this.zzb.zza.zzu)) {
            zzrz zzrz = this.zzb.zza;
            if (zzrz.zzq != null && zzrz.zzS) {
                zzrz.zzq.zzb();
            }
        }
    }
}
