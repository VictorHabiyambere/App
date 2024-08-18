package com.google.android.gms.internal.ads;

import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final /* synthetic */ class zzctt implements Runnable {
    public final /* synthetic */ AtomicReference zza;

    public /* synthetic */ zzctt(AtomicReference atomicReference) {
        this.zza = atomicReference;
    }

    public final void run() {
        zzctv.zzi(this.zza);
    }
}
