package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzelo {
    private zzelf zza;

    zzelo() {
    }

    private zzelo(zzelf zzelf) {
        this.zza = zzelf;
    }

    public static zzelo zzb(zzelf zzelf) {
        return new zzelo(zzelf);
    }

    public final zzelf zza(Clock clock, zzelh zzelh, zzehq zzehq, zzfoe zzfoe) {
        zzelf zzelf = this.zza;
        return zzelf != null ? zzelf : new zzelf(clock, zzelh, zzehq, zzfoe);
    }
}
