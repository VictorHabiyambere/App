package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.overlay.zzm;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
final class zzblg implements zzblp {
    zzblg() {
    }

    public final /* bridge */ /* synthetic */ void zza(Object obj, Map map) {
        zzchd zzchd = (zzchd) obj;
        if (zzchd.zzJ() != null) {
            zzchd.zzJ().zza();
        }
        zzm zzL = zzchd.zzL();
        if (zzL != null) {
            zzL.zzb();
            return;
        }
        zzm zzM = zzchd.zzM();
        if (zzM != null) {
            zzM.zzb();
        } else {
            com.google.android.gms.ads.internal.util.client.zzm.zzj("A GMSG tried to close something that wasn't an overlay.");
        }
    }
}
