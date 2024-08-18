package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zzg;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzcox implements zzcot {
    private final zzg zza;

    public zzcox(zzg zzg) {
        this.zza = zzg;
    }

    public final void zza(Map map) {
        this.zza.zzA(Boolean.parseBoolean((String) map.get("content_vertical_opted_out")));
    }
}
