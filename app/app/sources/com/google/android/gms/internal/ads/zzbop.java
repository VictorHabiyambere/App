package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Predicate;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final /* synthetic */ class zzbop implements Predicate {
    public final /* synthetic */ zzblp zza;

    public /* synthetic */ zzbop(zzblp zzblp) {
        this.zza = zzblp;
    }

    public final boolean apply(Object obj) {
        zzblp zzblp = (zzblp) obj;
        if (!(zzblp instanceof zzbov)) {
            return false;
        }
        return ((zzbov) zzblp).zzb.equals(this.zza);
    }
}
