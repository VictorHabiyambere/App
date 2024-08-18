package com.google.android.gms.fido.u2f.api.common;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.fido.u2f.api.common.ChannelIdValue;
import org.json.JSONException;
import org.json.JSONObject;

@Deprecated
/* compiled from: com.google.android.gms:play-services-fido@@20.1.0 */
public class ClientData {
    public static final String KEY_CHALLENGE = "challenge";
    public static final String KEY_CID_PUBKEY = "cid_pubkey";
    public static final String KEY_ORIGIN = "origin";
    public static final String KEY_TYPE = "typ";
    public static final String TYPE_FINISH_ENROLLMENT = "navigator.id.finishEnrollment";
    public static final String TYPE_GET_ASSERTION = "navigator.id.getAssertion";
    private final String zza;
    private final String zzb;
    private final String zzc;
    private final ChannelIdValue zzd;

    /* compiled from: com.google.android.gms:play-services-fido@@20.1.0 */
    public static class Builder implements Cloneable {
        private String zza;
        private String zzb;
        private String zzc;
        private ChannelIdValue zzd;

        Builder() {
            this.zzd = ChannelIdValue.ABSENT;
        }

        Builder(String str, String str2, String str3, ChannelIdValue channelIdValue) {
            this.zza = str;
            this.zzb = str2;
            this.zzc = str3;
            this.zzd = channelIdValue;
        }

        public static Builder newInstance() {
            return new Builder();
        }

        public ClientData build() {
            return new ClientData(this.zza, this.zzb, this.zzc, this.zzd);
        }

        public Builder clone() {
            return new Builder(this.zza, this.zzb, this.zzc, this.zzd);
        }

        public Builder setChallenge(String str) {
            this.zzb = str;
            return this;
        }

        public Builder setChannelId(ChannelIdValue channelIdValue) {
            this.zzd = channelIdValue;
            return this;
        }

        public Builder setOrigin(String str) {
            this.zzc = str;
            return this;
        }

        public Builder setType(String str) {
            this.zza = str;
            return this;
        }
    }

    ClientData(String str, String str2, String str3, ChannelIdValue channelIdValue) {
        this.zza = (String) Preconditions.checkNotNull(str);
        this.zzb = (String) Preconditions.checkNotNull(str2);
        this.zzc = (String) Preconditions.checkNotNull(str3);
        this.zzd = (ChannelIdValue) Preconditions.checkNotNull(channelIdValue);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ClientData)) {
            return false;
        }
        ClientData clientData = (ClientData) other;
        return this.zza.equals(clientData.zza) && this.zzb.equals(clientData.zzb) && this.zzc.equals(clientData.zzc) && this.zzd.equals(clientData.zzd);
    }

    public int hashCode() {
        return ((((((this.zza.hashCode() + 31) * 31) + this.zzb.hashCode()) * 31) + this.zzc.hashCode()) * 31) + this.zzd.hashCode();
    }

    public String toJsonString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(KEY_TYPE, this.zza);
            jSONObject.put(KEY_CHALLENGE, this.zzb);
            jSONObject.put("origin", this.zzc);
            ChannelIdValue.ChannelIdValueType channelIdValueType = ChannelIdValue.ChannelIdValueType.ABSENT;
            switch (this.zzd.getType().ordinal()) {
                case 1:
                    jSONObject.put(KEY_CID_PUBKEY, this.zzd.getStringValue());
                    break;
                case 2:
                    jSONObject.put(KEY_CID_PUBKEY, this.zzd.getObjectValue());
                    break;
            }
            return jSONObject.toString();
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }
}
