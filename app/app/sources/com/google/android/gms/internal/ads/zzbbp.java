package com.google.android.gms.internal.ads;

import java.util.Comparator;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
final class zzbbp implements Comparator {
    zzbbp(zzbbr zzbbr) {
    }

    public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
        zzbbv zzbbv = (zzbbv) obj;
        zzbbv zzbbv2 = (zzbbv) obj2;
        int i = zzbbv.zzc - zzbbv2.zzc;
        if (i != 0) {
            return i;
        }
        return Long.compare(zzbbv.zza, zzbbv2.zza);
    }
}
