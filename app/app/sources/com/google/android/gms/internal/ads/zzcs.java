package com.google.android.gms.internal.ads;

import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzcs {
    static final String zza = Integer.toString(0, 36);
    static final String zzb = Integer.toString(2, 36);
    static final String zzc = Integer.toString(3, 36);
    static final String zzd = Integer.toString(4, 36);
    @Deprecated
    public static final zzn zze = new zzcr();
    private static final String zzo = Integer.toString(1, 36);
    private static final String zzp = Integer.toString(5, 36);
    private static final String zzq = Integer.toString(6, 36);
    public final Object zzf;
    public final int zzg;
    public final zzbu zzh;
    public final Object zzi;
    public final int zzj;
    public final long zzk;
    public final long zzl;
    public final int zzm;
    public final int zzn;

    public zzcs(Object obj, int i, zzbu zzbu, Object obj2, int i2, long j, long j2, int i3, int i4) {
        this.zzf = obj;
        this.zzg = i;
        this.zzh = zzbu;
        this.zzi = obj2;
        this.zzj = i2;
        this.zzk = j;
        this.zzl = j2;
        this.zzm = i3;
        this.zzn = i4;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        zzcs zzcs = (zzcs) obj;
        return this.zzg == zzcs.zzg && this.zzj == zzcs.zzj && this.zzk == zzcs.zzk && this.zzl == zzcs.zzl && this.zzm == zzcs.zzm && this.zzn == zzcs.zzn && zzfya.zza(this.zzh, zzcs.zzh) && zzfya.zza(this.zzf, zzcs.zzf) && zzfya.zza(this.zzi, zzcs.zzi);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.zzf, Integer.valueOf(this.zzg), this.zzh, this.zzi, Integer.valueOf(this.zzj), Long.valueOf(this.zzk), Long.valueOf(this.zzl), Integer.valueOf(this.zzm), Integer.valueOf(this.zzn)});
    }
}
