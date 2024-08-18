package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.ads.internal.client.zzl;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.2.0 */
public final class zzbyo extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzbyo> CREATOR = new zzbyp();
    public final zzl zza;
    public final String zzb;

    public zzbyo(zzl zzl, String str) {
        this.zza = zzl;
        this.zzb = str;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        zzl zzl = this.zza;
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 2, zzl, i, false);
        SafeParcelWriter.writeString(parcel, 3, this.zzb, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
