package com.google.android.gms.ads.nonagon.signalgeneration;

import android.webkit.ValueCallback;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final /* synthetic */ class zzbc implements Runnable {
    public final /* synthetic */ zzbe zza;
    public final /* synthetic */ String zzb;

    public /* synthetic */ zzbc(zzbe zzbe, String str) {
        this.zza = zzbe;
        this.zzb = str;
    }

    public final void run() {
        this.zza.zzb.zzb.evaluateJavascript(this.zzb, (ValueCallback) null);
    }
}
