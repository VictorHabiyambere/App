package com.google.android.gms.fido.u2f.api.common;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Base64;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.util.Base64Utils;
import com.google.android.gms.fido.common.Transport;
import com.google.android.gms.fido.u2f.api.common.ProtocolVersion;
import java.util.Arrays;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Deprecated
/* compiled from: com.google.android.gms:play-services-fido@@20.1.0 */
public class KeyHandle extends AbstractSafeParcelable {
    public static final Parcelable.Creator<KeyHandle> CREATOR = new zze();
    private final int zza;
    private final byte[] zzb;
    private final ProtocolVersion zzc;
    private final List zzd;

    KeyHandle(int i, byte[] bArr, String str, List list) {
        this.zza = i;
        this.zzb = bArr;
        try {
            this.zzc = ProtocolVersion.fromString(str);
            this.zzd = list;
        } catch (ProtocolVersion.UnsupportedProtocolException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public static KeyHandle parseFromJson(JSONObject registeredKey) throws JSONException {
        String str;
        List<Transport> list = null;
        if (registeredKey.has("version")) {
            str = registeredKey.getString("version");
        } else {
            str = null;
        }
        try {
            ProtocolVersion fromString = ProtocolVersion.fromString(str);
            try {
                byte[] decode = Base64.decode(registeredKey.getString(SignResponseData.JSON_RESPONSE_DATA_KEY_HANDLE), 8);
                if (registeredKey.has("transports")) {
                    list = Transport.parseTransports(registeredKey.getJSONArray("transports"));
                }
                return new KeyHandle(decode, fromString, list);
            } catch (IllegalArgumentException e) {
                throw new JSONException(e.toString());
            }
        } catch (ProtocolVersion.UnsupportedProtocolException e2) {
            throw new JSONException(e2.toString());
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x002f, code lost:
        r3 = r5.zzd;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(java.lang.Object r5) {
        /*
            r4 = this;
            r0 = 1
            if (r4 != r5) goto L_0x0005
            return r0
        L_0x0005:
            boolean r1 = r5 instanceof com.google.android.gms.fido.u2f.api.common.KeyHandle
            r2 = 0
            if (r1 != 0) goto L_0x000b
            return r2
        L_0x000b:
            com.google.android.gms.fido.u2f.api.common.KeyHandle r5 = (com.google.android.gms.fido.u2f.api.common.KeyHandle) r5
            byte[] r1 = r4.zzb
            byte[] r3 = r5.zzb
            boolean r1 = java.util.Arrays.equals(r1, r3)
            if (r1 != 0) goto L_0x0018
            return r2
        L_0x0018:
            com.google.android.gms.fido.u2f.api.common.ProtocolVersion r1 = r4.zzc
            com.google.android.gms.fido.u2f.api.common.ProtocolVersion r3 = r5.zzc
            boolean r1 = r1.equals(r3)
            if (r1 != 0) goto L_0x0023
            return r2
        L_0x0023:
            java.util.List r1 = r4.zzd
            if (r1 != 0) goto L_0x002d
            java.util.List r3 = r5.zzd
            if (r3 == 0) goto L_0x002c
            goto L_0x002d
        L_0x002c:
            return r0
        L_0x002d:
            if (r1 == 0) goto L_0x0046
            java.util.List r3 = r5.zzd
            if (r3 != 0) goto L_0x0034
            goto L_0x0046
        L_0x0034:
            boolean r1 = r1.containsAll(r3)
            if (r1 == 0) goto L_0x0045
            java.util.List r5 = r5.zzd
            java.util.List r1 = r4.zzd
            boolean r5 = r5.containsAll(r1)
            if (r5 == 0) goto L_0x0045
            return r0
        L_0x0045:
            return r2
        L_0x0046:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.fido.u2f.api.common.KeyHandle.equals(java.lang.Object):boolean");
    }

    public byte[] getBytes() {
        return this.zzb;
    }

    public ProtocolVersion getProtocolVersion() {
        return this.zzc;
    }

    public List<Transport> getTransports() {
        return this.zzd;
    }

    public int getVersionCode() {
        return this.zza;
    }

    public int hashCode() {
        return Objects.hashCode(Integer.valueOf(Arrays.hashCode(this.zzb)), this.zzc, this.zzd);
    }

    public JSONObject toJson() {
        return zza();
    }

    public void writeToParcel(Parcel dest, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(dest);
        SafeParcelWriter.writeInt(dest, 1, getVersionCode());
        SafeParcelWriter.writeByteArray(dest, 2, getBytes(), false);
        SafeParcelWriter.writeString(dest, 3, this.zzc.toString(), false);
        SafeParcelWriter.writeTypedList(dest, 4, getTransports(), false);
        SafeParcelWriter.finishObjectHeader(dest, beginObjectHeader);
    }

    public final JSONObject zza() {
        JSONObject jSONObject = new JSONObject();
        try {
            byte[] bArr = this.zzb;
            if (bArr != null) {
                jSONObject.put(SignResponseData.JSON_RESPONSE_DATA_KEY_HANDLE, Base64.encodeToString(bArr, 11));
            }
            ProtocolVersion protocolVersion = this.zzc;
            if (protocolVersion != null) {
                jSONObject.put("version", protocolVersion.toString());
            }
            if (this.zzd != null) {
                JSONArray jSONArray = new JSONArray();
                for (Transport transport : this.zzd) {
                    jSONArray.put(transport.toString());
                }
                jSONObject.put("transports", jSONArray);
            }
            return jSONObject;
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    public String toString() {
        String str;
        List list = this.zzd;
        if (list == null) {
            str = "null";
        } else {
            str = list.toString();
        }
        return String.format("{keyHandle: %s, version: %s, transports: %s}", new Object[]{Base64Utils.encode(this.zzb), this.zzc, str});
    }

    public KeyHandle(byte[] keyHandleBytes, ProtocolVersion protocolVersion, List<Transport> transports) {
        this.zza = 1;
        this.zzb = keyHandleBytes;
        this.zzc = protocolVersion;
        this.zzd = transports;
    }
}
