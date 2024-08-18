package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.Looper;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
final class zzfz implements zzfb {
    private static final List zza = new ArrayList(50);
    private final Handler zzb;

    public zzfz(Handler handler) {
        this.zzb = handler;
    }

    static /* bridge */ /* synthetic */ void zzl(zzfy zzfy) {
        synchronized (zza) {
            if (zza.size() < 50) {
                zza.add(zzfy);
            }
        }
    }

    private static zzfy zzm() {
        zzfy zzfy;
        synchronized (zza) {
            if (zza.isEmpty()) {
                zzfy = new zzfy((zzfx) null);
            } else {
                List list = zza;
                zzfy = (zzfy) list.remove(list.size() - 1);
            }
        }
        return zzfy;
    }

    public final Looper zza() {
        return this.zzb.getLooper();
    }

    public final zzfa zzb(int i) {
        Handler handler = this.zzb;
        zzfy zzm = zzm();
        zzm.zzb(handler.obtainMessage(i), this);
        return zzm;
    }

    public final zzfa zzc(int i, Object obj) {
        Handler handler = this.zzb;
        zzfy zzm = zzm();
        zzm.zzb(handler.obtainMessage(i, obj), this);
        return zzm;
    }

    public final zzfa zzd(int i, int i2, int i3) {
        Handler handler = this.zzb;
        zzfy zzm = zzm();
        zzm.zzb(handler.obtainMessage(1, i2, i3), this);
        return zzm;
    }

    public final void zze(Object obj) {
        this.zzb.removeCallbacksAndMessages((Object) null);
    }

    public final void zzf(int i) {
        this.zzb.removeMessages(i);
    }

    public final boolean zzg(int i) {
        return this.zzb.hasMessages(0);
    }

    public final boolean zzh(Runnable runnable) {
        return this.zzb.post(runnable);
    }

    public final boolean zzi(int i) {
        return this.zzb.sendEmptyMessage(i);
    }

    public final boolean zzj(int i, long j) {
        return this.zzb.sendEmptyMessageAtTime(2, j);
    }

    public final boolean zzk(zzfa zzfa) {
        return ((zzfy) zzfa).zzc(this.zzb);
    }
}
