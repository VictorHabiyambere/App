package com.google.android.gms.ads.internal.overlay;

import android.view.View;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
final class zzf implements View.OnClickListener {
    final /* synthetic */ zzm zza;

    zzf(zzm zzm) {
        this.zza = zzm;
    }

    public final void onClick(View view) {
        zzm zzm = this.zza;
        zzm.zzn = 2;
        zzm.zzb.finish();
    }
}
