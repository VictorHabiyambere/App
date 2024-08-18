package com.google.android.gms.internal.ads;

import java.io.EOFException;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzadt implements zzafa {
    private final byte[] zza = new byte[4096];

    public final /* synthetic */ int zzf(zzu zzu, int i, boolean z) {
        return zzaey.zza(this, zzu, i, z);
    }

    public final int zzg(zzu zzu, int i, boolean z, int i2) throws IOException {
        int zza2 = zzu.zza(this.zza, 0, Math.min(4096, i));
        if (zza2 != -1) {
            return zza2;
        }
        if (z) {
            return -1;
        }
        throw new EOFException();
    }

    public final void zzl(zzan zzan) {
    }

    public final /* synthetic */ void zzq(zzfu zzfu, int i) {
        zzaey.zzb(this, zzfu, i);
    }

    public final void zzr(zzfu zzfu, int i, int i2) {
        zzfu.zzL(i);
    }

    public final void zzs(long j, int i, int i2, int i3, zzaez zzaez) {
    }
}
