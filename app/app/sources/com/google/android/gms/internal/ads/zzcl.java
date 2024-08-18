package com.google.android.gms.internal.ads;

import java.util.Locale;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzcl {
    public static final zzcl zza = new zzcl(1.0f, 1.0f);
    @Deprecated
    public static final zzn zzb = new zzck();
    private static final String zze = Integer.toString(0, 36);
    private static final String zzf = Integer.toString(1, 36);
    public final float zzc;
    public final float zzd;
    private final int zzg;

    public zzcl(float f, float f2) {
        boolean z;
        boolean z2 = true;
        if (f > 0.0f) {
            z = true;
        } else {
            z = false;
        }
        zzeq.zzd(z);
        zzeq.zzd(f2 <= 0.0f ? false : z2);
        this.zzc = f;
        this.zzd = f2;
        this.zzg = Math.round(f * 1000.0f);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            zzcl zzcl = (zzcl) obj;
            return this.zzc == zzcl.zzc && this.zzd == zzcl.zzd;
        }
    }

    public final int hashCode() {
        return ((Float.floatToRawIntBits(this.zzc) + 527) * 31) + Float.floatToRawIntBits(this.zzd);
    }

    public final String toString() {
        return String.format(Locale.US, "PlaybackParameters(speed=%.2f, pitch=%.2f)", new Object[]{Float.valueOf(this.zzc), Float.valueOf(this.zzd)});
    }

    public final long zza(long j) {
        return j * ((long) this.zzg);
    }
}
