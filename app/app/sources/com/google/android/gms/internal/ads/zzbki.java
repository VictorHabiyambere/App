package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.ads.internal.zzu;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.firebase.database.core.ServerValues;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzbki implements zzblp {
    public final /* bridge */ /* synthetic */ void zza(Object obj, Map map) {
        zzchd zzchd = (zzchd) obj;
        String str = (String) map.get("action");
        if ("tick".equals(str)) {
            String str2 = (String) map.get("label");
            String str3 = (String) map.get("start_label");
            String str4 = (String) map.get(ServerValues.NAME_OP_TIMESTAMP);
            if (TextUtils.isEmpty(str2)) {
                zzm.zzj("No label given for CSI tick.");
            } else if (TextUtils.isEmpty(str4)) {
                zzm.zzj("No timestamp given for CSI tick.");
            } else {
                try {
                    long elapsedRealtime = zzu.zzB().elapsedRealtime() + (Long.parseLong(str4) - zzu.zzB().currentTimeMillis());
                    if (true == TextUtils.isEmpty(str3)) {
                        str3 = "native:view_load";
                    }
                    zzchd.zzm().zzc(str2, str3, elapsedRealtime);
                } catch (NumberFormatException e) {
                    zzm.zzk("Malformed timestamp for CSI tick.", e);
                }
            }
        } else if ("experiment".equals(str)) {
            String str5 = (String) map.get(AppMeasurementSdk.ConditionalUserProperty.VALUE);
            if (TextUtils.isEmpty(str5)) {
                zzm.zzj("No value given for CSI experiment.");
            } else {
                zzchd.zzm().zza().zzd("e", str5);
            }
        } else if ("extra".equals(str)) {
            String str6 = (String) map.get("name");
            String str7 = (String) map.get(AppMeasurementSdk.ConditionalUserProperty.VALUE);
            if (TextUtils.isEmpty(str7)) {
                zzm.zzj("No value given for CSI extra.");
            } else if (TextUtils.isEmpty(str6)) {
                zzm.zzj("No name given for CSI extra.");
            } else {
                zzchd.zzm().zza().zzd(str6, str7);
            }
        }
    }
}
