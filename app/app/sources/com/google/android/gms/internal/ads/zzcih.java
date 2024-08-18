package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final /* synthetic */ class zzcih implements Runnable {
    public final /* synthetic */ zzcij zza;
    public final /* synthetic */ String zzb;

    public /* synthetic */ zzcih(zzcij zzcij, String str) {
        this.zza = zzcij;
        this.zzb = str;
    }

    public final void run() {
        this.zza.zza(this.zzb);
    }
}
