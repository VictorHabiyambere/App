package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.zzu;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import javax.annotation.CheckForNull;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzdsy {
    private final Map zza = new ConcurrentHashMap();
    private JSONObject zzb;
    private final Executor zzc;
    private boolean zzd;
    private JSONObject zze;

    public zzdsy(Executor executor) {
        this.zzc = executor;
    }

    /* access modifiers changed from: private */
    /* renamed from: zzg */
    public final synchronized void zzf() {
        JSONObject zzf;
        JSONObject jSONObject;
        Map map;
        this.zzd = true;
        zzcbs zzh = zzu.zzo().zzi().zzh();
        if (zzh != null && (zzf = zzh.zzf()) != null) {
            if (((Boolean) zzba.zzc().zza(zzbep.zzdZ)).booleanValue()) {
                jSONObject = zzf.optJSONObject("common_settings");
            } else {
                jSONObject = null;
            }
            this.zzb = jSONObject;
            this.zze = zzf.optJSONObject("ad_unit_patterns");
            JSONArray optJSONArray = zzf.optJSONArray("ad_unit_id_settings");
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                    if (optJSONObject != null) {
                        String optString = optJSONObject.optString("ad_unit_id");
                        String optString2 = optJSONObject.optString("format");
                        JSONObject optJSONObject2 = optJSONObject.optJSONObject("request_signals");
                        if (!(optString == null || optJSONObject2 == null || optString2 == null)) {
                            if (this.zza.containsKey(optString2)) {
                                map = (Map) this.zza.get(optString2);
                            } else {
                                ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
                                this.zza.put(optString2, concurrentHashMap);
                                map = concurrentHashMap;
                            }
                            map.put(optString, optJSONObject2);
                        }
                    }
                }
            }
        }
    }

    @CheckForNull
    public final JSONObject zza() {
        if (!((Boolean) zzba.zzc().zza(zzbep.zzdZ)).booleanValue()) {
            return null;
        }
        return this.zzb;
    }

    @CheckForNull
    public final JSONObject zzb(String str, String str2) {
        if (!((Boolean) zzba.zzc().zza(zzbep.zzdY)).booleanValue() || str == null || str2 == null) {
            return null;
        }
        if (!this.zzd) {
            zzf();
        }
        Map map = (Map) this.zza.get(str2);
        if (map == null) {
            return null;
        }
        JSONObject jSONObject = (JSONObject) map.get(str);
        if (jSONObject != null) {
            return jSONObject;
        }
        String zza2 = zzdta.zza(this.zze, str, str2);
        if (zza2 != null) {
            return (JSONObject) map.get(zza2);
        }
        return null;
    }

    public final void zzc() {
        zzu.zzo().zzi().zzr(new zzdsv(this));
        this.zzc.execute(new zzdsw(this));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zze() {
        this.zzc.execute(new zzdsx(this));
    }
}
