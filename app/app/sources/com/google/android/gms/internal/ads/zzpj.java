package com.google.android.gms.internal.ads;

import android.media.metrics.LogSessionId;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzpj {
    public static final zzpj zza;
    public final String zzb;
    private final zzpi zzc;
    private final Object zzd;

    static {
        zzpj zzpj;
        if (zzgd.zza < 31) {
            zzpj = new zzpj("");
        } else {
            zzpj = new zzpj(zzpi.zza, "");
        }
        zza = zzpj;
    }

    public zzpj(LogSessionId logSessionId, String str) {
        this(new zzpi(logSessionId), str);
    }

    private zzpj(zzpi zzpi, String str) {
        this.zzc = zzpi;
        this.zzb = str;
        this.zzd = new Object();
    }

    public zzpj(String str) {
        zzeq.zzf(zzgd.zza < 31);
        this.zzb = str;
        this.zzc = null;
        this.zzd = new Object();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzpj)) {
            return false;
        }
        zzpj zzpj = (zzpj) obj;
        return Objects.equals(this.zzb, zzpj.zzb) && Objects.equals(this.zzc, zzpj.zzc) && Objects.equals(this.zzd, zzpj.zzd);
    }

    public final int hashCode() {
        return Objects.hash(new Object[]{this.zzb, this.zzc, this.zzd});
    }

    public final LogSessionId zza() {
        zzpi zzpi = this.zzc;
        if (zzpi != null) {
            return zzpi.zzb;
        }
        throw null;
    }
}
