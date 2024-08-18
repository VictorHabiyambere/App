package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.client.zzp;
import com.google.android.gms.ads.internal.util.client.zzq;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzbrf;
import com.google.android.gms.internal.ads.zzbvc;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.2.0 */
final class zzag extends zzax {
    final /* synthetic */ Context zza;
    final /* synthetic */ zzbrf zzb;

    zzag(zzaw zzaw, Context context, zzbrf zzbrf) {
        this.zza = context;
        this.zzb = zzbrf;
    }

    /* access modifiers changed from: protected */
    public final /* bridge */ /* synthetic */ Object zza() {
        return null;
    }

    public final /* bridge */ /* synthetic */ Object zzb(zzce zzce) throws RemoteException {
        return zzce.zzl(ObjectWrapper.wrap(this.zza), this.zzb, 241806000);
    }

    public final /* bridge */ /* synthetic */ Object zzc() throws RemoteException {
        try {
            return ((zzbvc) zzq.zzb(this.zza, "com.google.android.gms.ads.DynamiteOfflineUtilsCreatorImpl", new zzaf())).zze(ObjectWrapper.wrap(this.zza), this.zzb, 241806000);
        } catch (RemoteException | zzp | NullPointerException e) {
            return null;
        }
    }
}
