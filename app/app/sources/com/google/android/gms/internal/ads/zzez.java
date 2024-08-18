package com.google.android.gms.internal.ads;

import android.content.Context;
import android.opengl.EGL14;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzez {
    public static void zza(boolean z, String str) throws zzey {
        if (!z) {
            throw new zzey(str);
        }
    }

    public static boolean zzb(Context context) {
        if (zzgd.zza < 24) {
            return false;
        }
        if (zzgd.zza < 26 && ("samsung".equals(zzgd.zzc) || "XT1650".equals(zzgd.zzd))) {
            return false;
        }
        if (zzgd.zza >= 26 || context.getPackageManager().hasSystemFeature("android.hardware.vr.high_performance")) {
            return zzd("EGL_EXT_protected_content");
        }
        return false;
    }

    public static boolean zzc() {
        return zzd("EGL_KHR_surfaceless_context");
    }

    private static boolean zzd(String str) {
        String eglQueryString = EGL14.eglQueryString(EGL14.eglGetDisplay(0), 12373);
        if (eglQueryString == null || !eglQueryString.contains(str)) {
            return false;
        }
        return true;
    }
}
