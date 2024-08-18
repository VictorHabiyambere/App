package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.overlay.zzn;
import com.google.android.gms.ads.internal.zzu;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final /* synthetic */ class zzeiz implements zzdjp {
    public final /* synthetic */ zzccn zza;

    public /* synthetic */ zzeiz(zzccn zzccn) {
        this.zza = zzccn;
    }

    public final void zza(boolean z, Context context, zzczy zzczy) {
        zzccn zzccn = this.zza;
        try {
            zzu.zzi();
            zzn.zza(context, (AdOverlayInfoParcel) zzccn.get(), true);
        } catch (Exception e) {
        }
    }
}
