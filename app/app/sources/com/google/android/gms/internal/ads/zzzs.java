package com.google.android.gms.internal.ads;

import android.os.Handler;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzzs {
    private final CopyOnWriteArrayList zza = new CopyOnWriteArrayList();

    public final void zza(Handler handler, zzzt zzzt) {
        zzc(zzzt);
        this.zza.add(new zzzr(handler, zzzt));
    }

    public final void zzb(int i, long j, long j2) {
        Iterator it = this.zza.iterator();
        while (it.hasNext()) {
            zzzr zzzr = (zzzr) it.next();
            if (!zzzr.zzc) {
                zzzr.zza.post(new zzzq(zzzr, i, j, j2));
            }
        }
    }

    public final void zzc(zzzt zzzt) {
        Iterator it = this.zza.iterator();
        while (it.hasNext()) {
            zzzr zzzr = (zzzr) it.next();
            if (zzzr.zzb == zzzt) {
                zzzr.zzc();
                this.zza.remove(zzzr);
            }
        }
    }
}
