package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
final class zzaih implements Parcelable.Creator {
    zzaih() {
    }

    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new zzaii(parcel.readLong(), parcel.readLong(), parcel.readInt());
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new zzaii[i];
    }
}
