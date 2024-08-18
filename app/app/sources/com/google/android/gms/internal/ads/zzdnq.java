package com.google.android.gms.internal.ads;

import androidx.collection.ArrayMap;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final /* synthetic */ class zzdnq implements Runnable {
    public final /* synthetic */ zzchd zza;

    public /* synthetic */ zzdnq(zzchd zzchd) {
        this.zza = zzchd;
    }

    public final void run() {
        this.zza.zzd("onSdkImpression", new ArrayMap());
    }
}
