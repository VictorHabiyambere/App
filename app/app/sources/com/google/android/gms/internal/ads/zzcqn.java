package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzu;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
final class zzcqn implements zzgfp {
    final /* synthetic */ zzcqp zza;

    zzcqn(zzcqp zzcqp) {
        this.zza = zzcqp;
    }

    public final void zza(Throwable th) {
    }

    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzcqp zzcqp = this.zza;
        zzfia zzj = zzcqp.zzh;
        List zzd = zzcqp.zzg.zzd(zzcqp.zze, zzcqp.zzf, false, "", (String) obj, zzcqp.zzf.zzc);
        int i = 1;
        if (true == zzu.zzo().zzA(this.zza.zza)) {
            i = 2;
        }
        zzj.zzc(zzd, i);
    }
}
