package com.google.android.gms.internal.ads;

import android.content.DialogInterface;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
final class zzbuf implements DialogInterface.OnClickListener {
    final /* synthetic */ zzbug zza;

    zzbuf(zzbug zzbug) {
        this.zza = zzbug;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.zza.zzh("User canceled the download.");
    }
}
