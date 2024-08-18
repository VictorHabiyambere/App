package com.google.android.gms.internal.ads;

import androidx.compose.animation.core.AnimationKt;
import androidx.compose.ui.layout.LayoutKt;
import com.google.common.base.Ascii;
import java.io.IOException;
import java.math.RoundingMode;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
final class zzapt implements zzapu {
    private static final int[] zza = {-1, -1, -1, -1, 2, 4, 6, 8, -1, -1, -1, -1, 2, 4, 6, 8};
    private static final int[] zzb = {7, 8, 9, 10, 11, 12, 13, 14, 16, 17, 19, 21, 23, 25, 28, 31, 34, 37, 41, 45, 50, 55, 60, 66, 73, 80, 88, 97, 107, 118, 130, 143, 157, 173, 190, 209, 230, 253, 279, 307, 337, 371, 408, 449, 494, 544, 598, 658, 724, 796, 876, 963, 1060, 1166, 1282, 1411, 1552, 1707, 1878, 2066, 2272, 2499, 2749, 3024, 3327, 3660, 4026, 4428, 4871, 5358, 5894, 6484, 7132, 7845, 8630, 9493, 10442, 11487, 12635, 13899, 15289, 16818, 18500, 20350, 22385, 24623, 27086, 29794, LayoutKt.LargeDimension};
    private final zzadx zzc;
    private final zzafa zzd;
    private final zzapx zze;
    private final int zzf;
    private final byte[] zzg;
    private final zzfu zzh;
    private final int zzi;
    private final zzan zzj;
    private int zzk;
    private long zzl;
    private int zzm;
    private long zzn;

    public zzapt(zzadx zzadx, zzafa zzafa, zzapx zzapx) throws zzch {
        this.zzc = zzadx;
        this.zzd = zzafa;
        this.zze = zzapx;
        this.zzi = Math.max(1, zzapx.zzc / 10);
        zzfu zzfu = new zzfu(zzapx.zzf);
        zzfu.zzk();
        int zzk2 = zzfu.zzk();
        this.zzf = zzk2;
        int i = zzapx.zzb;
        int i2 = (((zzapx.zzd - (i * 4)) * 8) / (zzapx.zze * i)) + 1;
        if (zzk2 == i2) {
            int i3 = this.zzi;
            int i4 = zzgd.zza;
            int i5 = ((i3 + zzk2) - 1) / zzk2;
            this.zzg = new byte[(zzapx.zzd * i5)];
            int i6 = this.zzf;
            this.zzh = new zzfu(i5 * (i6 + i6) * i);
            int i7 = ((zzapx.zzc * zzapx.zzd) * 8) / this.zzf;
            zzal zzal = new zzal();
            zzal.zzX("audio/raw");
            zzal.zzx(i7);
            zzal.zzS(i7);
            int i8 = this.zzi;
            zzal.zzP((i8 + i8) * i);
            zzal.zzy(zzapx.zzb);
            zzal.zzY(zzapx.zzc);
            zzal.zzR(2);
            this.zzj = zzal.zzad();
            return;
        }
        throw zzch.zza("Expected frames per block: " + i2 + "; got: " + zzk2, (Throwable) null);
    }

    private final int zzd(int i) {
        int i2 = this.zze.zzb;
        return i / (i2 + i2);
    }

    private final int zze(int i) {
        return (i + i) * this.zze.zzb;
    }

    private final void zzf(int i) {
        long zzt = this.zzl + zzgd.zzt(this.zzn, AnimationKt.MillisToNanos, (long) this.zze.zzc, RoundingMode.FLOOR);
        int zze2 = zze(i);
        this.zzd.zzs(zzt, 1, zze2, this.zzm - zze2, (zzaez) null);
        this.zzn += (long) i;
        this.zzm -= zze2;
    }

    public final void zza(int i, long j) {
        this.zzc.zzO(new zzaqa(this.zze, this.zzf, (long) i, j));
        this.zzd.zzl(this.zzj);
    }

