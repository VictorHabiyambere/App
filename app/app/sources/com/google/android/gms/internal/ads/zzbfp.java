package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.ads.query.QueryInfo;
import com.google.android.gms.ads.query.QueryInfoGenerationCallback;
import org.json.JSONException;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
final class zzbfp extends QueryInfoGenerationCallback {
    final /* synthetic */ String zza;
    final /* synthetic */ zzbfq zzb;

    zzbfp(zzbfq zzbfq, String str) {
        this.zza = str;
        this.zzb = zzbfq;
    }

    public final void onFailure(String str) {
        zzm.zzj("Failed to generate query info for Custom Tab error: ".concat(String.valueOf(str)));
        try {
            zzbfq zzbfq = this.zzb;
            zzbfq.zze.postMessage(zzbfq.zzc(this.zza, str).toString(), (Bundle) null);
        } catch (JSONException e) {
            zzm.zzh("Error creating PACT Error Response JSON: ", e);
        }
    }

    public final void onSuccess(QueryInfo queryInfo) {
        String query = queryInfo.getQuery();
        try {
            zzbfq zzbfq = this.zzb;
            zzbfq.zze.postMessage(zzbfq.zzd(this.zza, query).toString(), (Bundle) null);
        } catch (JSONException e) {
            zzm.zzh("Error creating PACT Signal Response JSON: ", e);
        }
    }
}
