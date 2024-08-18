package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.client.zzq;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
final class zzcls implements zzfdh {
    private final zzcla zza;
    private Context zzb;
    private String zzc;
    private zzq zzd;

    /* synthetic */ zzcls(zzcla zzcla, zzclr zzclr) {
        this.zza = zzcla;
    }

    public final /* synthetic */ zzfdh zza(zzq zzq) {
        if (zzq != null) {
            this.zzd = zzq;
            return this;
        }
        throw null;
    }

    public final /* synthetic */ zzfdh zzb(String str) {
        if (str != null) {
            this.zzc = str;
            return this;
        }
        throw null;
    }

    public final /* synthetic */ zzfdh zzc(Context context) {
        if (context != null) {
            this.zzb = context;
            return this;
        }
        throw null;
    }

    public final zzfdi zzd() {
        zzhkx.zzc(this.zzb, Context.class);
        zzhkx.zzc(this.zzc, String.class);
        zzhkx.zzc(this.zzd, zzq.class);
        return new zzclu(this.zza, this.zzb, this.zzc, this.zzd, (zzclt) null);
    }
}
