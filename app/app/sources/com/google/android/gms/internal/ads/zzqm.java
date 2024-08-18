package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final /* synthetic */ class zzqm implements Runnable {
    public final /* synthetic */ zzqn zza;
    public final /* synthetic */ String zzb;

    public /* synthetic */ zzqm(zzqn zzqn, String str) {
        this.zza = zzqn;
        this.zzb = str;
    }

    public final void run() {
        this.zza.zzo(this.zzb);
    }
}
