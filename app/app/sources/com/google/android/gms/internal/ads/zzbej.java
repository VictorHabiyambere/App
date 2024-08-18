package com.google.android.gms.internal.ads;

import android.content.SharedPreferences;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.2.0 */
public final /* synthetic */ class zzbej implements zzfyw {
    public final /* synthetic */ SharedPreferences zza;

    public /* synthetic */ zzbej(SharedPreferences sharedPreferences) {
        this.zza = sharedPreferences;
    }

    public final Object zza() {
        return this.zza.getString("app_settings_json", "{}");
    }
}