    public final void zzb(long j) {
        this.zzk = 0;
        this.zzl = j;
        this.zzm = 0;
        this.zzn = 0;
    }

    public final boolean zzc(zzadv zzadv, long j) throws IOException {
        int zzd2;
        int i;
        long j2 = j;
        int zzd3 = this.zzi - zzd(this.zzm);
        int i2 = zzgd.zza;
        int i3 = this.zzf;
        int i4 = (((zzd3 + i3) - 1) / i3) * this.zze.zzd;
        boolean z = j2 == 0;
        while (!z) {
            int i5 = this.zzk;
            if (i5 >= i4) {
                break;
            }
            int zza2 = zzadv.zza(this.zzg, this.zzk, (int) Math.min((long) (i4 - i5), j2));
            if (zza2 == -1) {
                z = true;
            } else {
                this.zzk += zza2;
            }
        }
        int i6 = this.zzk / this.zze.zzd;
        if (i6 > 0) {
            byte[] bArr = this.zzg;
            zzfu zzfu = this.zzh;
            for (int i7 = 0; i7 < i6; i7++) {
                int i8 = 0;
                while (true) {
                    zzapx zzapx = this.zze;
                    int i9 = zzapx.zzb;
                    if (i8 >= i9) {
                        break;
                    }
                    byte[] zzM = zzfu.zzM();
                    int i10 = zzapx.zzd;
                    int i11 = i7 * i10;
                    int i12 = (i10 / i9) - 4;
                    int i13 = i11 + (i8 * 4);
                    int min = Math.min(bArr[i13 + 2] & 255, 88);
                    int i14 = zzb[min];
                    int i15 = (this.zzf * i7 * i9) + i8;
                    int i16 = (short) (((bArr[i13 + 1] & 255) << 8) | (bArr[i13] & 255));
                    int i17 = i15 + i15;
                    zzM[i17] = (byte) (i16 & 255);
                    zzM[i17 + 1] = (byte) (i16 >> 8);
                    int i18 = 0;
                    while (i18 < i12 + i12) {
                        byte b = bArr[(i9 * 4) + i13 + ((i18 / 8) * i9 * 4) + ((i18 / 2) % 4)] & 255;
                        if (i18 % 2 == 0) {
                            i = b & Ascii.SI;
                        } else {
                            i = b >> 4;
                        }
                        int i19 = i & 7;
                        byte[] bArr2 = bArr;
                        int i20 = (((i19 + i19) + 1) * i14) >> 3;
                        if ((i & 8) != 0) {
                            i20 = -i20;
                        }
                        i16 = Math.max(-32768, Math.min(i16 + i20, LayoutKt.LargeDimension));
                        int i21 = i17 + i9 + i9;
                        zzM[i21] = (byte) (i16 & 255);
                        zzM[i21 + 1] = (byte) (i16 >> 8);
                        min = Math.max(0, Math.min(min + zza[i], 88));
                        i14 = zzb[min];
                        i18++;
                        i17 = i21;
                        bArr = bArr2;
                    }
                    byte[] bArr3 = bArr;
                    i8++;
                }
                byte[] bArr4 = bArr;
            }
            int zze2 = zze(this.zzf * i6);
            zzfu.zzK(0);
            zzfu.zzJ(zze2);
            this.zzk -= i6 * this.zze.zzd;
            zzfu zzfu2 = this.zzh;
            zzafa zzafa = this.zzd;
            int zze3 = zzfu2.zze();
            zzaey.zzb(zzafa, zzfu2, zze3);
            int i22 = this.zzm + zze3;
            this.zzm = i22;
            int zzd4 = zzd(i22);
            int i23 = this.zzi;
            if (zzd4 >= i23) {
                zzf(i23);
            }
        }
        if (z && (zzd2 = zzd(this.zzm)) > 0) {
            zzf(zzd2);
        }
        return z;
    }
}
