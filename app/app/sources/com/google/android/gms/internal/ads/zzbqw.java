package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.ads.internal.util.client.zzp;
import com.google.android.gms.ads.internal.util.client.zzq;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.measurement.api.AppMeasurementSdk;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.2.0 */
public final /* synthetic */ class zzbqw implements Runnable {
    public final /* synthetic */ zzbqx zza;
    public final /* synthetic */ Context zzb;
    public final /* synthetic */ String zzc;

    public /* synthetic */ zzbqw(zzbqx zzbqx, Context context, String str) {
        this.zza = zzbqx;
        this.zzb = context;
        this.zzc = str;
    }

    public final void run() {
        Context context = this.zzb;
        zzbep.zza(context);
        if (!((Boolean) zzba.zzc().zza(zzbep.zzau)).booleanValue()) {
            Bundle bundle = new Bundle();
            bundle.putBoolean("measurementEnabled", ((Boolean) zzba.zzc().zza(zzbep.zzai)).booleanValue());
            if (((Boolean) zzba.zzc().zza(zzbep.zzap)).booleanValue()) {
                bundle.putString("ad_storage", "denied");
                bundle.putString("analytics_storage", "denied");
            }
            try {
                ((zzcjc) zzq.zzb(context, "com.google.android.gms.ads.measurement.DynamiteMeasurementManager", new zzbqv())).zze(ObjectWrapper.wrap(context), new zzbqu(AppMeasurementSdk.getInstance(context, "FA-Ads", "am", this.zzc, bundle)));
            } catch (RemoteException | zzp | NullPointerException e) {
                zzm.zzl("#007 Could not call remote method.", e);
            }
        }
    }
}
