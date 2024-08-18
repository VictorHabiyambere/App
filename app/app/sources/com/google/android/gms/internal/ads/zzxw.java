package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzxw {
    public final long zza;
    public final long zzb;

    public zzxw(long j, long j2) {
        this.zza = j;
        this.zzb = j2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzxw)) {
            return false;
        }
        zzxw zzxw = (zzxw) obj;
        return this.zza == zzxw.zza && this.zzb == zzxw.zzb;
    }

    public final int hashCode() {
        return (((int) this.zza) * 31) + ((int) this.zzb);
    }
}
