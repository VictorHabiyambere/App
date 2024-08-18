package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.Looper;
import android.util.SparseArray;
import androidx.core.view.PointerIconCompat;
import java.io.IOException;
import java.util.List;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzpa implements zzmx {
    private final zzer zza;
    private final zzcz zzb;
    private final zzdb zzc;
    private final zzoz zzd;
    private final SparseArray zze;
    private zzfh zzf;
    private zzct zzg;
    private zzfb zzh;
    private boolean zzi;

    public static /* synthetic */ void zzV(zzpa zzpa) {
        zzmy zzT = zzpa.zzT();
        zzpa.zzY(zzT, 1028, new zznc(zzT));
        zzpa.zzf.zze();
    }

    private final zzmy zzaa(int i, zzvo zzvo) {
        zzct zzct = this.zzg;
        if (zzct == null) {
            throw null;
        } else if (zzvo == null) {
            zzdc zzn = zzct.zzn();
            if (i >= zzn.zzc()) {
                zzn = zzdc.zza;
            }
            return zzU(zzn, i, (zzvo) null);
        } else if (this.zzd.zza(zzvo) != null) {
            return zzZ(zzvo);
        } else {
            return zzU(zzdc.zza, i, zzvo);
        }
    }

    private final zzmy zzab() {
        return zzZ(this.zzd.zzd());
    }

    private final zzmy zzac() {
        return zzZ(this.zzd.zze());
    }

    private final zzmy zzad(zzcj zzcj) {
        zzvo zzvo;
        if (!(zzcj instanceof zzjh) || (zzvo = ((zzjh) zzcj).zzj) == null) {
            return zzT();
        }
        return zzZ(zzvo);
    }

    public final void zzA(zzan zzan, zziy zziy) {
        zzmy zzac = zzac();
        zzY(zzac, PointerIconCompat.TYPE_VERTICAL_TEXT, new zzoo(zzac, zzan, zziy));
    }

    public final void zzB(long j) {
        zzmy zzac = zzac();
        zzY(zzac, PointerIconCompat.TYPE_ALIAS, new zzns(zzac, j));
    }

    public final void zzC(Exception exc) {
        zzmy zzac = zzac();
        zzY(zzac, PointerIconCompat.TYPE_HORIZONTAL_DOUBLE_ARROW, new zzow(zzac, exc));
    }

    public final void zzD(zzqp zzqp) {
        zzmy zzac = zzac();
        zzY(zzac, 1031, new zzol(zzac, zzqp));
    }

    public final void zzE(zzqp zzqp) {
        zzmy zzac = zzac();
        zzY(zzac, 1032, new zzov(zzac, zzqp));
    }

    public final void zzF(int i, long j, long j2) {
        zzmy zzac = zzac();
        zzY(zzac, PointerIconCompat.TYPE_COPY, new zzno(zzac, i, j, j2));
    }

    public final void zzG(int i, long j) {
        zzmy zzab = zzab();
        zzY(zzab, PointerIconCompat.TYPE_ZOOM_IN, new zzny(zzab, i, j));
    }

    public final void zzH(Object obj, long j) {
        zzmy zzac = zzac();
        zzY(zzac, 26, new zzos(zzac, obj, j));
    }

    public final void zzI(Exception exc) {
        zzmy zzac = zzac();
        zzY(zzac, 1030, new zznn(zzac, exc));
    }

    public final void zzJ(String str, long j, long j2) {
        zzmy zzac = zzac();
        zzY(zzac, PointerIconCompat.TYPE_TOP_RIGHT_DIAGONAL_DOUBLE_ARROW, new zzou(zzac, str, j2, j));
    }

    public final void zzK(String str) {
        zzmy zzac = zzac();
        zzY(zzac, PointerIconCompat.TYPE_ZOOM_OUT, new zznx(zzac, str));
    }

    public final void zzL(zzix zzix) {
        zzmy zzab = zzab();
        zzY(zzab, PointerIconCompat.TYPE_GRAB, new zzok(zzab, zzix));
    }

    public final void zzM(zzix zzix) {
        zzmy zzac = zzac();
        zzY(zzac, PointerIconCompat.TYPE_VERTICAL_DOUBLE_ARROW, new zzoq(zzac, zzix));
    }

    public final void zzN(long j, int i) {
        zzmy zzab = zzab();
        zzY(zzab, PointerIconCompat.TYPE_GRABBING, new zzoc(zzab, j, i));
    }

    public final void zzO(zzan zzan, zziy zziy) {
        zzmy zzac = zzac();
        zzY(zzac, PointerIconCompat.TYPE_TOP_LEFT_DIAGONAL_DOUBLE_ARROW, new zzoj(zzac, zzan, zziy));
    }

    public final void zzP() {
        zzfb zzfb = this.zzh;
        zzeq.zzb(zzfb);
        zzfb.zzh(new zzor(this));
    }

    public final void zzQ(zzna zzna) {
        this.zzf.zzf(zzna);
    }

    public final void zzR(zzct zzct, Looper looper) {
        boolean z = true;
        if (this.zzg != null && !this.zzd.zzb.isEmpty()) {
            z = false;
        }
        zzeq.zzf(z);
        if (zzct != null) {
            this.zzg = zzct;
            this.zzh = this.zza.zzb(looper, (Handler.Callback) null);
            this.zzf = this.zzf.zza(looper, new zznq(this, zzct));
            return;
        }
        throw null;
    }

    /* access modifiers changed from: protected */
    public final zzmy zzT() {
        return zzZ(this.zzd.zzb());
    }

    /* access modifiers changed from: protected */
    @RequiresNonNull({"player"})
    public final zzmy zzU(zzdc zzdc, int i, zzvo zzvo) {
        zzdc zzdc2 = zzdc;
        int i2 = i;
        boolean z = true;
        zzvo zzvo2 = true == zzdc.zzo() ? null : zzvo;
        long zza2 = this.zza.zza();
        if (!zzdc2.equals(this.zzg.zzn()) || i2 != this.zzg.zzd()) {
            z = false;
        }
        long j = 0;
        if (zzvo2 == null || !zzvo2.zzb()) {
            if (z) {
                j = this.zzg.zzj();
            } else if (!zzdc.zzo()) {
                long j2 = zzdc2.zze(i2, this.zzc, 0).zzn;
                j = zzgd.zzu(0);
            }
        } else if (z && this.zzg.zzb() == zzvo2.zzb && this.zzg.zzc() == zzvo2.zzc) {
            j = this.zzg.zzk();
        }
        return new zzmy(zza2, zzdc, i, zzvo2, j, this.zzg.zzn(), this.zzg.zzd(), this.zzd.zzb(), this.zzg.zzk(), this.zzg.zzm());
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzW(zzct zzct, zzna zzna, zzah zzah) {
        zzna.zzi(zzct, new zzmz(zzah, this.zze));
    }

    public final void zzX(int i, long j, long j2) {
        zzmy zzZ = zzZ(this.zzd.zzc());
        zzY(zzZ, PointerIconCompat.TYPE_CELL, new zznl(zzZ, i, j, j2));
    }

    /* access modifiers changed from: protected */
    public final void zzY(zzmy zzmy, int i, zzfe zzfe) {
        this.zze.put(i, zzmy);
        zzfh zzfh = this.zzf;
        zzfh.zzd(i, zzfe);
        zzfh.zzc();
    }

    public final void zza(zzcp zzcp) {
        zzmy zzT = zzT();
        zzY(zzT, 13, new zznh(zzT, zzcp));
    }

    public final void zzae(int i, zzvo zzvo, zzvk zzvk) {
        zzmy zzaa = zzaa(i, zzvo);
        zzY(zzaa, PointerIconCompat.TYPE_WAIT, new zzod(zzaa, zzvk));
    }

    public final void zzaf(int i, zzvo zzvo, zzvf zzvf, zzvk zzvk) {
        zzmy zzaa = zzaa(i, zzvo);
        zzY(zzaa, 1002, new zzoe(zzaa, zzvf, zzvk));
    }

    public final void zzag(int i, zzvo zzvo, zzvf zzvf, zzvk zzvk) {
        zzmy zzaa = zzaa(i, zzvo);
        zzY(zzaa, 1001, new zzoi(zzaa, zzvf, zzvk));
    }

    public final void zzah(int i, zzvo zzvo, zzvf zzvf, zzvk zzvk, IOException iOException, boolean z) {
        zzmy zzaa = zzaa(i, zzvo);
        zzY(zzaa, PointerIconCompat.TYPE_HELP, new zznp(zzaa, zzvf, zzvk, iOException, z));
    }

    public final void zzai(int i, zzvo zzvo, zzvf zzvf, zzvk zzvk) {
        zzmy zzaa = zzaa(i, zzvo);
        zzY(zzaa, 1000, new zzng(zzaa, zzvf, zzvk));
    }

    public final void zzb(boolean z) {
        zzmy zzT = zzT();
        zzY(zzT, 3, new zzne(zzT, z));
    }

    public final void zzc(boolean z) {
        zzmy zzT = zzT();
        zzY(zzT, 7, new zznt(zzT, z));
    }

    public final void zzd(zzbu zzbu, int i) {
        zzmy zzT = zzT();
        zzY(zzT, 1, new zznj(zzT, zzbu, i));
    }

    public final void zze(zzca zzca) {
        zzmy zzT = zzT();
        zzY(zzT, 14, new zzox(zzT, zzca));
    }

    public final void zzf(boolean z, int i) {
        zzmy zzT = zzT();
        zzY(zzT, 5, new zzoa(zzT, z, i));
    }

    public final void zzg(zzcl zzcl) {
        zzmy zzT = zzT();
        zzY(zzT, 12, new zznb(zzT, zzcl));
    }

    public final void zzh(int i) {
        zzmy zzT = zzT();
        zzY(zzT, 4, new zzoh(zzT, i));
    }

    public final void zzi(int i) {
        zzmy zzT = zzT();
        zzY(zzT, 6, new zznw(zzT, i));
    }

    public final void zzj(zzcj zzcj) {
        zzmy zzad = zzad(zzcj);
        zzY(zzad, 10, new zzof(zzad, zzcj));
    }

    public final void zzk(zzcj zzcj) {
        zzmy zzad = zzad(zzcj);
        zzY(zzad, 10, new zznz(zzad, zzcj));
    }

    public final void zzl(boolean z, int i) {
        zzmy zzT = zzT();
        zzY(zzT, -1, new zznr(zzT, z, i));
    }

    public final void zzn(boolean z) {
        zzmy zzac = zzac();
        zzY(zzac, 23, new zznk(zzac, z));
    }

    public final void zzo(int i, int i2) {
        zzmy zzac = zzac();
        zzY(zzac, 24, new zzoy(zzac, i, i2));
    }

    public final void zzq(zzdp zzdp) {
        zzmy zzT = zzT();
        zzY(zzT, 2, new zznu(zzT, zzdp));
    }

    public final void zzr(zzdv zzdv) {
        zzmy zzac = zzac();
        zzY(zzac, 25, new zzom(zzac, zzdv));
    }

    public final void zzs(float f) {
        zzmy zzac = zzac();
        zzY(zzac, 22, new zznm(zzac, f));
    }

    public final void zzt(zzna zzna) {
        this.zzf.zzb(zzna);
    }

    public final void zzu() {
        if (!this.zzi) {
            zzmy zzT = zzT();
            this.zzi = true;
            zzY(zzT, -1, new zzon(zzT));
        }
    }

    public final void zzv(Exception exc) {
        zzmy zzac = zzac();
        zzY(zzac, 1029, new zzot(zzac, exc));
    }

    public final void zzw(String str, long j, long j2) {
        zzmy zzac = zzac();
        zzY(zzac, PointerIconCompat.TYPE_TEXT, new zznv(zzac, str, j2, j));
    }

    public final void zzx(String str) {
        zzmy zzac = zzac();
        zzY(zzac, PointerIconCompat.TYPE_NO_DROP, new zznf(zzac, str));
    }

    public final void zzy(zzix zzix) {
        zzmy zzab = zzab();
        zzY(zzab, PointerIconCompat.TYPE_ALL_SCROLL, new zzog(zzab, zzix));
    }

    public final void zzz(zzix zzix) {
        zzmy zzac = zzac();
        zzY(zzac, PointerIconCompat.TYPE_CROSSHAIR, new zznd(zzac, zzix));
    }

    private final zzmy zzZ(zzvo zzvo) {
        zzdc zzdc;
        if (this.zzg != null) {
            if (zzvo == null) {
                zzdc = null;
            } else {
                zzdc = this.zzd.zza(zzvo);
            }
            if (zzvo == null || zzdc == null) {
                int zzd2 = this.zzg.zzd();
                zzdc zzn = this.zzg.zzn();
                if (zzd2 >= zzn.zzc()) {
                    zzn = zzdc.zza;
                }
                return zzU(zzn, zzd2, (zzvo) null);
            }
            return zzU(zzdc, zzdc.zzn(zzvo.zza, this.zzb).zzd, zzvo);
        }
        throw null;
    }

    public final void zzS(List list, zzvo zzvo) {
        zzct zzct = this.zzg;
        if (zzct != null) {
            this.zzd.zzh(list, zzvo, zzct);
            return;
        }
        throw null;
    }

    public final void zzm(zzcs zzcs, zzcs zzcs2, int i) {
        if (i == 1) {
            this.zzi = false;
            i = 1;
        }
        zzoz zzoz = this.zzd;
        zzct zzct = this.zzg;
        if (zzct != null) {
            zzoz.zzg(zzct);
            zzmy zzT = zzT();
            zzY(zzT, 11, new zzop(zzT, i, zzcs, zzcs2));
            return;
        }
        throw null;
    }

    public final void zzp(zzdc zzdc, int i) {
        zzct zzct = this.zzg;
        if (zzct != null) {
            this.zzd.zzi(zzct);
            zzmy zzT = zzT();
            zzY(zzT, 0, new zzni(zzT, i));
            return;
        }
        throw null;
    }

    public zzpa(zzer zzer) {
        if (zzer != null) {
            this.zza = zzer;
            this.zzf = new zzfh(zzgd.zzy(), zzer, new zzob());
            this.zzb = new zzcz();
            this.zzc = new zzdb();
            this.zzd = new zzoz(this.zzb);
            this.zze = new SparseArray();
            return;
        }
        throw null;
    }
}
