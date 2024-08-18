package com.google.android.gms.internal.ads;

import android.view.ViewGroup;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final /* synthetic */ class zzdmq implements Runnable {
    public final /* synthetic */ zzdmt zza;
    public final /* synthetic */ ViewGroup zzb;

    public /* synthetic */ zzdmq(zzdmt zzdmt, ViewGroup viewGroup) {
        this.zza = zzdmt;
        this.zzb = viewGroup;
    }

    public final void run() {
        this.zza.zza(this.zzb);
    }
}
