package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.AdFormat;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
final class zzejq implements zzdjp {
    private final zzfgt zza;
    private final zzbte zzb;
    private final AdFormat zzc;
    private zzdad zzd = null;

    zzejq(zzfgt zzfgt, zzbte zzbte, AdFormat adFormat) {
        this.zza = zzfgt;
        this.zzb = zzbte;
        this.zzc = adFormat;
    }

    public final void zza(boolean z, Context context, zzczy zzczy) throws zzdjo {
        boolean z2;
        try {
            AdFormat adFormat = AdFormat.BANNER;
            switch (this.zzc.ordinal()) {
                case 1:
                    z2 = this.zzb.zzs(ObjectWrapper.wrap(context));
                    break;
                case 2:
                    z2 = this.zzb.zzt(ObjectWrapper.wrap(context));
                    break;
                case 5:
                    z2 = this.zzb.zzr(ObjectWrapper.wrap(context));
                    break;
            }
            if (z2) {
                if (this.zzd != null) {
                    if (!((Boolean) zzba.zzc().zza(zzbep.zzbx)).booleanValue() && this.zza.zzZ == 2) {
                        this.zzd.zza();
                        return;
                    }
                    return;
                }
                return;
            }
            throw new zzdjo("Adapter failed to show.");
        } catch (Throwable th) {
            throw new zzdjo(th);
        }
    }

    public final void zzb(zzdad zzdad) {
        this.zzd = zzdad;
    }
}
