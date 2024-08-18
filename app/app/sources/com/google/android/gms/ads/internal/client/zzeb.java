package com.google.android.gms.ads.internal.client;

import com.google.android.gms.ads.initialization.InitializationStatus;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.2.0 */
public final /* synthetic */ class zzeb implements InitializationStatus {
    public final /* synthetic */ zzej zza;

    public /* synthetic */ zzeb(zzej zzej) {
        this.zza = zzej;
    }

    public final Map getAdapterStatusMap() {
        HashMap hashMap = new HashMap();
        hashMap.put("com.google.android.gms.ads.MobileAds", new zzee(this.zza));
        return hashMap;
    }
}
