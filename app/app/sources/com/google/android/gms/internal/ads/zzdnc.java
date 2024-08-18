package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final /* synthetic */ class zzdnc implements zzblp {
    public final /* synthetic */ zzdnf zza;

    public /* synthetic */ zzdnc(zzdnf zzdnf) {
        this.zza = zzdnf;
    }

    public final void zza(Object obj, Map map) {
        zzchd zzchd = (zzchd) obj;
        zzchd.zzN().zzB(new zzdmz(this.zza, map));
        String str = (String) map.get("overlayHtml");
        String str2 = (String) map.get("baseUrl");
        if (TextUtils.isEmpty(str2)) {
            zzchd.loadData(str, "text/html", "UTF-8");
        } else {
            zzchd.loadDataWithBaseURL(str2, str, "text/html", "UTF-8", (String) null);
        }
    }
}
