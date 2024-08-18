package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzapm {
    public final int zza;
    public final String zzb;
    public final int zzc;
    public final List zzd;
    public final byte[] zze;

    public zzapm(int i, String str, int i2, List list, byte[] bArr) {
        List list2;
        this.zza = i;
        this.zzb = str;
        this.zzc = i2;
        if (list == null) {
            list2 = Collections.emptyList();
        } else {
            list2 = Collections.unmodifiableList(list);
        }
        this.zzd = list2;
        this.zze = bArr;
    }

    public final int zza() {
        switch (this.zzc) {
            case 2:
                return 2048;
            case 3:
                return 512;
            default:
                return 0;
        }
    }
}
