package com.google.android.gms.ads.query;

import android.content.Context;
import com.google.android.gms.ads.AdFormat;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.internal.client.zzdx;
import com.google.android.gms.internal.ads.zzbvx;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.2.0 */
public final /* synthetic */ class zza implements Runnable {
    public final /* synthetic */ Context zza;
    public final /* synthetic */ AdFormat zzb;
    public final /* synthetic */ AdRequest zzc;
    public final /* synthetic */ String zzd;
    public final /* synthetic */ QueryInfoGenerationCallback zze;

    public /* synthetic */ zza(Context context, AdFormat adFormat, AdRequest adRequest, String str, QueryInfoGenerationCallback queryInfoGenerationCallback) {
        this.zza = context;
        this.zzb = adFormat;
        this.zzc = adRequest;
        this.zzd = str;
        this.zze = queryInfoGenerationCallback;
    }

    public final void run() {
        AdRequest adRequest = this.zzc;
        zzdx zza2 = adRequest == null ? null : adRequest.zza();
        new zzbvx(this.zza, this.zzb, zza2, this.zzd).zzb(this.zze);
    }
}
