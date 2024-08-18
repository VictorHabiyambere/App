package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.client.zzm;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final /* synthetic */ class zzewv implements zzfxu {
    public final /* synthetic */ String zza;

    public /* synthetic */ zzewv(String str) {
        this.zza = str;
    }

    public final Object apply(Object obj) {
        Throwable th = (Throwable) obj;
        zzm.zzg("Error calling adapter: ".concat(String.valueOf(this.zza)));
        return null;
    }
}
