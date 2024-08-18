package com.google.android.gms.internal.ads;

import com.google.android.gms.common.internal.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzbye extends zzbyg {
    private final String zza;
    private final int zzb;

    public zzbye(String str, int i) {
        this.zza = str;
        this.zzb = i;
    }

    public final boolean equals(Object obj) {
        if (obj == null || !(obj instanceof zzbye)) {
            return false;
        }
        zzbye zzbye = (zzbye) obj;
        if (Objects.equal(this.zza, zzbye.zza)) {
            if (Objects.equal(Integer.valueOf(this.zzb), Integer.valueOf(zzbye.zzb))) {
                return true;
            }
        }
        return false;
    }

    public final int zzb() {
        return this.zzb;
    }

    public final String zzc() {
        return this.zza;
    }
}
