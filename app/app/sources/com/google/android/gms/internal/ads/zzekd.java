package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import org.json.JSONArray;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final /* synthetic */ class zzekd implements zzgfa {
    public final /* synthetic */ zzekf zza;
    public final /* synthetic */ zzfhf zzb;
    public final /* synthetic */ zzfgt zzc;

    public /* synthetic */ zzekd(zzekf zzekf, zzfhf zzfhf, zzfgt zzfgt) {
        this.zza = zzekf;
        this.zzb = zzfhf;
        this.zzc = zzfgt;
    }

    public final ListenableFuture zza(Object obj) {
        return this.zza.zzf(this.zzb, this.zzc, (JSONArray) obj);
    }
}
