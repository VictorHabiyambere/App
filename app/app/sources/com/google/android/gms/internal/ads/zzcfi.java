package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzcfi implements Iterable {
    private final List zza = new ArrayList();

    public final Iterator iterator() {
        return this.zza.iterator();
    }

    /* access modifiers changed from: package-private */
    public final zzcfh zza(zzcee zzcee) {
        Iterator it = iterator();
        while (it.hasNext()) {
            zzcfh zzcfh = (zzcfh) it.next();
            if (zzcfh.zza == zzcee) {
                return zzcfh;
            }
        }
        return null;
    }

    public final void zzb(zzcfh zzcfh) {
        this.zza.add(zzcfh);
    }

    public final void zzc(zzcfh zzcfh) {
        this.zza.remove(zzcfh);
    }

    public final boolean zzd(zzcee zzcee) {
        ArrayList<zzcfh> arrayList = new ArrayList<>();
        Iterator it = iterator();
        while (it.hasNext()) {
            zzcfh zzcfh = (zzcfh) it.next();
            if (zzcfh.zza == zzcee) {
                arrayList.add(zzcfh);
            }
        }
        if (arrayList.isEmpty()) {
            return false;
        }
        for (zzcfh zzcfh2 : arrayList) {
            zzcfh2.zzb.zzf();
        }
        return true;
    }
}
