package com.google.android.gms.ads.internal.util;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import com.google.android.gms.ads.internal.zzu;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
final class zzax implements Runnable {
    final /* synthetic */ Context zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ boolean zzc;
    final /* synthetic */ boolean zzd;

    zzax(zzay zzay, Context context, String str, boolean z, boolean z2) {
        this.zza = context;
        this.zzb = str;
        this.zzc = z;
        this.zzd = z2;
    }

    public final void run() {
        zzu.zzp();
        AlertDialog.Builder zzK = zzt.zzK(this.zza);
        zzK.setMessage(this.zzb);
        if (this.zzc) {
            zzK.setTitle("Error");
        } else {
            zzK.setTitle("Info");
        }
        if (this.zzd) {
            zzK.setNeutralButton("Dismiss", (DialogInterface.OnClickListener) null);
        } else {
            zzK.setPositiveButton("Learn More", new zzaw(this));
            zzK.setNegativeButton("Dismiss", (DialogInterface.OnClickListener) null);
        }
        zzK.create().show();
    }
}
