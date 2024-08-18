package com.google.android.gms.ads.appopen;

import android.content.Context;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.appopen.AppOpenAd;
import com.google.android.gms.internal.ads.zzbco;
import com.google.android.gms.internal.ads.zzbwj;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.2.0 */
public final /* synthetic */ class zzb implements Runnable {
    public final /* synthetic */ Context zza;
    public final /* synthetic */ String zzb;
    public final /* synthetic */ AdRequest zzc;
    public final /* synthetic */ int zzd;
    public final /* synthetic */ AppOpenAd.AppOpenAdLoadCallback zze;

    public /* synthetic */ zzb(Context context, String str, AdRequest adRequest, int i, AppOpenAd.AppOpenAdLoadCallback appOpenAdLoadCallback) {
        this.zza = context;
        this.zzb = str;
        this.zzc = adRequest;
        this.zzd = i;
        this.zze = appOpenAdLoadCallback;
    }

    public final void run() {
        Context context = this.zza;
        int i = this.zzd;
        String str = this.zzb;
        AdRequest adRequest = this.zzc;
        try {
            new zzbco(context, str, adRequest.zza(), i, this.zze).zza();
        } catch (IllegalStateException e) {
            zzbwj.zza(context).zzh(e, "AppOpenAd.load");
        }
    }
}
