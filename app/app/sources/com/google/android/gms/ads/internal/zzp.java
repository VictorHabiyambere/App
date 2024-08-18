package com.google.android.gms.ads.internal;

import com.google.android.gms.internal.ads.zzaxc;
import com.google.android.gms.internal.ads.zzaxd;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
final class zzp implements Callable {
    final /* synthetic */ zzt zza;

    zzp(zzt zzt) {
        this.zza = zzt;
    }

    public final /* bridge */ /* synthetic */ Object call() throws Exception {
        zzt zzt = this.zza;
        return new zzaxd(zzaxc.zzt(zzt.zza.afmaVersion, zzt.zzd, false));
    }
}
