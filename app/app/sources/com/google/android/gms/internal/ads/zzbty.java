package com.google.android.gms.internal.ads;

import android.content.DialogInterface;
import android.content.Intent;
import com.google.android.gms.ads.internal.util.zzt;
import com.google.android.gms.ads.internal.zzu;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
final class zzbty implements DialogInterface.OnClickListener {
    final /* synthetic */ zzbua zza;

    zzbty(zzbua zzbua) {
        this.zza = zzbua;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        zzbua zzbua = this.zza;
        Intent zzb = zzbua.zzb();
        zzu.zzp();
        zzt.zzT(zzbua.zzb, zzb);
    }
}
