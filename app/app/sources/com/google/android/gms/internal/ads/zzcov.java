package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zzg;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzcov implements zzcot {
    private final zzg zza;

    public zzcov(zzg zzg) {
        this.zza = zzg;
    }

    public final void zza(Map map) {
        this.zza.zzy(Boolean.parseBoolean((String) map.get("content_url_opted_out")));
    }
}
