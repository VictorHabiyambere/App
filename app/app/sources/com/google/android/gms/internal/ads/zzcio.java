package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.util.client.zzm;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzcio {
    private static final Pattern zza = Pattern.compile("^\\uFEFF?\\s*(\\s*<!--([^-]|(?!-->))*-->)*\\s*<!DOCTYPE(\\s)+html(|(\\s)+[^>]*)>", 2);
    private static final Pattern zzb = Pattern.compile("^\\uFEFF?\\s*(\\s*<!--([^-]|(?!-->))*-->)*?\\s*<!DOCTYPE[^>]*>", 2);

    public static String zza(zzfgt zzfgt) {
        zzehc zzehc;
        if (!((Boolean) zzba.zzc().zza(zzbep.zzfc)).booleanValue() || !zzfgt.zzU || !zzfgt.zzW.zzb() || zzfgt.zzb == 4) {
            return null;
        }
        if (zzfgt.zzW.zzc() == 1) {
            zzehc = zzehc.VIDEO;
        } else {
            zzehc = zzehc.HTML_DISPLAY;
        }
        String str = zzfgt.zzam;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("creativeType", zzehc.toString());
            jSONObject.put("contentUrl", str);
            return "<script>Object.defineProperty(window,'GOOG_OMID_JAVASCRIPT_SESSION_SERVICE_ENV',{get:function(){return " + jSONObject.toString() + "}});</script>";
        } catch (JSONException e) {
            zzm.zzk("Unable to build OMID ENV JSON", e);
            return null;
        }
    }

    public static String zzb(String str, String... strArr) {
        String str2;
        StringBuilder sb = new StringBuilder();
        Matcher matcher = zza.matcher(str);
        if (matcher.find()) {
            int end = matcher.end();
            sb.append(str.substring(0, end));
            String str3 = strArr[0];
            if (str3 != null) {
                sb.append(str3);
            }
            sb.append(str.substring(end));
        } else {
            if (!zzb.matcher(str).find() && (str2 = strArr[0]) != null) {
                sb.append(str2);
            }
            sb.append(str);
        }
        return sb.toString();
    }
}
