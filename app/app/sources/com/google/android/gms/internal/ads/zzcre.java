package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzu;
import java.util.UUID;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzcre implements zzhkp {
    private final zzhlg zza;
    private final zzhlg zzb;
    private final zzhlg zzc;

    public zzcre(zzhlg zzhlg, zzhlg zzhlg2, zzhlg zzhlg3) {
        this.zza = zzhlg;
        this.zzb = zzhlg2;
        this.zzc = zzhlg3;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        String str = (String) this.zzc.zzb();
        boolean equals = "native".equals(str);
        zzu.zzp();
        return new zzbaj(UUID.randomUUID().toString(), ((zzcjv) this.zza).zza(), str, (JSONObject) this.zzb.zzb(), false, equals);
    }
}
