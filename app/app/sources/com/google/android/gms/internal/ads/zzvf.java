package com.google.android.gms.internal.ads;

import android.net.Uri;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzvf {
    private static final AtomicLong zzd = new AtomicLong();
    public final zzhh zza;
    public final Uri zzb;
    public final Map zzc;

    public zzvf(long j, zzhh zzhh, Uri uri, Map map, long j2, long j3, long j4) {
        this.zza = zzhh;
        this.zzb = uri;
        this.zzc = map;
    }

    public static long zza() {
        return zzd.getAndIncrement();
    }
}
