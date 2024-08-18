package com.google.android.gms.internal.ads;

import android.os.Bundle;
import androidx.webkit.WebViewFeature;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.client.zze;
import com.google.android.gms.ads.internal.zzu;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzduj implements zzdcg, zzdaz, zzczo, zzdhu {
    private final zzdux zza;
    private final zzdvh zzb;

    public zzduj(zzdux zzdux, zzdvh zzdvh) {
        this.zza = zzdux;
        this.zzb = zzdvh;
    }

    private final void zzc(Bundle bundle) {
        if (bundle != null) {
            for (String str : bundle.keySet()) {
                long j = bundle.getLong(str);
                if (j >= 0) {
                    this.zza.zzc(str, String.valueOf(j));
                }
            }
        }
    }

    private final void zzd(Bundle bundle, zzgbc zzgbc) {
        int size = zzgbc.size();
        for (int i = 0; i < size; i++) {
            zzdum zzdum = (zzdum) zzgbc.get(i);
            long j = bundle.getLong(zzdum.zza().zza(), -1);
            long j2 = bundle.getLong(zzdum.zzb().zza(), -1);
            if (j > 0 && j2 > 0) {
                this.zza.zzc(zzdum.zzc(), String.valueOf(j2 - j));
            }
        }
        zzc(bundle.getBundle("client_sig_latency_key"));
        zzc(bundle.getBundle("gms_sig_latency_key"));
    }

    public final void zzdB(zze zze) {
        this.zza.zzb().put("action", "ftl");
        this.zza.zzc("ftl", String.valueOf(zze.zza));
        this.zza.zzc("ed", zze.zzc);
        this.zzb.zzf(this.zza.zzb());
    }

    public final void zzdn(zzbxu zzbxu) {
        this.zza.zze(zzbxu.zza);
    }

    public final void zzdo(zzfhf zzfhf) {
        this.zza.zzd(zzfhf);
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x00ba  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zze(com.google.android.gms.ads.nonagon.signalgeneration.zzax r7) {
        /*
            r6 = this;
            com.google.android.gms.internal.ads.zzbeg r0 = com.google.android.gms.internal.ads.zzbep.zzhj
            com.google.android.gms.internal.ads.zzben r1 = com.google.android.gms.ads.internal.client.zzba.zzc()
            java.lang.Object r0 = r1.zza(r0)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            if (r0 != 0) goto L_0x0013
            return
        L_0x0013:
            java.lang.String r0 = "sgs"
            java.lang.String r1 = "action"
            if (r7 != 0) goto L_0x003b
            com.google.android.gms.internal.ads.zzdux r7 = r6.zza
            java.util.Map r7 = r7.zzb()
            r7.put(r1, r0)
            com.google.android.gms.internal.ads.zzdux r7 = r6.zza
            java.util.Map r7 = r7.zzb()
            java.lang.String r0 = "request_id"
            java.lang.String r1 = "-1"
            r7.put(r0, r1)
            com.google.android.gms.internal.ads.zzdvh r7 = r6.zzb
            com.google.android.gms.internal.ads.zzdux r0 = r6.zza
            java.util.Map r0 = r0.zzb()
            r7.zzf(r0)
            return
        L_0x003b:
            com.google.android.gms.internal.ads.zzbxu r2 = r7.zzc
            com.google.android.gms.internal.ads.zzbeg r3 = com.google.android.gms.internal.ads.zzbep.zzcd
            com.google.android.gms.internal.ads.zzben r4 = com.google.android.gms.ads.internal.client.zzba.zzc()
            java.lang.Object r3 = r4.zza(r3)
            java.lang.Boolean r3 = (java.lang.Boolean) r3
            boolean r3 = r3.booleanValue()
            if (r3 == 0) goto L_0x006b
            if (r2 == 0) goto L_0x006b
            android.os.Bundle r2 = r2.zzm
            if (r2 == 0) goto L_0x006b
            com.google.android.gms.internal.ads.zzdul r3 = com.google.android.gms.internal.ads.zzdul.PUBLIC_API_CALLBACK
            java.lang.String r3 = r3.zza()
            com.google.android.gms.common.util.Clock r4 = com.google.android.gms.ads.internal.zzu.zzB()
            long r4 = r4.currentTimeMillis()
            r2.putLong(r3, r4)
            com.google.android.gms.internal.ads.zzgbc r3 = com.google.android.gms.internal.ads.zzdum.zza
            r6.zzd(r2, r3)
        L_0x006b:
            org.json.JSONObject r2 = new org.json.JSONObject     // Catch:{ JSONException -> 0x00cd }
            java.lang.String r3 = r7.zzb     // Catch:{ JSONException -> 0x00cd }
            r2.<init>(r3)     // Catch:{ JSONException -> 0x00cd }
            com.google.android.gms.internal.ads.zzdux r3 = r6.zza
            java.util.Map r3 = r3.zzb()
            r3.put(r1, r0)
            com.google.android.gms.internal.ads.zzdux r0 = r6.zza
            java.util.Map r0 = r0.zzb()
            com.google.android.gms.internal.ads.zzbeg r1 = com.google.android.gms.internal.ads.zzbep.zzjG
            com.google.android.gms.internal.ads.zzben r3 = com.google.android.gms.ads.internal.client.zzba.zzc()
            java.lang.Object r1 = r3.zza(r1)
            java.lang.Boolean r1 = (java.lang.Boolean) r1
            boolean r1 = r1.booleanValue()
            if (r1 != 0) goto L_0x0094
            goto L_0x00ae
        L_0x0094:
            java.lang.String r1 = "extras"
            org.json.JSONObject r1 = r2.getJSONObject(r1)     // Catch:{ JSONException -> 0x00a8 }
            java.lang.String r2 = "accept_3p_cookie"
            boolean r1 = r1.getBoolean(r2)     // Catch:{ JSONException -> 0x00a8 }
            if (r1 == 0) goto L_0x00a5
            java.lang.String r1 = "1"
            goto L_0x00b0
        L_0x00a5:
            java.lang.String r1 = "0"
            goto L_0x00b0
        L_0x00a8:
            r1 = move-exception
            java.lang.String r2 = "Error retrieving JSONObject from the requestJson, "
            com.google.android.gms.ads.internal.util.client.zzm.zzh(r2, r1)
        L_0x00ae:
            java.lang.String r1 = "na"
        L_0x00b0:
            java.lang.String r2 = "tpc"
            r0.put(r2, r1)
            com.google.android.gms.internal.ads.zzbxu r7 = r7.zzc
            if (r7 == 0) goto L_0x00c1
            com.google.android.gms.internal.ads.zzdux r0 = r6.zza
            android.os.Bundle r7 = r7.zza
            r0.zze(r7)
        L_0x00c1:
            com.google.android.gms.internal.ads.zzdvh r7 = r6.zzb
            com.google.android.gms.internal.ads.zzdux r0 = r6.zza
            java.util.Map r0 = r0.zzb()
            r7.zzf(r0)
            return
        L_0x00cd:
            r7 = move-exception
            com.google.android.gms.internal.ads.zzdux r7 = r6.zza
            java.util.Map r7 = r7.zzb()
            java.lang.String r0 = "sgf"
            r7.put(r1, r0)
            com.google.android.gms.internal.ads.zzdux r7 = r6.zza
            java.util.Map r7 = r7.zzb()
            java.lang.String r0 = "sgf_reason"
            java.lang.String r1 = "request_invalid"
            r7.put(r0, r1)
            com.google.android.gms.internal.ads.zzdvh r7 = r6.zzb
            com.google.android.gms.internal.ads.zzdux r0 = r6.zza
            java.util.Map r0 = r0.zzb()
            r7.zzf(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzduj.zze(com.google.android.gms.ads.nonagon.signalgeneration.zzax):void");
    }

    public final void zzf(String str) {
        if (((Boolean) zzba.zzc().zza(zzbep.zzhj)).booleanValue()) {
            this.zza.zzb().put("action", "sgf");
            this.zza.zzc("sgf_reason", str);
            this.zzb.zzf(this.zza.zzb());
        }
    }

    public final void zzs() {
        String str;
        this.zza.zzb().put("action", "loaded");
        if (((Boolean) zzba.zzc().zza(zzbep.zzcd)).booleanValue()) {
            this.zza.zza().putLong(zzdul.PUBLIC_API_CALLBACK.zza(), zzu.zzB().currentTimeMillis());
            zzd(this.zza.zza(), zzdum.zzb);
        }
        if (((Boolean) zzba.zzc().zza(zzbep.zzmB)).booleanValue()) {
            zzdux zzdux = this.zza;
            if (true != WebViewFeature.isFeatureSupported("MUTE_AUDIO")) {
                str = "0";
            } else {
                str = "1";
            }
            zzdux.zzb().put("mafe", str);
        }
        this.zzb.zzf(this.zza.zzb());
    }
}
