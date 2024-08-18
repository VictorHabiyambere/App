package com.google.android.gms.internal.ads;

import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
final class zzapy {
    public final int zza;
    public final long zzb;

    private zzapy(int i, long j) {
        this.zza = i;
        this.zzb = j;
    }

    public static zzapy zza(zzadv zzadv, zzfu zzfu) throws IOException {
        ((zzadi) zzadv).zzm(zzfu.zzM(), 0, 8, false);
        zzfu.zzK(0);
        return new zzapy(zzfu.zzg(), zzfu.zzs());
    }
}
