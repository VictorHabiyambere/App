package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzark {
    public final Object zza;
    public final zzaqn zzb;
    public final zzarn zzc;
    public boolean zzd;

    private zzark(zzarn zzarn) {
        this.zzd = false;
        this.zza = null;
        this.zzb = null;
        this.zzc = zzarn;
    }

    private zzark(Object obj, zzaqn zzaqn) {
        this.zzd = false;
        this.zza = obj;
        this.zzb = zzaqn;
        this.zzc = null;
    }

    public static zzark zza(zzarn zzarn) {
        return new zzark(zzarn);
    }

    public static zzark zzb(Object obj, zzaqn zzaqn) {
        return new zzark(obj, zzaqn);
    }

    public final boolean zzc() {
        return this.zzc == null;
    }
}
