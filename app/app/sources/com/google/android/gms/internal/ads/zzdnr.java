package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.zzu;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
final class zzdnr implements zzgfp {
    final /* synthetic */ zzdns zza;

    zzdnr(zzdns zzdns) {
        this.zza = zzdns;
    }

    public final void zza(Throwable th) {
        if (((Boolean) zzba.zzc().zza(zzbep.zzfj)).booleanValue()) {
            zzu.zzo().zzw(th, "omid native display exp");
        }
    }

    /* renamed from: zzc */
    public final void zzb(List list) {
        try {
            zzchd zzchd = (zzchd) list.get(0);
            if (zzchd != null) {
                this.zza.zzb(zzchd);
            }
        } catch (ClassCastException | IndexOutOfBoundsException e) {
            if (((Boolean) zzba.zzc().zza(zzbep.zzfj)).booleanValue()) {
                zzu.zzo().zzw(e, "omid native display exp");
            }
        }
    }
}
