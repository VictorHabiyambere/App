package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.common.util.Clock;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzelf {
    /* access modifiers changed from: private */
    public final Clock zza;
    /* access modifiers changed from: private */
    public final zzelh zzb;
    /* access modifiers changed from: private */
    public final zzfoe zzc;
    /* access modifiers changed from: private */
    public final LinkedHashMap zzd = new LinkedHashMap();
    /* access modifiers changed from: private */
    public final boolean zze;
    /* access modifiers changed from: private */
    public final zzehq zzf;
    /* access modifiers changed from: private */
    public boolean zzg;
    private long zzh;
    private long zzi;

    public zzelf(Clock clock, zzelh zzelh, zzehq zzehq, zzfoe zzfoe) {
        this.zza = clock;
        this.zzb = zzelh;
        this.zze = ((Boolean) zzba.zzc().zza(zzbep.zzhb)).booleanValue();
        this.zzf = zzehq;
        this.zzc = zzfoe;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0013, code lost:
        if (r3.zzc != 8) goto L_0x0017;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0015, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0017, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized boolean zzq(com.google.android.gms.internal.ads.zzfgt r3) {
        /*
            r2 = this;
            monitor-enter(r2)
            java.util.LinkedHashMap r0 = r2.zzd     // Catch:{ all -> 0x0018 }
            java.lang.Object r3 = r0.get(r3)     // Catch:{ all -> 0x0018 }
            com.google.android.gms.internal.ads.zzele r3 = (com.google.android.gms.internal.ads.zzele) r3     // Catch:{ all -> 0x0018 }
            r0 = 0
            if (r3 != 0) goto L_0x000e
            monitor-exit(r2)
            return r0
        L_0x000e:
            int r3 = r3.zzc     // Catch:{ all -> 0x0018 }
            r1 = 8
            monitor-exit(r2)
            if (r3 != r1) goto L_0x0017
            r3 = 1
            return r3
        L_0x0017:
            return r0
        L_0x0018:
            r3 = move-exception
            monitor-exit(r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzelf.zzq(com.google.android.gms.internal.ads.zzfgt):boolean");
    }

    public final synchronized long zza() {
        return this.zzh;
    }

    /* access modifiers changed from: package-private */
    public final synchronized ListenableFuture zzf(zzfhf zzfhf, zzfgt zzfgt, ListenableFuture listenableFuture, zzfoa zzfoa) {
        zzfgt zzfgt2 = zzfgt;
        ListenableFuture listenableFuture2 = listenableFuture;
        synchronized (this) {
            zzfgw zzfgw = zzfhf.zzb.zzb;
            long elapsedRealtime = this.zza.elapsedRealtime();
            String str = zzfgt2.zzx;
            if (str != null) {
                this.zzd.put(zzfgt2, new zzele(str, zzfgt2.zzag, 9, 0, (Integer) null));
                zzgft.zzr(listenableFuture2, new zzeld(this, elapsedRealtime, zzfgw, zzfgt, str, zzfoa, zzfhf), zzcci.zzf);
            }
        }
        return listenableFuture2;
    }

    public final synchronized String zzg() {
        ArrayList arrayList;
        arrayList = new ArrayList();
        for (Map.Entry value : this.zzd.entrySet()) {
            zzele zzele = (zzele) value.getValue();
            if (zzele.zzc != Integer.MAX_VALUE) {
                arrayList.add(zzele.toString());
            }
        }
        return TextUtils.join("_", arrayList);
    }

    public final synchronized void zzi(zzfgt zzfgt) {
        this.zzh = this.zza.elapsedRealtime() - this.zzi;
        if (zzfgt != null) {
            this.zzf.zze(zzfgt);
        }
        this.zzg = true;
    }

    public final synchronized void zzj() {
        this.zzh = this.zza.elapsedRealtime() - this.zzi;
    }

    public final synchronized void zzk(List list) {
        this.zzi = this.zza.elapsedRealtime();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            zzfgt zzfgt = (zzfgt) it.next();
            if (!TextUtils.isEmpty(zzfgt.zzx)) {
                this.zzd.put(zzfgt, new zzele(zzfgt.zzx, zzfgt.zzag, Integer.MAX_VALUE, 0, (Integer) null));
            }
        }
    }

    public final synchronized void zzl() {
        this.zzi = this.zza.elapsedRealtime();
    }

    public final synchronized void zzm(zzfgt zzfgt) {
        zzele zzele = (zzele) this.zzd.get(zzfgt);
        if (zzele != null && !this.zzg) {
            zzele.zzc = 8;
        }
    }
}
