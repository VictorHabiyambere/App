package com.google.android.gms.fido.u2f.api.common;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Base64;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.fido.u2f.api.common.ProtocolVersion;
import java.util.Arrays;
import org.json.JSONException;
import org.json.JSONObject;

@Deprecated
/* compiled from: com.google.android.gms:play-services-fido@@20.1.0 */
public class RegisterRequest extends AbstractSafeParcelable {
    public static final Parcelable.Creator<RegisterRequest> CREATOR = new zzg();
    public static final int U2F_V1_CHALLENGE_BYTE_LENGTH = 65;
    private final int zza;
    private final ProtocolVersion zzb;
    private final byte[] zzc;
    private final String zzd;

    RegisterRequest(int i, String str, byte[] bArr, String str2) {
        this.zza = i;
        try {
            this.zzb = ProtocolVersion.fromString(str);
            this.zzc = bArr;
            this.zzd = str2;
        } catch (ProtocolVersion.UnsupportedProtocolException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public static RegisterRequest parseFromJson(JSONObject registerRequest) throws JSONException {
        String str;
        String str2 = null;
        if (registerRequest.has("version")) {
            str = registerRequest.getString("version");
        } else {
            str = null;
        }
        try {
            ProtocolVersion fromString = ProtocolVersion.fromString(str);
            try {
                byte[] decode = Base64.decode(registerRequest.getString(ClientData.KEY_CHALLENGE), 8);
                if (registerRequest.has("appId")) {
                    str2 = registerRequest.getString("appId");
                }
                try {
                    return new RegisterRequest(fromString, decode, str2);
                } catch (IllegalArgumentException e) {
                    throw new JSONException(e.getMessage());
                }
            } catch (IllegalArgumentException e2) {
                throw new JSONException(e2.toString());
            }
        } catch (ProtocolVersion.UnsupportedProtocolException e3) {
            throw new JSONException(e3.toString());
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RegisterRequest)) {
            return false;
        }
        RegisterRequest registerRequest = (RegisterRequest) obj;
        if (!Arrays.equals(this.zzc, registerRequest.zzc) || this.zzb != registerRequest.zzb) {
            return false;
        }
        String str = this.zzd;
        if (str == null) {
            if (registerRequest.zzd != null) {
                return false;
            }
        } else if (!str.equals(registerRequest.zzd)) {
            return false;
        }
        return true;
    }

    public String getAppId() {
        return this.zzd;
    }

    public byte[] getChallengeValue() {
        return this.zzc;
    }

    public ProtocolVersion getProtocolVersion() {
        return this.zzb;
    }

    public int getVersionCode() {
        return this.zza;
    }

    public int hashCode() {
        int i;
        int hashCode = ((Arrays.hashCode(this.zzc) + 31) * 31) + this.zzb.hashCode();
        String str = this.zzd;
        if (str == null) {
            i = 0;
        } else {
            i = str.hashCode();
        }
        return (hashCode * 31) + i;
    }

    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("version", this.zzb.toString());
            jSONObject.put(ClientData.KEY_CHALLENGE, Base64.encodeToString(this.zzc, 11));
            String str = this.zzd;
            if (str != null) {
                jSONObject.put("appId", str);
            }
            return jSONObject;
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    public void writeToParcel(Parcel dest, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(dest);
        SafeParcelWriter.writeInt(dest, 1, getVersionCode());
        SafeParcelWriter.writeString(dest, 2, this.zzb.toString(), false);
        SafeParcelWriter.writeByteArray(dest, 3, getChallengeValue(), false);
        SafeParcelWriter.writeString(dest, 4, getAppId(), false);
        SafeParcelWriter.finishObjectHeader(dest, beginObjectHeader);
    }

    public RegisterRequest(ProtocolVersion protocolVersion, byte[] challengeValue, String appId) {
        boolean z = true;
        this.zza = 1;
        this.zzb = (ProtocolVersion) Preconditions.checkNotNull(protocolVersion);
        this.zzc = (byte[]) Preconditions.checkNotNull(challengeValue);
        if (protocolVersion == ProtocolVersion.V1) {
            Preconditions.checkArgument(challengeValue.length != 65 ? false : z, "invalid challengeValue length for V1");
        }
        this.zzd = appId;
    }
}
