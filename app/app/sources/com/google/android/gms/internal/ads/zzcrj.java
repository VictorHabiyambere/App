package com.google.android.gms.internal.ads;

import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final /* synthetic */ class zzcrj implements Runnable {
    public final /* synthetic */ zzcrk zza;
    public final /* synthetic */ JSONObject zzb;

    public /* synthetic */ zzcrj(zzcrk zzcrk, JSONObject jSONObject) {
        this.zza = zzcrk;
        this.zzb = jSONObject;
    }

    public final void run() {
        this.zza.zzd(this.zzb);
    }
}
