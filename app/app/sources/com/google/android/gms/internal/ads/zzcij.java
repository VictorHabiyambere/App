package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.webkit.JavascriptInterface;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.util.zzt;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzcij {
    private final zzcik zza;
    private final zzcii zzb;

    public zzcij(zzcik zzcik, zzcii zzcii) {
        this.zzb = zzcii;
        this.zza = zzcik;
    }

    /* JADX WARNING: type inference failed for: r0v1, types: [com.google.android.gms.internal.ads.zzcik, com.google.android.gms.internal.ads.zzciq] */
    @JavascriptInterface
    public String getClickSignals(String clickString) {
        if (TextUtils.isEmpty(clickString)) {
            zze.zza("Click string is empty, not proceeding.");
            return "";
        }
        ? r0 = this.zza;
        zzaxd zzI = r0.zzI();
        if (zzI == null) {
            zze.zza("Signal utils is empty, ignoring.");
            return "";
        }
        zzawz zzc = zzI.zzc();
        if (zzc == null) {
            zze.zza("Signals object is empty, ignoring.");
            return "";
        } else if (r0.getContext() == null) {
            zze.zza("Context is null, ignoring.");
            return "";
        } else {
            zzcik zzcik = this.zza;
            return zzc.zzf(zzcik.getContext(), clickString, (View) zzcik, zzcik.zzi());
        }
    }

    /* JADX WARNING: type inference failed for: r0v0, types: [com.google.android.gms.internal.ads.zzcik, com.google.android.gms.internal.ads.zzciq] */
    @JavascriptInterface
    public String getViewSignals() {
        ? r0 = this.zza;
        zzaxd zzI = r0.zzI();
        if (zzI == null) {
            zze.zza("Signal utils is empty, ignoring.");
            return "";
        }
        zzawz zzc = zzI.zzc();
        if (zzc == null) {
            zze.zza("Signals object is empty, ignoring.");
            return "";
        } else if (r0.getContext() == null) {
            zze.zza("Context is null, ignoring.");
            return "";
        } else {
            zzcik zzcik = this.zza;
            return zzc.zzh(zzcik.getContext(), (View) zzcik, zzcik.zzi());
        }
    }

    @JavascriptInterface
    public void notify(String url) {
        if (TextUtils.isEmpty(url)) {
            zzm.zzj("URL is empty, ignoring message");
        } else {
            zzt.zza.post(new zzcih(this, url));
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zza(String str) {
        Uri parse = Uri.parse(str);
        zzchl zzaO = ((zzcic) this.zzb.zza).zzaO();
        if (zzaO == null) {
            zzm.zzg("Unable to pass GMSG, no AdWebViewClient for AdWebView!");
        } else {
            zzaO.zzj(parse);
        }
    }
}
