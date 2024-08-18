package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.os.Bundle;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzbq {
    public static final zzbq zza = new zzbq(new zzbp());
    @Deprecated
    public static final zzn zzb = new zzbo();
    private static final String zzf = Integer.toString(0, 36);
    private static final String zzg = Integer.toString(1, 36);
    private static final String zzh = Integer.toString(2, 36);
    public final Uri zzc = null;
    public final String zzd = null;
    public final Bundle zze = null;

    private zzbq(zzbp zzbp) {
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzbq)) {
            return false;
        }
        zzbq zzbq = (zzbq) obj;
        Uri uri = zzbq.zzc;
        if (zzgd.zzG((Object) null, (Object) null)) {
            String str = zzbq.zzd;
            if (zzgd.zzG((Object) null, (Object) null)) {
                Bundle bundle = zzbq.zze;
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return 0;
    }
}
