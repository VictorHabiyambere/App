package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
final class zzbni implements zzgfa {
    final /* synthetic */ zzbna zza;

    zzbni(zzbnm zzbnm, zzbna zzbna) {
        this.zza = zzbna;
    }

    public final /* bridge */ /* synthetic */ ListenableFuture zza(Object obj) throws Exception {
        zzccn zzccn = new zzccn();
        ((zzbng) obj).zze(this.zza, new zzbnh(this, zzccn));
        return zzccn;
    }
}
