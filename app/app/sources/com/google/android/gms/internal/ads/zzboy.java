package com.google.android.gms.internal.ads;

import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final /* synthetic */ class zzboy implements Runnable {
    public final /* synthetic */ zzbpt zza;
    public final /* synthetic */ zzbps zzb;
    public final /* synthetic */ zzboo zzc;
    public final /* synthetic */ ArrayList zzd;
    public final /* synthetic */ long zze;

    public /* synthetic */ zzboy(zzbpt zzbpt, zzbps zzbps, zzboo zzboo, ArrayList arrayList, long j) {
        this.zza = zzbpt;
        this.zzb = zzbps;
        this.zzc = zzboo;
        this.zzd = arrayList;
        this.zze = j;
    }

    public final void run() {
        this.zza.zzi(this.zzb, this.zzc, this.zzd, this.zze);
    }
}
