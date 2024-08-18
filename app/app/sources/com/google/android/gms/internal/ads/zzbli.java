package com.google.android.gms.internal.ads;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.google.android.gms.ads.internal.util.client.zzm;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
final class zzbli implements zzblp {
    zzbli() {
    }

    public final void zza(Object obj, Map map) {
        zzm.zzi("Received log message: ".concat(String.valueOf((String) map.get(TypedValues.Custom.S_STRING))));
    }
}
