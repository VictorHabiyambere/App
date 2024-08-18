package com.google.android.gms.internal.ads;

import android.telephony.TelephonyCallback;
import android.telephony.TelephonyDisplayInfo;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
final class zzfp extends TelephonyCallback implements TelephonyCallback.DisplayInfoListener {
    private final zzfs zza;

    public zzfp(zzfs zzfs) {
        this.zza = zzfs;
    }

    public final void onDisplayInfoChanged(TelephonyDisplayInfo telephonyDisplayInfo) {
        boolean z;
        int overrideNetworkType = telephonyDisplayInfo.getOverrideNetworkType();
        int i = 5;
        if (overrideNetworkType == 3 || overrideNetworkType == 4) {
            z = true;
        } else {
            z = overrideNetworkType == 5;
        }
        zzfs zzfs = this.zza;
        if (true == z) {
            i = 10;
        }
        zzfs.zzc(zzfs, i);
    }
}
