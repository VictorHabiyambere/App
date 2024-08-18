package com.google.android.gms.internal.ads;

import java.util.List;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final /* synthetic */ class zzdot implements zzfxu {
    public final /* synthetic */ zzdow zza;
    public final /* synthetic */ JSONObject zzb;

    public /* synthetic */ zzdot(zzdow zzdow, JSONObject jSONObject) {
        this.zza = zzdow;
        this.zzb = jSONObject;
    }

    public final Object apply(Object obj) {
        return this.zza.zza(this.zzb, (List) obj);
    }
}
