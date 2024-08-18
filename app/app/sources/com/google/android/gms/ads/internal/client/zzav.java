package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzbrf;
import com.google.android.gms.internal.ads.zzbzm;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.2.0 */
final class zzav extends zzax {
    final /* synthetic */ Context zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ zzbrf zzc;
    final /* synthetic */ zzaw zzd;

    zzav(zzaw zzaw, Context context, String str, zzbrf zzbrf) {
        this.zza = context;
        this.zzb = str;
        this.zzc = zzbrf;
        this.zzd = zzaw;
    }

    /* access modifiers changed from: protected */
    public final /* bridge */ /* synthetic */ Object zza() {
        zzaw.zzt(this.zza, "rewarded");
        return new zzfc();
    }

    public final /* bridge */ /* synthetic */ Object zzb(zzce zzce) throws RemoteException {
        return zzce.zzo(ObjectWrapper.wrap(this.zza), this.zzb, this.zzc, 241806000);
    }

    public final /* bridge */ /* synthetic */ Object zzc() throws RemoteException {
        return zzbzm.zza(this.zza, this.zzb, this.zzc);
    }
}
