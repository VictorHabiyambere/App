package com.google.android.gms.internal.ads;

import java.io.InputStream;
import java.io.InputStreamReader;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final /* synthetic */ class zzecm implements zzfkw {
    public final /* synthetic */ JSONObject zza;
    public final /* synthetic */ zzbxx zzb;

    public /* synthetic */ zzecm(JSONObject jSONObject, zzbxx zzbxx) {
        this.zza = jSONObject;
        this.zzb = zzbxx;
    }

    public final Object zza(Object obj) {
        return new zzedp(zzeed.zza(new InputStreamReader((InputStream) obj)), this.zza, this.zzb);
    }
}
