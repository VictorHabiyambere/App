package com.google.android.gms.fido.fido2.api.common;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelableSerializer;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-fido@@20.1.0 */
public class FidoCredentialDetails extends AbstractSafeParcelable {
    public static final Parcelable.Creator<FidoCredentialDetails> CREATOR = new zzy();
    private final String zza;
    private final String zzb;
    private final byte[] zzc;
    private final byte[] zzd;
    private final boolean zze;
    private final boolean zzf;
    private final long zzg;

    FidoCredentialDetails(String str, String str2, byte[] bArr, byte[] bArr2, boolean z, boolean z2, long j) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = bArr;
        this.zzd = bArr2;
        this.zze = z;
        this.zzf = z2;
        this.zzg = j;
    }

    public static FidoCredentialDetails deserializeFromBytes(byte[] serializedBytes) {
        return (FidoCredentialDetails) SafeParcelableSerializer.deserializeFromBytes(serializedBytes, CREATOR);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof FidoCredentialDetails)) {
            return false;
        }
        FidoCredentialDetails fidoCredentialDetails = (FidoCredentialDetails) obj;
        if (!Objects.equal(this.zza, fidoCredentialDetails.zza) || !Objects.equal(this.zzb, fidoCredentialDetails.zzb) || !Arrays.equals(this.zzc, fidoCredentialDetails.zzc) || !Arrays.equals(this.zzd, fidoCredentialDetails.zzd) || this.zze != fidoCredentialDetails.zze || this.zzf != fidoCredentialDetails.zzf || this.zzg != fidoCredentialDetails.zzg) {
            return false;
        }
        return true;
    }

    public byte[] getCredentialId() {
        return this.zzd;
    }

    public boolean getIsDiscoverable() {
        return this.zze;
    }

    public boolean getIsPaymentCredential() {
        return this.zzf;
    }

    public long getLastUsedTime() {
        return this.zzg;
    }

    public String getUserDisplayName() {
        return this.zzb;
    }

    public byte[] getUserId() {
        return this.zzc;
    }

    public String getUserName() {
        return this.zza;
    }

    public int hashCode() {
        return Objects.hashCode(this.zza, this.zzb, this.zzc, this.zzd, Boolean.valueOf(this.zze), Boolean.valueOf(this.zzf), Long.valueOf(this.zzg));
    }

    public byte[] serializeToBytes() {
        return SafeParcelableSerializer.serializeToBytes(this);
    }

    public void writeToParcel(Parcel dest, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(dest);
        SafeParcelWriter.writeString(dest, 1, getUserName(), false);
        SafeParcelWriter.writeString(dest, 2, getUserDisplayName(), false);
        SafeParcelWriter.writeByteArray(dest, 3, getUserId(), false);
        SafeParcelWriter.writeByteArray(dest, 4, getCredentialId(), false);
        SafeParcelWriter.writeBoolean(dest, 5, getIsDiscoverable());
        SafeParcelWriter.writeBoolean(dest, 6, getIsPaymentCredential());
        SafeParcelWriter.writeLong(dest, 7, getLastUsedTime());
        SafeParcelWriter.finishObjectHeader(dest, beginObjectHeader);
    }
}
