package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzeta implements zzexw {
    private final zzgge zza;
    private final zzdsy zzb;
    private final String zzc;
    private final zzfho zzd;

    public zzeta(zzgge zzgge, zzdsy zzdsy, zzfho zzfho, String str) {
        this.zza = zzgge;
        this.zzb = zzdsy;
        this.zzd = zzfho;
        this.zzc = str;
    }

    public final int zza() {
        return 17;
    }

    public final ListenableFuture zzb() {
        return this.zza.zzb(new zzesz(this));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzetb zzc() throws Exception {
        zzfho zzfho = this.zzd;
        zzdsy zzdsy = this.zzb;
        return new zzetb(zzdsy.zzb(zzfho.zzf, this.zzc), zzdsy.zza());
    }
}
