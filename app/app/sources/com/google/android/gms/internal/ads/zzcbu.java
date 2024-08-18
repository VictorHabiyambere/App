package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.ads.internal.util.zzb;
import com.google.android.gms.ads.internal.zzu;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
final class zzcbu extends zzb {
    final /* synthetic */ zzcby zza;

    zzcbu(zzcby zzcby) {
        this.zza = zzcby;
    }

    public final void zza() {
        zzcby zzcby = this.zza;
        zzbes zzbes = new zzbes(zzcby.zze, zzcby.zzf.afmaVersion);
        synchronized (this.zza.zza) {
            try {
                zzu.zze();
                zzbev.zza(this.zza.zzh, zzbes);
            } catch (IllegalArgumentException e) {
                zzm.zzk("Cannot config CSI reporter.", e);
            }
        }
    }
}
