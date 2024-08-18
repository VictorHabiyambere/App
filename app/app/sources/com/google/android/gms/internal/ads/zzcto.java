package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzba;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzcto implements zzhkp {
    private final zzhlg zza;

    public zzcto(zzhlg zzhlg) {
        this.zza = zzhlg;
    }

    /* renamed from: zza */
    public final Boolean zzb() {
        boolean z = true;
        if (((zzczc) this.zza).zza().zza() == null) {
            if (!((Boolean) zzba.zzc().zza(zzbep.zzfG)).booleanValue()) {
                z = false;
            }
        }
        return Boolean.valueOf(z);
    }
}
