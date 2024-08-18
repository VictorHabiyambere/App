package com.google.android.gms.internal.ads;

import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzalp {
    public static void zza(zzalq zzalq, zzalu zzalu, zzev zzev) {
        for (int i = 0; i < zzalq.zza(); i++) {
            long zzb = zzalq.zzb(i);
            List zzc = zzalq.zzc(zzb);
            if (!zzc.isEmpty()) {
                if (i != zzalq.zza() - 1) {
                    long zzb2 = zzalq.zzb(i + 1) - zzalq.zzb(i);
                    if (zzb2 > 0) {
                        zzev.zza(new zzaln(zzc, zzb, zzb2));
                    }
                } else {
                    throw new IllegalStateException();
                }
            }
        }
    }
}
