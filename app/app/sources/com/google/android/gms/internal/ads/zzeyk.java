package com.google.android.gms.internal.ads;

import android.util.Base64;
import androidx.privacysandbox.ads.adservices.topics.GetTopicsResponse;
import androidx.privacysandbox.ads.adservices.topics.Topic;
import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final /* synthetic */ class zzeyk implements zzgfa {
    public final ListenableFuture zza(Object obj) {
        GetTopicsResponse getTopicsResponse = (GetTopicsResponse) obj;
        if (getTopicsResponse == null) {
            return zzgft.zzh(new zzeyo("", 1, (zzeyn) null));
        }
        zzhfp zzc = zzhfq.zzc();
        for (Topic next : getTopicsResponse.getTopics()) {
            zzhfn zzc2 = zzhfo.zzc();
            zzc2.zzc(next.getTopicId());
            zzc2.zza(next.getModelVersion());
            zzc2.zzb(next.getTaxonomyVersion());
            zzc.zza((zzhfo) zzc2.zzbr());
        }
        return zzgft.zzh(new zzeyo(Base64.encodeToString(((zzhfq) zzc.zzbr()).zzaV(), 1), 1, (zzeyn) null));
    }
}
