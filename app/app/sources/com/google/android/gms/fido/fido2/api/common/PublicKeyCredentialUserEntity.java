package com.google.android.gms.fido.fido2.api.common;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-fido@@20.1.0 */
public class PublicKeyCredentialUserEntity extends AbstractSafeParcelable {
    public static final Parcelable.Creator<PublicKeyCredentialUserEntity> CREATOR = new zzar();
    private final byte[] zza;
    private final String zzb;
    private final String zzc;
    private final String zzd;

    public PublicKeyCredentialUserEntity(byte[] id, String name, String icon, String displayName) {
        this.zza = (byte[]) Preconditions.checkNotNull(id);
        this.zzb = (String) Preconditions.checkNotNull(name);
        this.zzc = icon;
        this.zzd = (String) Preconditions.checkNotNull(displayName);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof PublicKeyCredentialUserEntity)) {
            return false;
        }
        PublicKeyCredentialUserEntity publicKeyCredentialUserEntity = (PublicKeyCredentialUserEntity) obj;
        if (!Arrays.equals(this.zza, publicKeyCredentialUserEntity.zza) || !Objects.equal(this.zzb, publicKeyCredentialUserEntity.zzb) || !Objects.equal(this.zzc, publicKeyCredentialUserEntity.zzc) || !Objects.equal(this.zzd, publicKeyCredentialUserEntity.zzd)) {
            return false;
        }
        return true;
    }

    public String getDisplayName() {
        return this.zzd;
    }

    public String getIcon() {
        return this.zzc;
    }

    public byte[] getId() {
        return this.zza;
    }

    public String getName() {
        return this.zzb;
    }

    public int hashCode() {
        return Objects.hashCode(this.zza, this.zzb, this.zzc, this.zzd);
    }

    public void writeToParcel(Parcel dest, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(dest);
        SafeParcelWriter.writeByteArray(dest, 2, getId(), false);
        SafeParcelWriter.writeString(dest, 3, getName(), false);
        SafeParcelWriter.writeString(dest, 4, getIcon(), false);
        SafeParcelWriter.writeString(dest, 5, getDisplayName(), false);
        SafeParcelWriter.finishObjectHeader(dest, beginObjectHeader);
    }
}
