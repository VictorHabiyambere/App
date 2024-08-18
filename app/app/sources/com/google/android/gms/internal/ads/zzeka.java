package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Callable;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final /* synthetic */ class zzeka implements Callable {
    public final /* synthetic */ zzekf zza;
    public final /* synthetic */ ListenableFuture zzb;
    public final /* synthetic */ ListenableFuture zzc;
    public final /* synthetic */ zzfhf zzd;
    public final /* synthetic */ zzfgt zze;
    public final /* synthetic */ JSONObject zzf;

    public /* synthetic */ zzeka(zzekf zzekf, ListenableFuture listenableFuture, ListenableFuture listenableFuture2, zzfhf zzfhf, zzfgt zzfgt, JSONObject jSONObject) {
        this.zza = zzekf;
        this.zzb = listenableFuture;
        this.zzc = listenableFuture2;
        this.zzd = zzfhf;
        this.zze = zzfgt;
        this.zzf = jSONObject;
    }

    public final Object call() {
        return this.zza.zzc(this.zzb, this.zzc, this.zzd, this.zze, this.zzf);
    }
}
