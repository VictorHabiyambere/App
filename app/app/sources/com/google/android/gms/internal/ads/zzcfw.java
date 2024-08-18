package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final /* synthetic */ class zzcfw implements Runnable {
    public final /* synthetic */ zzcee zza;
    public final /* synthetic */ boolean zzb;
    public final /* synthetic */ long zzc;

    public /* synthetic */ zzcfw(zzcee zzcee, boolean z, long j) {
        this.zza = zzcee;
        this.zzb = z;
        this.zzc = j;
    }

    public final void run() {
        int i = zzcfy.zzd;
        this.zza.zzv(this.zzb, this.zzc);
    }
}
