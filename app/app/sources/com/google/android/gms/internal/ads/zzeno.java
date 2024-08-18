package com.google.android.gms.internal.ads;

import android.view.View;
import com.google.android.gms.ads.internal.zzg;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzeno implements zzg {
    private zzg zza;

    public final synchronized void zza(View view) {
        zzg zzg = this.zza;
        if (zzg != null) {
            zzg.zza(view);
        }
    }

    public final synchronized void zzb() {
        zzg zzg = this.zza;
        if (zzg != null) {
            zzg.zzb();
        }
    }

    public final synchronized void zzc() {
        zzg zzg = this.zza;
        if (zzg != null) {
            zzg.zzc();
        }
    }

    public final synchronized void zzd(zzg zzg) {
        this.zza = zzg;
    }
}
