package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzcd implements Parcelable {
    public static final Parcelable.Creator<zzcd> CREATOR = new zzcb();
    public final long zza;
    private final zzcc[] zzb;

    public zzcd(long j, zzcc... zzccArr) {
        this.zza = j;
        this.zzb = zzccArr;
    }

    zzcd(Parcel parcel) {
        this.zzb = new zzcc[parcel.readInt()];
        int i = 0;
        while (true) {
            zzcc[] zzccArr = this.zzb;
            if (i < zzccArr.length) {
                zzccArr[i] = (zzcc) parcel.readParcelable(zzcc.class.getClassLoader());
                i++;
            } else {
                this.zza = parcel.readLong();
                return;
            }
        }
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
        zzcd zzcd = (zzcd) obj;
        return Arrays.equals(this.zzb, zzcd.zzb) && this.zza == zzcd.zza;
    }

    public final int hashCode() {
        long j = this.zza;
        return (Arrays.hashCode(this.zzb) * 31) + ((int) (j ^ (j >>> 32)));
    }

    public final String toString() {
        String str;
        long j = this.zza;
        int i = (j > -9223372036854775807L ? 1 : (j == -9223372036854775807L ? 0 : -1));
        String arrays = Arrays.toString(this.zzb);
        if (i == 0) {
            str = "";
        } else {
            str = ", presentationTimeUs=" + j;
        }
        return "entries=" + arrays + str;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.zzb.length);
        for (zzcc writeParcelable : this.zzb) {
            parcel.writeParcelable(writeParcelable, 0);
        }
        parcel.writeLong(this.zza);
    }

    public final int zza() {
        return this.zzb.length;
    }

    public final zzcc zzb(int i) {
        return this.zzb[i];
    }

    public final zzcd zzc(zzcc... zzccArr) {
        int length = zzccArr.length;
        if (length == 0) {
            return this;
        }
        long j = this.zza;
        zzcc[] zzccArr2 = this.zzb;
        int i = zzgd.zza;
        int length2 = zzccArr2.length;
        Object[] copyOf = Arrays.copyOf(zzccArr2, length2 + length);
        System.arraycopy(zzccArr, 0, copyOf, length2, length);
        return new zzcd(j, (zzcc[]) copyOf);
    }

    public final zzcd zzd(zzcd zzcd) {
        return zzcd == null ? this : zzc(zzcd.zzb);
    }

    public zzcd(List list) {
        this(-9223372036854775807L, (zzcc[]) list.toArray(new zzcc[0]));
    }
}
