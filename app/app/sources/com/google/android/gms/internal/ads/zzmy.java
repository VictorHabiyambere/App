package com.google.android.gms.internal.ads;

import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzmy {
    public final long zza;
    public final zzdc zzb;
    public final int zzc;
    public final zzvo zzd;
    public final long zze;
    public final zzdc zzf;
    public final int zzg;
    public final zzvo zzh;
    public final long zzi;
    public final long zzj;

    public zzmy(long j, zzdc zzdc, int i, zzvo zzvo, long j2, zzdc zzdc2, int i2, zzvo zzvo2, long j3, long j4) {
        this.zza = j;
        this.zzb = zzdc;
        this.zzc = i;
        this.zzd = zzvo;
        this.zze = j2;
        this.zzf = zzdc2;
        this.zzg = i2;
        this.zzh = zzvo2;
        this.zzi = j3;
        this.zzj = j4;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        zzmy zzmy = (zzmy) obj;
        return this.zza == zzmy.zza && this.zzc == zzmy.zzc && this.zze == zzmy.zze && this.zzg == zzmy.zzg && this.zzi == zzmy.zzi && this.zzj == zzmy.zzj && zzfya.zza(this.zzb, zzmy.zzb) && zzfya.zza(this.zzd, zzmy.zzd) && zzfya.zza(this.zzf, zzmy.zzf) && zzfya.zza(this.zzh, zzmy.zzh);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Long.valueOf(this.zza), this.zzb, Integer.valueOf(this.zzc), this.zzd, Long.valueOf(this.zze), this.zzf, Integer.valueOf(this.zzg), this.zzh, Long.valueOf(this.zzi), Long.valueOf(this.zzj)});
    }
}
