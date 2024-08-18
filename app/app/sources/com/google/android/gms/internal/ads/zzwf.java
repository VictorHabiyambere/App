package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzwf extends zzuw {
    private static final zzbu zza;
    private final zzvq[] zzb;
    private final zzdc[] zzc;
    private final ArrayList zzd;
    private final Map zze;
    private final zzgca zzf;
    private int zzg = -1;
    private long[][] zzh;
    private zzwe zzi;
    private final zzuz zzj;

    static {
        zzaw zzaw = new zzaw();
        zzaw.zza("MergingMediaSource");
        zza = zzaw.zzc();
    }

    public zzwf(boolean z, boolean z2, zzuz zzuz, zzvq... zzvqArr) {
        this.zzb = zzvqArr;
        this.zzj = zzuz;
        this.zzd = new ArrayList(Arrays.asList(zzvqArr));
        this.zzc = new zzdc[zzvqArr.length];
        this.zzh = new long[0][];
        this.zze = new HashMap();
        this.zzf = zzgci.zzb(8).zzb(2).zza();
    }

    /* access modifiers changed from: protected */
    public final /* bridge */ /* synthetic */ void zzA(Object obj, zzvq zzvq, zzdc zzdc) {
        int i;
        if (this.zzi == null) {
            if (this.zzg == -1) {
                i = zzdc.zzb();
                this.zzg = i;
            } else {
                int zzb2 = zzdc.zzb();
                int i2 = this.zzg;
                if (zzb2 != i2) {
                    this.zzi = new zzwe(0);
                    return;
                }
                i = i2;
            }
            if (this.zzh.length == 0) {
                int[] iArr = new int[2];
                iArr[1] = this.zzc.length;
                iArr[0] = i;
                this.zzh = (long[][]) Array.newInstance(Long.TYPE, iArr);
            }
            this.zzd.remove(zzvq);
            this.zzc[((Integer) obj).intValue()] = zzdc;
            if (this.zzd.isEmpty()) {
                zzo(this.zzc[0]);
            }
        }
    }

    public final void zzG(zzvm zzvm) {
        zzwd zzwd = (zzwd) zzvm;
        int i = 0;
        while (true) {
            zzvq[] zzvqArr = this.zzb;
            if (i < zzvqArr.length) {
                zzvqArr[i].zzG(zzwd.zzn(i));
                i++;
            } else {
                return;
            }
        }
    }

    public final zzvm zzI(zzvo zzvo, zzzv zzzv, long j) {
        zzdc[] zzdcArr = this.zzc;
        int length = this.zzb.length;
        zzvm[] zzvmArr = new zzvm[length];
        int zza2 = zzdcArr[0].zza(zzvo.zza);
        for (int i = 0; i < length; i++) {
            zzvmArr[i] = this.zzb[i].zzI(zzvo.zza(this.zzc[i].zzf(zza2)), zzzv, j - this.zzh[zza2][i]);
        }
        return new zzwd(this.zzj, this.zzh[zza2], zzvmArr);
    }

    public final zzbu zzJ() {
        zzvq[] zzvqArr = this.zzb;
        return zzvqArr.length > 0 ? zzvqArr[0].zzJ() : zza;
    }

    /* access modifiers changed from: protected */
    public final void zzn(zzie zzie) {
        super.zzn(zzie);
        for (int i = 0; i < this.zzb.length; i++) {
            zzB(Integer.valueOf(i), this.zzb[i]);
        }
    }

    /* access modifiers changed from: protected */
    public final void zzq() {
        super.zzq();
        Arrays.fill(this.zzc, (Object) null);
        this.zzg = -1;
        this.zzi = null;
        this.zzd.clear();
        Collections.addAll(this.zzd, this.zzb);
    }

    public final void zzt(zzbu zzbu) {
        this.zzb[0].zzt(zzbu);
    }

    /* access modifiers changed from: protected */
    public final /* bridge */ /* synthetic */ zzvo zzy(Object obj, zzvo zzvo) {
        if (((Integer) obj).intValue() == 0) {
            return zzvo;
        }
        return null;
    }

    public final void zzz() throws IOException {
        zzwe zzwe = this.zzi;
        if (zzwe == null) {
            super.zzz();
            return;
        }
        throw zzwe;
    }
}
