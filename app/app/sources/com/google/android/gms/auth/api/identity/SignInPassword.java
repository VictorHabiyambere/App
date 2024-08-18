package com.google.android.gms.auth.api.identity;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* compiled from: com.google.android.gms:play-services-auth@@20.7.0 */
public class SignInPassword extends AbstractSafeParcelable {
    public static final Parcelable.Creator<SignInPassword> CREATOR = new zbv();
    private final String zba;
    private final String zbb;

    public SignInPassword(String id, String password) {
        this.zba = Preconditions.checkNotEmpty(((String) Preconditions.checkNotNull(id, "Account identifier cannot be null")).trim(), "Account identifier cannot be empty");
        this.zbb = Preconditions.checkNotEmpty(password);
    }

    public boolean equals(Object o) {
        if (!(o instanceof SignInPassword)) {
            return false;
        }
        SignInPassword signInPassword = (SignInPassword) o;
        if (!Objects.equal(this.zba, signInPassword.zba) || !Objects.equal(this.zbb, signInPassword.zbb)) {
            return false;
        }
        return true;
    }

    public String getId() {
        return this.zba;
    }

    public String getPassword() {
        return this.zbb;
    }

    public int hashCode() {
        return Objects.hashCode(this.zba, this.zbb);
    }

    public void writeToParcel(Parcel dest, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(dest);
        SafeParcelWriter.writeString(dest, 1, getId(), false);
        SafeParcelWriter.writeString(dest, 2, getPassword(), false);
        SafeParcelWriter.finishObjectHeader(dest, beginObjectHeader);
    }
}
