package com.google.android.gms.internal.ads;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
final class zzcce implements ThreadFactory {
    final /* synthetic */ String zza;
    private final AtomicInteger zzb = new AtomicInteger(1);

    zzcce(String str) {
        this.zza = str;
    }

    public final Thread newThread(Runnable runnable) {
        int andIncrement = this.zzb.getAndIncrement();
        return new Thread(runnable, "AdWorker(" + this.zza + ") #" + andIncrement);
    }
}
