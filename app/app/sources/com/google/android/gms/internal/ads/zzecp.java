package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.io.InputStream;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final /* synthetic */ class zzecp implements zzgfa {
    public final /* synthetic */ zzecr zza;
    public final /* synthetic */ zzbxu zzb;

    public /* synthetic */ zzecp(zzecr zzecr, zzbxu zzbxu) {
        this.zza = zzecr;
        this.zzb = zzbxu;
    }

    public final ListenableFuture zza(Object obj) {
        return this.zza.zzd(this.zzb, (InputStream) obj);
    }
}
