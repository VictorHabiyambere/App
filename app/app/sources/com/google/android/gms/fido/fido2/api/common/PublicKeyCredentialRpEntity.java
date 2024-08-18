package com.google.android.gms.fido.fido2.api.common;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* compiled from: com.google.android.gms:play-services-fido@@20.1.0 */
public class PublicKeyCredentialRpEntity extends AbstractSafeParcelable {
    public static final Parcelable.Creator<PublicKeyCredentialRpEntity> CREATOR = new zzap();
    private final String zza;
    private final String zzb;
    private final String zzc;

    public PublicKeyCredentialRpEntity(String id, String name, String icon) {
        this.zza = (String) Preconditions.checkNotNull(id);
        this.zzb = (String) Preconditions.checkNotNull(name);
        this.zzc = icon;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof PublicKeyCredentialRpEntity)) {
            return false;
        }
        PublicKeyCredentialRpEntity publicKeyCredentialRpEntity = (PublicKeyCredentialRpEntity) obj;
        if (!Objects.equal(this.zza, publicKeyCredentialRpEntity.zza) || !Objects.equal(this.zzb, publicKeyCredentialRpEntity.zzb) || !Objects.equal(this.zzc, publicKeyCredentialRpEntity.zzc)) {
            return false;
        }
        return true;
    }

    public String getIcon() {
        return this.zzc;
    }

    public String getId() {
        return this.zza;
    }

    public String getName() {
        return this.zzb;
    }

    public int hashCode() {
        return Objects.hashCode(this.zza, this.zzb, this.zzc);
    }

    public void writeToParcel(Parcel dest, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(dest);
        SafeParcelWriter.writeString(dest, 2, getId(), false);
        SafeParcelWriter.writeString(dest, 3, getName(), false);
        SafeParcelWriter.writeString(dest, 4, getIcon(), false);
        SafeParcelWriter.finishObjectHeader(dest, beginObjectHeader);
    }
}
