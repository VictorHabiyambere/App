package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zze;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
final class zzbqi implements zzccr {
    final /* synthetic */ zzbpn zza;
    final /* synthetic */ Object zzb;
    final /* synthetic */ zzccn zzc;
    final /* synthetic */ zzbql zzd;

    zzbqi(zzbql zzbql, zzbpn zzbpn, Object obj, zzccn zzccn) {
        this.zza = zzbpn;
        this.zzb = obj;
        this.zzc = zzccn;
        this.zzd = zzbql;
    }

    public final /* bridge */ /* synthetic */ void zza(Object obj) {
        zze.zza("callJs > getEngine: Promise fulfilled");
        Object obj2 = this.zzb;
        zzccn zzccn = this.zzc;
        zzbql.zzd(this.zzd, this.zza, (zzbpu) obj, obj2, zzccn);
    }
}
