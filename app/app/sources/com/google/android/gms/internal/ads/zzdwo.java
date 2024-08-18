package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.client.zzl;
import com.google.android.gms.ads.internal.client.zzq;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzdwo implements zzdwc {
    /* access modifiers changed from: private */
    public final long zza;
    private final zzepk zzb;

    zzdwo(long j, Context context, zzdwh zzdwh, zzcjd zzcjd, String str) {
        this.zza = j;
        zzfey zzv = zzcjd.zzv();
        zzv.zzc(context);
        zzv.zza(new zzq());
        zzv.zzb(str);
        this.zzb = zzv.zzd().zza();
        this.zzb.zzD(new zzdwn(this, zzdwh));
    }

    public final void zza() {
        this.zzb.zzx();
    }

    public final void zzb(zzl zzl) {
        this.zzb.zzab(zzl);
    }

    public final void zzc() {
        this.zzb.zzW(ObjectWrapper.wrap(null));
    }
}
