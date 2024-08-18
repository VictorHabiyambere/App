package com.google.android.gms.internal.ads;

import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
final class zzamx {
    public static zzamy zza(zzamy zzamy, String[] strArr, Map map) {
        int length;
        int i = 0;
        if (zzamy == null) {
            if (strArr == null) {
                return null;
            }
            int length2 = strArr.length;
            if (length2 == 1) {
                return (zzamy) map.get(strArr[0]);
            }
            if (length2 > 1) {
                zzamy zzamy2 = new zzamy();
                while (i < length2) {
                    zzamy2.zzl((zzamy) map.get(strArr[i]));
                    i++;
                }
                return zzamy2;
            }
        } else if (strArr != null && strArr.length == 1) {
            zzamy.zzl((zzamy) map.get(strArr[0]));
            return zzamy;
        } else if (strArr != null && (length = strArr.length) > 1) {
            while (i < length) {
                zzamy.zzl((zzamy) map.get(strArr[i]));
                i++;
            }
            return zzamy;
        }
        return zzamy;
    }
}
