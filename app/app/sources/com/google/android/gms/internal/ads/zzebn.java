package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.io.InputStream;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final /* synthetic */ class zzebn implements zzgfa {
    public final /* synthetic */ zzbxu zza;

    public /* synthetic */ zzebn(zzbxu zzbxu) {
        this.zza = zzbxu;
    }

    public final ListenableFuture zza(Object obj) {
        String str = new String(zzgdm.zzb((InputStream) obj), zzfxs.zzc);
        zzbxu zzbxu = this.zza;
        zzbxu.zzj = str;
        return zzgft.zzh(zzbxu);
    }
}
