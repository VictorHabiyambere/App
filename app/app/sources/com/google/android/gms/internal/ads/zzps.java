package com.google.android.gms.internal.ads;

import android.media.AudioDeviceCallback;
import android.media.AudioDeviceInfo;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
final class zzps extends AudioDeviceCallback {
    final /* synthetic */ zzpw zza;

    /* synthetic */ zzps(zzpw zzpw, zzpr zzpr) {
        this.zza = zzpw;
    }

    public final void onAudioDevicesAdded(AudioDeviceInfo[] audioDeviceInfoArr) {
        zzpw zzpw = this.zza;
        this.zza.zzj(zzpp.zzc(zzpw.zza, zzpw.zzh, zzpw.zzg));
    }

    public final void onAudioDevicesRemoved(AudioDeviceInfo[] audioDeviceInfoArr) {
        zzpx zzd = this.zza.zzg;
        int i = zzgd.zza;
        int length = audioDeviceInfoArr.length;
        int i2 = 0;
        while (true) {
            if (i2 >= length) {
                break;
            } else if (zzgd.zzG(audioDeviceInfoArr[i2], zzd)) {
                this.zza.zzg = null;
                break;
            } else {
                i2++;
            }
        }
        zzpw zzpw = this.zza;
        zzpw.zzj(zzpp.zzc(zzpw.zza, zzpw.zzh, zzpw.zzg));
    }
}
