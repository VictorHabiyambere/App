package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zzu;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
final class zzbya implements Callable {
    final /* synthetic */ Context zza;
    final /* synthetic */ zzbyc zzb;

    zzbya(zzbyc zzbyc, Context context) {
        this.zza = context;
        this.zzb = zzbyc;
    }

    public final /* bridge */ /* synthetic */ Object call() throws Exception {
        zzbxz zzbxz;
        zzbyb zzbyb = (zzbyb) this.zzb.zza.get(this.zza);
        if (zzbyb != null) {
            if (zzbyb.zza + ((Long) zzbfz.zza.zze()).longValue() >= zzu.zzB().currentTimeMillis()) {
                zzbxz = new zzbxy(this.zza, zzbyb.zzb).zza();
                zzbyc zzbyc = this.zzb;
                zzbyc.zza.put(this.zza, new zzbyb(zzbyc, zzbxz));
                return zzbxz;
            }
        }
        zzbxz = new zzbxy(this.zza).zza();
        zzbyc zzbyc2 = this.zzb;
        zzbyc2.zza.put(this.zza, new zzbyb(zzbyc2, zzbxz));
        return zzbxz;
    }
}
