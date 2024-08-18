package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.client.zzm;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzcpt implements zzdag {
    private final zzfim zza;

    public zzcpt(zzfim zzfim) {
        this.zza = zzfim;
    }

    public final void zzdj(Context context) {
        try {
            this.zza.zzg();
        } catch (zzfhv e) {
            zzm.zzk("Cannot invoke onDestroy for the mediation adapter.", e);
        }
    }

    public final void zzdl(Context context) {
        try {
            this.zza.zzt();
        } catch (zzfhv e) {
            zzm.zzk("Cannot invoke onPause for the mediation adapter.", e);
        }
    }

    public final void zzdm(Context context) {
        try {
            this.zza.zzu();
            if (context != null) {
                this.zza.zzs(context);
            }
        } catch (zzfhv e) {
            zzm.zzk("Cannot invoke onResume for the mediation adapter.", e);
        }
    }
}
