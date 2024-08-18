package com.google.android.gms.fido.u2f.api.common;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Base64;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

@Deprecated
/* compiled from: com.google.android.gms:play-services-fido@@20.1.0 */
public class RegisteredKey extends AbstractSafeParcelable {
    public static final Parcelable.Creator<RegisteredKey> CREATOR = new zzj();
    String zza;
    private final KeyHandle zzb;
    private final String zzc;

    public RegisteredKey(KeyHandle keyHandle) {
        this(keyHandle, (String) null, (String) null);
    }

    public static RegisteredKey parseFromJson(JSONObject signRequest) throws JSONException {
        String str;
        String str2 = null;
        if (signRequest.has(ClientData.KEY_CHALLENGE)) {
            str = signRequest.getString(ClientData.KEY_CHALLENGE);
        } else {
            str = null;
        }
        KeyHandle parseFromJson = KeyHandle.parseFromJson(signRequest);
        if (signRequest.has("appId")) {
            str2 = signRequest.getString("appId");
        }
        return new RegisteredKey(parseFromJson, str, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RegisteredKey)) {
            return false;
        }
        RegisteredKey registeredKey = (RegisteredKey) obj;
        String str = this.zza;
        if (str == null) {
            if (registeredKey.zza != null) {
                return false;
            }
        } else if (!str.equals(registeredKey.zza)) {
            return false;
        }
        if (!this.zzb.equals(registeredKey.zzb)) {
            return false;
        }
        String str2 = this.zzc;
        if (str2 == null) {
            if (registeredKey.zzc != null) {
                return false;
            }
        } else if (!str2.equals(registeredKey.zzc)) {
            return false;
        }
        return true;
    }

    public String getAppId() {
        return this.zzc;
    }

    public String getChallengeValue() {
        return this.zza;
    }

    public KeyHandle getKeyHandle() {
        return this.zzb;
    }

    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            String str = this.zza;
            if (str != null) {
                jSONObject.put(ClientData.KEY_CHALLENGE, str);
            }
            JSONObject zza2 = this.zzb.zza();
            Iterator<String> keys = zza2.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                jSONObject.put(next, zza2.get(next));
            }
            String str2 = this.zzc;
            if (str2 != null) {
                jSONObject.put("appId", str2);
            }
            return jSONObject;
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    public String toString() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(SignResponseData.JSON_RESPONSE_DATA_KEY_HANDLE, Base64.encodeToString(this.zzb.getBytes(), 11));
            if (this.zzb.getProtocolVersion() != ProtocolVersion.UNKNOWN) {
                jSONObject.put("version", this.zzb.getProtocolVersion().toString());
            }
            if (this.zzb.getTransports() != null) {
                jSONObject.put("transports", this.zzb.getTransports().toString());
            }
            String str = this.zza;
            if (str != null) {
                jSONObject.put(ClientData.KEY_CHALLENGE, str);
            }
            String str2 = this.zzc;
            if (str2 != null) {
                jSONObject.put("appId", str2);
            }
            return jSONObject.toString();
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    public void writeToParcel(Parcel dest, int flags) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(dest);
        SafeParcelWriter.writeParcelable(dest, 2, getKeyHandle(), flags, false);
        SafeParcelWriter.writeString(dest, 3, getChallengeValue(), false);
        SafeParcelWriter.writeString(dest, 4, getAppId(), false);
        SafeParcelWriter.finishObjectHeader(dest, beginObjectHeader);
    }

    public RegisteredKey(KeyHandle keyHandle, String challengeValue, String appId) {
        this.zzb = (KeyHandle) Preconditions.checkNotNull(keyHandle);
        this.zza = challengeValue;
        this.zzc = appId;
    }

    public int hashCode() {
        int i;
        String str = this.zza;
        int i2 = 0;
        if (str == null) {
            i = 0;
        } else {
            i = str.hashCode();
        }
        int hashCode = ((i + 31) * 31) + this.zzb.hashCode();
        String str2 = this.zzc;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        return (hashCode * 31) + i2;
    }
}
