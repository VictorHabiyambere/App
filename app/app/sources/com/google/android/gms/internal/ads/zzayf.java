package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.SystemClock;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzayf {
    private long zza = -1;
    private long zzb = -1;
    private long zzc = -1;
    private long zzd = -1;
    private long zze = -1;
    private long zzf = -1;
    private long zzg = -1;
    private long zzh = -1;

    private static DisplayMetrics zzl(Context context) {
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        try {
            defaultDisplay.getRealMetrics(displayMetrics);
        } catch (NoSuchMethodError e) {
            defaultDisplay.getMetrics(displayMetrics);
        }
        return displayMetrics;
    }

    private static boolean zzm(View view) {
        try {
            if (view.getClass().getName().contains("DebugGestureViewWrapper")) {
                view = ((ViewGroup) view).getChildAt(0);
            }
            Object invoke = view.getClass().getMethod("getAdConfiguration", new Class[0]).invoke(view, new Object[0]);
            int intValue = ((Integer) invoke.getClass().getField("adType").get(invoke)).intValue();
            String str = (String) invoke.getClass().getMethod("adTypeToString", new Class[]{Integer.TYPE}).invoke((Object) null, new Object[]{Integer.valueOf(intValue)});
            if (str.contains("INTERSTITIAL") || str.contains("APP_OPEN") || str.contains("REWARDED")) {
                return true;
            }
            return false;
        } catch (ReflectiveOperationException | SecurityException e) {
            return false;
        }
    }

    public final long zza() {
        return this.zzg;
    }

    public final long zzb() {
        return this.zze;
    }

    public final long zzc() {
        return this.zza;
    }

    public final long zzd() {
        return this.zzc;
    }

    public final long zze() {
        return this.zzh;
    }

    public final long zzf() {
        return this.zzf;
    }

    public final long zzg() {
        return this.zzb;
    }

    public final long zzh() {
        return this.zzd;
    }

    public final void zzi() {
        this.zzh = this.zzg;
        this.zzg = SystemClock.uptimeMillis();
    }

    public final void zzj() {
        this.zzb = this.zza;
        this.zza = SystemClock.uptimeMillis();
    }

    public final void zzk(Context context, View view) {
        this.zzd = this.zzc;
        this.zzc = SystemClock.uptimeMillis();
        long j = this.zze;
        if (j != -1) {
            this.zzf = j;
        }
        DisplayMetrics zzl = zzl(context);
        int i = zzl.widthPixels * zzl.heightPixels;
        if (view != null) {
            int min = Math.min(view.getWidth(), zzl.widthPixels) * Math.min(view.getHeight(), zzl.heightPixels);
            if (min + min >= i || (min == 0 && zzm(view))) {
                this.zze = this.zzc;
                return;
            }
        }
        this.zze = -1;
    }
}
