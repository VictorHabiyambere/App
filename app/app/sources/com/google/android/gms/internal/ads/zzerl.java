package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzerl implements zzexw {
    private final zzgge zza;
    private final zzfho zzb;
    private final VersionInfoParcel zzc;
    private final zzccc zzd;

    public zzerl(zzgge zzgge, zzfho zzfho, VersionInfoParcel versionInfoParcel, zzccc zzccc) {
        this.zza = zzgge;
        this.zzb = zzfho;
        this.zzc = versionInfoParcel;
        this.zzd = zzccc;
    }

    public final int zza() {
        return 9;
    }

    public final ListenableFuture zzb() {
        return this.zza.zzb(new zzerk(this));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzerm zzc() throws Exception {
        return new zzerm(this.zzb.zzj, this.zzc, this.zzd.zzm());
    }
}
