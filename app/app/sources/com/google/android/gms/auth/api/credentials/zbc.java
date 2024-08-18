package com.google.android.gms.auth.api.credentials;

import android.os.Parcelable;

/* compiled from: com.google.android.gms:play-services-auth@@20.7.0 */
public final class zbc implements Parcelable.Creator {
    /* JADX WARNING: type inference failed for: r1v3, types: [android.os.Parcelable] */
    /* JADX WARNING: type inference failed for: r1v4, types: [android.os.Parcelable] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* bridge */ /* synthetic */ java.lang.Object createFromParcel(android.os.Parcel r14) {
        /*
            r13 = this;
            int r0 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.validateObjectHeader(r14)
            r1 = 0
            r2 = 0
            r4 = r1
            r5 = r4
            r9 = r5
            r12 = r9
            r6 = r2
            r7 = r6
            r8 = r7
            r10 = r8
            r11 = r10
        L_0x000f:
            int r1 = r14.dataPosition()
            if (r1 >= r0) goto L_0x005b
            int r1 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readHeader(r14)
            int r2 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.getFieldId(r1)
            switch(r2) {
                case 1: goto L_0x0056;
                case 2: goto L_0x0051;
                case 3: goto L_0x0047;
                case 4: goto L_0x003d;
                case 5: goto L_0x0038;
                case 6: goto L_0x0033;
                case 7: goto L_0x002e;
                case 8: goto L_0x0029;
                case 1000: goto L_0x0024;
                default: goto L_0x0020;
            }
        L_0x0020:
            com.google.android.gms.common.internal.safeparcel.SafeParcelReader.skipUnknownField(r14, r1)
            goto L_0x000f
        L_0x0024:
            int r4 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readInt(r14, r1)
            goto L_0x000f
        L_0x0029:
            boolean r12 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readBoolean(r14, r1)
            goto L_0x000f
        L_0x002e:
            java.lang.String r11 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createString(r14, r1)
            goto L_0x000f
        L_0x0033:
            java.lang.String r10 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createString(r14, r1)
            goto L_0x000f
        L_0x0038:
            boolean r9 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readBoolean(r14, r1)
            goto L_0x000f
        L_0x003d:
            android.os.Parcelable$Creator<com.google.android.gms.auth.api.credentials.CredentialPickerConfig> r2 = com.google.android.gms.auth.api.credentials.CredentialPickerConfig.CREATOR
            android.os.Parcelable r1 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createParcelable(r14, r1, r2)
            r8 = r1
            com.google.android.gms.auth.api.credentials.CredentialPickerConfig r8 = (com.google.android.gms.auth.api.credentials.CredentialPickerConfig) r8
            goto L_0x000f
        L_0x0047:
            android.os.Parcelable$Creator<com.google.android.gms.auth.api.credentials.CredentialPickerConfig> r2 = com.google.android.gms.auth.api.credentials.CredentialPickerConfig.CREATOR
            android.os.Parcelable r1 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createParcelable(r14, r1, r2)
            r7 = r1
            com.google.android.gms.auth.api.credentials.CredentialPickerConfig r7 = (com.google.android.gms.auth.api.credentials.CredentialPickerConfig) r7
            goto L_0x000f
        L_0x0051:
            java.lang.String[] r6 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createStringArray(r14, r1)
            goto L_0x000f
        L_0x0056:
            boolean r5 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readBoolean(r14, r1)
            goto L_0x000f
        L_0x005b:
            com.google.android.gms.common.internal.safeparcel.SafeParcelReader.ensureAtEnd(r14, r0)
            com.google.android.gms.auth.api.credentials.CredentialRequest r14 = new com.google.android.gms.auth.api.credentials.CredentialRequest
            r3 = r14
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12)
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.auth.api.credentials.zbc.createFromParcel(android.os.Parcel):java.lang.Object");
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new CredentialRequest[i];
    }
}
