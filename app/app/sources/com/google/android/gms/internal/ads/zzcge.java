package com.google.android.gms.internal.ads;

import android.net.Uri;
import java.io.IOException;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
final class zzcge implements zzhb {
    private final zzhb zza;
    private final long zzb;
    private final zzhb zzc;
    private long zzd;
    private Uri zze;

    zzcge(zzhb zzhb, int i, zzhb zzhb2) {
        this.zza = zzhb;
        this.zzb = (long) i;
        this.zzc = zzhb2;
    }

    public final int zza(byte[] bArr, int i, int i2) throws IOException {
        int i3;
        long j = this.zzd;
        long j2 = this.zzb;
        if (j < j2) {
            int zza2 = this.zza.zza(bArr, i, (int) Math.min((long) i2, j2 - j));
            long j3 = this.zzd + ((long) zza2);
            this.zzd = j3;
            i3 = zza2;
            j = j3;
        } else {
            i3 = 0;
        }
        if (j < this.zzb) {
            return i3;
        }
        int zza3 = this.zzc.zza(bArr, i + i3, i2 - i3);
        int i4 = i3 + zza3;
        this.zzd += (long) zza3;
        return i4;
    }

    public final long zzb(zzhh zzhh) throws IOException {
        zzhh zzhh2;
        long j;
        long j2;
        long j3;
        zzhh zzhh3 = zzhh;
        this.zze = zzhh3.zza;
        long j4 = zzhh3.zze;
        long j5 = this.zzb;
        zzhh zzhh4 = null;
        if (j4 >= j5) {
            zzhh2 = null;
        } else {
            long j6 = zzhh3.zzf;
            long j7 = j5 - j4;
            if (j6 != -1) {
                j3 = Math.min(j6, j7);
            } else {
                j3 = j7;
            }
            zzhh2 = new zzhh(zzhh3.zza, j4, j3, (String) null);
        }
        long j8 = zzhh3.zzf;
        if (j8 == -1 || zzhh3.zze + j8 > this.zzb) {
            long max = Math.max(this.zzb, zzhh3.zze);
            long j9 = zzhh3.zzf;
            if (j9 != -1) {
                j2 = Math.min(j9, (zzhh3.zze + j9) - this.zzb);
            } else {
                j2 = -1;
            }
            zzhh4 = new zzhh(zzhh3.zza, max, j2, (String) null);
        }
        long j10 = 0;
        if (zzhh2 != null) {
            j = this.zza.zzb(zzhh2);
        } else {
            j = 0;
        }
        if (zzhh4 != null) {
            j10 = this.zzc.zzb(zzhh4);
        }
        this.zzd = zzhh3.zze;
        if (j == -1 || j10 == -1) {
            return -1;
        }
        return j + j10;
    }

    public final Uri zzc() {
        return this.zze;
    }

    public final void zzd() throws IOException {
        this.zza.zzd();
        this.zzc.zzd();
    }

    public final Map zze() {
        return zzgbf.zzd();
    }

    public final void zzf(zzie zzie) {
    }
}
