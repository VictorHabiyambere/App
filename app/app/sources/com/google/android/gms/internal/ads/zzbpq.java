package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final /* synthetic */ class zzbpq implements Runnable {
    public final /* synthetic */ zzbpr zza;
    public final /* synthetic */ zzboo zzb;

    public /* synthetic */ zzbpq(zzbpr zzbpr, zzboo zzboo) {
        this.zza = zzbpr;
        this.zzb = zzboo;
    }

    public final void run() {
        zzboo zzboo = this.zzb;
        zzboo.zzr("/result", zzblo.zzo);
        zzboo.zzc();
    }
}
