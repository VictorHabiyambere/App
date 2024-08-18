package com.google.android.gms.internal.ads;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.2.0 */
public final class zzbhb {
    static final AtomicBoolean zza = new AtomicBoolean();
    private static final AtomicReference zzb = new AtomicReference();
    private static final AtomicReference zzc = new AtomicReference();

    static zzbgz zza() {
        return (zzbgz) zzb.get();
    }

    static zzbha zzb() {
        return (zzbha) zzc.get();
    }

    public static void zzc(zzbgz zzbgz) {
        zzb.set(zzbgz);
    }
}
