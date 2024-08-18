package com.google.android.gms.internal.ads;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
final class zzage extends zzagg {
    private long zzb = -9223372036854775807L;
    private long[] zzc = new long[0];
    private long[] zzd = new long[0];

    public zzage() {
        super(new zzadt());
    }

    private static Double zzg(zzfu zzfu) {
        return Double.valueOf(Double.longBitsToDouble(zzfu.zzt()));
    }

    private static String zzi(zzfu zzfu) {
        int zzq = zzfu.zzq();
        int zzd2 = zzfu.zzd();
        zzfu.zzL(zzq);
        return new String(zzfu.zzM(), zzd2, zzq);
    }

    private static HashMap zzj(zzfu zzfu) {
        int zzp = zzfu.zzp();
        HashMap hashMap = new HashMap(zzp);
        for (int i = 0; i < zzp; i++) {
            String zzi = zzi(zzfu);
            Object zzh = zzh(zzfu, zzfu.zzm());
            if (zzh != null) {
                hashMap.put(zzi, zzh);
            }
        }
        return hashMap;
    }

    /* access modifiers changed from: protected */
    public final boolean zza(zzfu zzfu) {
        return true;
    }

    /* access modifiers changed from: protected */
    public final boolean zzb(zzfu zzfu, long j) {
        if (zzfu.zzm() == 2 && "onMetaData".equals(zzi(zzfu)) && zzfu.zzb() != 0 && zzfu.zzm() == 8) {
            HashMap zzj = zzj(zzfu);
            Object obj = zzj.get(TypedValues.TransitionType.S_DURATION);
            if (obj instanceof Double) {
                double doubleValue = ((Double) obj).doubleValue();
                if (doubleValue > 0.0d) {
                    this.zzb = (long) (doubleValue * 1000000.0d);
                }
            }
            Object obj2 = zzj.get("keyframes");
            if (obj2 instanceof Map) {
                Map map = (Map) obj2;
                Object obj3 = map.get("filepositions");
                Object obj4 = map.get("times");
                if ((obj3 instanceof List) && (obj4 instanceof List)) {
                    List list = (List) obj3;
                    List list2 = (List) obj4;
                    int size = list2.size();
                    this.zzc = new long[size];
                    this.zzd = new long[size];
                    int i = 0;
                    while (true) {
                        if (i >= size) {
                            break;
                        }
                        Object obj5 = list.get(i);
                        Object obj6 = list2.get(i);
                        if (!(obj6 instanceof Double) || !(obj5 instanceof Double)) {
                            this.zzc = new long[0];
                            this.zzd = new long[0];
                        } else {
                            this.zzc[i] = (long) (((Double) obj6).doubleValue() * 1000000.0d);
                            this.zzd[i] = ((Double) obj5).longValue();
                            i++;
                        }
                    }
                    this.zzc = new long[0];
                    this.zzd = new long[0];
                }
            }
        }
        return false;
    }

    public final long zzc() {
        return this.zzb;
    }

    public final long[] zzd() {
        return this.zzd;
    }

    public final long[] zze() {
        return this.zzc;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v1, resolved type: boolean} */
    /* JADX WARNING: type inference failed for: r0v0 */
    /* JADX WARNING: type inference failed for: r0v2 */
    /* JADX WARNING: type inference failed for: r0v4, types: [int] */
    /* JADX WARNING: type inference failed for: r0v9 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.Object zzh(com.google.android.gms.internal.ads.zzfu r3, int r4) {
        /*
            r0 = 0
            switch(r4) {
                case 0: goto L_0x0068;
                case 1: goto L_0x005b;
                case 2: goto L_0x0056;
                case 3: goto L_0x003a;
                case 4: goto L_0x0004;
                case 5: goto L_0x0004;
                case 6: goto L_0x0004;
                case 7: goto L_0x0004;
                case 8: goto L_0x0035;
                case 9: goto L_0x0004;
                case 10: goto L_0x0019;
                case 11: goto L_0x0006;
                default: goto L_0x0004;
            }
        L_0x0004:
            r3 = 0
            return r3
        L_0x0006:
            java.util.Date r4 = new java.util.Date
            java.lang.Double r0 = zzg(r3)
            double r0 = r0.doubleValue()
            long r0 = (long) r0
            r4.<init>(r0)
            r0 = 2
            r3.zzL(r0)
            return r4
        L_0x0019:
            int r4 = r3.zzp()
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>(r4)
        L_0x0022:
            if (r0 >= r4) goto L_0x0034
            int r2 = r3.zzm()
            java.lang.Object r2 = zzh(r3, r2)
            if (r2 == 0) goto L_0x0031
            r1.add(r2)
        L_0x0031:
            int r0 = r0 + 1
            goto L_0x0022
        L_0x0034:
            return r1
        L_0x0035:
            java.util.HashMap r3 = zzj(r3)
            return r3
        L_0x003a:
            java.util.HashMap r4 = new java.util.HashMap
            r4.<init>()
        L_0x003f:
            java.lang.String r0 = zzi(r3)
            int r1 = r3.zzm()
            r2 = 9
            if (r1 != r2) goto L_0x004c
            return r4
        L_0x004c:
            java.lang.Object r1 = zzh(r3, r1)
            if (r1 == 0) goto L_0x003f
            r4.put(r0, r1)
            goto L_0x003f
        L_0x0056:
            java.lang.String r3 = zzi(r3)
            return r3
        L_0x005b:
            int r3 = r3.zzm()
            r4 = 1
            if (r3 != r4) goto L_0x0063
            r0 = r4
        L_0x0063:
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r0)
            return r3
        L_0x0068:
            java.lang.Double r3 = zzg(r3)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzage.zzh(com.google.android.gms.internal.ads.zzfu, int):java.lang.Object");
    }
}
