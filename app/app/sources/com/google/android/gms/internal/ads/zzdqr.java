package com.google.android.gms.internal.ads;

import java.lang.ref.WeakReference;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
final class zzdqr implements zzblp {
    final /* synthetic */ zzdqs zza;
    private final WeakReference zzb;
    private final String zzc;
    private final zzblp zzd;

    /* synthetic */ zzdqr(zzdqs zzdqs, WeakReference weakReference, String str, zzblp zzblp, zzdqq zzdqq) {
        this.zza = zzdqs;
        this.zzb = weakReference;
        this.zzc = str;
        this.zzd = zzblp;
    }

    public final void zza(Object obj, Map map) {
        Object obj2 = this.zzb.get();
        if (obj2 == null) {
            this.zza.zzn(this.zzc, this);
        } else {
            this.zzd.zza(obj2, map);
        }
    }
}
