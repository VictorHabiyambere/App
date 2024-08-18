package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.util.zzad;
import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzext implements zzexw {
    private final zzgge zza;
    private final Context zzb;

    zzext(zzgge zzgge, Context context) {
        this.zza = zzgge;
        this.zzb = context;
    }

    public final int zza() {
        return 37;
    }

    public final ListenableFuture zzb() {
        return this.zza.zzb(new zzexr(this));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzexv zzc() throws Exception {
        zzbeg zzbeg = zzbep.zzgo;
        Bundle zzb2 = zzad.zzb(this.zzb, (String) zzba.zzc().zza(zzbeg));
        if (zzb2.isEmpty()) {
            return null;
        }
        return new zzexs(zzb2);
    }
}
