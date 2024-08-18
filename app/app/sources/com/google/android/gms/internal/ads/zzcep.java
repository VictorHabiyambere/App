package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final /* synthetic */ class zzcep implements Runnable {
    public final /* synthetic */ zzcew zza;
    public final /* synthetic */ boolean zzb;
    public final /* synthetic */ long zzc;

    public /* synthetic */ zzcep(zzcew zzcew, boolean z, long j) {
        this.zza = zzcew;
        this.zzb = z;
        this.zzc = j;
    }

    public final void run() {
        this.zza.zzJ(this.zzb, this.zzc);
    }
}
