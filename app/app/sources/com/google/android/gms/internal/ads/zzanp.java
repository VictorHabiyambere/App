package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
final class zzanp implements zzalq {
    private final List zza;
    private final long[] zzb;
    private final long[] zzc;

    public zzanp(List list) {
        this.zza = Collections.unmodifiableList(new ArrayList(list));
        int size = list.size();
        this.zzb = new long[(size + size)];
        for (int i = 0; i < list.size(); i++) {
            zzane zzane = (zzane) list.get(i);
            long[] jArr = this.zzb;
            int i2 = i + i;
            jArr[i2] = zzane.zzb;
            jArr[i2 + 1] = zzane.zzc;
        }
        long[] jArr2 = this.zzb;
        this.zzc = Arrays.copyOf(jArr2, jArr2.length);
        Arrays.sort(this.zzc);
    }

    public final int zza() {
        return this.zzc.length;
    }

    public final long zzb(int i) {
        boolean z;
        boolean z2 = true;
        if (i >= 0) {
            z = true;
        } else {
            z = false;
        }
        zzeq.zzd(z);
        if (i >= this.zzc.length) {
            z2 = false;
        }
        zzeq.zzd(z2);
        return this.zzc[i];
    }

    public final List zzc(long j) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (int i = 0; i < this.zza.size(); i++) {
            long[] jArr = this.zzb;
            int i2 = i + i;
            if (jArr[i2] <= j && j < jArr[i2 + 1]) {
                zzane zzane = (zzane) this.zza.get(i);
                zzei zzei = zzane.zza;
                if (zzei.zzg == -3.4028235E38f) {
                    arrayList2.add(zzane);
                } else {
                    arrayList.add(zzei);
                }
            }
        }
        Collections.sort(arrayList2, new zzano());
        for (int i3 = 0; i3 < arrayList2.size(); i3++) {
            zzeg zzb2 = ((zzane) arrayList2.get(i3)).zza.zzb();
            zzb2.zze((float) (-1 - i3), 1);
            arrayList.add(zzb2.zzp());
        }
        return arrayList;
    }
}
