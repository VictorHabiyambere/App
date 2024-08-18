package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.Uri;
import android.os.RemoteException;
import com.google.android.gms.ads.h5.OnH5AdsEventListener;
import com.google.android.gms.ads.internal.client.zzay;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.2.0 */
public final class zzbmv {
    private final Context zza;
    private final OnH5AdsEventListener zzb;
    private zzbmr zzc;

    public zzbmv(Context context, OnH5AdsEventListener onH5AdsEventListener) {
        Preconditions.checkState(true, "Android version must be Lollipop or higher");
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(onH5AdsEventListener);
        this.zza = context;
        this.zzb = onH5AdsEventListener;
        zzbep.zza(context);
    }

    public static final boolean zzc(String str) {
        if (!((Boolean) zzba.zzc().zza(zzbep.zzjU)).booleanValue()) {
            return false;
        }
        Preconditions.checkNotNull(str);
        if (str.length() > ((Integer) zzba.zzc().zza(zzbep.zzjW)).intValue()) {
            zzm.zze("H5 GMSG exceeds max length");
            return false;
        }
        Uri parse = Uri.parse(str);
        if (!"gmsg".equals(parse.getScheme()) || !"mobileads.google.com".equals(parse.getHost()) || !"/h5ads".equals(parse.getPath())) {
            return false;
        }
        return true;
    }

    private final void zzd() {
        if (this.zzc == null) {
            this.zzc = zzay.zza().zzl(this.zza, new zzbrb(), this.zzb);
        }
    }

    public final void zza() {
        if (((Boolean) zzba.zzc().zza(zzbep.zzjU)).booleanValue()) {
            zzd();
            zzbmr zzbmr = this.zzc;
            if (zzbmr != null) {
                try {
                    zzbmr.zze();
                } catch (RemoteException e) {
                    zzm.zzl("#007 Could not call remote method.", e);
                }
            }
        }
    }

    public final boolean zzb(String str) {
        if (!zzc(str)) {
            return false;
        }
        zzd();
        zzbmr zzbmr = this.zzc;
        if (zzbmr == null) {
            return false;
        }
        try {
            zzbmr.zzf(str);
            return true;
        } catch (RemoteException e) {
            zzm.zzl("#007 Could not call remote method.", e);
            return true;
        }
    }
}
