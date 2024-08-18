package com.google.android.gms.internal.ads;

import android.content.SharedPreferences;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final /* synthetic */ class zzdvj implements SharedPreferences.OnSharedPreferenceChangeListener {
    public final /* synthetic */ zzdvk zza;
    public final /* synthetic */ String zzb;

    public /* synthetic */ zzdvj(zzdvk zzdvk, String str) {
        this.zza = zzdvk;
        this.zzb = str;
    }

    public final void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        this.zza.zzd(this.zzb, sharedPreferences, str);
    }
}
