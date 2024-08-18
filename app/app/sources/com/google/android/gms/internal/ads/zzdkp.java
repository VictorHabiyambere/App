package com.google.android.gms.internal.ads;

import java.lang.ref.WeakReference;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
final class zzdkp implements zzblp {
    private final WeakReference zza;

    /* synthetic */ zzdkp(zzdkq zzdkq, zzdko zzdko) {
        this.zza = new WeakReference(zzdkq);
    }

    public final void zza(Object obj, Map map) {
        zzdkq zzdkq = (zzdkq) this.zza.get();
        if (zzdkq != null) {
            zzdkq.zzg.zza();
        }
    }
}
