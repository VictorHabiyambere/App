package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.zzad;
import com.google.android.gms.ads.internal.util.zzg;
import com.google.android.gms.ads.internal.zzu;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzcpj implements zzcot {
    private final Context zza;
    private final zzg zzb = zzu.zzo().zzi();

    public zzcpj(Context context) {
        this.zza = context;
    }

    public final void zza(Map map) {
        String str;
        if (!map.isEmpty() && (str = (String) map.get("gad_idless")) != null) {
            zzg zzg = this.zzb;
            boolean parseBoolean = Boolean.parseBoolean(str);
            zzg.zzI(parseBoolean);
            if (parseBoolean) {
                zzad.zzc(this.zza);
            }
        }
    }
}
