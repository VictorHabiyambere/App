package com.google.android.gms.internal.ads;

import android.net.Uri;
import java.io.IOException;
import java.util.Collections;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzid implements zzhb {
    private final zzhb zza;
    private long zzb;
    private Uri zzc = Uri.EMPTY;
    private Map zzd = Collections.emptyMap();

    public zzid(zzhb zzhb) {
        this.zza = zzhb;
    }

    public final int zza(byte[] bArr, int i, int i2) throws IOException {
        int zza2 = this.zza.zza(bArr, i, i2);
        if (zza2 != -1) {
            this.zzb += (long) zza2;
        }
        return zza2;
    }

    public final long zzb(zzhh zzhh) throws IOException {
        this.zzc = zzhh.zza;
        this.zzd = Collections.emptyMap();
        long zzb2 = this.zza.zzb(zzhh);
        Uri zzc2 = zzc();
        if (zzc2 != null) {
            this.zzc = zzc2;
            this.zzd = zze();
            return zzb2;
        }
        throw null;
    }

    public final Uri zzc() {
        return this.zza.zzc();
    }

    public final void zzd() throws IOException {
        this.zza.zzd();
    }

    public final Map zze() {
        return this.zza.zze();
    }

    public final long zzg() {
        return this.zzb;
    }

    public final Uri zzh() {
        return this.zzc;
    }

    public final Map zzi() {
        return this.zzd;
    }

    public final void zzf(zzie zzie) {
        if (zzie != null) {
            this.zza.zzf(zzie);
            return;
        }
        throw null;
    }
}
