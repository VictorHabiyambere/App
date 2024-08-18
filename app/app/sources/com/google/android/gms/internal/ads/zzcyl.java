package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
final class zzcyl implements zzdaz, zzdag {
    private final Context zza;
    private final zzfgt zzb;
    private final zzbvl zzc;

    public zzcyl(Context context, zzfgt zzfgt, zzbvl zzbvl) {
        this.zza = context;
        this.zzb = zzfgt;
        this.zzc = zzbvl;
    }

    public final void zzdj(Context context) {
    }

    public final void zzdl(Context context) {
    }

    public final void zzdm(Context context) {
    }

    public final void zzs() {
        zzbvm zzbvm = this.zzb.zzae;
        if (zzbvm != null && zzbvm.zza) {
            ArrayList arrayList = new ArrayList();
            if (!this.zzb.zzae.zzb.isEmpty()) {
                arrayList.add(this.zzb.zzae.zzb);
            }
        }
    }
}
