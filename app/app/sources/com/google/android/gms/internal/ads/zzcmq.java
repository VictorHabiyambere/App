package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.client.zzq;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
final class zzcmq implements zzfey {
    private final zzcla zza;
    private Context zzb;
    private String zzc;
    private zzq zzd;

    /* synthetic */ zzcmq(zzcla zzcla, zzcmp zzcmp) {
        this.zza = zzcla;
    }

    public final /* synthetic */ zzfey zza(zzq zzq) {
        if (zzq != null) {
            this.zzd = zzq;
            return this;
        }
        throw null;
    }

    public final /* synthetic */ zzfey zzb(String str) {
        if (str != null) {
            this.zzc = str;
            return this;
        }
        throw null;
    }

    public final /* synthetic */ zzfey zzc(Context context) {
        if (context != null) {
            this.zzb = context;
            return this;
        }
        throw null;
    }

    public final zzfez zzd() {
        zzhkx.zzc(this.zzb, Context.class);
        zzhkx.zzc(this.zzc, String.class);
        zzhkx.zzc(this.zzd, zzq.class);
        return new zzcms(this.zza, this.zzb, this.zzc, this.zzd, (zzcmr) null);
    }
}
