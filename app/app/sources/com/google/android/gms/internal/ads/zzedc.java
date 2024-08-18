package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.android.gms.ads.internal.client.zzay;
import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final /* synthetic */ class zzedc implements zzgfa {
    public final /* synthetic */ zzeyv zza;
    public final /* synthetic */ zzbxu zzb;

    public /* synthetic */ zzedc(zzeyv zzeyv, zzbxu zzbxu) {
        this.zza = zzeyv;
        this.zzb = zzbxu;
    }

    public final ListenableFuture zza(Object obj) {
        return this.zza.zzb().zza(zzay.zzb().zzi((Bundle) obj), this.zzb.zzm);
    }
}
