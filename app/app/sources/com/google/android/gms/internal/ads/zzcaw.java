package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.zzu;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzcaw {
    static Uri zza(String str, String str2, String str3) {
        int indexOf = str.indexOf("&adurl");
        if (indexOf == -1) {
            indexOf = str.indexOf("?adurl");
        }
        if (indexOf == -1) {
            return Uri.parse(str).buildUpon().appendQueryParameter(str2, str3).build();
        }
        int i = indexOf + 1;
        return Uri.parse(str.substring(0, i) + str2 + "=" + str3 + "&" + str.substring(i));
    }

    public static String zzb(Uri uri, Context context, Map map) {
        if (!zzu.zzn().zzp(context)) {
            return uri.toString();
        }
        String zza = zzu.zzn().zza(context);
        if (zza == null) {
            return uri.toString();
        }
        String str = (String) zzba.zzc().zza(zzbep.zzaf);
        String uri2 = uri.toString();
        if (((Boolean) zzba.zzc().zza(zzbep.zzae)).booleanValue() && uri2.contains(str)) {
            zzu.zzn().zzj(context, zza, (Map) map.get("_ac"));
            return zzd(uri2, context).replace(str, zza);
        } else if (!TextUtils.isEmpty(uri.getQueryParameter("fbs_aeid"))) {
            return uri2;
        } else {
            if (((Boolean) zzba.zzc().zza(zzbep.zzad)).booleanValue()) {
                return uri2;
            }
            String uri3 = zza(zzd(uri2, context), "fbs_aeid", zza).toString();
            zzu.zzn().zzj(context, zza, (Map) map.get("_ac"));
            return uri3;
        }
    }

    public static String zzc(String str, Context context, boolean z, Map map) {
        String zza;
        if ((!((Boolean) zzba.zzc().zza(zzbep.zzam)).booleanValue() || z) && zzu.zzn().zzp(context) && !TextUtils.isEmpty(str) && (zza = zzu.zzn().zza(context)) != null) {
            String str2 = (String) zzba.zzc().zza(zzbep.zzaf);
            if (!((Boolean) zzba.zzc().zza(zzbep.zzae)).booleanValue() || !str.contains(str2)) {
                if (!str.contains("fbs_aeid")) {
                    if (!((Boolean) zzba.zzc().zza(zzbep.zzad)).booleanValue()) {
                        if (zzu.zzp().zzi(str)) {
                            zzu.zzn().zzj(context, zza, (Map) map.get("_ac"));
                            return zza(zzd(str, context), "fbs_aeid", zza).toString();
                        } else if (zzu.zzp().zzj(str)) {
                            zzu.zzn().zzk(context, zza, (Map) map.get("_ai"));
                            return zza(zzd(str, context), "fbs_aeid", zza).toString();
                        }
                    }
                }
            } else if (zzu.zzp().zzi(str)) {
                zzu.zzn().zzj(context, zza, (Map) map.get("_ac"));
                return zzd(str, context).replace(str2, zza);
            } else if (zzu.zzp().zzj(str)) {
                zzu.zzn().zzk(context, zza, (Map) map.get("_ai"));
                return zzd(str, context).replace(str2, zza);
            }
        }
        return str;
    }

    private static String zzd(String str, Context context) {
        String zzd = zzu.zzn().zzd(context);
        String zzb = zzu.zzn().zzb(context);
        if (!str.contains("gmp_app_id") && !TextUtils.isEmpty(zzd)) {
            str = zza(str, "gmp_app_id", zzd).toString();
        }
        return (str.contains("fbs_aiid") || TextUtils.isEmpty(zzb)) ? str : zza(str, "fbs_aiid", zzb).toString();
    }
}
