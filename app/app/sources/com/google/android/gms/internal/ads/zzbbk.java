package com.google.android.gms.internal.ads;

import android.webkit.ValueCallback;
import android.webkit.WebView;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
final class zzbbk implements Runnable {
    final ValueCallback zza = new zzbbj(this, this.zzb, this.zzc, this.zzd);
    final /* synthetic */ zzbbc zzb;
    final /* synthetic */ WebView zzc;
    final /* synthetic */ boolean zzd;
    final /* synthetic */ zzbbm zze;

    zzbbk(zzbbm zzbbm, zzbbc zzbbc, WebView webView, boolean z) {
        this.zzb = zzbbc;
        this.zzc = webView;
        this.zzd = z;
        this.zze = zzbbm;
    }

    public final void run() {
        if (this.zzc.getSettings().getJavaScriptEnabled()) {
            try {
                this.zzc.evaluateJavascript("(function() { return  {text:document.body.innerText}})();", this.zza);
            } catch (Throwable th) {
                this.zza.onReceiveValue("");
            }
        }
    }
}
