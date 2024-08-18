package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzbbv {
    final long zza;
    final String zzb;
    final int zzc;

    zzbbv(long j, String str, int i) {
        this.zza = j;
        this.zzb = str;
        this.zzc = i;
    }

    public final boolean equals(Object obj) {
        if (obj != null && (obj instanceof zzbbv)) {
            zzbbv zzbbv = (zzbbv) obj;
            return zzbbv.zza == this.zza && zzbbv.zzc == this.zzc;
        }
    }

    public final int hashCode() {
        return (int) this.zza;
    }
}
