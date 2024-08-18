package com.google.android.gms.ads.internal;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.internal.ads.zzbeg;
import com.google.android.gms.internal.ads.zzbep;
import com.google.android.gms.internal.ads.zzbpx;
import com.google.android.gms.internal.ads.zzbqe;
import com.google.android.gms.internal.ads.zzcbs;
import com.google.android.gms.internal.ads.zzcci;
import com.google.android.gms.internal.ads.zzccl;
import com.google.android.gms.internal.ads.zzdvb;
import com.google.android.gms.internal.ads.zzdvc;
import com.google.android.gms.internal.ads.zzfmb;
import com.google.android.gms.internal.ads.zzfmc;
import com.google.android.gms.internal.ads.zzfmq;
import com.google.android.gms.internal.ads.zzfmu;
import com.google.android.gms.internal.ads.zzgft;
import com.google.common.util.concurrent.ListenableFuture;
import javax.annotation.ParametersAreNonnullByDefault;
import org.json.JSONObject;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzf {
    private Context zza;
    private long zzb = 0;

    static final /* synthetic */ ListenableFuture zzd(Long l, zzdvc zzdvc, zzfmq zzfmq, zzfmc zzfmc, JSONObject jSONObject) throws Exception {
        boolean optBoolean = jSONObject.optBoolean("isSuccessful", false);
        if (optBoolean) {
            zzu.zzo().zzi().zzv(jSONObject.getString("appSettingsJson"));
            if (l != null) {
                zzf(zzdvc, "cld_s", zzu.zzB().elapsedRealtime() - l.longValue());
            }
        }
        zzfmc.zzh(optBoolean);
        zzfmq.zzb(zzfmc.zzn());
        return zzgft.zzh((Object) null);
    }

    /* access modifiers changed from: private */
    public static final void zzf(zzdvc zzdvc, String str, long j) {
        if (zzdvc != null) {
            if (((Boolean) zzba.zzc().zza(zzbep.zzmD)).booleanValue()) {
                zzdvb zza2 = zzdvc.zza();
                zza2.zzb("action", "lat_init");
                zza2.zzb(str, Long.toString(j));
                zza2.zzf();
            }
        }
    }

    public final void zza(Context context, VersionInfoParcel versionInfoParcel, String str, Runnable runnable, zzfmq zzfmq, zzdvc zzdvc, Long l) {
        zzb(context, versionInfoParcel, true, (zzcbs) null, str, (String) null, runnable, zzfmq, zzdvc, l);
    }

    /* access modifiers changed from: package-private */
    public final void zzb(Context context, VersionInfoParcel versionInfoParcel, boolean z, zzcbs zzcbs, String str, String str2, Runnable runnable, zzfmq zzfmq, zzdvc zzdvc, Long l) {
        PackageInfo packageInfo;
        Context context2 = context;
        VersionInfoParcel versionInfoParcel2 = versionInfoParcel;
        Runnable runnable2 = runnable;
        zzfmq zzfmq2 = zzfmq;
        Long l2 = l;
        if (zzu.zzB().elapsedRealtime() - this.zzb < 5000) {
            zzm.zzj("Not retrying to fetch app settings");
            return;
        }
        this.zzb = zzu.zzB().elapsedRealtime();
        if (zzcbs != null && !TextUtils.isEmpty(zzcbs.zzc())) {
            if (zzu.zzB().currentTimeMillis() - zzcbs.zza() <= ((Long) zzba.zzc().zza(zzbep.zzed)).longValue() && zzcbs.zzi()) {
                return;
            }
        }
        if (context2 == null) {
            zzm.zzj("Context not provided to fetch application settings");
        } else if (!TextUtils.isEmpty(str) || !TextUtils.isEmpty(str2)) {
            Context applicationContext = context.getApplicationContext();
            if (applicationContext == null) {
                applicationContext = context2;
            }
            this.zza = applicationContext;
            zzfmc zza2 = zzfmb.zza(context, zzfmu.CUI_NAME_SDKINIT_CLD);
            zza2.zzj();
            zzbpx zza3 = zzu.zzf().zza(this.zza, versionInfoParcel, zzfmq2).zza("google.afma.config.fetchAppSettings", zzbqe.zza, zzbqe.zza);
            try {
                JSONObject jSONObject = new JSONObject();
                if (!TextUtils.isEmpty(str)) {
                    jSONObject.put("app_id", str);
                } else if (!TextUtils.isEmpty(str2)) {
                    jSONObject.put("ad_unit_id", str2);
                }
                jSONObject.put("is_init", z);
                jSONObject.put("pn", context.getPackageName());
                zzbeg zzbeg = zzbep.zza;
                jSONObject.put("experiment_ids", TextUtils.join(",", zzba.zza().zza()));
                jSONObject.put("js", versionInfoParcel2.afmaVersion);
                try {
                    ApplicationInfo applicationInfo = this.zza.getApplicationInfo();
                    if (!(applicationInfo == null || (packageInfo = Wrappers.packageManager(context).getPackageInfo(applicationInfo.packageName, 0)) == null)) {
                        jSONObject.put("version", packageInfo.versionCode);
                    }
                } catch (PackageManager.NameNotFoundException e) {
                    zze.zza("Error fetching PackageInfo.");
                }
                ListenableFuture zzb2 = zza3.zzb(jSONObject);
                ListenableFuture zzn = zzgft.zzn(zzb2, new zzd(this, l, zzdvc, zzfmq, zza2), zzcci.zzf);
                if (runnable2 != null) {
                    zzb2.addListener(runnable2, zzcci.zzf);
                }
                if (l2 != null) {
                    zzb2.addListener(new zze(this, zzdvc, l2), zzcci.zzf);
                }
                if (((Boolean) zzba.zzc().zza(zzbep.zzhP)).booleanValue()) {
                    zzccl.zzb(zzn, "ConfigLoader.maybeFetchNewAppSettings");
                } else {
                    zzccl.zza(zzn, "ConfigLoader.maybeFetchNewAppSettings");
                }
            } catch (Exception e2) {
                zzm.zzh("Error requesting application settings", e2);
                zza2.zzi(e2);
                zza2.zzh(false);
                zzfmq2.zzb(zza2.zzn());
            }
        } else {
            zzm.zzj("App settings could not be fetched. Required parameters missing");
        }
    }

    public final void zzc(Context context, VersionInfoParcel versionInfoParcel, String str, zzcbs zzcbs, zzfmq zzfmq) {
        zzb(context, versionInfoParcel, false, zzcbs, zzcbs != null ? zzcbs.zzb() : null, str, (Runnable) null, zzfmq, (zzdvc) null, (Long) null);
    }
}
