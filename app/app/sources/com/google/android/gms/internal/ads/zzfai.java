package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.zze;
import com.google.common.util.concurrent.ListenableFuture;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
final class zzfai implements zzexw {
    private final JSONObject zza;

    zzfai(Context context) {
        this.zza = zzbxq.zzc(context, VersionInfoParcel.forPackage());
    }

    public final int zza() {
        return 46;
    }

    public final ListenableFuture zzb() {
        if (((Boolean) zzba.zzc().zza(zzbep.zzlT)).booleanValue()) {
            return zzgft.zzh(new zzfag());
        }
        return zzgft.zzh(new zzfah(this));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzc(JSONObject jSONObject) {
        try {
            jSONObject.put("gms_sdk_env", this.zza);
        } catch (JSONException e) {
            zze.zza("Failed putting version constants.");
        }
    }
}
