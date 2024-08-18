package com.google.android.gms.internal.ads;

import android.os.Handler;
import java.io.IOException;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzvx {
    public final int zza;
    public final zzvo zzb;
    private final CopyOnWriteArrayList zzc;

    public zzvx() {
        this(new CopyOnWriteArrayList(), 0, (zzvo) null);
    }

    private zzvx(CopyOnWriteArrayList copyOnWriteArrayList, int i, zzvo zzvo) {
        this.zzc = copyOnWriteArrayList;
        this.zza = 0;
        this.zzb = zzvo;
    }

    public final zzvx zza(int i, zzvo zzvo) {
        return new zzvx(this.zzc, 0, zzvo);
    }

    public final void zzb(Handler handler, zzvy zzvy) {
        this.zzc.add(new zzvw(handler, zzvy));
    }

    public final void zzc(zzvk zzvk) {
        Iterator it = this.zzc.iterator();
        while (it.hasNext()) {
            zzvw zzvw = (zzvw) it.next();
            zzgd.zzO(zzvw.zza, new zzvr(this, zzvw.zzb, zzvk));
        }
    }

    public final void zzd(zzvf zzvf, zzvk zzvk) {
        Iterator it = this.zzc.iterator();
        while (it.hasNext()) {
            zzvw zzvw = (zzvw) it.next();
            zzgd.zzO(zzvw.zza, new zzvv(this, zzvw.zzb, zzvf, zzvk));
        }
    }

    public final void zze(zzvf zzvf, zzvk zzvk) {
        Iterator it = this.zzc.iterator();
        while (it.hasNext()) {
            zzvw zzvw = (zzvw) it.next();
            zzgd.zzO(zzvw.zza, new zzvt(this, zzvw.zzb, zzvf, zzvk));
        }
    }

    public final void zzf(zzvf zzvf, zzvk zzvk, IOException iOException, boolean z) {
        Iterator it = this.zzc.iterator();
        while (it.hasNext()) {
            zzvw zzvw = (zzvw) it.next();
            zzgd.zzO(zzvw.zza, new zzvu(this, zzvw.zzb, zzvf, zzvk, iOException, z));
        }
    }

    public final void zzg(zzvf zzvf, zzvk zzvk) {
        Iterator it = this.zzc.iterator();
        while (it.hasNext()) {
            zzvw zzvw = (zzvw) it.next();
            zzgd.zzO(zzvw.zza, new zzvs(this, zzvw.zzb, zzvf, zzvk));
        }
    }

    public final void zzh(zzvy zzvy) {
        Iterator it = this.zzc.iterator();
        while (it.hasNext()) {
            zzvw zzvw = (zzvw) it.next();
            if (zzvw.zzb == zzvy) {
                this.zzc.remove(zzvw);
            }
        }
    }
}
