package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.common.base.Ascii;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzgh implements zzcc {
    public static final Parcelable.Creator<zzgh> CREATOR = new zzgf();
    public final String zza;
    public final byte[] zzb;
    public final int zzc;
    public final int zzd;

    /* synthetic */ zzgh(Parcel parcel, zzgg zzgg) {
        String readString = parcel.readString();
        int i = zzgd.zza;
        this.zza = readString;
        this.zzb = parcel.createByteArray();
        this.zzc = parcel.readInt();
        this.zzd = parcel.readInt();
    }

    public zzgh(String str, byte[] bArr, int i, int i2) {
        this.zza = str;
        this.zzb = bArr;
        this.zzc = i;
        this.zzd = i2;
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        zzgh zzgh = (zzgh) obj;
        return this.zza.equals(zzgh.zza) && Arrays.equals(this.zzb, zzgh.zzb) && this.zzc == zzgh.zzc && this.zzd == zzgh.zzd;
    }

    public final int hashCode() {
        return ((((((this.zza.hashCode() + 527) * 31) + Arrays.hashCode(this.zzb)) * 31) + this.zzc) * 31) + this.zzd;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.zza);
        parcel.writeByteArray(this.zzb);
        parcel.writeInt(this.zzc);
        parcel.writeInt(this.zzd);
    }

    public final /* synthetic */ void zza(zzby zzby) {
    }

    public final String toString() {
        String str;
        switch (this.zzd) {
            case 1:
                str = zzgd.zzA(this.zzb);
                break;
            case 23:
                str = String.valueOf(Float.intBitsToFloat(zzgea.zzd(this.zzb)));
                break;
            case ConstraintLayout.LayoutParams.Table.GUIDELINE_USE_RTL /*67*/:
                str = String.valueOf(zzgea.zzd(this.zzb));
                break;
            default:
                byte[] bArr = this.zzb;
                int length = bArr.length;
                StringBuilder sb = new StringBuilder(length + length);
                for (int i = 0; i < bArr.length; i++) {
                    sb.append(Character.forDigit((bArr[i] >> 4) & 15, 16));
                    sb.append(Character.forDigit(bArr[i] & Ascii.SI, 16));
                }
                str = sb.toString();
                break;
        }
        String str2 = this.zza;
        return "mdta: key=" + str2 + ", value=" + str;
    }
}
