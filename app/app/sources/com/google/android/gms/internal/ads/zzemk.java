package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.client.zzm;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final /* synthetic */ class zzemk implements zzdjp {
    public final /* synthetic */ zzeho zza;

    public /* synthetic */ zzemk(zzeho zzeho) {
        this.zza = zzeho;
    }

    public final void zza(boolean z, Context context, zzczy zzczy) {
        zzeho zzeho = this.zza;
        try {
            ((zzfim) zzeho.zzb).zzv(z);
            ((zzfim) zzeho.zzb).zzA();
        } catch (zzfhv e) {
            zzm.zzk("Cannot show rewarded video.", e);
            throw new zzdjo(e.getCause());
        }
    }
}
