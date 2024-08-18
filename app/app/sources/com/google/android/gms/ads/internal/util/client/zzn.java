package com.google.android.gms.ads.internal.util.client;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads-lite@@23.2.0 */
public final class zzn {
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v1, resolved type: android.os.Bundle} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v1, resolved type: android.os.Bundle} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v1, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v4, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v2, resolved type: android.os.Bundle} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v2, resolved type: android.os.Bundle} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean zza(android.os.Bundle r9, android.os.Bundle r10) {
        /*
            r0 = 1
            r1 = 0
            if (r9 == 0) goto L_0x008c
            if (r10 == 0) goto L_0x008c
            int r2 = r9.size()
            int r3 = r10.size()
            if (r2 == r3) goto L_0x0011
            return r1
        L_0x0011:
            java.util.Set r2 = r9.keySet()
            java.util.Iterator r2 = r2.iterator()
        L_0x0019:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x008b
            java.lang.Object r3 = r2.next()
            java.lang.String r3 = (java.lang.String) r3
            boolean r4 = r10.containsKey(r3)
            if (r4 != 0) goto L_0x002c
            return r1
        L_0x002c:
            java.lang.Object r4 = r9.get(r3)
            java.lang.Object r3 = r10.get(r3)
            if (r4 == 0) goto L_0x0087
            if (r3 != 0) goto L_0x0039
            goto L_0x0088
        L_0x0039:
            boolean r5 = r4 instanceof android.os.Bundle
            if (r5 == 0) goto L_0x004c
            boolean r5 = r3 instanceof android.os.Bundle
            if (r5 == 0) goto L_0x004b
            android.os.Bundle r4 = (android.os.Bundle) r4
            android.os.Bundle r3 = (android.os.Bundle) r3
            boolean r3 = zza(r4, r3)
            if (r3 != 0) goto L_0x0019
        L_0x004b:
            return r1
        L_0x004c:
            java.lang.Class r5 = r4.getClass()
            boolean r5 = r5.isArray()
            if (r5 == 0) goto L_0x0080
            int r5 = java.lang.reflect.Array.getLength(r4)
            java.lang.Class r6 = r3.getClass()
            boolean r6 = r6.isArray()
            if (r6 == 0) goto L_0x007f
            int r6 = java.lang.reflect.Array.getLength(r3)
            if (r5 != r6) goto L_0x007f
            r6 = r1
        L_0x006b:
            if (r6 >= r5) goto L_0x0019
            java.lang.Object r7 = java.lang.reflect.Array.get(r4, r6)
            java.lang.Object r8 = java.lang.reflect.Array.get(r3, r6)
            boolean r7 = com.google.android.gms.common.internal.Objects.equal(r7, r8)
            if (r7 != 0) goto L_0x007c
            return r1
        L_0x007c:
            int r6 = r6 + 1
            goto L_0x006b
        L_0x007f:
            return r1
        L_0x0080:
            boolean r3 = r4.equals(r3)
            if (r3 != 0) goto L_0x0019
            return r1
        L_0x0087:
        L_0x0088:
            r10 = r3
            r9 = r4
            goto L_0x008c
        L_0x008b:
            return r0
        L_0x008c:
            if (r9 != 0) goto L_0x0091
            if (r10 != 0) goto L_0x0091
            return r0
        L_0x0091:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.util.client.zzn.zza(android.os.Bundle, android.os.Bundle):boolean");
    }
}
