package com.google.android.gms.internal.ads;

import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzcim extends zzcil {
    public zzcim(zzchd zzchd, zzbdm zzbdm, boolean z, zzegk zzegk) {
        super(zzchd, zzbdm, z, zzegk);
    }

    public final WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
        if (webResourceRequest == null || webResourceRequest.getUrl() == null) {
            return null;
        }
        return zzS(webView, webResourceRequest.getUrl().toString(), webResourceRequest.getRequestHeaders());
    }
}
