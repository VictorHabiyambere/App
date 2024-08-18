package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Locale;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzaii implements Parcelable {
    public static final Parcelable.Creator<zzaii> CREATOR = new zzaih();
    public static final Comparator zza = new zzaig();
    public final long zzb;
    public final long zzc;
    public final int zzd;

    public zzaii(long j, long j2, int i) {
        zzeq.zzd(j < j2);
        this.zzb = j;
        this.zzc = j2;
        this.zzd = i;
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            zzaii zzaii = (zzaii) obj;
            return this.zzb == zzaii.zzb && this.zzc == zzaii.zzc && this.zzd == zzaii.zzd;
        }
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Long.valueOf(this.zzb), Long.valueOf(this.zzc), Integer.valueOf(this.zzd)});
    }

    public final String toString() {
        return String.format(Locale.US, "Segment: startTimeMs=%d, endTimeMs=%d, speedDivisor=%d", new Object[]{Long.valueOf(this.zzb), Long.valueOf(this.zzc), Integer.valueOf(this.zzd)});
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.zzb);
        parcel.writeLong(this.zzc);
        parcel.writeInt(this.zzd);
    }
}
