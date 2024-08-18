package com.google.android.gms.internal.ads;

import androidx.privacysandbox.ads.adservices.topics.GetTopicsResponse;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.zzu;
import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final /* synthetic */ class zzcpb implements zzgfa {
    public final ListenableFuture zza(Object obj) {
        Throwable th = (Throwable) obj;
        if (((Boolean) zzba.zzc().zza(zzbep.zzku)).booleanValue()) {
            zzu.zzo().zzx(th, "GetTopicsApiWithRecordObservationActionHandlerUnsampled");
        } else {
            zzu.zzo().zzv(th, "GetTopicsApiWithRecordObservationActionHandler");
        }
        return zzgft.zzh(new GetTopicsResponse(zzgbc.zzm()));
    }
}
