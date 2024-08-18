package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzesc implements zzexw {
    private final zzgge zza;
    private final VersionInfoParcel zzb;

    zzesc(VersionInfoParcel versionInfoParcel, zzgge zzgge) {
        this.zzb = versionInfoParcel;
        this.zza = zzgge;
    }

    public final int zza() {
        return 54;
    }

    public final ListenableFuture zzb() {
        return this.zza.zzb(new zzesb(this));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzesd zzc() throws Exception {
        return zzesd.zzb(this.zzb);
    }
}
