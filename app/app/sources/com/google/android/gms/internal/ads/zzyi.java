package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final /* synthetic */ class zzyi implements Comparator {
    public final int compare(Object obj, Object obj2) {
        List list = (List) obj;
        List list2 = (List) obj2;
        return zzgar.zzk().zzd((zzzd) Collections.max(list, new zzzb()), (zzzd) Collections.max(list2, new zzzb()), new zzzb()).zzb(list.size(), list2.size()).zzd((zzzd) Collections.max(list, new zzzc()), (zzzd) Collections.max(list2, new zzzc()), new zzzc()).zza();
    }
}
