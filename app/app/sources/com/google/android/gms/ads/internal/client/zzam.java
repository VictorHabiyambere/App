package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzbrf;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.2.0 */
final class zzam extends zzax {
    final /* synthetic */ Context zza;
    final /* synthetic */ zzq zzb;
    final /* synthetic */ String zzc;
    final /* synthetic */ zzbrf zzd;
    final /* synthetic */ zzaw zze;

    zzam(zzaw zzaw, Context context, zzq zzq, String str, zzbrf zzbrf) {
        this.zza = context;
        this.zzb = zzq;
        this.zzc = str;
        this.zzd = zzbrf;
        this.zze = zzaw;
    }

    public final /* bridge */ /* synthetic */ Object zza() {
        zzaw.zzt(this.zza, "interstitial");
        return new zzew();
    }

    public final /* bridge */ /* synthetic */ Object zzb(zzce zzce) throws RemoteException {
        return zzce.zze(ObjectWrapper.wrap(this.zza), this.zzb, this.zzc, this.zzd, 241806000);
    }

    public final /* bridge */ /* synthetic */ Object zzc() throws RemoteException {
        return this.zze.zza.zza(this.zza, this.zzb, this.zzc, this.zzd, 2);
    }
}
