package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzcpr implements zzcot {
    private final zzdya zza;

    zzcpr(zzdya zzdya) {
        this.zza = zzdya;
    }

    public final void zza(Map map) {
        String str = (String) map.get("test_mode_enabled");
        if (!TextUtils.isEmpty(str)) {
            this.zza.zzo(str.equals("true"));
        }
    }
}
