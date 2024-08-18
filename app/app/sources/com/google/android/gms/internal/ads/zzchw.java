package com.google.android.gms.internal.ads;

import android.webkit.ValueCallback;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final /* synthetic */ class zzchw implements Runnable {
    public final /* synthetic */ zzcic zza;
    public final /* synthetic */ String zzb;
    public final /* synthetic */ ValueCallback zzc;

    public /* synthetic */ zzchw(zzcic zzcic, String str, ValueCallback valueCallback) {
        this.zza = zzcic;
        this.zzb = str;
        this.zzc = valueCallback;
    }

    public final void run() {
        this.zza.zzaU(this.zzb, this.zzc);
    }
}
