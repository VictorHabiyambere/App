package com.google.android.gms.internal.ads;

import com.google.android.gms.fido.fido2.api.common.DevicePublicKeyStringDef;
import java.util.regex.Pattern;
import kotlinx.coroutines.DebugKt;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
final class zzamr {
    private static final Pattern zzd = Pattern.compile("\\s+");
    private static final zzgbh zze = zzgbh.zzp(DebugKt.DEBUG_PROPERTY_VALUE_AUTO, DevicePublicKeyStringDef.NONE);
    private static final zzgbh zzf = zzgbh.zzq("dot", "sesame", "circle");
    private static final zzgbh zzg = zzgbh.zzp("filled", "open");
    private static final zzgbh zzh = zzgbh.zzq("after", "before", "outside");
    public final int zza;
    public final int zzb;
    public final int zzc;

    private zzamr(int i, int i2, int i3) {
        this.zza = i;
        this.zzb = i2;
        this.zzc = i3;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.android.gms.internal.ads.zzamr zza(java.lang.String r7) {
        /*
            if (r7 != 0) goto L_0x0004
            goto L_0x00f2
        L_0x0004:
            java.lang.String r7 = r7.trim()
            java.lang.String r7 = com.google.android.gms.internal.ads.zzfxm.zza(r7)
            boolean r0 = r7.isEmpty()
            if (r0 != 0) goto L_0x00f2
            java.util.regex.Pattern r0 = zzd
            java.lang.String[] r7 = android.text.TextUtils.split(r7, r0)
            com.google.android.gms.internal.ads.zzgbh r7 = com.google.android.gms.internal.ads.zzgbh.zzm(r7)
            com.google.android.gms.internal.ads.zzgbh r0 = zzh
            com.google.android.gms.internal.ads.zzgdd r0 = com.google.android.gms.internal.ads.zzgde.zzb(r0, r7)
            java.lang.String r1 = "outside"
            java.lang.Object r0 = com.google.android.gms.internal.ads.zzgbi.zza(r0, r1)
            java.lang.String r0 = (java.lang.String) r0
            int r2 = r0.hashCode()
            r3 = 1
            r4 = -1
            r5 = 0
            switch(r2) {
                case -1106037339: goto L_0x0040;
                case 92734940: goto L_0x0035;
                default: goto L_0x0034;
            }
        L_0x0034:
            goto L_0x0048
        L_0x0035:
            java.lang.String r1 = "after"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0034
            r0 = r5
            goto L_0x0049
        L_0x0040:
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0034
            r0 = r3
            goto L_0x0049
        L_0x0048:
            r0 = r4
        L_0x0049:
            r1 = 2
            switch(r0) {
                case 0: goto L_0x0051;
                case 1: goto L_0x004f;
                default: goto L_0x004d;
            }
        L_0x004d:
            r0 = r3
            goto L_0x0052
        L_0x004f:
            r0 = -2
            goto L_0x0052
        L_0x0051:
            r0 = r1
        L_0x0052:
            com.google.android.gms.internal.ads.zzgbh r2 = zze
            com.google.android.gms.internal.ads.zzgdd r2 = com.google.android.gms.internal.ads.zzgde.zzb(r2, r7)
            boolean r6 = r2.isEmpty()
            if (r6 != 0) goto L_0x0084
            java.util.Iterator r7 = r2.iterator()
            java.lang.Object r7 = r7.next()
            java.lang.String r7 = (java.lang.String) r7
            int r1 = r7.hashCode()
            switch(r1) {
                case 3387192: goto L_0x0070;
                default: goto L_0x006f;
            }
        L_0x006f:
            goto L_0x007a
        L_0x0070:
            java.lang.String r1 = "none"
            boolean r7 = r7.equals(r1)
            if (r7 == 0) goto L_0x006f
            r7 = r5
            goto L_0x007b
        L_0x007a:
            r7 = r4
        L_0x007b:
            switch(r7) {
                case 0: goto L_0x0081;
                default: goto L_0x007e;
            }
        L_0x007e:
            r3 = r4
            goto L_0x00ec
        L_0x0081:
            r3 = r5
            goto L_0x00ec
        L_0x0084:
            com.google.android.gms.internal.ads.zzgbh r2 = zzg
            com.google.android.gms.internal.ads.zzgdd r2 = com.google.android.gms.internal.ads.zzgde.zzb(r2, r7)
            com.google.android.gms.internal.ads.zzgbh r6 = zzf
            com.google.android.gms.internal.ads.zzgdd r7 = com.google.android.gms.internal.ads.zzgde.zzb(r6, r7)
            boolean r6 = r2.isEmpty()
            if (r6 == 0) goto L_0x009e
            boolean r6 = r7.isEmpty()
            if (r6 == 0) goto L_0x009e
            r3 = r4
            goto L_0x00ec
        L_0x009e:
            java.lang.String r6 = "filled"
            java.lang.Object r2 = com.google.android.gms.internal.ads.zzgbi.zza(r2, r6)
            java.lang.String r2 = (java.lang.String) r2
            int r6 = r2.hashCode()
            switch(r6) {
                case 3417674: goto L_0x00ae;
                default: goto L_0x00ad;
            }
        L_0x00ad:
            goto L_0x00b9
        L_0x00ae:
            java.lang.String r6 = "open"
            boolean r2 = r2.equals(r6)
            if (r2 == 0) goto L_0x00ad
            r2 = r5
            goto L_0x00ba
        L_0x00b9:
            r2 = r4
        L_0x00ba:
            switch(r2) {
                case 0: goto L_0x00bf;
                default: goto L_0x00bd;
            }
        L_0x00bd:
            r2 = r3
            goto L_0x00c0
        L_0x00bf:
            r2 = r1
        L_0x00c0:
            java.lang.String r6 = "circle"
            java.lang.Object r7 = com.google.android.gms.internal.ads.zzgbi.zza(r7, r6)
            java.lang.String r7 = (java.lang.String) r7
            int r6 = r7.hashCode()
            switch(r6) {
                case -905816648: goto L_0x00db;
                case 99657: goto L_0x00d1;
                default: goto L_0x00d0;
            }
        L_0x00d0:
            goto L_0x00e4
        L_0x00d1:
            java.lang.String r6 = "dot"
            boolean r7 = r7.equals(r6)
            if (r7 == 0) goto L_0x00d0
            r4 = r5
            goto L_0x00e4
        L_0x00db:
            java.lang.String r5 = "sesame"
            boolean r7 = r7.equals(r5)
            if (r7 == 0) goto L_0x00d0
            r4 = r3
        L_0x00e4:
            switch(r4) {
                case 0: goto L_0x00ea;
                case 1: goto L_0x00e8;
                default: goto L_0x00e7;
            }
        L_0x00e7:
            goto L_0x00eb
        L_0x00e8:
            r3 = 3
            goto L_0x00eb
        L_0x00ea:
            r3 = r1
        L_0x00eb:
            r5 = r2
        L_0x00ec:
            com.google.android.gms.internal.ads.zzamr r7 = new com.google.android.gms.internal.ads.zzamr
            r7.<init>(r3, r5, r0)
            return r7
        L_0x00f2:
            r7 = 0
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzamr.zza(java.lang.String):com.google.android.gms.internal.ads.zzamr");
    }
}
