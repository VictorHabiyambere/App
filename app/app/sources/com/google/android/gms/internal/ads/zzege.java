package com.google.android.gms.internal.ads;

import android.content.DialogInterface;
import com.google.android.gms.ads.internal.overlay.zzm;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final /* synthetic */ class zzege implements DialogInterface.OnClickListener {
    public final /* synthetic */ zzegk zza;
    public final /* synthetic */ zzm zzb;

    public /* synthetic */ zzege(zzegk zzegk, zzm zzm) {
        this.zza = zzegk;
        this.zzb = zzm;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.zza.zzk(this.zzb, dialogInterface, i);
    }
}
