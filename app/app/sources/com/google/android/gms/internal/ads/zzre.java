package com.google.android.gms.internal.ads;

import android.media.AudioTrack;
import android.os.Handler;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final /* synthetic */ class zzre implements Runnable {
    public final /* synthetic */ AudioTrack zza;
    public final /* synthetic */ zzqs zzb;
    public final /* synthetic */ Handler zzc;
    public final /* synthetic */ zzqp zzd;
    public final /* synthetic */ zzeu zze;

    public /* synthetic */ zzre(AudioTrack audioTrack, zzqs zzqs, Handler handler, zzqp zzqp, zzeu zzeu) {
        this.zza = audioTrack;
        this.zzb = zzqs;
        this.zzc = handler;
        this.zzd = zzqp;
        this.zze = zzeu;
    }

    public final void run() {
        zzrz.zzI(this.zza, this.zzb, this.zzc, this.zzd, this.zze);
    }
}
