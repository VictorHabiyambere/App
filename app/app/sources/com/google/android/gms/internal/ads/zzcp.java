package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzcp {
    public static final zzcp zza = new zzcn().zze();
    @Deprecated
    public static final zzn zzb = new zzcm();
    private static final String zzc = Integer.toString(0, 36);
    /* access modifiers changed from: private */
    public final zzah zzd;

    /* synthetic */ zzcp(zzah zzah, zzco zzco) {
        this.zzd = zzah;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzcp)) {
            return false;
        }
        return this.zzd.equals(((zzcp) obj).zzd);
    }

    public final int hashCode() {
        return this.zzd.hashCode();
    }
}
