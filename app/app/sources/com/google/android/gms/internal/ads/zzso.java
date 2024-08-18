package com.google.android.gms.internal.ads;

import android.os.Handler;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzso {
    public final int zza;
    public final zzvo zzb;
    private final CopyOnWriteArrayList zzc;

    public zzso() {
        this(new CopyOnWriteArrayList(), 0, (zzvo) null);
    }

    private zzso(CopyOnWriteArrayList copyOnWriteArrayList, int i, zzvo zzvo) {
        this.zzc = copyOnWriteArrayList;
        this.zza = 0;
        this.zzb = zzvo;
    }

    public final zzso zza(int i, zzvo zzvo) {
        return new zzso(this.zzc, 0, zzvo);
    }

    public final void zzb(Handler handler, zzsp zzsp) {
        this.zzc.add(new zzsn(handler, zzsp));
    }

    public final void zzc(zzsp zzsp) {
        Iterator it = this.zzc.iterator();
        while (it.hasNext()) {
            zzsn zzsn = (zzsn) it.next();
            if (zzsn.zzb == zzsp) {
                this.zzc.remove(zzsn);
            }
        }
    }
}
