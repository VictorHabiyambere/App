package com.google.android.gms.internal.ads;

import android.util.Base64;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzpd implements zzph {
    public static final zzfyw zza = new zzpb();
    private static final Random zzb = new Random();
    /* access modifiers changed from: private */
    public final zzdb zzc;
    /* access modifiers changed from: private */
    public final zzcz zzd;
    private final HashMap zze;
    private final zzfyw zzf;
    private zzpg zzg;
    private zzdc zzh;
    private String zzi;
    private long zzj;

    public zzpd() {
        throw null;
    }

    public zzpd(zzfyw zzfyw) {
        this.zzf = zzfyw;
        this.zzc = new zzdb();
        this.zzd = new zzcz();
        this.zze = new HashMap();
        this.zzh = zzdc.zza;
        this.zzj = -1;
    }

    /* access modifiers changed from: private */
    public final long zzl() {
        zzpc zzpc = (zzpc) this.zze.get(this.zzi);
        return (zzpc == null || zzpc.zzd == -1) ? this.zzj + 1 : zzpc.zzd;
    }

    private final zzpc zzm(int i, zzvo zzvo) {
        int i2;
        long j = Long.MAX_VALUE;
        zzpc zzpc = null;
        for (zzpc zzpc2 : this.zze.values()) {
            zzpc2.zzg(i, zzvo);
            if (zzpc2.zzj(i, zzvo)) {
                long zzb2 = zzpc2.zzd;
                if (zzb2 == -1 || zzb2 < j) {
                    zzpc = zzpc2;
                    j = zzb2;
                } else if (i2 == 0) {
                    int i3 = zzgd.zza;
                    if (!(zzpc.zze == null || zzpc2.zze == null)) {
                        zzpc = zzpc2;
                    }
                }
            }
        }
        if (zzpc != null) {
            return zzpc;
        }
        String zzn = zzn();
        zzpc zzpc3 = new zzpc(this, zzn, i, zzvo);
        this.zze.put(zzn, zzpc3);
        return zzpc3;
    }

    /* access modifiers changed from: private */
    public static String zzn() {
        byte[] bArr = new byte[12];
        zzb.nextBytes(bArr);
        return Base64.encodeToString(bArr, 10);
    }

    private final void zzo(zzpc zzpc) {
        if (zzpc.zzd != -1) {
            this.zzj = zzpc.zzd;
        }
        this.zzi = null;
    }

    @RequiresNonNull({"listener"})
    private final void zzp(zzmy zzmy) {
        if (zzmy.zzb.zzo()) {
            String str = this.zzi;
            if (str != null) {
                zzpc zzpc = (zzpc) this.zze.get(str);
                if (zzpc != null) {
                    zzo(zzpc);
                    return;
                }
                throw null;
            }
            return;
        }
        zzpc zzpc2 = (zzpc) this.zze.get(this.zzi);
        zzpc zzm = zzm(zzmy.zzc, zzmy.zzd);
        this.zzi = zzm.zzb;
        zzi(zzmy);
        zzvo zzvo = zzmy.zzd;
        if (zzvo != null && zzvo.zzb()) {
            if (zzpc2 != null) {
                if (zzpc2.zzd == zzvo.zzd && zzpc2.zze != null && zzpc2.zze.zzb == zzmy.zzd.zzb && zzpc2.zze.zzc == zzmy.zzd.zzc) {
                    return;
                }
            }
            zzvo zzvo2 = zzmy.zzd;
            String unused = zzm(zzmy.zzc, new zzvo(zzvo2.zza, zzvo2.zzd)).zzb;
            String unused2 = zzm.zzb;
        }
    }

    public final synchronized String zze() {
        return this.zzi;
    }

    public final synchronized String zzf(zzdc zzdc, zzvo zzvo) {
        return zzm(zzdc.zzn(zzvo.zza, this.zzd).zzd, zzvo).zzb;
    }

    public final synchronized void zzg(zzmy zzmy) {
        zzpg zzpg;
        String str = this.zzi;
        if (str != null) {
            zzpc zzpc = (zzpc) this.zze.get(str);
            if (zzpc != null) {
                zzo(zzpc);
            } else {
                throw null;
            }
        }
        Iterator it = this.zze.values().iterator();
        while (it.hasNext()) {
            zzpc zzpc2 = (zzpc) it.next();
            it.remove();
            if (zzpc2.zzf && (zzpg = this.zzg) != null) {
                zzpg.zzd(zzmy, zzpc2.zzb, false);
            }
        }
    }

    public final void zzh(zzpg zzpg) {
        this.zzg = zzpg;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0039, code lost:
        if (com.google.android.gms.internal.ads.zzpc.zza(r0) == r10.zzc) goto L_0x003b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00c5, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void zzi(com.google.android.gms.internal.ads.zzmy r10) {
        /*
            r9 = this;
            monitor-enter(r9)
            com.google.android.gms.internal.ads.zzpg r0 = r9.zzg     // Catch:{ all -> 0x00c9 }
            if (r0 == 0) goto L_0x00c6
            com.google.android.gms.internal.ads.zzdc r0 = r10.zzb     // Catch:{ all -> 0x00c9 }
            boolean r0 = r0.zzo()     // Catch:{ all -> 0x00c9 }
            if (r0 == 0) goto L_0x000f
            goto L_0x00c4
        L_0x000f:
            com.google.android.gms.internal.ads.zzvo r0 = r10.zzd     // Catch:{ all -> 0x00c9 }
            if (r0 == 0) goto L_0x003b
            long r1 = r9.zzl()     // Catch:{ all -> 0x00c9 }
            long r3 = r0.zzd     // Catch:{ all -> 0x00c9 }
            int r0 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r0 < 0) goto L_0x00c4
            java.util.HashMap r0 = r9.zze     // Catch:{ all -> 0x00c9 }
            java.lang.String r1 = r9.zzi     // Catch:{ all -> 0x00c9 }
            java.lang.Object r0 = r0.get(r1)     // Catch:{ all -> 0x00c9 }
            com.google.android.gms.internal.ads.zzpc r0 = (com.google.android.gms.internal.ads.zzpc) r0     // Catch:{ all -> 0x00c9 }
            if (r0 == 0) goto L_0x003b
            long r1 = r0.zzd     // Catch:{ all -> 0x00c9 }
            r3 = -1
            int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r1 != 0) goto L_0x003b
            int r0 = r0.zzc     // Catch:{ all -> 0x00c9 }
            int r1 = r10.zzc     // Catch:{ all -> 0x00c9 }
            if (r0 != r1) goto L_0x00c4
        L_0x003b:
            int r0 = r10.zzc     // Catch:{ all -> 0x00c9 }
            com.google.android.gms.internal.ads.zzvo r1 = r10.zzd     // Catch:{ all -> 0x00c9 }
            com.google.android.gms.internal.ads.zzpc r0 = r9.zzm(r0, r1)     // Catch:{ all -> 0x00c9 }
            java.lang.String r1 = r9.zzi     // Catch:{ all -> 0x00c9 }
            if (r1 != 0) goto L_0x004d
            java.lang.String r1 = r0.zzb     // Catch:{ all -> 0x00c9 }
            r9.zzi = r1     // Catch:{ all -> 0x00c9 }
        L_0x004d:
            com.google.android.gms.internal.ads.zzvo r1 = r10.zzd     // Catch:{ all -> 0x00c9 }
            r2 = 1
            if (r1 == 0) goto L_0x0097
            boolean r3 = r1.zzb()     // Catch:{ all -> 0x00c9 }
            if (r3 == 0) goto L_0x0097
            java.lang.Object r3 = r1.zza     // Catch:{ all -> 0x00c9 }
            long r4 = r1.zzd     // Catch:{ all -> 0x00c9 }
            int r1 = r1.zzb     // Catch:{ all -> 0x00c9 }
            com.google.android.gms.internal.ads.zzvo r6 = new com.google.android.gms.internal.ads.zzvo     // Catch:{ all -> 0x00c9 }
            r6.<init>(r3, r4, r1)     // Catch:{ all -> 0x00c9 }
            int r1 = r10.zzc     // Catch:{ all -> 0x00c9 }
            com.google.android.gms.internal.ads.zzpc r1 = r9.zzm(r1, r6)     // Catch:{ all -> 0x00c9 }
            boolean r3 = r1.zzf     // Catch:{ all -> 0x00c9 }
            if (r3 != 0) goto L_0x0097
            r1.zzf = true     // Catch:{ all -> 0x00c9 }
            com.google.android.gms.internal.ads.zzdc r3 = r10.zzb     // Catch:{ all -> 0x00c9 }
            com.google.android.gms.internal.ads.zzvo r4 = r10.zzd     // Catch:{ all -> 0x00c9 }
            com.google.android.gms.internal.ads.zzcz r5 = r9.zzd     // Catch:{ all -> 0x00c9 }
            java.lang.Object r4 = r4.zza     // Catch:{ all -> 0x00c9 }
            r3.zzn(r4, r5)     // Catch:{ all -> 0x00c9 }
            com.google.android.gms.internal.ads.zzcz r3 = r9.zzd     // Catch:{ all -> 0x00c9 }
            com.google.android.gms.internal.ads.zzvo r4 = r10.zzd     // Catch:{ all -> 0x00c9 }
            int r4 = r4.zzb     // Catch:{ all -> 0x00c9 }
            r3.zzi(r4)     // Catch:{ all -> 0x00c9 }
            r3 = 0
            long r5 = com.google.android.gms.internal.ads.zzgd.zzu(r3)     // Catch:{ all -> 0x00c9 }
            long r7 = com.google.android.gms.internal.ads.zzgd.zzu(r3)     // Catch:{ all -> 0x00c9 }
            long r5 = r5 + r7
            java.lang.Math.max(r3, r5)     // Catch:{ all -> 0x00c9 }
            java.lang.String unused = r1.zzb     // Catch:{ all -> 0x00c9 }
        L_0x0097:
            boolean r1 = r0.zzf     // Catch:{ all -> 0x00c9 }
            if (r1 != 0) goto L_0x00a3
            r0.zzf = true     // Catch:{ all -> 0x00c9 }
            java.lang.String unused = r0.zzb     // Catch:{ all -> 0x00c9 }
        L_0x00a3:
            java.lang.String r1 = r0.zzb     // Catch:{ all -> 0x00c9 }
            java.lang.String r3 = r9.zzi     // Catch:{ all -> 0x00c9 }
            boolean r1 = r1.equals(r3)     // Catch:{ all -> 0x00c9 }
            if (r1 == 0) goto L_0x00c4
            boolean r1 = r0.zzg     // Catch:{ all -> 0x00c9 }
            if (r1 != 0) goto L_0x00c4
            r0.zzg = true     // Catch:{ all -> 0x00c9 }
            com.google.android.gms.internal.ads.zzpg r1 = r9.zzg     // Catch:{ all -> 0x00c9 }
            java.lang.String r0 = r0.zzb     // Catch:{ all -> 0x00c9 }
            r1.zzc(r10, r0)     // Catch:{ all -> 0x00c9 }
            monitor-exit(r9)
            return
        L_0x00c4:
            monitor-exit(r9)
            return
        L_0x00c6:
            r10 = 0
            throw r10     // Catch:{ all -> 0x00c9 }
        L_0x00c9:
            r10 = move-exception
            monitor-exit(r9)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzpd.zzi(com.google.android.gms.internal.ads.zzmy):void");
    }

    public final synchronized void zzj(zzmy zzmy, int i) {
        if (this.zzg != null) {
            Iterator it = this.zze.values().iterator();
            while (it.hasNext()) {
                zzpc zzpc = (zzpc) it.next();
                if (zzpc.zzk(zzmy)) {
                    it.remove();
                    if (zzpc.zzf) {
                        boolean equals = zzpc.zzb.equals(this.zzi);
                        boolean z = false;
                        if (i == 0 && equals && zzpc.zzg) {
                            z = true;
                        }
                        if (equals) {
                            zzo(zzpc);
                        }
                        this.zzg.zzd(zzmy, zzpc.zzb, z);
                    }
                }
            }
            zzp(zzmy);
        } else {
            throw null;
        }
    }

    public final synchronized void zzk(zzmy zzmy) {
        if (this.zzg != null) {
            zzdc zzdc = this.zzh;
            this.zzh = zzmy.zzb;
            Iterator it = this.zze.values().iterator();
            while (it.hasNext()) {
                zzpc zzpc = (zzpc) it.next();
                if (!zzpc.zzl(zzdc, this.zzh) || zzpc.zzk(zzmy)) {
                    it.remove();
                    if (zzpc.zzf) {
                        if (zzpc.zzb.equals(this.zzi)) {
                            zzo(zzpc);
                        }
                        this.zzg.zzd(zzmy, zzpc.zzb, false);
                    }
                }
            }
            zzp(zzmy);
        } else {
            throw null;
        }
    }
}
