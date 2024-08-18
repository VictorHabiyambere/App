package com.google.android.gms.internal.ads;

import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.text.TextUtils;
import androidx.credentials.exceptions.publickeycredential.DomExceptionUtils;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.ads.internal.zzu;
import java.net.URISyntaxException;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzblo {
    public static final zzblp zzA = new zzblc();
    public static final zzblp zzB = new zzble();
    public static final zzblp zzC = new zzblf();
    public static final zzblp zza = new zzbkm();
    public static final zzblp zzb = new zzbko();
    public static final zzblp zzc = new zzbkr();
    public static final zzblp zzd = new zzblg();
    public static final zzblp zze = new zzblh();
    public static final zzblp zzf = new zzbks();
    public static final zzblp zzg = new zzbli();
    public static final zzblp zzh = new zzblj();
    public static final zzblp zzi = new zzbkq();
    public static final zzblp zzj = new zzblk();
    public static final zzblp zzk = new zzbll();
    public static final zzblp zzl = new zzcfd();
    public static final zzblp zzm = new zzcfe();
    public static final zzblp zzn = new zzbki();
    public static final zzbmf zzo = new zzbmf();
    public static final zzblp zzp = new zzblm();
    public static final zzblp zzq = new zzbln();
    public static final zzblp zzr = new zzbkt();
    public static final zzblp zzs = new zzbku();
    public static final zzblp zzt = new zzbkv();
    public static final zzblp zzu = new zzbkw();
    public static final zzblp zzv = new zzbkx();
    public static final zzblp zzw = new zzbky();
    public static final zzblp zzx = new zzbkz();
    public static final zzblp zzy = new zzbla();
    public static final zzblp zzz = new zzblb();

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0068  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x008f  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x00bd  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.common.util.concurrent.ListenableFuture zza(com.google.android.gms.internal.ads.zzchd r5, java.lang.String r6) {
        /*
            android.net.Uri r0 = android.net.Uri.parse(r6)
            com.google.android.gms.internal.ads.zzaxd r1 = r5.zzI()     // Catch:{ zzaxe -> 0x0053 }
            com.google.android.gms.internal.ads.zzfhs r2 = r5.zzS()     // Catch:{ zzaxe -> 0x0053 }
            com.google.android.gms.internal.ads.zzbeg r3 = com.google.android.gms.internal.ads.zzbep.zzlW     // Catch:{ zzaxe -> 0x0053 }
            com.google.android.gms.internal.ads.zzben r4 = com.google.android.gms.ads.internal.client.zzba.zzc()     // Catch:{ zzaxe -> 0x0053 }
            java.lang.Object r3 = r4.zza(r3)     // Catch:{ zzaxe -> 0x0053 }
            java.lang.Boolean r3 = (java.lang.Boolean) r3     // Catch:{ zzaxe -> 0x0053 }
            boolean r3 = r3.booleanValue()     // Catch:{ zzaxe -> 0x0053 }
            if (r3 == 0) goto L_0x003a
            if (r2 == 0) goto L_0x003a
            if (r1 == 0) goto L_0x0039
            boolean r1 = r1.zzf(r0)     // Catch:{ zzaxe -> 0x0053 }
            if (r1 == 0) goto L_0x0039
            android.content.Context r1 = r5.getContext()     // Catch:{ zzaxe -> 0x0053 }
            android.view.View r3 = r5.zzF()     // Catch:{ zzaxe -> 0x0053 }
            android.app.Activity r4 = r5.zzi()     // Catch:{ zzaxe -> 0x0053 }
            android.net.Uri r0 = r2.zza(r0, r1, r3, r4)     // Catch:{ zzaxe -> 0x0053 }
            goto L_0x005d
        L_0x0039:
            goto L_0x005d
        L_0x003a:
            if (r1 == 0) goto L_0x0052
            boolean r2 = r1.zzf(r0)     // Catch:{ zzaxe -> 0x0053 }
            if (r2 == 0) goto L_0x0052
            android.content.Context r2 = r5.getContext()     // Catch:{ zzaxe -> 0x0053 }
            android.view.View r3 = r5.zzF()     // Catch:{ zzaxe -> 0x0053 }
            android.app.Activity r4 = r5.zzi()     // Catch:{ zzaxe -> 0x0053 }
            android.net.Uri r0 = r1.zza(r0, r2, r3, r4)     // Catch:{ zzaxe -> 0x0053 }
        L_0x0052:
            goto L_0x005d
        L_0x0053:
            r1 = move-exception
            java.lang.String r1 = "Unable to append parameter to URL: "
            java.lang.String r6 = r1.concat(r6)
            com.google.android.gms.ads.internal.util.client.zzm.zzj(r6)
        L_0x005d:
            java.util.HashMap r6 = new java.util.HashMap
            r6.<init>()
            com.google.android.gms.internal.ads.zzfgt r1 = r5.zzD()
            if (r1 == 0) goto L_0x006e
            com.google.android.gms.internal.ads.zzfgt r6 = r5.zzD()
            java.util.Map r6 = r6.zzax
        L_0x006e:
            android.content.Context r1 = r5.getContext()
            java.lang.String r6 = com.google.android.gms.internal.ads.zzcaw.zzb(r0, r1, r6)
            com.google.android.gms.internal.ads.zzbfv r0 = com.google.android.gms.internal.ads.zzbgj.zze
            java.lang.Object r0 = r0.zze()
            java.lang.Long r0 = (java.lang.Long) r0
            long r0 = r0.longValue()
            r2 = 0
            int r2 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r2 <= 0) goto L_0x00bd
            r2 = 241806202(0xe69ab7a, double:1.194681374E-315)
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 > 0) goto L_0x00bd
            com.google.common.util.concurrent.ListenableFuture r5 = r5.zzT()
            com.google.android.gms.internal.ads.zzgfk r5 = com.google.android.gms.internal.ads.zzgfk.zzu(r5)
            com.google.android.gms.internal.ads.zzbkj r0 = new com.google.android.gms.internal.ads.zzbkj
            r0.<init>()
            com.google.android.gms.internal.ads.zzgge r1 = com.google.android.gms.internal.ads.zzcci.zzf
            java.lang.Class<java.lang.Throwable> r2 = java.lang.Throwable.class
            com.google.common.util.concurrent.ListenableFuture r5 = com.google.android.gms.internal.ads.zzgft.zze(r5, r2, r0, r1)
            com.google.android.gms.internal.ads.zzbkk r0 = new com.google.android.gms.internal.ads.zzbkk
            r0.<init>(r6)
            com.google.android.gms.internal.ads.zzgge r1 = com.google.android.gms.internal.ads.zzcci.zzf
            com.google.common.util.concurrent.ListenableFuture r5 = com.google.android.gms.internal.ads.zzgft.zzm(r5, r0, r1)
            com.google.android.gms.internal.ads.zzbkl r0 = new com.google.android.gms.internal.ads.zzbkl
            r0.<init>(r6)
            com.google.android.gms.internal.ads.zzgge r6 = com.google.android.gms.internal.ads.zzcci.zzf
            java.lang.Class<java.lang.Throwable> r1 = java.lang.Throwable.class
            com.google.common.util.concurrent.ListenableFuture r5 = com.google.android.gms.internal.ads.zzgft.zze(r5, r1, r0, r6)
            return r5
        L_0x00bd:
            com.google.common.util.concurrent.ListenableFuture r5 = com.google.android.gms.internal.ads.zzgft.zzh(r6)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzblo.zza(com.google.android.gms.internal.ads.zzchd, java.lang.String):com.google.common.util.concurrent.ListenableFuture");
    }

    static /* synthetic */ void zzb(zzcik zzcik, Map map) {
        Intent intent;
        Intent intent2;
        PackageManager packageManager = zzcik.getContext().getPackageManager();
        try {
            try {
                JSONArray jSONArray = new JSONObject((String) map.get("data")).getJSONArray("intents");
                JSONObject jSONObject = new JSONObject();
                for (int i = 0; i < jSONArray.length(); i++) {
                    try {
                        JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                        String optString = jSONObject2.optString("id");
                        String optString2 = jSONObject2.optString("u");
                        String optString3 = jSONObject2.optString("i");
                        String optString4 = jSONObject2.optString("m");
                        String optString5 = jSONObject2.optString("p");
                        String optString6 = jSONObject2.optString("c");
                        String optString7 = jSONObject2.optString("intent_url");
                        ResolveInfo resolveInfo = null;
                        if (!TextUtils.isEmpty(optString7)) {
                            try {
                                intent = Intent.parseUri(optString7, 0);
                            } catch (URISyntaxException e) {
                                zzm.zzh("Error parsing the url: ".concat(String.valueOf(optString7)), e);
                                intent = null;
                            }
                        } else {
                            intent = null;
                        }
                        boolean z = true;
                        if (intent == null) {
                            Intent intent3 = new Intent();
                            if (!TextUtils.isEmpty(optString2)) {
                                intent3.setData(Uri.parse(optString2));
                            }
                            if (!TextUtils.isEmpty(optString3)) {
                                intent3.setAction(optString3);
                            }
                            if (!TextUtils.isEmpty(optString4)) {
                                intent3.setType(optString4);
                            }
                            if (!TextUtils.isEmpty(optString5)) {
                                intent3.setPackage(optString5);
                            }
                            if (!TextUtils.isEmpty(optString6)) {
                                String[] split = optString6.split(DomExceptionUtils.SEPARATOR, 2);
                                if (split.length == 2) {
                                    intent3.setComponent(new ComponentName(split[0], split[1]));
                                }
                            }
                            intent2 = intent3;
                        } else {
                            intent2 = intent;
                        }
                        try {
                            resolveInfo = packageManager.resolveActivity(intent2, 65536);
                        } catch (NullPointerException e2) {
                            zzu.zzo().zzw(e2, intent2.toString());
                        }
                        if (resolveInfo == null) {
                            z = false;
                        }
                        try {
                            jSONObject.put(optString, z);
                        } catch (JSONException e3) {
                            zzm.zzh("Error constructing openable urls response.", e3);
                        }
                    } catch (JSONException e4) {
                        zzm.zzh("Error parsing the intent data.", e4);
                    }
                }
                ((zzbok) zzcik).zze("openableIntents", jSONObject);
            } catch (JSONException e5) {
                ((zzbok) zzcik).zze("openableIntents", new JSONObject());
            }
        } catch (JSONException e6) {
            ((zzbok) zzcik).zze("openableIntents", new JSONObject());
        }
    }

    public static void zzc(Map map, zzdhi zzdhi) {
        if (((Boolean) zzba.zzc().zza(zzbep.zzkL)).booleanValue() && map.containsKey("sc") && ((String) map.get("sc")).equals("1") && zzdhi != null) {
            zzdhi.zzdG();
        }
    }
}
