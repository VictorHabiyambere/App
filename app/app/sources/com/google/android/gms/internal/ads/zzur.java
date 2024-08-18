package com.google.android.gms.internal.ads;

import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
final class zzur implements zzxf {
    public final zzxf zza;
    final /* synthetic */ zzus zzb;
    private boolean zzc;

    public zzur(zzus zzus, zzxf zzxf) {
        this.zzb = zzus;
        this.zza = zzxf;
    }

    public final int zza(zzlj zzlj, zzin zzin, int i) {
        zzus zzus = this.zzb;
        if (zzus.zzq()) {
            return -3;
        }
        if (this.zzc) {
            zzin.zzc(4);
            return -4;
        }
        long zzb2 = zzus.zzb();
        int zza2 = this.zza.zza(zzlj, zzin, i);
        if (zza2 == -5) {
            zzan zzan = zzlj.zza;
            if (zzan != null) {
                int i2 = zzan.zzD;
                int i3 = 0;
                if (i2 == 0) {
                    if (zzan.zzE != 0) {
                        i2 = 0;
                    }
                    return -5;
                }
                if (this.zzb.zzb == Long.MIN_VALUE) {
                    i3 = zzan.zzE;
                }
                zzal zzb3 = zzan.zzb();
                zzb3.zzF(i2);
                zzb3.zzG(i3);
                zzlj.zza = zzb3.zzad();
                return -5;
            }
            throw null;
        }
        long j = this.zzb.zzb;
        if (j == Long.MIN_VALUE || ((zza2 != -4 || zzin.zze < j) && (zza2 != -3 || zzb2 != Long.MIN_VALUE || zzin.zzd))) {
            return zza2;
        }
        zzin.zzb();
        zzin.zzc(4);
        this.zzc = true;
        return -4;
    }

    public final int zzb(long j) {
        if (this.zzb.zzq()) {
            return -3;
        }
        return this.zza.zzb(j);
    }

    public final void zzc() {
        this.zzc = false;
    }

    public final void zzd() throws IOException {
        this.zza.zzd();
    }

    public final boolean zze() {
        return !this.zzb.zzq() && this.zza.zze();
    }
}
