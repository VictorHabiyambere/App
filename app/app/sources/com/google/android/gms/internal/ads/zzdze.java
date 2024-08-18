package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.io.InputStream;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final /* synthetic */ class zzdze implements zzgfa {
    public final /* synthetic */ zzbxu zza;

    public /* synthetic */ zzdze(zzbxu zzbxu) {
        this.zza = zzbxu;
    }

    public final ListenableFuture zza(Object obj) {
        return zzgft.zzh(new zzebi((InputStream) obj, this.zza));
    }
}
