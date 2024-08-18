package com.google.android.gms.internal.ads;

import com.google.android.gms.common.internal.Preconditions;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzbmj implements zzblp {
    private final zzdya zza;

    public zzbmj(zzdya zzdya) {
        Preconditions.checkNotNull(zzdya, "The Inspector Manager must not be null");
        this.zza = zzdya;
    }

    public final void zza(Object obj, Map map) {
        if (map != null && map.containsKey("extras")) {
            long j = Long.MAX_VALUE;
            if (map.containsKey("expires")) {
                try {
                    j = Long.parseLong((String) map.get("expires"));
                } catch (NumberFormatException e) {
                }
            }
            this.zza.zzi((String) map.get("extras"), j);
        }
    }
}
