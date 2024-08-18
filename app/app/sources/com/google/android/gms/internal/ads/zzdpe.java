package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final /* synthetic */ class zzdpe implements zzgfa {
    public final /* synthetic */ zzdpo zza;
    public final /* synthetic */ JSONObject zzb;

    public /* synthetic */ zzdpe(zzdpo zzdpo, JSONObject jSONObject) {
        this.zza = zzdpo;
        this.zzb = jSONObject;
    }

    public final ListenableFuture zza(Object obj) {
        return this.zza.zzc(this.zzb, (zzchd) obj);
    }
}
