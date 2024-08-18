package com.google.android.gms.auth.api.identity;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-auth@@20.7.0 */
public class AuthorizationRequest extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<AuthorizationRequest> CREATOR = new zbd();
    private final List zba;
    private final String zbb;
    private final boolean zbc;
    private final boolean zbd;
    private final Account zbe;
    private final String zbf;
    private final String zbg;
    private final boolean zbh;

    /* compiled from: com.google.android.gms:play-services-auth@@20.7.0 */
    public static final class Builder {
        private List zba;
        private String zbb;
        private boolean zbc;
        private boolean zbd;
        private Account zbe;
        private String zbf;
        private String zbg;
        private boolean zbh;

        private final String zbc(String str) {
            Preconditions.checkNotNull(str);
            String str2 = this.zbb;
            boolean z = true;
            if (str2 != null && !str2.equals(str)) {
                z = false;
            }
            Preconditions.checkArgument(z, "two different server client ids provided");
            return str;
        }

        public AuthorizationRequest build() {
            return new AuthorizationRequest(this.zba, this.zbb, this.zbc, this.zbd, this.zbe, this.zbf, this.zbg, this.zbh);
        }

        public Builder filterByHostedDomain(String hostedDomain) {
            this.zbf = Preconditions.checkNotEmpty(hostedDomain);
            return this;
        }

        public Builder requestOfflineAccess(String serverClientId) {
            requestOfflineAccess(serverClientId, false);
            return this;
        }

        public Builder setAccount(Account account) {
            this.zbe = (Account) Preconditions.checkNotNull(account);
            return this;
        }

        public Builder setRequestedScopes(List<Scope> requestedScopes) {
            boolean z = false;
            if (requestedScopes != null && !requestedScopes.isEmpty()) {
                z = true;
            }
            Preconditions.checkArgument(z, "requestedScopes cannot be null or empty");
            this.zba = requestedScopes;
            return this;
        }

        public final Builder zba(String str) {
            zbc(str);
            this.zbb = str;
            this.zbd = true;
            return this;
        }

        public final Builder zbb(String str) {
            this.zbg = str;
            return this;
        }

        public Builder requestOfflineAccess(String serverClientId, boolean forceCodeForRefreshToken) {
            zbc(serverClientId);
            this.zbb = serverClientId;
            this.zbc = true;
            this.zbh = forceCodeForRefreshToken;
            return this;
        }
    }

    AuthorizationRequest(List list, String str, boolean z, boolean z2, Account account, String str2, String str3, boolean z3) {
        boolean z4 = false;
        if (list != null && !list.isEmpty()) {
            z4 = true;
        }
        Preconditions.checkArgument(z4, "requestedScopes cannot be null or empty");
        this.zba = list;
        this.zbb = str;
        this.zbc = z;
        this.zbd = z2;
        this.zbe = account;
        this.zbf = str2;
        this.zbg = str3;
        this.zbh = z3;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder zba(AuthorizationRequest authorizationRequest) {
        Preconditions.checkNotNull(authorizationRequest);
        Builder builder = builder();
        builder.setRequestedScopes(authorizationRequest.getRequestedScopes());
        boolean isForceCodeForRefreshToken = authorizationRequest.isForceCodeForRefreshToken();
        String str = authorizationRequest.zbg;
        String hostedDomain = authorizationRequest.getHostedDomain();
        Account account = authorizationRequest.getAccount();
        String serverClientId = authorizationRequest.getServerClientId();
        if (str != null) {
            builder.zbb(str);
        }
        if (hostedDomain != null) {
            builder.filterByHostedDomain(hostedDomain);
        }
        if (account != null) {
            builder.setAccount(account);
        }
        if (authorizationRequest.zbd && serverClientId != null) {
            builder.zba(serverClientId);
        }
        if (authorizationRequest.isOfflineAccessRequested() && serverClientId != null) {
            builder.requestOfflineAccess(serverClientId, isForceCodeForRefreshToken);
        }
        return builder;
    }

    public boolean equals(Object o) {
        if (!(o instanceof AuthorizationRequest)) {
            return false;
        }
        AuthorizationRequest authorizationRequest = (AuthorizationRequest) o;
        if (this.zba.size() != authorizationRequest.zba.size() || !this.zba.containsAll(authorizationRequest.zba) || this.zbc != authorizationRequest.zbc || this.zbh != authorizationRequest.zbh || this.zbd != authorizationRequest.zbd || !Objects.equal(this.zbb, authorizationRequest.zbb) || !Objects.equal(this.zbe, authorizationRequest.zbe) || !Objects.equal(this.zbf, authorizationRequest.zbf) || !Objects.equal(this.zbg, authorizationRequest.zbg)) {
            return false;
        }
        return true;
    }

    public Account getAccount() {
        return this.zbe;
    }

    public String getHostedDomain() {
        return this.zbf;
    }

    public List<Scope> getRequestedScopes() {
        return this.zba;
    }

    public String getServerClientId() {
        return this.zbb;
    }

    public int hashCode() {
        return Objects.hashCode(this.zba, this.zbb, Boolean.valueOf(this.zbc), Boolean.valueOf(this.zbh), Boolean.valueOf(this.zbd), this.zbe, this.zbf, this.zbg);
    }

    public boolean isForceCodeForRefreshToken() {
        return this.zbh;
    }

    public boolean isOfflineAccessRequested() {
        return this.zbc;
    }

    public void writeToParcel(Parcel dest, int flags) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(dest);
        SafeParcelWriter.writeTypedList(dest, 1, getRequestedScopes(), false);
        SafeParcelWriter.writeString(dest, 2, getServerClientId(), false);
        SafeParcelWriter.writeBoolean(dest, 3, isOfflineAccessRequested());
        SafeParcelWriter.writeBoolean(dest, 4, this.zbd);
        SafeParcelWriter.writeParcelable(dest, 5, getAccount(), flags, false);
        SafeParcelWriter.writeString(dest, 6, getHostedDomain(), false);
        SafeParcelWriter.writeString(dest, 7, this.zbg, false);
        SafeParcelWriter.writeBoolean(dest, 8, isForceCodeForRefreshToken());
        SafeParcelWriter.finishObjectHeader(dest, beginObjectHeader);
    }
}
