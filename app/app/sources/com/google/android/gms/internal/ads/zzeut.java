package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.zzt;
import com.google.android.gms.ads.internal.zzu;
import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzeut implements zzexw {
    private final Context zza;
    private final zzgge zzb;

    zzeut(zzgge zzgge, Context context) {
        this.zzb = zzgge;
        this.zza = context;
    }

    public final int zza() {
        return 57;
    }

    public final ListenableFuture zzb() {
        return this.zzb.zzb(new zzeus(this));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzeuu zzc() throws Exception {
        zzu.zzp();
        return new zzeuu(zzt.zzs(this.zza));
    }
}
