package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
final class zzakc {
    public final zzafa zza;
    public final zzakr zzb = new zzakr();
    public final zzfu zzc = new zzfu();
    public zzaks zzd;
    public zzajy zze;
    public int zzf;
    public int zzg;
    public int zzh;
    public int zzi;
    private final zzfu zzj = new zzfu(1);
    private final zzfu zzk = new zzfu();
    /* access modifiers changed from: private */
    public boolean zzl;

    public zzakc(zzafa zzafa, zzaks zzaks, zzajy zzajy) {
        this.zza = zzafa;
        this.zzd = zzaks;
        this.zze = zzajy;
        zzh(zzaks, zzajy);
    }

    public final int zza() {
        int i;
        if (!this.zzl) {
            i = this.zzd.zzg[this.zzf];
        } else {
            i = this.zzb.zzj[this.zzf] ? 1 : 0;
        }
        return zzf() != null ? i | 1073741824 : i;
    }

    public final int zzb() {
        if (!this.zzl) {
            return this.zzd.zzd[this.zzf];
        }
        return this.zzb.zzh[this.zzf];
    }

    public final int zzc(int i, int i2) {
        zzfu zzfu;
        boolean z;
        zzakq zzf2 = zzf();
        if (zzf2 == null) {
            return 0;
        }
        int i3 = zzf2.zzd;
        if (i3 != 0) {
            zzfu = this.zzb.zzn;
        } else {
            byte[] bArr = zzf2.zze;
            int i4 = zzgd.zza;
            zzfu zzfu2 = this.zzk;
            int length = bArr.length;
            zzfu2.zzI(bArr, length);
            zzfu = this.zzk;
            i3 = length;
        }
        boolean zzb2 = this.zzb.zzb(this.zzf);
        if (!zzb2) {
            z = i2 != 0;
        } else {
            z = true;
        }
        zzfu zzfu3 = this.zzj;
        zzfu3.zzM()[0] = (byte) ((true != z ? 0 : 128) | i3);
        zzfu3.zzK(0);
        this.zza.zzr(this.zzj, 1, 1);
        this.zza.zzr(zzfu, i3, 1);
        if (!z) {
            return i3 + 1;
        }
        if (!zzb2) {
            this.zzc.zzH(8);
            zzfu zzfu4 = this.zzc;
            byte[] zzM = zzfu4.zzM();
            zzM[0] = 0;
            zzM[1] = 1;
            zzM[2] = 0;
            zzM[3] = (byte) i2;
            zzM[4] = (byte) ((i >> 24) & 255);
            zzM[5] = (byte) ((i >> 16) & 255);
            zzM[6] = (byte) ((i >> 8) & 255);
            zzM[7] = (byte) (i & 255);
            this.zza.zzr(zzfu4, 8, 1);
            return i3 + 9;
        }
        int i5 = i3 + 1;
        zzfu zzfu5 = this.zzb.zzn;
        int zzq = zzfu5.zzq();
        zzfu5.zzL(-2);
        int i6 = (zzq * 6) + 2;
        if (i2 != 0) {
            this.zzc.zzH(i6);
            byte[] zzM2 = this.zzc.zzM();
            zzfu5.zzG(zzM2, 0, i6);
            int i7 = (((zzM2[2] & 255) << 8) | (zzM2[3] & 255)) + i2;
            zzM2[2] = (byte) ((i7 >> 8) & 255);
            zzM2[3] = (byte) (i7 & 255);
            zzfu5 = this.zzc;
        }
        this.zza.zzr(zzfu5, i6, 1);
        return i5 + i6;
    }

    public final long zzd() {
        if (!this.zzl) {
            return this.zzd.zzc[this.zzf];
        }
        return this.zzb.zzf[this.zzh];
    }

    public final long zze() {
        if (!this.zzl) {
            return this.zzd.zzf[this.zzf];
        }
        zzakr zzakr = this.zzb;
        return zzakr.zzi[this.zzf];
    }

    public final zzakq zzf() {
        if (!this.zzl) {
            return null;
        }
        zzajy zzajy = this.zzb.zza;
        int i = zzgd.zza;
        int i2 = zzajy.zza;
        zzakq zzakq = this.zzb.zzm;
        if (zzakq == null) {
            zzakq = this.zzd.zza.zza(i2);
        }
        if (zzakq == null || !zzakq.zza) {
            return null;
        }
        return zzakq;
    }

    public final void zzh(zzaks zzaks, zzajy zzajy) {
        this.zzd = zzaks;
        this.zze = zzajy;
        this.zza.zzl(zzaks.zza.zzf);
        zzi();
    }

    public final void zzi() {
        zzakr zzakr = this.zzb;
        zzakr.zzd = 0;
        zzakr.zzp = 0;
        zzakr.zzq = false;
        zzakr.zzk = false;
        zzakr.zzo = false;
        zzakr.zzm = null;
        this.zzf = 0;
        this.zzh = 0;
        this.zzg = 0;
        this.zzi = 0;
        this.zzl = false;
    }

    public final boolean zzk() {
        this.zzf++;
        if (!this.zzl) {
            return false;
        }
        int i = this.zzg + 1;
        this.zzg = i;
        int[] iArr = this.zzb.zzg;
        int i2 = this.zzh;
        if (i != iArr[i2]) {
            return true;
        }
        this.zzh = i2 + 1;
        this.zzg = 0;
        return false;
    }
}
