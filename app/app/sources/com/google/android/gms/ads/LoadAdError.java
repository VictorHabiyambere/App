package com.google.android.gms.ads;

import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.2.0 */
public final class LoadAdError extends AdError {
    private final ResponseInfo zza;

    public LoadAdError(int code, String message, String domain, AdError cause, ResponseInfo responseInfo) {
        super(code, message, domain, cause);
        this.zza = responseInfo;
    }

    public ResponseInfo getResponseInfo() {
        return this.zza;
    }

    public String toString() {
        try {
            return zzb().toString(2);
        } catch (JSONException e) {
            return "Error forming toString output.";
        }
    }

    public final JSONObject zzb() throws JSONException {
        JSONObject zzb = super.zzb();
        ResponseInfo responseInfo = getResponseInfo();
        if (responseInfo == null) {
            zzb.put("Response Info", "null");
        } else {
            zzb.put("Response Info", responseInfo.zzd());
        }
        return zzb;
    }
}
