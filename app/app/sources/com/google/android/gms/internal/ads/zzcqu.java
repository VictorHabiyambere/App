package com.google.android.gms.internal.ads;

import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
final class zzcqu implements zzblp {
    final /* synthetic */ zzcqv zza;

    zzcqu(zzcqv zzcqv) {
        this.zza = zzcqv;
    }

    public final void zza(Object obj, Map map) {
        if (zzcqv.zzg(this.zza, map)) {
            this.zza.zzc.execute(new zzcqt(this));
        }
    }
}
