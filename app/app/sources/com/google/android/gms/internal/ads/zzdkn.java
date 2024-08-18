package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.google.android.gms.ads.internal.client.zzba;
import java.lang.ref.WeakReference;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
final class zzdkn implements zzblp {
    private final WeakReference zza;

    /* synthetic */ zzdkn(zzdkq zzdkq, zzdkm zzdkm) {
        this.zza = new WeakReference(zzdkq);
    }

    public final void zza(Object obj, Map map) {
        zzdkq zzdkq = (zzdkq) this.zza.get();
        if (zzdkq != null) {
            zzdkq.zzh.onAdClicked();
            if (((Boolean) zzba.zzc().zza(zzbep.zzkM)).booleanValue()) {
                zzdkq.zzi.zzdG();
                if (!TextUtils.isEmpty((CharSequence) map.get("sccg"))) {
                    zzdkq.zzi.zzdf();
                }
            }
        }
    }
}
