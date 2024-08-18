package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.util.Pair;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
final class zzmf {
    private final zzpj zza;
    private final List zzb = new ArrayList();
    private final IdentityHashMap zzc = new IdentityHashMap();
    private final Map zzd = new HashMap();
    private final zzme zze;
    private final HashMap zzf;
    private final Set zzg;
    /* access modifiers changed from: private */
    public final zzmx zzh;
    /* access modifiers changed from: private */
    public final zzfb zzi;
    private boolean zzj;
    private zzie zzk;
    private zzxi zzl = new zzxi(0);

    public zzmf(zzme zzme, zzmx zzmx, zzfb zzfb, zzpj zzpj) {
        this.zza = zzpj;
        this.zze = zzme;
        this.zzh = zzmx;
        this.zzi = zzfb;
        this.zzf = new HashMap();
        this.zzg = new HashSet();
    }

    private final void zzr(int i, int i2) {
        while (i < this.zzb.size()) {
            ((zzmd) this.zzb.get(i)).zzd += i2;
            i++;
        }
    }

    private final void zzs(zzmd zzmd) {
        zzmc zzmc = (zzmc) this.zzf.get(zzmd);
        if (zzmc != null) {
            zzmc.zza.zzi(zzmc.zzb);
        }
    }

    private final void zzt() {
        Iterator it = this.zzg.iterator();
        while (it.hasNext()) {
            zzmd zzmd = (zzmd) it.next();
            if (zzmd.zzc.isEmpty()) {
                zzs(zzmd);
                it.remove();
            }
        }
    }

    private final void zzu(zzmd zzmd) {
        if (zzmd.zze && zzmd.zzc.isEmpty()) {
            zzmc zzmc = (zzmc) this.zzf.remove(zzmd);
            if (zzmc != null) {
                zzmc.zza.zzp(zzmc.zzb);
                zzmc.zza.zzs(zzmc.zzc);
                zzmc.zza.zzr(zzmc.zzc);
                this.zzg.remove(zzmd);
                return;
            }
            throw null;
        }
    }

    private final void zzv(zzmd zzmd) {
        zzvj zzvj = zzmd.zza;
        zzlv zzlv = new zzlv(this);
        zzmb zzmb = new zzmb(this, zzmd);
        this.zzf.put(zzmd, new zzmc(zzvj, zzlv, zzmb));
        zzvj.zzh(new Handler(zzgd.zzy(), (Handler.Callback) null), zzmb);
        zzvj.zzg(new Handler(zzgd.zzy(), (Handler.Callback) null), zzmb);
        zzvj.zzm(zzlv, this.zzk, this.zza);
    }

    private final void zzw(int i, int i2) {
        for (int i3 = i2 - 1; i3 >= i; i3--) {
            zzmd zzmd = (zzmd) this.zzb.remove(i3);
            this.zzd.remove(zzmd.zzb);
            zzr(i3, -zzmd.zza.zzC().zzc());
            zzmd.zze = true;
            if (this.zzj) {
                zzu(zzmd);
            }
        }
    }

    public final int zza() {
        return this.zzb.size();
    }

    public final zzdc zzb() {
        if (this.zzb.isEmpty()) {
            return zzdc.zza;
        }
        int i = 0;
        for (int i2 = 0; i2 < this.zzb.size(); i2++) {
            zzmd zzmd = (zzmd) this.zzb.get(i2);
            zzmd.zzd = i;
            i += zzmd.zza.zzC().zzc();
        }
        return new zzml(this.zzb, this.zzl);
    }

