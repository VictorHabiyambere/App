package com.google.android.gms.auth.api.identity;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.fido.fido2.api.common.PublicKeyCredential;

/* compiled from: com.google.android.gms:play-services-auth@@20.7.0 */
public final class SignInCredential extends AbstractSafeParcelable {
    public static final Parcelable.Creator<SignInCredential> CREATOR = new zbt();
    private final String zba;
    private final String zbb;
    private final String zbc;
    private final String zbd;
    private final Uri zbe;
    private final String zbf;
    private final String zbg;
    private final String zbh;
    private final PublicKeyCredential zbi;

    SignInCredential(String str, String str2, String str3, String str4, Uri uri, String str5, String str6, String str7, PublicKeyCredential publicKeyCredential) {
        this.zba = Preconditions.checkNotEmpty(str);
        this.zbb = str2;
        this.zbc = str3;
        this.zbd = str4;
        this.zbe = uri;
        this.zbf = str5;
        this.zbg = str6;
        this.zbh = str7;
        this.zbi = publicKeyCredential;
    }

    public boolean equals(Object o) {
        if (!(o instanceof SignInCredential)) {
            return false;
        }
        SignInCredential signInCredential = (SignInCredential) o;
        if (!Objects.equal(this.zba, signInCredential.zba) || !Objects.equal(this.zbb, signInCredential.zbb) || !Objects.equal(this.zbc, signInCredential.zbc) || !Objects.equal(this.zbd, signInCredential.zbd) || !Objects.equal(this.zbe, signInCredential.zbe) || !Objects.equal(this.zbf, signInCredential.zbf) || !Objects.equal(this.zbg, signInCredential.zbg) || !Objects.equal(this.zbh, signInCredential.zbh) || !Objects.equal(this.zbi, signInCredential.zbi)) {
            return false;
        }
        return true;
    }

    public String getDisplayName() {
        return this.zbb;
    }

    public String getFamilyName() {
        return this.zbd;
    }

    public String getGivenName() {
        return this.zbc;
    }

    public String getGoogleIdToken() {
        return this.zbg;
    }

    public String getId() {
        return this.zba;
    }

    public String getPassword() {
        return this.zbf;
    }

    @Deprecated
    public String getPhoneNumber() {
        return this.zbh;
    }

    public Uri getProfilePictureUri() {
        return this.zbe;
    }

    public PublicKeyCredential getPublicKeyCredential() {
        return this.zbi;
    }

    public int hashCode() {
        return Objects.hashCode(this.zba, this.zbb, this.zbc, this.zbd, this.zbe, this.zbf, this.zbg, this.zbh, this.zbi);
    }

    public void writeToParcel(Parcel dest, int flags) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(dest);
        SafeParcelWriter.writeString(dest, 1, getId(), false);
        SafeParcelWriter.writeString(dest, 2, getDisplayName(), false);
        SafeParcelWriter.writeString(dest, 3, getGivenName(), false);
        SafeParcelWriter.writeString(dest, 4, getFamilyName(), false);
        SafeParcelWriter.writeParcelable(dest, 5, getProfilePictureUri(), flags, false);
        SafeParcelWriter.writeString(dest, 6, getPassword(), false);
        SafeParcelWriter.writeString(dest, 7, getGoogleIdToken(), false);
        SafeParcelWriter.writeString(dest, 8, getPhoneNumber(), false);
        SafeParcelWriter.writeParcelable(dest, 9, getPublicKeyCredential(), flags, false);
        SafeParcelWriter.finishObjectHeader(dest, beginObjectHeader);
    }
}
