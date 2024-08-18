package com.google.android.gms.ads.nonagon.signalgeneration;

import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.internal.ads.zzbep;
import com.google.android.gms.internal.ads.zzdhu;
import com.google.android.gms.internal.ads.zzdux;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzl implements zzdhu {
    private final zzdux zza;
    private final zzk zzb;
    private final String zzc;

    public zzl(zzdux zzdux, zzk zzk, String str) {
        this.zza = zzdux;
        this.zzb = zzk;
        this.zzc = str;
    }

    public final void zze(zzax zzax) {
        if (zzax != null) {
            if (((Boolean) zzba.zzc().zza(zzbep.zzhg)).booleanValue()) {
                this.zzb.zzd(this.zzc, zzax.zzb, this.zza);
            }
        }
    }

    public final void zzf(String str) {
    }
}
