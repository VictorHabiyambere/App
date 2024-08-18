package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.ads.internal.util.client.zzp;
import com.google.android.gms.ads.internal.util.client.zzq;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.2.0 */
public final class zzbhd {
    private final Context zza;

    public zzbhd(Context context) {
        this.zza = context;
    }

    public final void zza(zzbwq zzbwq) {
        try {
            ((zzbhe) zzq.zzb(this.zza, "com.google.android.gms.ads.flags.FlagRetrieverSupplierProxy", new zzbhc())).zze(zzbwq);
        } catch (zzp e) {
            zzm.zzj("Could not load com.google.android.gms.ads.flags.FlagRetrieverSupplierProxy:".concat(String.valueOf(e.getMessage())));
        } catch (RemoteException e2) {
            zzm.zzj("Error calling setFlagsAccessedBeforeInitializedListener: ".concat(String.valueOf(e2.getMessage())));
        }
    }
}