    public final zzdc zzc(int i, int i2, List list) {
        boolean z;
        boolean z2 = true;
        if (i < 0 || i > i2 || i2 > zza()) {
            z = false;
        } else {
            z = true;
        }
        zzeq.zzd(z);
        if (list.size() != i2 - i) {
            z2 = false;
        }
        zzeq.zzd(z2);
        for (int i3 = i; i3 < i2; i3++) {
            ((zzmd) this.zzb.get(i3)).zza.zzt((zzbu) list.get(i3 - i));
        }
        return zzb();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzf(zzvq zzvq, zzdc zzdc) {
        this.zze.zzh();
    }

    public final void zzg(zzie zzie) {
        zzeq.zzf(!this.zzj);
        this.zzk = zzie;
        for (int i = 0; i < this.zzb.size(); i++) {
            zzmd zzmd = (zzmd) this.zzb.get(i);
            zzv(zzmd);
            this.zzg.add(zzmd);
        }
        this.zzj = true;
    }

    public final void zzh() {
        for (zzmc zzmc : this.zzf.values()) {
            try {
                zzmc.zza.zzp(zzmc.zzb);
            } catch (RuntimeException e) {
                zzfk.zzd("MediaSourceList", "Failed to release child source.", e);
            }
            zzmc.zza.zzs(zzmc.zzc);
            zzmc.zza.zzr(zzmc.zzc);
        }
        this.zzf.clear();
        this.zzg.clear();
        this.zzj = false;
    }

    public final void zzi(zzvm zzvm) {
        zzmd zzmd = (zzmd) this.zzc.remove(zzvm);
        if (zzmd != null) {
            zzmd.zza.zzG(zzvm);
            zzmd.zzc.remove(((zzvg) zzvm).zza);
            if (!this.zzc.isEmpty()) {
                zzt();
            }
            zzu(zzmd);
            return;
        }
        throw null;
    }

    public final boolean zzj() {
        return this.zzj;
    }

    public final zzdc zzk(int i, List list, zzxi zzxi) {
        if (!list.isEmpty()) {
            this.zzl = zzxi;
            for (int i2 = i; i2 < list.size() + i; i2++) {
                zzmd zzmd = (zzmd) list.get(i2 - i);
                if (i2 > 0) {
                    zzmd zzmd2 = (zzmd) this.zzb.get(i2 - 1);
                    zzmd.zzc(zzmd2.zzd + zzmd2.zza.zzC().zzc());
                } else {
                    zzmd.zzc(0);
                }
                zzr(i2, zzmd.zza.zzC().zzc());
                this.zzb.add(i2, zzmd);
                this.zzd.put(zzmd.zzb, zzmd);
                if (this.zzj) {
                    zzv(zzmd);
                    if (this.zzc.isEmpty()) {
                        this.zzg.add(zzmd);
                    } else {
                        zzs(zzmd);
                    }
                }
            }
        }
        return zzb();
    }

    public final zzdc zzl(int i, int i2, int i3, zzxi zzxi) {
        boolean z;
        if (zza() >= 0) {
            z = true;
        } else {
            z = false;
        }
        zzeq.zzd(z);
        this.zzl = null;
        return zzb();
    }

    public final zzdc zzm(int i, int i2, zzxi zzxi) {
        boolean z = false;
        if (i >= 0 && i <= i2 && i2 <= zza()) {
            z = true;
        }
        zzeq.zzd(z);
        this.zzl = zzxi;
        zzw(i, i2);
        return zzb();
    }

    public final zzdc zzn(List list, zzxi zzxi) {
        zzw(0, this.zzb.size());
        return zzk(this.zzb.size(), list, zzxi);
    }

    public final zzdc zzo(zzxi zzxi) {
        int zza2 = zza();
        if (zzxi.zzc() != zza2) {
            zzxi = zzxi.zzf().zzg(0, zza2);
        }
        this.zzl = zzxi;
        return zzb();
    }

    public final zzvm zzp(zzvo zzvo, zzzv zzzv, long j) {
        int i = zzml.zzc;
        Object obj = ((Pair) zzvo.zza).first;
        zzvo zza2 = zzvo.zza(((Pair) zzvo.zza).second);
        zzmd zzmd = (zzmd) this.zzd.get(obj);
        if (zzmd != null) {
            this.zzg.add(zzmd);
            zzmc zzmc = (zzmc) this.zzf.get(zzmd);
            if (zzmc != null) {
                zzmc.zza.zzk(zzmc.zzb);
            }
            zzmd.zzc.add(zza2);
            zzvg zzH = zzmd.zza.zzI(zza2, zzzv, j);
            this.zzc.put(zzH, zzmd);
            zzt();
            return zzH;
        }
        throw null;
    }

    public final zzxi zzq() {
        return this.zzl;
    }
}
