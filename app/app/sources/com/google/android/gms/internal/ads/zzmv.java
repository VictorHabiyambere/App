package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.PowerManager;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
final class zzmv {
    private final PowerManager zza;

    public zzmv(Context context) {
        this.zza = (PowerManager) context.getApplicationContext().getSystemService("power");
    }
}
