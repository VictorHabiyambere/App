package com.google.android.gms.internal.ads;

import android.media.AudioDeviceInfo;
import android.media.AudioManager;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
final class zzpk {
    public static boolean zza(AudioManager audioManager, zzpx currentDevice) {
        AudioDeviceInfo[] audioDeviceInfoArr;
        if (currentDevice != null) {
            audioDeviceInfoArr = new AudioDeviceInfo[]{currentDevice.zza};
        } else if (audioManager != null) {
            audioDeviceInfoArr = audioManager.getDevices(2);
        } else {
            throw null;
        }
        zzgbh<Integer> zzb = zzb();
        for (AudioDeviceInfo type : audioDeviceInfoArr) {
            if (zzb.contains(Integer.valueOf(type.getType()))) {
                return true;
            }
        }
        return false;
    }

    private static zzgbh<Integer> zzb() {
        zzgbg zzgbg = new zzgbg();
        zzgbg.zzg(8, 7);
        if (zzgd.zza >= 31) {
            zzgbg.zzg(26, 27);
        }
        if (zzgd.zza >= 33) {
            zzgbg.zzf(30);
        }
        return zzgbg.zzi();
    }
}
