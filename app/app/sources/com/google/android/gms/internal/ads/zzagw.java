package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzagw implements zzcc {
    public static final Parcelable.Creator<zzagw> CREATOR = new zzagv();
    public final int zza;
    public final String zzb;
    public final String zzc;
    public final int zzd;
    public final int zze;
    public final int zzf;
    public final int zzg;
    public final byte[] zzh;

    public zzagw(int i, String str, String str2, int i2, int i3, int i4, int i5, byte[] bArr) {
        this.zza = i;
        this.zzb = str;
        this.zzc = str2;
        this.zzd = i2;
        this.zze = i3;
        this.zzf = i4;
        this.zzg = i5;
        this.zzh = bArr;
    }

    zzagw(Parcel parcel) {
        this.zza = parcel.readInt();
        String readString = parcel.readString();
        int i = zzgd.zza;
        this.zzb = readString;
        this.zzc = parcel.readString();
        this.zzd = parcel.readInt();
        this.zze = parcel.readInt();
        this.zzf = parcel.readInt();
        this.zzg = parcel.readInt();
        this.zzh = parcel.createByteArray();
    }

    public static zzagw zzb(zzfu zzfu) {
        int zzg2 = zzfu.zzg();
        String zze2 = zzcg.zze(zzfu.zzA(zzfu.zzg(), zzfxs.zza));
        String zzA = zzfu.zzA(zzfu.zzg(), zzfxs.zzc);
        int zzg3 = zzfu.zzg();
        int zzg4 = zzfu.zzg();
        int zzg5 = zzfu.zzg();
        int zzg6 = zzfu.zzg();
        int zzg7 = zzfu.zzg();
        byte[] bArr = new byte[zzg7];
        zzfu.zzG(bArr, 0, zzg7);
        return new zzagw(zzg2, zze2, zzA, zzg3, zzg4, zzg5, zzg6, bArr);
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
        zzagw zzagw = (zzagw) obj;
        return this.zza == zzagw.zza && this.zzb.equals(zzagw.zzb) && this.zzc.equals(zzagw.zzc) && this.zzd == zzagw.zzd && this.zze == zzagw.zze && this.zzf == zzagw.zzf && this.zzg == zzagw.zzg && Arrays.equals(this.zzh, zzagw.zzh);
    }

    public final int hashCode() {
        return ((((((((((((((this.zza + 527) * 31) + this.zzb.hashCode()) * 31) + this.zzc.hashCode()) * 31) + this.zzd) * 31) + this.zze) * 31) + this.zzf) * 31) + this.zzg) * 31) + Arrays.hashCode(this.zzh);
    }

    public final String toString() {
        return "Picture: mimeType=" + this.zzb + ", description=" + this.zzc;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.zza);
        parcel.writeString(this.zzb);
        parcel.writeString(this.zzc);
        parcel.writeInt(this.zzd);
        parcel.writeInt(this.zze);
        parcel.writeInt(this.zzf);
        parcel.writeInt(this.zzg);
        parcel.writeByteArray(this.zzh);
    }

    public final void zza(zzby zzby) {
        zzby.zza(this.zzh, this.zza);
    }
}
