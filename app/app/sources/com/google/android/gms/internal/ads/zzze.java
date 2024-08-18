package com.google.android.gms.internal.ads;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzze extends zzzj implements zzmo {
    /* access modifiers changed from: private */
    public static final zzgcn zzb = zzgcn.zzb(new zzyb());
    public final Context zza;
    private final Object zzc = new Object();
    private final boolean zzd;
    private zzys zze;
    private zzyx zzf;
    private zzk zzg;
    private final zzxx zzh;

    public zzze(Context context) {
        Context context2;
        zzxx zzxx = new zzxx();
        zzys zzd2 = zzys.zzd(context);
        if (context != null) {
            context2 = context.getApplicationContext();
        } else {
            context2 = null;
        }
        this.zza = context2;
        this.zzh = zzxx;
        this.zze = zzd2;
        this.zzg = zzk.zza;
        boolean z = false;
        if (context != null && zzgd.zzN(context)) {
            z = true;
        }
        this.zzd = z;
        if (!z && context != null && zzgd.zza >= 32) {
            this.zzf = zzyx.zza(context);
        }
        if (this.zze.zzS && context == null) {
            zzfk.zzf("DefaultTrackSelector", "Audio channel count constraints cannot be applied without reference to Context. Build the track selector instance with one of the non-deprecated constructors that take a Context argument.");
        }
    }

    static /* bridge */ /* synthetic */ int zzb(int i, int i2) {
        if (i == 0 || i != i2) {
            return Integer.bitCount(i & i2);
        }
        return Integer.MAX_VALUE;
    }

    protected static int zzc(zzan zzan, String str, boolean z) {
        if (!TextUtils.isEmpty(str) && str.equals(zzan.zze)) {
            return 4;
        }
        String zzh2 = zzh(str);
        String zzh3 = zzh(zzan.zze);
        if (zzh3 == null || zzh2 == null) {
            return (!z || zzh3 != null) ? 0 : 1;
        }
        if (zzh3.startsWith(zzh2) || zzh2.startsWith(zzh3)) {
            return 3;
        }
        int i = zzgd.zza;
        if (zzh3.split("-", 2)[0].equals(zzh2.split("-", 2)[0])) {
            return 2;
        }
        return 0;
    }

    protected static String zzh(String str) {
        if (TextUtils.isEmpty(str) || TextUtils.equals(str, "und")) {
            return null;
        }
        return str;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0047, code lost:
        if (r1.equals("audio/eac3-joc") != false) goto L_0x004b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static /* synthetic */ boolean zzm(com.google.android.gms.internal.ads.zzze r7, com.google.android.gms.internal.ads.zzan r8) {
        /*
            java.lang.Object r0 = r7.zzc
            monitor-enter(r0)
            com.google.android.gms.internal.ads.zzys r1 = r7.zze     // Catch:{ all -> 0x008a }
            boolean r1 = r1.zzS     // Catch:{ all -> 0x008a }
            r2 = 1
            if (r1 == 0) goto L_0x0087
            boolean r1 = r7.zzd     // Catch:{ all -> 0x008a }
            if (r1 != 0) goto L_0x0087
            int r1 = r8.zzA     // Catch:{ all -> 0x008a }
            r3 = 2
            if (r1 <= r3) goto L_0x0087
            java.lang.String r1 = r8.zzn     // Catch:{ all -> 0x008a }
            r4 = 32
            r5 = 0
            if (r1 != 0) goto L_0x001b
            goto L_0x005e
        L_0x001b:
            int r6 = r1.hashCode()     // Catch:{ all -> 0x008a }
            switch(r6) {
                case -2123537834: goto L_0x0041;
                case 187078296: goto L_0x0037;
                case 187078297: goto L_0x002d;
                case 1504578661: goto L_0x0023;
                default: goto L_0x0022;
            }
        L_0x0022:
            goto L_0x004a
        L_0x0023:
            java.lang.String r3 = "audio/eac3"
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x004a
            r3 = r2
            goto L_0x004b
        L_0x002d:
            java.lang.String r3 = "audio/ac4"
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x004a
            r3 = 3
            goto L_0x004b
        L_0x0037:
            java.lang.String r3 = "audio/ac3"
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x004a
            r3 = r5
            goto L_0x004b
        L_0x0041:
            java.lang.String r6 = "audio/eac3-joc"
            boolean r1 = r1.equals(r6)
            if (r1 == 0) goto L_0x004a
            goto L_0x004b
        L_0x004a:
            r3 = -1
        L_0x004b:
            switch(r3) {
                case 0: goto L_0x004f;
                case 1: goto L_0x004f;
                case 2: goto L_0x004f;
                case 3: goto L_0x004f;
                default: goto L_0x004e;
            }
        L_0x004e:
            goto L_0x005e
        L_0x004f:
            int r1 = com.google.android.gms.internal.ads.zzgd.zza     // Catch:{ all -> 0x008a }
            if (r1 < r4) goto L_0x0087
            com.google.android.gms.internal.ads.zzyx r1 = r7.zzf     // Catch:{ all -> 0x008a }
            if (r1 == 0) goto L_0x0087
            boolean r1 = r1.zzg()     // Catch:{ all -> 0x008a }
            if (r1 != 0) goto L_0x005e
            goto L_0x0087
        L_0x005e:
            int r1 = com.google.android.gms.internal.ads.zzgd.zza     // Catch:{ all -> 0x008a }
            if (r1 < r4) goto L_0x0085
            com.google.android.gms.internal.ads.zzyx r1 = r7.zzf     // Catch:{ all -> 0x008a }
            if (r1 == 0) goto L_0x0085
            boolean r3 = r1.zzg()     // Catch:{ all -> 0x008a }
            if (r3 == 0) goto L_0x0085
            boolean r1 = r1.zze()     // Catch:{ all -> 0x008a }
            if (r1 == 0) goto L_0x0085
            com.google.android.gms.internal.ads.zzyx r1 = r7.zzf     // Catch:{ all -> 0x008a }
            boolean r1 = r1.zzf()     // Catch:{ all -> 0x008a }
            if (r1 == 0) goto L_0x0085
            com.google.android.gms.internal.ads.zzyx r1 = r7.zzf     // Catch:{ all -> 0x008a }
            com.google.android.gms.internal.ads.zzk r7 = r7.zzg     // Catch:{ all -> 0x008a }
            boolean r7 = r1.zzd(r7, r8)     // Catch:{ all -> 0x008a }
            if (r7 == 0) goto L_0x0085
            goto L_0x0088
        L_0x0085:
            r2 = r5
            goto L_0x0088
        L_0x0087:
        L_0x0088:
            monitor-exit(r0)     // Catch:{ all -> 0x008a }
            return r2
        L_0x008a:
            r7 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x008a }
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzze.zzm(com.google.android.gms.internal.ads.zzze, com.google.android.gms.internal.ads.zzan):boolean");
    }

    protected static boolean zzo(int i, boolean z) {
        int i2 = i & 7;
        if (i2 == 4) {
            return true;
        }
        if (z) {
            return i2 == 3;
        }
        return false;
    }

    private static void zzu(zzxr zzxr, zzdl zzdl, Map map) {
        int i = 0;
        while (i < zzxr.zzc) {
            if (((zzdg) zzdl.zzD.get(zzxr.zzb(i))) == null) {
                i++;
            } else {
                throw null;
            }
        }
    }

    /* access modifiers changed from: private */
    public final void zzv() {
        boolean z;
        zzyx zzyx;
        synchronized (this.zzc) {
            z = false;
            if (this.zze.zzS && !this.zzd && zzgd.zza >= 32 && (zzyx = this.zzf) != null && zzyx.zzg()) {
                z = true;
            }
        }
        if (z) {
            zzt();
        }
    }

    private static final Pair zzw(int i, zzzi zzzi, int[][][] iArr, zzyz zzyz, Comparator comparator) {
        Object obj;
        boolean z;
        zzzi zzzi2 = zzzi;
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        while (i2 < 2) {
            if (i == zzzi2.zzc(i2)) {
                zzxr zzd2 = zzzi2.zzd(i2);
                int i3 = 0;
                while (i3 < zzd2.zzc) {
                    zzde zzb2 = zzd2.zzb(i3);
                    List zza2 = zzyz.zza(i2, zzb2, iArr[i2][i3]);
                    boolean[] zArr = new boolean[zzb2.zzb];
                    int i4 = 0;
                    while (i4 < zzb2.zzb) {
                        int i5 = i4 + 1;
                        zzza zzza = (zzza) zza2.get(i4);
                        int zzb3 = zzza.zzb();
                        if (!zArr[i4] && zzb3 != 0) {
                            if (zzb3 == 1) {
                                obj = zzgbc.zzn(zzza);
                            } else {
                                ArrayList arrayList2 = new ArrayList();
                                arrayList2.add(zzza);
                                int i6 = i5;
                                while (i6 < zzb2.zzb) {
                                    zzza zzza2 = (zzza) zza2.get(i6);
                                    if (zzza2.zzb() != 2) {
                                        z = true;
                                    } else if (zzza.zzc(zzza2)) {
                                        arrayList2.add(zzza2);
                                        z = true;
                                        zArr[i6] = true;
                                    } else {
                                        z = true;
                                    }
                                    i6++;
                                    boolean z2 = z;
                                    zzzi zzzi3 = zzzi;
                                }
                                obj = arrayList2;
                            }
                            arrayList.add(obj);
                        }
                        zzzi zzzi4 = zzzi;
                        i4 = i5;
                    }
                    i3++;
                    zzzi zzzi5 = zzzi;
                }
            }
            zzyz zzyz2 = zzyz;
            i2++;
            zzzi2 = zzzi;
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        List list = (List) Collections.max(arrayList, comparator);
        int[] iArr2 = new int[list.size()];
        for (int i7 = 0; i7 < list.size(); i7++) {
            iArr2[i7] = ((zzza) list.get(i7)).zzc;
        }
        zzza zzza3 = (zzza) list.get(0);
        return Pair.create(new zzzf(zzza3.zzb, iArr2, 0), Integer.valueOf(zzza3.zza));
    }

    public final void zza(zzmn zzmn) {
        synchronized (this.zzc) {
            boolean z = this.zze.zzW;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v0, resolved type: com.google.android.gms.internal.ads.zzzg[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v9, resolved type: java.lang.Object[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v3, resolved type: com.google.android.gms.internal.ads.zzxy} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v8, resolved type: com.google.android.gms.internal.ads.zzzh} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r20v1, resolved type: com.google.android.gms.internal.ads.zzzh} */
    /* JADX WARNING: type inference failed for: r9v1 */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.util.Pair zzd(com.google.android.gms.internal.ads.zzzi r27, int[][][] r28, int[] r29, com.google.android.gms.internal.ads.zzvo r30, com.google.android.gms.internal.ads.zzdc r31) throws com.google.android.gms.internal.ads.zzjh {
        /*
            r26 = this;
            r1 = r26
            r0 = r27
            r2 = r28
            r3 = r29
            java.lang.Object r4 = r1.zzc
            monitor-enter(r4)
            com.google.android.gms.internal.ads.zzys r5 = r1.zze     // Catch:{ all -> 0x0271 }
            boolean r6 = r5.zzS     // Catch:{ all -> 0x0271 }
            if (r6 == 0) goto L_0x0025
            int r6 = com.google.android.gms.internal.ads.zzgd.zza     // Catch:{ all -> 0x0271 }
            r7 = 32
            if (r6 < r7) goto L_0x0025
            com.google.android.gms.internal.ads.zzyx r6 = r1.zzf     // Catch:{ all -> 0x0271 }
            if (r6 == 0) goto L_0x0025
            android.os.Looper r7 = android.os.Looper.myLooper()     // Catch:{ all -> 0x0271 }
            com.google.android.gms.internal.ads.zzeq.zzb(r7)     // Catch:{ all -> 0x0271 }
            r6.zzb(r1, r7)     // Catch:{ all -> 0x0271 }
        L_0x0025:
            monitor-exit(r4)     // Catch:{ all -> 0x0271 }
            r4 = 2
            com.google.android.gms.internal.ads.zzzf[] r6 = new com.google.android.gms.internal.ads.zzzf[r4]
            com.google.android.gms.internal.ads.zzdj r7 = r5.zzv
            com.google.android.gms.internal.ads.zzyh r7 = new com.google.android.gms.internal.ads.zzyh
            r7.<init>(r5, r3)
            com.google.android.gms.internal.ads.zzyi r8 = new com.google.android.gms.internal.ads.zzyi
            r8.<init>()
            android.util.Pair r7 = zzw(r4, r0, r2, r7, r8)
            boolean r8 = r5.zzA
            r8 = 4
            if (r7 != 0) goto L_0x004f
            com.google.android.gms.internal.ads.zzdj r10 = r5.zzv
            com.google.android.gms.internal.ads.zzyd r10 = new com.google.android.gms.internal.ads.zzyd
            r10.<init>(r5)
            com.google.android.gms.internal.ads.zzye r11 = new com.google.android.gms.internal.ads.zzye
            r11.<init>()
            android.util.Pair r10 = zzw(r8, r0, r2, r10, r11)
            goto L_0x0050
        L_0x004f:
            r10 = 0
        L_0x0050:
            r11 = 0
            if (r10 == 0) goto L_0x0063
            java.lang.Object r7 = r10.second
            java.lang.Integer r7 = (java.lang.Integer) r7
            int r7 = r7.intValue()
            java.lang.Object r10 = r10.first
            com.google.android.gms.internal.ads.zzzf r10 = (com.google.android.gms.internal.ads.zzzf) r10
            r6[r7] = r10
            r7 = r11
            goto L_0x0076
        L_0x0063:
            if (r7 == 0) goto L_0x0074
            java.lang.Object r10 = r7.second
            java.lang.Integer r10 = (java.lang.Integer) r10
            int r10 = r10.intValue()
            java.lang.Object r7 = r7.first
            com.google.android.gms.internal.ads.zzzf r7 = (com.google.android.gms.internal.ads.zzzf) r7
            r6[r10] = r7
            goto L_0x0075
        L_0x0074:
        L_0x0075:
            r7 = r11
        L_0x0076:
            r10 = 1
            if (r7 >= r4) goto L_0x008c
            int r12 = r0.zzc(r7)
            if (r12 != r4) goto L_0x0089
            com.google.android.gms.internal.ads.zzxr r12 = r0.zzd(r7)
            int r12 = r12.zzc
            if (r12 <= 0) goto L_0x0089
            r7 = r10
            goto L_0x008d
        L_0x0089:
            int r7 = r7 + 1
            goto L_0x0076
        L_0x008c:
            r7 = r11
        L_0x008d:
            com.google.android.gms.internal.ads.zzyf r12 = new com.google.android.gms.internal.ads.zzyf
            r12.<init>(r1, r5, r7, r3)
            com.google.android.gms.internal.ads.zzyg r3 = new com.google.android.gms.internal.ads.zzyg
            r3.<init>()
            android.util.Pair r3 = zzw(r10, r0, r2, r12, r3)
            if (r3 == 0) goto L_0x00ab
            java.lang.Object r7 = r3.second
            java.lang.Integer r7 = (java.lang.Integer) r7
            int r7 = r7.intValue()
            java.lang.Object r12 = r3.first
            com.google.android.gms.internal.ads.zzzf r12 = (com.google.android.gms.internal.ads.zzzf) r12
            r6[r7] = r12
        L_0x00ab:
            if (r3 != 0) goto L_0x00af
            r3 = 0
            goto L_0x00c3
        L_0x00af:
            java.lang.Object r7 = r3.first
            com.google.android.gms.internal.ads.zzzf r7 = (com.google.android.gms.internal.ads.zzzf) r7
            com.google.android.gms.internal.ads.zzde r7 = r7.zza
            java.lang.Object r3 = r3.first
            com.google.android.gms.internal.ads.zzzf r3 = (com.google.android.gms.internal.ads.zzzf) r3
            int[] r3 = r3.zzb
            r3 = r3[r11]
            com.google.android.gms.internal.ads.zzan r3 = r7.zzb(r3)
            java.lang.String r3 = r3.zze
        L_0x00c3:
            com.google.android.gms.internal.ads.zzdj r7 = r5.zzv
            com.google.android.gms.internal.ads.zzyj r7 = new com.google.android.gms.internal.ads.zzyj
            r7.<init>(r5, r3)
            com.google.android.gms.internal.ads.zzyk r3 = new com.google.android.gms.internal.ads.zzyk
            r3.<init>()
            r12 = 3
            android.util.Pair r3 = zzw(r12, r0, r2, r7, r3)
            if (r3 == 0) goto L_0x00e6
            java.lang.Object r7 = r3.second
            java.lang.Integer r7 = (java.lang.Integer) r7
            int r7 = r7.intValue()
            java.lang.Object r3 = r3.first
            com.google.android.gms.internal.ads.zzzf r3 = (com.google.android.gms.internal.ads.zzzf) r3
            r6[r7] = r3
            r3 = r11
            goto L_0x00e7
        L_0x00e6:
            r3 = r11
        L_0x00e7:
            if (r3 >= r4) goto L_0x015c
            int r7 = r0.zzc(r3)
            if (r7 == r4) goto L_0x0154
            if (r7 == r10) goto L_0x0154
            if (r7 == r12) goto L_0x0154
            if (r7 == r8) goto L_0x0154
            com.google.android.gms.internal.ads.zzxr r7 = r0.zzd(r3)
            r13 = r2[r3]
            com.google.android.gms.internal.ads.zzdj r14 = r5.zzv
            r14 = r11
            r16 = r14
            r15 = 0
            r17 = 0
        L_0x0103:
            int r8 = r7.zzc
            if (r14 >= r8) goto L_0x0144
            com.google.android.gms.internal.ads.zzde r8 = r7.zzb(r14)
            r18 = r13[r14]
            r10 = r11
            r12 = r17
        L_0x0110:
            int r9 = r8.zzb
            if (r10 >= r9) goto L_0x013a
            r9 = r18[r10]
            boolean r4 = r5.zzT
            boolean r4 = zzo(r9, r4)
            if (r4 == 0) goto L_0x0135
            com.google.android.gms.internal.ads.zzan r4 = r8.zzb(r10)
            com.google.android.gms.internal.ads.zzyn r9 = new com.google.android.gms.internal.ads.zzyn
            r11 = r18[r10]
            r9.<init>(r4, r11)
            if (r12 == 0) goto L_0x0131
            int r4 = r9.compareTo(r12)
            if (r4 <= 0) goto L_0x0135
        L_0x0131:
            r15 = r8
            r12 = r9
            r16 = r10
        L_0x0135:
            int r10 = r10 + 1
            r4 = 2
            r11 = 0
            goto L_0x0110
        L_0x013a:
            int r14 = r14 + 1
            r17 = r12
            r4 = 2
            r8 = 4
            r10 = 1
            r11 = 0
            r12 = 3
            goto L_0x0103
        L_0x0144:
            if (r15 != 0) goto L_0x0148
            r4 = 0
            goto L_0x0152
        L_0x0148:
            com.google.android.gms.internal.ads.zzzf r4 = new com.google.android.gms.internal.ads.zzzf
            int[] r7 = new int[]{r16}
            r8 = 0
            r4.<init>(r15, r7, r8)
        L_0x0152:
            r6[r3] = r4
        L_0x0154:
            int r3 = r3 + 1
            r4 = 2
            r8 = 4
            r10 = 1
            r11 = 0
            r12 = 3
            goto L_0x00e7
        L_0x015c:
            java.util.HashMap r2 = new java.util.HashMap
            r2.<init>()
            r8 = 0
        L_0x0162:
            r3 = 2
            if (r8 >= r3) goto L_0x016f
            com.google.android.gms.internal.ads.zzxr r3 = r0.zzd(r8)
            zzu(r3, r5, r2)
            int r8 = r8 + 1
            goto L_0x0162
        L_0x016f:
            com.google.android.gms.internal.ads.zzxr r3 = r27.zze()
            zzu(r3, r5, r2)
            r8 = 0
        L_0x0177:
            r3 = 2
            if (r8 >= r3) goto L_0x0190
            int r3 = r0.zzc(r8)
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            java.lang.Object r3 = r2.get(r3)
            com.google.android.gms.internal.ads.zzdg r3 = (com.google.android.gms.internal.ads.zzdg) r3
            if (r3 != 0) goto L_0x018d
            int r8 = r8 + 1
            goto L_0x0177
        L_0x018d:
            r0 = 0
            throw r0
        L_0x0190:
            r8 = 0
        L_0x0191:
            r2 = 2
            if (r8 >= r2) goto L_0x01ae
            com.google.android.gms.internal.ads.zzxr r2 = r0.zzd(r8)
            boolean r3 = r5.zzg(r8, r2)
            if (r3 != 0) goto L_0x01a0
            r2 = 0
            goto L_0x01a9
        L_0x01a0:
            com.google.android.gms.internal.ads.zzyu r2 = r5.zze(r8, r2)
            if (r2 != 0) goto L_0x01ac
            r2 = 0
            r6[r8] = r2
        L_0x01a9:
            int r8 = r8 + 1
            goto L_0x0191
        L_0x01ac:
            r2 = 0
            throw r2
        L_0x01ae:
            r8 = 0
        L_0x01af:
            r2 = 2
            if (r8 >= r2) goto L_0x01d2
            int r2 = r0.zzc(r8)
            boolean r3 = r5.zzf(r8)
            if (r3 != 0) goto L_0x01cb
            com.google.android.gms.internal.ads.zzgbh r3 = r5.zzE
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            boolean r2 = r3.contains(r2)
            if (r2 == 0) goto L_0x01c9
            goto L_0x01cb
        L_0x01c9:
            r2 = 0
            goto L_0x01cf
        L_0x01cb:
            r2 = 0
            r6[r8] = r2
        L_0x01cf:
            int r8 = r8 + 1
            goto L_0x01af
        L_0x01d2:
            r2 = 0
            com.google.android.gms.internal.ads.zzxx r3 = r1.zzh
            com.google.android.gms.internal.ads.zzzu r4 = r26.zzr()
            com.google.android.gms.internal.ads.zzgbc r7 = com.google.android.gms.internal.ads.zzxy.zzf(r6)
            r8 = 2
            com.google.android.gms.internal.ads.zzzg[] r15 = new com.google.android.gms.internal.ads.zzzg[r8]
            r14 = 0
        L_0x01e1:
            if (r14 >= r8) goto L_0x0233
            r8 = r6[r14]
            if (r8 == 0) goto L_0x0229
            int[] r11 = r8.zzb
            int r9 = r11.length
            if (r9 != 0) goto L_0x01f3
            r19 = r14
            r16 = 0
            r17 = 1
            goto L_0x022f
        L_0x01f3:
            r13 = 1
            if (r9 != r13) goto L_0x0210
            com.google.android.gms.internal.ads.zzde r8 = r8.zza
            com.google.android.gms.internal.ads.zzzh r9 = new com.google.android.gms.internal.ads.zzzh
            r16 = 0
            r22 = r11[r16]
            r23 = 0
            r24 = 0
            r25 = 0
            r20 = r9
            r21 = r8
            r20.<init>(r21, r22, r23, r24, r25)
            r17 = r13
            r19 = r14
            goto L_0x0226
        L_0x0210:
            r16 = 0
            com.google.android.gms.internal.ads.zzde r10 = r8.zza
            java.lang.Object r8 = r7.get(r14)
            com.google.android.gms.internal.ads.zzgbc r8 = (com.google.android.gms.internal.ads.zzgbc) r8
            r12 = 0
            r9 = r3
            r17 = r13
            r13 = r4
            r19 = r14
            r14 = r8
            com.google.android.gms.internal.ads.zzxy r9 = r9.zza(r10, r11, r12, r13, r14)
        L_0x0226:
            r15[r19] = r9
            goto L_0x022f
        L_0x0229:
            r19 = r14
            r16 = 0
            r17 = 1
        L_0x022f:
            int r14 = r19 + 1
            r8 = 2
            goto L_0x01e1
        L_0x0233:
            r16 = 0
            r3 = 2
            com.google.android.gms.internal.ads.zzmq[] r4 = new com.google.android.gms.internal.ads.zzmq[r3]
            r11 = r16
        L_0x023a:
            if (r11 >= r3) goto L_0x0268
            int r6 = r0.zzc(r11)
            boolean r7 = r5.zzf(r11)
            if (r7 != 0) goto L_0x0262
            com.google.android.gms.internal.ads.zzgbh r7 = r5.zzE
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
            boolean r6 = r7.contains(r6)
            if (r6 == 0) goto L_0x0254
            r6 = r2
            goto L_0x0263
        L_0x0254:
            int r6 = r0.zzc(r11)
            r7 = -2
            if (r6 == r7) goto L_0x025f
            r6 = r15[r11]
            if (r6 == 0) goto L_0x0262
        L_0x025f:
            com.google.android.gms.internal.ads.zzmq r6 = com.google.android.gms.internal.ads.zzmq.zza
            goto L_0x0263
        L_0x0262:
            r6 = r2
        L_0x0263:
            r4[r11] = r6
            int r11 = r11 + 1
            goto L_0x023a
        L_0x0268:
            boolean r0 = r5.zzU
            com.google.android.gms.internal.ads.zzdj r0 = r5.zzv
            android.util.Pair r0 = android.util.Pair.create(r4, r15)
            return r0
        L_0x0271:
            r0 = move-exception
            monitor-exit(r4)     // Catch:{ all -> 0x0271 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzze.zzd(com.google.android.gms.internal.ads.zzzi, int[][][], int[], com.google.android.gms.internal.ads.zzvo, com.google.android.gms.internal.ads.zzdc):android.util.Pair");
    }

    public final zzmo zze() {
        return this;
    }

    public final zzys zzf() {
        zzys zzys;
        synchronized (this.zzc) {
            zzys = this.zze;
        }
        return zzys;
    }

    public final void zzj() {
        zzyx zzyx;
        synchronized (this.zzc) {
            if (zzgd.zza >= 32 && (zzyx = this.zzf) != null) {
                zzyx.zzc();
            }
        }
        super.zzj();
    }

    public final void zzk(zzk zzk) {
        boolean z;
        synchronized (this.zzc) {
            z = !this.zzg.equals(zzk);
            this.zzg = zzk;
        }
        if (z) {
            zzv();
        }
    }

    public final void zzl(zzyq zzyq) {
        boolean z;
        zzys zzys = new zzys(zzyq);
        synchronized (this.zzc) {
            z = !this.zze.equals(zzys);
            this.zze = zzys;
        }
        if (z) {
            if (zzys.zzS && this.zza == null) {
                zzfk.zzf("DefaultTrackSelector", "Audio channel count constraints cannot be applied without reference to Context. Build the track selector instance with one of the non-deprecated constructors that take a Context argument.");
            }
            zzt();
        }
    }

    public final boolean zzn() {
        return true;
    }
}
