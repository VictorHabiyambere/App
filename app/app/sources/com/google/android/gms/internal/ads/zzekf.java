package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzekf implements zzejz {
    private final zzdkd zza;
    private final zzgge zzb;
    private final zzdoj zzc;
    private final zzfin zzd;
    private final zzdqy zze;

    public zzekf(zzdkd zzdkd, zzgge zzgge, zzdoj zzdoj, zzfin zzfin, zzdqy zzdqy) {
        this.zza = zzdkd;
        this.zzb = zzgge;
        this.zzc = zzdoj;
        this.zzd = zzfin;
        this.zze = zzdqy;
    }

    private final ListenableFuture zzg(zzfhf zzfhf, zzfgt zzfgt, JSONObject jSONObject) {
        zzdoj zzdoj = this.zzc;
        ListenableFuture zza2 = this.zzd.zza();
        ListenableFuture zza3 = zzdoj.zza(zzfhf, zzfgt, jSONObject);
        return zzgft.zzc(zza2, zza3).zza(new zzeka(this, zza3, zza2, zzfhf, zzfgt, jSONObject), this.zzb);
    }

    public final ListenableFuture zza(zzfhf zzfhf, zzfgt zzfgt) {
        return zzgft.zzn(zzgft.zzn(this.zzd.zza(), new zzekc(this, zzfgt), this.zzb), new zzekd(this, zzfhf, zzfgt), this.zzb);
    }

    public final boolean zzb(zzfhf zzfhf, zzfgt zzfgt) {
        zzfgy zzfgy = zzfgt.zzt;
        return (zzfgy == null || zzfgy.zzc == null) ? false : true;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzdlo zzc(ListenableFuture listenableFuture, ListenableFuture listenableFuture2, zzfhf zzfhf, zzfgt zzfgt, JSONObject jSONObject) throws Exception {
        zzdlt zzdlt = (zzdlt) listenableFuture.get();
        zzdqs zzdqs = (zzdqs) listenableFuture2.get();
        zzdlu zzd2 = this.zza.zzd(new zzcvf(zzfhf, zzfgt, (String) null), new zzdmf(zzdlt), new zzdks(jSONObject, zzdqs));
        zzd2.zzh().zzb();
        zzd2.zzi().zza(zzdqs);
        zzd2.zzg().zza(zzdlt.zzs());
        zzd2.zzl().zza(this.zze, zzdlt.zzq());
        return zzd2.zza();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ ListenableFuture zzd(zzdqs zzdqs, JSONObject jSONObject) throws Exception {
        this.zzd.zzb(zzgft.zzh(zzdqs));
        if (jSONObject.optBoolean("success")) {
            return zzgft.zzh(jSONObject.getJSONObject("json").getJSONArray("ads"));
        }
        throw new zzbpw("process json failed");
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ ListenableFuture zze(zzfgt zzfgt, zzdqs zzdqs) throws Exception {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("isNonagon", true);
        if (((Boolean) zzba.zzc().zza(zzbep.zziH)).booleanValue() && PlatformVersion.isAtLeastR()) {
            jSONObject.put("skipDeepLinkValidation", true);
        }
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("response", zzfgt.zzt.zzc);
        jSONObject2.put("sdk_params", jSONObject);
        return zzgft.zzn(zzdqs.zzg("google.afma.nativeAds.preProcessJson", jSONObject2), new zzekb(this, zzdqs), this.zzb);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ ListenableFuture zzf(zzfhf zzfhf, zzfgt zzfgt, JSONArray jSONArray) throws Exception {
        if (jSONArray.length() == 0) {
            return zzgft.zzg(new zzdzd(3));
        }
        if (zzfhf.zza.zza.zzk <= 1) {
            return zzgft.zzm(zzg(zzfhf, zzfgt, jSONArray.getJSONObject(0)), new zzeke(), this.zzb);
        }
        int length = jSONArray.length();
        this.zzd.zzc(Math.min(length, zzfhf.zza.zza.zzk));
        ArrayList arrayList = new ArrayList(zzfhf.zza.zza.zzk);
        for (int i = 0; i < zzfhf.zza.zza.zzk; i++) {
            if (i < length) {
                arrayList.add(zzg(zzfhf, zzfgt, jSONArray.getJSONObject(i)));
            } else {
                arrayList.add(zzgft.zzg(new zzdzd(3)));
            }
        }
        return zzgft.zzh(arrayList);
    }
}
