package com.google.android.gms.internal.ads;

import com.google.android.gms.appset.AppSetIdInfo;
import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final /* synthetic */ class zzezr implements zzgfa {
    public final ListenableFuture zza(Object obj) {
        AppSetIdInfo appSetIdInfo = (AppSetIdInfo) obj;
        if (appSetIdInfo == null) {
            return zzgft.zzh(new zzezu((String) null, -1));
        }
        return zzgft.zzh(new zzezu(appSetIdInfo.getId(), appSetIdInfo.getScope()));
    }
}
