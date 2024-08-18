package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final /* synthetic */ class zzelr implements zzdjp {
    public final /* synthetic */ zzeho zza;

    public /* synthetic */ zzelr(zzeho zzeho) {
        this.zza = zzeho;
    }

    public final void zza(boolean z, Context context, zzczy zzczy) {
        zzeho zzeho = this.zza;
        try {
            ((zzfim) zzeho.zzb).zzv(z);
            ((zzfim) zzeho.zzb).zzz(context);
        } catch (zzfhv e) {
            throw new zzdjo(e.getCause());
        }
    }
}
