package com.google.android.gms.internal.ads;

import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzlo {
    public final long zza;
    public final float zzb;
    public final long zzc;

    /* synthetic */ zzlo(zzlm zzlm, zzln zzln) {
        this.zza = zzlm.zza;
        this.zzb = zzlm.zzb;
        this.zzc = zzlm.zzc;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzlo)) {
            return false;
        }
        zzlo zzlo = (zzlo) obj;
        return this.zza == zzlo.zza && this.zzb == zzlo.zzb && this.zzc == zzlo.zzc;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Long.valueOf(this.zza), Float.valueOf(this.zzb), Long.valueOf(this.zzc)});
    }

    public final zzlm zza() {
        return new zzlm(this, (zzll) null);
    }
}
