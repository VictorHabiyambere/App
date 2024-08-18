package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final /* synthetic */ class zzacc implements Runnable {
    public final /* synthetic */ zzach zza;
    public final /* synthetic */ Exception zzb;

    public /* synthetic */ zzacc(zzach zzach, Exception exc) {
        this.zza = zzach;
        this.zzb = exc;
    }

    public final void run() {
        this.zza.zzo(this.zzb);
    }
}
