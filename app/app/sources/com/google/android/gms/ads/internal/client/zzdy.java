package com.google.android.gms.ads.internal.client;

import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.2.0 */
public final /* synthetic */ class zzdy implements Runnable {
    public final /* synthetic */ zzea zza;
    public final /* synthetic */ IObjectWrapper zzb;

    public /* synthetic */ zzdy(zzea zzea, IObjectWrapper iObjectWrapper) {
        this.zza = zzea;
        this.zzb = iObjectWrapper;
    }

    public final void run() {
        this.zza.zzl(this.zzb);
    }
}
