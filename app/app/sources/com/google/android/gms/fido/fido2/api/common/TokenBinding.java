package com.google.android.gms.fido.fido2.api.common;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.core.app.NotificationCompat;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.internal.fido.zzao;
import java.util.Arrays;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-fido@@20.1.0 */
public class TokenBinding extends AbstractSafeParcelable {
    public static final Parcelable.Creator<TokenBinding> CREATOR = new zzau();
    public static final TokenBinding NOT_SUPPORTED = new TokenBinding(TokenBindingStatus.NOT_SUPPORTED.toString(), (String) null);
    public static final TokenBinding SUPPORTED = new TokenBinding(TokenBindingStatus.SUPPORTED.toString(), (String) null);
    private final TokenBindingStatus zza;
    private final String zzb;

    /* compiled from: com.google.android.gms:play-services-fido@@20.1.0 */
    public enum TokenBindingStatus implements Parcelable {
        PRESENT("present"),
        SUPPORTED("supported"),
        NOT_SUPPORTED("not-supported");
        
        public static final Parcelable.Creator<TokenBindingStatus> CREATOR = null;
        private final String zzb;

        static {
            CREATOR = new zzat();
        }

        private TokenBindingStatus(String str) {
            this.zzb = str;
        }

        public static TokenBindingStatus fromString(String tokenBindingStatusAsString) throws UnsupportedTokenBindingStatusException {
            for (TokenBindingStatus tokenBindingStatus : values()) {
                if (tokenBindingStatusAsString.equals(tokenBindingStatus.zzb)) {
                    return tokenBindingStatus;
                }
            }
            throw new UnsupportedTokenBindingStatusException(tokenBindingStatusAsString);
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

    /* compiled from: com.google.android.gms:play-services-fido@@20.1.0 */
    public static class UnsupportedTokenBindingStatusException extends Exception {
        public UnsupportedTokenBindingStatusException(String unsupportedTokenBindingStatus) {
            super(String.format("TokenBindingStatus %s not supported", new Object[]{unsupportedTokenBindingStatus}));
        }
    }

    public TokenBinding(String tokenBindingId) {
        this(TokenBindingStatus.PRESENT.toString(), (String) Preconditions.checkNotNull(tokenBindingId));
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof TokenBinding)) {
            return false;
        }
        TokenBinding tokenBinding = (TokenBinding) obj;
        if (!zzao.zza(this.zza, tokenBinding.zza) || !zzao.zza(this.zzb, tokenBinding.zzb)) {
            return false;
        }
        return true;
    }

    public String getTokenBindingId() {
        return this.zzb;
    }

    public String getTokenBindingStatusAsString() {
        return this.zza.toString();
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.zza, this.zzb});
    }

    public JSONObject toJsonObject() throws JSONException {
        try {
            return new JSONObject().put(NotificationCompat.CATEGORY_STATUS, this.zza).put("id", this.zzb);
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    public void writeToParcel(Parcel dest, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(dest);
        SafeParcelWriter.writeString(dest, 2, getTokenBindingStatusAsString(), false);
        SafeParcelWriter.writeString(dest, 3, getTokenBindingId(), false);
        SafeParcelWriter.finishObjectHeader(dest, beginObjectHeader);
    }

    TokenBinding(String str, String str2) {
        Preconditions.checkNotNull(str);
        try {
            this.zza = TokenBindingStatus.fromString(str);
            this.zzb = str2;
        } catch (UnsupportedTokenBindingStatusException e) {
            throw new IllegalArgumentException(e);
        }
    }
}
