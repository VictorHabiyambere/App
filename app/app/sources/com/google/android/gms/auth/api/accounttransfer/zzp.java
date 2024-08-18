package com.google.android.gms.auth.api.accounttransfer;

import android.os.Parcelable;

/* compiled from: com.google.android.gms:play-services-auth-base@@18.0.4 */
public final class zzp implements Parcelable.Creator {
    /* JADX WARNING: type inference failed for: r1v12, types: [android.os.Parcelable] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* bridge */ /* synthetic */ java.lang.Object createFromParcel(android.os.Parcel r9) {
        /*
            r8 = this;
            int r0 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.validateObjectHeader(r9)
            java.util.HashSet r2 = new java.util.HashSet
            r2.<init>()
            r1 = 0
            r3 = 0
            r5 = r1
            r4 = r3
            r6 = r4
            r3 = r5
        L_0x000f:
            int r1 = r9.dataPosition()
            if (r1 >= r0) goto L_0x005f
            int r1 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readHeader(r9)
            int r7 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.getFieldId(r1)
            switch(r7) {
                case 1: goto L_0x0052;
                case 2: goto L_0x0043;
                case 3: goto L_0x0036;
                case 4: goto L_0x0024;
                default: goto L_0x0020;
            }
        L_0x0020:
            com.google.android.gms.common.internal.safeparcel.SafeParcelReader.skipUnknownField(r9, r1)
            goto L_0x005e
        L_0x0024:
            android.os.Parcelable$Creator<com.google.android.gms.auth.api.accounttransfer.zzs> r6 = com.google.android.gms.auth.api.accounttransfer.zzs.CREATOR
            android.os.Parcelable r1 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createParcelable(r9, r1, r6)
            r6 = r1
            com.google.android.gms.auth.api.accounttransfer.zzs r6 = (com.google.android.gms.auth.api.accounttransfer.zzs) r6
            r1 = 4
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r2.add(r1)
            goto L_0x005e
        L_0x0036:
            int r5 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readInt(r9, r1)
            r1 = 3
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r2.add(r1)
            goto L_0x005e
        L_0x0043:
            android.os.Parcelable$Creator<com.google.android.gms.auth.api.accounttransfer.zzu> r4 = com.google.android.gms.auth.api.accounttransfer.zzu.CREATOR
            java.util.ArrayList r4 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createTypedList(r9, r1, r4)
            r1 = 2
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r2.add(r1)
            goto L_0x005e
        L_0x0052:
            int r3 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readInt(r9, r1)
            r1 = 1
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r2.add(r1)
        L_0x005e:
            goto L_0x000f
        L_0x005f:
            int r1 = r9.dataPosition()
            if (r1 != r0) goto L_0x006c
            com.google.android.gms.auth.api.accounttransfer.zzo r9 = new com.google.android.gms.auth.api.accounttransfer.zzo
            r1 = r9
            r1.<init>(r2, r3, r4, r5, r6)
            return r9
        L_0x006c:
            com.google.android.gms.common.internal.safeparcel.SafeParcelReader$ParseException r1 = new com.google.android.gms.common.internal.safeparcel.SafeParcelReader$ParseException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Overread allowed size end="
            r2.append(r3)
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            r1.<init>(r0, r9)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.auth.api.accounttransfer.zzp.createFromParcel(android.os.Parcel):java.lang.Object");
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new zzo[i];
    }
}
