package com.google.android.gms.fido.fido2.api.common;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelableSerializer;

/* compiled from: com.google.android.gms:play-services-fido@@20.1.0 */
public class BrowserPublicKeyCredentialRequestOptions extends BrowserRequestOptions {
    public static final Parcelable.Creator<BrowserPublicKeyCredentialRequestOptions> CREATOR = new zzo();
    private final PublicKeyCredentialRequestOptions zza;
    private final Uri zzb;
    private final byte[] zzc;

    /* compiled from: com.google.android.gms:play-services-fido@@20.1.0 */
    public static final class Builder {
        private PublicKeyCredentialRequestOptions zza;
        private Uri zzb;
        private byte[] zzc;

        public BrowserPublicKeyCredentialRequestOptions build() {
            return new BrowserPublicKeyCredentialRequestOptions(this.zza, this.zzb, this.zzc);
        }

        public Builder setClientDataHash(byte[] clientDataHash) {
            byte[] unused = BrowserPublicKeyCredentialRequestOptions.zzd(clientDataHash);
            this.zzc = clientDataHash;
            return this;
        }

        public Builder setOrigin(Uri origin) {
            Uri unused = BrowserPublicKeyCredentialRequestOptions.zzc(origin);
            this.zzb = origin;
            return this;
        }

        public Builder setPublicKeyCredentialRequestOptions(PublicKeyCredentialRequestOptions publicKeyCredentialRequestOptions) {
            this.zza = (PublicKeyCredentialRequestOptions) Preconditions.checkNotNull(publicKeyCredentialRequestOptions);
            return this;
        }
    }

    BrowserPublicKeyCredentialRequestOptions(PublicKeyCredentialRequestOptions publicKeyCredentialRequestOptions, Uri uri, byte[] bArr) {
        this.zza = (PublicKeyCredentialRequestOptions) Preconditions.checkNotNull(publicKeyCredentialRequestOptions);
        zzc(uri);
        this.zzb = uri;
        zzd(bArr);
        this.zzc = bArr;
    }

    public static BrowserPublicKeyCredentialRequestOptions deserializeFromBytes(byte[] serializedBytes) {
        return (BrowserPublicKeyCredentialRequestOptions) SafeParcelableSerializer.deserializeFromBytes(serializedBytes, CREATOR);
    }

    /* access modifiers changed from: private */
    public static Uri zzc(Uri uri) {
        boolean z;
        Preconditions.checkNotNull(uri);
        boolean z2 = true;
        if (uri.getScheme() != null) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkArgument(z, "origin scheme must be non-empty");
        if (uri.getAuthority() == null) {
            z2 = false;
        }
        Preconditions.checkArgument(z2, "origin authority must be non-empty");
        return uri;
    }

    /* access modifiers changed from: private */
    public static byte[] zzd(byte[] bArr) {
        boolean z = true;
        if (!(bArr == null || bArr.length == 32)) {
            z = false;
        }
        Preconditions.checkArgument(z, "clientDataHash must be 32 bytes long");
        return bArr;
    }

    public boolean equals(Object o) {
        if (!(o instanceof BrowserPublicKeyCredentialRequestOptions)) {
            return false;
        }
        BrowserPublicKeyCredentialRequestOptions browserPublicKeyCredentialRequestOptions = (BrowserPublicKeyCredentialRequestOptions) o;
        if (!Objects.equal(this.zza, browserPublicKeyCredentialRequestOptions.zza) || !Objects.equal(this.zzb, browserPublicKeyCredentialRequestOptions.zzb)) {
            return false;
        }
        return true;
    }

    public AuthenticationExtensions getAuthenticationExtensions() {
        return this.zza.getAuthenticationExtensions();
    }

    public byte[] getChallenge() {
        return this.zza.getChallenge();
    }

    public byte[] getClientDataHash() {
        return this.zzc;
    }

    public Uri getOrigin() {
        return this.zzb;
    }

    public PublicKeyCredentialRequestOptions getPublicKeyCredentialRequestOptions() {
        return this.zza;
    }

    public Integer getRequestId() {
        return this.zza.getRequestId();
    }

    public Double getTimeoutSeconds() {
        return this.zza.getTimeoutSeconds();
    }

    public TokenBinding getTokenBinding() {
        return this.zza.getTokenBinding();
    }

    public int hashCode() {
        return Objects.hashCode(this.zza, this.zzb);
    }

    public byte[] serializeToBytes() {
        return SafeParcelableSerializer.serializeToBytes(this);
    }

    public void writeToParcel(Parcel dest, int flags) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(dest);
        SafeParcelWriter.writeParcelable(dest, 2, getPublicKeyCredentialRequestOptions(), flags, false);
        SafeParcelWriter.writeParcelable(dest, 3, getOrigin(), flags, false);
        SafeParcelWriter.writeByteArray(dest, 4, getClientDataHash(), false);
        SafeParcelWriter.finishObjectHeader(dest, beginObjectHeader);
    }
}
