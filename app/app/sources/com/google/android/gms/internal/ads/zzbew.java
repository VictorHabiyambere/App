package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzu;

@Deprecated
/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzbew {
    public static boolean zza(zzbfe zzbfe, zzbfb zzbfb, String... strArr) {
        if (zzbfb == null) {
            return false;
        }
        zzbfe.zze(zzbfb, zzu.zzB().elapsedRealtime(), strArr);
        return true;
    }
}
