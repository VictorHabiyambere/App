package com.google.android.gms.fido.common;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import com.google.android.gms.common.internal.ReflectedParcelable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;

/* compiled from: com.google.android.gms:play-services-fido@@20.1.0 */
public enum Transport implements ReflectedParcelable {
    BLUETOOTH_CLASSIC("bt"),
    BLUETOOTH_LOW_ENERGY("ble"),
    NFC("nfc"),
    USB("usb"),
    INTERNAL("internal"),
    HYBRID("cable");
    
    public static final Parcelable.Creator<Transport> CREATOR = null;
    private final String zzb;

    /* compiled from: com.google.android.gms:play-services-fido@@20.1.0 */
    public static class UnsupportedTransportException extends Exception {
        public UnsupportedTransportException(String errorMessage) {
            super(errorMessage);
        }
    }

    static {
        CREATOR = new zza();
    }

    private Transport(String str) {
        this.zzb = str;
    }

    public static Transport fromString(String value) throws UnsupportedTransportException {
        for (Transport transport : values()) {
            if (value.equals(transport.zzb)) {
                return transport;
            }
        }
        if (value.equals("hybrid")) {
            return HYBRID;
        }
        throw new UnsupportedTransportException(String.format("Transport %s not supported", new Object[]{value}));
    }

    public static List<Transport> parseTransports(JSONArray transports) throws JSONException {
        if (transports == null) {
            return null;
        }
        HashSet hashSet = new HashSet(transports.length());
        for (int i = 0; i < transports.length(); i++) {
            String string = transports.getString(i);
            if (string != null && !string.isEmpty()) {
                try {
                    hashSet.add(fromString(string));
                } catch (UnsupportedTransportException e) {
                    Log.w("Transport", "Ignoring unrecognized transport ".concat(string));
                }
            }
        }
        return new ArrayList(hashSet);
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
