package com.google.android.gms.ads.internal.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.ads.internal.zzu;
import com.google.android.gms.internal.ads.zzbep;
import com.google.android.gms.internal.ads.zzfvg;
import com.google.android.gms.internal.ads.zzfvh;
import com.google.android.gms.internal.ads.zzfxr;
import com.google.android.gms.internal.ads.zzfyt;
import java.io.IOException;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzad {
    public static Bundle zza(Context context, String str, SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        if (TextUtils.isEmpty(str)) {
            return Bundle.EMPTY;
        }
        PreferenceManager.getDefaultSharedPreferences(context).registerOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
        return zzb(context, str);
    }

    public static Bundle zzb(Context context, String str) {
        JSONArray jSONArray;
        int i;
        Object obj;
        SharedPreferences sharedPreferences;
        String str2;
        if (TextUtils.isEmpty(str)) {
            jSONArray = null;
        } else {
            try {
                jSONArray = new JSONArray(str);
            } catch (JSONException e) {
                zzm.zzf("JSON parsing error", e);
                jSONArray = null;
            }
        }
        if (jSONArray == null) {
            return Bundle.EMPTY;
        }
        Bundle bundle = new Bundle();
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            JSONObject optJSONObject = jSONArray.optJSONObject(i2);
            String optString = optJSONObject.optString("bk");
            String optString2 = optJSONObject.optString("sk");
            switch (optJSONObject.optInt("type", -1)) {
                case 0:
                    i = 1;
                    break;
                case 1:
                    i = 2;
                    break;
                case 2:
                    i = 3;
                    break;
                default:
                    i = 0;
                    break;
            }
            if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2) && i != 0) {
                List zzf = zzfyt.zzc(zzfxr.zzc('/')).zzf(optString2);
                if (zzf.size() > 2) {
                    obj = null;
                } else if (zzf.isEmpty()) {
                    obj = null;
                } else {
                    if (zzf.size() == 1) {
                        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
                        str2 = (String) zzf.get(0);
                    } else {
                        sharedPreferences = context.getSharedPreferences((String) zzf.get(0), 0);
                        str2 = (String) zzf.get(1);
                    }
                    obj = sharedPreferences.getAll().get(str2);
                }
                if (obj != null) {
                    switch (i - 1) {
                        case 0:
                            if (!(obj instanceof String)) {
                                break;
                            } else {
                                bundle.putString(optString, (String) obj);
                                break;
                            }
                        case 1:
                            if (!(obj instanceof Integer)) {
                                if (!(obj instanceof Long)) {
                                    if (!(obj instanceof Float)) {
                                        break;
                                    } else {
                                        bundle.putFloat(optString, ((Float) obj).floatValue());
                                        break;
                                    }
                                } else {
                                    bundle.putLong(optString, ((Long) obj).longValue());
                                    break;
                                }
                            } else {
                                bundle.putInt(optString, ((Integer) obj).intValue());
                                break;
                            }
                        default:
                            if (!(obj instanceof Boolean)) {
                                break;
                            } else {
                                bundle.putBoolean(optString, ((Boolean) obj).booleanValue());
                                break;
                            }
                    }
                }
            }
        }
        return bundle;
    }

    public static void zzc(Context context) {
        if (((Boolean) zzba.zzc().zza(zzbep.zzgs)).booleanValue() && context != null) {
            context.deleteDatabase("OfflineUpload.db");
        }
        try {
            zzfvg zzj = zzfvg.zzj(context);
            zzfvh zzi = zzfvh.zzi(context);
            zzj.zzk();
            zzj.zzl();
            zzi.zzj();
            if (((Boolean) zzba.zzc().zza(zzbep.zzcX)).booleanValue()) {
                zzi.zzk();
            }
            if (((Boolean) zzba.zzc().zza(zzbep.zzcY)).booleanValue()) {
                zzi.zzl();
            }
        } catch (IOException e) {
            zzu.zzo().zzw(e, "clearStorageOnIdlessMode");
        }
    }
}
