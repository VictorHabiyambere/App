package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Point;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzyq extends zzdk {
    /* access modifiers changed from: private */
    public boolean zza;
    /* access modifiers changed from: private */
    public boolean zzb;
    /* access modifiers changed from: private */
    public boolean zzc;
    /* access modifiers changed from: private */
    public boolean zzd;
    /* access modifiers changed from: private */
    public boolean zze;
    /* access modifiers changed from: private */
    public boolean zzf;
    /* access modifiers changed from: private */
    public boolean zzg;
    /* access modifiers changed from: private */
    public final SparseArray zzh;
    /* access modifiers changed from: private */
    public final SparseBooleanArray zzi;

    @Deprecated
    public zzyq() {
        this.zzh = new SparseArray();
        this.zzi = new SparseBooleanArray();
        zzx();
    }

    private final void zzx() {
        this.zza = true;
        this.zzb = true;
        this.zzc = true;
        this.zzd = true;
        this.zze = true;
        this.zzf = true;
        this.zzg = true;
    }

    public final zzyq zzp(int i, boolean z) {
        if (this.zzi.get(i) != z) {
            if (z) {
                this.zzi.put(i, true);
            } else {
                this.zzi.delete(i);
            }
        }
        return this;
    }

    public zzyq(Context context) {
        super.zze(context);
        Point zzv = zzgd.zzv(context);
        super.zzf(zzv.x, zzv.y, true);
        this.zzh = new SparseArray();
        this.zzi = new SparseBooleanArray();
        zzx();
    }

    /* synthetic */ zzyq(zzys zzys, zzyp zzyp) {
        super(zzys);
        this.zza = zzys.zzI;
        this.zzb = zzys.zzK;
        this.zzc = zzys.zzM;
        this.zzd = zzys.zzR;
        this.zze = zzys.zzS;
        this.zzf = zzys.zzT;
        this.zzg = zzys.zzV;
        SparseArray zza2 = zzys.zzaq;
        SparseArray sparseArray = new SparseArray();
        for (int i = 0; i < zza2.size(); i++) {
            sparseArray.put(zza2.keyAt(i), new HashMap((Map) zza2.valueAt(i)));
        }
        this.zzh = sparseArray;
        this.zzi = zzys.zzar.clone();
    }
}
