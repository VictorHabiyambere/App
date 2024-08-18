package com.google.android.gms.ads.internal.util;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
final class zzcl extends BroadcastReceiver {
    final /* synthetic */ zzcm zza;

    zzcl(zzcm zzcm) {
        this.zza = zzcm;
    }

    public final void onReceive(Context context, Intent intent) {
        this.zza.zze(context, intent);
    }
}
