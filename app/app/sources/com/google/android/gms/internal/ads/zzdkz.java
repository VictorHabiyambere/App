package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.zzu;
import java.util.UUID;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzdkz implements zzhkp {
    private final zzhlg zza;
    private final zzhlg zzb;

    public zzdkz(zzhlg zzhlg, zzhlg zzhlg2) {
        this.zza = zzhlg;
        this.zzb = zzhlg2;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        VersionInfoParcel zza2 = ((zzcjv) this.zza).zza();
        zzu.zzp();
        return new zzbaj(UUID.randomUUID().toString(), zza2, "native", new JSONObject(), false, true);
    }
}
