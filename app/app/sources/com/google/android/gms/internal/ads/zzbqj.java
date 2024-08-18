package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zze;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
final class zzbqj implements zzccp {
    final /* synthetic */ zzccn zza;
    final /* synthetic */ zzbpn zzb;

    zzbqj(zzbql zzbql, zzccn zzccn, zzbpn zzbpn) {
        this.zza = zzccn;
        this.zzb = zzbpn;
    }

    public final void zza() {
        zze.zza("callJs > getEngine: Promise rejected");
        this.zza.zzd(new zzbpw("Unable to obtain a JavascriptEngine."));
        this.zzb.zzb();
    }
}
