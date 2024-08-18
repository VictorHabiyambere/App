package com.google.android.gms.internal.ads;

import android.util.Pair;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
final class zzmb implements zzvy, zzsp {
    final /* synthetic */ zzmf zza;
    private final zzmd zzb;

    public zzmb(zzmf zzmf, zzmd zzmd) {
        this.zza = zzmf;
        this.zzb = zzmd;
    }

    private final Pair zzf(int i, zzvo zzvo) {
        zzvo zzvo2;
        zzvo zzvo3 = null;
        if (zzvo != null) {
            zzmd zzmd = this.zzb;
            int i2 = 0;
            while (true) {
                if (i2 >= zzmd.zzc.size()) {
                    zzvo2 = null;
                    break;
                } else if (((zzvo) zzmd.zzc.get(i2)).zzd == zzvo.zzd) {
                    zzvo2 = zzvo.zza(Pair.create(zzmd.zzb, zzvo.zza));
                    break;
                } else {
                    i2++;
                }
            }
            if (zzvo2 == null) {
                return null;
            }
            zzvo3 = zzvo2;
        }
        return Pair.create(Integer.valueOf(this.zzb.zzd), zzvo3);
    }

    public final void zzae(int i, zzvo zzvo, zzvk zzvk) {
        Pair zzf = zzf(0, zzvo);
        if (zzf != null) {
            this.zza.zzi.zzh(new zzlz(this, zzf, zzvk));
        }
    }

    public final void zzaf(int i, zzvo zzvo, zzvf zzvf, zzvk zzvk) {
        Pair zzf = zzf(0, zzvo);
        if (zzf != null) {
            this.zza.zzi.zzh(new zzlx(this, zzf, zzvf, zzvk));
        }
    }

    public final void zzag(int i, zzvo zzvo, zzvf zzvf, zzvk zzvk) {
        Pair zzf = zzf(0, zzvo);
        if (zzf != null) {
            this.zza.zzi.zzh(new zzma(this, zzf, zzvf, zzvk));
        }
    }

    public final void zzah(int i, zzvo zzvo, zzvf zzvf, zzvk zzvk, IOException iOException, boolean z) {
        Pair zzf = zzf(0, zzvo);
        if (zzf != null) {
            this.zza.zzi.zzh(new zzlw(this, zzf, zzvf, zzvk, iOException, z));
        }
    }

    public final void zzai(int i, zzvo zzvo, zzvf zzvf, zzvk zzvk) {
        Pair zzf = zzf(0, zzvo);
        if (zzf != null) {
            this.zza.zzi.zzh(new zzly(this, zzf, zzvf, zzvk));
        }
    }
}
