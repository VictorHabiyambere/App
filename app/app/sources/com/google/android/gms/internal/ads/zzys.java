package com.google.android.gms.internal.ads;

import android.content.Context;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import androidx.core.view.PointerIconCompat;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzys extends zzdl {
    public static final zzys zzF = new zzys(new zzyq());
    @Deprecated
    public static final zzys zzG = zzF;
    @Deprecated
    public static final zzn zzH = new zzyo();
    private static final String zzX = Integer.toString(1000, 36);
    private static final String zzY = Integer.toString(1001, 36);
    private static final String zzZ = Integer.toString(1002, 36);
    private static final String zzaa = Integer.toString(PointerIconCompat.TYPE_HELP, 36);
    private static final String zzab = Integer.toString(PointerIconCompat.TYPE_WAIT, 36);
    private static final String zzac = Integer.toString(1005, 36);
    private static final String zzad = Integer.toString(PointerIconCompat.TYPE_CELL, 36);
    private static final String zzae = Integer.toString(PointerIconCompat.TYPE_CROSSHAIR, 36);
    private static final String zzaf = Integer.toString(PointerIconCompat.TYPE_TEXT, 36);
    private static final String zzag = Integer.toString(PointerIconCompat.TYPE_VERTICAL_TEXT, 36);
    private static final String zzah = Integer.toString(PointerIconCompat.TYPE_ALIAS, 36);
    private static final String zzai = Integer.toString(PointerIconCompat.TYPE_COPY, 36);
    private static final String zzaj = Integer.toString(PointerIconCompat.TYPE_NO_DROP, 36);
    private static final String zzak = Integer.toString(PointerIconCompat.TYPE_ALL_SCROLL, 36);
    private static final String zzal = Integer.toString(PointerIconCompat.TYPE_HORIZONTAL_DOUBLE_ARROW, 36);
    private static final String zzam = Integer.toString(PointerIconCompat.TYPE_VERTICAL_DOUBLE_ARROW, 36);
    private static final String zzan = Integer.toString(PointerIconCompat.TYPE_TOP_RIGHT_DIAGONAL_DOUBLE_ARROW, 36);
    private static final String zzao = Integer.toString(PointerIconCompat.TYPE_TOP_LEFT_DIAGONAL_DOUBLE_ARROW, 36);
    private static final String zzap = Integer.toString(PointerIconCompat.TYPE_ZOOM_IN, 36);
    public final boolean zzI;
    public final boolean zzJ;
    public final boolean zzK;
    public final boolean zzL;
    public final boolean zzM;
    public final boolean zzN;
    public final boolean zzO;
    public final boolean zzP;
    public final boolean zzQ;
    public final boolean zzR;
    public final boolean zzS;
    public final boolean zzT;
    public final boolean zzU;
    public final boolean zzV;
    public final boolean zzW;
    /* access modifiers changed from: private */
    public final SparseArray zzaq;
    /* access modifiers changed from: private */
    public final SparseBooleanArray zzar;

    private zzys(zzyq zzyq) {
        super(zzyq);
        this.zzI = zzyq.zza;
        this.zzJ = false;
        this.zzK = zzyq.zzb;
        this.zzL = false;
        this.zzM = zzyq.zzc;
        this.zzN = false;
        this.zzO = false;
        this.zzP = false;
        this.zzQ = false;
        this.zzR = zzyq.zzd;
        this.zzS = zzyq.zze;
        this.zzT = zzyq.zzf;
        this.zzU = false;
        this.zzV = zzyq.zzg;
        this.zzW = false;
        this.zzaq = zzyq.zzh;
        this.zzar = zzyq.zzi;
    }

    public static zzys zzd(Context context) {
        return new zzys(new zzyq(context));
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        zzys zzys = (zzys) obj;
        if (super.equals(zzys) && this.zzI == zzys.zzI && this.zzK == zzys.zzK && this.zzM == zzys.zzM && this.zzR == zzys.zzR && this.zzS == zzys.zzS && this.zzT == zzys.zzT && this.zzV == zzys.zzV) {
            SparseBooleanArray sparseBooleanArray = this.zzar;
            SparseBooleanArray sparseBooleanArray2 = zzys.zzar;
            int size = sparseBooleanArray.size();
            if (sparseBooleanArray2.size() == size) {
                int i = 0;
                while (true) {
                    if (i >= size) {
                        SparseArray sparseArray = this.zzaq;
                        SparseArray sparseArray2 = zzys.zzaq;
                        int size2 = sparseArray.size();
                        if (sparseArray2.size() == size2) {
                            int i2 = 0;
                            while (i2 < size2) {
                                int indexOfKey = sparseArray2.indexOfKey(sparseArray.keyAt(i2));
                                if (indexOfKey >= 0) {
                                    Map map = (Map) sparseArray.valueAt(i2);
                                    Map map2 = (Map) sparseArray2.valueAt(indexOfKey);
                                    if (map2.size() == map.size()) {
                                        for (Map.Entry entry : map.entrySet()) {
                                            zzxr zzxr = (zzxr) entry.getKey();
                                            if (map2.containsKey(zzxr)) {
                                                if (!zzgd.zzG(entry.getValue(), map2.get(zzxr))) {
                                                }
                                            }
                                        }
                                        i2++;
                                    }
                                }
                            }
                            return true;
                        }
                    } else if (sparseBooleanArray2.indexOfKey(sparseBooleanArray.keyAt(i)) < 0) {
                        break;
                    } else {
                        i++;
                    }
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        return (((((((((((((((super.hashCode() + 31) * 31) + (this.zzI ? 1 : 0)) * 961) + (this.zzK ? 1 : 0)) * 961) + (this.zzM ? 1 : 0)) * 28629151) + (this.zzR ? 1 : 0)) * 31) + (this.zzS ? 1 : 0)) * 31) + (this.zzT ? 1 : 0)) * 961) + (this.zzV ? 1 : 0)) * 31;
    }

    public final zzyq zzc() {
        return new zzyq(this, (zzyp) null);
    }

    @Deprecated
    public final zzyu zze(int i, zzxr zzxr) {
        Map map = (Map) this.zzaq.get(i);
        if (map != null) {
            return (zzyu) map.get(zzxr);
        }
        return null;
    }

    public final boolean zzf(int i) {
        return this.zzar.get(i);
    }

    @Deprecated
    public final boolean zzg(int i, zzxr zzxr) {
        Map map = (Map) this.zzaq.get(i);
        return map != null && map.containsKey(zzxr);
    }
}
