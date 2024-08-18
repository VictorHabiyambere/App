package com.google.android.gms.ads;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zzay;
import com.google.android.gms.ads.internal.client.zzdn;
import com.google.android.gms.ads.internal.client.zzu;
import com.google.android.gms.ads.internal.util.client.zzm;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.2.0 */
public final class ResponseInfo {
    private final zzdn zza;
    private final List zzb = new ArrayList();
    private AdapterResponseInfo zzc;

    private ResponseInfo(zzdn zzdn) {
        this.zza = zzdn;
        zzdn zzdn2 = this.zza;
        if (zzdn2 != null) {
            try {
                List<zzu> zzj = zzdn2.zzj();
                if (zzj != null) {
                    for (zzu zza2 : zzj) {
                        AdapterResponseInfo zza3 = AdapterResponseInfo.zza(zza2);
                        if (zza3 != null) {
                            this.zzb.add(zza3);
                        }
                    }
                }
            } catch (RemoteException e) {
                zzm.zzh("Could not forward getAdapterResponseInfo to ResponseInfo.", e);
            }
        }
        zzdn zzdn3 = this.zza;
        if (zzdn3 != null) {
            try {
                zzu zzf = zzdn3.zzf();
                if (zzf != null) {
                    this.zzc = AdapterResponseInfo.zza(zzf);
                }
            } catch (RemoteException e2) {
                zzm.zzh("Could not forward getLoadedAdapterResponse to ResponseInfo.", e2);
            }
        }
    }

    public static ResponseInfo zza(zzdn zzdn) {
        if (zzdn != null) {
            return new ResponseInfo(zzdn);
        }
        return null;
    }

    public static ResponseInfo zzb(zzdn zzdn) {
        return new ResponseInfo(zzdn);
    }

    public List<AdapterResponseInfo> getAdapterResponses() {
        return this.zzb;
    }

    public AdapterResponseInfo getLoadedAdapterResponseInfo() {
        return this.zzc;
    }

    public String getMediationAdapterClassName() {
        try {
            zzdn zzdn = this.zza;
            if (zzdn != null) {
                return zzdn.zzg();
            }
            return null;
        } catch (RemoteException e) {
            zzm.zzh("Could not forward getMediationAdapterClassName to ResponseInfo.", e);
            return null;
        }
    }

    public Bundle getResponseExtras() {
        try {
            zzdn zzdn = this.zza;
            if (zzdn != null) {
                return zzdn.zze();
            }
        } catch (RemoteException e) {
            zzm.zzh("Could not forward getResponseExtras to ResponseInfo.", e);
        }
        return new Bundle();
    }

    public String getResponseId() {
        try {
            zzdn zzdn = this.zza;
            if (zzdn != null) {
                return zzdn.zzi();
            }
            return null;
        } catch (RemoteException e) {
            zzm.zzh("Could not forward getResponseId to ResponseInfo.", e);
            return null;
        }
    }

    public String toString() {
        try {
            return zzd().toString(2);
        } catch (JSONException e) {
            return "Error forming toString output.";
        }
    }

    public final zzdn zzc() {
        return this.zza;
    }

    public final JSONObject zzd() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        String responseId = getResponseId();
        if (responseId == null) {
            jSONObject.put("Response ID", "null");
        } else {
            jSONObject.put("Response ID", responseId);
        }
        String mediationAdapterClassName = getMediationAdapterClassName();
        if (mediationAdapterClassName == null) {
            jSONObject.put("Mediation Adapter Class Name", "null");
        } else {
            jSONObject.put("Mediation Adapter Class Name", mediationAdapterClassName);
        }
        JSONArray jSONArray = new JSONArray();
        for (AdapterResponseInfo zzb2 : this.zzb) {
            jSONArray.put(zzb2.zzb());
        }
        jSONObject.put("Adapter Responses", jSONArray);
        AdapterResponseInfo adapterResponseInfo = this.zzc;
        if (adapterResponseInfo != null) {
            jSONObject.put("Loaded Adapter Response", adapterResponseInfo.zzb());
        }
        Bundle responseExtras = getResponseExtras();
        if (responseExtras != null) {
            jSONObject.put("Response Extras", zzay.zzb().zzi(responseExtras));
        }
        return jSONObject;
    }
}
