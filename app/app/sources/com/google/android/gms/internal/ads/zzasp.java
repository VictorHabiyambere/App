package com.google.android.gms.internal.ads;

import java.io.Closeable;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzasp extends zzhka implements Closeable {
    private static final zzhkh zza = zzhkh.zzb(zzasp.class);

    public zzasp(zzhkb zzhkb, zzaso zzaso) throws IOException {
        zzf(zzhkb, zzhkb.zzc(), zzaso);
    }

    public final void close() throws IOException {
    }

    public final String toString() {
        String obj = this.zzd.toString();
        StringBuilder sb = new StringBuilder(String.valueOf(obj).length() + 7);
        sb.append("model(");
        sb.append(obj);
        sb.append(")");
        return sb.toString();
    }
}
