package com.google.android.gms.internal.ads;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
final class zzip extends BroadcastReceiver implements Runnable {
    final /* synthetic */ zzir zza;
    private final zziq zzb;
    private final Handler zzc;

    public zzip(zzir zzir, Handler handler, zziq zziq) {
        this.zza = zzir;
        this.zzc = handler;
        this.zzb = zziq;
    }

    public final void onReceive(Context context, Intent intent) {
        if ("android.media.AUDIO_BECOMING_NOISY".equals(intent.getAction())) {
            this.zzc.post(this);
        }
    }

    public final void run() {
    }
}
