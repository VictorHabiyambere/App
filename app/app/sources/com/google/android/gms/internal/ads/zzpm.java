package com.google.android.gms.internal.ads;

import android.media.AudioDeviceInfo;
import android.media.AudioManager;
import android.media.AudioProfile;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
final class zzpm {
    public static zzpp zza(AudioManager audioManager, zzk audioAttributes) {
        List directProfilesForAttributes = audioManager.getDirectProfilesForAttributes(audioAttributes.zza().zza);
        HashMap hashMap = new HashMap();
        hashMap.put(2, new HashSet(zzgea.zzf(12)));
        for (int i = 0; i < directProfilesForAttributes.size(); i++) {
            AudioProfile audioProfile = (AudioProfile) directProfilesForAttributes.get(i);
            if (audioProfile.getEncapsulationType() != 1) {
                int format = audioProfile.getFormat();
                if (zzgd.zzK(format) || zzpp.zzb.containsKey(Integer.valueOf(format))) {
                    Integer valueOf = Integer.valueOf(format);
                    if (hashMap.containsKey(valueOf)) {
                        Set set = (Set) hashMap.get(valueOf);
                        if (set != null) {
                            set.addAll(zzgea.zzf(audioProfile.getChannelMasks()));
                        } else {
                            throw null;
                        }
                    } else {
                        hashMap.put(valueOf, new HashSet(zzgea.zzf(audioProfile.getChannelMasks())));
                    }
                }
            }
        }
        zzgaz zzgaz = new zzgaz();
        for (Map.Entry entry : hashMap.entrySet()) {
            zzgaz.zzf(new zzpn(((Integer) entry.getKey()).intValue(), (Set) entry.getValue()));
        }
        return new zzpp(zzgaz.zzi());
    }

    public static zzpx zzb(AudioManager audioManager, zzk audioAttributes) {
        if (audioManager != null) {
            try {
                List audioDevicesForAttributes = audioManager.getAudioDevicesForAttributes(audioAttributes.zza().zza);
                if (!audioDevicesForAttributes.isEmpty()) {
                    return new zzpx((AudioDeviceInfo) audioDevicesForAttributes.get(0));
                }
            } catch (RuntimeException e) {
            }
        } else {
            throw null;
        }
        return null;
    }
}
