package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.client.zzay;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.client.zze;
import com.google.android.gms.ads.internal.client.zzu;
import com.google.android.gms.ads.internal.util.client.zzm;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzdxo implements zzczo, zzdcg, zzdbd {
    private final zzdya zza;
    private final String zzb;
    private final String zzc;
    private int zzd;
    private zzdxn zze;
    private zzcze zzf;
    private zze zzg;
    private String zzh = "";
    private String zzi = "";
    private String zzj = "";
    private JSONObject zzk;
    private JSONObject zzl;
    private boolean zzm;
    private boolean zzn;
    private boolean zzo;

    zzdxo(zzdya zzdya, zzfho zzfho, String str) {
        this.zza = zzdya;
        this.zzc = str;
        this.zzb = zzfho.zzf;
        this.zzd = 0;
        this.zze = zzdxn.AD_REQUESTED;
    }

    private static JSONObject zzh(zze zze2) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("errorDomain", zze2.zzc);
        jSONObject.put("errorCode", zze2.zza);
        jSONObject.put("errorDescription", zze2.zzb);
        zze zze3 = zze2.zzd;
        jSONObject.put("underlyingError", zze3 == null ? null : zzh(zze3));
        return jSONObject;
    }

    private final JSONObject zzi(zzcze zzcze) throws JSONException {
        JSONObject jSONObject;
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("winningAdapterClassName", zzcze.zzg());
        jSONObject2.put("responseSecsSinceEpoch", zzcze.zzc());
        jSONObject2.put("responseId", zzcze.zzi());
        if (((Boolean) zzba.zzc().zza(zzbep.zzjl)).booleanValue()) {
            String zzd2 = zzcze.zzd();
            if (!TextUtils.isEmpty(zzd2)) {
                zzm.zze("Bidding data: ".concat(String.valueOf(zzd2)));
                jSONObject2.put("biddingData", new JSONObject(zzd2));
            }
        }
        if (!TextUtils.isEmpty(this.zzh)) {
            jSONObject2.put("adRequestUrl", this.zzh);
        }
        if (!TextUtils.isEmpty(this.zzi)) {
            jSONObject2.put("postBody", this.zzi);
        }
        if (!TextUtils.isEmpty(this.zzj)) {
            jSONObject2.put("adResponseBody", this.zzj);
        }
        JSONObject jSONObject3 = this.zzk;
        if (jSONObject3 != null) {
            jSONObject2.put("adResponseHeaders", jSONObject3);
        }
        JSONObject jSONObject4 = this.zzl;
        if (jSONObject4 != null) {
            jSONObject2.put("transactionExtras", jSONObject4);
        }
        if (((Boolean) zzba.zzc().zza(zzbep.zzjo)).booleanValue()) {
            jSONObject2.put("hasExceededMemoryLimit", this.zzo);
        }
        JSONArray jSONArray = new JSONArray();
        for (zzu zzu : zzcze.zzj()) {
            JSONObject jSONObject5 = new JSONObject();
            jSONObject5.put("adapterClassName", zzu.zza);
            jSONObject5.put("latencyMillis", zzu.zzb);
            if (((Boolean) zzba.zzc().zza(zzbep.zzjm)).booleanValue()) {
                jSONObject5.put("credentials", zzay.zzb().zzi(zzu.zzd));
            }
            zze zze2 = zzu.zzc;
            if (zze2 == null) {
                jSONObject = null;
            } else {
                jSONObject = zzh(zze2);
            }
            jSONObject5.put("error", jSONObject);
            jSONArray.put(jSONObject5);
        }
        jSONObject2.put("adNetworks", jSONArray);
        return jSONObject2;
    }

    public final void zza(zzcup zzcup) {
        if (this.zza.zzq()) {
            this.zzf = zzcup.zzl();
            this.zze = zzdxn.AD_LOADED;
            if (((Boolean) zzba.zzc().zza(zzbep.zzjs)).booleanValue()) {
                this.zza.zzf(this.zzb, this);
            }
        }
    }

    public final String zzc() {
        return this.zzc;
    }

    public final JSONObject zzd() throws JSONException {
        JSONObject jSONObject;
        IBinder iBinder;
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("state", this.zze);
        jSONObject2.put("format", zzfgt.zza(this.zzd));
        if (((Boolean) zzba.zzc().zza(zzbep.zzjs)).booleanValue()) {
            jSONObject2.put("isOutOfContext", this.zzm);
            if (this.zzm) {
                jSONObject2.put("shown", this.zzn);
            }
        }
        zzcze zzcze = this.zzf;
        if (zzcze != null) {
            jSONObject = zzi(zzcze);
        } else {
            zze zze2 = this.zzg;
            if (zze2 == null || (iBinder = zze2.zze) == null) {
                jSONObject = null;
            } else {
                zzcze zzcze2 = (zzcze) iBinder;
                JSONObject zzi2 = zzi(zzcze2);
                if (zzcze2.zzj().isEmpty()) {
                    JSONArray jSONArray = new JSONArray();
                    jSONArray.put(zzh(this.zzg));
                    zzi2.put("errors", jSONArray);
                }
                jSONObject = zzi2;
            }
        }
        jSONObject2.put("responseInfo", jSONObject);
        return jSONObject2;
    }

    public final void zzdB(zze zze2) {
        if (this.zza.zzq()) {
            this.zze = zzdxn.AD_LOAD_FAILED;
            this.zzg = zze2;
            if (((Boolean) zzba.zzc().zza(zzbep.zzjs)).booleanValue()) {
                this.zza.zzf(this.zzb, this);
            }
        }
    }

    public final void zzdn(zzbxu zzbxu) {
        if (!((Boolean) zzba.zzc().zza(zzbep.zzjs)).booleanValue() && this.zza.zzq()) {
            this.zza.zzf(this.zzb, this);
        }
    }

    public final void zzdo(zzfhf zzfhf) {
        if (this.zza.zzq()) {
            int i = 0;
            if (!zzfhf.zzb.zza.isEmpty()) {
                this.zzd = ((zzfgt) zzfhf.zzb.zza.get(0)).zzb;
            }
            if (!TextUtils.isEmpty(zzfhf.zzb.zzb.zzk)) {
                this.zzh = zzfhf.zzb.zzb.zzk;
            }
            if (!TextUtils.isEmpty(zzfhf.zzb.zzb.zzl)) {
                this.zzi = zzfhf.zzb.zzb.zzl;
            }
            if (zzfhf.zzb.zzb.zzo.length() > 0) {
                this.zzl = zzfhf.zzb.zzb.zzo;
            }
            if (!((Boolean) zzba.zzc().zza(zzbep.zzjo)).booleanValue()) {
                return;
            }
            if (!this.zza.zzs()) {
                this.zzo = true;
                return;
            }
            if (!TextUtils.isEmpty(zzfhf.zzb.zzb.zzm)) {
                this.zzj = zzfhf.zzb.zzb.zzm;
            }
            if (zzfhf.zzb.zzb.zzn.length() > 0) {
                this.zzk = zzfhf.zzb.zzb.zzn;
            }
            zzdya zzdya = this.zza;
            JSONObject jSONObject = this.zzk;
            if (jSONObject != null) {
                i = jSONObject.toString().length();
            }
            if (!TextUtils.isEmpty(this.zzj)) {
                i += this.zzj.length();
            }
            zzdya.zzk((long) i);
        }
    }

    public final void zze() {
        this.zzm = true;
    }

    public final void zzf() {
        this.zzn = true;
    }

    public final boolean zzg() {
        return this.zze != zzdxn.AD_REQUESTED;
    }
}
