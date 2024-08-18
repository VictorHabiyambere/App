package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
final class zzekq {
    private final Map zza = new HashMap();
    private final List zzb = new ArrayList();
    private final zzggm zzc;
    private final List zzd = new ArrayList();
    private final Set zze = new HashSet();
    private zzelg zzf;
    private int zzg = Integer.MAX_VALUE;
    private final String zzh;
    private final int zzi;
    private final zzelf zzj;
    private zzfgt zzk;
    private boolean zzl;

    zzekq(zzfhf zzfhf, zzelf zzelf, zzggm zzggm) {
        this.zzl = false;
        this.zzi = zzfhf.zzb.zzb.zzq;
        this.zzj = zzelf;
        this.zzc = zzggm;
        this.zzh = zzelm.zzc(zzfhf);
        List list = zzfhf.zzb.zza;
        for (int i = 0; i < list.size(); i++) {
            this.zza.put((zzfgt) list.get(i), Integer.valueOf(i));
        }
        this.zzb.addAll(list);
    }

    private final synchronized void zze() {
        this.zzj.zzi(this.zzk);
        zzelg zzelg = this.zzf;
        if (zzelg != null) {
            this.zzc.zzc(zzelg);
        } else {
            this.zzc.zzd(new zzelj(3, this.zzh));
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0049, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final synchronized boolean zzf(boolean r5) {
        /*
            r4 = this;
            monitor-enter(r4)
            java.util.List r0 = r4.zzb     // Catch:{ all -> 0x004b }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ all -> 0x004b }
        L_0x0007:
            boolean r1 = r0.hasNext()     // Catch:{ all -> 0x004b }
            if (r1 == 0) goto L_0x0048
            java.lang.Object r1 = r0.next()     // Catch:{ all -> 0x004b }
            com.google.android.gms.internal.ads.zzfgt r1 = (com.google.android.gms.internal.ads.zzfgt) r1     // Catch:{ all -> 0x004b }
            java.util.Map r2 = r4.zza     // Catch:{ all -> 0x004b }
            java.lang.Object r2 = r2.get(r1)     // Catch:{ all -> 0x004b }
            java.lang.Integer r2 = (java.lang.Integer) r2     // Catch:{ all -> 0x004b }
            if (r2 == 0) goto L_0x0022
            int r2 = r2.intValue()     // Catch:{ all -> 0x004b }
            goto L_0x0025
        L_0x0022:
            r2 = 2147483647(0x7fffffff, float:NaN)
        L_0x0025:
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ all -> 0x004b }
            if (r5 != 0) goto L_0x0035
            java.util.Set r3 = r4.zze     // Catch:{ all -> 0x004b }
            java.lang.String r1 = r1.zzau     // Catch:{ all -> 0x004b }
            boolean r1 = r3.contains(r1)     // Catch:{ all -> 0x004b }
            if (r1 != 0) goto L_0x0007
        L_0x0035:
            int r1 = r2.intValue()     // Catch:{ all -> 0x004b }
            int r3 = r4.zzg     // Catch:{ all -> 0x004b }
            if (r1 >= r3) goto L_0x0040
            monitor-exit(r4)
            r5 = 1
            return r5
        L_0x0040:
            int r1 = r2.intValue()     // Catch:{ all -> 0x004b }
            int r2 = r4.zzg     // Catch:{ all -> 0x004b }
            if (r1 <= r2) goto L_0x0007
        L_0x0048:
            monitor-exit(r4)
            r5 = 0
            return r5
        L_0x004b:
            r5 = move-exception
            monitor-exit(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzekq.zzf(boolean):boolean");
    }

    private final synchronized boolean zzg() {
        int i;
        for (zzfgt zzfgt : this.zzd) {
            Integer num = (Integer) this.zza.get(zzfgt);
            if (num != null) {
                i = num.intValue();
            } else {
                i = Integer.MAX_VALUE;
            }
            if (Integer.valueOf(i).intValue() < this.zzg) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0013, code lost:
        return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final synchronized boolean zzh() {
        /*
            r2 = this;
            monitor-enter(r2)
            r0 = 1
            boolean r1 = r2.zzf(r0)     // Catch:{ all -> 0x0014 }
            if (r1 != 0) goto L_0x0012
            boolean r1 = r2.zzg()     // Catch:{ all -> 0x0014 }
            if (r1 == 0) goto L_0x000f
            goto L_0x0012
        L_0x000f:
            monitor-exit(r2)
            r0 = 0
            return r0
        L_0x0012:
            monitor-exit(r2)
            return r0
        L_0x0014:
            r0 = move-exception
            monitor-exit(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzekq.zzh():boolean");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0026, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final synchronized boolean zzi() {
        /*
            r3 = this;
            monitor-enter(r3)
            boolean r0 = r3.zzl     // Catch:{ all -> 0x0040 }
            r1 = 0
            if (r0 == 0) goto L_0x0008
            monitor-exit(r3)
            return r1
        L_0x0008:
            java.util.List r0 = r3.zzb     // Catch:{ all -> 0x0040 }
            boolean r0 = r0.isEmpty()     // Catch:{ all -> 0x0040 }
            if (r0 != 0) goto L_0x0027
            java.util.List r0 = r3.zzb     // Catch:{ all -> 0x0040 }
            java.lang.Object r0 = r0.get(r1)     // Catch:{ all -> 0x0040 }
            com.google.android.gms.internal.ads.zzfgt r0 = (com.google.android.gms.internal.ads.zzfgt) r0     // Catch:{ all -> 0x0040 }
            boolean r0 = r0.zzaw     // Catch:{ all -> 0x0040 }
            if (r0 == 0) goto L_0x0027
            java.util.List r0 = r3.zzd     // Catch:{ all -> 0x0040 }
            boolean r0 = r0.isEmpty()     // Catch:{ all -> 0x0040 }
            if (r0 == 0) goto L_0x0025
            goto L_0x0027
        L_0x0025:
            monitor-exit(r3)
            return r1
        L_0x0027:
            boolean r0 = r3.zzd()     // Catch:{ all -> 0x0040 }
            if (r0 != 0) goto L_0x0025
            java.util.List r0 = r3.zzd     // Catch:{ all -> 0x0040 }
            int r2 = r3.zzi     // Catch:{ all -> 0x0040 }
            int r0 = r0.size()     // Catch:{ all -> 0x0040 }
            if (r0 >= r2) goto L_0x0025
            boolean r0 = r3.zzf(r1)     // Catch:{ all -> 0x0040 }
            if (r0 == 0) goto L_0x0025
            monitor-exit(r3)
            r0 = 1
            return r0
        L_0x0040:
            r0 = move-exception
            monitor-exit(r3)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzekq.zzi():boolean");
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0047, code lost:
        return null;
     */
    @javax.annotation.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized com.google.android.gms.internal.ads.zzfgt zza() {
        /*
            r4 = this;
            monitor-enter(r4)
            boolean r0 = r4.zzi()     // Catch:{ all -> 0x0049 }
            if (r0 == 0) goto L_0x0046
            r0 = 0
        L_0x0008:
            java.util.List r1 = r4.zzb     // Catch:{ all -> 0x0049 }
            int r1 = r1.size()     // Catch:{ all -> 0x0049 }
            if (r0 >= r1) goto L_0x0046
            java.util.List r1 = r4.zzb     // Catch:{ all -> 0x0049 }
            java.lang.Object r1 = r1.get(r0)     // Catch:{ all -> 0x0049 }
            com.google.android.gms.internal.ads.zzfgt r1 = (com.google.android.gms.internal.ads.zzfgt) r1     // Catch:{ all -> 0x0049 }
            java.lang.String r2 = r1.zzau     // Catch:{ all -> 0x0049 }
            java.util.Set r3 = r4.zze     // Catch:{ all -> 0x0049 }
            boolean r3 = r3.contains(r2)     // Catch:{ all -> 0x0049 }
            if (r3 == 0) goto L_0x0025
            int r0 = r0 + 1
            goto L_0x0008
        L_0x0025:
            boolean r3 = r1.zzaw     // Catch:{ all -> 0x0049 }
            if (r3 == 0) goto L_0x002c
            r3 = 1
            r4.zzl = r3     // Catch:{ all -> 0x0049 }
        L_0x002c:
            boolean r3 = android.text.TextUtils.isEmpty(r2)     // Catch:{ all -> 0x0049 }
            if (r3 != 0) goto L_0x0037
            java.util.Set r3 = r4.zze     // Catch:{ all -> 0x0049 }
            r3.add(r2)     // Catch:{ all -> 0x0049 }
        L_0x0037:
            java.util.List r2 = r4.zzd     // Catch:{ all -> 0x0049 }
            r2.add(r1)     // Catch:{ all -> 0x0049 }
            java.util.List r1 = r4.zzb     // Catch:{ all -> 0x0049 }
            java.lang.Object r0 = r1.remove(r0)     // Catch:{ all -> 0x0049 }
            com.google.android.gms.internal.ads.zzfgt r0 = (com.google.android.gms.internal.ads.zzfgt) r0     // Catch:{ all -> 0x0049 }
            monitor-exit(r4)
            return r0
        L_0x0046:
            monitor-exit(r4)
            r0 = 0
            return r0
        L_0x0049:
            r0 = move-exception
            monitor-exit(r4)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzekq.zza():com.google.android.gms.internal.ads.zzfgt");
    }

    /* access modifiers changed from: package-private */
    public final synchronized void zzb(Throwable th, zzfgt zzfgt) {
        this.zzl = false;
        this.zzd.remove(zzfgt);
        this.zze.remove(zzfgt.zzau);
        if (!zzd() && !zzh()) {
            zze();
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0058, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void zzc(com.google.android.gms.internal.ads.zzelg r4, com.google.android.gms.internal.ads.zzfgt r5) {
        /*
            r3 = this;
            monitor-enter(r3)
            r0 = 0
            r3.zzl = r0     // Catch:{ all -> 0x0059 }
            java.util.List r0 = r3.zzd     // Catch:{ all -> 0x0059 }
            r0.remove(r5)     // Catch:{ all -> 0x0059 }
            boolean r0 = r3.zzd()     // Catch:{ all -> 0x0059 }
            if (r0 == 0) goto L_0x0014
            r4.zzq()     // Catch:{ all -> 0x0059 }
            monitor-exit(r3)
            return
        L_0x0014:
            java.util.Map r0 = r3.zza     // Catch:{ all -> 0x0059 }
            java.lang.Object r0 = r0.get(r5)     // Catch:{ all -> 0x0059 }
            java.lang.Integer r0 = (java.lang.Integer) r0     // Catch:{ all -> 0x0059 }
            if (r0 == 0) goto L_0x0023
            int r0 = r0.intValue()     // Catch:{ all -> 0x0059 }
            goto L_0x0026
        L_0x0023:
            r0 = 2147483647(0x7fffffff, float:NaN)
        L_0x0026:
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{ all -> 0x0059 }
            int r1 = r0.intValue()     // Catch:{ all -> 0x0059 }
            int r2 = r3.zzg     // Catch:{ all -> 0x0059 }
            if (r1 <= r2) goto L_0x0039
            com.google.android.gms.internal.ads.zzelf r4 = r3.zzj     // Catch:{ all -> 0x0059 }
            r4.zzm(r5)     // Catch:{ all -> 0x0059 }
            monitor-exit(r3)
            return
        L_0x0039:
            com.google.android.gms.internal.ads.zzelg r1 = r3.zzf     // Catch:{ all -> 0x0059 }
            if (r1 == 0) goto L_0x0044
            com.google.android.gms.internal.ads.zzelf r1 = r3.zzj     // Catch:{ all -> 0x0059 }
            com.google.android.gms.internal.ads.zzfgt r2 = r3.zzk     // Catch:{ all -> 0x0059 }
            r1.zzm(r2)     // Catch:{ all -> 0x0059 }
        L_0x0044:
            int r0 = r0.intValue()     // Catch:{ all -> 0x0059 }
            r3.zzg = r0     // Catch:{ all -> 0x0059 }
            r3.zzf = r4     // Catch:{ all -> 0x0059 }
            r3.zzk = r5     // Catch:{ all -> 0x0059 }
            boolean r4 = r3.zzh()     // Catch:{ all -> 0x0059 }
            if (r4 != 0) goto L_0x0057
            r3.zze()     // Catch:{ all -> 0x0059 }
        L_0x0057:
            monitor-exit(r3)
            return
        L_0x0059:
            r4 = move-exception
            monitor-exit(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzekq.zzc(com.google.android.gms.internal.ads.zzelg, com.google.android.gms.internal.ads.zzfgt):void");
    }

    /* access modifiers changed from: package-private */
    public final synchronized boolean zzd() {
        return this.zzc.isDone();
    }
}
