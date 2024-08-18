package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.google.android.gms.ads.internal.util.client.zzm;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzbmh implements zzblp {
    private final zzbmg zza;

    public zzbmh(zzbmg zzbmg) {
        this.zza = zzbmg;
    }

    public static void zzb(zzchd zzchd, zzbmg zzbmg) {
        zzchd.zzag("/reward", new zzbmh(zzbmg));
    }

    public final void zza(Object obj, Map map) {
        String str = (String) map.get("action");
        if ("grant".equals(str)) {
            zzbyt zzbyt = null;
            try {
                int parseInt = Integer.parseInt((String) map.get("amount"));
                String str2 = (String) map.get("type");
                if (!TextUtils.isEmpty(str2)) {
                    zzbyt = new zzbyt(str2, parseInt);
                }
            } catch (NumberFormatException e) {
                zzm.zzk("Unable to parse reward amount.", e);
            }
            this.zza.zza(zzbyt);
        } else if ("video_start".equals(str)) {
            this.zza.zzc();
        } else if ("video_complete".equals(str)) {
            this.zza.zzb();
        }
    }
}
