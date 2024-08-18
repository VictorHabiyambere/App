package com.google.android.gms.internal.ads;

import androidx.core.view.InputDeviceCompat;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzapc implements zzapp {
    private final zzapb zza;
    private final zzfu zzb = new zzfu(32);
    private int zzc;
    private int zzd;
    private boolean zze;
    private boolean zzf;

    public zzapc(zzapb zzapb) {
        this.zza = zzapb;
    }

    public final void zza(zzfu zzfu, int i) {
        int i2;
        boolean z;
        int i3 = i & 1;
        if (i3 != 0) {
            i2 = zzfu.zzd() + zzfu.zzm();
        } else {
            i2 = -1;
        }
        if (this.zzf) {
            if (i3 != 0) {
                this.zzf = false;
                zzfu.zzK(i2);
                this.zzd = 0;
            } else {
                return;
            }
        }
        while (zzfu.zzb() > 0) {
            int i4 = this.zzd;
            if (i4 < 3) {
                if (i4 == 0) {
                    int zzm = zzfu.zzm();
                    zzfu.zzK(zzfu.zzd() - 1);
                    if (zzm == 255) {
                    }
                }
                int min = Math.min(zzfu.zzb(), 3 - this.zzd);
                zzfu.zzG(this.zzb.zzM(), this.zzd, min);
                int i5 = this.zzd + min;
                this.zzd = i5;
                if (i5 == 3) {
                    this.zzb.zzK(0);
                    this.zzb.zzJ(3);
                    this.zzb.zzL(1);
                    zzfu zzfu2 = this.zzb;
                    int zzm2 = zzfu2.zzm();
                    if ((zzm2 & 128) != 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    int zzm3 = zzfu2.zzm();
                    this.zze = z;
                    this.zzc = (zzm3 | ((zzm2 & 15) << 8)) + 3;
                    int zzc2 = this.zzb.zzc();
                    int i6 = this.zzc;
                    if (zzc2 < i6) {
                        int zzc3 = this.zzb.zzc();
                        this.zzb.zzE(Math.min(InputDeviceCompat.SOURCE_TOUCHSCREEN, Math.max(i6, zzc3 + zzc3)));
                    }
                }
            } else {
                int min2 = Math.min(zzfu.zzb(), this.zzc - i4);
                zzfu.zzG(this.zzb.zzM(), this.zzd, min2);
                int i7 = this.zzd + min2;
                this.zzd = i7;
                int i8 = this.zzc;
                if (i7 != i8) {
                    continue;
                } else {
                    if (!this.zze) {
                        this.zzb.zzJ(i8);
                    } else if (zzgd.zze(this.zzb.zzM(), 0, i8, -1) == 0) {
                        this.zzb.zzJ(this.zzc - 4);
                    }
                    this.zzb.zzK(0);
                    this.zza.zza(this.zzb);
                    this.zzd = 0;
                }
            }
            this.zzf = true;
            return;
        }
    }

    public final void zzb(zzgb zzgb, zzadx zzadx, zzapo zzapo) {
        this.zza.zzb(zzgb, zzadx, zzapo);
        this.zzf = true;
    }

    public final void zzc() {
        this.zzf = true;
    }
}
