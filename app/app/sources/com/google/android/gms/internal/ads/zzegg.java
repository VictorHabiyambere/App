package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.DialogInterface;
import com.google.android.gms.ads.internal.overlay.zzm;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final /* synthetic */ class zzegg implements DialogInterface.OnClickListener {
    public final /* synthetic */ zzegk zza;
    public final /* synthetic */ Activity zzb;
    public final /* synthetic */ zzm zzc;

    public /* synthetic */ zzegg(zzegk zzegk, Activity activity, zzm zzm) {
        this.zza = zzegk;
        this.zzb = activity;
        this.zzc = zzm;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.zza.zzm(this.zzb, this.zzc, dialogInterface, i);
    }
}
