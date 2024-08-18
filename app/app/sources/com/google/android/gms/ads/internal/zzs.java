package com.google.android.gms.ads.internal;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.internal.client.zzl;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.ads.internal.util.zzad;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.internal.ads.zzbfx;
import java.util.Map;
import java.util.TreeMap;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
final class zzs {
    private final Context zza;
    private final String zzb;
    private final Map zzc = new TreeMap();
    private String zzd;
    private String zze;
    private final String zzf;

    public zzs(Context context, String str) {
        String str2;
        this.zza = context.getApplicationContext();
        this.zzb = str;
        String packageName = context.getPackageName();
        try {
            str2 = packageName + "-" + Wrappers.packageManager(context).getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            zzm.zzh("Unable to get package version name for reporting", e);
            str2 = String.valueOf(packageName).concat("-missing");
        }
        this.zzf = str2;
    }

    public final String zza() {
        return this.zzf;
    }

    public final String zzb() {
        return this.zze;
    }

    public final String zzc() {
        return this.zzb;
    }

    public final String zzd() {
        return this.zzd;
    }

    public final Map zze() {
        return this.zzc;
    }

    public final void zzf(zzl zzl, VersionInfoParcel versionInfoParcel) {
        this.zzd = zzl.zzj.zza;
        Bundle bundle = zzl.zzm;
        Bundle bundle2 = bundle != null ? bundle.getBundle(AdMobAdapter.class.getName()) : null;
        if (bundle2 != null) {
            String str = (String) zzbfx.zzc.zze();
            for (String str2 : bundle2.keySet()) {
                if (str.equals(str2)) {
                    this.zze = bundle2.getString(str2);
                } else if (str2.startsWith("csa_")) {
                    this.zzc.put(str2.substring(4), bundle2.getString(str2));
                }
            }
            this.zzc.put("SDKVersion", versionInfoParcel.afmaVersion);
            if (((Boolean) zzbfx.zza.zze()).booleanValue()) {
                Bundle zzb2 = zzad.zzb(this.zza, (String) zzbfx.zzb.zze());
                for (String str3 : zzb2.keySet()) {
                    this.zzc.put(str3, zzb2.get(str3).toString());
                }
            }
        }
    }
}
