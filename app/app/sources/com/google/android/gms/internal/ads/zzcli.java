package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
final class zzcli implements zzfbt {
    private final zzcla zza;
    private Context zzb;
    private String zzc;

    /* synthetic */ zzcli(zzcla zzcla, zzclh zzclh) {
        this.zza = zzcla;
    }

    public final /* synthetic */ zzfbt zza(String str) {
        if (str != null) {
            this.zzc = str;
            return this;
        }
        throw null;
    }

    public final /* synthetic */ zzfbt zzb(Context context) {
        if (context != null) {
            this.zzb = context;
            return this;
        }
        throw null;
    }

    public final zzfbu zzc() {
        zzhkx.zzc(this.zzb, Context.class);
        zzhkx.zzc(this.zzc, String.class);
        return new zzclk(this.zza, this.zzb, this.zzc, (zzclj) null);
    }
}
