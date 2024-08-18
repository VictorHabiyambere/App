package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final /* synthetic */ class zzekb implements zzgfa {
    public final /* synthetic */ zzekf zza;
    public final /* synthetic */ zzdqs zzb;

    public /* synthetic */ zzekb(zzekf zzekf, zzdqs zzdqs) {
        this.zza = zzekf;
        this.zzb = zzdqs;
    }

    public final ListenableFuture zza(Object obj) {
        return this.zza.zzd(this.zzb, (JSONObject) obj);
    }
}
