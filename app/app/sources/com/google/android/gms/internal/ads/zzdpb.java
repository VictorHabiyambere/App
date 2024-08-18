package com.google.android.gms.internal.ads;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.Executor;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzdpb {
    private final Executor zza;
    private final zzdow zzb;

    public zzdpb(Executor executor, zzdow zzdow) {
        this.zza = executor;
        this.zzb = zzdow;
    }

    public final ListenableFuture zza(JSONObject jSONObject, String str) {
        ListenableFuture listenableFuture;
        JSONArray optJSONArray = jSONObject.optJSONArray("custom_assets");
        if (optJSONArray == null) {
            return zzgft.zzh(Collections.emptyList());
        }
        ArrayList arrayList = new ArrayList();
        int length = optJSONArray.length();
        for (int i = 0; i < length; i++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i);
            if (optJSONObject == null) {
                listenableFuture = zzgft.zzh((Object) null);
            } else {
                String optString = optJSONObject.optString("name");
                if (optString == null) {
                    listenableFuture = zzgft.zzh((Object) null);
                } else {
                    String optString2 = optJSONObject.optString("type");
                    if (TypedValues.Custom.S_STRING.equals(optString2)) {
                        listenableFuture = zzgft.zzh(new zzdpa(optString, optJSONObject.optString("string_value")));
                    } else if ("image".equals(optString2)) {
                        listenableFuture = zzgft.zzm(this.zzb.zze(optJSONObject, "image_value"), new zzdoy(optString), this.zza);
                    } else {
                        listenableFuture = zzgft.zzh((Object) null);
                    }
                }
            }
            arrayList.add(listenableFuture);
        }
        return zzgft.zzm(zzgft.zzd(arrayList), new zzdoz(), this.zza);
    }
}
