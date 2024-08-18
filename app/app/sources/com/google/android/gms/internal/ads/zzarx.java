package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
final class zzarx {
    long zza;
    final String zzb;
    final String zzc;
    final long zzd;
    final long zze;
    final long zzf;
    final long zzg;
    final List zzh;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    zzarx(java.lang.String r14, com.google.android.gms.internal.ads.zzaqn r15) {
        /*
            r13 = this;
            java.lang.String r2 = r15.zzb
            long r3 = r15.zzc
            long r5 = r15.zzd
            long r7 = r15.zze
            long r9 = r15.zzf
            java.util.List r0 = r15.zzh
            if (r0 == 0) goto L_0x0010
            r11 = r0
            goto L_0x0045
        L_0x0010:
            java.util.Map r15 = r15.zzg
            java.util.ArrayList r0 = new java.util.ArrayList
            int r1 = r15.size()
            r0.<init>(r1)
            java.util.Set r15 = r15.entrySet()
            java.util.Iterator r15 = r15.iterator()
        L_0x0023:
            boolean r1 = r15.hasNext()
            if (r1 == 0) goto L_0x0044
            java.lang.Object r1 = r15.next()
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            com.google.android.gms.internal.ads.zzaqw r11 = new com.google.android.gms.internal.ads.zzaqw
            java.lang.Object r12 = r1.getKey()
            java.lang.String r12 = (java.lang.String) r12
            java.lang.Object r1 = r1.getValue()
            java.lang.String r1 = (java.lang.String) r1
            r11.<init>(r12, r1)
            r0.add(r11)
            goto L_0x0023
        L_0x0044:
            r11 = r0
        L_0x0045:
            r0 = r13
            r1 = r14
            r0.<init>(r1, r2, r3, r5, r7, r9, r11)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzarx.<init>(java.lang.String, com.google.android.gms.internal.ads.zzaqn):void");
    }

    static zzarx zza(zzary zzary) throws IOException {
        if (zzasa.zze(zzary) == 538247942) {
            String zzh2 = zzasa.zzh(zzary);
            String zzh3 = zzasa.zzh(zzary);
            long zzf2 = zzasa.zzf(zzary);
            long zzf3 = zzasa.zzf(zzary);
            long zzf4 = zzasa.zzf(zzary);
            long zzf5 = zzasa.zzf(zzary);
            int zze2 = zzasa.zze(zzary);
            if (zze2 >= 0) {
                List emptyList = zze2 == 0 ? Collections.emptyList() : new ArrayList();
                for (int i = 0; i < zze2; i++) {
                    emptyList.add(new zzaqw(zzasa.zzh(zzary).intern(), zzasa.zzh(zzary).intern()));
                }
                return new zzarx(zzh2, zzh3, zzf2, zzf3, zzf4, zzf5, emptyList);
            }
            throw new IOException("readHeaderList size=" + zze2);
        }
        throw new IOException();
    }

    private zzarx(String str, String str2, long j, long j2, long j3, long j4, List list) {
        this.zzb = str;
        this.zzc = true == "".equals(str2) ? null : str2;
        this.zzd = j;
        this.zze = j2;
        this.zzf = j3;
        this.zzg = j4;
        this.zzh = list;
    }
}
