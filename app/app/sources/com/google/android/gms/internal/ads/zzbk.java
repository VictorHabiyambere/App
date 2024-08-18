package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzbk {
    public static final zzbk zza = new zzbk(new zzbi());
    @Deprecated
    public static final zzn zzb = new zzbh();
    private static final String zzh = Integer.toString(0, 36);
    private static final String zzi = Integer.toString(1, 36);
    private static final String zzj = Integer.toString(2, 36);
    private static final String zzk = Integer.toString(3, 36);
    private static final String zzl = Integer.toString(4, 36);
    public final long zzc;
    public final long zzd;
    public final long zze;
    public final float zzf;
    public final float zzg;

    private zzbk(zzbi zzbi) {
        this.zzc = -9223372036854775807L;
        this.zzd = -9223372036854775807L;
        this.zze = -9223372036854775807L;
        this.zzf = -3.4028235E38f;
        this.zzg = -3.4028235E38f;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzbk)) {
            return false;
        }
        zzbk zzbk = (zzbk) obj;
        long j = zzbk.zzc;
        long j2 = zzbk.zzd;
        long j3 = zzbk.zze;
        float f = zzbk.zzf;
        float f2 = zzbk.zzg;
        return true;
    }

    public final int hashCode() {
        int i = (int) -9223372034707292159L;
        return (((((((i * 31) + i) * 31) + i) * 31) + Float.floatToIntBits(-3.4028235E38f)) * 31) + Float.floatToIntBits(-3.4028235E38f);
    }
}
