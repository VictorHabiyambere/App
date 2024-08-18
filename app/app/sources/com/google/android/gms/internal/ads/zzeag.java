package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzba;
import java.util.regex.Matcher;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
final class zzeag implements zzgfp {
    final /* synthetic */ zzeah zza;

    zzeag(zzeah zzeah) {
        this.zza = zzeah;
    }

    public final void zza(Throwable th) {
        if (((Boolean) zzba.zzc().zza(zzbep.zzgs)).booleanValue()) {
            Matcher matcher = zzeah.zza.matcher(th.getMessage());
            if (matcher.matches()) {
                this.zza.zzf.zzi(Integer.parseInt(matcher.group(1)));
            }
        }
    }

    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzfhf zzfhf = (zzfhf) obj;
        if (((Boolean) zzba.zzc().zza(zzbep.zzgs)).booleanValue()) {
            this.zza.zzf.zzi(zzfhf.zzb.zzb.zze);
            this.zza.zzf.zzj(zzfhf.zzb.zzb.zzf);
        }
    }
}
