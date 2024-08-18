package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzblq implements zzblp {
    private final zzdya zza;

    public zzblq(zzdya zzdya) {
        Preconditions.checkNotNull(zzdya, "The Inspector Manager must not be null");
        this.zza = zzdya;
    }

    public final void zza(Object obj, Map map) {
        if (map != null && map.containsKey("persistentData") && !TextUtils.isEmpty((CharSequence) map.get("persistentData"))) {
            this.zza.zzj((String) map.get("persistentData"));
        }
    }
}
