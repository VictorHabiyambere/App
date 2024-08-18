package com.google.android.gms.internal.ads;

import androidx.core.location.LocationRequestCompat;
import com.google.firebase.ml.modeldownloader.FirebaseMlException;
import java.nio.ByteBuffer;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzact {
    public static final /* synthetic */ int zza = 0;
    private static final int[] zzb = {1, 2, 3, 6};
    private static final int[] zzc = {48000, 44100, 32000};
    private static final int[] zzd = {24000, 22050, 16000};
    private static final int[] zze = {2, 1, 2, 3, 3, 4, 4, 5};
    private static final int[] zzf = {32, 40, 48, 56, 64, 80, 96, 112, 128, 160, 192, 224, 256, 320, 384, 448, 512, 576, 640};
    private static final int[] zzg = {69, 87, LocationRequestCompat.QUALITY_LOW_POWER, FirebaseMlException.DOWNLOAD_URL_EXPIRED, 139, 174, 208, 243, 278, 348, 417, 487, 557, 696, 835, 975, 1114, 1253, 1393};

    public static int zza(ByteBuffer byteBuffer) {
        int i = 3;
        if (((byteBuffer.get(byteBuffer.position() + 5) & 248) >> 3) <= 10) {
            return 1536;
        }
        if (((byteBuffer.get(byteBuffer.position() + 4) & 192) >> 6) != 3) {
            i = (byteBuffer.get(byteBuffer.position() + 4) & 48) >> 4;
        }
        return zzb[i] * 256;
    }

    public static int zzb(byte[] bArr) {
        if (bArr.length < 6) {
            return -1;
        }
        if (((bArr[5] & 248) >> 3) > 10) {
            int i = ((bArr[3] & 255) | ((bArr[2] & 7) << 8)) + 1;
            return i + i;
        }
        byte b = bArr[4];
        return zzf((b & 192) >> 6, b & 63);
    }

    public static zzan zzc(zzfu zzfu, String str, String str2, zzae zzae) {
        zzft zzft = new zzft();
        zzft.zzi(zzfu);
        int i = zzc[zzft.zzd(2)];
        zzft.zzm(8);
        int i2 = zze[zzft.zzd(3)];
        if (zzft.zzd(1) != 0) {
            i2++;
        }
        int i3 = zzf[zzft.zzd(5)] * 1000;
        zzft.zze();
        zzfu.zzK(zzft.zzb());
        zzal zzal = new zzal();
        zzal.zzK(str);
        zzal.zzX("audio/ac3");
        zzal.zzy(i2);
        zzal.zzY(i);
        zzal.zzE(zzae);
        zzal.zzO(str2);
        zzal.zzx(i3);
        zzal.zzS(i3);
        return zzal.zzad();
    }

    public static zzan zzd(zzfu zzfu, String str, String str2, zzae zzae) {
        String str3;
        zzft zzft = new zzft();
        zzft.zzi(zzfu);
        int zzd2 = zzft.zzd(13) * 1000;
        zzft.zzm(3);
        int i = zzc[zzft.zzd(2)];
        zzft.zzm(10);
        int i2 = zze[zzft.zzd(3)];
        if (zzft.zzd(1) != 0) {
            i2++;
        }
        zzft.zzm(3);
        int zzd3 = zzft.zzd(4);
        zzft.zzm(1);
        if (zzd3 > 0) {
            zzft.zzm(6);
            if (zzft.zzd(1) != 0) {
                i2 += 2;
            }
            zzft.zzm(1);
        }
        if (zzft.zza() > 7) {
            zzft.zzm(7);
            if (zzft.zzd(1) != 0) {
                str3 = "audio/eac3-joc";
                zzft.zze();
                zzfu.zzK(zzft.zzb());
                zzal zzal = new zzal();
                zzal.zzK(str);
                zzal.zzX(str3);
                zzal.zzy(i2);
                zzal.zzY(i);
                zzal.zzE(zzae);
                zzal.zzO(str2);
                zzal.zzS(zzd2);
                return zzal.zzad();
            }
        }
        str3 = "audio/eac3";
        zzft.zze();
        zzfu.zzK(zzft.zzb());
        zzal zzal2 = new zzal();
        zzal2.zzK(str);
        zzal2.zzX(str3);
        zzal2.zzy(i2);
        zzal2.zzY(i);
        zzal2.zzE(zzae);
        zzal2.zzO(str2);
        zzal2.zzS(zzd2);
        return zzal2.zzad();
    }

    public static zzacs zze(zzft zzft) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        String str;
        String str2;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        zzft zzft2 = zzft;
        int zzc2 = zzft.zzc();
        zzft2.zzm(40);
        int zzd2 = zzft2.zzd(5);
        zzft2.zzk(zzc2);
        int i13 = -1;
        if (zzd2 > 10) {
            zzft2.zzm(16);
            switch (zzft2.zzd(2)) {
                case 0:
                    i13 = 0;
                    break;
                case 1:
                    i13 = 1;
                    break;
                case 2:
                    i13 = 2;
                    break;
            }
            zzft2.zzm(3);
            int zzd3 = zzft2.zzd(11) + 1;
            int zzd4 = zzft2.zzd(2);
            if (zzd4 == 3) {
                i10 = zzd[zzft2.zzd(2)];
                i8 = 6;
                i9 = 3;
            } else {
                int zzd5 = zzft2.zzd(2);
                int i14 = zzb[zzd5];
                i9 = zzd5;
                i10 = zzc[zzd4];
                i8 = i14;
            }
            int i15 = zzd3 + zzd3;
            int i16 = (i15 * i10) / (i8 * 32);
            int zzd6 = zzft2.zzd(3);
            boolean zzo = zzft.zzo();
            int i17 = zze[zzd6] + (zzo ? 1 : 0);
            zzft2.zzm(10);
            if (zzft.zzo()) {
                zzft2.zzm(8);
            }
            if (zzd6 == 0) {
                zzft2.zzm(5);
                if (zzft.zzo()) {
                    zzft2.zzm(8);
                    i11 = 0;
                    zzd6 = 0;
                } else {
                    i11 = 0;
                    zzd6 = 0;
                }
            } else {
                i11 = zzd6;
            }
            if (i13 != 1) {
                i12 = i13;
            } else if (zzft.zzo()) {
                zzft2.zzm(16);
                i12 = 1;
            } else {
                i12 = 1;
            }
            if (zzft.zzo()) {
                if (i11 > 2) {
                    zzft2.zzm(2);
                }
                if ((i11 & 1) != 0 && i11 > 2) {
                    zzft2.zzm(6);
                }
                if ((i11 & 4) != 0) {
                    zzft2.zzm(6);
                }
                if (zzo && zzft.zzo()) {
                    zzft2.zzm(5);
                }
                if (i12 == 0) {
                    if (zzft.zzo()) {
                        zzft2.zzm(6);
                    }
                    if (i11 == 0 && zzft.zzo()) {
                        zzft2.zzm(6);
                    }
                    if (zzft.zzo()) {
                        zzft2.zzm(6);
                    }
                    int zzd7 = zzft2.zzd(2);
                    if (zzd7 == 1) {
                        zzft2.zzm(5);
                    } else if (zzd7 == 2) {
                        zzft2.zzm(12);
                    } else if (zzd7 == 3) {
                        int zzd8 = zzft2.zzd(5);
                        if (zzft.zzo()) {
                            zzft2.zzm(5);
                            if (zzft.zzo()) {
                                zzft2.zzm(4);
                            }
                            if (zzft.zzo()) {
                                zzft2.zzm(4);
                            }
                            if (zzft.zzo()) {
                                zzft2.zzm(4);
                            }
                            if (zzft.zzo()) {
                                zzft2.zzm(4);
                            }
                            if (zzft.zzo()) {
                                zzft2.zzm(4);
                            }
                            if (zzft.zzo()) {
                                zzft2.zzm(4);
                            }
                            if (zzft.zzo()) {
                                zzft2.zzm(4);
                            }
                            if (zzft.zzo()) {
                                if (zzft.zzo()) {
                                    zzft2.zzm(4);
                                }
                                if (zzft.zzo()) {
                                    zzft2.zzm(4);
                                }
                            }
                        }
                        if (zzft.zzo()) {
                            zzft2.zzm(5);
                            if (zzft.zzo()) {
                                zzft2.zzm(7);
                                if (zzft.zzo()) {
                                    zzft2.zzm(8);
                                }
                            }
                        }
                        zzft2.zzm((zzd8 + 2) * 8);
                        zzft.zze();
                    }
                    if (i11 < 2) {
                        if (zzft.zzo()) {
                            zzft2.zzm(14);
                        }
                        if (zzd6 == 0 && zzft.zzo()) {
                            zzft2.zzm(14);
                        }
                    }
                    if (zzft.zzo()) {
                        if (i9 == 0) {
                            zzft2.zzm(5);
                            i12 = 0;
                            i9 = 0;
                        } else {
                            for (int i18 = 0; i18 < i8; i18++) {
                                if (zzft.zzo()) {
                                    zzft2.zzm(5);
                                }
                            }
                        }
                    }
                    i12 = 0;
                }
            }
            if (zzft.zzo()) {
                zzft2.zzm(5);
                if (i11 == 2) {
                    zzft2.zzm(4);
                    i11 = 2;
                }
                if (i11 >= 6) {
                    zzft2.zzm(2);
                }
                if (zzft.zzo()) {
                    zzft2.zzm(8);
                }
                if (i11 == 0 && zzft.zzo()) {
                    zzft2.zzm(8);
                }
                if (zzd4 < 3) {
                    zzft.zzl();
                }
            }
            if (i12 == 0 && i9 != 3) {
                zzft.zzl();
            }
            if (i12 == 2 && (i9 == 3 || zzft.zzo())) {
                zzft2.zzm(6);
            }
            str = (zzft.zzo() && zzft2.zzd(6) == 1 && zzft2.zzd(8) == 1) ? "audio/eac3-joc" : "audio/eac3";
            i6 = i13;
            i3 = i15;
            i4 = i10;
            i2 = i8 * 256;
            i = i16;
            i5 = i17;
        } else {
            zzft2.zzm(32);
            int zzd9 = zzft2.zzd(2);
            if (zzd9 == 3) {
                str2 = null;
            } else {
                str2 = "audio/ac3";
            }
            int zzd10 = zzft2.zzd(6);
            int i19 = zzf[zzd10 / 2] * 1000;
            int zzf2 = zzf(zzd9, zzd10);
            zzft2.zzm(8);
            int zzd11 = zzft2.zzd(3);
            if (!((zzd11 & 1) == 0 || zzd11 == 1)) {
                zzft2.zzm(2);
            }
            if ((zzd11 & 4) != 0) {
                zzft2.zzm(2);
            }
            if (zzd11 == 2) {
                zzft2.zzm(2);
            }
            if (zzd9 < 3) {
                i7 = zzc[zzd9];
            } else {
                i7 = -1;
            }
            i6 = -1;
            str = str2;
            i = i19;
            i3 = zzf2;
            i4 = i7;
            i2 = 1536;
            i5 = zze[zzd11] + (zzft.zzo() ? 1 : 0);
        }
        return new zzacs(str, i6, i5, i4, i3, i2, i, (zzacr) null);
    }

    private static int zzf(int i, int i2) {
        int i3;
        if (i < 0 || i >= 3 || i2 < 0 || (i3 = i2 >> 1) >= 19) {
            return -1;
        }
        int i4 = zzc[i];
        if (i4 == 44100) {
            int i5 = zzg[i3] + (i2 & 1);
            return i5 + i5;
        }
        int i6 = zzf[i3];
        return i4 == 32000 ? i6 * 6 : i6 * 4;
    }
}
