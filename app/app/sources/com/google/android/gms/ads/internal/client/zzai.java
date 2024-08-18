package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.h5.OnH5AdsEventListener;
import com.google.android.gms.ads.internal.util.client.zzp;
import com.google.android.gms.ads.internal.util.client.zzq;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzbml;
import com.google.android.gms.internal.ads.zzbmu;
import com.google.android.gms.internal.ads.zzbmy;
import com.google.android.gms.internal.ads.zzbrf;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.2.0 */
final class zzai extends zzax {
    final /* synthetic */ Context zza;
    final /* synthetic */ zzbrf zzb;
    final /* synthetic */ OnH5AdsEventListener zzc;

    zzai(zzaw zzaw, Context context, zzbrf zzbrf, OnH5AdsEventListener onH5AdsEventListener) {
        this.zza = context;
        this.zzb = zzbrf;
        this.zzc = onH5AdsEventListener;
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ Object zza() {
        return new zzbmy();
    }

    public final /* bridge */ /* synthetic */ Object zzb(zzce zzce) throws RemoteException {
        return zzce.zzk(ObjectWrapper.wrap(this.zza), this.zzb, 241806000, new zzbml(this.zzc));
    }

    public final /* bridge */ /* synthetic */ Object zzc() throws RemoteException {
        try {
            return ((zzbmu) zzq.zzb(this.zza, "com.google.android.gms.ads.DynamiteH5AdsManagerCreatorImpl", new zzah())).zze(ObjectWrapper.wrap(this.zza), this.zzb, 241806000, new zzbml(this.zzc));
        } catch (RemoteException | zzp | NullPointerException e) {
            return null;
        }
    }
}
