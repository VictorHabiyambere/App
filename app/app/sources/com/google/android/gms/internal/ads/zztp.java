package com.google.android.gms.internal.ads;

import android.graphics.Point;
import android.media.MediaCodecInfo;
import android.util.Pair;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zztp {
    public final String zza;
    public final String zzb;
    public final String zzc;
    public final MediaCodecInfo.CodecCapabilities zzd;
    public final boolean zze;
    public final boolean zzf;
    public final boolean zzg;
    private final boolean zzh;

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0041  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0050  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0060  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.android.gms.internal.ads.zztp zzc(java.lang.String r12, java.lang.String r13, java.lang.String r14, android.media.MediaCodecInfo.CodecCapabilities r15, boolean r16, boolean r17, boolean r18, boolean r19, boolean r20) {
        /*
            r1 = r12
            r4 = r15
            com.google.android.gms.internal.ads.zztp r11 = new com.google.android.gms.internal.ads.zztp
            r0 = 1
            r2 = 0
            if (r4 == 0) goto L_0x003e
            java.lang.String r3 = "adaptive-playback"
            boolean r3 = r15.isFeatureSupported(r3)
            if (r3 == 0) goto L_0x003e
            int r3 = com.google.android.gms.internal.ads.zzgd.zza
            r5 = 22
            if (r3 > r5) goto L_0x003c
            java.lang.String r3 = com.google.android.gms.internal.ads.zzgd.zzd
            java.lang.String r5 = "ODROID-XU3"
            boolean r3 = r5.equals(r3)
            if (r3 != 0) goto L_0x002a
            java.lang.String r3 = "Nexus 10"
            java.lang.String r5 = com.google.android.gms.internal.ads.zzgd.zzd
            boolean r3 = r3.equals(r5)
            if (r3 == 0) goto L_0x003c
        L_0x002a:
            java.lang.String r3 = "OMX.Exynos.AVC.Decoder"
            boolean r3 = r3.equals(r12)
            if (r3 != 0) goto L_0x003e
            java.lang.String r3 = "OMX.Exynos.AVC.Decoder.secure"
            boolean r3 = r3.equals(r12)
            if (r3 == 0) goto L_0x003c
            r8 = r2
            goto L_0x003f
        L_0x003c:
            r8 = r0
            goto L_0x003f
        L_0x003e:
            r8 = r2
        L_0x003f:
            if (r4 == 0) goto L_0x004d
            int r3 = com.google.android.gms.internal.ads.zzgd.zza
            java.lang.String r3 = "tunneled-playback"
            boolean r3 = r15.isFeatureSupported(r3)
            if (r3 == 0) goto L_0x004d
            r9 = r0
            goto L_0x004e
        L_0x004d:
            r9 = r2
        L_0x004e:
            if (r20 != 0) goto L_0x0060
            if (r4 == 0) goto L_0x005e
            int r3 = com.google.android.gms.internal.ads.zzgd.zza
            java.lang.String r3 = "secure-playback"
            boolean r3 = r15.isFeatureSupported(r3)
            if (r3 == 0) goto L_0x005e
            r10 = r0
            goto L_0x0061
        L_0x005e:
            r10 = r2
            goto L_0x0061
        L_0x0060:
            r10 = r0
        L_0x0061:
            r0 = r11
            r1 = r12
            r2 = r13
            r3 = r14
            r4 = r15
            r5 = r16
            r6 = r17
            r7 = r18
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10)
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zztp.zzc(java.lang.String, java.lang.String, java.lang.String, android.media.MediaCodecInfo$CodecCapabilities, boolean, boolean, boolean, boolean, boolean):com.google.android.gms.internal.ads.zztp");
    }

    private static Point zzi(MediaCodecInfo.VideoCapabilities videoCapabilities, int i, int i2) {
        int widthAlignment = videoCapabilities.getWidthAlignment();
        int heightAlignment = videoCapabilities.getHeightAlignment();
        int i3 = zzgd.zza;
        return new Point((((i + widthAlignment) - 1) / widthAlignment) * widthAlignment, (((i2 + heightAlignment) - 1) / heightAlignment) * heightAlignment);
    }

    private final void zzj(String str) {
        String str2 = zzgd.zze;
        zzfk.zzb("MediaCodecInfo", "NoSupport [" + str + "] [" + this.zza + ", " + this.zzb + "] [" + str2 + "]");
    }

    private static boolean zzk(MediaCodecInfo.VideoCapabilities videoCapabilities, int i, int i2, double d) {
        Point zzi = zzi(videoCapabilities, i, i2);
        int i3 = zzi.x;
        int i4 = zzi.y;
        if (d == -1.0d || d < 1.0d) {
            return videoCapabilities.isSizeSupported(i3, i4);
        }
        return videoCapabilities.areSizeAndRateSupported(i3, i4, Math.floor(d));
    }

    private final boolean zzl(zzan zzan, boolean z) {
        int i;
        MediaCodecInfo.VideoCapabilities videoCapabilities;
        Pair zza2 = zzuj.zza(zzan);
        if (zza2 != null) {
            int intValue = ((Integer) zza2.first).intValue();
            int intValue2 = ((Integer) zza2.second).intValue();
            int i2 = 8;
            if ("video/dolby-vision".equals(zzan.zzn)) {
                if ("video/avc".equals(this.zzb)) {
                    intValue = 8;
                    intValue2 = 0;
                } else if ("video/hevc".equals(this.zzb)) {
                    intValue = 2;
                    intValue2 = 0;
                }
            }
            if (!this.zzh) {
                if (intValue == 42) {
                    intValue = 42;
                }
            }
            MediaCodecInfo.CodecProfileLevel[] zzh2 = zzh();
            if (zzgd.zza <= 23 && "video/x-vnd.on2.vp9".equals(this.zzb) && zzh2.length == 0) {
                MediaCodecInfo.CodecCapabilities codecCapabilities = this.zzd;
                if (codecCapabilities == null || (videoCapabilities = codecCapabilities.getVideoCapabilities()) == null) {
                    i = 0;
                } else {
                    i = videoCapabilities.getBitrateRange().getUpper().intValue();
                }
                if (i >= 180000000) {
                    i2 = 1024;
                } else if (i >= 120000000) {
                    i2 = 512;
                } else if (i >= 60000000) {
                    i2 = 256;
                } else if (i >= 30000000) {
                    i2 = 128;
                } else if (i >= 18000000) {
                    i2 = 64;
                } else if (i >= 12000000) {
                    i2 = 32;
                } else if (i >= 7200000) {
                    i2 = 16;
                } else if (i < 3600000) {
                    i2 = i >= 1800000 ? 4 : i >= 800000 ? 2 : 1;
                }
                MediaCodecInfo.CodecProfileLevel codecProfileLevel = new MediaCodecInfo.CodecProfileLevel();
                codecProfileLevel.profile = 1;
                codecProfileLevel.level = i2;
                zzh2 = new MediaCodecInfo.CodecProfileLevel[]{codecProfileLevel};
            }
            int length = zzh2.length;
            int i3 = 0;
            while (i3 < length) {
                MediaCodecInfo.CodecProfileLevel codecProfileLevel2 = zzh2[i3];
                if (codecProfileLevel2.profile != intValue || ((codecProfileLevel2.level < intValue2 && z) || ("video/hevc".equals(this.zzb) && intValue == 2 && ("sailfish".equals(zzgd.zzb) || "marlin".equals(zzgd.zzb))))) {
                    i3++;
                }
            }
            zzj("codec.profileLevel, " + zzan.zzk + ", " + this.zzc);
            return false;
        }
        return true;
    }

    private final boolean zzm(zzan zzan) {
        return this.zzb.equals(zzan.zzn) || this.zzb.equals(zzuj.zzc(zzan));
    }

    public final String toString() {
        return this.zza;
    }

    public final Point zza(int i, int i2) {
        MediaCodecInfo.VideoCapabilities videoCapabilities;
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.zzd;
        if (codecCapabilities == null || (videoCapabilities = codecCapabilities.getVideoCapabilities()) == null) {
            return null;
        }
        return zzi(videoCapabilities, i, i2);
    }

    public final zziy zzb(zzan zzan, zzan zzan2) {
        int i;
        int i2;
        int i3 = true != zzgd.zzG(zzan.zzn, zzan2.zzn) ? 8 : 0;
        if (this.zzh) {
            if (zzan.zzv != zzan2.zzv) {
                i3 |= 1024;
            }
            if (!this.zze && !(zzan.zzs == zzan2.zzs && zzan.zzt == zzan2.zzt)) {
                i3 |= 512;
            }
            if ((!zzt.zzg(zzan.zzz) || !zzt.zzg(zzan2.zzz)) && !zzgd.zzG(zzan.zzz, zzan2.zzz)) {
                i3 |= 2048;
            }
            String str = this.zza;
            if (zzgd.zzd.startsWith("SM-T230") && "OMX.MARVELL.VIDEO.HW.CODA7542DECODER".equals(str) && !zzan.zzd(zzan2)) {
                i3 |= 2;
            }
            if (i3 == 0) {
                String str2 = this.zza;
                if (true != zzan.zzd(zzan2)) {
                    i2 = 2;
                } else {
                    i2 = 3;
                }
                return new zziy(str2, zzan, zzan2, i2, 0);
            }
            i = i3;
        } else {
            if (zzan.zzA != zzan2.zzA) {
                i3 |= 4096;
            }
            if (zzan.zzB != zzan2.zzB) {
                i3 |= 8192;
            }
            if (zzan.zzC != zzan2.zzC) {
                i3 |= 16384;
            }
            if (i3 == 0 && "audio/mp4a-latm".equals(this.zzb)) {
                Pair zza2 = zzuj.zza(zzan);
                Pair zza3 = zzuj.zza(zzan2);
                if (!(zza2 == null || zza3 == null)) {
                    int intValue = ((Integer) zza2.first).intValue();
                    int intValue2 = ((Integer) zza3.first).intValue();
                    if (intValue == 42 && intValue2 == 42) {
                        return new zziy(this.zza, zzan, zzan2, 3, 0);
                    }
                }
            }
            if (!zzan.zzd(zzan2)) {
                i3 |= 32;
            }
            if ("audio/opus".equals(this.zzb)) {
                i3 |= 2;
            }
            if (i3 == 0) {
                return new zziy(this.zza, zzan, zzan2, 1, 0);
            }
            i = i3;
        }
        return new zziy(this.zza, zzan, zzan2, 0, i);
    }

    public final boolean zzd(zzan zzan) {
        if (!zzm(zzan) || !zzl(zzan, false)) {
            return false;
        }
        return true;
    }

    public final boolean zze(zzan zzan) throws zzud {
        int i;
        if (!zzm(zzan) || !zzl(zzan, true)) {
            return false;
        }
        if (!this.zzh) {
            int i2 = zzgd.zza;
            int i3 = zzan.zzB;
            if (i3 != -1) {
                MediaCodecInfo.CodecCapabilities codecCapabilities = this.zzd;
                if (codecCapabilities == null) {
                    zzj("sampleRate.caps");
                    return false;
                }
                MediaCodecInfo.AudioCapabilities audioCapabilities = codecCapabilities.getAudioCapabilities();
                if (audioCapabilities == null) {
                    zzj("sampleRate.aCaps");
                    return false;
                } else if (!audioCapabilities.isSampleRateSupported(i3)) {
                    zzj("sampleRate.support, " + i3);
                    return false;
                }
            }
            int i4 = zzan.zzA;
            if (i4 == -1) {
                return true;
            }
            MediaCodecInfo.CodecCapabilities codecCapabilities2 = this.zzd;
            if (codecCapabilities2 == null) {
                zzj("channelCount.caps");
            } else {
                MediaCodecInfo.AudioCapabilities audioCapabilities2 = codecCapabilities2.getAudioCapabilities();
                if (audioCapabilities2 == null) {
                    zzj("channelCount.aCaps");
                } else {
                    String str = this.zza;
                    String str2 = this.zzb;
                    int maxInputChannelCount = audioCapabilities2.getMaxInputChannelCount();
                    if (maxInputChannelCount <= 1 && ((zzgd.zza < 26 || maxInputChannelCount <= 0) && !"audio/mpeg".equals(str2) && !"audio/3gpp".equals(str2) && !"audio/amr-wb".equals(str2) && !"audio/mp4a-latm".equals(str2) && !"audio/vorbis".equals(str2) && !"audio/opus".equals(str2) && !"audio/raw".equals(str2) && !"audio/flac".equals(str2) && !"audio/g711-alaw".equals(str2) && !"audio/g711-mlaw".equals(str2) && !"audio/gsm".equals(str2))) {
                        if ("audio/ac3".equals(str2)) {
                            i = 6;
                        } else {
                            i = "audio/eac3".equals(str2) ? 16 : 30;
                        }
                        zzfk.zzf("MediaCodecInfo", "AssumedMaxChannelAdjustment: " + str + ", [" + maxInputChannelCount + " to " + i + "]");
                        maxInputChannelCount = i;
                    }
                    if (maxInputChannelCount >= i4) {
                        return true;
                    }
                    zzj("channelCount.support, " + i4);
                }
            }
            return false;
        } else if (zzan.zzs <= 0 || zzan.zzt <= 0) {
            return true;
        } else {
            int i5 = zzgd.zza;
            return zzg(zzan.zzs, zzan.zzt, (double) zzan.zzu);
        }
    }

    public final boolean zzf(zzan zzan) {
        if (this.zzh) {
            return this.zze;
        }
        Pair zza2 = zzuj.zza(zzan);
        return zza2 != null && ((Integer) zza2.first).intValue() == 42;
    }

    public final boolean zzg(int i, int i2, double d) {
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.zzd;
        if (codecCapabilities == null) {
            zzj("sizeAndRate.caps");
            return false;
        }
        MediaCodecInfo.VideoCapabilities videoCapabilities = codecCapabilities.getVideoCapabilities();
        if (videoCapabilities == null) {
            zzj("sizeAndRate.vCaps");
            return false;
        }
        if (zzgd.zza >= 29) {
            int zza2 = zztr.zza(videoCapabilities, i, i2, d);
            if (zza2 != 2) {
                if (zza2 == 1) {
                    zzj("sizeAndRate.cover, " + i + "x" + i2 + "@" + d);
                    return false;
                }
            }
            return true;
        }
        if (!zzk(videoCapabilities, i, i2, d)) {
            if (i >= i2 || (("OMX.MTK.VIDEO.DECODER.HEVC".equals(this.zza) && "mcv5a".equals(zzgd.zzb)) || !zzk(videoCapabilities, i2, i, d))) {
                zzj("sizeAndRate.support, " + i + "x" + i2 + "@" + d);
                return false;
            }
            zzfk.zzb("MediaCodecInfo", "AssumedSupport [" + ("sizeAndRate.rotated, " + i + "x" + i2 + "@" + d) + "] [" + this.zza + ", " + this.zzb + "] [" + zzgd.zze + "]");
        }
        return true;
    }

    public final MediaCodecInfo.CodecProfileLevel[] zzh() {
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.zzd;
        if (codecCapabilities == null || codecCapabilities.profileLevels == null) {
            return new MediaCodecInfo.CodecProfileLevel[0];
        }
        return this.zzd.profileLevels;
    }

    zztp(String str, String str2, String str3, MediaCodecInfo.CodecCapabilities codecCapabilities, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6) {
        if (str != null) {
            this.zza = str;
            this.zzb = str2;
            this.zzc = str3;
            this.zzd = codecCapabilities;
            this.zzg = z;
            this.zze = z4;
            this.zzf = z6;
            this.zzh = zzcg.zzh(str2);
            return;
        }
        throw null;
    }
}
