package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final /* synthetic */ class zzcqk implements Runnable {
    public final /* synthetic */ zzcqp zza;
    public final /* synthetic */ int zzb;
    public final /* synthetic */ int zzc;

    public /* synthetic */ zzcqk(zzcqp zzcqp, int i, int i2) {
        this.zza = zzcqp;
        this.zzb = i;
        this.zzc = i2;
    }

    public final void run() {
        this.zza.zzo(this.zzb, this.zzc);
    }
}
