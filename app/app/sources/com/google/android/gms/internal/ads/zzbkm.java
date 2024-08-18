package com.google.android.gms.internal.ads;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.ads.internal.util.zze;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final /* synthetic */ class zzbkm implements zzblp {
    public final void zza(Object obj, Map map) {
        String str;
        zzcik zzcik = (zzcik) obj;
        zzblp zzblp = zzblo.zza;
        String str2 = (String) map.get("urls");
        if (TextUtils.isEmpty(str2)) {
            zzm.zzj("URLs missing in canOpenURLs GMSG.");
            return;
        }
        String[] split = str2.split(",");
        HashMap hashMap = new HashMap();
        PackageManager packageManager = zzcik.getContext().getPackageManager();
        for (String str3 : split) {
            String[] split2 = str3.split(";", 2);
            String trim = split2[0].trim();
            boolean z = true;
            if (split2.length > 1) {
                str = split2[1].trim();
            } else {
                str = "android.intent.action.VIEW";
            }
            if (packageManager.resolveActivity(new Intent(str, Uri.parse(trim)), 65536) == null) {
                z = false;
            }
            Boolean valueOf = Boolean.valueOf(z);
            hashMap.put(str3, valueOf);
            zze.zza("/canOpenURLs;" + str3 + ";" + valueOf);
        }
        ((zzbok) zzcik).zzd("openableURLs", hashMap);
    }
}
