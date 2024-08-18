package com.google.android.gms.internal.ads;

import androidx.compose.animation.core.AnimationKt;
import java.util.Collections;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzaeg {
    public final int zza;
    public final int zzb;
    public final int zzc;
    public final int zzd;
    public final int zze;
    public final int zzf;
    public final int zzg;
    public final int zzh;
    public final int zzi;
    public final long zzj;
    public final zzaef zzk;
    private final zzcd zzl;

    private zzaeg(int i, int i2, int i3, int i4, int i5, int i6, int i7, long j, zzaef zzaef, zzcd zzcd) {
        this.zza = i;
        this.zzb = i2;
        this.zzc = i3;
        this.zzd = i4;
        this.zze = i5;
        this.zzf = zzi(i5);
        this.zzg = i6;
        this.zzh = i7;
        this.zzi = zzh(i7);
        this.zzj = j;
        this.zzk = zzaef;
        this.zzl = zzcd;
    }

    public zzaeg(byte[] bArr, int i) {
        zzft zzft = new zzft(bArr, bArr.length);
        zzft.zzk(i * 8);
        this.zza = zzft.zzd(16);
        this.zzb = zzft.zzd(16);
        this.zzc = zzft.zzd(24);
        this.zzd = zzft.zzd(24);
        int zzd2 = zzft.zzd(20);
        this.zze = zzd2;
        this.zzf = zzi(zzd2);
        this.zzg = zzft.zzd(3) + 1;
        int zzd3 = zzft.zzd(5) + 1;
        this.zzh = zzd3;
        this.zzi = zzh(zzd3);
        int zzd4 = zzft.zzd(4);
        int zzd5 = zzft.zzd(32);
        int i2 = zzgd.zza;
        this.zzj = ((((long) zzd4) & 4294967295L) << 32) | (((long) zzd5) & 4294967295L);
        this.zzk = null;
        this.zzl = null;
    }

    private static int zzh(int i) {
        switch (i) {
            case 8:
                return 1;
            case 12:
                return 2;
            case 16:
                return 4;
            case 20:
                return 5;
            case 24:
                return 6;
            default:
                return -1;
        }
    }

    private static int zzi(int i) {
        switch (i) {
            case 8000:
                return 4;
            case 16000:
                return 5;
            case 22050:
                return 6;
            case 24000:
                return 7;
            case 32000:
                return 8;
            case 44100:
                return 9;
            case 48000:
                return 10;
            case 88200:
                return 1;
            case 96000:
                return 11;
            case 176400:
                return 2;
            case 192000:
                return 3;
            default:
                return -1;
        }
    }

    public final long zza() {
        long j = this.zzj;
        if (j == 0) {
            return -9223372036854775807L;
        }
        return (j * AnimationKt.MillisToNanos) / ((long) this.zze);
    }

    public final long zzb(long j) {
        return Math.max(0, Math.min((j * ((long) this.zze)) / AnimationKt.MillisToNanos, this.zzj - 1));
    }

    public final zzan zzc(byte[] bArr, zzcd zzcd) {
        bArr[4] = Byte.MIN_VALUE;
        zzcd zzd2 = zzd(zzcd);
        zzal zzal = new zzal();
        zzal.zzX("audio/flac");
        int i = this.zzd;
        if (i <= 0) {
            i = -1;
        }
        zzal.zzP(i);
        zzal.zzy(this.zzg);
        zzal.zzY(this.zze);
        zzal.zzR(zzgd.zzl(this.zzh));
        zzal.zzL(Collections.singletonList(bArr));
        zzal.zzQ(zzd2);
        return zzal.zzad();
    }

    public final zzcd zzd(zzcd zzcd) {
        zzcd zzcd2 = this.zzl;
        return zzcd2 == null ? zzcd : zzcd2.zzd(zzcd);
    }

    public final zzaeg zze(List list) {
        return new zzaeg(this.zza, this.zzb, this.zzc, this.zzd, this.zze, this.zzg, this.zzh, this.zzj, this.zzk, zzd(new zzcd(list)));
    }

    public final zzaeg zzf(zzaef zzaef) {
        return new zzaeg(this.zza, this.zzb, this.zzc, this.zzd, this.zze, this.zzg, this.zzh, this.zzj, zzaef, this.zzl);
    }

    public final zzaeg zzg(List list) {
        return new zzaeg(this.zza, this.zzb, this.zzc, this.zzd, this.zze, this.zzg, this.zzh, this.zzj, this.zzk, zzd(zzafg.zzb(list)));
    }
}
