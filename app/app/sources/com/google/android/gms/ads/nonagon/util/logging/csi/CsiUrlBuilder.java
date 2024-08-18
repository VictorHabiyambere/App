package com.google.android.gms.ads.nonagon.util.logging.csi;

import android.net.Uri;
import com.google.android.gms.internal.ads.zzbge;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public class CsiUrlBuilder {
    private final String zza = ((String) zzbge.zzb.zze());

    public String generateUrl(Map<String, String> params) {
        Uri.Builder buildUpon = Uri.parse(this.zza).buildUpon();
        for (Map.Entry next : params.entrySet()) {
            buildUpon.appendQueryParameter((String) next.getKey(), (String) next.getValue());
        }
        return buildUpon.build().toString();
    }
}
