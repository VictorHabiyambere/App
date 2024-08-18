package com.google.android.gms.ads.internal.util;

import android.content.Context;
import android.content.SharedPreferences;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final /* synthetic */ class zzm implements SharedPreferences.OnSharedPreferenceChangeListener {
    public final /* synthetic */ zzt zza;
    public final /* synthetic */ Context zzb;
    public final /* synthetic */ String zzc;

    public /* synthetic */ zzm(zzt zzt, Context context, String str) {
        this.zza = zzt;
        this.zzb = context;
        this.zzc = str;
    }

    public final void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        this.zza.zzg(this.zzb, this.zzc, sharedPreferences, str);
    }
}
