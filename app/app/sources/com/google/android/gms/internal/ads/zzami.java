package com.google.android.gms.internal.ads;

import android.graphics.Bitmap;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
final class zzami {
    private final zzfu zza = new zzfu();
    private final int[] zzb = new int[256];
    private boolean zzc;
    private int zzd;
    private int zze;
    private int zzf;
    private int zzg;
    private int zzh;
    private int zzi;

    static /* bridge */ /* synthetic */ void zzb(zzami zzami, zzfu zzfu, int i) {
        int zzo;
        if (i >= 4) {
            zzfu.zzL(3);
            int i2 = i - 4;
            if ((zzfu.zzm() & 128) != 0) {
                if (i2 >= 7 && (zzo = zzfu.zzo()) >= 4) {
                    zzami.zzh = zzfu.zzq();
                    zzami.zzi = zzfu.zzq();
                    zzami.zza.zzH(zzo - 4);
                    i2 -= 7;
                } else {
                    return;
                }
            }
            zzfu zzfu2 = zzami.zza;
            int zzd2 = zzfu2.zzd();
            int zze2 = zzfu2.zze();
            if (zzd2 < zze2 && i2 > 0) {
                int min = Math.min(i2, zze2 - zzd2);
                zzfu.zzG(zzfu2.zzM(), zzd2, min);
                zzami.zza.zzK(zzd2 + min);
            }
        }
    }

    static /* bridge */ /* synthetic */ void zzc(zzami zzami, zzfu zzfu, int i) {
        if (i >= 19) {
            zzami.zzd = zzfu.zzq();
            zzami.zze = zzfu.zzq();
            zzfu.zzL(11);
            zzami.zzf = zzfu.zzq();
            zzami.zzg = zzfu.zzq();
        }
    }

    static /* bridge */ /* synthetic */ void zzd(zzami zzami, zzfu zzfu, int i) {
        zzami zzami2 = zzami;
        if (i % 5 == 2) {
            zzfu.zzL(2);
            int i2 = 0;
            Arrays.fill(zzami2.zzb, 0);
            int i3 = i / 5;
            int i4 = 0;
            while (i4 < i3) {
                int zzm = zzfu.zzm();
                int zzm2 = zzfu.zzm();
                int zzm3 = zzfu.zzm();
                int zzm4 = zzfu.zzm();
                double d = (double) zzm2;
                double d2 = (double) (zzm3 - 128);
                double d3 = (double) (zzm4 - 128);
                zzami2.zzb[zzm] = Math.max(0, Math.min((int) (d + (d3 * 1.772d)), 255)) | (zzfu.zzm() << 24) | (Math.max(i2, Math.min((int) ((1.402d * d2) + d), 255)) << 16) | (Math.max(0, Math.min((int) ((d - (0.34414d * d3)) - (d2 * 0.71414d)), 255)) << 8);
                i4++;
                i2 = 0;
            }
            zzami2.zzc = true;
        }
    }

    public final zzei zza() {
        int i;
        if (this.zzd == 0 || this.zze == 0 || this.zzh == 0 || this.zzi == 0) {
            return null;
        }
        zzfu zzfu = this.zza;
        if (zzfu.zze() == 0 || zzfu.zzd() != zzfu.zze() || !this.zzc) {
            return null;
        }
        zzfu.zzK(0);
        int i2 = this.zzh * this.zzi;
        int[] iArr = new int[i2];
        int i3 = 0;
        while (i3 < i2) {
            int zzm = this.zza.zzm();
            if (zzm != 0) {
                iArr[i3] = this.zzb[zzm];
                i3++;
            } else {
                int zzm2 = this.zza.zzm();
                if (zzm2 != 0) {
                    int i4 = zzm2 & 63;
                    if ((zzm2 & 64) != 0) {
                        i4 = (i4 << 8) | this.zza.zzm();
                    }
                    if ((zzm2 & 128) == 0) {
                        i = 0;
                    } else {
                        i = this.zzb[this.zza.zzm()];
                    }
                    int i5 = i4 + i3;
                    Arrays.fill(iArr, i3, i5, i);
                    i3 = i5;
                }
            }
        }
        Bitmap createBitmap = Bitmap.createBitmap(iArr, this.zzh, this.zzi, Bitmap.Config.ARGB_8888);
        zzeg zzeg = new zzeg();
        zzeg.zzc(createBitmap);
        zzeg.zzh(((float) this.zzf) / ((float) this.zzd));
        zzeg.zzi(0);
        zzeg.zze(((float) this.zzg) / ((float) this.zze), 0);
        zzeg.zzf(0);
        zzeg.zzk(((float) this.zzh) / ((float) this.zzd));
        zzeg.zzd(((float) this.zzi) / ((float) this.zze));
        return zzeg.zzp();
    }

    public final void zze() {
        this.zzd = 0;
        this.zze = 0;
        this.zzf = 0;
        this.zzg = 0;
        this.zzh = 0;
        this.zzi = 0;
        this.zza.zzH(0);
        this.zzc = false;
    }
}
