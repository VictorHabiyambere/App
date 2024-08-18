package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
final class zzajm extends zzajo {
    public final long zza;
    public final List zzb = new ArrayList();
    public final List zzc = new ArrayList();

    public zzajm(int i, long j) {
        super(i);
        this.zza = j;
    }

    public final String toString() {
        List list = this.zzb;
        String zzf = zzf(this.zzd);
        String arrays = Arrays.toString(list.toArray());
        String arrays2 = Arrays.toString(this.zzc.toArray());
        return zzf + " leaves: " + arrays + " containers: " + arrays2;
    }

    public final zzajm zza(int i) {
        int size = this.zzc.size();
        for (int i2 = 0; i2 < size; i2++) {
            zzajm zzajm = (zzajm) this.zzc.get(i2);
            if (zzajm.zzd == i) {
                return zzajm;
            }
        }
        return null;
    }

    public final zzajn zzb(int i) {
        int size = this.zzb.size();
        for (int i2 = 0; i2 < size; i2++) {
            zzajn zzajn = (zzajn) this.zzb.get(i2);
            if (zzajn.zzd == i) {
                return zzajn;
            }
        }
        return null;
    }

    public final void zzc(zzajm zzajm) {
        this.zzc.add(zzajm);
    }

    public final void zzd(zzajn zzajn) {
        this.zzb.add(zzajn);
    }
}
