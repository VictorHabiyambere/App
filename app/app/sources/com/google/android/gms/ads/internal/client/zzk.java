package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.ads.internal.util.client.zzp;
import com.google.android.gms.ads.internal.util.client.zzq;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamic.RemoteCreator;
import com.google.android.gms.internal.ads.zzbep;
import com.google.android.gms.internal.ads.zzbrf;
import com.google.android.gms.internal.ads.zzbwj;
import com.google.android.gms.internal.ads.zzbwl;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.2.0 */
public final class zzk extends RemoteCreator {
    private zzbwl zza;

    public zzk() {
        super("com.google.android.gms.ads.AdManagerCreatorImpl");
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ Object getRemoteCreator(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManagerCreator");
        return queryLocalInterface instanceof zzbv ? (zzbv) queryLocalInterface : new zzbv(iBinder);
    }

    public final zzbu zza(Context context, zzq zzq, String str, zzbrf zzbrf, int i) {
        zzbu zzbs;
        zzbep.zza(context);
        if (((Boolean) zzba.zzc().zza(zzbep.zzkI)).booleanValue()) {
            try {
                IBinder zze = ((zzbv) zzq.zzb(context, "com.google.android.gms.ads.ChimeraAdManagerCreatorImpl", new zzj())).zze(ObjectWrapper.wrap(context), zzq, str, zzbrf, 241806000, i);
                if (zze == null) {
                    return null;
                }
                IInterface queryLocalInterface = zze.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManager");
                return queryLocalInterface instanceof zzbu ? (zzbu) queryLocalInterface : new zzbs(zze);
            } catch (RemoteException | zzp | NullPointerException e) {
                this.zza = zzbwj.zza(context);
                this.zza.zzh(e, "AdManagerCreator.newAdManagerByDynamiteLoader");
                zzm.zzl("#007 Could not call remote method.", e);
                return null;
            }
        } else {
            try {
                IBinder zze2 = ((zzbv) getRemoteCreatorInstance(context)).zze(ObjectWrapper.wrap(context), zzq, str, zzbrf, 241806000, i);
                if (zze2 == null) {
                    return null;
                }
                IInterface queryLocalInterface2 = zze2.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManager");
                if (queryLocalInterface2 instanceof zzbu) {
                    zzbs = (zzbu) queryLocalInterface2;
                } else {
                    zzbs = new zzbs(zze2);
                }
                return zzbs;
            } catch (RemoteException | RemoteCreator.RemoteCreatorException e2) {
                zzm.zzf("Could not create remote AdManager.", e2);
                return null;
            }
        }
    }
}
