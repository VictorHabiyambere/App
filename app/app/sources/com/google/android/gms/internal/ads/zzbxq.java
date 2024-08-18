package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.zzu;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;
import com.google.common.util.concurrent.ListenableFuture;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzbxq extends zzbxo {
    private final Object zza = new Object();
    private final Context zzb;
    private SharedPreferences zzc;
    private final zzbpx zzd;
    private final VersionInfoParcel zze;

    public zzbxq(Context context, zzbpx zzbpx, VersionInfoParcel versionInfoParcel) {
        this.zzb = context.getApplicationContext();
        this.zze = versionInfoParcel;
        this.zzd = zzbpx;
    }

    public static JSONObject zzc(Context context, VersionInfoParcel versionInfoParcel) {
        JSONObject jSONObject = new JSONObject();
        try {
            if (((Boolean) zzbgk.zzb.zze()).booleanValue()) {
                jSONObject.put("package_name", context.getPackageName());
            }
            jSONObject.put("js", versionInfoParcel.afmaVersion);
            jSONObject.put("mf", zzbgk.zzc.zze());
            jSONObject.put("cl", "636244245");
            jSONObject.put("rapid_rc", "dev");
            jSONObject.put("rapid_rollup", "HEAD");
            jSONObject.put("admob_module_version", 12451000);
            jSONObject.put("dynamite_local_version", ModuleDescriptor.MODULE_VERSION);
            jSONObject.put("dynamite_version", DynamiteModule.getRemoteVersion(context, ModuleDescriptor.MODULE_ID));
            jSONObject.put("container_version", 12451000);
        } catch (JSONException e) {
        }
        return jSONObject;
    }

    public final ListenableFuture zza() {
        synchronized (this.zza) {
            if (this.zzc == null) {
                this.zzc = this.zzb.getSharedPreferences("google_ads_flags_meta", 0);
            }
        }
        SharedPreferences sharedPreferences = this.zzc;
        long j = 0;
        if (sharedPreferences != null) {
            j = sharedPreferences.getLong("js_last_update", 0);
        }
        if (zzu.zzB().currentTimeMillis() - j < ((Long) zzbgk.zzd.zze()).longValue()) {
            return zzgft.zzh((Object) null);
        }
        return zzgft.zzm(this.zzd.zzb(zzc(this.zzb, this.zze)), new zzbxp(this), zzcci.zzf);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Void zzb(JSONObject jSONObject) {
        zzbeg zzbeg = zzbep.zza;
        zzba.zzb();
        SharedPreferences zza2 = zzbei.zza(this.zzb);
        if (zza2 == null) {
            return null;
        }
        SharedPreferences.Editor edit = zza2.edit();
        zzba.zza();
        zzbfv zzbfv = zzbga.zza;
        zzba.zza().zze(edit, 1, jSONObject);
        zzba.zzb();
        edit.commit();
        SharedPreferences sharedPreferences = this.zzc;
        if (sharedPreferences == null) {
            return null;
        }
        sharedPreferences.edit().putLong("js_last_update", zzu.zzB().currentTimeMillis()).apply();
        return null;
    }
}
