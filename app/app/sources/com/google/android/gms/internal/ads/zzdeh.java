package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzba;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzdeh implements zzdcg {
    private int zza = ((Integer) zzba.zzc().zza(zzbep.zzbh)).intValue();

    public final synchronized int zzc() {
        return this.zza;
    }

    public final void zzdn(zzbxu zzbxu) {
    }

    public final synchronized void zzdo(zzfhf zzfhf) {
        if (((Boolean) zzba.zzc().zza(zzbep.zzbi)).booleanValue()) {
            try {
                this.zza = zzfhf.zzb.zzb.zzc;
            } catch (NullPointerException e) {
            }
        }
    }
}
