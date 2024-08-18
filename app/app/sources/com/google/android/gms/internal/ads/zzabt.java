package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.view.Choreographer;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
final class zzabt implements Choreographer.FrameCallback, Handler.Callback {
    private static final zzabt zzb = new zzabt();
    public volatile long zza = -9223372036854775807L;
    private final Handler zzc;
    private final HandlerThread zzd = new HandlerThread("ExoPlayer:FrameReleaseChoreographer");
    private Choreographer zze;
    private int zzf;

    private zzabt() {
        this.zzd.start();
        this.zzc = new Handler(this.zzd.getLooper(), this);
        this.zzc.sendEmptyMessage(0);
    }

    public static zzabt zza() {
        return zzb;
    }

    public final boolean handleMessage(Message message) {
        switch (message.what) {
            case 0:
                try {
                    this.zze = Choreographer.getInstance();
                } catch (RuntimeException e) {
                    zzfk.zzg("VideoFrameReleaseHelper", "Vsync sampling disabled due to platform error", e);
                }
                return true;
            case 1:
                Choreographer choreographer = this.zze;
                if (choreographer != null) {
                    int i = this.zzf + 1;
                    this.zzf = i;
                    if (i == 1) {
                        choreographer.postFrameCallback(this);
                    }
                }
                return true;
            case 2:
                Choreographer choreographer2 = this.zze;
                if (choreographer2 != null) {
                    int i2 = this.zzf - 1;
                    this.zzf = i2;
                    if (i2 == 0) {
                        choreographer2.removeFrameCallback(this);
                        this.zza = -9223372036854775807L;
                    }
                }
                return true;
            default:
                return false;
        }
    }

    public final void zzb() {
        this.zzc.sendEmptyMessage(1);
    }

    public final void zzc() {
        this.zzc.sendEmptyMessage(2);
    }

    public final void doFrame(long j) {
        this.zza = j;
        Choreographer choreographer = this.zze;
        if (choreographer != null) {
            choreographer.postFrameCallbackDelayed(this, 500);
            return;
        }
        throw null;
    }
}
