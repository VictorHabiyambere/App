package com.google.android.gms.internal.ads;

import android.net.Uri;
import java.util.Collections;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzhf {
    private Uri zza;
    private Map zzb;
    private long zzc;
    private final long zzd;
    private int zze;

    public zzhf() {
        this.zzb = Collections.emptyMap();
        this.zzd = -1;
    }

    /* synthetic */ zzhf(zzhh zzhh, zzhe zzhe) {
        this.zza = zzhh.zza;
        this.zzb = zzhh.zzd;
        this.zzc = zzhh.zze;
        this.zzd = zzhh.zzf;
        this.zze = zzhh.zzg;
    }

    public final zzhf zza(int i) {
        this.zze = 6;
        return this;
    }

    public final zzhf zzb(Map map) {
        this.zzb = map;
        return this;
    }

    public final zzhf zzc(long j) {
        this.zzc = j;
        return this;
    }

    public final zzhf zzd(Uri uri) {
        this.zza = uri;
        return this;
    }

    public final zzhh zze() {
        if (this.zza != null) {
            return new zzhh(this.zza, 0, 1, (byte[]) null, this.zzb, this.zzc, this.zzd, (String) null, this.zze, (Object) null, (zzhg) null);
        }
        throw new IllegalStateException("The uri must be set.");
    }
}
