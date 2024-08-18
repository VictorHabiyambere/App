package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zzca;
import com.google.android.gms.ads.internal.zzu;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
final class zzbld implements zzgfp {
    final /* synthetic */ zzchd zza;

    zzbld(zzchd zzchd) {
        this.zza = zzchd;
    }

    public final void zza(Throwable th) {
        zzu.zzo().zzw(th, "DefaultGmsgHandlers.attributionReportingManager");
    }

    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzchd zzchd = this.zza;
        new zzca(zzchd.getContext(), zzchd.zzn().afmaVersion, (String) obj).zzb();
    }
}
