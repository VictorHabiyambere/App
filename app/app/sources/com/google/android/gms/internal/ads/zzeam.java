package com.google.android.gms.internal.ads;

import android.content.Context;
import androidx.core.os.EnvironmentCompat;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.ads.internal.zzu;
import com.google.common.util.concurrent.ListenableFuture;
import java.io.StringReader;
import java.util.concurrent.Executor;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzeam {
    private final zzcjd zza;
    private final Context zzb;
    private final VersionInfoParcel zzc;
    private final zzfho zzd;
    private final Executor zze;
    private final String zzf;
    private final zzfmn zzg;
    private final zzfid zzh;
    private final zzdux zzi;

    public zzeam(zzcjd zzcjd, Context context, VersionInfoParcel versionInfoParcel, zzfho zzfho, Executor executor, String str, zzfmn zzfmn, zzdux zzdux) {
        this.zza = zzcjd;
        this.zzb = context;
        this.zzc = versionInfoParcel;
        this.zzd = zzfho;
        this.zze = executor;
        this.zzf = str;
        this.zzg = zzfmn;
        this.zzh = zzcjd.zzx();
        this.zzi = zzdux;
    }

    private final ListenableFuture zzc(String str, String str2) {
        zzfmc zza2 = zzfmb.zza(this.zzb, zzfmu.CUI_NAME_ADREQUEST_PARSERESPONSE);
        zza2.zzj();
        ListenableFuture zzn = zzgft.zzn(zzgft.zzn(zzgft.zzn(zzgft.zzh(""), new zzeaj(this, str, str2), this.zze), new zzeak(zzu.zzf().zza(this.zzb, this.zzc, this.zza.zzz()).zza("google.afma.response.normalize", zzbqe.zza, zzbqe.zza)), this.zze), new zzeal(this), this.zze);
        zzfmm.zzb(zzn, this.zzg, zza2);
        return zzn;
    }

    private final String zzd(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            JSONArray jSONArray = jSONObject.getJSONArray("ad_types");
            if (jSONArray != null && EnvironmentCompat.MEDIA_UNKNOWN.equals(jSONArray.getString(0))) {
                jSONObject.put("ad_types", new JSONArray().put(this.zzf));
            }
            return jSONObject.toString();
        } catch (JSONException e) {
            zzm.zzj("Failed to update the ad types for rendering. ".concat(e.toString()));
            return str;
        }
    }

    private static final String zze(String str) {
        try {
            return new JSONObject(str).optString("request_id", "");
        } catch (JSONException e) {
            return "";
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x00ad  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.common.util.concurrent.ListenableFuture zza() {
        /*
            r10 = this;
            com.google.android.gms.internal.ads.zzfho r0 = r10.zzd
            com.google.android.gms.ads.internal.client.zzl r0 = r0.zzd
            java.lang.String r0 = r0.zzx
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            java.lang.String r2 = "true"
            if (r1 != 0) goto L_0x0121
            com.google.android.gms.internal.ads.zzbeg r1 = com.google.android.gms.internal.ads.zzbep.zzhg
            com.google.android.gms.internal.ads.zzben r3 = com.google.android.gms.ads.internal.client.zzba.zzc()
            java.lang.Object r1 = r3.zza(r1)
            java.lang.Boolean r1 = (java.lang.Boolean) r1
            boolean r1 = r1.booleanValue()
            if (r1 == 0) goto L_0x0121
            java.lang.String r1 = zze(r0)
            com.google.android.gms.internal.ads.zzbeg r3 = com.google.android.gms.internal.ads.zzbep.zzhr
            com.google.android.gms.internal.ads.zzben r4 = com.google.android.gms.ads.internal.client.zzba.zzc()
            java.lang.Object r3 = r4.zza(r3)
            java.lang.Boolean r3 = (java.lang.Boolean) r3
            boolean r3 = r3.booleanValue()
            r4 = -1
            if (r3 == 0) goto L_0x004e
            boolean r3 = r1.isEmpty()
            if (r3 == 0) goto L_0x004e
            java.lang.String r1 = "&request_id="
            int r1 = r0.lastIndexOf(r1)
            if (r1 == r4) goto L_0x004c
            int r1 = r1 + 12
            java.lang.String r1 = r0.substring(r1)
            goto L_0x004e
        L_0x004c:
            java.lang.String r1 = ""
        L_0x004e:
            boolean r3 = android.text.TextUtils.isEmpty(r1)
            if (r3 == 0) goto L_0x0062
            com.google.android.gms.internal.ads.zzelj r0 = new com.google.android.gms.internal.ads.zzelj
            r1 = 15
            java.lang.String r2 = "Invalid ad string."
            r0.<init>(r1, r2)
            com.google.common.util.concurrent.ListenableFuture r0 = com.google.android.gms.internal.ads.zzgft.zzg(r0)
            return r0
        L_0x0062:
            com.google.android.gms.internal.ads.zzcjd r3 = r10.zza
            com.google.android.gms.internal.ads.zzdux r5 = r10.zzi
            com.google.android.gms.ads.nonagon.signalgeneration.zzk r3 = r3.zzo()
            java.lang.String r3 = r3.zzb(r1, r5)
            com.google.android.gms.internal.ads.zzbeg r5 = com.google.android.gms.internal.ads.zzbep.zzhr
            com.google.android.gms.internal.ads.zzben r6 = com.google.android.gms.ads.internal.client.zzba.zzc()
            java.lang.Object r5 = r6.zza(r5)
            java.lang.Boolean r5 = (java.lang.Boolean) r5
            boolean r5 = r5.booleanValue()
            if (r5 == 0) goto L_0x0110
            com.google.android.gms.internal.ads.zzdux r5 = r10.zzi
            boolean r6 = android.text.TextUtils.isEmpty(r3)
            if (r6 != 0) goto L_0x0110
            r6 = 0
            org.json.JSONObject r7 = new org.json.JSONObject     // Catch:{ JSONException -> 0x00a0 }
            r7.<init>(r3)     // Catch:{ JSONException -> 0x00a0 }
            java.lang.String r8 = "is_gbid"
            java.lang.String r7 = r7.optString(r8)     // Catch:{ JSONException -> 0x00a0 }
            boolean r7 = r7.equals(r2)     // Catch:{ JSONException -> 0x00a0 }
            if (r7 == 0) goto L_0x00a1
            r7 = 1
            java.lang.Boolean r7 = java.lang.Boolean.valueOf(r7)     // Catch:{ JSONException -> 0x00a0 }
            goto L_0x00a6
        L_0x00a0:
            r7 = move-exception
        L_0x00a1:
            java.lang.Boolean r7 = java.lang.Boolean.valueOf(r6)
        L_0x00a6:
            boolean r7 = r7.booleanValue()
            if (r7 != 0) goto L_0x00ad
            goto L_0x0111
        L_0x00ad:
            java.lang.String r7 = "&"
            int r7 = r0.lastIndexOf(r7)
            r8 = 0
            if (r7 == r4) goto L_0x00bc
            java.lang.String r4 = r0.substring(r6, r7)
            goto L_0x00bd
        L_0x00bc:
            r4 = r8
        L_0x00bd:
            boolean r6 = android.text.TextUtils.isEmpty(r4)
            if (r6 == 0) goto L_0x00c4
            goto L_0x0111
        L_0x00c4:
            r6 = 11
            byte[] r4 = android.util.Base64.decode(r4, r6)     // Catch:{ UnsupportedEncodingException -> 0x00f8 }
            java.lang.String r6 = "UTF-8"
            byte[] r1 = r1.getBytes(r6)     // Catch:{ UnsupportedEncodingException -> 0x00f8 }
            org.json.JSONObject r6 = new org.json.JSONObject     // Catch:{ JSONException -> 0x00dc }
            r6.<init>(r3)     // Catch:{ JSONException -> 0x00dc }
            java.lang.String r7 = "arek"
            java.lang.String r8 = r6.getString(r7)     // Catch:{ JSONException -> 0x00dc }
            goto L_0x00f3
        L_0x00dc:
            r6 = move-exception
            java.lang.String r7 = r6.toString()     // Catch:{ UnsupportedEncodingException -> 0x00f8 }
            java.lang.String r9 = "Failed to get key from QueryJSONMap"
            java.lang.String r7 = r9.concat(r7)     // Catch:{ UnsupportedEncodingException -> 0x00f8 }
            com.google.android.gms.ads.internal.util.zze.zza(r7)     // Catch:{ UnsupportedEncodingException -> 0x00f8 }
            com.google.android.gms.internal.ads.zzcby r7 = com.google.android.gms.ads.internal.zzu.zzo()     // Catch:{ UnsupportedEncodingException -> 0x00f8 }
            java.lang.String r9 = "CryptoUtils.getKeyFromQueryJsonMap"
            r7.zzw(r6, r9)     // Catch:{ UnsupportedEncodingException -> 0x00f8 }
        L_0x00f3:
            java.lang.String r0 = com.google.android.gms.internal.ads.zzfid.zzb(r4, r1, r8, r5)     // Catch:{ UnsupportedEncodingException -> 0x00f8 }
            goto L_0x0111
        L_0x00f8:
            r1 = move-exception
            java.lang.String r4 = r1.toString()
            java.lang.String r5 = "Failed to decode the adResponse. "
            java.lang.String r4 = r5.concat(r4)
            com.google.android.gms.ads.internal.util.zze.zza(r4)
            com.google.android.gms.internal.ads.zzcby r4 = com.google.android.gms.ads.internal.zzu.zzo()
            java.lang.String r5 = "PreloadedLoader.decryptAdResponseIfNecessary"
            r4.zzw(r1, r5)
            goto L_0x0111
        L_0x0110:
        L_0x0111:
            boolean r1 = android.text.TextUtils.isEmpty(r3)
            if (r1 == 0) goto L_0x0118
            goto L_0x0121
        L_0x0118:
            java.lang.String r1 = r10.zzd(r3)
            com.google.common.util.concurrent.ListenableFuture r0 = r10.zzc(r0, r1)
            return r0
        L_0x0121:
            com.google.android.gms.internal.ads.zzfho r0 = r10.zzd
            com.google.android.gms.ads.internal.client.zzl r0 = r0.zzd
            com.google.android.gms.ads.internal.client.zzc r0 = r0.zzs
            if (r0 == 0) goto L_0x0180
            com.google.android.gms.internal.ads.zzbeg r1 = com.google.android.gms.internal.ads.zzbep.zzhe
            com.google.android.gms.internal.ads.zzben r3 = com.google.android.gms.ads.internal.client.zzba.zzc()
            java.lang.Object r1 = r3.zza(r1)
            java.lang.Boolean r1 = (java.lang.Boolean) r1
            boolean r1 = r1.booleanValue()
            if (r1 != 0) goto L_0x013c
            goto L_0x0168
        L_0x013c:
            java.lang.String r1 = r0.zza
            java.lang.String r3 = r0.zzb
            java.lang.String r1 = zze(r1)
            java.lang.String r3 = zze(r3)
            boolean r4 = android.text.TextUtils.isEmpty(r3)
            if (r4 != 0) goto L_0x0175
            boolean r3 = r1.equals(r3)
            if (r3 == 0) goto L_0x0175
            com.google.android.gms.internal.ads.zzcjd r2 = r10.zza
            com.google.android.gms.ads.nonagon.signalgeneration.zzk r2 = r2.zzo()
            r2.zzf(r1)
            com.google.android.gms.internal.ads.zzdux r2 = r10.zzi
            java.util.Map r2 = r2.zzb()
            java.lang.String r3 = "request_id"
            r2.put(r3, r1)
        L_0x0168:
            java.lang.String r1 = r0.zza
            java.lang.String r0 = r0.zzb
            java.lang.String r0 = r10.zzd(r0)
            com.google.common.util.concurrent.ListenableFuture r0 = r10.zzc(r1, r0)
            return r0
        L_0x0175:
            com.google.android.gms.internal.ads.zzdux r0 = r10.zzi
            java.util.Map r0 = r0.zzb()
            java.lang.String r1 = "ridmm"
            r0.put(r1, r2)
        L_0x0180:
            com.google.android.gms.internal.ads.zzelj r0 = new com.google.android.gms.internal.ads.zzelj
            r1 = 14
            java.lang.String r2 = "Mismatch request IDs."
            r0.<init>(r1, r2)
            com.google.common.util.concurrent.ListenableFuture r0 = com.google.android.gms.internal.ads.zzgft.zzg(r0)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzeam.zza():com.google.common.util.concurrent.ListenableFuture");
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ ListenableFuture zzb(JSONObject jSONObject) throws Exception {
        return zzgft.zzh(new zzfhf(new zzfhc(this.zzd), zzfhe.zza(new StringReader(jSONObject.toString()), (zzbxu) null)));
    }
}
