package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.util.zzg;
import com.google.android.gms.common.util.Clock;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
final class zzcai {
    private final Clock zza;
    private final zzg zzb;
    private final zzcau zzc;

    zzcai(Clock clock, zzg zzg, zzcau zzcau) {
        this.zza = clock;
        this.zzb = zzg;
        this.zzc = zzcau;
    }

    public final void zza(int i, long j) {
        if (!((Boolean) zzba.zzc().zza(zzbep.zzaq)).booleanValue()) {
            if (j - this.zzb.zzf() < 0) {
                zze.zza("Receiving npa decision in the past, ignoring.");
                return;
            }
            if (!((Boolean) zzba.zzc().zza(zzbep.zzar)).booleanValue()) {
                this.zzb.zzM(-1);
                this.zzb.zzN(j);
                return;
            }
            this.zzb.zzM(i);
            this.zzb.zzN(j);
        }
    }
}
