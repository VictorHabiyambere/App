package com.google.android.gms.internal.ads;

import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzcur implements zzcus {
    private final Map zza;

    zzcur(Map map) {
        this.zza = map;
    }

    public final zzehl zza(int i, String str) {
        return (zzehl) this.zza.get(str);
    }
}
