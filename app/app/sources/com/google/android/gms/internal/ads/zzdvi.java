package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final /* synthetic */ class zzdvi implements Runnable {
    public final /* synthetic */ zzdvk zza;
    public final /* synthetic */ String zzb;

    public /* synthetic */ zzdvi(zzdvk zzdvk, String str) {
        this.zza = zzdvk;
        this.zzb = str;
    }

    public final void run() {
        this.zza.zze.zza(this.zzb);
    }
}
