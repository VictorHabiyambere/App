package com.google.android.gms.internal.ads;

import android.content.DialogInterface;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
final class zzbtz implements DialogInterface.OnClickListener {
    final /* synthetic */ zzbua zza;

    zzbtz(zzbua zzbua) {
        this.zza = zzbua;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.zza.zzh("Operation denied by user.");
    }
}
