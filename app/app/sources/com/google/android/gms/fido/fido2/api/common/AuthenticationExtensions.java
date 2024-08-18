package com.google.android.gms.fido.fido2.api.common;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* compiled from: com.google.android.gms:play-services-fido@@20.1.0 */
public class AuthenticationExtensions extends AbstractSafeParcelable {
    public static final Parcelable.Creator<AuthenticationExtensions> CREATOR = new zzd();
    private final FidoAppIdExtension zza;
    private final zzs zzb;
    private final UserVerificationMethodExtension zzc;
    private final zzz zzd;
    private final zzab zze;
    private final zzad zzf;
    private final zzu zzg;
    private final zzag zzh;
    private final GoogleThirdPartyPaymentExtension zzi;
    private final zzai zzj;

    /* compiled from: com.google.android.gms:play-services-fido@@20.1.0 */
    public static final class Builder {
        private FidoAppIdExtension zza;
        private UserVerificationMethodExtension zzb;
        private zzs zzc;
        private zzz zzd;
        private zzab zze;
        private zzad zzf;
        private zzu zzg;
        private zzag zzh;
        private GoogleThirdPartyPaymentExtension zzi;
        private zzai zzj;

        public Builder() {
        }

        public Builder(AuthenticationExtensions extensions) {
            if (extensions != null) {
                this.zza = extensions.getFidoAppIdExtension();
                this.zzb = extensions.getUserVerificationMethodExtension();
                this.zzc = extensions.zza();
                this.zzd = extensions.zzc();
                this.zze = extensions.zzd();
                this.zzf = extensions.zze();
                this.zzg = extensions.zzb();
                this.zzh = extensions.zzg();
                this.zzi = extensions.zzf();
                this.zzj = extensions.zzh();
            }
        }

        public AuthenticationExtensions build() {
            return new AuthenticationExtensions(this.zza, this.zzc, this.zzb, this.zzd, this.zze, this.zzf, this.zzg, this.zzh, this.zzi, this.zzj);
        }

        public Builder setFido2Extension(FidoAppIdExtension fidoAppIdExtension) {
            this.zza = fidoAppIdExtension;
            return this;
        }

        public Builder setGoogleThirdPartyPaymentExtension(GoogleThirdPartyPaymentExtension googleThirdPartyPaymentExtension) {
            this.zzi = googleThirdPartyPaymentExtension;
            return this;
        }

        public Builder setUserVerificationMethodExtension(UserVerificationMethodExtension userVerificationMethodExtension) {
            this.zzb = userVerificationMethodExtension;
            return this;
        }
    }

    AuthenticationExtensions(FidoAppIdExtension fidoAppIdExtension, zzs zzs, UserVerificationMethodExtension userVerificationMethodExtension, zzz zzz, zzab zzab, zzad zzad, zzu zzu, zzag zzag, GoogleThirdPartyPaymentExtension googleThirdPartyPaymentExtension, zzai zzai) {
        this.zza = fidoAppIdExtension;
        this.zzc = userVerificationMethodExtension;
        this.zzb = zzs;
        this.zzd = zzz;
        this.zze = zzab;
        this.zzf = zzad;
        this.zzg = zzu;
        this.zzh = zzag;
        this.zzi = googleThirdPartyPaymentExtension;
        this.zzj = zzai;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof AuthenticationExtensions)) {
            return false;
        }
        AuthenticationExtensions authenticationExtensions = (AuthenticationExtensions) obj;
        if (!Objects.equal(this.zza, authenticationExtensions.zza) || !Objects.equal(this.zzb, authenticationExtensions.zzb) || !Objects.equal(this.zzc, authenticationExtensions.zzc) || !Objects.equal(this.zzd, authenticationExtensions.zzd) || !Objects.equal(this.zze, authenticationExtensions.zze) || !Objects.equal(this.zzf, authenticationExtensions.zzf) || !Objects.equal(this.zzg, authenticationExtensions.zzg) || !Objects.equal(this.zzh, authenticationExtensions.zzh) || !Objects.equal(this.zzi, authenticationExtensions.zzi) || !Objects.equal(this.zzj, authenticationExtensions.zzj)) {
            return false;
        }
        return true;
    }

    public FidoAppIdExtension getFidoAppIdExtension() {
        return this.zza;
    }

    public UserVerificationMethodExtension getUserVerificationMethodExtension() {
        return this.zzc;
    }

    public int hashCode() {
        return Objects.hashCode(this.zza, this.zzb, this.zzc, this.zzd, this.zze, this.zzf, this.zzg, this.zzh, this.zzi, this.zzj);
    }

    public void writeToParcel(Parcel dest, int flags) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(dest);
        SafeParcelWriter.writeParcelable(dest, 2, getFidoAppIdExtension(), flags, false);
        SafeParcelWriter.writeParcelable(dest, 3, this.zzb, flags, false);
        SafeParcelWriter.writeParcelable(dest, 4, getUserVerificationMethodExtension(), flags, false);
        SafeParcelWriter.writeParcelable(dest, 5, this.zzd, flags, false);
        SafeParcelWriter.writeParcelable(dest, 6, this.zze, flags, false);
        SafeParcelWriter.writeParcelable(dest, 7, this.zzf, flags, false);
        SafeParcelWriter.writeParcelable(dest, 8, this.zzg, flags, false);
        SafeParcelWriter.writeParcelable(dest, 9, this.zzh, flags, false);
        SafeParcelWriter.writeParcelable(dest, 10, this.zzi, flags, false);
        SafeParcelWriter.writeParcelable(dest, 11, this.zzj, flags, false);
        SafeParcelWriter.finishObjectHeader(dest, beginObjectHeader);
    }

    public final zzs zza() {
        return this.zzb;
    }

    public final zzu zzb() {
        return this.zzg;
    }

    public final zzz zzc() {
        return this.zzd;
    }

    public final zzab zzd() {
        return this.zze;
    }

    public final zzad zze() {
        return this.zzf;
    }

    public final GoogleThirdPartyPaymentExtension zzf() {
        return this.zzi;
    }

    public final zzag zzg() {
        return this.zzh;
    }

    public final zzai zzh() {
        return this.zzj;
    }
}
