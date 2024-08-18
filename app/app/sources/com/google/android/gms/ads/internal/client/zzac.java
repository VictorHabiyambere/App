package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.client.zzp;
import com.google.android.gms.ads.internal.util.client.zzq;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzbep;
import com.google.android.gms.internal.ads.zzbrf;
import com.google.android.gms.internal.ads.zzbwj;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.2.0 */
final class zzac extends zzax {
    final /* synthetic */ Context zza;
    final /* synthetic */ zzbrf zzb;

    zzac(zzaw zzaw, Context context, zzbrf zzbrf) {
        this.zza = context;
        this.zzb = zzbrf;
    }

    /* access modifiers changed from: protected */
    public final /* bridge */ /* synthetic */ Object zza() {
        zzaw.zzt(this.zza, "out_of_context_tester");
        return null;
    }

    public final /* bridge */ /* synthetic */ Object zzb(zzce zzce) throws RemoteException {
        Context context = this.zza;
        IObjectWrapper wrap = ObjectWrapper.wrap(context);
        zzbep.zza(context);
        if (((Boolean) zzba.zzc().zza(zzbep.zzjt)).booleanValue()) {
            return zzce.zzh(wrap, this.zzb, 241806000);
        }
        return null;
    }

    public final /* bridge */ /* synthetic */ Object zzc() throws RemoteException {
        Context context = this.zza;
        IObjectWrapper wrap = ObjectWrapper.wrap(context);
        zzbep.zza(context);
        if (!((Boolean) zzba.zzc().zza(zzbep.zzjt)).booleanValue()) {
            return null;
        }
        try {
            return ((zzdk) zzq.zzb(this.zza, "com.google.android.gms.ads.DynamiteOutOfContextTesterCreatorImpl", new zzab())).zze(wrap, this.zzb, 241806000);
        } catch (RemoteException | zzp | NullPointerException e) {
            zzbwj.zza(this.zza).zzh(e, "ClientApiBroker.getOutOfContextTester");
            return null;
        }
    }
}
