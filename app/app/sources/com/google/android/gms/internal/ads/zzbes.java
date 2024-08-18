package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Build;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.util.zzt;
import com.google.android.gms.ads.internal.zzu;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.Future;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzbes {
    private final String zza = ((String) zzbge.zzb.zze());
    private final Map zzb = new LinkedHashMap();
    private final Context zzc;
    private final String zzd;

    public zzbes(Context context, String str) {
        String str2;
        this.zzc = context;
        this.zzd = str;
        this.zzb.put("s", "gmob_sdk");
        this.zzb.put("v", "3");
        this.zzb.put("os", Build.VERSION.RELEASE);
        this.zzb.put("api_v", Build.VERSION.SDK);
        Map map = this.zzb;
        zzu.zzp();
        map.put("device", zzt.zzr());
        Map map2 = this.zzb;
        if (context.getApplicationContext() != null) {
            str2 = context.getApplicationContext().getPackageName();
        } else {
            str2 = context.getPackageName();
        }
        map2.put("app", str2);
        Map map3 = this.zzb;
        zzu.zzp();
        String str3 = "0";
        map3.put("is_lite_sdk", true != zzt.zzE(context) ? str3 : "1");
        Future zzb2 = zzu.zzm().zzb(this.zzc);
        try {
            this.zzb.put("network_coarse", Integer.toString(((zzbxz) zzb2.get()).zzk));
            this.zzb.put("network_fine", Integer.toString(((zzbxz) zzb2.get()).zzl));
        } catch (Exception e) {
            zzu.zzo().zzw(e, "CsiConfiguration.CsiConfiguration");
        }
        if (((Boolean) zzba.zzc().zza(zzbep.zzlp)).booleanValue()) {
            Map map4 = this.zzb;
            zzu.zzp();
            map4.put("is_bstar", true == zzt.zzB(context) ? "1" : str3);
        }
        if (((Boolean) zzba.zzc().zza(zzbep.zzju)).booleanValue()) {
            if (((Boolean) zzba.zzc().zza(zzbep.zzck)).booleanValue() && !zzfyv.zzd(zzu.zzo().zzn())) {
                this.zzb.put("plugin", zzu.zzo().zzn());
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final Context zza() {
        return this.zzc;
    }

    /* access modifiers changed from: package-private */
    public final String zzb() {
        return this.zzd;
    }

    /* access modifiers changed from: package-private */
    public final String zzc() {
        return this.zza;
    }

    /* access modifiers changed from: package-private */
    public final Map zzd() {
        return this.zzb;
    }
}
