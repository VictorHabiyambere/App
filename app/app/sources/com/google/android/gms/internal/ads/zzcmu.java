package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
final class zzcmu implements zzfgm {
    private final zzcla zza;
    private Context zzb;
    private String zzc;

    /* synthetic */ zzcmu(zzcla zzcla, zzcmt zzcmt) {
        this.zza = zzcla;
    }

    public final /* synthetic */ zzfgm zza(String str) {
        this.zzc = str;
        return this;
    }

    public final /* synthetic */ zzfgm zzb(Context context) {
        if (context != null) {
            this.zzb = context;
            return this;
        }
        throw null;
    }

    public final zzfgn zzc() {
        zzhkx.zzc(this.zzb, Context.class);
        return new zzcmw(this.zza, this.zzb, this.zzc, (zzcmv) null);
    }
}
