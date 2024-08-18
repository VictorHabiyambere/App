package com.google.android.gms.internal.ads;

import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
final class zzaiz {
    private final zzfu zza = new zzfu(8);
    private int zzb;

    private final long zzb(zzadv zzadv) throws IOException {
        int i;
        zzadi zzadi = (zzadi) zzadv;
        int i2 = 0;
        zzadi.zzm(this.zza.zzM(), 0, 1, false);
        byte b = this.zza.zzM()[0] & 255;
        if (b == 0) {
            return Long.MIN_VALUE;
        }
        int i3 = 128;
        int i4 = 0;
        while (true) {
            i = i4 + 1;
            if ((b & i3) != 0) {
                break;
            }
            i3 >>= 1;
            i4 = i;
        }
        int i5 = b & (~i3);
        zzadi.zzm(this.zza.zzM(), 1, i4, false);
        while (i2 < i4) {
            i2++;
            i5 = (this.zza.zzM()[i2] & 255) + (i5 << 8);
        }
        this.zzb += i;
        return (long) i5;
    }

    public final boolean zza(zzadv zzadv) throws IOException {
        long zzb2;
        int i;
        long zzd = zzadv.zzd();
        int i2 = (zzd > -1 ? 1 : (zzd == -1 ? 0 : -1));
        long j = 1024;
        if (i2 != 0 && zzd <= 1024) {
            j = zzd;
        }
        zzadi zzadi = (zzadi) zzadv;
        zzadi.zzm(this.zza.zzM(), 0, 4, false);
        long zzu = this.zza.zzu();
        this.zzb = 4;
        while (zzu != 440786851) {
            int i3 = (int) j;
            int i4 = this.zzb + 1;
            this.zzb = i4;
            if (i4 == i3) {
                return false;
            }
            zzadi.zzm(this.zza.zzM(), 0, 1, false);
            zzu = ((zzu << 8) & -256) | ((long) (this.zza.zzM()[0] & 255));
        }
        long zzb3 = zzb(zzadv);
        long j2 = (long) this.zzb;
        if (zzb3 != Long.MIN_VALUE) {
            long j3 = j2 + zzb3;
            if (i2 == 0 || j3 < zzd) {
                while (true) {
                    int i5 = (((long) this.zzb) > j3 ? 1 : (((long) this.zzb) == j3 ? 0 : -1));
                    if (i5 < 0) {
                        if (zzb(zzadv) == Long.MIN_VALUE || zzb2 < 0) {
                            return false;
                        }
                        if (i != 0) {
                            int zzb4 = (int) (zzb2 = zzb(zzadv));
                            zzadi.zzl(zzb4, false);
                            this.zzb += zzb4;
                        }
                    } else if (i5 == 0) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
