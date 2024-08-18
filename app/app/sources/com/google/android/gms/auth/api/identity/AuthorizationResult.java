package com.google.android.gms.auth.api.identity;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-auth@@20.7.0 */
public final class AuthorizationResult extends AbstractSafeParcelable {
    public static final Parcelable.Creator<AuthorizationResult> CREATOR = new zbe();
    private final String zba;
    private final String zbb;
    private final String zbc;
    private final List zbd;
    private final GoogleSignInAccount zbe;
    private final PendingIntent zbf;

    public AuthorizationResult(String serverAuthCode, String accessToken, String idToken, List<String> grantedScopes, GoogleSignInAccount googleSignInAccount, PendingIntent pendingIntent) {
        this.zba = serverAuthCode;
        this.zbb = accessToken;
        this.zbc = idToken;
        this.zbd = (List) Preconditions.checkNotNull(grantedScopes);
        this.zbf = pendingIntent;
        this.zbe = googleSignInAccount;
    }

    public boolean equals(Object o) {
        if (!(o instanceof AuthorizationResult)) {
            return false;
        }
        AuthorizationResult authorizationResult = (AuthorizationResult) o;
        if (!Objects.equal(this.zba, authorizationResult.zba) || !Objects.equal(this.zbb, authorizationResult.zbb) || !Objects.equal(this.zbc, authorizationResult.zbc) || !Objects.equal(this.zbd, authorizationResult.zbd) || !Objects.equal(this.zbf, authorizationResult.zbf) || !Objects.equal(this.zbe, authorizationResult.zbe)) {
            return false;
        }
        return true;
    }

    public String getAccessToken() {
        return this.zbb;
    }

    public List<String> getGrantedScopes() {
        return this.zbd;
    }

    public PendingIntent getPendingIntent() {
        return this.zbf;
    }

    public String getServerAuthCode() {
        return this.zba;
    }

    public boolean hasResolution() {
        return this.zbf != null;
    }

    public int hashCode() {
        return Objects.hashCode(this.zba, this.zbb, this.zbc, this.zbd, this.zbf, this.zbe);
    }

    public GoogleSignInAccount toGoogleSignInAccount() {
        return this.zbe;
    }

    public void writeToParcel(Parcel dest, int flags) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(dest);
        SafeParcelWriter.writeString(dest, 1, getServerAuthCode(), false);
        SafeParcelWriter.writeString(dest, 2, getAccessToken(), false);
        SafeParcelWriter.writeString(dest, 3, this.zbc, false);
        SafeParcelWriter.writeStringList(dest, 4, getGrantedScopes(), false);
        SafeParcelWriter.writeParcelable(dest, 5, toGoogleSignInAccount(), flags, false);
        SafeParcelWriter.writeParcelable(dest, 6, getPendingIntent(), flags, false);
        SafeParcelWriter.finishObjectHeader(dest, beginObjectHeader);
    }
}
