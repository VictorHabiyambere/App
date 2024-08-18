package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.IdentityHashMap;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
final class zzwd implements zzvm, zzvl {
    private final zzvm[] zza;
    private final IdentityHashMap zzb = new IdentityHashMap();
    private final ArrayList zzc = new ArrayList();
    private final HashMap zzd = new HashMap();
    private zzvl zze;
    private zzxr zzf;
    private zzvm[] zzg;
    private zzxh zzh = new zzuy(zzgbc.zzm(), zzgbc.zzm());
    private final zzuz zzi;

    public zzwd(zzuz zzuz, long[] jArr, zzvm... zzvmArr) {
        this.zzi = zzuz;
        this.zza = zzvmArr;
        this.zzg = new zzvm[0];
        for (int i = 0; i < zzvmArr.length; i++) {
            long j = jArr[i];
            if (j != 0) {
                this.zza[i] = new zzxn(zzvmArr[i], j);
            }
        }
    }

    public final long zza(long j, zzmr zzmr) {
        zzvm[] zzvmArr = this.zzg;
        return (zzvmArr.length > 0 ? zzvmArr[0] : this.zza[0]).zza(j, zzmr);
    }

    public final long zzb() {
        return this.zzh.zzb();
    }

    public final long zzc() {
        return this.zzh.zzc();
    }

    public final long zzd() {
        long j = -9223372036854775807L;
        for (zzvm zzvm : this.zzg) {
            long zzd2 = zzvm.zzd();
            if (zzd2 != -9223372036854775807L) {
                if (j == -9223372036854775807L) {
                    zzvm[] zzvmArr = this.zzg;
                    int length = zzvmArr.length;
                    int i = 0;
                    while (i < length) {
                        zzvm zzvm2 = zzvmArr[i];
                        if (zzvm2 == zzvm) {
                            break;
                        } else if (zzvm2.zze(zzd2) == zzd2) {
                            i++;
                        } else {
                            throw new IllegalStateException("Unexpected child seekToUs result.");
                        }
                    }
                    j = zzd2;
                } else if (zzd2 != j) {
                    throw new IllegalStateException("Conflicting discontinuities.");
                }
            } else if (!(j == -9223372036854775807L || zzvm.zze(j) == j)) {
                throw new IllegalStateException("Unexpected child seekToUs result.");
            }
        }
        return j;
    }

