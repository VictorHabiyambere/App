package com.google.android.gms.internal.ads;

import android.content.pm.ApplicationInfo;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final /* synthetic */ class zzech implements zzfxu {
    public final /* synthetic */ zzbxu zza;

    public /* synthetic */ zzech(zzbxu zzbxu) {
        this.zza = zzbxu;
    }

    public final Object apply(Object obj) {
        zzbxu zzbxu = this.zza;
        String zzc = zzfyv.zzc(zzbxu.zza.getString("ms"));
        ApplicationInfo applicationInfo = zzbxu.zzc;
        String str = zzbxu.zzh;
        return new zzbwv(applicationInfo, zzbxu.zzd, zzbxu.zzf, zzc, -1, str, zzbxu.zze, zzbxu.zzk, zzbxu.zzl);
    }
}
