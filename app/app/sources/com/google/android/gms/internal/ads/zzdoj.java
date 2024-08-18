package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzdoj {
    private final zzgge zza;
    private final zzdow zzb;
    private final zzdpb zzc;

    public zzdoj(zzgge zzgge, zzdow zzdow, zzdpb zzdpb) {
        this.zza = zzgge;
        this.zzb = zzdow;
        this.zzc = zzdpb;
    }

    public final ListenableFuture zza(zzfhf zzfhf, zzfgt zzfgt, JSONObject jSONObject) {
        ListenableFuture listenableFuture;
        zzfhf zzfhf2 = zzfhf;
        zzfgt zzfgt2 = zzfgt;
        JSONObject jSONObject2 = jSONObject;
        ListenableFuture zzb2 = this.zza.zzb(new zzdoh(this, zzfhf2, zzfgt2, jSONObject2));
        ListenableFuture zzf = this.zzb.zzf(jSONObject2, "images");
        zzfgw zzfgw = zzfhf2.zzb.zzb;
        zzdow zzdow = this.zzb;
        ListenableFuture zzg = zzdow.zzg(jSONObject2, "images", zzfgt2, zzfgw);
        ListenableFuture zze = zzdow.zze(jSONObject2, "secondary_image");
        ListenableFuture zze2 = zzdow.zze(jSONObject2, "app_icon");
        ListenableFuture zzd = zzdow.zzd(jSONObject2, "attribution");
        ListenableFuture zzh = this.zzb.zzh(jSONObject2, zzfgt2, zzfhf2.zzb.zzb);
        ListenableFuture zza2 = this.zzc.zza(jSONObject2, "custom_assets");
        if (!jSONObject2.optBoolean("enable_omid")) {
            listenableFuture = zzgft.zzh((Object) null);
        } else {
            JSONObject optJSONObject = jSONObject2.optJSONObject("omid_settings");
            if (optJSONObject == null) {
                listenableFuture = zzgft.zzh((Object) null);
            } else {
                String optString = optJSONObject.optString("omid_html");
                if (TextUtils.isEmpty(optString)) {
                    listenableFuture = zzgft.zzh((Object) null);
                } else {
                    listenableFuture = zzgft.zzn(zzgft.zzh((Object) null), new zzdol(this.zzb, optString), zzcci.zze);
                }
            }
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(zzb2);
        arrayList.add(zzf);
        arrayList.add(zzg);
        arrayList.add(zze);
        arrayList.add(zze2);
        arrayList.add(zzd);
        arrayList.add(zzh);
        arrayList.add(zza2);
        if (!((Boolean) zzba.zzc().zza(zzbep.zzfi)).booleanValue()) {
            arrayList.add(listenableFuture);
        }
        return zzgft.zza(arrayList).zza(new zzdoi(this, zzb2, zzf, zze2, zze, zzd, jSONObject, zzh, zzg, listenableFuture, zza2), this.zza);
    }
}
