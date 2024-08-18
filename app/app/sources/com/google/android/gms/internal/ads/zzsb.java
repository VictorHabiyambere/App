package com.google.android.gms.internal.ads;

import androidx.compose.animation.core.AnimationKt;
import androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzsb implements zzrk {
    protected zzsb(zzsa zzsa) {
    }

    protected static int zza(int i, int i2, int i3) {
        return zzgea.zzb(((((long) i) * ((long) i2)) * ((long) i3)) / AnimationKt.MillisToNanos);
    }

    protected static int zzb(int i) {
        switch (i) {
            case 5:
                return 80000;
            case 6:
            case 18:
                return 768000;
            case 7:
                return 192000;
            case 8:
                return 2250000;
            case 9:
                return 40000;
            case 10:
                return AndroidComposeViewAccessibilityDelegateCompat.ParcelSafeTextLength;
            case 11:
                return 16000;
            case 12:
                return 7000;
            case 14:
                return 3062500;
            case 15:
                return 8000;
            case 16:
                return 256000;
            case 17:
                return 336000;
            case 20:
                return 63750;
            default:
                throw new IllegalArgumentException();
        }
    }
}
