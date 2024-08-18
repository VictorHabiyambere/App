package com.google.android.gms.internal.ads;

import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
final class zzafx implements zzadd {
    private final zzaeg zza;
    private final int zzb;
    private final zzaeb zzc = new zzaeb();

    /* synthetic */ zzafx(zzaeg zzaeg, int i, zzafw zzafw) {
        this.zza = zzaeg;
        this.zzb = i;
    }

    private final long zzc(zzadv zzadv) throws IOException {
        while (zzadv.zze() < zzadv.zzd() - 6) {
            zzaeg zzaeg = this.zza;
            int i = this.zzb;
            zzaeb zzaeb = this.zzc;
            long zze = zzadv.zze();
            byte[] bArr = new byte[2];
            zzadi zzadi = (zzadi) zzadv;
            zzadi.zzm(bArr, 0, 2, false);
            if ((((bArr[0] & 255) << 8) | (bArr[1] & 255)) != i) {
                zzadv.zzj();
                zzadi.zzl((int) (zze - zzadv.zzf()), false);
            } else {
                zzfu zzfu = new zzfu(16);
                System.arraycopy(bArr, 0, zzfu.zzM(), 0, 2);
                zzfu.zzJ(zzady.zza(zzadv, zzfu.zzM(), 2, 14));
                zzadv.zzj();
                zzadi.zzl((int) (zze - zzadv.zzf()), false);
                if (zzaec.zzc(zzfu, zzaeg, i, zzaeb)) {
                    break;
                }
            }
            zzadi.zzl(1, false);
        }
        if (zzadv.zze() < zzadv.zzd() - 6) {
            return this.zzc.zza;
        }
        ((zzadi) zzadv).zzl((int) (zzadv.zzd() - zzadv.zze()), false);
        return this.zza.zzj;
    }

    public final zzadc zza(zzadv zzadv, long j) throws IOException {
        int i = this.zza.zzc;
        long zzf = zzadv.zzf();
        long zzc2 = zzc(zzadv);
        long zze = zzadv.zze();
        ((zzadi) zzadv).zzl(Math.max(6, i), false);
        int i2 = (zzc2 > j ? 1 : (zzc2 == j ? 0 : -1));
        long zzc3 = zzc(zzadv);
        long zze2 = zzadv.zze();
        if (i2 > 0 || zzc3 <= j) {
            return zzc3 <= j ? zzadc.zzf(zzc3, zze2) : zzadc.zzd(zzc2, zzf);
        }
        return zzadc.zze(zze);
    }

    public final /* synthetic */ void zzb() {
    }
}
