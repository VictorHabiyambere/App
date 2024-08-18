package com.google.android.gms.internal.ads;

import android.webkit.ValueCallback;
import android.webkit.WebView;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final /* synthetic */ class zzbbj implements ValueCallback {
    public final /* synthetic */ zzbbk zza;
    public final /* synthetic */ zzbbc zzb;
    public final /* synthetic */ WebView zzc;
    public final /* synthetic */ boolean zzd;

    public /* synthetic */ zzbbj(zzbbk zzbbk, zzbbc zzbbc, WebView webView, boolean z) {
        this.zza = zzbbk;
        this.zzb = zzbbc;
        this.zzc = webView;
        this.zzd = z;
    }

    public final void onReceiveValue(Object obj) {
        this.zza.zze.zzd(this.zzb, this.zzc, (String) obj, this.zzd);
    }
}
