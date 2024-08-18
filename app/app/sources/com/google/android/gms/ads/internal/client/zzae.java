package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.client.zzp;
import com.google.android.gms.ads.internal.util.client.zzq;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzbrf;
import com.google.android.gms.internal.ads.zzcbj;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.2.0 */
final class zzae extends zzax {
    final /* synthetic */ Context zza;
    final /* synthetic */ zzbrf zzb;

    zzae(zzaw zzaw, Context context, zzbrf zzbrf) {
        this.zza = context;
        this.zzb = zzbrf;
    }

    /* access modifiers changed from: protected */
    public final /* bridge */ /* synthetic */ Object zza() {
        return null;
    }

    public final /* bridge */ /* synthetic */ Object zzb(zzce zzce) throws RemoteException {
        return zzce.zzp(ObjectWrapper.wrap(this.zza), this.zzb, 241806000);
    }

    public final /* bridge */ /* synthetic */ Object zzc() throws RemoteException {
        try {
            return ((zzcbj) zzq.zzb(this.zza, "com.google.android.gms.ads.DynamiteSignalGeneratorCreatorImpl", new zzad())).zze(ObjectWrapper.wrap(this.zza), this.zzb, 241806000);
        } catch (RemoteException | zzp | NullPointerException e) {
            return null;
        }
    }
}
