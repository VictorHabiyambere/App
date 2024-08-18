package com.google.android.gms.internal.ads;

import android.os.Handler;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzaqv {
    private final Executor zza;

    public zzaqv(Handler handler) {
        this.zza = new zzaqt(this, handler);
    }

    public final void zza(zzare zzare, zzarn zzarn) {
        zzare.zzm("post-error");
        ((zzaqt) this.zza).zza.post(new zzaqu(zzare, zzark.zza(zzarn), (Runnable) null));
    }

    public final void zzb(zzare zzare, zzark zzark, Runnable runnable) {
        zzare.zzq();
        zzare.zzm("post-response");
        ((zzaqt) this.zza).zza.post(new zzaqu(zzare, zzark, runnable));
    }
}
