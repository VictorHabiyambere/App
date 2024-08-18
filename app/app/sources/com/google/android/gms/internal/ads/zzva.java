package com.google.android.gms.internal.ads;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
final class zzva {
    private final zzaea zza;
    private final Map zzb = new HashMap();
    private final Set zzc = new HashSet();
    private final Map zzd = new HashMap();
    private zzha zze;
    private final zzalt zzf;

    public zzva(zzaea zzaea, zzalt zzalt) {
        this.zza = zzaea;
        this.zzf = zzalt;
    }

    public final void zza(zzha zzha) {
        if (zzha != this.zze) {
            this.zze = zzha;
            this.zzb.clear();
            this.zzd.clear();
        }
    }
}
