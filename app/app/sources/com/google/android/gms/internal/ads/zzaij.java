package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzaij implements zzcc {
    public static final Parcelable.Creator<zzaij> CREATOR = new zzaif();
    public final List zza;

    public zzaij(List list) {
        this.zza = list;
        boolean z = false;
        if (!list.isEmpty()) {
            long j = ((zzaii) list.get(0)).zzc;
            int i = 1;
            while (true) {
                if (i >= list.size()) {
                    break;
                } else if (((zzaii) list.get(i)).zzb < j) {
                    z = true;
                    break;
                } else {
                    j = ((zzaii) list.get(i)).zzc;
                    i++;
                }
            }
        }
        zzeq.zzd(!z);
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
        return this.zza.equals(((zzaij) obj).zza);
    }

    public final int hashCode() {
        return this.zza.hashCode();
    }

    public final String toString() {
        return "SlowMotion: segments=".concat(this.zza.toString());
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeList(this.zza);
    }

    public final /* synthetic */ void zza(zzby zzby) {
    }
}
