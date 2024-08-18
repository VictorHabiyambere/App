package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.ads.internal.util.zzca;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final /* synthetic */ class zzbks implements zzblp {
    public final void zza(Object obj, Map map) {
        zzcik zzcik = (zzcik) obj;
        zzblp zzblp = zzblo.zza;
        String str = (String) map.get("u");
        if (str == null) {
            zzm.zzj("URL missing from httpTrack GMSG.");
        } else {
            new zzca(zzcik.getContext(), ((zzcir) zzcik).zzn().afmaVersion, str).zzb();
        }
    }
}
