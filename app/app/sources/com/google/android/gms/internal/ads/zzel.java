package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.text.Spanned;
import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
final class zzel {
    private static final String zza = Integer.toString(0, 36);
    private static final String zzb = Integer.toString(1, 36);
    private static final String zzc = Integer.toString(2, 36);
    private static final String zzd = Integer.toString(3, 36);
    private static final String zze = Integer.toString(4, 36);

    public static ArrayList zza(Spanned spanned) {
        ArrayList arrayList = new ArrayList();
        for (zzen zzen : (zzen[]) spanned.getSpans(0, spanned.length(), zzen.class)) {
            arrayList.add(zzb(spanned, zzen, 1, zzen.zza()));
        }
        for (zzep zzep : (zzep[]) spanned.getSpans(0, spanned.length(), zzep.class)) {
            arrayList.add(zzb(spanned, zzep, 2, zzep.zza()));
        }
        for (zzem zzb2 : (zzem[]) spanned.getSpans(0, spanned.length(), zzem.class)) {
            arrayList.add(zzb(spanned, zzb2, 3, (Bundle) null));
        }
        return arrayList;
    }

    private static Bundle zzb(Spanned spanned, Object obj, int i, Bundle bundle) {
        Bundle bundle2 = new Bundle();
        bundle2.putInt(zza, spanned.getSpanStart(obj));
        bundle2.putInt(zzb, spanned.getSpanEnd(obj));
        bundle2.putInt(zzc, spanned.getSpanFlags(obj));
        bundle2.putInt(zzd, i);
        if (bundle != null) {
            bundle2.putBundle(zze, bundle);
        }
        return bundle2;
    }
}
