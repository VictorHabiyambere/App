package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final /* synthetic */ class zzbos implements Runnable {
    public final /* synthetic */ zzbow zza;
    public final /* synthetic */ String zzb;

    public /* synthetic */ zzbos(zzbow zzbow, String str) {
        this.zza = zzbow;
        this.zzb = str;
    }

    public final void run() {
        this.zza.zzm(this.zzb);
    }
}
