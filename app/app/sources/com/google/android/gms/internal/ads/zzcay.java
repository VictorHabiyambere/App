package com.google.android.gms.internal.ads;

import android.content.SharedPreferences;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
final class zzcay implements SharedPreferences.OnSharedPreferenceChangeListener {
    final /* synthetic */ zzcaz zza;
    private final String zzb;

    public zzcay(zzcaz zzcaz, String str) {
        this.zza = zzcaz;
        this.zzb = str;
    }

    public final void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        synchronized (this.zza) {
            for (zzcax zzcax : this.zza.zzb) {
                zzcax.zza.zzb(zzcax.zzb, sharedPreferences, this.zzb, str);
            }
        }
    }
}
