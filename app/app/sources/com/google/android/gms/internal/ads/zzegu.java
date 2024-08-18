package com.google.android.gms.internal.ads;

import android.view.View;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final /* synthetic */ class zzegu implements Runnable {
    public final /* synthetic */ zzfou zza;
    public final /* synthetic */ View zzb;

    public /* synthetic */ zzegu(zzfou zzfou, View view) {
        this.zza = zzfou;
        this.zzb = view;
    }

    public final void run() {
        this.zza.zze(this.zzb, zzfoq.NOT_VISIBLE, "Ad overlay");
    }
}
