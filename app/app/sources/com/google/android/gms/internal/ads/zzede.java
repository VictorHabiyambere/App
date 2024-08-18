package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final /* synthetic */ class zzede implements Callable {
    public final /* synthetic */ ListenableFuture zza;
    public final /* synthetic */ zzbxu zzb;
    public final /* synthetic */ ListenableFuture zzc;

    public /* synthetic */ zzede(ListenableFuture listenableFuture, zzbxu zzbxu, ListenableFuture listenableFuture2) {
        this.zza = listenableFuture;
        this.zzb = zzbxu;
        this.zzc = listenableFuture2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x001a, code lost:
        r1 = r6.zzb;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object call() {
        /*
            r6 = this;
            com.google.common.util.concurrent.ListenableFuture r0 = r6.zza
            java.lang.Object r0 = r0.get()
            com.google.android.gms.internal.ads.zzbxx r0 = (com.google.android.gms.internal.ads.zzbxx) r0
            com.google.android.gms.internal.ads.zzbeg r1 = com.google.android.gms.internal.ads.zzbep.zzcd
            com.google.android.gms.internal.ads.zzben r2 = com.google.android.gms.ads.internal.client.zzba.zzc()
            java.lang.Object r1 = r2.zza(r1)
            java.lang.Boolean r1 = (java.lang.Boolean) r1
            boolean r1 = r1.booleanValue()
            if (r1 == 0) goto L_0x003c
            com.google.android.gms.internal.ads.zzbxu r1 = r6.zzb
            android.os.Bundle r2 = r1.zzm
            if (r2 == 0) goto L_0x003c
            com.google.android.gms.internal.ads.zzdul r3 = com.google.android.gms.internal.ads.zzdul.GET_AD_DICTIONARY_SDKCORE_START
            java.lang.String r3 = r3.zza()
            long r4 = r0.zzc()
            r2.putLong(r3, r4)
            android.os.Bundle r1 = r1.zzm
            com.google.android.gms.internal.ads.zzdul r2 = com.google.android.gms.internal.ads.zzdul.GET_AD_DICTIONARY_SDKCORE_END
            java.lang.String r2 = r2.zza()
            long r3 = r0.zzb()
            r1.putLong(r2, r3)
        L_0x003c:
            com.google.common.util.concurrent.ListenableFuture r1 = r6.zzc
            com.google.android.gms.internal.ads.zzeeg r2 = new com.google.android.gms.internal.ads.zzeeg
            java.lang.Object r1 = r1.get()
            org.json.JSONObject r1 = (org.json.JSONObject) r1
            r2.<init>(r1, r0)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzede.call():java.lang.Object");
    }
}
