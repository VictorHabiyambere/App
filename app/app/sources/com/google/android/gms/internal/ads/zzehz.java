package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final /* synthetic */ class zzehz implements zzdjp {
    public final /* synthetic */ zzeho zza;

    public /* synthetic */ zzehz(zzeho zzeho) {
        this.zza = zzeho;
    }

    public final void zza(boolean z, Context context, zzczy zzczy) {
        zzeho zzeho = this.zza;
        try {
            ((zzfim) zzeho.zzb).zzv(z);
            ((zzfim) zzeho.zzb).zzw(context);
        } catch (zzfhv e) {
            throw new zzdjo(e.getCause());
        }
    }
}
