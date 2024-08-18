package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.ads.internal.util.client.zzp;
import com.google.android.gms.ads.internal.util.client.zzq;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.2.0 */
public final class zzbzm {
    public static final zzbza zza(Context context, String str, zzbrf zzbrf) {
        try {
            IBinder zze = ((zzbze) zzq.zzb(context, "com.google.android.gms.ads.rewarded.ChimeraRewardedAdCreatorImpl", new zzbzl())).zze(ObjectWrapper.wrap(context), str, zzbrf, 241806000);
            if (zze == null) {
                return null;
            }
            IInterface queryLocalInterface = zze.queryLocalInterface("com.google.android.gms.ads.internal.rewarded.client.IRewardedAd");
            return queryLocalInterface instanceof zzbza ? (zzbza) queryLocalInterface : new zzbyy(zze);
        } catch (RemoteException | zzp e) {
            zzm.zzl("#007 Could not call remote method.", e);
            return null;
        }
    }
}
