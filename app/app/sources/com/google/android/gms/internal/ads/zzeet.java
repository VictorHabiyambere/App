package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.client.zze;
import com.google.android.gms.ads.internal.util.zzg;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzeet implements zzdaz, zzczo {
    private static final Object zza = new Object();
    private static int zzb = 0;
    private final zzg zzc;
    private final zzefd zzd;

    public zzeet(zzefd zzefd, zzg zzg) {
        this.zzd = zzefd;
        this.zzc = zzg;
    }

    private final void zzb(boolean z) {
        int i;
        int intValue;
        if (((Boolean) zzba.zzc().zza(zzbep.zzgs)).booleanValue() && !this.zzc.zzS()) {
            synchronized (zza) {
                i = zzb;
                intValue = ((Integer) zzba.zzc().zza(zzbep.zzgt)).intValue();
            }
            if (i < intValue) {
                this.zzd.zzd(z);
                synchronized (zza) {
                    zzb++;
                }
            }
        }
    }

    public final void zzdB(zze zze) {
        zzb(false);
    }

    public final void zzs() {
        zzb(true);
    }
}
