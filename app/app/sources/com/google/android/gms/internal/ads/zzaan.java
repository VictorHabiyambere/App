package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzaan {
    private static final Comparator zza = new zzaaj();
    private static final Comparator zzb = new zzaak();
    private final ArrayList zzc = new ArrayList();
    private final zzaam[] zzd = new zzaam[5];
    private int zze = -1;
    private int zzf;
    private int zzg;
    private int zzh;

    public zzaan(int i) {
    }

    public final float zza(float f) {
        if (this.zze != 0) {
            Collections.sort(this.zzc, zzb);
            this.zze = 0;
        }
        float f2 = (float) this.zzg;
        int i = 0;
        for (int i2 = 0; i2 < this.zzc.size(); i2++) {
            zzaam zzaam = (zzaam) this.zzc.get(i2);
            i += zzaam.zzb;
            if (((float) i) >= 0.5f * f2) {
                return zzaam.zzc;
            }
        }
        if (this.zzc.isEmpty()) {
            return Float.NaN;
        }
        ArrayList arrayList = this.zzc;
        return ((zzaam) arrayList.get(arrayList.size() - 1)).zzc;
    }

    public final void zzb(int i, float f) {
        zzaam zzaam;
        if (this.zze != 1) {
            Collections.sort(this.zzc, zza);
            this.zze = 1;
        }
        int i2 = this.zzh;
        if (i2 > 0) {
            zzaam[] zzaamArr = this.zzd;
            int i3 = i2 - 1;
            this.zzh = i3;
            zzaam = zzaamArr[i3];
        } else {
            zzaam = new zzaam((zzaal) null);
        }
        int i4 = this.zzf;
        this.zzf = i4 + 1;
        zzaam.zza = i4;
        zzaam.zzb = i;
        zzaam.zzc = f;
        this.zzc.add(zzaam);
        this.zzg += i;
        while (true) {
            int i5 = this.zzg;
            if (i5 > 2000) {
                int i6 = i5 - 2000;
                zzaam zzaam2 = (zzaam) this.zzc.get(0);
                int i7 = zzaam2.zzb;
                if (i7 <= i6) {
                    this.zzg -= i7;
                    this.zzc.remove(0);
                    int i8 = this.zzh;
                    if (i8 < 5) {
                        zzaam[] zzaamArr2 = this.zzd;
                        this.zzh = i8 + 1;
                        zzaamArr2[i8] = zzaam2;
                    }
                } else {
                    zzaam2.zzb = i7 - i6;
                    this.zzg -= i6;
                }
            } else {
                return;
            }
        }
    }

    public final void zzc() {
        this.zzc.clear();
        this.zze = -1;
        this.zzf = 0;
        this.zzg = 0;
    }
}
