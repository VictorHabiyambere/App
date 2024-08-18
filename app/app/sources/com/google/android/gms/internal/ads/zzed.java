package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzed extends zzea {
    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zze(java.nio.ByteBuffer r6) {
        /*
            r5 = this;
            int r0 = r6.position()
            int r1 = r6.limit()
            int r2 = r1 - r0
            com.google.android.gms.internal.ads.zzdx r3 = r5.zzb
            int r3 = r3.zzd
            switch(r3) {
                case 3: goto L_0x001d;
                case 4: goto L_0x001a;
                case 21: goto L_0x0017;
                case 22: goto L_0x001a;
                case 268435456: goto L_0x001f;
                case 1342177280: goto L_0x0017;
                case 1610612736: goto L_0x001a;
                default: goto L_0x0011;
            }
        L_0x0011:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            r6.<init>()
            throw r6
        L_0x0017:
            int r2 = r2 / 3
            goto L_0x001e
        L_0x001a:
            int r2 = r2 / 2
            goto L_0x001f
        L_0x001d:
        L_0x001e:
            int r2 = r2 + r2
        L_0x001f:
            java.nio.ByteBuffer r2 = r5.zzj(r2)
            com.google.android.gms.internal.ads.zzdx r3 = r5.zzb
            int r3 = r3.zzd
            switch(r3) {
                case 3: goto L_0x00cc;
                case 4: goto L_0x00a2;
                case 21: goto L_0x008a;
                case 22: goto L_0x0072;
                case 268435456: goto L_0x005c;
                case 1342177280: goto L_0x0046;
                case 1610612736: goto L_0x0030;
                default: goto L_0x002a;
            }
        L_0x002a:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            r6.<init>()
            throw r6
        L_0x0030:
        L_0x0031:
            if (r0 >= r1) goto L_0x00e1
            int r3 = r0 + 1
            byte r3 = r6.get(r3)
            r2.put(r3)
            byte r3 = r6.get(r0)
            r2.put(r3)
            int r0 = r0 + 4
            goto L_0x0031
        L_0x0046:
        L_0x0047:
            if (r0 >= r1) goto L_0x00e1
            int r3 = r0 + 1
            byte r3 = r6.get(r3)
            r2.put(r3)
            byte r3 = r6.get(r0)
            r2.put(r3)
            int r0 = r0 + 3
            goto L_0x0047
        L_0x005c:
        L_0x005d:
            if (r0 >= r1) goto L_0x00e1
            int r3 = r0 + 1
            byte r3 = r6.get(r3)
            r2.put(r3)
            byte r3 = r6.get(r0)
            r2.put(r3)
            int r0 = r0 + 2
            goto L_0x005d
        L_0x0072:
        L_0x0073:
            if (r0 >= r1) goto L_0x00e1
            int r3 = r0 + 2
            byte r3 = r6.get(r3)
            r2.put(r3)
            int r3 = r0 + 3
            byte r3 = r6.get(r3)
            r2.put(r3)
            int r0 = r0 + 4
            goto L_0x0073
        L_0x008a:
        L_0x008b:
            if (r0 >= r1) goto L_0x00e1
            int r3 = r0 + 1
            byte r3 = r6.get(r3)
            r2.put(r3)
            int r3 = r0 + 2
            byte r3 = r6.get(r3)
            r2.put(r3)
            int r0 = r0 + 3
            goto L_0x008b
        L_0x00a2:
        L_0x00a3:
            if (r0 >= r1) goto L_0x00e1
            float r3 = r6.getFloat(r0)
            r4 = 1065353216(0x3f800000, float:1.0)
            float r3 = java.lang.Math.min(r3, r4)
            r4 = -1082130432(0xffffffffbf800000, float:-1.0)
            float r3 = java.lang.Math.max(r4, r3)
            r4 = 1191181824(0x46fffe00, float:32767.0)
            float r3 = r3 * r4
            int r3 = (int) r3
            short r3 = (short) r3
            r4 = r3 & 255(0xff, float:3.57E-43)
            byte r4 = (byte) r4
            r2.put(r4)
            int r3 = r3 >> 8
            r3 = r3 & 255(0xff, float:3.57E-43)
            byte r3 = (byte) r3
            r2.put(r3)
            int r0 = r0 + 4
            goto L_0x00a3
        L_0x00cc:
            if (r0 >= r1) goto L_0x00e1
            r3 = 0
            r2.put(r3)
            byte r3 = r6.get(r0)
            r3 = r3 & 255(0xff, float:3.57E-43)
            int r3 = r3 + -128
            byte r3 = (byte) r3
            r2.put(r3)
            int r0 = r0 + 1
            goto L_0x00cc
        L_0x00e1:
            int r0 = r6.limit()
            r6.position(r0)
            r2.flip()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzed.zze(java.nio.ByteBuffer):void");
    }

    public final zzdx zzi(zzdx zzdx) throws zzdy {
        int i = zzdx.zzd;
        if (i != 3) {
            if (i == 2) {
                return zzdx.zza;
            }
            if (!(i == 268435456 || i == 21 || i == 1342177280 || i == 22 || i == 1610612736 || i == 4)) {
                throw new zzdy("Unhandled input format:", zzdx);
            }
        }
        return new zzdx(zzdx.zzb, zzdx.zzc, 2);
    }
}
