package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final /* synthetic */ class zzdyk implements Runnable {
    public final /* synthetic */ zzdyl zza;
    public final /* synthetic */ String zzb;

    public /* synthetic */ zzdyk(zzdyl zzdyl, String str) {
        this.zza = zzdyl;
        this.zzb = str;
    }

    public final void run() {
        this.zza.zzi(this.zzb);
    }
}
