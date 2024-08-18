package com.google.android.gms.internal.ads;

import android.net.Uri;
import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final /* synthetic */ class zzeiy implements zzgfa {
    public final /* synthetic */ zzeja zza;
    public final /* synthetic */ Uri zzb;
    public final /* synthetic */ zzfhf zzc;
    public final /* synthetic */ zzfgt zzd;

    public /* synthetic */ zzeiy(zzeja zzeja, Uri uri, zzfhf zzfhf, zzfgt zzfgt) {
        this.zza = zzeja;
        this.zzb = uri;
        this.zzc = zzfhf;
        this.zzd = zzfgt;
    }

    public final ListenableFuture zza(Object obj) {
        return this.zza.zzc(this.zzb, this.zzc, this.zzd, obj);
    }
}
