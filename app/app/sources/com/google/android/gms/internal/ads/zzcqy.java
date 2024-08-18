package com.google.android.gms.internal.ads;

import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final /* synthetic */ class zzcqy implements Runnable {
    public final /* synthetic */ zzchd zza;
    public final /* synthetic */ JSONObject zzb;

    public /* synthetic */ zzcqy(zzchd zzchd, JSONObject jSONObject) {
        this.zza = zzchd;
        this.zzb = jSONObject;
    }

    public final void run() {
        this.zza.zzl("AFMA_updateActiveView", this.zzb);
    }
}
