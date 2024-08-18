package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.google.android.gms.common.internal.ImagesContract;
import java.util.Arrays;
import java.util.List;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzbxx {
    private final List zza;
    private final String zzb;
    private final String zzc;
    private final String zzd;
    private final boolean zze;
    private final boolean zzf;
    private final String zzg;
    private final String zzh;
    private final String zzi;
    private final int zzj;
    private final JSONObject zzk;
    private final String zzl;
    private final String zzm;
    private final long zzn;
    private final long zzo;

    public zzbxx(JSONObject jSONObject) {
        List list;
        this.zzi = jSONObject.optString(ImagesContract.URL);
        this.zzb = jSONObject.optString("base_uri");
        this.zzc = jSONObject.optString("post_parameters");
        this.zze = zzm(jSONObject.optString("drt_include"));
        this.zzf = zzm(jSONObject.optString("cookies_include", "true"));
        this.zzg = jSONObject.optString("request_id");
        this.zzd = jSONObject.optString("type");
        String optString = jSONObject.optString("errors");
        if (optString == null) {
            list = null;
        } else {
            list = Arrays.asList(optString.split(","));
        }
        this.zza = list;
        this.zzj = jSONObject.optInt("valid", 0) == 1 ? -2 : 1;
        this.zzh = jSONObject.optString("fetched_ad");
        jSONObject.optBoolean("render_test_ad_label");
        JSONObject optJSONObject = jSONObject.optJSONObject("preprocessor_flags");
        this.zzk = optJSONObject == null ? new JSONObject() : optJSONObject;
        this.zzl = jSONObject.optString("analytics_query_ad_event_id");
        jSONObject.optBoolean("is_analytics_logging_enabled");
        this.zzm = jSONObject.optString("pool_key");
        this.zzn = zzl(jSONObject.optString("start_time")).longValue();
        this.zzo = zzl(jSONObject.optString("end_time")).longValue();
    }

    private static Long zzl(String str) {
        if (TextUtils.isEmpty(str)) {
            return -1L;
        }
        try {
            return Long.valueOf(str);
        } catch (NumberFormatException e) {
            return -1L;
        }
    }

    private static boolean zzm(String str) {
        if (str == null) {
            return false;
        }
        if (!str.equals("1")) {
            return str.equals("true");
        }
        return true;
    }

    public final int zza() {
        return this.zzj;
    }

    public final long zzb() {
        return this.zzo;
    }

    public final long zzc() {
        return this.zzn;
    }

    public final String zzd() {
        return this.zzb;
    }

    public final String zze() {
        return this.zzm;
    }

    public final String zzf() {
        return this.zzc;
    }

    public final String zzg() {
        return this.zzi;
    }

    public final List zzh() {
        return this.zza;
    }

    public final JSONObject zzi() {
        return this.zzk;
    }

    public final boolean zzj() {
        return this.zzf;
    }

    public final boolean zzk() {
        return this.zze;
    }
}
