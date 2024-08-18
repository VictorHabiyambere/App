package com.google.android.gms.ads.nonagon.signalgeneration;

import com.google.android.gms.internal.ads.zzdqs;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final /* synthetic */ class zzv implements Runnable {
    public final /* synthetic */ zzaj zza;
    public final /* synthetic */ zzdqs[] zzb;

    public /* synthetic */ zzv(zzaj zzaj, zzdqs[] zzdqsArr) {
        this.zza = zzaj;
        this.zzb = zzdqsArr;
    }

    public final void run() {
        this.zza.zzJ(this.zzb);
    }
}
