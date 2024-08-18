package com.google.android.gms.internal.ads;

import androidx.compose.animation.core.AnimationKt;
import java.io.IOException;
import java.math.RoundingMode;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
final class zzapv implements zzapu {
    private final zzadx zza;
    private final zzafa zzb;
    private final zzapx zzc;
    private final zzan zzd;
    private final int zze;
    private long zzf;
    private int zzg;
    private long zzh;

    public zzapv(zzadx zzadx, zzafa zzafa, zzapx zzapx, String str, int i) throws zzch {
        this.zza = zzadx;
        this.zzb = zzafa;
        this.zzc = zzapx;
        int i2 = zzapx.zzb * zzapx.zze;
        int i3 = zzapx.zzd;
        int i4 = i2 / 8;
        if (i3 == i4) {
            int i5 = zzapx.zzc * i4;
            int i6 = i5 * 8;
            this.zze = Math.max(i4, i5 / 10);
            zzal zzal = new zzal();
            zzal.zzX(str);
            zzal.zzx(i6);
            zzal.zzS(i6);
            zzal.zzP(this.zze);
            zzal.zzy(zzapx.zzb);
            zzal.zzY(zzapx.zzc);
            zzal.zzR(i);
            this.zzd = zzal.zzad();
            return;
        }
        throw zzch.zza("Expected block size: " + i4 + "; got: " + i3, (Throwable) null);
    }

    public final void zza(int i, long j) {
        this.zza.zzO(new zzaqa(this.zzc, 1, (long) i, j));
        this.zzb.zzl(this.zzd);
    }

    public final void zzb(long j) {
        this.zzf = j;
        this.zzg = 0;
        this.zzh = 0;
    }

    public final boolean zzc(zzadv zzadv, long j) throws IOException {
        int i;
        int i2;
        int i3;
        long j2 = j;
        while (true) {
            i = (j2 > 0 ? 1 : (j2 == 0 ? 0 : -1));
            if (i <= 0 || (i2 = this.zzg) >= (i3 = this.zze)) {
                zzapx zzapx = this.zzc;
                int i4 = this.zzg;
                int i5 = zzapx.zzd;
                int i6 = i4 / i5;
            } else {
                int zza2 = zzaey.zza(this.zzb, zzadv, (int) Math.min((long) (i3 - i2), j2), true);
                if (zza2 == -1) {
                    j2 = 0;
                } else {
                    this.zzg += zza2;
                    j2 -= (long) zza2;
                }
            }
        }
        zzapx zzapx2 = this.zzc;
        int i42 = this.zzg;
        int i52 = zzapx2.zzd;
        int i62 = i42 / i52;
        if (i62 > 0) {
            int i7 = i62 * i52;
            int i8 = this.zzg - i7;
            this.zzb.zzs(this.zzf + zzgd.zzt(this.zzh, AnimationKt.MillisToNanos, (long) zzapx2.zzc, RoundingMode.FLOOR), 1, i7, i8, (zzaez) null);
            this.zzh += (long) i62;
            this.zzg = i8;
        }
        if (i <= 0) {
            return true;
        }
        return false;
    }
}
