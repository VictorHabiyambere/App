package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzgn implements zzcc {
    public static final Parcelable.Creator<zzgn> CREATOR = new zzgl();
    public final long zza;
    public final long zzb;
    public final long zzc;

    public zzgn(long j, long j2, long j3) {
        this.zza = j;
        this.zzb = j2;
        this.zzc = j3;
    }

    /* synthetic */ zzgn(Parcel parcel, zzgm zzgm) {
        this.zza = parcel.readLong();
        this.zzb = parcel.readLong();
        this.zzc = parcel.readLong();
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzgn)) {
            return false;
        }
        zzgn zzgn = (zzgn) obj;
        return this.zza == zzgn.zza && this.zzb == zzgn.zzb && this.zzc == zzgn.zzc;
    }

    public final int hashCode() {
        long j = this.zza;
        long j2 = this.zzc;
        long j3 = this.zzb;
        return ((((((int) (j ^ (j >>> 32))) + 527) * 31) + ((int) ((j3 >>> 32) ^ j3))) * 31) + ((int) (j2 ^ (j2 >>> 32)));
    }

    public final String toString() {
        return "Mp4Timestamp: creation time=" + this.zza + ", modification time=" + this.zzb + ", timescale=" + this.zzc;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.zza);
        parcel.writeLong(this.zzb);
        parcel.writeLong(this.zzc);
    }

    public final /* synthetic */ void zza(zzby zzby) {
    }
}
