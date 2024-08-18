package com.google.android.gms.ads.query;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.ads.AdFormat;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.client.zzdx;
import com.google.android.gms.ads.internal.client.zzem;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.ads.zzbep;
import com.google.android.gms.internal.ads.zzbgi;
import com.google.android.gms.internal.ads.zzbvx;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.2.0 */
public class QueryInfo {
    private final zzem zza;

    public QueryInfo(zzem zzem) {
        this.zza = zzem;
    }

    public static void generate(Context context, AdFormat adFormat, AdRequest adRequest, QueryInfoGenerationCallback callback) {
        zza(context, adFormat, adRequest, (String) null, callback);
    }

    private static void zza(Context context, AdFormat adFormat, AdRequest adRequest, String str, QueryInfoGenerationCallback queryInfoGenerationCallback) {
        zzdx zzdx;
        zzbep.zza(context);
        if (((Boolean) zzbgi.zzk.zze()).booleanValue()) {
            if (((Boolean) zzba.zzc().zza(zzbep.zzlg)).booleanValue()) {
                zzb.zzb.execute(new zza(context, adFormat, adRequest, str, queryInfoGenerationCallback));
                return;
            }
        }
        if (adRequest == null) {
            zzdx = null;
        } else {
            zzdx = adRequest.zza();
        }
        new zzbvx(context, adFormat, zzdx, str).zzb(queryInfoGenerationCallback);
    }

    public String getQuery() {
        return this.zza.zzb();
    }

    public Bundle getQueryBundle() {
        return this.zza.zza();
    }

    public String getRequestId() {
        return this.zza.zzc();
    }

    public static void generate(Context context, AdFormat adFormat, AdRequest adRequest, String adUnitId, QueryInfoGenerationCallback callback) {
        Preconditions.checkNotNull(adUnitId, "AdUnitId cannot be null.");
        zza(context, adFormat, adRequest, adUnitId, callback);
    }
}
