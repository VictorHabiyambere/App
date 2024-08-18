package com.google.android.gms.internal.ads;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.google.android.gms.ads.internal.zzu;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
final class zzble implements zzblp {
    zzble() {
    }

    public final /* bridge */ /* synthetic */ void zza(Object obj, Map map) {
        zzchd zzchd = (zzchd) obj;
        try {
            JSONObject jSONObject = new JSONObject((String) map.get("args"));
            Iterator<String> keys = jSONObject.keys();
            SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(zzchd.getContext()).edit();
            while (keys.hasNext()) {
                String next = keys.next();
                Object obj2 = jSONObject.get(next);
                if (obj2 instanceof Integer) {
                    edit.putInt(next, ((Integer) obj2).intValue());
                } else if (obj2 instanceof Long) {
                    edit.putLong(next, ((Long) obj2).longValue());
                } else if (obj2 instanceof Double) {
                    edit.putFloat(next, ((Double) obj2).floatValue());
                } else if (obj2 instanceof Float) {
                    edit.putFloat(next, ((Float) obj2).floatValue());
                } else if (obj2 instanceof Boolean) {
                    edit.putBoolean(next, ((Boolean) obj2).booleanValue());
                } else if (obj2 instanceof String) {
                    edit.putString(next, (String) obj2);
                }
            }
            edit.apply();
        } catch (JSONException e) {
            zzu.zzo().zzw(e, "GMSG write local storage KV pairs handler");
        }
    }
}
