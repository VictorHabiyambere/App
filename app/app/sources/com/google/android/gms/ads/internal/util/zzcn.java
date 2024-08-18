package com.google.android.gms.ads.internal.util;

import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.util.Range;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzcn {
    private static final Map zza = new HashMap();
    private static List zzb;
    private static final Object zzc = new Object();

    public static List zza(String str) {
        synchronized (zzc) {
            if (zza.containsKey(str)) {
                List list = (List) zza.get(str);
                return list;
            }
            try {
                synchronized (zzc) {
                    if (zzb == null) {
                        zzb = Arrays.asList(new MediaCodecList(0).getCodecInfos());
                    }
                }
                ArrayList arrayList = new ArrayList();
                for (MediaCodecInfo mediaCodecInfo : zzb) {
                    if (!mediaCodecInfo.isEncoder() && Arrays.asList(mediaCodecInfo.getSupportedTypes()).contains(str)) {
                        HashMap hashMap = new HashMap();
                        hashMap.put("codecName", mediaCodecInfo.getName());
                        MediaCodecInfo.CodecCapabilities capabilitiesForType = mediaCodecInfo.getCapabilitiesForType(str);
                        ArrayList arrayList2 = new ArrayList();
                        for (MediaCodecInfo.CodecProfileLevel codecProfileLevel : capabilitiesForType.profileLevels) {
                            arrayList2.add(new Integer[]{Integer.valueOf(codecProfileLevel.profile), Integer.valueOf(codecProfileLevel.level)});
                        }
                        hashMap.put("profileLevels", arrayList2);
                        MediaCodecInfo.VideoCapabilities videoCapabilities = capabilitiesForType.getVideoCapabilities();
                        hashMap.put("bitRatesBps", zzb(videoCapabilities.getBitrateRange()));
                        hashMap.put("widthAlignment", Integer.valueOf(videoCapabilities.getWidthAlignment()));
                        hashMap.put("heightAlignment", Integer.valueOf(videoCapabilities.getHeightAlignment()));
                        hashMap.put("frameRates", zzb(videoCapabilities.getSupportedFrameRates()));
                        hashMap.put("widths", zzb(videoCapabilities.getSupportedWidths()));
                        hashMap.put("heights", zzb(videoCapabilities.getSupportedHeights()));
                        hashMap.put("instancesLimit", Integer.valueOf(capabilitiesForType.getMaxSupportedInstances()));
                        arrayList.add(hashMap);
                    }
                }
                zza.put(str, arrayList);
                return arrayList;
            } catch (LinkageError | RuntimeException e) {
                HashMap hashMap2 = new HashMap();
                hashMap2.put("error", e.getClass().getSimpleName());
                ArrayList arrayList3 = new ArrayList();
                arrayList3.add(hashMap2);
                zza.put(str, arrayList3);
                return arrayList3;
            }
        }
    }

    private static Integer[] zzb(Range range) {
        return new Integer[]{(Integer) range.getLower(), (Integer) range.getUpper()};
    }
}
