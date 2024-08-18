package com.google.android.gms.internal.ads;

import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzdp {
    public static final zzdp zza = new zzdp(zzgbc.zzm());
    @Deprecated
    public static final zzn zzb = new zzdm();
    private static final String zzc = Integer.toString(0, 36);
    private final zzgbc zzd;

    public zzdp(List list) {
        this.zzd = zzgbc.zzk(list);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.zzd.equals(((zzdp) obj).zzd);
    }

    public final int hashCode() {
        return this.zzd.hashCode();
    }

    public final zzgbc zza() {
        return this.zzd;
    }

    public final boolean zzb(int i) {
        for (int i2 = 0; i2 < this.zzd.size(); i2++) {
            zzdo zzdo = (zzdo) this.zzd.get(i2);
            if (zzdo.zzc() && zzdo.zza() == i) {
                return true;
            }
        }
        return false;
    }
}
