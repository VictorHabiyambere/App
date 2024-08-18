package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
final class zzaif implements Parcelable.Creator {
    zzaif() {
    }

    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        ArrayList arrayList = new ArrayList();
        parcel.readList(arrayList, zzaii.class.getClassLoader());
        return new zzaij(arrayList);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new zzaij[i];
    }
}
