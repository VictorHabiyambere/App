package com.google.android.gms.ads.internal.util.client;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.2.0 */
public final class VersionInfoParcel extends AbstractSafeParcelable {
    public static final Parcelable.Creator<VersionInfoParcel> CREATOR = new zzs();
    public String afmaVersion;
    public int buddyApkVersion;
    public int clientJarVersion;
    public boolean isClientJar;
    public boolean isLiteSdk;

    public VersionInfoParcel(int buddyApkVersion2, int clientJarVersion2, boolean isClientJar2) {
        this(buddyApkVersion2, clientJarVersion2, isClientJar2, false, false);
    }

    public static VersionInfoParcel forPackage() {
        return new VersionInfoParcel(12451000, 12451000, true);
    }

    public void writeToParcel(Parcel out, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(out);
        SafeParcelWriter.writeString(out, 2, this.afmaVersion, false);
        SafeParcelWriter.writeInt(out, 3, this.buddyApkVersion);
        SafeParcelWriter.writeInt(out, 4, this.clientJarVersion);
        SafeParcelWriter.writeBoolean(out, 5, this.isClientJar);
        SafeParcelWriter.writeBoolean(out, 6, this.isLiteSdk);
        SafeParcelWriter.finishObjectHeader(out, beginObjectHeader);
    }

    public VersionInfoParcel(int buddyApkVersion2, int clientJarVersion2, boolean isClientJar2, boolean isLiteSdk2) {
        this(buddyApkVersion2, clientJarVersion2, isClientJar2, false, isLiteSdk2);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public VersionInfoParcel(int r9, int r10, boolean r11, boolean r12, boolean r13) {
        /*
            r8 = this;
            if (r11 == 0) goto L_0x0006
            java.lang.String r12 = "0"
            goto L_0x000d
        L_0x0006:
            if (r12 == 0) goto L_0x000b
            java.lang.String r12 = "2"
            goto L_0x000d
        L_0x000b:
            java.lang.String r12 = "1"
        L_0x000d:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "afma-sdk-a-v"
            r0.append(r1)
            r0.append(r9)
            java.lang.String r1 = "."
            r0.append(r1)
            r0.append(r10)
            r0.append(r1)
            r0.append(r12)
            java.lang.String r3 = r0.toString()
            r2 = r8
            r4 = r9
            r5 = r10
            r6 = r11
            r7 = r13
            r2.<init>((java.lang.String) r3, (int) r4, (int) r5, (boolean) r6, (boolean) r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.util.client.VersionInfoParcel.<init>(int, int, boolean, boolean, boolean):void");
    }

    VersionInfoParcel(String str, int i, int i2, boolean z, boolean z2) {
        this.afmaVersion = str;
        this.buddyApkVersion = i;
        this.clientJarVersion = i2;
        this.isClientJar = z;
        this.isLiteSdk = z2;
    }
}
