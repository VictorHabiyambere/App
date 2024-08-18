package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzdsl implements zzdag {
    private final zzchd zza;

    zzdsl(zzchd zzchd) {
        this.zza = zzchd;
    }

    public final void zzdj(Context context) {
        zzchd zzchd = this.zza;
        if (zzchd != null) {
            zzchd.destroy();
        }
    }

    public final void zzdl(Context context) {
        zzchd zzchd = this.zza;
        if (zzchd != null) {
            zzchd.onPause();
        }
    }

    public final void zzdm(Context context) {
        zzchd zzchd = this.zza;
        if (zzchd != null) {
            zzchd.onResume();
        }
    }
}
