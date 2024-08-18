package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final /* synthetic */ class zzdqg implements zzgfa {
    public final /* synthetic */ zzdqs zza;
    public final /* synthetic */ String zzb;
    public final /* synthetic */ JSONObject zzc;

    public /* synthetic */ zzdqg(zzdqs zzdqs, String str, JSONObject jSONObject) {
        this.zza = zzdqs;
        this.zzb = str;
        this.zzc = jSONObject;
    }

    public final ListenableFuture zza(Object obj) {
        return this.zza.zzf(this.zzb, this.zzc, (zzchd) obj);
    }
}
