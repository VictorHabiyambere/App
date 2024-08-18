package com.google.android.gms.ads.nonagon.util.logging.csi;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.zzt;
import com.google.android.gms.ads.internal.zzu;
import com.google.android.gms.internal.ads.zzbeg;
import com.google.android.gms.internal.ads.zzbep;
import com.google.android.gms.internal.ads.zzfyv;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public class CsiParamDefaults {
    private final Context zza;
    private final String zzb;
    private final String zzc;

    public CsiParamDefaults(Context context, VersionInfoParcel versionInfo) {
        this.zza = context;
        this.zzb = context.getPackageName();
        this.zzc = versionInfo.afmaVersion;
    }

    public void set(Map<String, String> params) {
        params.put("s", "gmob_sdk");
        params.put("v", "3");
        params.put("os", Build.VERSION.RELEASE);
        params.put("api_v", Build.VERSION.SDK);
        zzu.zzp();
        params.put("device", zzt.zzr());
        params.put("app", this.zzb);
        zzu.zzp();
        String str = "0";
        params.put("is_lite_sdk", true != zzt.zzE(this.zza) ? str : "1");
        zzbeg zzbeg = zzbep.zza;
        List zzb2 = zzba.zza().zzb();
        if (((Boolean) zzba.zzc().zza(zzbep.zzhd)).booleanValue()) {
            zzb2.addAll(zzu.zzo().zzi().zzh().zzd());
        }
        params.put("e", TextUtils.join(",", zzb2));
        params.put("sdkVersion", this.zzc);
        if (((Boolean) zzba.zzc().zza(zzbep.zzlp)).booleanValue()) {
            zzu.zzp();
            if (true == zzt.zzB(this.zza)) {
                str = "1";
            }
            params.put("is_bstar", str);
        }
        if (((Boolean) zzba.zzc().zza(zzbep.zzju)).booleanValue()) {
            if (((Boolean) zzba.zzc().zza(zzbep.zzck)).booleanValue()) {
                params.put("plugin", zzfyv.zzc(zzu.zzo().zzn()));
            }
        }
    }
}
