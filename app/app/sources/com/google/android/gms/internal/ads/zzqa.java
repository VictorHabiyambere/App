package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzqa {
    public static final zzqa zza = new zzpy().zzd();
    public final boolean zzb;
    public final boolean zzc;
    public final boolean zzd;

    /* synthetic */ zzqa(zzpy zzpy, zzpz zzpz) {
        this.zzb = zzpy.zza;
        this.zzc = zzpy.zzb;
        this.zzd = zzpy.zzc;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            zzqa zzqa = (zzqa) obj;
            return this.zzb == zzqa.zzb && this.zzc == zzqa.zzc && this.zzd == zzqa.zzd;
        }
    }

    public final int hashCode() {
        boolean z = this.zzb;
        boolean z2 = this.zzc;
        return ((z ? 1 : 0) << true) + (z2 ? 1 : 0) + z2 + (this.zzd ? 1 : 0);
    }
}
