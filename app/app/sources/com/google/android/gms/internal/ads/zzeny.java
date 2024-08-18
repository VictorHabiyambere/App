package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.zzu;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzeny {
    private final Map zza = new HashMap();
    private final Map zzb = new HashMap();
    private final Map zzc = new HashMap();
    private final Map zzd = new HashMap();
    private final Map zze = new HashMap();
    private final Executor zzf;
    private JSONObject zzg;

    zzeny(Executor executor) {
        this.zzf = executor;
    }

    private final synchronized zzgbf zzh(String str) {
        HashMap hashMap;
        if (!TextUtils.isEmpty(str)) {
            if (!TextUtils.isEmpty(zzu.zzo().zzi().zzh().zzc())) {
                boolean matches = Pattern.matches((String) zzba.zzc().zza(zzbep.zzde), str);
                boolean matches2 = Pattern.matches((String) zzba.zzc().zza(zzbep.zzdf), str);
                if (matches) {
                    hashMap = new HashMap(this.zze);
                } else if (matches2) {
                    hashMap = new HashMap(this.zzd);
                }
                return zzgbf.zzc(hashMap);
            }
        }
        return zzgbf.zzd();
    }

    private final synchronized List zzi(JSONObject jSONObject, String str) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        if (jSONObject != null) {
            Bundle zzo = zzo(jSONObject.optJSONObject("data"));
            JSONArray optJSONArray = jSONObject.optJSONArray("rtb_adapters");
            if (optJSONArray != null) {
                ArrayList arrayList2 = new ArrayList();
                for (int i = 0; i < optJSONArray.length(); i++) {
                    String optString = optJSONArray.optString(i, "");
                    if (!TextUtils.isEmpty(optString)) {
                        arrayList2.add(optString);
                    }
                }
                int size = arrayList2.size();
                for (int i2 = 0; i2 < size; i2++) {
                    String str2 = (String) arrayList2.get(i2);
                    zzg(str2);
                    if (((zzeoa) this.zza.get(str2)) != null) {
                        arrayList.add(new zzeoa(str2, str, zzo));
                    }
                }
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: private */
    public final synchronized void zzj() {
        this.zzb.clear();
        this.zza.clear();
        this.zze.clear();
        this.zzd.clear();
        zzm();
        zzn();
        zzk();
    }

    private final synchronized void zzk() {
        if (!((Boolean) zzbgq.zzb.zze()).booleanValue()) {
            if (((Boolean) zzba.zzc().zza(zzbep.zzbN)).booleanValue()) {
                JSONObject zzf2 = zzu.zzo().zzi().zzh().zzf();
                if (zzf2 != null) {
                    try {
                        JSONArray jSONArray = zzf2.getJSONArray("adapter_settings");
                        for (int i = 0; i < jSONArray.length(); i++) {
                            JSONObject jSONObject = jSONArray.getJSONObject(i);
                            String optString = jSONObject.optString("adapter_class_name");
                            JSONArray optJSONArray = jSONObject.optJSONArray("permission_set");
                            if (!TextUtils.isEmpty(optString)) {
                                for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i2);
                                    boolean optBoolean = jSONObject2.optBoolean("enable_rendering", false);
                                    boolean optBoolean2 = jSONObject2.optBoolean("collect_secure_signals", false);
                                    boolean optBoolean3 = jSONObject2.optBoolean("collect_secure_signals_on_full_app", false);
                                    String optString2 = jSONObject2.optString("platform");
                                    zzeoc zzeoc = new zzeoc(optString, optBoolean2, optBoolean, optBoolean3, new Bundle());
                                    if (optString2.equals("ADMOB")) {
                                        this.zzd.put(optString, zzeoc);
                                    } else if (optString2.equals("AD_MANAGER")) {
                                        this.zze.put(optString, zzeoc);
                                    }
                                }
                            }
                        }
                    } catch (JSONException e) {
                        zze.zzb("Malformed config loading JSON.", e);
                    }
                }
            }
        }
    }

    private final synchronized void zzl(String str, String str2, List list) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            Map map = (Map) this.zzc.get(str);
            if (map == null) {
                map = new HashMap();
            }
            this.zzc.put(str, map);
            List list2 = (List) map.get(str2);
            if (list2 == null) {
                list2 = new ArrayList();
            }
            list2.addAll(list);
            map.put(str2, list2);
        }
    }

    private final synchronized void zzm() {
        String str;
        JSONObject zzf2 = zzu.zzo().zzi().zzh().zzf();
        if (zzf2 != null) {
            try {
                JSONArray optJSONArray = zzf2.optJSONArray("ad_unit_id_settings");
                this.zzg = zzf2.optJSONObject("ad_unit_patterns");
                if (optJSONArray != null) {
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        JSONObject jSONObject = optJSONArray.getJSONObject(i);
                        if (((Boolean) zzba.zzc().zza(zzbep.zzkR)).booleanValue()) {
                            str = jSONObject.optString("ad_unit_id", "").toLowerCase(Locale.ROOT);
                        } else {
                            str = jSONObject.optString("ad_unit_id", "");
                        }
                        String optString = jSONObject.optString("format", "");
                        ArrayList arrayList = new ArrayList();
                        JSONObject optJSONObject = jSONObject.optJSONObject("mediation_config");
                        if (optJSONObject != null) {
                            JSONArray optJSONArray2 = optJSONObject.optJSONArray("ad_networks");
                            if (optJSONArray2 != null) {
                                for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                                    arrayList.addAll(zzi(optJSONArray2.getJSONObject(i2), optString));
                                }
                            }
                        }
                        zzl(optString, str, arrayList);
                    }
                }
            } catch (JSONException e) {
                zze.zzb("Malformed config loading JSON.", e);
            }
        }
    }

    private final synchronized void zzn() {
        if (!((Boolean) zzbgq.zzg.zze()).booleanValue()) {
            if (((Boolean) zzba.zzc().zza(zzbep.zzbM)).booleanValue()) {
                JSONObject zzf2 = zzu.zzo().zzi().zzh().zzf();
                if (zzf2 != null) {
                    try {
                        JSONArray jSONArray = zzf2.getJSONArray("signal_adapters");
                        for (int i = 0; i < jSONArray.length(); i++) {
                            JSONObject jSONObject = jSONArray.getJSONObject(i);
                            Bundle zzo = zzo(jSONObject.optJSONObject("data"));
                            String optString = jSONObject.optString("adapter_class_name");
                            boolean optBoolean = jSONObject.optBoolean("render", false);
                            boolean optBoolean2 = jSONObject.optBoolean("collect_signals", false);
                            if (!TextUtils.isEmpty(optString)) {
                                this.zzb.put(optString, new zzeoc(optString, optBoolean2, optBoolean, true, zzo));
                            }
                        }
                    } catch (JSONException e) {
                        zze.zzb("Malformed config loading JSON.", e);
                    }
                }
            }
        }
    }

    private static final Bundle zzo(JSONObject jSONObject) {
        Bundle bundle = new Bundle();
        if (jSONObject != null) {
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                bundle.putString(next, jSONObject.optString(next, ""));
            }
        }
        return bundle;
    }

    public final synchronized Map zza(String str, String str2) {
        HashMap hashMap;
        Bundle bundle;
        Map zzb2 = zzb(str, str2);
        zzgbf zzh = zzh(str2);
        hashMap = new HashMap();
        for (Map.Entry entry : ((zzgbf) zzb2).entrySet()) {
            String str3 = (String) entry.getKey();
            if (zzh.containsKey(str3)) {
                zzeoc zzeoc = (zzeoc) zzh.get(str3);
                List list = (List) entry.getValue();
                boolean z = zzeoc.zzb;
                boolean z2 = zzeoc.zzc;
                boolean z3 = zzeoc.zzd;
                if (list == null || list.isEmpty()) {
                    bundle = new Bundle();
                } else {
                    bundle = (Bundle) list.get(0);
                }
                hashMap.put(str3, new zzeoc(str3, z, z2, z3, bundle));
            }
        }
        zzgdi zze2 = zzh.entrySet().iterator();
        while (zze2.hasNext()) {
            Map.Entry entry2 = (Map.Entry) zze2.next();
            String str4 = (String) entry2.getKey();
            if (!hashMap.containsKey(str4) && ((zzeoc) entry2.getValue()).zzd) {
                hashMap.put(str4, (zzeoc) entry2.getValue());
            }
        }
        return hashMap;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v7, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v8, resolved type: java.util.List} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized java.util.Map zzb(java.lang.String r4, java.lang.String r5) {
        /*
            r3 = this;
            monitor-enter(r3)
            boolean r0 = android.text.TextUtils.isEmpty(r4)     // Catch:{ all -> 0x009c }
            if (r0 != 0) goto L_0x0096
            boolean r0 = android.text.TextUtils.isEmpty(r5)     // Catch:{ all -> 0x009c }
            if (r0 != 0) goto L_0x0096
            com.google.android.gms.internal.ads.zzcby r0 = com.google.android.gms.ads.internal.zzu.zzo()     // Catch:{ all -> 0x009c }
            com.google.android.gms.ads.internal.util.zzg r0 = r0.zzi()     // Catch:{ all -> 0x009c }
            com.google.android.gms.internal.ads.zzcbs r0 = r0.zzh()     // Catch:{ all -> 0x009c }
            java.lang.String r0 = r0.zzc()     // Catch:{ all -> 0x009c }
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x009c }
            if (r0 == 0) goto L_0x0024
            goto L_0x0096
        L_0x0024:
            java.util.Map r0 = r3.zzc     // Catch:{ all -> 0x009c }
            java.lang.Object r0 = r0.get(r4)     // Catch:{ all -> 0x009c }
            java.util.Map r0 = (java.util.Map) r0     // Catch:{ all -> 0x009c }
            if (r0 == 0) goto L_0x0096
            java.lang.Object r1 = r0.get(r5)     // Catch:{ all -> 0x009c }
            java.util.List r1 = (java.util.List) r1     // Catch:{ all -> 0x009c }
            if (r1 != 0) goto L_0x005c
            org.json.JSONObject r1 = r3.zzg     // Catch:{ all -> 0x009c }
            java.lang.String r4 = com.google.android.gms.internal.ads.zzdta.zza(r1, r5, r4)     // Catch:{ all -> 0x009c }
            com.google.android.gms.internal.ads.zzbeg r5 = com.google.android.gms.internal.ads.zzbep.zzkR     // Catch:{ all -> 0x009c }
            com.google.android.gms.internal.ads.zzben r1 = com.google.android.gms.ads.internal.client.zzba.zzc()     // Catch:{ all -> 0x009c }
            java.lang.Object r5 = r1.zza(r5)     // Catch:{ all -> 0x009c }
            java.lang.Boolean r5 = (java.lang.Boolean) r5     // Catch:{ all -> 0x009c }
            boolean r5 = r5.booleanValue()     // Catch:{ all -> 0x009c }
            if (r5 == 0) goto L_0x0054
            java.util.Locale r5 = java.util.Locale.ROOT     // Catch:{ all -> 0x009c }
            java.lang.String r4 = r4.toLowerCase(r5)     // Catch:{ all -> 0x009c }
        L_0x0054:
            java.lang.Object r4 = r0.get(r4)     // Catch:{ all -> 0x009c }
            r1 = r4
            java.util.List r1 = (java.util.List) r1     // Catch:{ all -> 0x009c }
            goto L_0x005d
        L_0x005c:
        L_0x005d:
            if (r1 == 0) goto L_0x0096
            java.util.HashMap r4 = new java.util.HashMap     // Catch:{ all -> 0x009c }
            r4.<init>()     // Catch:{ all -> 0x009c }
            java.util.Iterator r5 = r1.iterator()     // Catch:{ all -> 0x009c }
        L_0x0068:
            boolean r0 = r5.hasNext()     // Catch:{ all -> 0x009c }
            if (r0 == 0) goto L_0x0090
            java.lang.Object r0 = r5.next()     // Catch:{ all -> 0x009c }
            com.google.android.gms.internal.ads.zzeoa r0 = (com.google.android.gms.internal.ads.zzeoa) r0     // Catch:{ all -> 0x009c }
            java.lang.String r1 = r0.zza     // Catch:{ all -> 0x009c }
            boolean r2 = r4.containsKey(r1)     // Catch:{ all -> 0x009c }
            if (r2 != 0) goto L_0x0084
            java.util.ArrayList r2 = new java.util.ArrayList     // Catch:{ all -> 0x009c }
            r2.<init>()     // Catch:{ all -> 0x009c }
            r4.put(r1, r2)     // Catch:{ all -> 0x009c }
        L_0x0084:
            java.lang.Object r1 = r4.get(r1)     // Catch:{ all -> 0x009c }
            java.util.List r1 = (java.util.List) r1     // Catch:{ all -> 0x009c }
            android.os.Bundle r0 = r0.zzc     // Catch:{ all -> 0x009c }
            r1.add(r0)     // Catch:{ all -> 0x009c }
            goto L_0x0068
        L_0x0090:
            com.google.android.gms.internal.ads.zzgbf r4 = com.google.android.gms.internal.ads.zzgbf.zzc(r4)     // Catch:{ all -> 0x009c }
            monitor-exit(r3)
            return r4
        L_0x0096:
            com.google.android.gms.internal.ads.zzgbf r4 = com.google.android.gms.internal.ads.zzgbf.zzd()     // Catch:{ all -> 0x009c }
            monitor-exit(r3)
            return r4
        L_0x009c:
            r4 = move-exception
            monitor-exit(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzeny.zzb(java.lang.String, java.lang.String):java.util.Map");
    }

    public final synchronized Map zzc() {
        if (TextUtils.isEmpty(zzu.zzo().zzi().zzh().zzc())) {
            return zzgbf.zzd();
        }
        return zzgbf.zzc(this.zzb);
    }

    public final void zze() {
        zzu.zzo().zzi().zzr(new zzenx(this));
        this.zzf.execute(new zzenw(this));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzf() {
        this.zzf.execute(new zzenw(this));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0024, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void zzg(java.lang.String r5) {
        /*
            r4 = this;
            monitor-enter(r4)
            boolean r0 = android.text.TextUtils.isEmpty(r5)     // Catch:{ all -> 0x0025 }
            if (r0 == 0) goto L_0x0008
            goto L_0x0023
        L_0x0008:
            java.util.Map r0 = r4.zza     // Catch:{ all -> 0x0025 }
            boolean r0 = r0.containsKey(r5)     // Catch:{ all -> 0x0025 }
            if (r0 != 0) goto L_0x0023
            java.util.Map r0 = r4.zza     // Catch:{ all -> 0x0025 }
            com.google.android.gms.internal.ads.zzeoa r1 = new com.google.android.gms.internal.ads.zzeoa     // Catch:{ all -> 0x0025 }
            android.os.Bundle r2 = new android.os.Bundle     // Catch:{ all -> 0x0025 }
            r2.<init>()     // Catch:{ all -> 0x0025 }
            java.lang.String r3 = ""
            r1.<init>(r5, r3, r2)     // Catch:{ all -> 0x0025 }
            r0.put(r5, r1)     // Catch:{ all -> 0x0025 }
            monitor-exit(r4)
            return
        L_0x0023:
            monitor-exit(r4)
            return
        L_0x0025:
            r5 = move-exception
            monitor-exit(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzeny.zzg(java.lang.String):void");
    }
}
