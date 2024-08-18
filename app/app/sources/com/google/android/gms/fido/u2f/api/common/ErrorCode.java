package com.google.android.gms.fido.u2f.api.common;

import android.os.Parcel;
import android.os.Parcelable;

@Deprecated
/* compiled from: com.google.android.gms:play-services-fido@@20.1.0 */
public enum ErrorCode implements Parcelable {
    OK(0),
    OTHER_ERROR(1),
    BAD_REQUEST(2),
    CONFIGURATION_UNSUPPORTED(3),
    DEVICE_INELIGIBLE(4),
    TIMEOUT(5);
    
    public static final Parcelable.Creator<ErrorCode> CREATOR = null;
    private static final String zza = null;
    private final int zzc;

    static {
        zza = ErrorCode.class.getSimpleName();
        CREATOR = new zzc();
    }

    private ErrorCode(int i) {
        this.zzc = i;
    }

    public static ErrorCode toErrorCode(int code) {
        for (ErrorCode errorCode : values()) {
            if (code == errorCode.zzc) {
                return errorCode;
            }
        }
        return OTHER_ERROR;
    }

    public int describeContents() {
        return 0;
    }

    public int getCode() {
        return this.zzc;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.zzc);
    }
}
