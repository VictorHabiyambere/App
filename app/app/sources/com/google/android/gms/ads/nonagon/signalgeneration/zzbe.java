package com.google.android.gms.ads.nonagon.signalgeneration;

import android.webkit.ValueCallback;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.ads.internal.zzu;
import com.google.android.gms.ads.query.QueryInfo;
import com.google.android.gms.ads.query.QueryInfoGenerationCallback;
import com.google.android.gms.internal.ads.zzbep;
import com.google.android.gms.internal.ads.zzbgp;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
final class zzbe extends QueryInfoGenerationCallback {
    final /* synthetic */ String zza;
    final /* synthetic */ TaggingLibraryJsInterface zzb;

    zzbe(TaggingLibraryJsInterface taggingLibraryJsInterface, String str) {
        this.zza = str;
        this.zzb = taggingLibraryJsInterface;
    }

    public final void onFailure(String str) {
        long j;
        zzm.zzj("Failed to generate query info for the tagging library, error: ".concat(String.valueOf(str)));
        Locale locale = Locale.getDefault();
        String str2 = this.zza;
        if (((Boolean) zzbgp.zza.zze()).booleanValue()) {
            j = ((Long) zzba.zzc().zza(zzbep.zzjR)).longValue();
        } else {
            j = 0;
        }
        String format = String.format(locale, "window.postMessage({'paw_id': '%1$s', 'error': '%2$s', 'sdk_ttl_ms': %3$d}, '*');", new Object[]{str2, str, Long.valueOf(j)});
        if (((Boolean) zzbgp.zza.zze()).booleanValue()) {
            try {
                this.zzb.zzh.execute(new zzbc(this, format));
            } catch (RuntimeException e) {
                zzu.zzo().zzv(e, "TaggingLibraryJsInterface.getQueryInfo.onFailure");
            }
        } else {
            this.zzb.zzb.evaluateJavascript(format, (ValueCallback) null);
        }
    }

    public final void onSuccess(QueryInfo queryInfo) {
        String str;
        long j;
        String query = queryInfo.getQuery();
        long j2 = 0;
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("paw_id", this.zza);
            jSONObject.put("signal", query);
            if (((Boolean) zzbgp.zza.zze()).booleanValue()) {
                j = ((Long) zzba.zzc().zza(zzbep.zzjR)).longValue();
            } else {
                j = 0;
            }
            jSONObject.put("sdk_ttl_ms", j);
            str = String.format(Locale.getDefault(), "window.postMessage(%1$s, '*');", new Object[]{jSONObject});
        } catch (JSONException e) {
            String str2 = this.zza;
            Locale locale = Locale.getDefault();
            String query2 = queryInfo.getQuery();
            if (((Boolean) zzbgp.zza.zze()).booleanValue()) {
                j2 = ((Long) zzba.zzc().zza(zzbep.zzjR)).longValue();
            }
            str = String.format(locale, "window.postMessage({'paw_id': '%1$s', 'signal': '%2$s', 'sdk_ttl_ms': %3$d}, '*');", new Object[]{str2, query2, Long.valueOf(j2)});
        }
        if (((Boolean) zzbgp.zza.zze()).booleanValue()) {
            try {
                this.zzb.zzh.execute(new zzbd(this, str));
            } catch (RuntimeException e2) {
                zzu.zzo().zzv(e2, "TaggingLibraryJsInterface.getQueryInfo.onSuccess");
            }
        } else {
            this.zzb.zzb.evaluateJavascript(str, (ValueCallback) null);
        }
    }
}
