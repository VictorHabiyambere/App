package com.google.android.gms.fido.fido2.api.common;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.fido.common.Transport;
import com.google.android.gms.fido.fido2.api.common.PublicKeyCredentialType;
import com.google.android.gms.internal.fido.zzbc;
import com.google.android.gms.internal.fido.zzh;
import java.util.Arrays;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-fido@@20.1.0 */
public class PublicKeyCredentialDescriptor extends AbstractSafeParcelable {
    public static final Parcelable.Creator<PublicKeyCredentialDescriptor> CREATOR = new zzam();
    private static final zzbc zza = zzbc.zzk(zzh.zza, zzh.zzb);
    private final PublicKeyCredentialType zzb;
    private final byte[] zzc;
    private final List zzd;

    /* compiled from: com.google.android.gms:play-services-fido@@20.1.0 */
    public static class UnsupportedPubKeyCredDescriptorException extends Exception {
        public UnsupportedPubKeyCredDescriptorException(String errorMessage) {
            super(errorMessage);
        }

        public UnsupportedPubKeyCredDescriptorException(String errorMessage, Throwable t) {
            super(errorMessage, t);
        }
    }

    public PublicKeyCredentialDescriptor(String type, byte[] id, List<Transport> transports) {
        Preconditions.checkNotNull(type);
        try {
            this.zzb = PublicKeyCredentialType.fromString(type);
            this.zzc = (byte[]) Preconditions.checkNotNull(id);
            this.zzd = transports;
        } catch (PublicKeyCredentialType.UnsupportedPublicKeyCredTypeException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public boolean equals(Object obj) {
        List list;
        if (!(obj instanceof PublicKeyCredentialDescriptor)) {
            return false;
        }
        PublicKeyCredentialDescriptor publicKeyCredentialDescriptor = (PublicKeyCredentialDescriptor) obj;
        if (!this.zzb.equals(publicKeyCredentialDescriptor.zzb) || !Arrays.equals(this.zzc, publicKeyCredentialDescriptor.zzc)) {
            return false;
        }
        List list2 = this.zzd;
        if (list2 == null && publicKeyCredentialDescriptor.zzd == null) {
            return true;
        }
        if (list2 == null || (list = publicKeyCredentialDescriptor.zzd) == null || !list2.containsAll(list) || !publicKeyCredentialDescriptor.zzd.containsAll(this.zzd)) {
            return false;
        }
        return true;
    }

    public byte[] getId() {
        return this.zzc;
    }

    public List<Transport> getTransports() {
        return this.zzd;
    }

    public PublicKeyCredentialType getType() {
        return this.zzb;
    }

    public String getTypeAsString() {
        return this.zzb.toString();
    }

    public int hashCode() {
        return Objects.hashCode(this.zzb, Integer.valueOf(Arrays.hashCode(this.zzc)), this.zzd);
    }

    public void writeToParcel(Parcel dest, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(dest);
        SafeParcelWriter.writeString(dest, 2, getTypeAsString(), false);
        SafeParcelWriter.writeByteArray(dest, 3, getId(), false);
        SafeParcelWriter.writeTypedList(dest, 4, getTransports(), false);
        SafeParcelWriter.finishObjectHeader(dest, beginObjectHeader);
    }
}
