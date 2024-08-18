package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzewo implements zzexw {
    private final String zza;
    private final String zzb;

    zzewo(String str, String str2) {
        this.zza = str;
        this.zzb = str2;
    }

    public final int zza() {
        return 31;
    }

    public final ListenableFuture zzb() {
        return zzgft.zzh(new zzewp(this.zza, this.zzb));
    }
}
