package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final /* synthetic */ class zzaap implements Executor {
    public final /* synthetic */ zzfb zza;

    public /* synthetic */ zzaap(zzfb zzfb) {
        this.zza = zzfb;
    }

    public final void execute(Runnable runnable) {
        this.zza.zzh(runnable);
    }
}
