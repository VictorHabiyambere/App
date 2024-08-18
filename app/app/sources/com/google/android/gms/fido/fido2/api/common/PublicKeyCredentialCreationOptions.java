package com.google.android.gms.fido.fido2.api.common;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelableSerializer;
import com.google.android.gms.fido.fido2.api.common.AttestationConveyancePreference;
import java.util.Arrays;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-fido@@20.1.0 */
public class PublicKeyCredentialCreationOptions extends RequestOptions {
    public static final Parcelable.Creator<PublicKeyCredentialCreationOptions> CREATOR = new zzak();
    private final PublicKeyCredentialRpEntity zza;
    private final PublicKeyCredentialUserEntity zzb;
    private final byte[] zzc;
    private final List zzd;
    private final Double zze;
    private final List zzf;
    private final AuthenticatorSelectionCriteria zzg;
    private final Integer zzh;
    private final TokenBinding zzi;
    private final AttestationConveyancePreference zzj;
    private final AuthenticationExtensions zzk;

    /* compiled from: com.google.android.gms:play-services-fido@@20.1.0 */
    public static final class Builder {
        private PublicKeyCredentialRpEntity zza;
        private PublicKeyCredentialUserEntity zzb;
        private byte[] zzc;
        private List zzd;
        private Double zze;
        private List zzf;
        private AuthenticatorSelectionCriteria zzg;
        private Integer zzh;
        private TokenBinding zzi;
        private AttestationConveyancePreference zzj;
        private AuthenticationExtensions zzk;

        public PublicKeyCredentialCreationOptions build() {
            String str;
            PublicKeyCredentialRpEntity publicKeyCredentialRpEntity = this.zza;
            PublicKeyCredentialUserEntity publicKeyCredentialUserEntity = this.zzb;
            byte[] bArr = this.zzc;
            List list = this.zzd;
            Double d = this.zze;
            List list2 = this.zzf;
            AuthenticatorSelectionCriteria authenticatorSelectionCriteria = this.zzg;
            Integer num = this.zzh;
            TokenBinding tokenBinding = this.zzi;
            AttestationConveyancePreference attestationConveyancePreference = this.zzj;
            if (attestationConveyancePreference == null) {
                str = null;
            } else {
                str = attestationConveyancePreference.toString();
            }
            return new PublicKeyCredentialCreationOptions(publicKeyCredentialRpEntity, publicKeyCredentialUserEntity, bArr, list, d, list2, authenticatorSelectionCriteria, num, tokenBinding, str, this.zzk);
        }

        public Builder setAttestationConveyancePreference(AttestationConveyancePreference attestationConveyancePreference) {
            this.zzj = attestationConveyancePreference;
            return this;
        }

        public Builder setAuthenticationExtensions(AuthenticationExtensions authenticationExtensions) {
            this.zzk = authenticationExtensions;
            return this;
        }

        public Builder setAuthenticatorSelection(AuthenticatorSelectionCriteria authenticatorSelectionCriteria) {
            this.zzg = authenticatorSelectionCriteria;
            return this;
        }

        public Builder setChallenge(byte[] challenge) {
            this.zzc = (byte[]) Preconditions.checkNotNull(challenge);
            return this;
        }

        public Builder setExcludeList(List<PublicKeyCredentialDescriptor> list) {
            this.zzf = list;
            return this;
        }

        public Builder setParameters(List<PublicKeyCredentialParameters> parameters) {
            this.zzd = (List) Preconditions.checkNotNull(parameters);
            return this;
        }

        public Builder setRequestId(Integer num) {
            this.zzh = num;
            return this;
        }

        public Builder setRp(PublicKeyCredentialRpEntity rp) {
            this.zza = (PublicKeyCredentialRpEntity) Preconditions.checkNotNull(rp);
            return this;
        }

        public Builder setTimeoutSeconds(Double d) {
            this.zze = d;
            return this;
        }

        public Builder setTokenBinding(TokenBinding tokenBinding) {
            this.zzi = tokenBinding;
            return this;
        }

        public Builder setUser(PublicKeyCredentialUserEntity user) {
            this.zzb = (PublicKeyCredentialUserEntity) Preconditions.checkNotNull(user);
            return this;
        }
    }

    PublicKeyCredentialCreationOptions(PublicKeyCredentialRpEntity publicKeyCredentialRpEntity, PublicKeyCredentialUserEntity publicKeyCredentialUserEntity, byte[] bArr, List list, Double d, List list2, AuthenticatorSelectionCriteria authenticatorSelectionCriteria, Integer num, TokenBinding tokenBinding, String str, AuthenticationExtensions authenticationExtensions) {
        this.zza = (PublicKeyCredentialRpEntity) Preconditions.checkNotNull(publicKeyCredentialRpEntity);
        this.zzb = (PublicKeyCredentialUserEntity) Preconditions.checkNotNull(publicKeyCredentialUserEntity);
        this.zzc = (byte[]) Preconditions.checkNotNull(bArr);
        this.zzd = (List) Preconditions.checkNotNull(list);
        this.zze = d;
        this.zzf = list2;
        this.zzg = authenticatorSelectionCriteria;
        this.zzh = num;
        this.zzi = tokenBinding;
        if (str != null) {
            try {
                this.zzj = AttestationConveyancePreference.fromString(str);
            } catch (AttestationConveyancePreference.UnsupportedAttestationConveyancePreferenceException e) {
                throw new IllegalArgumentException(e);
            }
        } else {
            this.zzj = null;
        }
        this.zzk = authenticationExtensions;
    }

