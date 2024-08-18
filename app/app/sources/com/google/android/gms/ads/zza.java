package com.google.android.gms.ads;

import com.google.android.gms.ads.internal.client.zzdx;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.2.0 */
public final /* synthetic */ class zza implements Runnable {
    public final /* synthetic */ AdLoader zza;
    public final /* synthetic */ zzdx zzb;

    public /* synthetic */ zza(AdLoader adLoader, zzdx zzdx) {
        this.zza = adLoader;
        this.zzb = zzdx;
    }

    public final void run() {
        this.zza.zza(this.zzb);
    }
}
