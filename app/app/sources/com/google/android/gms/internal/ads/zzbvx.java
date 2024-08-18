package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.AdFormat;
import com.google.android.gms.ads.internal.client.zzay;
import com.google.android.gms.ads.internal.client.zzdx;
import com.google.android.gms.ads.internal.client.zzl;
import com.google.android.gms.ads.internal.client.zzm;
import com.google.android.gms.ads.internal.client.zzp;
import com.google.android.gms.ads.internal.client.zzq;
import com.google.android.gms.ads.query.QueryInfoGenerationCallback;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.2.0 */
public final class zzbvx {
    private static zzcbg zza;
    private final Context zzb;
    private final AdFormat zzc;
    private final zzdx zzd;
    private final String zze;

    public zzbvx(Context context, AdFormat adFormat, zzdx zzdx, String str) {
        this.zzb = context;
        this.zzc = adFormat;
        this.zzd = zzdx;
        this.zze = str;
    }

    public static zzcbg zza(Context context) {
        zzcbg zzcbg;
        synchronized (zzbvx.class) {
            if (zza == null) {
                zza = zzay.zza().zzr(context, new zzbrb());
            }
            zzcbg = zza;
        }
        return zzcbg;
    }

    public final void zzb(QueryInfoGenerationCallback queryInfoGenerationCallback) {
        zzl zzl;
        zzcbg zza2 = zza(this.zzb);
        if (zza2 == null) {
            queryInfoGenerationCallback.onFailure("Internal Error, query info generator is null.");
            return;
        }
        Context context = this.zzb;
        zzdx zzdx = this.zzd;
        IObjectWrapper wrap = ObjectWrapper.wrap(context);
        if (zzdx == null) {
            zzm zzm = new zzm();
            zzm.zzg(System.currentTimeMillis());
            zzl = zzm.zza();
        } else {
            zzl = zzp.zza.zza(this.zzb, zzdx);
        }
        try {
            zza2.zzf(wrap, new zzcbk(this.zze, this.zzc.name(), (zzq) null, zzl), new zzbvw(this, queryInfoGenerationCallback));
        } catch (RemoteException e) {
            queryInfoGenerationCallback.onFailure("Internal Error.");
        }
    }
}
