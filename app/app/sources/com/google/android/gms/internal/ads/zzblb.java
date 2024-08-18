package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzu;
import java.io.IOException;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
final class zzblb implements zzblp {
    zzblb() {
    }

    public final /* bridge */ /* synthetic */ void zza(Object obj, Map map) {
        zzchd zzchd = (zzchd) obj;
        try {
            zzfvg.zzj(zzchd.getContext()).zzk();
            zzfvh.zzi(zzchd.getContext()).zzj();
        } catch (IOException e) {
            zzu.zzo().zzw(e, "DefaultGmsgHandlers.ResetPaid");
        }
    }
}
