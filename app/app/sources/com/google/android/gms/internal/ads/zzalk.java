package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import org.checkerframework.checker.nullness.qual.EnsuresNonNullIf;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
final class zzalk extends zzali {
    private zzalj zza;
    private int zzb;
    private boolean zzc;
    private zzaff zzd;
    private zzafd zze;

    zzalk() {
    }

    /* access modifiers changed from: protected */
    public final long zza(zzfu zzfu) {
        int i;
        int i2 = 0;
        if ((zzfu.zzM()[0] & 1) == 1) {
            return -1;
        }
        byte b = zzfu.zzM()[0];
        zzalj zzalj = this.zza;
        zzeq.zzb(zzalj);
        if (!zzalj.zzd[(b >> 1) & (255 >>> (8 - zzalj.zze))].zza) {
            i = zzalj.zza.zze;
        } else {
            i = zzalj.zza.zzf;
        }
        if (this.zzc) {
            i2 = (this.zzb + i) / 4;
        }
        if (zzfu.zzc() < zzfu.zze() + 4) {
            byte[] copyOf = Arrays.copyOf(zzfu.zzM(), zzfu.zze() + 4);
            zzfu.zzI(copyOf, copyOf.length);
        } else {
            zzfu.zzJ(zzfu.zze() + 4);
        }
        long j = (long) i2;
        byte[] zzM = zzfu.zzM();
        zzM[zzfu.zze() - 4] = (byte) ((int) (j & 255));
        zzM[zzfu.zze() - 3] = (byte) ((int) ((j >>> 8) & 255));
        zzM[zzfu.zze() - 2] = (byte) ((int) ((j >>> 16) & 255));
        zzM[zzfu.zze() - 1] = (byte) ((int) ((j >>> 24) & 255));
        this.zzc = true;
        this.zzb = i;
        return j;
    }

    /* access modifiers changed from: protected */
    public final void zzb(boolean z) {
        super.zzb(z);
        if (z) {
            this.zza = null;
            this.zzd = null;
            this.zze = null;
        }
        this.zzb = 0;
        this.zzc = false;
    }

    /* access modifiers changed from: protected */
    public final void zzi(long j) {
        super.zzi(j);
        int i = 0;
        this.zzc = j != 0;
        zzaff zzaff = this.zzd;
        if (zzaff != null) {
            i = zzaff.zze;
        }
        this.zzb = i;
    }

