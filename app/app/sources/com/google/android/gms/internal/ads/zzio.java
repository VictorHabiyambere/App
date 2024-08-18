package com.google.android.gms.internal.ads;

import android.util.Pair;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public abstract class zzio extends zzdc {
    private final int zzc;
    private final zzxi zzd;

    public zzio(boolean z, zzxi zzxi) {
        this.zzd = zzxi;
        this.zzc = zzxi.zzc();
    }

    private final int zzw(int i, boolean z) {
        if (z) {
            return this.zzd.zzd(i);
        }
        if (i >= this.zzc - 1) {
            return -1;
        }
        return i + 1;
    }

    private final int zzx(int i, boolean z) {
        if (z) {
            return this.zzd.zze(i);
        }
        if (i <= 0) {
            return -1;
        }
        return i - 1;
    }

    public final int zza(Object obj) {
        int zza;
        if (obj instanceof Pair) {
            Pair pair = (Pair) obj;
            Object obj2 = pair.first;
            Object obj3 = pair.second;
            int zzp = zzp(obj2);
            if (!(zzp == -1 || (zza = zzu(zzp).zza(obj3)) == -1)) {
                return zzs(zzp) + zza;
            }
        }
        return -1;
    }

    public final zzcz zzd(int i, zzcz zzcz, boolean z) {
        int zzq = zzq(i);
        int zzt = zzt(zzq);
        zzu(zzq).zzd(i - zzs(zzq), zzcz, z);
        zzcz.zzd += zzt;
        if (z) {
            Object zzv = zzv(zzq);
            Object obj = zzcz.zzc;
            if (obj != null) {
                zzcz.zzc = Pair.create(zzv, obj);
            } else {
                throw null;
            }
        }
        return zzcz;
    }

    public final zzdb zze(int i, zzdb zzdb, long j) {
        int zzr = zzr(i);
        int zzt = zzt(zzr);
        int zzs = zzs(zzr);
        zzu(zzr).zze(i - zzt, zzdb, j);
        Object zzv = zzv(zzr);
        if (!zzdb.zza.equals(zzdb.zzc)) {
            zzv = Pair.create(zzv, zzdb.zzc);
        }
        zzdb.zzc = zzv;
        zzdb.zzp += zzs;
        zzdb.zzq += zzs;
        return zzdb;
    }

    public final Object zzf(int i) {
        int zzq = zzq(i);
        return Pair.create(zzv(zzq), zzu(zzq).zzf(i - zzs(zzq)));
    }

    public final int zzg(boolean z) {
        int i;
        if (this.zzc != 0) {
            if (z) {
                i = this.zzd.zza();
            } else {
                i = 0;
            }
            while (zzu(i).zzo()) {
                i = zzw(i, z);
                if (i == -1) {
                }
            }
            return zzt(i) + zzu(i).zzg(z);
        }
        return -1;
    }

    public final int zzh(boolean z) {
        int i;
        int i2 = this.zzc;
        if (i2 != 0) {
            if (z) {
                i = this.zzd.zzb();
            } else {
                i = i2 - 1;
            }
            while (zzu(i).zzo()) {
                i = zzx(i, z);
                if (i == -1) {
                }
            }
            return zzt(i) + zzu(i).zzh(z);
        }
        return -1;
    }

    public final int zzj(int i, int i2, boolean z) {
        int i3;
        int zzr = zzr(i);
        int zzt = zzt(zzr);
        zzdc zzu = zzu(zzr);
        int i4 = i - zzt;
        if (i2 == 2) {
            i3 = 0;
        } else {
            i3 = i2;
        }
        int zzj = zzu.zzj(i4, i3, z);
        if (zzj != -1) {
            return zzt + zzj;
        }
        int zzw = zzw(zzr, z);
        while (zzw != -1 && zzu(zzw).zzo()) {
            zzw = zzw(zzw, z);
        }
        if (zzw != -1) {
            return zzt(zzw) + zzu(zzw).zzg(z);
        }
        if (i2 == 2) {
            return zzg(z);
        }
        return -1;
    }

    public final int zzk(int i, int i2, boolean z) {
        int zzr = zzr(i);
        int zzt = zzt(zzr);
        int zzk = zzu(zzr).zzk(i - zzt, 0, false);
        if (zzk != -1) {
            return zzt + zzk;
        }
        int zzx = zzx(zzr, false);
        while (zzx != -1 && zzu(zzx).zzo()) {
            zzx = zzx(zzx, false);
        }
        if (zzx != -1) {
            return zzt(zzx) + zzu(zzx).zzh(false);
        }
        return -1;
    }

    public final zzcz zzn(Object obj, zzcz zzcz) {
        Pair pair = (Pair) obj;
        Object obj2 = pair.first;
        Object obj3 = pair.second;
        int zzp = zzp(obj2);
        int zzt = zzt(zzp);
        zzu(zzp).zzn(obj3, zzcz);
        zzcz.zzd += zzt;
        zzcz.zzc = obj;
        return zzcz;
    }

    /* access modifiers changed from: protected */
    public abstract int zzp(Object obj);

    /* access modifiers changed from: protected */
    public abstract int zzq(int i);

    /* access modifiers changed from: protected */
    public abstract int zzr(int i);

    /* access modifiers changed from: protected */
    public abstract int zzs(int i);

    /* access modifiers changed from: protected */
    public abstract int zzt(int i);

    /* access modifiers changed from: protected */
    public abstract zzdc zzu(int i);

    /* access modifiers changed from: protected */
    public abstract Object zzv(int i);
}
