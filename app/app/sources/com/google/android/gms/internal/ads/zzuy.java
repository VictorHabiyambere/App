package com.google.android.gms.internal.ads;

import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzuy implements zzxh {
    private final zzgbc zza;
    private long zzb;

    public zzuy(List list, List list2) {
        boolean z;
        zzgaz zzgaz = new zzgaz();
        if (list.size() == list2.size()) {
            z = true;
        } else {
            z = false;
        }
        zzeq.zzd(z);
        for (int i = 0; i < list.size(); i++) {
            zzgaz.zzf(new zzux((zzxh) list.get(i), (List) list2.get(i)));
        }
        this.zza = zzgaz.zzi();
        this.zzb = -9223372036854775807L;
    }

    public final long zzb() {
        long j = Long.MAX_VALUE;
        long j2 = Long.MAX_VALUE;
        for (int i = 0; i < this.zza.size(); i++) {
            zzux zzux = (zzux) this.zza.get(i);
            long zzb2 = zzux.zzb();
            if ((zzux.zza().contains(1) || zzux.zza().contains(2) || zzux.zza().contains(4)) && zzb2 != Long.MIN_VALUE) {
                j = Math.min(j, zzb2);
            }
            if (zzb2 != Long.MIN_VALUE) {
                j2 = Math.min(j2, zzb2);
            }
        }
        if (j != Long.MAX_VALUE) {
            this.zzb = j;
            return j;
        } else if (j2 == Long.MAX_VALUE) {
            return Long.MIN_VALUE;
        } else {
            long j3 = this.zzb;
            return j3 != -9223372036854775807L ? j3 : j2;
        }
    }

    public final long zzc() {
        long j = Long.MAX_VALUE;
        for (int i = 0; i < this.zza.size(); i++) {
            long zzc = ((zzux) this.zza.get(i)).zzc();
            if (zzc != Long.MIN_VALUE) {
                j = Math.min(j, zzc);
            }
        }
        if (j == Long.MAX_VALUE) {
            return Long.MIN_VALUE;
        }
        return j;
    }

    public final void zzm(long j) {
        for (int i = 0; i < this.zza.size(); i++) {
            ((zzux) this.zza.get(i)).zzm(j);
        }
    }

    public final boolean zzo(zzlo zzlo) {
        boolean z;
        boolean z2;
        boolean z3 = false;
        do {
            long zzc = zzc();
            if (zzc == Long.MIN_VALUE) {
                break;
            }
            z = false;
            for (int i = 0; i < this.zza.size(); i++) {
                long zzc2 = ((zzux) this.zza.get(i)).zzc();
                if (zzc2 == Long.MIN_VALUE || zzc2 > zzlo.zza) {
                    z2 = false;
                } else {
                    z2 = true;
                }
                if (zzc2 == zzc || z2) {
                    z |= ((zzux) this.zza.get(i)).zzo(zzlo);
                }
            }
            z3 |= z;
        } while (z);
        return z3;
    }

    public final boolean zzp() {
        for (int i = 0; i < this.zza.size(); i++) {
            if (((zzux) this.zza.get(i)).zzp()) {
                return true;
            }
        }
        return false;
    }
}
