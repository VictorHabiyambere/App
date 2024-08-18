package com.google.android.gms.ads.internal.util;

import android.content.SharedPreferences;
import com.google.android.gms.ads.internal.zzu;
import java.util.Map;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
final class zzce implements SharedPreferences.OnSharedPreferenceChangeListener {
    final /* synthetic */ zzcf zza;
    private final String zzb;

    public zzce(zzcf zzcf, String str) {
        this.zza = zzcf;
        this.zzb = str;
    }

    public final void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        synchronized (this.zza) {
            for (zzcd zzcd : this.zza.zzb) {
                String str2 = this.zzb;
                Map map = zzcd.zza;
                if (map.containsKey(str2) && ((Set) map.get(str2)).contains(str)) {
                    zzu.zzo().zzi().zzJ(false);
                }
            }
        }
    }
}
