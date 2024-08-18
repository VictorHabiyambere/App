package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
final class zzcmg implements zzdwl {
    private final zzcla zza;
    private Context zzb;
    private zzbmo zzc;

    /* synthetic */ zzcmg(zzcla zzcla, zzcmf zzcmf) {
        this.zza = zzcla;
    }

    public final /* synthetic */ zzdwl zza(zzbmo zzbmo) {
        if (zzbmo != null) {
            this.zzc = zzbmo;
            return this;
        }
        throw null;
    }

    public final /* synthetic */ zzdwl zzb(Context context) {
        if (context != null) {
            this.zzb = context;
            return this;
        }
        throw null;
    }

    public final zzdwm zzc() {
        zzhkx.zzc(this.zzb, Context.class);
        zzhkx.zzc(this.zzc, zzbmo.class);
        return new zzcmi(this.zza, this.zzb, this.zzc, (zzcmh) null);
    }
}
