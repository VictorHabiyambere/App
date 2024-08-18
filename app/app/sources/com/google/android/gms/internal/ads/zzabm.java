package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.view.Surface;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzabm extends Surface {
    private static int zzb;
    private static boolean zzc;
    public final boolean zza;
    private final zzabk zzd;
    private boolean zze;

    /* synthetic */ zzabm(zzabk zzabk, SurfaceTexture surfaceTexture, boolean z, zzabl zzabl) {
        super(surfaceTexture);
        this.zzd = zzabk;
        this.zza = z;
    }

    public static zzabm zza(Context context, boolean z) {
        int i = 0;
        boolean z2 = true;
        if (z && !zzb(context)) {
            z2 = false;
        }
        zzeq.zzf(z2);
        zzabk zzabk = new zzabk();
        if (z) {
            i = zzb;
        }
        return zzabk.zza(i);
    }

    public static synchronized boolean zzb(Context context) {
        int i;
        synchronized (zzabm.class) {
            if (!zzc) {
                zzb = zzez.zzb(context) ? zzez.zzc() ? 1 : 2 : 0;
                zzc = true;
            }
            i = zzb;
        }
        return i != 0;
    }

    public final void release() {
        super.release();
        synchronized (this.zzd) {
            if (!this.zze) {
                this.zzd.zzb();
                this.zze = true;
            }
        }
    }
}
