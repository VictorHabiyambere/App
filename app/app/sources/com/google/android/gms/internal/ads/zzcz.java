package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzcz {
    @Deprecated
    public static final zzn zza = new zzcy();
    private static final String zzh = Integer.toString(0, 36);
    private static final String zzi = Integer.toString(1, 36);
    private static final String zzj = Integer.toString(2, 36);
    private static final String zzk = Integer.toString(3, 36);
    private static final String zzl = Integer.toString(4, 36);
    public Object zzb;
    public Object zzc;
    public int zzd;
    public long zze;
    public long zzf;
    public boolean zzg;
    private zzd zzm = zzd.zza;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !getClass().equals(obj.getClass())) {
            return false;
        }
        zzcz zzcz = (zzcz) obj;
        return zzgd.zzG(this.zzb, zzcz.zzb) && zzgd.zzG(this.zzc, zzcz.zzc) && this.zzd == zzcz.zzd && this.zze == zzcz.zze && this.zzg == zzcz.zzg && zzgd.zzG(this.zzm, zzcz.zzm);
    }

    public final int zza(int i) {
        return this.zzm.zza(i).zzd;
    }

    public final int zzb() {
        int i = this.zzm.zzc;
        return 0;
    }

    public final int zzc(long j) {
        return -1;
    }

    public final int zzd(long j) {
        this.zzm.zzb(-1);
        return -1;
    }

    public final int zze(int i) {
        return this.zzm.zza(i).zza(-1);
    }

    public final int zzf(int i, int i2) {
        return this.zzm.zza(i).zza(i2);
    }

    public final int zzg() {
        int i = this.zzm.zze;
        return 0;
    }

    public final long zzh(int i, int i2) {
        zzc zza2 = this.zzm.zza(i);
        if (zza2.zzd != -1) {
            return zza2.zzh[i2];
        }
        return -9223372036854775807L;
    }

    public final long zzi(int i) {
        long j = this.zzm.zza(i).zzc;
        return 0;
    }

    public final long zzj() {
        long j = this.zzm.zzd;
        return 0;
    }

    public final long zzk(int i) {
        long j = this.zzm.zza(i).zzi;
        return 0;
    }

    public final zzcz zzl(Object obj, Object obj2, int i, long j, long j2, zzd zzd2, boolean z) {
        this.zzb = obj;
        this.zzc = obj2;
        this.zzd = i;
        this.zze = j;
        this.zzf = 0;
        this.zzm = zzd2;
        this.zzg = z;
        return this;
    }

    public final boolean zzm(int i) {
        zzb();
        if (i != -1) {
            return false;
        }
        this.zzm.zzb(-1);
        return false;
    }

    public final boolean zzn(int i) {
        boolean z = this.zzm.zza(i).zzj;
        return false;
    }

    public final int hashCode() {
        int i;
        Object obj = this.zzb;
        int i2 = 0;
        if (obj == null) {
            i = 0;
        } else {
            i = obj.hashCode();
        }
        Object obj2 = this.zzc;
        if (obj2 != null) {
            i2 = obj2.hashCode();
        }
        int i3 = ((((i + 217) * 31) + i2) * 31) + this.zzd;
        long j = this.zze;
        return (((((i3 * 31) + ((int) (j ^ (j >>> 32)))) * 961) + (this.zzg ? 1 : 0)) * 31) + this.zzm.hashCode();
    }
}
