package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
final class zzoz {
    private final zzcz zza;
    /* access modifiers changed from: private */
    public zzgbc zzb = zzgbc.zzm();
    private zzgbf zzc = zzgbf.zzd();
    private zzvo zzd;
    private zzvo zze;
    private zzvo zzf;

    public zzoz(zzcz zzcz) {
        this.zza = zzcz;
    }

    private static zzvo zzj(zzct zzct, zzgbc zzgbc, zzvo zzvo, zzcz zzcz) {
        int i;
        zzdc zzn = zzct.zzn();
        int zze2 = zzct.zze();
        Object zzf2 = zzn.zzo() ? null : zzn.zzf(zze2);
        if (!zzct.zzx()) {
            i = zzn.zzo() ? -1 : zzn.zzd(zze2, zzcz, false).zzc(zzgd.zzr(zzct.zzk()));
        } else {
            i = -1;
        }
        for (int i2 = 0; i2 < zzgbc.size(); i2++) {
            zzvo zzvo2 = (zzvo) zzgbc.get(i2);
            if (zzm(zzvo2, zzf2, zzct.zzx(), zzct.zzb(), zzct.zzc(), i)) {
                return zzvo2;
            }
        }
        if (zzgbc.isEmpty() && zzvo != null) {
            if (zzm(zzvo, zzf2, zzct.zzx(), zzct.zzb(), zzct.zzc(), i)) {
                return zzvo;
            }
        }
        return null;
    }

    private final void zzk(zzgbe zzgbe, zzvo zzvo, zzdc zzdc) {
        if (zzvo != null) {
            if (zzdc.zza(zzvo.zza) != -1) {
                zzgbe.zza(zzvo, zzdc);
                return;
            }
            zzdc zzdc2 = (zzdc) this.zzc.get(zzvo);
            if (zzdc2 != null) {
                zzgbe.zza(zzvo, zzdc2);
            }
        }
    }

    private final void zzl(zzdc zzdc) {
        zzgbe zzgbe = new zzgbe();
        if (this.zzb.isEmpty()) {
            zzk(zzgbe, this.zze, zzdc);
            if (!zzfya.zza(this.zzf, this.zze)) {
                zzk(zzgbe, this.zzf, zzdc);
            }
            if (!zzfya.zza(this.zzd, this.zze) && !zzfya.zza(this.zzd, this.zzf)) {
                zzk(zzgbe, this.zzd, zzdc);
            }
        } else {
            for (int i = 0; i < this.zzb.size(); i++) {
                zzk(zzgbe, (zzvo) this.zzb.get(i), zzdc);
            }
            if (!this.zzb.contains(this.zzd)) {
                zzk(zzgbe, this.zzd, zzdc);
            }
        }
        this.zzc = zzgbe.zzc();
    }

    private static boolean zzm(zzvo zzvo, Object obj, boolean z, int i, int i2, int i3) {
        if (!zzvo.zza.equals(obj)) {
            return false;
        }
        if (z) {
            if (!(zzvo.zzb == i && zzvo.zzc == i2)) {
                return false;
            }
        } else if (!(zzvo.zzb == -1 && zzvo.zze == i3)) {
            return false;
        }
        return true;
    }

    public final zzdc zza(zzvo zzvo) {
        return (zzdc) this.zzc.get(zzvo);
    }

    public final zzvo zzb() {
        return this.zzd;
    }

    public final zzvo zzc() {
        Object obj;
        Object next;
        if (this.zzb.isEmpty()) {
            return null;
        }
        zzgbc zzgbc = this.zzb;
        if (!(zzgbc instanceof List)) {
            Iterator it = zzgbc.iterator();
            do {
                next = it.next();
            } while (it.hasNext());
            obj = next;
        } else if (!zzgbc.isEmpty()) {
            obj = zzgbc.get(zzgbc.size() - 1);
        } else {
            throw new NoSuchElementException();
        }
        return (zzvo) obj;
    }

    public final zzvo zzd() {
        return this.zze;
    }

    public final zzvo zze() {
        return this.zzf;
    }

    public final void zzg(zzct zzct) {
        this.zzd = zzj(zzct, this.zzb, this.zze, this.zza);
    }

    public final void zzh(List list, zzvo zzvo, zzct zzct) {
        this.zzb = zzgbc.zzk(list);
        if (!list.isEmpty()) {
            this.zze = (zzvo) list.get(0);
            if (zzvo != null) {
                this.zzf = zzvo;
            } else {
                throw null;
            }
        }
        if (this.zzd == null) {
            this.zzd = zzj(zzct, this.zzb, this.zze, this.zza);
        }
        zzl(zzct.zzn());
    }

    public final void zzi(zzct zzct) {
        this.zzd = zzj(zzct, this.zzb, this.zze, this.zza);
        zzl(zzct.zzn());
    }
}