    public static PublicKeyCredentialCreationOptions deserializeFromBytes(byte[] serializedBytes) {
        return (PublicKeyCredentialCreationOptions) SafeParcelableSerializer.deserializeFromBytes(serializedBytes, CREATOR);
    }

    public boolean equals(Object obj) {
        List list;
        List list2;
        if (!(obj instanceof PublicKeyCredentialCreationOptions)) {
            return false;
        }
        PublicKeyCredentialCreationOptions publicKeyCredentialCreationOptions = (PublicKeyCredentialCreationOptions) obj;
        if (!Objects.equal(this.zza, publicKeyCredentialCreationOptions.zza) || !Objects.equal(this.zzb, publicKeyCredentialCreationOptions.zzb) || !Arrays.equals(this.zzc, publicKeyCredentialCreationOptions.zzc) || !Objects.equal(this.zze, publicKeyCredentialCreationOptions.zze) || !this.zzd.containsAll(publicKeyCredentialCreationOptions.zzd) || !publicKeyCredentialCreationOptions.zzd.containsAll(this.zzd) || ((((list = this.zzf) != null || publicKeyCredentialCreationOptions.zzf != null) && (list == null || (list2 = publicKeyCredentialCreationOptions.zzf) == null || !list.containsAll(list2) || !publicKeyCredentialCreationOptions.zzf.containsAll(this.zzf))) || !Objects.equal(this.zzg, publicKeyCredentialCreationOptions.zzg) || !Objects.equal(this.zzh, publicKeyCredentialCreationOptions.zzh) || !Objects.equal(this.zzi, publicKeyCredentialCreationOptions.zzi) || !Objects.equal(this.zzj, publicKeyCredentialCreationOptions.zzj) || !Objects.equal(this.zzk, publicKeyCredentialCreationOptions.zzk))) {
            return false;
        }
        return true;
    }

    public AttestationConveyancePreference getAttestationConveyancePreference() {
        return this.zzj;
    }

    public String getAttestationConveyancePreferenceAsString() {
        AttestationConveyancePreference attestationConveyancePreference = this.zzj;
        if (attestationConveyancePreference == null) {
            return null;
        }
        return attestationConveyancePreference.toString();
    }

    public AuthenticationExtensions getAuthenticationExtensions() {
        return this.zzk;
    }

    public AuthenticatorSelectionCriteria getAuthenticatorSelection() {
        return this.zzg;
    }

    public byte[] getChallenge() {
        return this.zzc;
    }

    public List<PublicKeyCredentialDescriptor> getExcludeList() {
        return this.zzf;
    }

    public List<PublicKeyCredentialParameters> getParameters() {
        return this.zzd;
    }

    public Integer getRequestId() {
        return this.zzh;
    }

    public PublicKeyCredentialRpEntity getRp() {
        return this.zza;
    }

    public Double getTimeoutSeconds() {
        return this.zze;
    }

    public TokenBinding getTokenBinding() {
        return this.zzi;
    }

    public PublicKeyCredentialUserEntity getUser() {
        return this.zzb;
    }

    public int hashCode() {
        return Objects.hashCode(this.zza, this.zzb, Integer.valueOf(Arrays.hashCode(this.zzc)), this.zzd, this.zze, this.zzf, this.zzg, this.zzh, this.zzi, this.zzj, this.zzk);
    }

    public byte[] serializeToBytes() {
        return SafeParcelableSerializer.serializeToBytes(this);
    }

    public void writeToParcel(Parcel dest, int flags) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(dest);
        SafeParcelWriter.writeParcelable(dest, 2, getRp(), flags, false);
        SafeParcelWriter.writeParcelable(dest, 3, getUser(), flags, false);
        SafeParcelWriter.writeByteArray(dest, 4, getChallenge(), false);
        SafeParcelWriter.writeTypedList(dest, 5, getParameters(), false);
        SafeParcelWriter.writeDoubleObject(dest, 6, getTimeoutSeconds(), false);
        SafeParcelWriter.writeTypedList(dest, 7, getExcludeList(), false);
        SafeParcelWriter.writeParcelable(dest, 8, getAuthenticatorSelection(), flags, false);
        SafeParcelWriter.writeIntegerObject(dest, 9, getRequestId(), false);
        SafeParcelWriter.writeParcelable(dest, 10, getTokenBinding(), flags, false);
        SafeParcelWriter.writeString(dest, 11, getAttestationConveyancePreferenceAsString(), false);
        SafeParcelWriter.writeParcelable(dest, 12, getAuthenticationExtensions(), flags, false);
        SafeParcelWriter.finishObjectHeader(dest, beginObjectHeader);
    }
}
