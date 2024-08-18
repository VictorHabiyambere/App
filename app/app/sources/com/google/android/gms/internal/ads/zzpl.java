package com.google.android.gms.internal.ads;

import android.media.AudioFormat;
import android.media.AudioTrack;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
final class zzpl {
    public static int zza(int encoding, int sampleRate, zzk audioAttributes) {
        for (int i = 10; i > 0; i--) {
            int zzh = zzgd.zzh(i);
            if (zzh != 0 && AudioTrack.isDirectPlaybackSupported(new AudioFormat.Builder().setEncoding(encoding).setSampleRate(sampleRate).setChannelMask(zzh).build(), audioAttributes.zza().zza)) {
                return i;
            }
        }
        return 0;
    }

    public static zzgbc<Integer> zzb(zzk audioAttributes) {
        zzgaz zzgaz = new zzgaz();
        zzgdi zze = zzpp.zzb.keySet().iterator();
        while (zze.hasNext()) {
            int intValue = ((Integer) zze.next()).intValue();
            if (zzgd.zza >= zzgd.zzg(intValue) && AudioTrack.isDirectPlaybackSupported(new AudioFormat.Builder().setChannelMask(12).setEncoding(intValue).setSampleRate(48000).build(), audioAttributes.zza().zza)) {
                zzgaz.zzf(Integer.valueOf(intValue));
            }
        }
        zzgaz.zzf(2);
        return zzgaz.zzi();
    }
}
