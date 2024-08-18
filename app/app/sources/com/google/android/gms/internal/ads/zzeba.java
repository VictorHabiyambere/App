package com.google.android.gms.internal.ads;

import android.content.Context;
import android.text.TextUtils;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
final class zzeba implements zzdcg {
    private final Context zza;
    private final zzcau zzb;

    zzeba(Context context, zzcau zzcau) {
        this.zza = context;
        this.zzb = zzcau;
    }

    public final void zzdn(zzbxu zzbxu) {
    }

    public final void zzdo(zzfhf zzfhf) {
        if (!TextUtils.isEmpty(zzfhf.zzb.zzb.zzd)) {
            this.zzb.zzm(this.zza, zzfhf.zza.zza.zzd);
            this.zzb.zzi(this.zza, zzfhf.zzb.zzb.zzd);
        }
    }
}
