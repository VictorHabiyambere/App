package com.google.android.gms.internal.ads;

import android.media.AudioTrack;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
final class zzqx {
    private final zzqw zza;
    private int zzb;
    private long zzc;
    private long zzd;
    private long zze;
    private long zzf;

    public zzqx(AudioTrack audioTrack) {
        this.zza = new zzqw(audioTrack);
        zzh(0);
    }

    private final void zzh(int i) {
        this.zzb = i;
        long j = 10000;
        switch (i) {
            case 0:
                this.zze = 0;
                this.zzf = -1;
                this.zzc = System.nanoTime() / 1000;
                break;
            case 1:
                this.zzd = 10000;
                return;
            case 2:
            case 3:
                j = 10000000;
                break;
            default:
                j = 500000;
                break;
        }
        this.zzd = j;
    }

    public final long zza() {
        return this.zza.zza();
    }

    public final long zzb() {
        return this.zza.zzb();
    }

    public final void zzc() {
        if (this.zzb == 4) {
            zzh(0);
        }
    }

    public final void zzd() {
        zzh(4);
    }

    public final void zze() {
        zzh(0);
    }

    public final boolean zzf() {
        return this.zzb == 2;
    }

    public final boolean zzg(long j) {
        if (j - this.zze < this.zzd) {
            return false;
        }
        this.zze = j;
        boolean zzc2 = this.zza.zzc();
        switch (this.zzb) {
            case 0:
                if (zzc2) {
                    if (this.zza.zzb() < this.zzc) {
                        return false;
                    }
                    this.zzf = this.zza.zza();
                    zzh(1);
                    return true;
                } else if (j - this.zzc <= 500000) {
                    return false;
                } else {
                    zzh(3);
                    return false;
                }
            case 1:
                if (!zzc2) {
                    zzh(0);
                    return false;
                } else if (this.zza.zza() <= this.zzf) {
                    return true;
                } else {
                    zzh(2);
                    return true;
                }
            case 2:
                if (zzc2) {
                    return true;
                }
                zzh(0);
                return false;
            case 3:
                if (!zzc2) {
                    return false;
                }
                zzh(0);
                return true;
            default:
                return zzc2;
        }
    }
}
