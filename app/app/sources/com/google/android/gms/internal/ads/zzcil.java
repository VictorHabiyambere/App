package com.google.android.gms.internal.ads;

import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.ads.internal.util.zzt;
import com.google.android.gms.ads.internal.zzu;
import java.io.File;
import java.util.Collections;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public class zzcil extends zzchl {
    public zzcil(zzchd zzchd, zzbdm zzbdm, boolean z, zzegk zzegk) {
        super(zzchd, zzbdm, z, new zzbui(zzchd, zzchd.zzE(), new zzbdx(zzchd.getContext())), (zzbud) null, zzegk);
    }

    /* access modifiers changed from: protected */
    public final WebResourceResponse zzS(WebView webView, String str, Map map) {
        String str2;
        if (!(webView instanceof zzchd)) {
            zzm.zzj("Tried to intercept request from a WebView that wasn't an AdWebView.");
            return null;
        }
        zzchd zzchd = (zzchd) webView;
        zzcaf zzcaf = this.zza;
        if (zzcaf != null) {
            zzcaf.zzd(str, map, 1);
        }
        zzftu.zza();
        zzftz zzftz = zzftz.zza;
        if (!"mraid.js".equalsIgnoreCase(new File(str).getName())) {
            if (map == null) {
                map = Collections.emptyMap();
            }
            return super.zzc(str, map);
        }
        if (zzchd.zzN() != null) {
            zzchd.zzN().zzF();
        }
        if (zzchd.zzO().zzi()) {
            str2 = (String) zzba.zzc().zza(zzbep.zzN);
        } else if (zzchd.zzaF()) {
            str2 = (String) zzba.zzc().zza(zzbep.zzM);
        } else {
            str2 = (String) zzba.zzc().zza(zzbep.zzL);
        }
        zzu.zzp();
        return zzt.zzx(zzchd.getContext(), zzchd.zzn().afmaVersion, str2);
    }
}
