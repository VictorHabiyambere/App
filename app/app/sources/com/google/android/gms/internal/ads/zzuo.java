package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.Looper;
import java.util.ArrayList;
import java.util.HashSet;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public abstract class zzuo implements zzvq {
    private final ArrayList zza = new ArrayList(1);
    private final HashSet zzb = new HashSet(1);
    private final zzvx zzc = new zzvx();
    private final zzso zzd = new zzso();
    private Looper zze;
    private zzdc zzf;
    private zzpj zzg;

    public /* synthetic */ zzdc zzM() {
        return null;
    }

    /* access modifiers changed from: protected */
    public final zzpj zzb() {
        zzpj zzpj = this.zzg;
        zzeq.zzb(zzpj);
        return zzpj;
    }

    /* access modifiers changed from: protected */
    public final zzso zzc(zzvo zzvo) {
        return this.zzd.zza(0, zzvo);
    }

    /* access modifiers changed from: protected */
    public final zzso zzd(int i, zzvo zzvo) {
        return this.zzd.zza(0, zzvo);
    }

    /* access modifiers changed from: protected */
    public final zzvx zze(zzvo zzvo) {
        return this.zzc.zza(0, zzvo);
    }

    /* access modifiers changed from: protected */
    public final zzvx zzf(int i, zzvo zzvo) {
        return this.zzc.zza(0, zzvo);
    }

    public final void zzg(Handler handler, zzsp zzsp) {
        this.zzd.zzb(handler, zzsp);
    }

    public final void zzh(Handler handler, zzvy zzvy) {
        this.zzc.zzb(handler, zzvy);
    }

    public final void zzi(zzvp zzvp) {
        boolean z = !this.zzb.isEmpty();
        this.zzb.remove(zzvp);
        if (z && this.zzb.isEmpty()) {
            zzj();
        }
    }

    /* access modifiers changed from: protected */
    public void zzj() {
    }

    public final void zzk(zzvp zzvp) {
        if (this.zze != null) {
            HashSet hashSet = this.zzb;
            boolean isEmpty = hashSet.isEmpty();
            hashSet.add(zzvp);
            if (isEmpty) {
                zzl();
                return;
            }
            return;
        }
        throw null;
    }

    /* access modifiers changed from: protected */
    public void zzl() {
    }

    public final void zzm(zzvp zzvp, zzie zzie, zzpj zzpj) {
        Looper myLooper = Looper.myLooper();
        Looper looper = this.zze;
        boolean z = true;
        if (!(looper == null || looper == myLooper)) {
            z = false;
        }
        zzeq.zzd(z);
        this.zzg = zzpj;
        zzdc zzdc = this.zzf;
        this.zza.add(zzvp);
        if (this.zze == null) {
            this.zze = myLooper;
            this.zzb.add(zzvp);
            zzn(zzie);
        } else if (zzdc != null) {
            zzk(zzvp);
            zzvp.zza(this, zzdc);
        }
    }

    /* access modifiers changed from: protected */
    public abstract void zzn(zzie zzie);

    /* access modifiers changed from: protected */
    public final void zzo(zzdc zzdc) {
        this.zzf = zzdc;
        ArrayList arrayList = this.zza;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            ((zzvp) arrayList.get(i)).zza(this, zzdc);
        }
    }

    public final void zzp(zzvp zzvp) {
        this.zza.remove(zzvp);
        if (this.zza.isEmpty()) {
            this.zze = null;
            this.zzf = null;
            this.zzg = null;
            this.zzb.clear();
            zzq();
            return;
        }
        zzi(zzvp);
    }

    /* access modifiers changed from: protected */
    public abstract void zzq();

    public final void zzr(zzsp zzsp) {
        this.zzd.zzc(zzsp);
    }

    public final void zzs(zzvy zzvy) {
        this.zzc.zzh(zzvy);
    }

    public /* synthetic */ void zzt(zzbu zzbu) {
        throw null;
    }

    /* access modifiers changed from: protected */
    public final boolean zzu() {
        return !this.zzb.isEmpty();
    }

    public /* synthetic */ boolean zzv() {
        return true;
    }
}
