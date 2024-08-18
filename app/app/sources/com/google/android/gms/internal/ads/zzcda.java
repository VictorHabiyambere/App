package com.google.android.gms.internal.ads;

import android.media.MediaPlayer;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
final class zzcda implements Runnable {
    final /* synthetic */ MediaPlayer zza;
    final /* synthetic */ zzcdi zzb;

    zzcda(zzcdi zzcdi, MediaPlayer mediaPlayer) {
        this.zza = mediaPlayer;
        this.zzb = zzcdi;
    }

    public final void run() {
        zzcdi.zzl(this.zzb, this.zza);
        zzcdi zzcdi = this.zzb;
        if (zzcdi.zzq != null) {
            zzcdi.zzq.zzf();
        }
    }
}
