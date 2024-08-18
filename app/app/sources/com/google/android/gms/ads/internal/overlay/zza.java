package com.google.android.gms.ads.internal.overlay;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import androidx.credentials.exceptions.publickeycredential.DomExceptionUtils;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.util.zzt;
import com.google.android.gms.ads.internal.zzu;
import com.google.android.gms.internal.ads.zzbep;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zza {
    public static final boolean zza(Context context, Intent intent, zzaa zzaa, zzy zzy, boolean z) {
        if (z) {
            return zzc(context, intent.getData(), zzaa, zzy);
        }
        try {
            String uri = intent.toURI();
            zze.zza("Launching an intent: " + uri);
            zzu.zzp();
            zzt.zzT(context, intent);
            if (zzaa != null) {
                zzaa.zzg();
            }
            if (zzy != null) {
                zzy.zza(true);
            }
            return true;
        } catch (ActivityNotFoundException e) {
            zzm.zzj(e.getMessage());
            if (zzy != null) {
                zzy.zza(false);
            }
            return false;
        }
    }

    public static final boolean zzb(Context context, zzc zzc, zzaa zzaa, zzy zzy) {
        int i = 0;
        if (zzc == null) {
            zzm.zzj("No intent data for launcher overlay.");
            return false;
        }
        zzbep.zza(context);
        Intent intent = zzc.zzh;
        if (intent != null) {
            return zza(context, intent, zzaa, zzy, zzc.zzj);
        }
        Intent intent2 = new Intent();
        if (TextUtils.isEmpty(zzc.zzb)) {
            zzm.zzj("Open GMSG did not contain a URL.");
            return false;
        }
        if (!TextUtils.isEmpty(zzc.zzc)) {
            String str = zzc.zzb;
            intent2.setDataAndType(Uri.parse(str), zzc.zzc);
        } else {
            intent2.setData(Uri.parse(zzc.zzb));
        }
        intent2.setAction("android.intent.action.VIEW");
        if (!TextUtils.isEmpty(zzc.zzd)) {
            intent2.setPackage(zzc.zzd);
        }
        if (!TextUtils.isEmpty(zzc.zze)) {
            String[] split = zzc.zze.split(DomExceptionUtils.SEPARATOR, 2);
            if (split.length < 2) {
                zzm.zzj("Could not parse component name from open GMSG: ".concat(String.valueOf(zzc.zze)));
                return false;
            }
            intent2.setClassName(split[0], split[1]);
        }
        String str2 = zzc.zzf;
        if (!TextUtils.isEmpty(str2)) {
            try {
                i = Integer.parseInt(str2);
            } catch (NumberFormatException e) {
                zzm.zzj("Could not parse intent flags.");
            }
            intent2.addFlags(i);
        }
        if (((Boolean) zzba.zzc().zza(zzbep.zzeA)).booleanValue()) {
            intent2.addFlags(268435456);
            intent2.putExtra("android.support.customtabs.extra.user_opt_out", true);
        } else {
            if (((Boolean) zzba.zzc().zza(zzbep.zzez)).booleanValue()) {
                zzu.zzp();
                zzt.zzo(context, intent2);
            }
        }
        return zza(context, intent2, zzaa, zzy, zzc.zzj);
    }

    private static final boolean zzc(Context context, Uri uri, zzaa zzaa, zzy zzy) {
        int i;
        try {
            i = zzu.zzp().zzm(context, uri);
            if (zzaa != null) {
                zzaa.zzg();
            }
        } catch (ActivityNotFoundException e) {
            zzm.zzj(e.getMessage());
            i = 6;
        }
        if (zzy != null) {
            zzy.zzb(i);
        }
        return i == 5;
    }
}
