package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Build;
import android.os.RemoteException;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.client.zzay;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.client.zzda;
import com.google.android.gms.ads.internal.client.zze;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.client.zzf;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.ads.internal.zzu;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzdya implements zzdzb, zzdxl {
    private final zzdyl zza;
    private final zzdzc zzb;
    private final zzdxm zzc;
    private final zzdxv zzd;
    private final zzdxk zze;
    private final zzdyx zzf;
    private final zzdyh zzg;
    private final zzdyh zzh;
    private final String zzi;
    private final Context zzj;
    @Nullable
    private final String zzk;
    private final Map zzl = new HashMap();
    private final Map zzm = new HashMap();
    private final Map zzn = new HashMap();
    private String zzo = "{}";
    private JSONObject zzp;
    private long zzq = Long.MAX_VALUE;
    private zzdxw zzr = zzdxw.NONE;
    private boolean zzs;
    private int zzt;
    private boolean zzu;
    private zzdxz zzv = zzdxz.UNKNOWN;
    private long zzw = 0;
    private String zzx = "";

    zzdya(zzdyl zzdyl, zzdzc zzdzc, zzdxm zzdxm, Context context, VersionInfoParcel versionInfoParcel, zzdxv zzdxv, zzdyx zzdyx, zzdyh zzdyh, zzdyh zzdyh2, @Nullable String str) {
        this.zza = zzdyl;
        this.zzb = zzdzc;
        this.zzc = zzdxm;
        this.zze = new zzdxk(context);
        this.zzi = versionInfoParcel.afmaVersion;
        this.zzk = str;
        this.zzd = zzdxv;
        this.zzf = zzdyx;
        this.zzg = zzdyh;
        this.zzh = zzdyh2;
        this.zzj = context;
        zzu.zzs().zzg(this);
    }

    private final synchronized void zzA(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                zzx(jSONObject.optBoolean("isTestMode", false), false);
                zzw((zzdxw) Enum.valueOf(zzdxw.class, jSONObject.optString("gesture", "NONE")), false);
                this.zzo = jSONObject.optString("networkExtras", "{}");
                this.zzq = jSONObject.optLong("networkExtrasExpirationSecs", Long.MAX_VALUE);
            } catch (JSONException e) {
            }
        }
    }

    private final synchronized JSONObject zzt() throws JSONException {
        JSONObject jSONObject;
        jSONObject = new JSONObject();
        for (Map.Entry entry : this.zzl.entrySet()) {
            JSONArray jSONArray = new JSONArray();
            for (zzdxo zzdxo : (List) entry.getValue()) {
                if (zzdxo.zzg()) {
                    jSONArray.put(zzdxo.zzd());
                }
            }
            if (jSONArray.length() > 0) {
                jSONObject.put((String) entry.getKey(), jSONArray);
            }
        }
        return jSONObject;
    }

    private final void zzu() {
        this.zzu = true;
        this.zzd.zzc();
        this.zza.zzh(this);
        this.zzb.zzd(this);
        this.zzc.zzd(this);
        this.zzf.zzf(this);
        if (!TextUtils.isEmpty((CharSequence) zzba.zzc().zza(zzbep.zzjx))) {
            this.zzg.zzb(PreferenceManager.getDefaultSharedPreferences(this.zzj), Arrays.asList(((String) zzba.zzc().zza(zzbep.zzjx)).split(",")));
        }
        if (!TextUtils.isEmpty((CharSequence) zzba.zzc().zza(zzbep.zzjy))) {
            this.zzh.zzb(this.zzj.getSharedPreferences("admob", 0), Arrays.asList(((String) zzba.zzc().zza(zzbep.zzjy)).split(",")));
        }
        zzA(zzu.zzo().zzi().zzn());
        this.zzx = zzu.zzo().zzi().zzo();
    }

    private final void zzv() {
        zzu.zzo().zzi().zzG(zzd());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0022, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final synchronized void zzw(com.google.android.gms.internal.ads.zzdxw r2, boolean r3) {
        /*
            r1 = this;
            monitor-enter(r1)
            com.google.android.gms.internal.ads.zzdxw r0 = r1.zzr     // Catch:{ all -> 0x0023 }
            if (r0 != r2) goto L_0x0006
            goto L_0x0021
        L_0x0006:
            boolean r0 = r1.zzq()     // Catch:{ all -> 0x0023 }
            if (r0 == 0) goto L_0x000f
            r1.zzy()     // Catch:{ all -> 0x0023 }
        L_0x000f:
            r1.zzr = r2     // Catch:{ all -> 0x0023 }
            boolean r2 = r1.zzq()     // Catch:{ all -> 0x0023 }
            if (r2 == 0) goto L_0x001a
            r1.zzz()     // Catch:{ all -> 0x0023 }
        L_0x001a:
            if (r3 == 0) goto L_0x0021
            r1.zzv()     // Catch:{ all -> 0x0023 }
            monitor-exit(r1)
            return
        L_0x0021:
            monitor-exit(r1)
            return
        L_0x0023:
            r2 = move-exception
            monitor-exit(r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdya.zzw(com.google.android.gms.internal.ads.zzdxw, boolean):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x003b, code lost:
        return;
     */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0035  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final synchronized void zzx(boolean r2, boolean r3) {
        /*
            r1 = this;
            monitor-enter(r1)
            boolean r0 = r1.zzs     // Catch:{ all -> 0x003c }
            if (r0 != r2) goto L_0x0006
            goto L_0x003a
        L_0x0006:
            r1.zzs = r2     // Catch:{ all -> 0x003c }
            if (r2 == 0) goto L_0x002a
            com.google.android.gms.internal.ads.zzbeg r2 = com.google.android.gms.internal.ads.zzbep.zzjj     // Catch:{ all -> 0x003c }
            com.google.android.gms.internal.ads.zzben r0 = com.google.android.gms.ads.internal.client.zzba.zzc()     // Catch:{ all -> 0x003c }
            java.lang.Object r2 = r0.zza(r2)     // Catch:{ all -> 0x003c }
            java.lang.Boolean r2 = (java.lang.Boolean) r2     // Catch:{ all -> 0x003c }
            boolean r2 = r2.booleanValue()     // Catch:{ all -> 0x003c }
            if (r2 == 0) goto L_0x0026
            com.google.android.gms.ads.internal.util.zzay r2 = com.google.android.gms.ads.internal.zzu.zzs()     // Catch:{ all -> 0x003c }
            boolean r2 = r2.zzl()     // Catch:{ all -> 0x003c }
            if (r2 != 0) goto L_0x002a
        L_0x0026:
            r1.zzz()     // Catch:{ all -> 0x003c }
            goto L_0x0033
        L_0x002a:
            boolean r2 = r1.zzq()     // Catch:{ all -> 0x003c }
            if (r2 != 0) goto L_0x0033
            r1.zzy()     // Catch:{ all -> 0x003c }
        L_0x0033:
            if (r3 == 0) goto L_0x003a
            r1.zzv()     // Catch:{ all -> 0x003c }
            monitor-exit(r1)
            return
        L_0x003a:
            monitor-exit(r1)
            return
        L_0x003c:
            r2 = move-exception
            monitor-exit(r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdya.zzx(boolean, boolean):void");
    }

    private final synchronized void zzy() {
        zzdxw zzdxw = zzdxw.NONE;
        switch (this.zzr.ordinal()) {
            case 1:
                this.zzb.zzb();
                return;
            case 2:
                this.zzc.zzb();
                return;
            default:
                return;
        }
    }

    private final synchronized void zzz() {
        zzdxw zzdxw = zzdxw.NONE;
        switch (this.zzr.ordinal()) {
            case 1:
                this.zzb.zzc();
                return;
            case 2:
                this.zzc.zzc();
                return;
            default:
                return;
        }
    }

    public final zzdxw zza() {
        return this.zzr;
    }

    public final synchronized ListenableFuture zzb(String str) {
        zzccn zzccn;
        zzccn = new zzccn();
        if (this.zzm.containsKey(str)) {
            zzccn.zzc((zzdxo) this.zzm.get(str));
        } else {
            if (!this.zzn.containsKey(str)) {
                this.zzn.put(str, new ArrayList());
            }
            ((List) this.zzn.get(str)).add(zzccn);
        }
        return zzccn;
    }

    public final synchronized String zzc() {
        if (((Boolean) zzba.zzc().zza(zzbep.zziU)).booleanValue()) {
            if (zzq()) {
                if (this.zzq < zzu.zzB().currentTimeMillis() / 1000) {
                    this.zzo = "{}";
                    this.zzq = Long.MAX_VALUE;
                    return "";
                } else if (!this.zzo.equals("{}")) {
                    return this.zzo;
                }
            }
        }
        return "";
    }

    public final synchronized String zzd() {
        JSONObject jSONObject;
        jSONObject = new JSONObject();
        try {
            jSONObject.put("isTestMode", this.zzs);
            jSONObject.put("gesture", this.zzr);
            if (this.zzq > zzu.zzB().currentTimeMillis() / 1000) {
                jSONObject.put("networkExtras", this.zzo);
                jSONObject.put("networkExtrasExpirationSecs", this.zzq);
            }
        } catch (JSONException e) {
        }
        return jSONObject.toString();
    }

    public final synchronized JSONObject zze() {
        JSONObject jSONObject;
        JSONObject jSONObject2;
        jSONObject = new JSONObject();
        try {
            jSONObject.put("platform", "ANDROID");
            if (!TextUtils.isEmpty(this.zzk)) {
                String str = this.zzk;
                jSONObject.put("sdkVersion", "afma-sdk-a-v" + str);
            }
            jSONObject.put("internalSdkVersion", this.zzi);
            jSONObject.put("osVersion", Build.VERSION.RELEASE);
            jSONObject.put("adapters", this.zzd.zza());
            if (((Boolean) zzba.zzc().zza(zzbep.zzju)).booleanValue()) {
                String zzn2 = zzu.zzo().zzn();
                if (!TextUtils.isEmpty(zzn2)) {
                    jSONObject.put("plugin", zzn2);
                }
            }
            if (this.zzq < zzu.zzB().currentTimeMillis() / 1000) {
                this.zzo = "{}";
            }
            jSONObject.put("networkExtras", this.zzo);
            jSONObject.put("adSlots", zzt());
            jSONObject.put("appInfo", this.zze.zza());
            String zzc2 = zzu.zzo().zzi().zzh().zzc();
            if (!TextUtils.isEmpty(zzc2)) {
                jSONObject.put("cld", new JSONObject(zzc2));
            }
            if (((Boolean) zzba.zzc().zza(zzbep.zzjk)).booleanValue() && (jSONObject2 = this.zzp) != null) {
                String obj = jSONObject2.toString();
                zzm.zze("Server data: " + obj);
                jSONObject.put("serverData", this.zzp);
            }
            if (((Boolean) zzba.zzc().zza(zzbep.zzjj)).booleanValue()) {
                jSONObject.put("openAction", this.zzv);
                jSONObject.put("gesture", this.zzr);
            }
            jSONObject.put("isGamRegisteredTestDevice", zzu.zzs().zzl());
            zzu.zzp();
            zzay.zzb();
            jSONObject.put("isSimulator", zzf.zzs());
            if (((Boolean) zzba.zzc().zza(zzbep.zzjw)).booleanValue()) {
                jSONObject.put("uiStorage", new JSONObject(this.zzx));
            }
            if (!TextUtils.isEmpty((CharSequence) zzba.zzc().zza(zzbep.zzjy))) {
                jSONObject.put("gmaDisk", this.zzh.zza());
            }
            if (!TextUtils.isEmpty((CharSequence) zzba.zzc().zza(zzbep.zzjx))) {
                jSONObject.put("userDisk", this.zzg.zza());
            }
        } catch (JSONException e) {
            zzu.zzo().zzv(e, "Inspector.toJson");
            zzm.zzk("Ad inspector encountered an error", e);
        }
        return jSONObject;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:28:0x009e, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void zzf(java.lang.String r4, com.google.android.gms.internal.ads.zzdxo r5) {
        /*
            r3 = this;
            monitor-enter(r3)
            com.google.android.gms.internal.ads.zzbeg r0 = com.google.android.gms.internal.ads.zzbep.zziU     // Catch:{ all -> 0x009f }
            com.google.android.gms.internal.ads.zzben r1 = com.google.android.gms.ads.internal.client.zzba.zzc()     // Catch:{ all -> 0x009f }
            java.lang.Object r0 = r1.zza(r0)     // Catch:{ all -> 0x009f }
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch:{ all -> 0x009f }
            boolean r0 = r0.booleanValue()     // Catch:{ all -> 0x009f }
            if (r0 == 0) goto L_0x009d
            boolean r0 = r3.zzq()     // Catch:{ all -> 0x009f }
            if (r0 != 0) goto L_0x001b
            goto L_0x009d
        L_0x001b:
            int r0 = r3.zzt     // Catch:{ all -> 0x009f }
            com.google.android.gms.internal.ads.zzbeg r1 = com.google.android.gms.internal.ads.zzbep.zziW     // Catch:{ all -> 0x009f }
            com.google.android.gms.internal.ads.zzben r2 = com.google.android.gms.ads.internal.client.zzba.zzc()     // Catch:{ all -> 0x009f }
            java.lang.Object r1 = r2.zza(r1)     // Catch:{ all -> 0x009f }
            java.lang.Integer r1 = (java.lang.Integer) r1     // Catch:{ all -> 0x009f }
            int r1 = r1.intValue()     // Catch:{ all -> 0x009f }
            if (r0 < r1) goto L_0x0036
            java.lang.String r4 = "Maximum number of ad requests stored reached. Dropping the current request."
            com.google.android.gms.ads.internal.util.client.zzm.zzj(r4)     // Catch:{ all -> 0x009f }
            monitor-exit(r3)
            return
        L_0x0036:
            java.util.Map r0 = r3.zzl     // Catch:{ all -> 0x009f }
            boolean r0 = r0.containsKey(r4)     // Catch:{ all -> 0x009f }
            if (r0 != 0) goto L_0x0048
            java.util.Map r0 = r3.zzl     // Catch:{ all -> 0x009f }
            java.util.ArrayList r1 = new java.util.ArrayList     // Catch:{ all -> 0x009f }
            r1.<init>()     // Catch:{ all -> 0x009f }
            r0.put(r4, r1)     // Catch:{ all -> 0x009f }
        L_0x0048:
            int r0 = r3.zzt     // Catch:{ all -> 0x009f }
            int r0 = r0 + 1
            r3.zzt = r0     // Catch:{ all -> 0x009f }
            java.util.Map r0 = r3.zzl     // Catch:{ all -> 0x009f }
            java.lang.Object r4 = r0.get(r4)     // Catch:{ all -> 0x009f }
            java.util.List r4 = (java.util.List) r4     // Catch:{ all -> 0x009f }
            r4.add(r5)     // Catch:{ all -> 0x009f }
            com.google.android.gms.internal.ads.zzbeg r4 = com.google.android.gms.internal.ads.zzbep.zzjs     // Catch:{ all -> 0x009f }
            com.google.android.gms.internal.ads.zzben r0 = com.google.android.gms.ads.internal.client.zzba.zzc()     // Catch:{ all -> 0x009f }
            java.lang.Object r4 = r0.zza(r4)     // Catch:{ all -> 0x009f }
            java.lang.Boolean r4 = (java.lang.Boolean) r4     // Catch:{ all -> 0x009f }
            boolean r4 = r4.booleanValue()     // Catch:{ all -> 0x009f }
            if (r4 == 0) goto L_0x009d
            java.lang.String r4 = r5.zzc()     // Catch:{ all -> 0x009f }
            java.util.Map r0 = r3.zzm     // Catch:{ all -> 0x009f }
            r0.put(r4, r5)     // Catch:{ all -> 0x009f }
            java.util.Map r0 = r3.zzn     // Catch:{ all -> 0x009f }
            boolean r0 = r0.containsKey(r4)     // Catch:{ all -> 0x009f }
            if (r0 == 0) goto L_0x009d
            java.util.Map r0 = r3.zzn     // Catch:{ all -> 0x009f }
            java.lang.Object r4 = r0.get(r4)     // Catch:{ all -> 0x009f }
            java.util.List r4 = (java.util.List) r4     // Catch:{ all -> 0x009f }
            java.util.Iterator r0 = r4.iterator()     // Catch:{ all -> 0x009f }
        L_0x0088:
            boolean r1 = r0.hasNext()     // Catch:{ all -> 0x009f }
            if (r1 == 0) goto L_0x0098
            java.lang.Object r1 = r0.next()     // Catch:{ all -> 0x009f }
            com.google.android.gms.internal.ads.zzccn r1 = (com.google.android.gms.internal.ads.zzccn) r1     // Catch:{ all -> 0x009f }
            r1.zzc(r5)     // Catch:{ all -> 0x009f }
            goto L_0x0088
        L_0x0098:
            r4.clear()     // Catch:{ all -> 0x009f }
            monitor-exit(r3)
            return
        L_0x009d:
            monitor-exit(r3)
            return
        L_0x009f:
            r4 = move-exception
            monitor-exit(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdya.zzf(java.lang.String, com.google.android.gms.internal.ads.zzdxo):void");
    }

    public final void zzg() {
        if (((Boolean) zzba.zzc().zza(zzbep.zziU)).booleanValue()) {
            if (!((Boolean) zzba.zzc().zza(zzbep.zzjj)).booleanValue() || !zzu.zzo().zzi().zzR()) {
                String zzn2 = zzu.zzo().zzi().zzn();
                if (!TextUtils.isEmpty(zzn2)) {
                    try {
                        if (new JSONObject(zzn2).optBoolean("isTestMode", false)) {
                            zzu();
                        }
                    } catch (JSONException e) {
                    }
                }
            } else {
                zzu();
            }
        }
    }

    public final synchronized void zzh(zzda zzda, zzdxz zzdxz) {
        if (!zzq()) {
            try {
                zzda.zze(zzfiq.zzd(18, (String) null, (zze) null));
            } catch (RemoteException e) {
                zzm.zzj("Ad inspector cannot be opened because the device is not in test mode. See https://developers.google.com/admob/android/test-ads#enable_test_devices for more information.");
            }
        } else {
            if (!((Boolean) zzba.zzc().zza(zzbep.zziU)).booleanValue()) {
                try {
                    zzda.zze(zzfiq.zzd(1, (String) null, (zze) null));
                } catch (RemoteException e2) {
                    zzm.zzj("Ad inspector had an internal error.");
                }
            } else {
                this.zzv = zzdxz;
                this.zza.zzj(zzda, new zzbmj(this), new zzbmc(this.zzf), new zzblq(this));
            }
        }
    }

    public final synchronized void zzi(String str, long j) {
        this.zzo = str;
        this.zzq = j;
        zzv();
    }

    public final synchronized void zzj(String str) {
        this.zzx = str;
        zzu.zzo().zzi().zzH(this.zzx);
    }

    public final synchronized void zzk(long j) {
        this.zzw += j;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000a, code lost:
        if (r2 != false) goto L_0x000c;
     */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x001b  */
    /* JADX WARNING: Removed duplicated region for block: B:13:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzl(boolean r2) {
        /*
            r1 = this;
            boolean r0 = r1.zzu
            if (r0 != 0) goto L_0x000a
            if (r2 == 0) goto L_0x0015
            r1.zzu()
            goto L_0x000c
        L_0x000a:
            if (r2 == 0) goto L_0x0015
        L_0x000c:
            boolean r2 = r1.zzs
            if (r2 == 0) goto L_0x0011
            goto L_0x0015
        L_0x0011:
            r1.zzz()
            return
        L_0x0015:
            boolean r2 = r1.zzq()
            if (r2 != 0) goto L_0x001e
            r1.zzy()
        L_0x001e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdya.zzl(boolean):void");
    }

    public final void zzm(zzdxw zzdxw) {
        zzw(zzdxw, true);
    }

    public final synchronized void zzn(JSONObject jSONObject) {
        this.zzp = jSONObject;
    }

    public final void zzo(boolean z) {
        if (!this.zzu && z) {
            zzu();
        }
        zzx(z, true);
    }

    public final boolean zzp() {
        return this.zzp != null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0026, code lost:
        return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized boolean zzq() {
        /*
            r2 = this;
            monitor-enter(r2)
            com.google.android.gms.internal.ads.zzbeg r0 = com.google.android.gms.internal.ads.zzbep.zzjj     // Catch:{ all -> 0x002c }
            com.google.android.gms.internal.ads.zzben r1 = com.google.android.gms.ads.internal.client.zzba.zzc()     // Catch:{ all -> 0x002c }
            java.lang.Object r0 = r1.zza(r0)     // Catch:{ all -> 0x002c }
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch:{ all -> 0x002c }
            boolean r0 = r0.booleanValue()     // Catch:{ all -> 0x002c }
            if (r0 == 0) goto L_0x0028
            boolean r0 = r2.zzs     // Catch:{ all -> 0x002c }
            if (r0 != 0) goto L_0x0025
            com.google.android.gms.ads.internal.util.zzay r0 = com.google.android.gms.ads.internal.zzu.zzs()     // Catch:{ all -> 0x002c }
            boolean r0 = r0.zzl()     // Catch:{ all -> 0x002c }
            if (r0 == 0) goto L_0x0022
            goto L_0x0025
        L_0x0022:
            monitor-exit(r2)
            r0 = 0
            return r0
        L_0x0025:
            monitor-exit(r2)
            r0 = 1
            return r0
        L_0x0028:
            boolean r0 = r2.zzs     // Catch:{ all -> 0x002c }
            monitor-exit(r2)
            return r0
        L_0x002c:
            r0 = move-exception
            monitor-exit(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdya.zzq():boolean");
    }

    public final synchronized boolean zzr() {
        return this.zzs;
    }

    public final boolean zzs() {
        return this.zzw < ((Long) zzba.zzc().zza(zzbep.zzjp)).longValue();
    }
}
