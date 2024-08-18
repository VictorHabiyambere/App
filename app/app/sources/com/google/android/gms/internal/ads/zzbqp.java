package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final /* synthetic */ class zzbqp implements zzgfa {
    public final /* synthetic */ String zza;
    public final /* synthetic */ zzblp zzb;

    public /* synthetic */ zzbqp(String str, zzblp zzblp) {
        this.zza = str;
        this.zzb = zzblp;
    }

    public final ListenableFuture zza(Object obj) {
        zzbpu zzbpu = (zzbpu) obj;
        zzbpu.zzq(this.zza, this.zzb);
        return zzgft.zzh(zzbpu);
    }
}
