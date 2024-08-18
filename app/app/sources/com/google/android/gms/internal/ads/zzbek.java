package com.google.android.gms.internal.ads;

import android.content.SharedPreferences;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.2.0 */
public final /* synthetic */ class zzbek implements zzfyw {
    public final /* synthetic */ SharedPreferences zza;

    public /* synthetic */ zzbek(SharedPreferences sharedPreferences) {
        this.zza = sharedPreferences;
    }

    public final Object zza() {
        return this.zza.getString("flag_configuration", "{}");
    }
}
