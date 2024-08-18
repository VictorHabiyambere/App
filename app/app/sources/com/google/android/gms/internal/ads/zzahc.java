package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzahc extends zzahr {
    public static final Parcelable.Creator<zzahc> CREATOR = new zzahb();
    public final String zza;
    public final String zzb;
    public final int zzc;
    public final byte[] zzd;

    zzahc(Parcel parcel) {
        super("APIC");
        String readString = parcel.readString();
        int i = zzgd.zza;
        this.zza = readString;
        this.zzb = parcel.readString();
        this.zzc = parcel.readInt();
        this.zzd = parcel.createByteArray();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        zzahc zzahc = (zzahc) obj;
        return this.zzc == zzahc.zzc && zzgd.zzG(this.zza, zzahc.zza) && zzgd.zzG(this.zzb, zzahc.zzb) && Arrays.equals(this.zzd, zzahc.zzd);
    }

    public final int hashCode() {
        int i;
        String str = this.zza;
        int i2 = 0;
        if (str != null) {
            i = str.hashCode();
        } else {
            i = 0;
        }
        int i3 = this.zzc;
        String str2 = this.zzb;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        return ((((((i3 + 527) * 31) + i) * 31) + i2) * 31) + Arrays.hashCode(this.zzd);
    }

    public final String toString() {
        return this.zzf + ": mimeType=" + this.zza + ", description=" + this.zzb;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.zza);
        parcel.writeString(this.zzb);
        parcel.writeInt(this.zzc);
        parcel.writeByteArray(this.zzd);
    }

    public final void zza(zzby zzby) {
        zzby.zza(this.zzd, this.zzc);
    }

    public zzahc(String str, String str2, int i, byte[] bArr) {
        super("APIC");
        this.zza = str;
        this.zzb = str2;
        this.zzc = i;
        this.zzd = bArr;
    }
}
