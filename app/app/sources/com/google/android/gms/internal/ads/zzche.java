package com.google.android.gms.internal.ads;

import android.view.View;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final /* synthetic */ class zzche implements Runnable {
    public final /* synthetic */ zzchl zza;
    public final /* synthetic */ View zzb;
    public final /* synthetic */ zzcaf zzc;
    public final /* synthetic */ int zzd;

    public /* synthetic */ zzche(zzchl zzchl, View view, zzcaf zzcaf, int i) {
        this.zza = zzchl;
        this.zzb = view;
        this.zzc = zzcaf;
        this.zzd = i;
    }

    public final void run() {
        this.zza.zzp(this.zzb, this.zzc, this.zzd);
    }
}
