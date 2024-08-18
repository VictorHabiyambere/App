package com.google.android.gms.internal.ads;

import android.text.Spannable;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzeo {
    public static void zza(Spannable spannable, Object obj, int i, int i2, int i3) {
        for (Object obj2 : spannable.getSpans(i, i2, obj.getClass())) {
            if (spannable.getSpanStart(obj2) == i && spannable.getSpanEnd(obj2) == i2 && spannable.getSpanFlags(obj2) == 33) {
                spannable.removeSpan(obj2);
            }
        }
        spannable.setSpan(obj, i, i2, 33);
    }
}
