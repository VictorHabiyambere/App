package com.google.android.gms.internal.ads;

import android.webkit.ValueCallback;
import android.webkit.WebView;
import com.google.android.gms.ads.h5.OnH5AdsEventListener;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.2.0 */
public final /* synthetic */ class zzbmw implements OnH5AdsEventListener {
    public final /* synthetic */ WebView zza;

    public /* synthetic */ zzbmw(WebView webView) {
        this.zza = webView;
    }

    public final void onH5AdsEvent(String str) {
        int i = zzbmx.zza;
        this.zza.evaluateJavascript(str, (ValueCallback) null);
    }
}
