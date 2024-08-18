package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzaek {
    public final List zza;
    public final int zzb;
    public final int zzc;
    public final int zzd;
    public final int zze;
    public final int zzf;
    public final int zzg;
    public final float zzh;
    public final String zzi;

    private zzaek(List list, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, float f, String str) {
        this.zza = list;
        this.zzb = i;
        this.zzc = i4;
        this.zzd = i5;
        this.zze = i6;
        this.zzf = i7;
        this.zzg = i8;
        this.zzh = f;
        this.zzi = str;
    }

    public static zzaek zza(zzfu zzfu) throws zzch {
        int i;
        int i2;
        int i3;
        zzfu zzfu2 = zzfu;
        try {
            zzfu2.zzL(21);
            int zzm = zzfu.zzm() & 3;
            int zzm2 = zzfu.zzm();
            int zzd2 = zzfu.zzd();
            int i4 = 0;
            int i5 = 0;
            for (int i6 = 0; i6 < zzm2; i6++) {
                zzfu2.zzL(1);
                int zzq = zzfu.zzq();
                for (int i7 = 0; i7 < zzq; i7++) {
                    int zzq2 = zzfu.zzq();
                    i5 += zzq2 + 4;
                    zzfu2.zzL(zzq2);
                }
            }
            zzfu2.zzK(zzd2);
            byte[] bArr = new byte[i5];
            int i8 = -1;
            int i9 = -1;
            int i10 = -1;
            int i11 = -1;
            int i12 = -1;
            int i13 = -1;
            int i14 = -1;
            String str = null;
            float f = 1.0f;
            int i15 = 0;
            int i16 = 0;
            while (i15 < zzm2) {
                int zzm3 = zzfu.zzm() & 63;
                int zzq3 = zzfu.zzq();
                int i17 = i4;
                while (i17 < zzq3) {
                    int zzq4 = zzfu.zzq();
                    int i18 = zzm2;
                    System.arraycopy(zzgr.zza, i4, bArr, i16, 4);
                    int i19 = i16 + 4;
                    System.arraycopy(zzfu.zzM(), zzfu.zzd(), bArr, i19, zzq4);
                    int i20 = i19 + zzq4;
                    if (zzm3 == 33 && i17 == 0) {
                        zzgo zzc2 = zzgr.zzc(bArr, i19 + 2, i20);
                        i8 = zzc2.zzi;
                        i9 = zzc2.zzj;
                        i10 = zzc2.zze + 8;
                        i11 = zzc2.zzf + 8;
                        int i21 = zzc2.zzl;
                        int i22 = zzc2.zzm;
                        int i23 = zzc2.zzn;
                        i3 = i20;
                        float f2 = zzc2.zzk;
                        i2 = zzm3;
                        i = zzq3;
                        str = zzes.zzb(zzc2.zza, zzc2.zzb, zzc2.zzc, zzc2.zzd, zzc2.zzg, zzc2.zzh);
                        f = f2;
                        i12 = i21;
                        i14 = i23;
                        i13 = i22;
                        i17 = 0;
                    } else {
                        i3 = i20;
                        i2 = zzm3;
                        i = zzq3;
                    }
                    zzfu2.zzL(zzq4);
                    i17++;
                    zzm2 = i18;
                    i16 = i3;
                    zzm3 = i2;
                    zzq3 = i;
                    i4 = 0;
                }
                int i24 = zzm2;
                i15++;
                i4 = 0;
            }
            return new zzaek(i5 == 0 ? Collections.emptyList() : Collections.singletonList(bArr), zzm + 1, i8, i9, i10, i11, i12, i13, i14, f, str);
        } catch (ArrayIndexOutOfBoundsException e) {
            throw zzch.zza("Error parsing HEVC config", e);
        }
    }
}
