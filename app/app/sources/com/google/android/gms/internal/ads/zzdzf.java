package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final /* synthetic */ class zzdzf implements Callable {
    public final /* synthetic */ zzdzi zza;
    public final /* synthetic */ zzbxu zzb;

    public /* synthetic */ zzdzf(zzdzi zzdzi, zzbxu zzbxu) {
        this.zza = zzdzi;
        this.zzb = zzbxu;
    }

    public final Object call() {
        return this.zza.zza(this.zzb);
    }
}
