package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzaed {
    public static zzcd zza(zzadv zzadv, boolean z) throws IOException {
        zzaho zzaho;
        if (z) {
            zzaho = null;
        } else {
            zzaho = zzahq.zza;
        }
        zzcd zza = new zzael().zza(zzadv, zzaho);
        if (zza == null || zza.zza() == 0) {
            return null;
        }
        return zza;
    }

    public static zzaef zzb(zzfu zzfu) {
        zzfu.zzL(1);
        int zzo = zzfu.zzo();
        long zzd = (long) zzfu.zzd();
        long j = (long) zzo;
        int i = zzo / 18;
        long[] jArr = new long[i];
        long[] jArr2 = new long[i];
        int i2 = 0;
        while (true) {
            if (i2 >= i) {
                break;
            }
            long zzt = zzfu.zzt();
            if (zzt == -1) {
                jArr = Arrays.copyOf(jArr, i2);
                jArr2 = Arrays.copyOf(jArr2, i2);
                break;
            }
            jArr[i2] = zzt;
            jArr2[i2] = zzfu.zzt();
            zzfu.zzL(2);
            i2++;
        }
        zzfu.zzL((int) ((zzd + j) - ((long) zzfu.zzd())));
        return new zzaef(jArr, jArr2);
    }
}
