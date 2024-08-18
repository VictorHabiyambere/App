package com.google.android.gms.fido.fido2.api.common;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: com.google.android.gms:play-services-fido@@20.1.0 */
public enum AttestationConveyancePreference implements Parcelable {
    NONE(DevicePublicKeyStringDef.NONE),
    INDIRECT(DevicePublicKeyStringDef.INDIRECT),
    DIRECT(DevicePublicKeyStringDef.DIRECT);
    
    public static final Parcelable.Creator<AttestationConveyancePreference> CREATOR = null;
    private final String zzb;

    /* compiled from: com.google.android.gms:play-services-fido@@20.1.0 */
    public static class UnsupportedAttestationConveyancePreferenceException extends Exception {
        public UnsupportedAttestationConveyancePreferenceException(String preference) {
            super(String.format("Attestation conveyance preference %s not supported", new Object[]{preference}));
        }
    }

    static {
        CREATOR = new zzb();
    }

    private AttestationConveyancePreference(String str) {
        this.zzb = str;
    }

    public static AttestationConveyancePreference fromString(String value) throws UnsupportedAttestationConveyancePreferenceException {
        for (AttestationConveyancePreference attestationConveyancePreference : values()) {
            if (value.equals(attestationConveyancePreference.zzb)) {
                return attestationConveyancePreference;
            }
        }
        throw new UnsupportedAttestationConveyancePreferenceException(value);
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