    public final long zze(long j) {
        long zze2 = this.zzg[0].zze(j);
        int i = 1;
        while (true) {
            zzvm[] zzvmArr = this.zzg;
            if (i >= zzvmArr.length) {
                return zze2;
            }
            if (zzvmArr[i].zze(zze2) == zze2) {
                i++;
            } else {
                throw new IllegalStateException("Unexpected child seekToUs result.");
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v7, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v9, resolved type: java.lang.Integer} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final long zzf(com.google.android.gms.internal.ads.zzzg[] r22, boolean[] r23, com.google.android.gms.internal.ads.zzxf[] r24, boolean[] r25, long r26) {
        /*
            r21 = this;
            r0 = r21
            r1 = r22
            r2 = r24
            int r3 = r1.length
            int[] r4 = new int[r3]
            int[] r3 = new int[r3]
            r5 = 0
            r6 = r5
        L_0x000d:
            int r7 = r1.length
            r8 = 0
            if (r6 >= r7) goto L_0x004b
            r7 = r2[r6]
            if (r7 != 0) goto L_0x0016
            goto L_0x001f
        L_0x0016:
            java.util.IdentityHashMap r8 = r0.zzb
            java.lang.Object r7 = r8.get(r7)
            r8 = r7
            java.lang.Integer r8 = (java.lang.Integer) r8
        L_0x001f:
            r7 = -1
            if (r8 != 0) goto L_0x0024
            r8 = r7
            goto L_0x0028
        L_0x0024:
            int r8 = r8.intValue()
        L_0x0028:
            r4[r6] = r8
            r8 = r1[r6]
            if (r8 == 0) goto L_0x0045
            com.google.android.gms.internal.ads.zzde r7 = r8.zze()
            java.lang.String r7 = r7.zzc
            java.lang.String r8 = ":"
            int r8 = r7.indexOf(r8)
            java.lang.String r7 = r7.substring(r5, r8)
            int r7 = java.lang.Integer.parseInt(r7)
            r3[r6] = r7
            goto L_0x0048
        L_0x0045:
            r3[r6] = r7
        L_0x0048:
            int r6 = r6 + 1
            goto L_0x000d
        L_0x004b:
            java.util.IdentityHashMap r6 = r0.zzb
            r6.clear()
            com.google.android.gms.internal.ads.zzvm[] r6 = r0.zza
            com.google.android.gms.internal.ads.zzxf[] r9 = new com.google.android.gms.internal.ads.zzxf[r7]
            com.google.android.gms.internal.ads.zzxf[] r15 = new com.google.android.gms.internal.ads.zzxf[r7]
            com.google.android.gms.internal.ads.zzzg[] r14 = new com.google.android.gms.internal.ads.zzzg[r7]
            java.util.ArrayList r13 = new java.util.ArrayList
            int r6 = r6.length
            r13.<init>(r6)
            r17 = r26
            r6 = r5
        L_0x0061:
            com.google.android.gms.internal.ads.zzvm[] r10 = r0.zza
            int r10 = r10.length
            if (r6 >= r10) goto L_0x0103
            r10 = r5
        L_0x0067:
            int r11 = r1.length
            if (r10 >= r11) goto L_0x009d
            r11 = r4[r10]
            if (r11 != r6) goto L_0x0071
            r11 = r2[r10]
            goto L_0x0072
        L_0x0071:
            r11 = r8
        L_0x0072:
            r15[r10] = r11
            r11 = r3[r10]
            if (r11 != r6) goto L_0x0096
            r11 = r1[r10]
            if (r11 == 0) goto L_0x0094
            java.util.HashMap r12 = r0.zzd
            com.google.android.gms.internal.ads.zzde r5 = r11.zze()
            java.lang.Object r5 = r12.get(r5)
            com.google.android.gms.internal.ads.zzde r5 = (com.google.android.gms.internal.ads.zzde) r5
            if (r5 == 0) goto L_0x0092
            com.google.android.gms.internal.ads.zzwc r12 = new com.google.android.gms.internal.ads.zzwc
            r12.<init>(r11, r5)
            r14[r10] = r12
            goto L_0x0099
        L_0x0092:
            throw r8
        L_0x0094:
            throw r8
        L_0x0096:
            r14[r10] = r8
        L_0x0099:
            int r10 = r10 + 1
            r5 = 0
            goto L_0x0067
        L_0x009d:
            com.google.android.gms.internal.ads.zzvm[] r5 = r0.zza
            r10 = r5[r6]
            r11 = r14
            r12 = r23
            r5 = r13
            r13 = r15
            r19 = r14
            r14 = r25
            r20 = r15
            r15 = r17
            long r10 = r10.zzf(r11, r12, r13, r14, r15)
            if (r6 != 0) goto L_0x00b7
            r17 = r10
            goto L_0x00bb
        L_0x00b7:
            int r10 = (r10 > r17 ? 1 : (r10 == r17 ? 0 : -1))
            if (r10 != 0) goto L_0x00fb
        L_0x00bb:
            r10 = 0
            r11 = 0
        L_0x00bd:
            int r12 = r1.length
            if (r10 >= r12) goto L_0x00e8
            r12 = r3[r10]
            r13 = 1
            if (r12 != r6) goto L_0x00d8
            r11 = r20[r10]
            if (r11 == 0) goto L_0x00d6
            r9[r10] = r11
            java.util.IdentityHashMap r12 = r0.zzb
            java.lang.Integer r14 = java.lang.Integer.valueOf(r6)
            r12.put(r11, r14)
            r11 = r13
            goto L_0x00e5
        L_0x00d6:
            throw r8
        L_0x00d8:
            r12 = r4[r10]
            if (r12 != r6) goto L_0x00e5
            r12 = r20[r10]
            if (r12 != 0) goto L_0x00e1
            goto L_0x00e2
        L_0x00e1:
            r13 = 0
        L_0x00e2:
            com.google.android.gms.internal.ads.zzeq.zzf(r13)
        L_0x00e5:
            int r10 = r10 + 1
            goto L_0x00bd
        L_0x00e8:
            if (r11 == 0) goto L_0x00f1
            com.google.android.gms.internal.ads.zzvm[] r10 = r0.zza
            r10 = r10[r6]
            r5.add(r10)
        L_0x00f1:
            int r6 = r6 + 1
            r13 = r5
            r14 = r19
            r15 = r20
            r5 = 0
            goto L_0x0061
        L_0x00fb:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "Children enabled at different positions."
            r1.<init>(r2)
            throw r1
        L_0x0103:
            r5 = r13
            r1 = 0
            java.lang.System.arraycopy(r9, r1, r2, r1, r7)
            com.google.android.gms.internal.ads.zzvm[] r1 = new com.google.android.gms.internal.ads.zzvm[r1]
            java.lang.Object[] r1 = r5.toArray(r1)
            com.google.android.gms.internal.ads.zzvm[] r1 = (com.google.android.gms.internal.ads.zzvm[]) r1
            r0.zzg = r1
            com.google.android.gms.internal.ads.zzwb r1 = new com.google.android.gms.internal.ads.zzwb
            r1.<init>()
            java.util.List r1 = com.google.android.gms.internal.ads.zzgbs.zzb(r5, r1)
            com.google.android.gms.internal.ads.zzuy r2 = new com.google.android.gms.internal.ads.zzuy
            r2.<init>(r5, r1)
            r0.zzh = r2
            return r17
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzwd.zzf(com.google.android.gms.internal.ads.zzzg[], boolean[], com.google.android.gms.internal.ads.zzxf[], boolean[], long):long");
    }

    public final /* bridge */ /* synthetic */ void zzg(zzxh zzxh) {
        zzvm zzvm = (zzvm) zzxh;
        zzvl zzvl = this.zze;
        if (zzvl != null) {
            zzvl.zzg(this);
            return;
        }
        throw null;
    }

    public final zzxr zzh() {
        zzxr zzxr = this.zzf;
        if (zzxr != null) {
            return zzxr;
        }
        throw null;
    }

    public final void zzi(zzvm zzvm) {
        this.zzc.remove(zzvm);
        if (this.zzc.isEmpty()) {
            zzvm[] zzvmArr = this.zza;
            int i = 0;
            for (zzvm zzh2 : zzvmArr) {
                i += zzh2.zzh().zzc;
            }
            zzde[] zzdeArr = new zzde[i];
            int i2 = 0;
            int i3 = 0;
            while (true) {
                zzvm[] zzvmArr2 = this.zza;
                if (i2 >= zzvmArr2.length) {
                    break;
                }
                zzxr zzh3 = zzvmArr2[i2].zzh();
                int i4 = zzh3.zzc;
                int i5 = 0;
                while (i5 < i4) {
                    zzde zzb2 = zzh3.zzb(i5);
                    zzan[] zzanArr = new zzan[zzb2.zzb];
                    for (int i6 = 0; i6 < zzb2.zzb; i6++) {
                        zzan zzb3 = zzb2.zzb(i6);
                        zzal zzb4 = zzb3.zzb();
                        String str = zzb3.zzb;
                        if (str == null) {
                            str = "";
                        }
                        zzb4.zzK(i2 + ":" + str);
                        zzanArr[i6] = zzb4.zzad();
                    }
                    zzde zzde = new zzde(i2 + ":" + zzb2.zzc, zzanArr);
                    this.zzd.put(zzde, zzb2);
                    zzdeArr[i3] = zzde;
                    i5++;
                    i3++;
                }
                i2++;
            }
            this.zzf = new zzxr(zzdeArr);
            zzvl zzvl = this.zze;
            if (zzvl != null) {
                zzvl.zzi(this);
                return;
            }
            throw null;
        }
    }

    public final void zzj(long j, boolean z) {
        for (zzvm zzj : this.zzg) {
            zzj.zzj(j, false);
        }
    }

    public final void zzk() throws IOException {
        int i = 0;
        while (true) {
            zzvm[] zzvmArr = this.zza;
            if (i < zzvmArr.length) {
                zzvmArr[i].zzk();
                i++;
            } else {
                return;
            }
        }
    }

    public final void zzl(zzvl zzvl, long j) {
        this.zze = zzvl;
        Collections.addAll(this.zzc, this.zza);
        int i = 0;
        while (true) {
            zzvm[] zzvmArr = this.zza;
            if (i < zzvmArr.length) {
                zzvmArr[i].zzl(this, j);
                i++;
            } else {
                return;
            }
        }
    }

    public final void zzm(long j) {
        this.zzh.zzm(j);
    }

    public final zzvm zzn(int i) {
        zzvm zzvm = this.zza[i];
        return zzvm instanceof zzxn ? ((zzxn) zzvm).zzn() : zzvm;
    }

    public final boolean zzo(zzlo zzlo) {
        if (this.zzc.isEmpty()) {
            return this.zzh.zzo(zzlo);
        }
        int size = this.zzc.size();
        for (int i = 0; i < size; i++) {
            ((zzvm) this.zzc.get(i)).zzo(zzlo);
        }
        return false;
    }

    public final boolean zzp() {
        return this.zzh.zzp();
    }
}
