package com.google.android.gms.internal.ads;

import android.media.MediaCodecInfo;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
final class zztq {
    public static int zza(MediaCodecInfo.VideoCapabilities videoCapabilities, int width, int height, double frameRate) {
        List<MediaCodecInfo.VideoCapabilities.PerformancePoint> supportedPerformancePoints;
        List<MediaCodecInfo.VideoCapabilities.PerformancePoint> supportedPerformancePoints2 = videoCapabilities.getSupportedPerformancePoints();
        if (supportedPerformancePoints2 == null || supportedPerformancePoints2.isEmpty()) {
            return 0;
        }
        int zzb = zzb(supportedPerformancePoints2, new MediaCodecInfo.VideoCapabilities.PerformancePoint(width, height, (int) frameRate));
        boolean z = true;
        if (zzb == 1 && zztr.zza == null) {
            if (zzgd.zza >= 35) {
                z = false;
            } else {
                try {
                    zzal zzal = new zzal();
                    zzal.zzX("video/avc");
                    zzan zzad = zzal.zzad();
                    if (zzad.zzn != null) {
                        List zzf = zzuj.zzf(zztx.zza, zzad, false, false);
                        int i = 0;
                        while (true) {
                            if (i >= zzf.size()) {
                                break;
                            } else if (((zztp) zzf.get(i)).zzd == null || ((zztp) zzf.get(i)).zzd.getVideoCapabilities() == null || (supportedPerformancePoints = ((zztp) zzf.get(i)).zzd.getVideoCapabilities().getSupportedPerformancePoints()) == null || supportedPerformancePoints.isEmpty()) {
                                i++;
                            } else if (zzb(supportedPerformancePoints, new MediaCodecInfo.VideoCapabilities.PerformancePoint(1280, 720, 60)) != 1) {
                                z = false;
                            }
                        }
                    }
                } catch (zzud e) {
                }
            }
            zztr.zza = Boolean.valueOf(z);
            if (zztr.zza.booleanValue()) {
                return 0;
            }
        }
        return zzb;
    }

    private static int zzb(List list, MediaCodecInfo.VideoCapabilities.PerformancePoint performancePoint) {
        for (int i = 0; i < list.size(); i++) {
            if (((MediaCodecInfo.VideoCapabilities.PerformancePoint) list.get(i)).covers(performancePoint)) {
                return 2;
            }
        }
        return 1;
    }
}
