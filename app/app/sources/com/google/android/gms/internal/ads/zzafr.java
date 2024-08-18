package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
final class zzafr implements zzafj {
    public final zzgbc zza;
    private final int zzb;

    private zzafr(int i, zzgbc zzgbc) {
        this.zzb = i;
        this.zza = zzgbc;
    }

    public static zzafr zzc(int i, zzfu zzfu) {
        zzafj zzafj;
        String str;
        String str2;
        zzfu zzfu2 = zzfu;
        zzgaz zzgaz = new zzgaz();
        int zze = zzfu.zze();
        int i2 = -2;
        while (zzfu.zzb() > 8) {
            int zzi = zzfu.zzi();
            int zzd = zzfu.zzd() + zzfu.zzi();
            zzfu2.zzJ(zzd);
            if (zzi != 1414744396) {
                switch (zzi) {
                    case 1718776947:
                        if (i2 != 2) {
                            if (i2 != 1) {
                                zzfk.zzf("StreamFormatChunk", "Ignoring strf box for unsupported track type: ".concat(zzgd.zzC(i2)));
                                zzafj = null;
                                break;
                            } else {
                                int zzk = zzfu.zzk();
                                switch (zzk) {
                                    case 1:
                                        str = "audio/raw";
                                        break;
                                    case 85:
                                        str = "audio/mpeg";
                                        break;
                                    case 255:
                                        str = "audio/mp4a-latm";
                                        break;
                                    case 8192:
                                        str = "audio/ac3";
                                        break;
                                    case 8193:
                                        str = "audio/vnd.dts";
                                        break;
                                    default:
                                        str = null;
                                        break;
                                }
                                if (str != null) {
                                    int zzk2 = zzfu.zzk();
                                    int zzi2 = zzfu.zzi();
                                    zzfu2.zzL(6);
                                    int zzl = zzgd.zzl(zzfu.zzq());
                                    int zzk3 = zzfu.zzk();
                                    byte[] bArr = new byte[zzk3];
                                    zzfu2.zzG(bArr, 0, zzk3);
                                    zzal zzal = new zzal();
                                    zzal.zzX(str);
                                    zzal.zzy(zzk2);
                                    zzal.zzY(zzi2);
                                    if ("audio/raw".equals(str) && zzl != 0) {
                                        zzal.zzR(zzl);
                                    }
                                    if ("audio/mp4a-latm".equals(str) && zzk3 > 0) {
                                        zzal.zzL(zzgbc.zzn(bArr));
                                    }
                                    zzafj = new zzafs(zzal.zzad());
                                    break;
                                } else {
                                    zzfk.zzf("StreamFormatChunk", "Ignoring track with unsupported format tag " + zzk);
                                    zzafj = null;
                                    break;
                                }
                            }
                        } else {
                            zzfu2.zzL(4);
                            int zzi3 = zzfu.zzi();
                            int zzi4 = zzfu.zzi();
                            zzfu2.zzL(4);
                            int zzi5 = zzfu.zzi();
                            switch (zzi5) {
                                case 808802372:
                                case 877677894:
                                case 1145656883:
                                case 1145656920:
                                case 1482049860:
                                case 1684633208:
                                case 2021026148:
                                    str2 = "video/mp4v-es";
                                    break;
                                case 826496577:
                                case 828601953:
                                case 875967048:
                                    str2 = "video/avc";
                                    break;
                                case 842289229:
                                    str2 = "video/mp42";
                                    break;
                                case 859066445:
                                    str2 = "video/mp43";
                                    break;
                                case 1196444237:
                                case 1735420525:
                                    str2 = "video/mjpeg";
                                    break;
                                default:
                                    str2 = null;
                                    break;
                            }
                            if (str2 != null) {
                                zzal zzal2 = new zzal();
                                zzal2.zzac(zzi3);
                                zzal2.zzI(zzi4);
                                zzal2.zzX(str2);
                                zzafj = new zzafs(zzal2.zzad());
                                break;
                            } else {
                                zzfk.zzf("StreamFormatChunk", "Ignoring track with unsupported compression " + zzi5);
                                zzafj = null;
                                break;
                            }
                        }
                    case 1751742049:
                        zzafj = zzafo.zzb(zzfu);
                        break;
                    case 1752331379:
                        zzafj = zzafp.zzb(zzfu);
                        break;
                    case 1852994675:
                        zzafj = zzaft.zzb(zzfu);
                        break;
                    default:
                        zzafj = null;
                        break;
                }
            } else {
                zzafj = zzc(zzfu.zzi(), zzfu2);
            }
            if (zzafj != null) {
                if (zzafj.zza() == 1752331379) {
                    int i3 = ((zzafp) zzafj).zza;
                    switch (i3) {
                        case 1935960438:
                            i2 = 2;
                            break;
                        case 1935963489:
                            i2 = 1;
                            break;
                        case 1937012852:
                            i2 = 3;
                            break;
                        default:
                            zzfk.zzf("AviStreamHeaderChunk", "Found unsupported streamType fourCC: ".concat(String.valueOf(Integer.toHexString(i3))));
                            i2 = -1;
                            break;
                    }
                }
                zzgaz.zzf(zzafj);
            }
            zzfu2.zzK(zzd);
            zzfu2.zzJ(zze);
        }
        return new zzafr(i, zzgaz.zzi());
    }

    public final int zza() {
        return this.zzb;
    }

    public final zzafj zzb(Class cls) {
        zzgbc zzgbc = this.zza;
        int size = zzgbc.size();
        int i = 0;
        while (i < size) {
            zzafj zzafj = (zzafj) zzgbc.get(i);
            i++;
            if (zzafj.getClass() == cls) {
                return zzafj;
            }
        }
        return null;
    }
}
