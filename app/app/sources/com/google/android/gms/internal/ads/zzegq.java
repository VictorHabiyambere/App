package com.google.android.gms.internal.ads;

import android.view.View;
import com.google.android.gms.ads.internal.client.zzba;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final /* synthetic */ class zzegq implements Runnable {
    public final /* synthetic */ zzfoj zza;
    public final /* synthetic */ View zzb;

    public /* synthetic */ zzegq(zzfoj zzfoj, View view) {
        this.zza = zzfoj;
        this.zzb = view;
    }

    public final void run() {
        if (((Boolean) zzba.zzc().zza(zzbep.zzeZ)).booleanValue() && zzfoh.zzb()) {
            this.zza.zzd(this.zzb);
        }
    }
}
