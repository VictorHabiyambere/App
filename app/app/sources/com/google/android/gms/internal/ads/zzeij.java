package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final /* synthetic */ class zzeij implements Runnable {
    public final /* synthetic */ zzeim zza;
    public final /* synthetic */ zzchd zzb;

    public /* synthetic */ zzeij(zzeim zzeim, zzchd zzchd) {
        this.zza = zzeim;
        this.zzb = zzchd;
    }

    public final void run() {
        this.zza.zzd(this.zzb);
    }
}
