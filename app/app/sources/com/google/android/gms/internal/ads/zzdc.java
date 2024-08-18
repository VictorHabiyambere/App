package com.google.android.gms.internal.ads;

import android.util.Pair;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public abstract class zzdc {
    public static final zzdc zza = new zzcx();
    @Deprecated
    public static final zzn zzb = new zzcw();
    private static final String zzc = Integer.toString(0, 36);
    private static final String zzd = Integer.toString(1, 36);
    private static final String zze = Integer.toString(2, 36);

    protected zzdc() {
    }

    public final boolean equals(Object obj) {
        int zzh;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzdc)) {
            return false;
        }
        zzdc zzdc = (zzdc) obj;
        if (zzdc.zzc() != zzc() || zzdc.zzb() != zzb()) {
            return false;
        }
        zzdb zzdb = new zzdb();
        zzcz zzcz = new zzcz();
        zzdb zzdb2 = new zzdb();
        zzcz zzcz2 = new zzcz();
        for (int i = 0; i < zzc(); i++) {
            if (!zze(i, zzdb, 0).equals(zzdc.zze(i, zzdb2, 0))) {
                return false;
            }
        }
        for (int i2 = 0; i2 < zzb(); i2++) {
            if (!zzd(i2, zzcz, true).equals(zzdc.zzd(i2, zzcz2, true))) {
                return false;
            }
        }
        int zzg = zzg(true);
        if (zzg != zzdc.zzg(true) || (zzh = zzh(true)) != zzdc.zzh(true)) {
            return false;
        }
        while (zzg != zzh) {
            int zzj = zzj(zzg, 0, true);
            if (zzj != zzdc.zzj(zzg, 0, true)) {
                return false;
            }
            zzg = zzj;
        }
        return true;
    }

    public final int hashCode() {
        int i;
        zzdb zzdb = new zzdb();
        zzcz zzcz = new zzcz();
        int zzc2 = zzc() + 217;
        int i2 = 0;
        while (true) {
            i = zzc2 * 31;
            if (i2 >= zzc()) {
                break;
            }
            zzc2 = i + zze(i2, zzdb, 0).hashCode();
            i2++;
        }
        int zzb2 = i + zzb();
        for (int i3 = 0; i3 < zzb(); i3++) {
            zzb2 = (zzb2 * 31) + zzd(i3, zzcz, true).hashCode();
        }
        int zzg = zzg(true);
        while (zzg != -1) {
            zzb2 = (zzb2 * 31) + zzg;
            zzg = zzj(zzg, 0, true);
        }
        return zzb2;
    }

    public abstract int zza(Object obj);

    public abstract int zzb();

    public abstract int zzc();

    public abstract zzcz zzd(int i, zzcz zzcz, boolean z);

    public abstract zzdb zze(int i, zzdb zzdb, long j);

    public abstract Object zzf(int i);

    public int zzg(boolean z) {
        return zzo() ? -1 : 0;
    }

    public int zzh(boolean z) {
        if (zzo()) {
            return -1;
        }
        return zzc() - 1;
    }

    public final int zzi(int i, zzcz zzcz, zzdb zzdb, int i2, boolean z) {
        int i3 = zzd(i, zzcz, false).zzd;
        if (zze(i3, zzdb, 0).zzq != i) {
            return i + 1;
        }
        int zzj = zzj(i3, i2, z);
        if (zzj == -1) {
            return -1;
        }
        return zze(zzj, zzdb, 0).zzp;
    }

    public int zzk(int i, int i2, boolean z) {
        if (i == zzg(false)) {
            return -1;
        }
        return i - 1;
    }

    public final Pair zzl(zzdb zzdb, zzcz zzcz, int i, long j) {
        Pair zzm = zzm(zzdb, zzcz, i, j, 0);
        if (zzm != null) {
            return zzm;
        }
        throw null;
    }

    public final Pair zzm(zzdb zzdb, zzcz zzcz, int i, long j, long j2) {
        zzeq.zza(i, 0, zzc());
        zze(i, zzdb, j2);
        if (j == -9223372036854775807L) {
            long j3 = zzdb.zzn;
            j = 0;
        }
        int i2 = zzdb.zzp;
        zzd(i2, zzcz, false);
        while (i2 < zzdb.zzq) {
            long j4 = zzcz.zzf;
            int i3 = (j > 0 ? 1 : (j == 0 ? 0 : -1));
            if (i3 == 0) {
                break;
            }
            int i4 = i2 + 1;
            long j5 = zzd(i4, zzcz, false).zzf;
            if (i3 < 0) {
                break;
            }
            i2 = i4;
        }
        zzd(i2, zzcz, true);
        long j6 = zzcz.zzf;
        long j7 = zzcz.zze;
        if (j7 != -9223372036854775807L) {
            j = Math.min(j, j7 - 1);
        }
        long max = Math.max(0, j);
        Object obj = zzcz.zzc;
        if (obj != null) {
            return Pair.create(obj, Long.valueOf(max));
        }
        throw null;
    }

    public zzcz zzn(Object obj, zzcz zzcz) {
        return zzd(zza(obj), zzcz, true);
    }

    public final boolean zzo() {
        return zzc() == 0;
    }

    public int zzj(int i, int i2, boolean z) {
        switch (i2) {
            case 0:
                if (i == zzh(z)) {
                    return -1;
                }
                return i + 1;
            case 1:
                return i;
            case 2:
                return i == zzh(z) ? zzg(z) : i + 1;
            default:
                throw new IllegalStateException();
        }
    }
}
