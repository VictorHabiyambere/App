package com.google.android.gms.internal.ads;

import android.view.View;
import com.google.android.gms.ads.internal.client.zzba;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final /* synthetic */ class zzego implements Runnable {
    public final /* synthetic */ zzfoj zza;
    public final /* synthetic */ View zzb;

    public /* synthetic */ zzego(zzfoj zzfoj, View view) {
        this.zza = zzfoj;
        this.zzb = view;
    }

    public final void run() {
        if (((Boolean) zzba.zzc().zza(zzbep.zzeZ)).booleanValue() && zzfoh.zzb()) {
            this.zza.zzb(this.zzb, zzfoq.NOT_VISIBLE, "Ad overlay");
        }
    }
}
