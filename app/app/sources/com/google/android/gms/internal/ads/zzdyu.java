package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.LoadAdError;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
final class zzdyu extends AdListener {
    final /* synthetic */ String zza;
    final /* synthetic */ zzdyx zzb;

    zzdyu(zzdyx zzdyx, String str) {
        this.zza = str;
        this.zzb = zzdyx;
    }

    public final void onAdFailedToLoad(LoadAdError loadAdError) {
        this.zzb.zzm(zzdyx.zzl(loadAdError), this.zza);
    }
}
