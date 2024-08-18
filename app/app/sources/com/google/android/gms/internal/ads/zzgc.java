package com.google.android.gms.internal.ads;

import java.util.concurrent.ThreadFactory;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final /* synthetic */ class zzgc implements ThreadFactory {
    public final /* synthetic */ String zza;

    public /* synthetic */ zzgc(String str) {
        this.zza = str;
    }

    public final Thread newThread(Runnable runnable) {
        return new Thread(runnable, this.zza);
    }
}
