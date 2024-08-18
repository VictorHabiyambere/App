package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Base64;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.client.zzel;
import com.google.android.gms.ads.internal.client.zzq;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.zzbw;
import com.google.android.gms.ads.internal.zza;
import com.google.android.gms.ads.internal.zzb;
import com.google.android.gms.ads.internal.zzm;
import com.google.android.gms.ads.internal.zzu;
import com.google.android.gms.common.internal.ImagesContract;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzdow {
    private final Context zza;
    private final zzdof zzb;
    private final zzaxd zzc;
    private final VersionInfoParcel zzd;
    private final zza zze;
    private final zzbdm zzf;
    private final Executor zzg;
    private final zzbhk zzh;
    private final zzdpo zzi;
    private final zzdsd zzj;
    private final ScheduledExecutorService zzk;
    private final zzdqy zzl;
    private final zzdvc zzm;
    private final zzfoe zzn;
    private final zzefz zzo;
    private final zzegk zzp;
    private final zzfhs zzq;

    public zzdow(Context context, zzdof zzdof, zzaxd zzaxd, VersionInfoParcel versionInfoParcel, zza zza2, zzbdm zzbdm, Executor executor, zzfho zzfho, zzdpo zzdpo, zzdsd zzdsd, ScheduledExecutorService scheduledExecutorService, zzdvc zzdvc, zzfoe zzfoe, zzefz zzefz, zzdqy zzdqy, zzegk zzegk, zzfhs zzfhs) {
        this.zza = context;
        this.zzb = zzdof;
        this.zzc = zzaxd;
        this.zzd = versionInfoParcel;
        this.zze = zza2;
        this.zzf = zzbdm;
        this.zzg = executor;
        this.zzh = zzfho.zzi;
        this.zzi = zzdpo;
        this.zzj = zzdsd;
        this.zzk = scheduledExecutorService;
        this.zzm = zzdvc;
        this.zzn = zzfoe;
        this.zzo = zzefz;
        this.zzl = zzdqy;
        this.zzp = zzegk;
        this.zzq = zzfhs;
    }

    public static final zzel zzi(JSONObject jSONObject) {
        JSONObject optJSONObject;
        JSONObject optJSONObject2 = jSONObject.optJSONObject("mute");
        if (optJSONObject2 == null || (optJSONObject = optJSONObject2.optJSONObject("default_reason")) == null) {
            return null;
        }
        return zzr(optJSONObject);
    }

    public static final List zzj(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("mute");
        if (optJSONObject == null) {
            return zzgbc.zzm();
        }
        JSONArray optJSONArray = optJSONObject.optJSONArray("reasons");
        if (optJSONArray == null || optJSONArray.length() <= 0) {
            return zzgbc.zzm();
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < optJSONArray.length(); i++) {
            zzel zzr = zzr(optJSONArray.optJSONObject(i));
            if (zzr != null) {
                arrayList.add(zzr);
            }
        }
        return zzgbc.zzk(arrayList);
    }

    private final zzq zzk(int i, int i2) {
        if (i == 0) {
            if (i2 == 0) {
                return zzq.zzc();
            }
            i = 0;
        }
        return new zzq(this.zza, new AdSize(i, i2));
    }

    private static ListenableFuture zzl(ListenableFuture listenableFuture, Object obj) {
        return zzgft.zzf(listenableFuture, Exception.class, new zzdou((Object) null), zzcci.zzf);
    }

    private static ListenableFuture zzm(boolean z, ListenableFuture listenableFuture, Object obj) {
        if (z) {
            return zzgft.zzn(listenableFuture, new zzdov(listenableFuture), zzcci.zzf);
        }
        return zzl(listenableFuture, (Object) null);
    }

    private final ListenableFuture zzn(JSONObject jSONObject, boolean z) {
        if (jSONObject == null) {
            return zzgft.zzh((Object) null);
        }
        String optString = jSONObject.optString(ImagesContract.URL);
        if (TextUtils.isEmpty(optString)) {
            return zzgft.zzh((Object) null);
        }
        double optDouble = jSONObject.optDouble("scale", 1.0d);
        boolean optBoolean = jSONObject.optBoolean("is_transparent", true);
        int optInt = jSONObject.optInt("width", -1);
        int optInt2 = jSONObject.optInt("height", -1);
        if (z) {
            return zzgft.zzh(new zzbhi((Drawable) null, Uri.parse(optString), optDouble, optInt, optInt2));
        }
        return zzm(jSONObject.optBoolean("require"), zzgft.zzm(this.zzb.zzb(optString, optDouble, optBoolean), new zzdom(optString, optDouble, optInt, optInt2), this.zzg), (Object) null);
    }

    private final ListenableFuture zzo(JSONArray jSONArray, boolean z, boolean z2) {
        int i;
        if (jSONArray == null || jSONArray.length() <= 0) {
            return zzgft.zzh(Collections.emptyList());
        }
        ArrayList arrayList = new ArrayList();
        if (z2) {
            i = jSONArray.length();
        } else {
            i = 1;
        }
        for (int i2 = 0; i2 < i; i2++) {
            arrayList.add(zzn(jSONArray.optJSONObject(i2), z));
        }
        return zzgft.zzm(zzgft.zzd(arrayList), new zzdor(), this.zzg);
    }

    private final ListenableFuture zzp(JSONObject jSONObject, zzfgt zzfgt, zzfgw zzfgw) {
        ListenableFuture zzb2 = this.zzi.zzb(jSONObject.optString("base_url"), jSONObject.optString("html"), zzfgt, zzfgw, zzk(jSONObject.optInt("width", 0), jSONObject.optInt("height", 0)));
        return zzgft.zzn(zzb2, new zzdon(zzb2), zzcci.zzf);
    }

    private static Integer zzq(JSONObject jSONObject, String str) {
        try {
            JSONObject jSONObject2 = jSONObject.getJSONObject(str);
            return Integer.valueOf(Color.rgb(jSONObject2.getInt("r"), jSONObject2.getInt("g"), jSONObject2.getInt("b")));
        } catch (JSONException e) {
            return null;
        }
    }

    private static final zzel zzr(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        String optString = jSONObject.optString("reason");
        String optString2 = jSONObject.optString("ping_url");
        if (TextUtils.isEmpty(optString) || TextUtils.isEmpty(optString2)) {
            return null;
        }
        return new zzel(optString, optString2);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzbhf zza(JSONObject jSONObject, List list) {
        Integer num = null;
        if (list == null || list.isEmpty()) {
            return null;
        }
        String optString = jSONObject.optString("text");
        Integer zzq2 = zzq(jSONObject, "bg_color");
        Integer zzq3 = zzq(jSONObject, "text_color");
        int optInt = jSONObject.optInt("text_size", -1);
        boolean optBoolean = jSONObject.optBoolean("allow_pub_rendering");
        int optInt2 = jSONObject.optInt("animation_ms", 1000);
        int optInt3 = jSONObject.optInt("presentation_ms", 4000);
        if (optInt > 0) {
            num = Integer.valueOf(optInt);
        }
        return new zzbhf(optString, list, zzq2, zzq3, num, optInt3 + optInt2, this.zzh.zze, optBoolean);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ ListenableFuture zzb(zzq zzq2, zzfgt zzfgt, zzfgw zzfgw, String str, String str2, Object obj) throws Exception {
        zzchd zza2 = this.zzj.zza(zzq2, zzfgt, zzfgw);
        zzccm zza3 = zzccm.zza(zza2);
        zzdqv zzb2 = this.zzl.zzb();
        zzdqv zzdqv = zzb2;
        zzciv zzN = zza2.zzN();
        zzb zzb3 = r3;
        zzb zzb4 = new zzb(this.zza, (zzcaf) null, (zzbwx) null);
        zzN.zzR(zzb2, zzdqv, zzb2, zzb2, zzb2, false, (zzbls) null, zzb3, (zzbuk) null, (zzcaf) null, this.zzo, this.zzn, this.zzm, (zzbmj) null, zzb2, (zzbmi) null, (zzbmc) null, (zzblq) null, (zzcqd) null);
        zza2.zzag("/getNativeAdViewSignals", zzblo.zzs);
        zza2.zzag("/getNativeClickMeta", zzblo.zzt);
        zza2.zzN().zzB(new zzdoq(zza3));
        zza2.zzae(str, str2, (String) null);
        return zza3;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ ListenableFuture zzc(String str, Object obj) throws Exception {
        zzu.zzz();
        zzchd zza2 = zzchq.zza(this.zza, zzcix.zza(), "native-omid", false, false, this.zzc, (zzbfs) null, this.zzd, (zzbfe) null, (zzm) null, this.zze, this.zzf, (zzfgt) null, (zzfgw) null, this.zzp, this.zzq);
        zzccm zza3 = zzccm.zza(zza2);
        zza2.zzN().zzB(new zzdos(zza3));
        if (((Boolean) zzba.zzc().zza(zzbep.zzff)).booleanValue()) {
            zza2.loadData(Base64.encodeToString(str.getBytes(), 1), "text/html", "base64");
        } else {
            zza2.loadData(str, "text/html", "UTF-8");
        }
        return zza3;
    }

    public final ListenableFuture zzd(JSONObject jSONObject, String str) {
        JSONObject optJSONObject = jSONObject.optJSONObject("attribution");
        if (optJSONObject == null) {
            return zzgft.zzh((Object) null);
        }
        JSONArray optJSONArray = optJSONObject.optJSONArray("images");
        JSONObject optJSONObject2 = optJSONObject.optJSONObject("image");
        if (optJSONArray == null && optJSONObject2 != null) {
            optJSONArray = new JSONArray();
            optJSONArray.put(optJSONObject2);
        }
        return zzm(optJSONObject.optBoolean("require"), zzgft.zzm(zzo(optJSONArray, false, true), new zzdot(this, optJSONObject), this.zzg), (Object) null);
    }

    public final ListenableFuture zze(JSONObject jSONObject, String str) {
        return zzn(jSONObject.optJSONObject(str), this.zzh.zzb);
    }

    public final ListenableFuture zzf(JSONObject jSONObject, String str) {
        zzbhk zzbhk = this.zzh;
        return zzo(jSONObject.optJSONArray("images"), zzbhk.zzb, zzbhk.zzd);
    }

    public final ListenableFuture zzg(JSONObject jSONObject, String str, zzfgt zzfgt, zzfgw zzfgw) {
        if (!((Boolean) zzba.zzc().zza(zzbep.zzjZ)).booleanValue()) {
            return zzgft.zzh((Object) null);
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("images");
        if (optJSONArray == null || optJSONArray.length() <= 0) {
            return zzgft.zzh((Object) null);
        }
        JSONObject optJSONObject = optJSONArray.optJSONObject(0);
        if (optJSONObject == null) {
            return zzgft.zzh((Object) null);
        }
        String optString = optJSONObject.optString("base_url");
        String optString2 = optJSONObject.optString("html");
        zzq zzk2 = zzk(optJSONObject.optInt("width", 0), optJSONObject.optInt("height", 0));
        if (TextUtils.isEmpty(optString2)) {
            return zzgft.zzh((Object) null);
        }
        ListenableFuture zzn2 = zzgft.zzn(zzgft.zzh((Object) null), new zzdoo(this, zzk2, zzfgt, zzfgw, optString, optString2), zzcci.zze);
        return zzgft.zzn(zzn2, new zzdop(zzn2), zzcci.zzf);
    }

    public final ListenableFuture zzh(JSONObject jSONObject, zzfgt zzfgt, zzfgw zzfgw) {
        ListenableFuture listenableFuture;
        boolean z = false;
        JSONObject zzh2 = zzbw.zzh(jSONObject, "html_containers", "instream");
        if (zzh2 != null) {
            return zzp(zzh2, zzfgt, zzfgw);
        }
        JSONObject optJSONObject = jSONObject.optJSONObject("video");
        if (optJSONObject == null) {
            return zzgft.zzh((Object) null);
        }
        String optString = optJSONObject.optString("vast_xml");
        if (((Boolean) zzba.zzc().zza(zzbep.zzjY)).booleanValue() && optJSONObject.has("html")) {
            z = true;
        }
        if (TextUtils.isEmpty(optString)) {
            if (!z) {
                com.google.android.gms.ads.internal.util.client.zzm.zzj("Required field 'vast_xml' or 'html' is missing");
                return zzgft.zzh((Object) null);
            }
        } else if (!z) {
            listenableFuture = this.zzi.zza(optJSONObject);
            return zzl(zzgft.zzo(listenableFuture, (long) ((Integer) zzba.zzc().zza(zzbep.zzdN)).intValue(), TimeUnit.SECONDS, this.zzk), (Object) null);
        }
        listenableFuture = zzp(optJSONObject, zzfgt, zzfgw);
        return zzl(zzgft.zzo(listenableFuture, (long) ((Integer) zzba.zzc().zza(zzbep.zzdN)).intValue(), TimeUnit.SECONDS, this.zzk), (Object) null);
    }
}
