package com.google.android.gms.ads.internal.client;

import android.os.Parcelable;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.2.0 */
public final class zzr implements Parcelable.Creator {
    /* JADX WARNING: type inference failed for: r2v3, types: [java.lang.Object[]] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* bridge */ /* synthetic */ java.lang.Object createFromParcel(android.os.Parcel r21) {
        /*
            r20 = this;
            r0 = r21
            int r1 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.validateObjectHeader(r21)
            r2 = 0
            r3 = 0
            r6 = r2
            r7 = r6
            r8 = r7
            r9 = r8
            r10 = r9
            r12 = r10
            r13 = r12
            r14 = r13
            r15 = r14
            r16 = r15
            r17 = r16
            r18 = r17
            r19 = r18
            r5 = r3
            r11 = r5
        L_0x001b:
            int r2 = r21.dataPosition()
            if (r2 >= r1) goto L_0x0080
            int r2 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readHeader(r21)
            int r3 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.getFieldId(r2)
            switch(r3) {
                case 2: goto L_0x007b;
                case 3: goto L_0x0076;
                case 4: goto L_0x0071;
                case 5: goto L_0x006c;
                case 6: goto L_0x0067;
                case 7: goto L_0x0062;
                case 8: goto L_0x0058;
                case 9: goto L_0x0053;
                case 10: goto L_0x004e;
                case 11: goto L_0x0049;
                case 12: goto L_0x0044;
                case 13: goto L_0x003f;
                case 14: goto L_0x003a;
                case 15: goto L_0x0035;
                case 16: goto L_0x0030;
                default: goto L_0x002c;
            }
        L_0x002c:
            com.google.android.gms.common.internal.safeparcel.SafeParcelReader.skipUnknownField(r0, r2)
            goto L_0x001b
        L_0x0030:
            boolean r19 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readBoolean(r0, r2)
            goto L_0x001b
        L_0x0035:
            boolean r18 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readBoolean(r0, r2)
            goto L_0x001b
        L_0x003a:
            boolean r17 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readBoolean(r0, r2)
            goto L_0x001b
        L_0x003f:
            boolean r16 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readBoolean(r0, r2)
            goto L_0x001b
        L_0x0044:
            boolean r15 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readBoolean(r0, r2)
            goto L_0x001b
        L_0x0049:
            boolean r14 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readBoolean(r0, r2)
            goto L_0x001b
        L_0x004e:
            boolean r13 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readBoolean(r0, r2)
            goto L_0x001b
        L_0x0053:
            boolean r12 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readBoolean(r0, r2)
            goto L_0x001b
        L_0x0058:
            android.os.Parcelable$Creator<com.google.android.gms.ads.internal.client.zzq> r3 = com.google.android.gms.ads.internal.client.zzq.CREATOR
            java.lang.Object[] r2 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createTypedArray(r0, r2, r3)
            r11 = r2
            com.google.android.gms.ads.internal.client.zzq[] r11 = (com.google.android.gms.ads.internal.client.zzq[]) r11
            goto L_0x001b
        L_0x0062:
            int r10 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readInt(r0, r2)
            goto L_0x001b
        L_0x0067:
            int r9 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readInt(r0, r2)
            goto L_0x001b
        L_0x006c:
            boolean r8 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readBoolean(r0, r2)
            goto L_0x001b
        L_0x0071:
            int r7 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readInt(r0, r2)
            goto L_0x001b
        L_0x0076:
            int r6 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readInt(r0, r2)
            goto L_0x001b
        L_0x007b:
            java.lang.String r5 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createString(r0, r2)
            goto L_0x001b
        L_0x0080:
            com.google.android.gms.common.internal.safeparcel.SafeParcelReader.ensureAtEnd(r0, r1)
            com.google.android.gms.ads.internal.client.zzq r0 = new com.google.android.gms.ads.internal.client.zzq
            r4 = r0
            r4.<init>(r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.client.zzr.createFromParcel(android.os.Parcel):java.lang.Object");
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new zzq[i];
    }
}