    /* access modifiers changed from: protected */
    @EnsuresNonNullIf(expression = {"#3.format"}, result = false)
    public final boolean zzc(zzfu zzfu, long j, zzalf zzalf) throws IOException {
        zzalj zzalj;
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        zzaff zzaff;
        long j2;
        zzfu zzfu2 = zzfu;
        zzalf zzalf2 = zzalf;
        if (this.zza == null) {
            zzaff zzaff2 = this.zzd;
            int i6 = 4;
            if (zzaff2 == null) {
                zzafg.zzd(1, zzfu2, false);
                int zzj = zzfu.zzj();
                int zzm = zzfu.zzm();
                int zzj2 = zzfu.zzj();
                int zzi = zzfu.zzi();
                int i7 = zzi <= 0 ? -1 : zzi;
                int zzi2 = zzfu.zzi();
                int i8 = zzi2 <= 0 ? -1 : zzi2;
                int zzi3 = zzfu.zzi();
                int i9 = zzi3 <= 0 ? -1 : zzi3;
                int zzm2 = zzfu.zzm();
                this.zzd = new zzaff(zzj, zzm, zzj2, i7, i8, i9, (int) Math.pow(2.0d, (double) (zzm2 & 15)), (int) Math.pow(2.0d, (double) ((zzm2 & 240) >> 4)), 1 == (zzfu.zzm() & 1), Arrays.copyOf(zzfu.zzM(), zzfu.zze()));
                zzalj = null;
            } else {
                zzafd zzafd = this.zze;
                if (zzafd == null) {
                    this.zze = zzafg.zzc(zzfu2, true, true);
                    zzalj = null;
                } else {
                    byte[] bArr = new byte[zzfu.zze()];
                    System.arraycopy(zzfu.zzM(), 0, bArr, 0, zzfu.zze());
                    int i10 = zzaff2.zza;
                    int i11 = 5;
                    zzafg.zzd(5, zzfu2, false);
                    int zzm3 = zzfu.zzm() + 1;
                    zzafc zzafc = new zzafc(zzfu.zzM());
                    zzafc.zzc(zzfu.zzd() * 8);
                    int i12 = 0;
                    while (true) {
                        int i13 = 2;
                        int i14 = 16;
                        if (i12 >= zzm3) {
                            zzaff zzaff3 = zzaff2;
                            int zzb2 = zzafc.zzb(6) + 1;
                            int i15 = 0;
                            while (i15 < zzb2) {
                                if (zzafc.zzb(16) == 0) {
                                    i15++;
                                } else {
                                    throw zzch.zza("placeholder of time domain transforms not zeroed out", (Throwable) null);
                                }
                            }
                            int zzb3 = zzafc.zzb(6) + 1;
                            int i16 = 0;
                            while (true) {
                                int i17 = 3;
                                if (i16 < zzb3) {
                                    int zzb4 = zzafc.zzb(i14);
                                    switch (zzb4) {
                                        case 0:
                                            int i18 = 8;
                                            zzafc.zzc(8);
                                            zzafc.zzc(16);
                                            zzafc.zzc(16);
                                            zzafc.zzc(6);
                                            zzafc.zzc(8);
                                            int zzb5 = zzafc.zzb(4) + 1;
                                            int i19 = 0;
                                            while (i19 < zzb5) {
                                                zzafc.zzc(i18);
                                                i19++;
                                                i18 = 8;
                                            }
                                            break;
                                        case 1:
                                            int zzb6 = zzafc.zzb(i11);
                                            int[] iArr = new int[zzb6];
                                            int i20 = -1;
                                            for (int i21 = 0; i21 < zzb6; i21++) {
                                                int zzb7 = zzafc.zzb(4);
                                                iArr[i21] = zzb7;
                                                if (zzb7 > i20) {
                                                    i20 = zzb7;
                                                }
                                            }
                                            int i22 = i20 + 1;
                                            int[] iArr2 = new int[i22];
                                            int i23 = 0;
                                            while (i23 < i22) {
                                                iArr2[i23] = zzafc.zzb(i17) + 1;
                                                int zzb8 = zzafc.zzb(i13);
                                                if (zzb8 > 0) {
                                                    zzafc.zzc(8);
                                                    i4 = 0;
                                                } else {
                                                    i4 = 0;
                                                }
                                                while (i4 < (1 << zzb8)) {
                                                    zzafc.zzc(8);
                                                    i4++;
                                                }
                                                i23++;
                                                i13 = 2;
                                                i17 = 3;
                                            }
                                            zzafc.zzc(2);
                                            int zzb9 = zzafc.zzb(4);
                                            int i24 = 0;
                                            int i25 = 0;
                                            for (int i26 = 0; i26 < zzb6; i26++) {
                                                i24 += iArr2[iArr[i26]];
                                                while (i25 < i24) {
                                                    zzafc.zzc(zzb9);
                                                    i25++;
                                                }
                                            }
                                            break;
                                        default:
                                            throw zzch.zza("floor type greater than 1 not decodable: " + zzb4, (Throwable) null);
                                    }
                                    i16++;
                                    i14 = 16;
                                    i11 = 5;
                                    i13 = 2;
                                } else {
                                    int zzb10 = zzafc.zzb(6) + 1;
                                    int i27 = 0;
                                    while (i27 < zzb10) {
                                        if (zzafc.zzb(16) <= 2) {
                                            zzafc.zzc(24);
                                            zzafc.zzc(24);
                                            zzafc.zzc(24);
                                            int zzb11 = zzafc.zzb(6) + 1;
                                            zzafc.zzc(8);
                                            int[] iArr3 = new int[zzb11];
                                            for (int i28 = 0; i28 < zzb11; i28++) {
                                                int zzb12 = zzafc.zzb(3);
                                                if (zzafc.zzd()) {
                                                    i3 = zzafc.zzb(5);
                                                } else {
                                                    i3 = 0;
                                                }
                                                iArr3[i28] = (i3 * 8) + zzb12;
                                            }
                                            for (int i29 = 0; i29 < zzb11; i29++) {
                                                for (int i30 = 0; i30 < 8; i30++) {
                                                    if ((iArr3[i29] & (1 << i30)) != 0) {
                                                        zzafc.zzc(8);
                                                    }
                                                }
                                            }
                                            i27++;
                                        } else {
                                            throw zzch.zza("residueType greater than 2 is not decodable", (Throwable) null);
                                        }
                                    }
                                    int zzb13 = zzafc.zzb(6) + 1;
                                    for (int i31 = 0; i31 < zzb13; i31++) {
                                        int zzb14 = zzafc.zzb(16);
                                        if (zzb14 != 0) {
                                            zzfk.zzc("VorbisUtil", "mapping type other than 0 not supported: " + zzb14);
                                        } else {
                                            if (zzafc.zzd()) {
                                                i = zzafc.zzb(4) + 1;
                                            } else {
                                                i = 1;
                                            }
                                            if (zzafc.zzd()) {
                                                int zzb15 = zzafc.zzb(8) + 1;
                                                for (int i32 = 0; i32 < zzb15; i32++) {
                                                    int i33 = i10 - 1;
                                                    zzafc.zzc(zzafg.zza(i33));
                                                    zzafc.zzc(zzafg.zza(i33));
                                                }
                                            }
                                            if (zzafc.zzb(2) == 0) {
                                                if (i > 1) {
                                                    for (int i34 = 0; i34 < i10; i34++) {
                                                        zzafc.zzc(4);
                                                    }
                                                    i2 = 0;
                                                } else {
                                                    i2 = 0;
                                                }
                                                while (i2 < i) {
                                                    zzafc.zzc(8);
                                                    zzafc.zzc(8);
                                                    zzafc.zzc(8);
                                                    i2++;
                                                }
                                            } else {
                                                throw zzch.zza("to reserved bits must be zero after mapping coupling steps", (Throwable) null);
                                            }
                                        }
                                    }
                                    int zzb16 = zzafc.zzb(6) + 1;
                                    zzafe[] zzafeArr = new zzafe[zzb16];
                                    for (int i35 = 0; i35 < zzb16; i35++) {
                                        zzafeArr[i35] = new zzafe(zzafc.zzd(), zzafc.zzb(16), zzafc.zzb(16), zzafc.zzb(8));
                                    }
                                    if (zzafc.zzd()) {
                                        zzalj = new zzalj(zzaff3, zzafd, bArr, zzafeArr, zzafg.zza(zzb16 - 1));
                                    } else {
                                        throw zzch.zza("framing bit after modes not set as expected", (Throwable) null);
                                    }
                                }
                            }
                        } else if (zzafc.zzb(24) == 5653314) {
                            int zzb17 = zzafc.zzb(16);
                            int zzb18 = zzafc.zzb(24);
                            if (!zzafc.zzd()) {
                                boolean zzd2 = zzafc.zzd();
                                for (int i36 = 0; i36 < zzb18; i36++) {
                                    if (!zzd2) {
                                        zzafc.zzc(5);
                                    } else if (zzafc.zzd()) {
                                        zzafc.zzc(5);
                                    }
                                }
                            } else {
                                zzafc.zzc(5);
                                for (int i37 = 0; i37 < zzb18; i37 += zzafc.zzb(zzafg.zza(zzb18 - i37))) {
                                }
                            }
                            int zzb19 = zzafc.zzb(i6);
                            if (zzb19 <= 2) {
                                if (zzb19 == 1) {
                                    i13 = zzb19;
                                } else if (zzb19 != 2) {
                                    zzaff = zzaff2;
                                    i5 = zzm3;
                                    i12++;
                                    zzaff2 = zzaff;
                                    zzm3 = i5;
                                    i6 = 4;
                                }
                                zzafc.zzc(32);
                                zzafc.zzc(32);
                                int zzb20 = zzafc.zzb(i6) + 1;
                                zzafc.zzc(1);
                                if (i13 != 1) {
                                    zzaff = zzaff2;
                                    i5 = zzm3;
                                    j2 = ((long) zzb17) * ((long) zzb18);
                                } else if (zzb17 != 0) {
                                    zzaff = zzaff2;
                                    i5 = zzm3;
                                    j2 = (long) Math.floor(Math.pow((double) ((long) zzb18), 1.0d / ((double) ((long) zzb17))));
                                } else {
                                    zzaff = zzaff2;
                                    i5 = zzm3;
                                    j2 = 0;
                                }
                                zzafc.zzc((int) (j2 * ((long) zzb20)));
                                i12++;
                                zzaff2 = zzaff;
                                zzm3 = i5;
                                i6 = 4;
                            } else {
                                throw zzch.zza("lookup type greater than 2 not decodable: " + zzb19, (Throwable) null);
                            }
                        } else {
                            throw zzch.zza("expected code book to start with [0x56, 0x43, 0x42] at " + zzafc.zza(), (Throwable) null);
                        }
                    }
                }
            }
            this.zza = zzalj;
            zzalj zzalj2 = this.zza;
            if (zzalj2 == null) {
                return true;
            }
            ArrayList arrayList = new ArrayList();
            zzaff zzaff4 = zzalj2.zza;
            arrayList.add(zzaff4.zzg);
            arrayList.add(zzalj2.zzc);
            zzcd zzb21 = zzafg.zzb(zzgbc.zzl(zzalj2.zzb.zzb));
            zzal zzal = new zzal();
            zzal.zzX("audio/vorbis");
            zzal.zzx(zzaff4.zzd);
            zzal.zzS(zzaff4.zzc);
            zzal.zzy(zzaff4.zza);
            zzal.zzY(zzaff4.zzb);
            zzal.zzL(arrayList);
            zzal.zzQ(zzb21);
            zzalf2.zza = zzal.zzad();
            return true;
        } else if (zzalf2.zza != null) {
            return false;
        } else {
            throw null;
        }
    }
}
