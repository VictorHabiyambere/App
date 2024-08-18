package com.google.android.gms.fido.u2f.api.common;

import android.os.Parcel;
import android.os.Parcelable;
import java.io.UnsupportedEncodingException;

@Deprecated
/* compiled from: com.google.android.gms:play-services-fido@@20.1.0 */
public enum ProtocolVersion implements Parcelable {
    UNKNOWN("UNKNOWN"),
    V1("U2F_V1"),
    V2("U2F_V2");
    
    public static final Parcelable.Creator<ProtocolVersion> CREATOR = null;
    private final String zzb;

    /* compiled from: com.google.android.gms:play-services-fido@@20.1.0 */
    public static class UnsupportedProtocolException extends Exception {
        public UnsupportedProtocolException(String version) {
            super(String.format("Protocol version %s not supported", new Object[]{version}));
        }
    }

    static {
        CREATOR = new zzf();
    }

    private ProtocolVersion(String str) {
        this.zzb = str;
    }

    public static ProtocolVersion fromBytes(byte[] value) throws UnsupportedProtocolException {
        try {
            return fromString(new String(value, "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    public static ProtocolVersion fromString(String value) throws UnsupportedProtocolException {
        if (value == null) {
            return UNKNOWN;
        }
        for (ProtocolVersion protocolVersion : values()) {
            if (value.equals(protocolVersion.zzb)) {
                return protocolVersion;
            }
        }
        throw new UnsupportedProtocolException(value);
    }

    public int describeContents() {
        return 0;
    }

    public boolean isCompatible(ProtocolVersion otherVersion) {
        if (equals(UNKNOWN) || otherVersion.equals(UNKNOWN)) {
            return true;
        }
        return equals(otherVersion);
    }

    public String toString() {
        return this.zzb;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.zzb);
    }
}
