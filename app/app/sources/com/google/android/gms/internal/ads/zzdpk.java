package com.google.android.gms.internal.ads;

import java.util.HashMap;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final /* synthetic */ class zzdpk implements zzban {
    public final /* synthetic */ zzchd zza;

    public /* synthetic */ zzdpk(zzchd zzchd) {
        this.zza = zzchd;
    }

    public final void zzdp(zzbam zzbam) {
        String str;
        HashMap hashMap = new HashMap();
        if (true != zzbam.zzj) {
            str = "0";
        } else {
            str = "1";
        }
        hashMap.put("isVisible", str);
        this.zza.zzd("onAdVisibilityChanged", hashMap);
    }
}
