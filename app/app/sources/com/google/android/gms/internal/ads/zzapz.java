package com.google.android.gms.internal.ads;

import android.util.Pair;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
final class zzapz {
    public static Pair zza(zzadv zzadv) throws IOException {
        zzadv.zzj();
        zzapy zzd = zzd(1684108385, zzadv, new zzfu(8));
        ((zzadi) zzadv).zzo(8, false);
        return Pair.create(Long.valueOf(zzadv.zzf()), Long.valueOf(zzd.zzb));
    }

    public static zzapx zzb(zzadv zzadv) throws IOException {
        byte[] bArr;
        zzfu zzfu = new zzfu(16);
        zzapy zzd = zzd(1718449184, zzadv, zzfu);
        zzeq.zzf(zzd.zzb >= 16);
        zzadi zzadi = (zzadi) zzadv;
        zzadi.zzm(zzfu.zzM(), 0, 16, false);
        zzfu.zzK(0);
        int zzk = zzfu.zzk();
        int zzk2 = zzfu.zzk();
        int zzj = zzfu.zzj();
        int zzj2 = zzfu.zzj();
        int zzk3 = zzfu.zzk();
        int zzk4 = zzfu.zzk();
        int i = ((int) zzd.zzb) - 16;
        if (i > 0) {
            byte[] bArr2 = new byte[i];
            zzadi.zzm(bArr2, 0, i, false);
            bArr = bArr2;
        } else {
            bArr = zzgd.zzf;
        }
        zzadi.zzo((int) (zzadv.zze() - zzadv.zzf()), false);
        return new zzapx(zzk, zzk2, zzj, zzj2, zzk3, zzk4, bArr);
    }

    public static boolean zzc(zzadv zzadv) throws IOException {
        zzfu zzfu = new zzfu(8);
        int i = zzapy.zza(zzadv, zzfu).zza;
        if (i != 1380533830 && i != 1380333108) {
            return false;
        }
        ((zzadi) zzadv).zzm(zzfu.zzM(), 0, 4, false);
        zzfu.zzK(0);
        int zzg = zzfu.zzg();
        if (zzg == 1463899717) {
            return true;
        }
        zzfk.zzc("WavHeaderReader", "Unsupported form type: " + zzg);
        return false;
    }

    private static zzapy zzd(int i, zzadv zzadv, zzfu zzfu) throws IOException {
        zzapy zza = zzapy.zza(zzadv, zzfu);
        while (true) {
            int i2 = zza.zza;
            if (i2 == i) {
                return zza;
            }
            zzfk.zzf("WavHeaderReader", "Ignoring unknown WAV chunk: " + i2);
            long j = zza.zzb;
            int i3 = ((j & 1) > 0 ? 1 : ((j & 1) == 0 ? 0 : -1));
            long j2 = j + 8;
            if (i3 != 0) {
                j2++;
            }
            if (j2 <= 2147483647L) {
                ((zzadi) zzadv).zzo((int) j2, false);
                zza = zzapy.zza(zzadv, zzfu);
            } else {
                int i4 = zza.zza;
                throw zzch.zzc("Chunk is too large (~2GB+) to skip; id: " + i4);
            }
        }
    }
}
