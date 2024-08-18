package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final /* synthetic */ class zzeaa implements Callable {
    public final /* synthetic */ zzeac zza;
    public final /* synthetic */ zzbxu zzb;

    public /* synthetic */ zzeaa(zzeac zzeac, zzbxu zzbxu) {
        this.zza = zzeac;
        this.zzb = zzbxu;
    }

    public final Object call() {
        return this.zza.zza(this.zzb);
    }
}
