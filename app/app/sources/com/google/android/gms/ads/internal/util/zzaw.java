package com.google.android.gms.ads.internal.util;

import android.content.DialogInterface;
import android.net.Uri;
import com.google.android.gms.ads.internal.zzu;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
final class zzaw implements DialogInterface.OnClickListener {
    final /* synthetic */ zzax zza;

    zzaw(zzax zzax) {
        this.zza = zzax;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        zzu.zzp();
        zzt.zzU(this.zza.zza, Uri.parse("https://support.google.com/dfp_premium/answer/7160685#push"));
    }
}
