package com.google.android.gms.ads.internal.util;

import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzbh {
    private final String[] zza;
    private final double[] zzb;
    private final double[] zzc;
    private final int[] zzd;
    private int zze = 0;

    /* synthetic */ zzbh(zzbf zzbf, zzbg zzbg) {
        int size = zzbf.zzb.size();
        this.zza = (String[]) zzbf.zza.toArray(new String[size]);
        this.zzb = zzc(zzbf.zzb);
        this.zzc = zzc(zzbf.zzc);
        this.zzd = new int[size];
    }

    private static final double[] zzc(List list) {
        int size = list.size();
        double[] dArr = new double[size];
        for (int i = 0; i < size; i++) {
            dArr[i] = ((Double) list.get(i)).doubleValue();
        }
        return dArr;
    }

    public final List zza() {
        zzbh zzbh = this;
        ArrayList arrayList = new ArrayList(zzbh.zza.length);
        int i = 0;
        while (true) {
            String[] strArr = zzbh.zza;
            if (i >= strArr.length) {
                return arrayList;
            }
            String str = strArr[i];
            double[] dArr = zzbh.zzc;
            double[] dArr2 = zzbh.zzb;
            int[] iArr = zzbh.zzd;
            double d = dArr[i];
            double d2 = dArr2[i];
            int i2 = iArr[i];
            arrayList.add(new zzbe(str, d, d2, ((double) i2) / ((double) zzbh.zze), i2));
            i++;
            zzbh = this;
        }
    }

    public final void zzb(double d) {
        this.zze++;
        int i = 0;
        while (true) {
            double[] dArr = this.zzc;
            if (i < dArr.length) {
                double d2 = dArr[i];
                if (d2 <= d && d < this.zzb[i]) {
                    int[] iArr = this.zzd;
                    iArr[i] = iArr[i] + 1;
                }
                if (d >= d2) {
                    i++;
                } else {
                    return;
                }
            } else {
                return;
            }
        }
    }
}
