package com.google.android.gms.internal.ads;

import java.util.concurrent.Future;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final /* synthetic */ class zzbde implements Runnable {
    public final /* synthetic */ zzccn zza;
    public final /* synthetic */ Future zzb;

    public /* synthetic */ zzbde(zzccn zzccn, Future future) {
        this.zza = zzccn;
        this.zzb = future;
    }

    public final void run() {
        int i = zzbdg.zzd;
        if (this.zza.isCancelled()) {
            this.zzb.cancel(true);
        }
    }
}
