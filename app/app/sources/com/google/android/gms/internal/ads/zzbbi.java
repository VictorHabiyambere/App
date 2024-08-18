package com.google.android.gms.internal.ads;

import android.view.View;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
final class zzbbi implements Runnable {
    final /* synthetic */ View zza;
    final /* synthetic */ zzbbm zzb;

    zzbbi(zzbbm zzbbm, View view) {
        this.zza = view;
        this.zzb = zzbbm;
    }

    public final void run() {
        this.zzb.zzc(this.zza);
    }
}
