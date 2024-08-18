package com.google.android.gms.internal.ads;

import android.content.pm.PackageInfo;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzeyy implements zzexw {
    private final Executor zza;
    private final String zzb;
    private final PackageInfo zzc;
    private final zzcbp zzd;

    public zzeyy(zzcbp zzcbp, Executor executor, String str, PackageInfo packageInfo, int i) {
        this.zzd = zzcbp;
        this.zza = executor;
        this.zzb = str;
        this.zzc = packageInfo;
    }

    public final int zza() {
        return 41;
    }

    public final ListenableFuture zzb() {
        return zzgft.zzf(zzgft.zzm(zzgft.zzh(this.zzb), new zzeyw(), this.zza), Throwable.class, new zzeyx(this), this.zza);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ ListenableFuture zzc(Throwable th) throws Exception {
        return zzgft.zzh(new zzeyz(this.zzb));
    }
}
