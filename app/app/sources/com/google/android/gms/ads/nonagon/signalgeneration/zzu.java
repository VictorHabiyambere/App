package com.google.android.gms.ads.nonagon.signalgeneration;

import com.google.android.gms.internal.ads.zzdqs;
import com.google.android.gms.internal.ads.zzgfa;
import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final /* synthetic */ class zzu implements zzgfa {
    public final /* synthetic */ zzaj zza;
    public final /* synthetic */ zzdqs[] zzb;
    public final /* synthetic */ String zzc;

    public /* synthetic */ zzu(zzaj zzaj, zzdqs[] zzdqsArr, String str) {
        this.zza = zzaj;
        this.zzb = zzdqsArr;
        this.zzc = str;
    }

    public final ListenableFuture zza(Object obj) {
        return this.zza.zzv(this.zzb, this.zzc, (zzdqs) obj);
    }
}
