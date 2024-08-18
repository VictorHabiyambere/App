package com.google.android.gms.internal.ads;

import android.util.SparseArray;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzalw implements zzadx {
    private final zzadx zzb;
    private final zzalt zzc;
    private final SparseArray zzd = new SparseArray();

    public zzalw(zzadx zzadx, zzalt zzalt) {
        this.zzb = zzadx;
        this.zzc = zzalt;
    }

    public final void zzD() {
        this.zzb.zzD();
    }

    public final void zzO(zzaet zzaet) {
        this.zzb.zzO(zzaet);
    }

    public final zzafa zzw(int i, int i2) {
        if (i2 != 3) {
            return this.zzb.zzw(i, i2);
        }
        zzaly zzaly = (zzaly) this.zzd.get(i);
        if (zzaly != null) {
            return zzaly;
        }
        zzaly zzaly2 = new zzaly(this.zzb.zzw(i, 3), this.zzc);
        this.zzd.put(i, zzaly2);
        return zzaly2;
    }
}
