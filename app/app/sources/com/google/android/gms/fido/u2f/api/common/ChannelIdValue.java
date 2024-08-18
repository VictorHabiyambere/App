package com.google.android.gms.fido.u2f.api.common;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import org.json.JSONException;
import org.json.JSONObject;

@Deprecated
/* compiled from: com.google.android.gms:play-services-fido@@20.1.0 */
public class ChannelIdValue extends AbstractSafeParcelable {
    public static final ChannelIdValue ABSENT = new ChannelIdValue();
    public static final Parcelable.Creator<ChannelIdValue> CREATOR = new zzb();
    public static final ChannelIdValue UNAVAILABLE = new ChannelIdValue("unavailable");
    public static final ChannelIdValue UNUSED = new ChannelIdValue("unused");
    private final ChannelIdValueType zza;
    private final String zzb;
    private final String zzc;

    /* compiled from: com.google.android.gms:play-services-fido@@20.1.0 */
    public enum ChannelIdValueType implements Parcelable {
        ABSENT(0),
        STRING(1),
        OBJECT(2);
        
        public static final Parcelable.Creator<ChannelIdValueType> CREATOR = null;
        /* access modifiers changed from: private */
        public final int zzb;

        static {
            CREATOR = new zza();
        }

        private ChannelIdValueType(int i) {
            this.zzb = i;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.zzb);
        }
    }

    /* compiled from: com.google.android.gms:play-services-fido@@20.1.0 */
    public static class UnsupportedChannelIdValueTypeException extends Exception {
        public UnsupportedChannelIdValueTypeException(int type) {
            super(String.format("ChannelIdValueType %s not supported", new Object[]{Integer.valueOf(type)}));
        }
    }

    private ChannelIdValue() {
        this.zza = ChannelIdValueType.ABSENT;
        this.zzc = null;
        this.zzb = null;
    }

    public static ChannelIdValueType toChannelIdValueType(int type) throws UnsupportedChannelIdValueTypeException {
        for (ChannelIdValueType channelIdValueType : ChannelIdValueType.values()) {
            if (type == channelIdValueType.zzb) {
                return channelIdValueType;
            }
        }
        throw new UnsupportedChannelIdValueTypeException(type);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ChannelIdValue)) {
            return false;
        }
        ChannelIdValue channelIdValue = (ChannelIdValue) other;
        if (!this.zza.equals(channelIdValue.zza)) {
            return false;
        }
        switch (this.zza.ordinal()) {
            case 0:
                return true;
            case 1:
                return this.zzb.equals(channelIdValue.zzb);
            case 2:
                return this.zzc.equals(channelIdValue.zzc);
            default:
                return false;
        }
    }

    public JSONObject getObjectValue() {
        if (this.zzc == null) {
            return null;
        }
        try {
            return new JSONObject(this.zzc);
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    public String getObjectValueAsString() {
        return this.zzc;
    }

    public String getStringValue() {
        return this.zzb;
    }

    public ChannelIdValueType getType() {
        return this.zza;
    }

    public int getTypeAsInt() {
        return this.zza.zzb;
    }

    public int hashCode() {
        int hashCode = this.zza.hashCode() + 31;
        switch (this.zza.ordinal()) {
            case 0:
                return hashCode;
            case 1:
                return (hashCode * 31) + this.zzb.hashCode();
            case 2:
                return (hashCode * 31) + this.zzc.hashCode();
            default:
                return hashCode;
        }
    }

    public void writeToParcel(Parcel dest, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(dest);
        SafeParcelWriter.writeInt(dest, 2, getTypeAsInt());
        SafeParcelWriter.writeString(dest, 3, getStringValue(), false);
        SafeParcelWriter.writeString(dest, 4, getObjectValueAsString(), false);
        SafeParcelWriter.finishObjectHeader(dest, beginObjectHeader);
    }

    ChannelIdValue(int i, String str, String str2) {
        try {
            this.zza = toChannelIdValueType(i);
            this.zzb = str;
            this.zzc = str2;
        } catch (UnsupportedChannelIdValueTypeException e) {
            throw new IllegalArgumentException(e);
        }
    }

    private ChannelIdValue(String str) {
        this.zzb = (String) Preconditions.checkNotNull(str);
        this.zza = ChannelIdValueType.STRING;
        this.zzc = null;
    }

    public ChannelIdValue(JSONObject value) {
        this.zzc = (String) Preconditions.checkNotNull(value.toString());
        this.zza = ChannelIdValueType.OBJECT;
        this.zzb = null;
    }
}
