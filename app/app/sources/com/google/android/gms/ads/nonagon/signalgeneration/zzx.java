package com.google.android.gms.ads.nonagon.signalgeneration;

import android.net.Uri;
import com.google.android.gms.internal.ads.zzgfa;
import com.google.android.gms.internal.ads.zzgft;
import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final /* synthetic */ class zzx implements zzgfa {
    public final /* synthetic */ zzaj zza;

    public /* synthetic */ zzx(zzaj zzaj) {
        this.zza = zzaj;
    }

    public final ListenableFuture zza(Object obj) {
        return zzgft.zzm(this.zza.zzS("google.afma.nativeAds.getPublisherCustomRenderedClickSignals"), new zzy(this.zza, (Uri) obj), this.zza.zzk);
    }
}
