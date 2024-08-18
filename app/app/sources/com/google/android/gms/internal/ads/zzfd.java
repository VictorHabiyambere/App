package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final /* synthetic */ class zzfd implements Runnable {
    public final /* synthetic */ CopyOnWriteArraySet zza;
    public final /* synthetic */ int zzb;
    public final /* synthetic */ zzfe zzc;

    public /* synthetic */ zzfd(CopyOnWriteArraySet copyOnWriteArraySet, int i, zzfe zzfe) {
        this.zza = copyOnWriteArraySet;
        this.zzb = i;
        this.zzc = zzfe;
    }

    public final void run() {
        Iterator it = this.zza.iterator();
        while (it.hasNext()) {
            zzfe zzfe = this.zzc;
            ((zzfg) it.next()).zza(this.zzb, zzfe);
        }
    }
}
