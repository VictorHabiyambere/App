package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.overlay.zzp;
import com.google.android.gms.ads.internal.util.client.zzm;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
final class zzbtv implements zzp {
    final /* synthetic */ zzbtx zza;

    zzbtv(zzbtx zzbtx) {
        this.zza = zzbtx;
    }

    public final void zzdH() {
        zzm.zze("AdMobCustomTabsAdapter overlay is resumed.");
    }

    public final void zzdk() {
        zzm.zze("AdMobCustomTabsAdapter overlay is paused.");
    }

    public final void zzdq() {
        zzm.zze("Delay close AdMobCustomTabsAdapter overlay.");
    }

    public final void zzdr() {
        zzm.zze("Opening AdMobCustomTabsAdapter overlay.");
        zzbtx zzbtx = this.zza;
        zzbtx.zzb.onAdOpened(zzbtx);
    }

    public final void zzdt() {
    }

    public final void zzdu(int i) {
        zzm.zze("AdMobCustomTabsAdapter overlay is closed.");
        zzbtx zzbtx = this.zza;
        zzbtx.zzb.onAdClosed(zzbtx);
    }
}
