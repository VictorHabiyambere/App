package com.google.android.gms.ads.nonagon.signalgeneration;

import android.util.Pair;
import com.google.android.gms.internal.ads.zzdux;
import com.google.android.gms.internal.ads.zzdvh;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final /* synthetic */ class zzo implements Runnable {
    public final /* synthetic */ zzdvh zza;
    public final /* synthetic */ String zzb;
    public final /* synthetic */ Pair[] zzc;

    public /* synthetic */ zzo(zzdvh zzdvh, zzdux zzdux, String str, Pair[] pairArr) {
        this.zza = zzdvh;
        this.zzb = str;
        this.zzc = pairArr;
    }

    public final void run() {
        zzp.zze(this.zza, (zzdux) null, this.zzb, this.zzc);
    }
}
