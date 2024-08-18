package com.google.android.gms.internal.ads;

import java.lang.ref.WeakReference;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
final class zzdbz implements Runnable {
    private final WeakReference zza;

    /* synthetic */ zzdbz(zzdca zzdca, zzdby zzdby) {
        this.zza = new WeakReference(zzdca);
    }

    public final void run() {
        zzdca zzdca = (zzdca) this.zza.get();
        if (zzdca != null) {
            zzdca.zzq(new zzdbx());
        }
    }
}
