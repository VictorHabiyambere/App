package com.google.android.gms.fido.fido2.api.common;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: com.google.android.gms:play-services-fido@@20.1.0 */
public enum PublicKeyCredentialType implements Parcelable {
    PUBLIC_KEY("public-key");
    
    public static final Parcelable.Creator<PublicKeyCredentialType> CREATOR = null;
    private final String zzb;

    /* compiled from: com.google.android.gms:play-services-fido@@20.1.0 */
    public static class UnsupportedPublicKeyCredTypeException extends Exception {
        public UnsupportedPublicKeyCredTypeException(String errorMessage) {
            super(errorMessage);
        }
    }

    static {
        CREATOR = new zzaq();
    }

    private PublicKeyCredentialType(String str) {
        this.zzb = "public-key";
    }

    public static PublicKeyCredentialType fromString(String value) throws UnsupportedPublicKeyCredTypeException {
        for (PublicKeyCredentialType publicKeyCredentialType : values()) {
            if (value.equals(publicKeyCredentialType.zzb)) {
                return publicKeyCredentialType;
            }
        }
        throw new UnsupportedPublicKeyCredTypeException(String.format("PublicKeyCredentialType %s not supported", new Object[]{value}));
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        return this.zzb;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.zzb);
    }
}
