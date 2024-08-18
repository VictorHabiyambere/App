package com.google.android.gms.internal.ads;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
final class zzpv extends BroadcastReceiver {
    final /* synthetic */ zzpw zza;

    /* synthetic */ zzpv(zzpw zzpw, zzpu zzpu) {
        this.zza = zzpw;
    }

    public final void onReceive(Context context, Intent intent) {
        if (!isInitialStickyBroadcast()) {
            zzpw zzpw = this.zza;
            zzpw.zzj(zzpp.zzd(context, intent, zzpw.zzh, zzpw.zzg));
        }
    }
}
