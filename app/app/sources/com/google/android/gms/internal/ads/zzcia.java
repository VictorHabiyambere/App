package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.google.android.gms.ads.internal.util.client.zzm;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
final class zzcia implements zzblp {
    final /* synthetic */ zzcic zza;

    zzcia(zzcic zzcic) {
        this.zza = zzcic;
    }

    public final /* bridge */ /* synthetic */ void zza(Object obj, Map map) {
        zzchd zzchd = (zzchd) obj;
        if (map != null) {
            String str = (String) map.get("height");
            if (!TextUtils.isEmpty(str)) {
                try {
                    int parseInt = Integer.parseInt(str);
                    synchronized (this.zza) {
                        zzcic zzcic = this.zza;
                        if (zzcic.zzI != parseInt) {
                            zzcic.zzI = parseInt;
                            this.zza.requestLayout();
                        }
                    }
                } catch (Exception e) {
                    zzm.zzk("Exception occurred while getting webview content height", e);
                }
            }
        }
    }
}
