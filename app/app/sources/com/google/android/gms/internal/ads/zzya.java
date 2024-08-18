package com.google.android.gms.internal.ads;

import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public class zzya implements zzzg {
    protected final zzde zza;
    protected final int zzb;
    protected final int[] zzc;
    private final zzan[] zzd;
    private int zze;

    public zzya(zzde zzde, int[] iArr, int i) {
        boolean z;
        int length = iArr.length;
        if (length > 0) {
            z = true;
        } else {
            z = false;
        }
        zzeq.zzf(z);
        if (zzde != null) {
            this.zza = zzde;
            this.zzb = length;
            this.zzd = new zzan[length];
            for (int i2 = 0; i2 < iArr.length; i2++) {
                this.zzd[i2] = zzde.zzb(iArr[i2]);
            }
            Arrays.sort(this.zzd, new zzxz());
            this.zzc = new int[this.zzb];
            for (int i3 = 0; i3 < this.zzb; i3++) {
                this.zzc[i3] = zzde.zza(this.zzd[i3]);
            }
            return;
        }
        throw null;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        zzya zzya = (zzya) obj;
        return this.zza.equals(zzya.zza) && Arrays.equals(this.zzc, zzya.zzc);
    }

    public final int hashCode() {
        int i = this.zze;
        if (i != 0) {
            return i;
        }
        int identityHashCode = (System.identityHashCode(this.zza) * 31) + Arrays.hashCode(this.zzc);
        this.zze = identityHashCode;
        return identityHashCode;
    }

    public final int zza(int i) {
        return this.zzc[i];
    }

    public final int zzb(int i) {
        for (int i2 = 0; i2 < this.zzb; i2++) {
            if (this.zzc[i2] == i) {
                return i2;
            }
        }
        return -1;
    }

    public final int zzc() {
        return this.zzc.length;
    }

    public final zzan zzd(int i) {
        return this.zzd[i];
    }

    public final zzde zze() {
        return this.zza;
    }
}
