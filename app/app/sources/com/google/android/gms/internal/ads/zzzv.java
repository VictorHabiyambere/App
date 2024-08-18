package com.google.android.gms.internal.ads;

import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzzv {
    private int zza;
    private int zzb;
    private int zzc = 0;
    private zzzo[] zzd = new zzzo[100];

    public zzzv(boolean z, int i) {
    }

    public final synchronized int zza() {
        return this.zzb * 65536;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x002d, code lost:
        return r2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized com.google.android.gms.internal.ads.zzzo zzb() {
        /*
            r4 = this;
            monitor-enter(r4)
            int r0 = r4.zzb     // Catch:{ all -> 0x0039 }
            int r0 = r0 + 1
            r4.zzb = r0     // Catch:{ all -> 0x0039 }
            int r0 = r4.zzc     // Catch:{ all -> 0x0039 }
            if (r0 <= 0) goto L_0x001b
            com.google.android.gms.internal.ads.zzzo[] r1 = r4.zzd     // Catch:{ all -> 0x0039 }
            int r0 = r0 + -1
            r4.zzc = r0     // Catch:{ all -> 0x0039 }
            r2 = r1[r0]     // Catch:{ all -> 0x0039 }
            r3 = 0
            if (r2 == 0) goto L_0x0019
            r1[r0] = r3     // Catch:{ all -> 0x0039 }
            goto L_0x002c
        L_0x0019:
            throw r3     // Catch:{ all -> 0x0039 }
        L_0x001b:
            com.google.android.gms.internal.ads.zzzo r2 = new com.google.android.gms.internal.ads.zzzo     // Catch:{ all -> 0x0039 }
            r0 = 65536(0x10000, float:9.18355E-41)
            byte[] r0 = new byte[r0]     // Catch:{ all -> 0x0039 }
            r1 = 0
            r2.<init>(r0, r1)     // Catch:{ all -> 0x0039 }
            int r0 = r4.zzb     // Catch:{ all -> 0x0039 }
            com.google.android.gms.internal.ads.zzzo[] r1 = r4.zzd     // Catch:{ all -> 0x0039 }
            int r3 = r1.length     // Catch:{ all -> 0x0039 }
            if (r0 > r3) goto L_0x002e
        L_0x002c:
            monitor-exit(r4)
            return r2
        L_0x002e:
            int r3 = r3 + r3
            java.lang.Object[] r0 = java.util.Arrays.copyOf(r1, r3)     // Catch:{ all -> 0x0039 }
            com.google.android.gms.internal.ads.zzzo[] r0 = (com.google.android.gms.internal.ads.zzzo[]) r0     // Catch:{ all -> 0x0039 }
            r4.zzd = r0     // Catch:{ all -> 0x0039 }
            monitor-exit(r4)
            return r2
        L_0x0039:
            r0 = move-exception
            monitor-exit(r4)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzzv.zzb():com.google.android.gms.internal.ads.zzzo");
    }

    public final synchronized void zzc(zzzo zzzo) {
        zzzo[] zzzoArr = this.zzd;
        int i = this.zzc;
        this.zzc = i + 1;
        zzzoArr[i] = zzzo;
        this.zzb--;
        notifyAll();
    }

    public final synchronized void zzd(zzzp zzzp) {
        while (zzzp != null) {
            zzzo[] zzzoArr = this.zzd;
            int i = this.zzc;
            this.zzc = i + 1;
            zzzoArr[i] = zzzp.zzc();
            this.zzb--;
            zzzp = zzzp.zzd();
        }
        notifyAll();
    }

    public final synchronized void zze() {
        zzf(0);
    }

    public final synchronized void zzf(int i) {
        int i2 = this.zza;
        this.zza = i;
        if (i < i2) {
            zzg();
        }
    }

    public final synchronized void zzg() {
        int i = this.zza;
        int i2 = zzgd.zza;
        int max = Math.max(0, ((i + 65535) / 65536) - this.zzb);
        int i3 = this.zzc;
        if (max < i3) {
            Arrays.fill(this.zzd, max, i3, (Object) null);
            this.zzc = max;
        }
    }
}
